package com.edts.tdlib.service;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.edts.tdlib.TdApi;
import com.edts.tdlib.bean.contact.EditTelegramUserBean;
import com.edts.tdlib.bean.contact.TelegramUserAuthorizationBean;
import com.edts.tdlib.bean.contact.TelegramUserBean;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.engine.GlobalVariable;
import com.edts.tdlib.engine.handler.UpdatesHandler;
import com.edts.tdlib.engine.handler.UserContactHandler;
import com.edts.tdlib.exception.HandledException;
import com.edts.tdlib.helper.CoreHelper;
import com.edts.tdlib.helper.TelegramUserExcelHelper;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.mapper.ContactMapper;
import com.edts.tdlib.model.contact.MemberTelegramUserGroup;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.model.contact.TelegramUserGroup;
import com.edts.tdlib.repository.MemberTelegramUserGroupRepo;
import com.edts.tdlib.repository.TelegramUserRepo;
import com.edts.tdlib.util.GeneralUtil;
import com.edts.tdlib.util.SecurityUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TelegramUserService {


    private final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TelegramUserRepo telegramUserRepo;
    private final CommonMapper commonMapper;
    private final ContactMapper contactMapper;
    private final TelegramUserGroupService telegramUserGroupService;
    private final MemberTelegramUserGroupRepo memberTelegramUserGroupRepo;

    public TelegramUserService(TelegramUserRepo telegramUserRepo, CommonMapper commonMapper, ContactMapper contactMapper,
                               TelegramUserGroupService telegramUserGroupService, MemberTelegramUserGroupRepo memberTelegramUserGroupRepo) {
        this.telegramUserRepo = telegramUserRepo;
        this.commonMapper = commonMapper;
        this.contactMapper = contactMapper;
        this.telegramUserGroupService = telegramUserGroupService;
        this.memberTelegramUserGroupRepo = memberTelegramUserGroupRepo;
    }

    public void addTelegramUser(TelegramUserAuthorizationBean telegramUserBean) throws InterruptedException {
        String phoneNumber = telegramUserBean.getPhoneNumber() == null ? "" : telegramUserBean.getPhoneNumber();
        String fisrtName = telegramUserBean.getFirstName() == null ? "" : telegramUserBean.getFirstName();
        String lastName = telegramUserBean.getFirstName() == null ? "" : telegramUserBean.getLastName();

        TdApi.Contact contact = new TdApi.Contact(phoneNumber, fisrtName, lastName, "", 0);
        TdApi.Contact[] contacts = {contact};

        CoreHelper.userBy.clear();
        CoreHelper.userBy.put(1, SecurityUtil.getEmail().get());

        CoreHelper.userGroup.clear();
        telegramUserBean.getTelegramUserGroupsBean().parallelStream().forEach(ug -> {
            CoreHelper.userGroup.put(ug.getId(), ug);
        });

        GlobalVariable.mainTelegram.client.send(new TdApi.ImportContacts(contacts), GlobalVariable.mainTelegram.userContactHandler);

        //Thread.sleep(5000);
        //TelegramUser telegramUser = telegramUserRepo.findByPhoneNumber(phoneNumber).orElseThrow(() -> new HandledException("This User is not Registered on Telegram, or the Contact Privacy Setting is not set to Everybody"));

    }


    public Map<String, Object> processDataUpload(MultipartFile file) throws IOException {
        return TelegramUserExcelHelper.excelToObject(file.getInputStream());
    }

    public void addBulkTelegramUser(List<TelegramUserBean> telegramUserBeans) {
        List<TelegramUser> telegramUserList = commonMapper.mapList(telegramUserBeans, TelegramUser.class);
        telegramUserRepo.saveAll(telegramUserList);

        CoreHelper.userBy.clear();
        CoreHelper.userBy.put(1, SecurityUtil.getEmail().get());
        /*if (telegramUserList != null && telegramUserList.size() > 0) {
            logger.info("::: START Import Contact :::");
            AtomicInteger atomicInteger = new AtomicInteger(0);
            //TdApi.Contact[] contacts = new TdApi.Contact[telegramUserList.size()];
            telegramUserList.forEach(ut -> {
                TdApi.Contact contact = new TdApi.Contact(ut.getPhoneNumber() == null ? "" : ut.getPhoneNumber(),
                        ut.getFirstName() == null ? "" : ut.getFirstName(),
                        ut.getFirstName() == null ? "" : ut.getLastName(),
                        "",
                        0);
                TdApi.Contact[] contacts = {contact};
                //contacts[atomicInteger.getAndIncrement()] = contact;

                logger.info("phone ::: " + ut.getFirstName());
                //GlobalVariable.mainTelegram.client.send(new TdApi.ImportContacts(contacts), GlobalVariable.mainTelegram.userContactHandler);

            });

            //GlobalVariable.mainTelegram.client.send(new TdApi.ImportContacts(contacts), GlobalVariable.mainTelegram.userContactHandler);

        }*/

    }

    public void addBulkTelegramUserByFile(MultipartFile file) throws IOException {
        Map<String, Object> objectMap = TelegramUserExcelHelper.excelToObject(file.getInputStream());
        List<TelegramUserBean> telegramUserBeans = (List<TelegramUserBean>) objectMap.get("confirmData");
        addBulkTelegramUser(telegramUserBeans);
    }


    public Page<TelegramUserBean> getTelegramUsers(String name, String type, Pageable pageable) {

        String typeParam = type == null ? GeneralConstant.USER_TYPE_REGULAR : type;

        Page<TelegramUser> telegramUserPage;
        if (name == null || name.isEmpty() || name.equalsIgnoreCase("")) {
            telegramUserPage = telegramUserRepo.findAll(typeParam, pageable);
        } else {
            telegramUserPage = telegramUserRepo.findAllByFirstNameOrLastName(name, typeParam, pageable);
        }

        Page<TelegramUserBean> telegramUserBeans = commonMapper.mapEntityPageIntoDtoPage(telegramUserPage, TelegramUserBean.class);
        return telegramUserBeans;
    }


    public TelegramUserAuthorizationBean findById(long id) throws ParseException {
        Optional<TelegramUser> optionalTelegramUser = Optional.ofNullable(telegramUserRepo.findById(id).orElseThrow(EntityNotFoundException::new));

        List<MemberTelegramUserGroup> memberTelegramUserGroups = memberTelegramUserGroupRepo.findAllByTelegramUser(optionalTelegramUser.get());
        List<TelegramUserGroup> telegramUserGroups = new ArrayList<>();
        if (memberTelegramUserGroups != null && memberTelegramUserGroups.size() > 0) {
            memberTelegramUserGroups.parallelStream().forEach(mt -> {
                TelegramUserGroup telegramUserGroup = mt.getUserGroup();
                telegramUserGroups.add(telegramUserGroup);
            });
        }

        TelegramUserBean telegramUserBean = contactMapper.toTelegramUserBean(optionalTelegramUser.get());
        TelegramUserAuthorizationBean telegramUserAuthorizationBean = contactMapper.toTelegramUserAuthorizationBean(telegramUserBean, telegramUserGroups);
        telegramUserAuthorizationBean.setCreatedBy(optionalTelegramUser.get().getCreatedBy());
        telegramUserAuthorizationBean.setModifiedBy(optionalTelegramUser.get().getModifiedBy());
        telegramUserAuthorizationBean.setCreatedDate(optionalTelegramUser.get().getCreatedDate());
        telegramUserAuthorizationBean.setModifiedDate(optionalTelegramUser.get().getModifiedDate());
        return telegramUserAuthorizationBean;
    }

    /**
     * Edit telegram in db apps
     * add or edit in member telegram user group app
     * edit to telegram profile
     */
    public void editTelegramUser(long id, EditTelegramUserBean editTelegramUserBean) {
        Optional<TelegramUser> optionalTelegramUser = Optional.ofNullable(telegramUserRepo.findById(id).orElseThrow(EntityNotFoundException::new));
        TelegramUser telegramUser = optionalTelegramUser.get();
        telegramUser.setFirstName(editTelegramUserBean.getFirstName());
        telegramUser.setLastName(editTelegramUserBean.getLastName());
        telegramUser.setModifiedBy(SecurityUtil.getEmail().get());
        telegramUserRepo.save(telegramUser);

        telegramUserGroupService.addEditMemberFromAddUser(telegramUser, editTelegramUserBean.getTelegramUserGroupsBean(), editTelegramUserBean.getRemoveUserGroupBeans());

        TdApi.Contact contact = new TdApi.Contact();
        contact.phoneNumber = telegramUser.getPhoneNumber();
        contact.firstName = telegramUser.getFirstName();
        contact.lastName = telegramUser.getLastName();
        contact.vcard = "";
        contact.userId = telegramUser.getUserTelegramId();
        GlobalVariable.mainTelegram.client.send(new TdApi.AddContact(contact, false), new UserContactHandler());
    }


    public void delete(long id) {
        Optional<TelegramUser> telegramUser = Optional.ofNullable(telegramUserRepo.findById(id).orElseThrow(EntityNotFoundException::new));
        TelegramUser user = telegramUser.get();
        user.setDeleted(true);
        telegramUserRepo.save(user);
    }

    public void syncUser() {
        List<TelegramUser> telegramUsers = (List<TelegramUser>) telegramUserRepo.findAll();
        if (telegramUsers != null && telegramUsers.size() > 0) {
            telegramUsers.stream().forEach(tu -> {
                GlobalVariable.mainTelegram.client.send(new TdApi.CreatePrivateChat(tu.getUserTelegramId(), true), new UpdatesHandler());
            });
        }
    }


    public ByteArrayInputStream downloadTelegramUser(String name, String type, Pageable pageable) {
        List<TelegramUser> telegramUserList = new ArrayList<>();

        String typeParam = type == null ? GeneralConstant.USER_TYPE_REGULAR : type;

        Page<TelegramUser> telegramUserPage;
        if (name == null || name.isEmpty() || name.equalsIgnoreCase("")) {
            telegramUserPage = telegramUserRepo.findAll(typeParam, pageable);
        } else {
            telegramUserPage = telegramUserRepo.findAllByFirstNameOrLastName(name, typeParam, pageable);
        }

        telegramUserList = telegramUserPage.getContent();

        ByteArrayInputStream in = TelegramUserExcelHelper.telegramUsersToExcel(telegramUserList);
        return in;
    }

}
