package com.edts.tdlib.service;

import com.edts.tdlib.bean.contact.*;
import com.edts.tdlib.exception.HandledException;
import com.edts.tdlib.helper.ChatRoomGroupExcelHelper;
import com.edts.tdlib.helper.TelegramUserGroupExcelHelper;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.mapper.ContactMapper;
import com.edts.tdlib.model.contact.ChatRoomGroup;
import com.edts.tdlib.model.contact.MemberTelegramUserGroup;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.model.contact.TelegramUserGroup;
import com.edts.tdlib.repository.MemberTelegramUserGroupRepo;
import com.edts.tdlib.repository.TelegramUserGroupRepo;
import com.edts.tdlib.repository.TelegramUserRepo;
import org.apache.commons.lang3.ArrayUtils;
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
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TelegramUserGroupService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TelegramUserGroupRepo telegramUserGroupRepo;
    private final TelegramUserRepo telegramUserRepo;
    private final CommonMapper commonMapper;
    private final ContactMapper contactMapper;
    private final MemberTelegramUserGroupRepo memberTelegramUserGroupRepo;
    private final TelegramUserGroupExcelHelper telegramUserGroupExcelHelper;

    public TelegramUserGroupService(TelegramUserGroupRepo telegramUserGroupRepo, TelegramUserRepo telegramUserRepo,
                                    CommonMapper commonMapper, ContactMapper contactMapper, MemberTelegramUserGroupRepo memberTelegramUserGroupRepo,
                                    TelegramUserGroupExcelHelper telegramUserGroupExcelHelper) {
        this.telegramUserGroupRepo = telegramUserGroupRepo;
        this.telegramUserRepo = telegramUserRepo;
        this.commonMapper = commonMapper;
        this.contactMapper = contactMapper;
        this.memberTelegramUserGroupRepo = memberTelegramUserGroupRepo;
        this.telegramUserGroupExcelHelper = telegramUserGroupExcelHelper;
    }

    @Transactional
    public void save(HDTelegramUserGroupBean telegramUserGroupBean) {
        TelegramUserGroup telegramUserGroup;

        if (telegramUserGroupBean.getId() > 0) {
            telegramUserGroup = telegramUserGroupRepo.findById(telegramUserGroupBean.getId()).orElseThrow();
            telegramUserGroup.setCountMember(telegramUserGroupBean.getMemberGroupBeanList().size() + telegramUserGroup.getCountMember());
        } else {
            telegramUserGroup = new TelegramUserGroup();
            telegramUserGroup.setCountMember(telegramUserGroupBean.getMemberGroupBeanList().size());
        }

        telegramUserGroup.setEnable(telegramUserGroupBean.isEnable());
        telegramUserGroup.setName(telegramUserGroupBean.getGroupName());
        telegramUserGroup.setPathImage(telegramUserGroupBean.getFilePath());
        List<MemberTelegramUserGroup> memberTelegramUserGroupList = new ArrayList<>();
        telegramUserGroupBean.getMemberGroupBeanList().stream().forEach(l -> {
            MemberTelegramUserGroup memberTelegramUsergroup = new MemberTelegramUserGroup();
            memberTelegramUsergroup.setEnable(l.isEnable());
            memberTelegramUsergroup.setUserGroup(telegramUserGroup);
            TelegramUser telegramUser = telegramUserRepo.findById(l.getTelegramUserBean().getId()).orElseThrow(() -> new HandledException("Telegram user not found"));

            telegramUser.setGroupJoined(telegramUser.getGroupJoined() + 1);
            telegramUserRepo.save(telegramUser);

            memberTelegramUsergroup.setTelegramUser(telegramUser);
            memberTelegramUserGroupList.add(memberTelegramUsergroup);
        });
        telegramUserGroup.setTeleUserGroupList(memberTelegramUserGroupList);

        telegramUserGroupRepo.save(telegramUserGroup);
    }

    @Transactional
    public void edit(HDTelegramUserGroupBean telegramUserGroupBean) {
        TelegramUserGroup telegramUserGroup;

        telegramUserGroup = telegramUserGroupRepo.findById(telegramUserGroupBean.getId()).orElseThrow();
        telegramUserGroup.setEnable(telegramUserGroupBean.isEnable());
        telegramUserGroup.setName(telegramUserGroupBean.getGroupName());
        telegramUserGroup.setPathImage(telegramUserGroupBean.getFilePath());

        /**Delete member user group*/
        if (telegramUserGroupBean.getRemoveUser().length > 0) {
            Long[] deleteMember = ArrayUtils.toObject(telegramUserGroupBean.getRemoveUser());
            List<Long> deleteMemberAsList = Arrays.asList(deleteMember);
            List<MemberTelegramUserGroup> memberTelegramUserGroupsDelete = new ArrayList<>();
            deleteMemberAsList.parallelStream().forEach(dm -> {
                Optional<MemberTelegramUserGroup> optionalMemberTelegramUserGroup = memberTelegramUserGroupRepo.findByIdUserGroupAndIdUser(telegramUserGroup.getId(), dm);
                if (!optionalMemberTelegramUserGroup.isEmpty()) {
                    memberTelegramUserGroupsDelete.add(optionalMemberTelegramUserGroup.get());
                    TelegramUser telegramUser = optionalMemberTelegramUserGroup.get().getTelegramUser();
                    telegramUser.setGroupJoined(telegramUser.getGroupJoined() - 1);
                    telegramUserRepo.save(telegramUser);
                }
            });
            memberTelegramUserGroupRepo.deleteAll(memberTelegramUserGroupsDelete);
            telegramUserGroup.setCountMember(telegramUserGroup.getCountMember() - memberTelegramUserGroupsDelete.size());
            telegramUserGroupRepo.save(telegramUserGroup);
        }

        if (telegramUserGroupBean.getMemberGroupBeanList() != null && telegramUserGroupBean.getMemberGroupBeanList().size() > 0) {
            List<MemberTelegramUserGroup> memberTelegramUserGroupList = new ArrayList<>();
            telegramUserGroupBean.getMemberGroupBeanList().stream().forEach(l -> {
                Optional<MemberTelegramUserGroup> optionalMemberTelegramUserGroup = memberTelegramUserGroupRepo.findByIdUserGroupAndIdUser(telegramUserGroup.getId(), l.getTelegramUserBean().getId());
                if (optionalMemberTelegramUserGroup.isEmpty()) {
                    MemberTelegramUserGroup memberTelegramUsergroup = new MemberTelegramUserGroup();
                    memberTelegramUsergroup.setEnable(l.isEnable());
                    memberTelegramUsergroup.setUserGroup(telegramUserGroup);
                    TelegramUser telegramUser = telegramUserRepo.findById(l.getTelegramUserBean().getId()).orElseThrow(() -> new HandledException("Telegram user not found"));
                    telegramUser.setGroupJoined(telegramUser.getGroupJoined() + 1);
                    telegramUserRepo.save(telegramUser);
                    memberTelegramUsergroup.setTelegramUser(telegramUser);
                    memberTelegramUserGroupList.add(memberTelegramUsergroup);
                }
            });
            telegramUserGroup.setTeleUserGroupList(memberTelegramUserGroupList);
            telegramUserGroup.setCountMember(telegramUserGroup.getCountMember() + memberTelegramUserGroupList.size());
            telegramUserGroupRepo.save(telegramUserGroup);
        }


    }


    public Page<TelegramUserGroupBean> getTelegramUSerGroup(String name, Pageable pageable) {
        Page<TelegramUserGroup> telegramUserGroupPage;
        if (name == null) {
            telegramUserGroupPage = telegramUserGroupRepo.findAll(pageable);
        } else {
            telegramUserGroupPage = telegramUserGroupRepo.findAllByName(name, pageable);
        }

        Page<TelegramUserGroupBean> telegramUserBeans = commonMapper.mapEntityPageIntoDtoPage(telegramUserGroupPage, TelegramUserGroupBean.class);
        return telegramUserBeans;
    }

    public ViewUserGroupBean findById(long id) {
        Optional<TelegramUserGroup> optionalTelegramUserGroup = Optional.ofNullable(telegramUserGroupRepo.findById(id).orElseThrow(EntityNotFoundException::new));
        return contactMapper.toViewUserGroupBean(optionalTelegramUserGroup.get());
    }


    public void addMemberUserGroup(AddMemberUserGroupBean addMemberUserGroupBean) {
        TelegramUserGroup telegramUserGroup = telegramUserGroupRepo.findById(addMemberUserGroupBean.getId()).orElseThrow(EntityNotFoundException::new);
        List<MemberTelegramUserGroup> memberTelegramUserGroups = new ArrayList<>();
        Long[] inputUser = ArrayUtils.toObject(addMemberUserGroupBean.getIdUsers());
        List<Long> inputAsList = Arrays.asList(inputUser);
        inputAsList.parallelStream().forEach(u -> {
            TelegramUser telegramUser = telegramUserRepo.findById(u).orElseThrow();
            MemberTelegramUserGroup memberTelegramUserGroup = new MemberTelegramUserGroup();
            memberTelegramUserGroup.setTelegramUser(telegramUser);
            memberTelegramUserGroup.setUserGroup(telegramUserGroup);
            memberTelegramUserGroup.setEnable(true);
            memberTelegramUserGroups.add(memberTelegramUserGroup);
        });

        memberTelegramUserGroupRepo.saveAll(memberTelegramUserGroups);
        telegramUserGroup.setCountMember(telegramUserGroup.getCountMember() + memberTelegramUserGroups.size());
        telegramUserGroupRepo.save(telegramUserGroup);
    }


    /**
     * when telegram user add or edit
     * set user group
     */
    public void addEditMemberFromAddUser(TelegramUser telegramUser, List<TelegramUserGroupBean> telegramUserGroupBeans, List<TelegramUserGroupBean> removeFromGroups) {

        if (removeFromGroups != null && removeFromGroups.size() > 0) {
            AtomicInteger countJoinDe = new AtomicInteger();
            removeFromGroups.parallelStream().forEach(rg -> {
                countJoinDe.getAndIncrement();
                TelegramUserGroup telegramUserGroup = telegramUserGroupRepo.findById(rg.getId()).orElseThrow();
                Optional<MemberTelegramUserGroup> memberTelegramUserGroupExist = memberTelegramUserGroupRepo.findByIdUserGroupAndIdUser(telegramUserGroup.getId(), telegramUser.getId());
                memberTelegramUserGroupExist.ifPresent(de -> {
                    memberTelegramUserGroupRepo.delete(de);

                    telegramUserGroup.setCountMember(telegramUserGroup.getCountMember() - 1);
                    telegramUserGroupRepo.save(telegramUserGroup);


                });
            });
            telegramUser.setGroupJoined(telegramUser.getGroupJoined() - countJoinDe.get());
            telegramUserRepo.save(telegramUser);
        }

        if (telegramUserGroupBeans != null && telegramUserGroupBeans.size() > 0) {
            AtomicInteger countJoin = new AtomicInteger();
            telegramUserGroupBeans.parallelStream().forEach(ug -> {
                TelegramUserGroup telegramUserGroup = telegramUserGroupRepo.findById(ug.getId()).orElseThrow();

                Optional<MemberTelegramUserGroup> memberTelegramUserGroupExist = memberTelegramUserGroupRepo.findByIdUserGroupAndIdUser(telegramUserGroup.getId(), telegramUser.getId());
                if (memberTelegramUserGroupExist.isEmpty()) {
                    countJoin.getAndIncrement();
                    List<MemberTelegramUserGroup> memberTelegramUserGroups = new ArrayList<>();
                    MemberTelegramUserGroup memberTelegramUserGroup = new MemberTelegramUserGroup();
                    memberTelegramUserGroup.setEnable(true);
                    memberTelegramUserGroup.setUserGroup(telegramUserGroup);
                    memberTelegramUserGroup.setTelegramUser(telegramUser);
                    memberTelegramUserGroups.add(memberTelegramUserGroup);

                    telegramUserGroup.setTeleUserGroupList(memberTelegramUserGroups);

                    telegramUserGroup.setCountMember(telegramUserGroup.getCountMember() + 1);
                    telegramUserGroupRepo.save(telegramUserGroup);


                }
            });

            telegramUser.setGroupJoined(telegramUser.getGroupJoined() + countJoin.get());
            telegramUserRepo.save(telegramUser);
        }

    }

    public Map<String, Object> processDataUpload(MultipartFile file) throws IOException {
        return telegramUserGroupExcelHelper.excelToObject(file.getInputStream());
    }

    public void createUserGroupBulk(MultipartFile file, String name) throws IOException {
        List<MemberTelegramUserGroup> memberTelegramUserGroups = telegramUserGroupExcelHelper.excelToObjectForSave(file.getInputStream());

        TelegramUserGroup telegramUserGroup = new TelegramUserGroup();
        telegramUserGroup.setCountMember(memberTelegramUserGroups.size());
        telegramUserGroup.setName(name);
        memberTelegramUserGroups.parallelStream().forEach(m -> {
            m.setUserGroup(telegramUserGroup);
        });
        telegramUserGroup.setTeleUserGroupList(memberTelegramUserGroups);

        telegramUserGroupRepo.save(telegramUserGroup);
    }

    public void delete(long id) {
        TelegramUserGroup telegramUserGroup = telegramUserGroupRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        telegramUserGroup.setDeleted(true);
        telegramUserGroupRepo.save(telegramUserGroup);
    }

    public InputStream download(String name, Pageable pageable) {
        List<TelegramUserGroup> telegramUserGroupList = new ArrayList<>();


        Page<TelegramUserGroup> telegramUserGroupPage;
        if (name == null) {
            telegramUserGroupPage = telegramUserGroupRepo.findAll(pageable);
        } else {
            telegramUserGroupPage = telegramUserGroupRepo.findAllByName(name, pageable);
        }


        telegramUserGroupList = telegramUserGroupPage.getContent();

        ByteArrayInputStream in = TelegramUserGroupExcelHelper.telegramUserGroupToExcel(telegramUserGroupList);
        return in;
    }
}
