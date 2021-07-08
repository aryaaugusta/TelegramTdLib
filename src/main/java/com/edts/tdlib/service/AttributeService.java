package com.edts.tdlib.service;

import com.edts.tdlib.bean.contact.AddUpdateAttributeBean;
import com.edts.tdlib.bean.contact.AttributeBean;
import com.edts.tdlib.bean.contact.ViewAttributeBean;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.exception.HandledException;
import com.edts.tdlib.helper.AttributeMemberExelHelper;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.mapper.ContactMapper;
import com.edts.tdlib.model.contact.Attribute;
import com.edts.tdlib.model.contact.MemberAttribute;
import com.edts.tdlib.repository.AttributeRepo;
import com.edts.tdlib.repository.ChatRoomRepo;
import com.edts.tdlib.repository.MemberAttributeRepo;
import com.edts.tdlib.repository.TelegramUserRepo;
import com.edts.tdlib.util.GeneralUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AttributeService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final AttributeRepo attributeRepo;
    private final ContactMapper contactMapper;
    private final CommonMapper commonMapper;
    private final MemberAttributeRepo memberAttributeRepo;
    private final AttributeMemberExelHelper attributeMemberExelHelper;
    private final TelegramUserRepo telegramUserRepo;
    private final ChatRoomRepo chatRoomRepo;


    public AttributeService(AttributeRepo attributeRepo, ContactMapper contactMapper, CommonMapper commonMapper, MemberAttributeRepo memberAttributeRepo,
                            AttributeMemberExelHelper attributeMemberExelHelper, TelegramUserRepo telegramUserRepo, ChatRoomRepo chatRoomRepo) {
        this.attributeRepo = attributeRepo;
        this.contactMapper = contactMapper;
        this.commonMapper = commonMapper;
        this.memberAttributeRepo = memberAttributeRepo;
        this.attributeMemberExelHelper = attributeMemberExelHelper;
        this.telegramUserRepo = telegramUserRepo;
        this.chatRoomRepo = chatRoomRepo;
    }


    public void add(AddUpdateAttributeBean addUpdateAttributeBean) {

        attributeRepo.findByNameAndDeletedEquals(addUpdateAttributeBean.getName(), false).ifPresent(a -> {throw  new HandledException("Data duplikat");
        });

        Attribute attribute = contactMapper.toAttribute(addUpdateAttributeBean);

        attribute.getMemberAttributeList().stream().forEach(m -> {
            m.setId(0);
            if (m.getContactType().equals(GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER)) {
                telegramUserRepo.findById(m.getIdRefContact()).orElseThrow(EntityNotFoundException::new);
            } else {
                chatRoomRepo.findById(m.getIdRefContact()).orElseThrow(EntityNotFoundException::new);
            }

            m.setAttribute(attribute);
        });

        attributeRepo.save(attribute);
    }


    public Page<AttributeBean> list(String name, String dataType, Pageable pageable) {
        Page<Attribute> attributePage = null;
        if (name == null && dataType == null) {
            attributePage = attributeRepo.findByDeletedEquals(false, pageable);
        } else if (name != null && dataType == null) {
            attributePage = attributeRepo.findByNameAndDeletedEquals(name, pageable);
        } else if (name == null && dataType != null) {
            attributePage = attributeRepo.findByDataTypeAndDeletedEquals(dataType, false, pageable);
        } else {
            attributePage = attributeRepo.findByNameAndDataTypeAndDeletedEquals(name, dataType, pageable);
        }

        Page<AttributeBean> attributeBeanPage = commonMapper.mapEntityPageIntoDtoPage(attributePage, AttributeBean.class);
        return attributeBeanPage;
    }


    public ViewAttributeBean findById(long id) {
        Attribute attribute = attributeRepo.findById(id).orElseThrow(EntityNotFoundException::new);

        return contactMapper.toViewAttributeBeaan(attribute);
    }

    public void delete(long id) {
        Attribute attribute = attributeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        attribute.setDeleted(true);
        attributeRepo.save(attribute);
    }

    public void edit(AddUpdateAttributeBean addUpdateAttributeBean) {
        Attribute attribute = attributeRepo.findById(addUpdateAttributeBean.getId()).orElseThrow(EntityNotFoundException::new);
        attribute.setName(addUpdateAttributeBean.getName());

        if (addUpdateAttributeBean.getRemoveMember().length > 0) {
            Long[] deleteMember = ArrayUtils.toObject(addUpdateAttributeBean.getRemoveMember());
            List<Long> deleteMemberAsList = Arrays.asList(deleteMember);
            List<MemberAttribute> deleteMemberAttributes = new ArrayList<>();
            Attribute finalAttribute = attribute;
            deleteMemberAsList.parallelStream().forEach(ma -> {
                MemberAttribute memberAttribute = memberAttributeRepo.findById(ma).orElseThrow(EntityNotFoundException::new);

                deleteMemberAttributes.add(memberAttribute);
            });

            memberAttributeRepo.deleteAll(deleteMemberAttributes);
            attribute.setUserCount(attribute.getUserCount() - deleteMemberAttributes.size());
            attributeRepo.save(attribute);
        }


        if (addUpdateAttributeBean.getMemberAttributeBeans() != null && addUpdateAttributeBean.getMemberAttributeBeans().size() > 0) {
            List<MemberAttribute> addMemberAttributes = new ArrayList<>();
            AtomicInteger addMember = new AtomicInteger();
            addUpdateAttributeBean.getMemberAttributeBeans().stream().forEach(l -> {
                Optional<MemberAttribute> optionalMemberAttribute = memberAttributeRepo.findByIdRefContactAndAttributeAndContactTypeEquals(l.getIdRefContact(), attribute, l.getContactType().toUpperCase(Locale.ROOT));
                optionalMemberAttribute.ifPresentOrElse(max -> {
                    max.setAttributeValue(l.getAttributeValue());
                    memberAttributeRepo.save(max);

                }, () -> {
                    if (l.getContactType().equals(GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER)) {
                        telegramUserRepo.findById(l.getIdRefContact()).orElseThrow(EntityNotFoundException::new);
                    } else {
                        chatRoomRepo.findById(l.getIdRefContact()).orElseThrow(EntityNotFoundException::new);
                    }
                    MemberAttribute memberAttribute = new MemberAttribute();
                    memberAttribute.setAttribute(attribute);
                    memberAttribute.setAttributeValue(l.getAttributeValue());
                    memberAttribute.setIdRefContact(l.getIdRefContact());
                    memberAttribute.setContactType(l.getContactType());
                    addMemberAttributes.add(memberAttribute);
                    addMember.getAndIncrement();
                });

            });
            attribute.setMemberAttributeList(addMemberAttributes);
            attribute.setUserCount(attribute.getUserCount() + addMember.get());
            attributeRepo.save(attribute);
        }


    }

    public Map<String, Object> processDataUpload(MultipartFile file, String dataType) throws IOException {
        return attributeMemberExelHelper.excelToObject(file.getInputStream(), dataType);
    }


    public void addBulk(MultipartFile file, AttributeBean attributeBean) throws IOException {


        Attribute attribute = new Attribute();
        List<MemberAttribute> memberAttributes = attributeMemberExelHelper.excelToObjectForSave(file.getInputStream(), attributeBean.getDataType());
        memberAttributes.stream().forEach(a -> {
            a.setAttribute(attribute);
        });

        attribute.setName(attributeBean.getName());
        attribute.setDataType(attributeBean.getDataType().toUpperCase(Locale.ROOT));
        attribute.setUserCount(memberAttributes.size());


        attribute.setMemberAttributeList(memberAttributes);
        attributeRepo.save(attribute);

    }
}
