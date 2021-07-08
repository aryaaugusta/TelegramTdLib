package com.edts.tdlib.service;

import com.edts.tdlib.bean.contact.AttributeBean;
import com.edts.tdlib.bean.message.*;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.exception.HandledException;
import com.edts.tdlib.mapper.*;
import com.edts.tdlib.model.contact.*;
import com.edts.tdlib.model.message.*;
import com.edts.tdlib.repository.*;
import com.edts.tdlib.util.GeneralUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.time.Period;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

@Service
public class MessageTaskService {

    private static final ConcurrentMap<String, Long> recAttributeMember = new ConcurrentHashMap<String, Long>();

    private final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MessageTypeRepo messageTypeRepo;
    private final MessageTaskRepo messageTaskRepo;
    private final MessageTaskMapper messageTaskMapper;
    private final MessageService messageService;
    private final TelegramUserRepo telegramUserRepo;
    private final TelegramUserGroupRepo telegramUserGroupRepo;
    private final ChatRoomRepo chatRoomRepo;
    private final MessageTaskScheduleRepo messageTaskScheduleRepo;
    private final CommonMapper commonMapper;
    private final MessageFileMapper messageFileMapper;
    private final MessageReceiverRepo messageReceiverRepo;
    private final MessageFileRepo messageFileRepo;
    private final MessageReportService messageReportService;
    private final MessageTypeMapper messageTypeMapper;
    private final MessageReportRepo messageReportRepo;
    private final ChatRoomGroupRepo chatRoomGroupRepo;
    private final AttributeRepo attributeRepo;
    private final ContactMapper contactMapper;
    private final MessageAttributesRepo messageAttributesRepo;
    private final AttributeTaskScheduleRepo attributeTaskScheduleRepo;
    private final MemberTelegramUserGroupRepo memberTelegramUserGroupRepo;
    private final ChatRoomGroupMemberRepo chatRoomGroupMemberRepo;

    public MessageTaskService(MessageTypeRepo messageTypeRepo, MessageTaskRepo messageTaskRepo, MessageTaskMapper messageTaskMapper, MessageService messageService,
                              TelegramUserRepo telegramUserRepo, TelegramUserGroupRepo telegramUserGroupRepo, ChatRoomRepo chatRoomRepo,
                              MessageTaskScheduleRepo messageTaskScheduleRepo, CommonMapper commonMapper, MessageFileMapper messageFileMapper,
                              MessageReceiverRepo messageReceiverRepo, MessageFileRepo messageFileRepo, MessageReportService messageReportService,
                              MessageTypeMapper messageTypeMapper, MessageReportRepo messageReportRepo, ChatRoomGroupRepo chatRoomGroupRepo, AttributeRepo attributeRepo, ContactMapper contactMapper,
                              MessageAttributesRepo messageAttributesRepo, AttributeTaskScheduleRepo attributeTaskScheduleRepo, MemberTelegramUserGroupRepo memberTelegramUserGroupRepo,
                              ChatRoomGroupMemberRepo chatRoomGroupMemberRepo) {
        this.messageTypeRepo = messageTypeRepo;
        this.messageTaskRepo = messageTaskRepo;
        this.messageTaskMapper = messageTaskMapper;
        this.messageService = messageService;
        this.telegramUserRepo = telegramUserRepo;
        this.telegramUserGroupRepo = telegramUserGroupRepo;
        this.chatRoomRepo = chatRoomRepo;
        this.messageTaskScheduleRepo = messageTaskScheduleRepo;
        this.commonMapper = commonMapper;
        this.messageFileMapper = messageFileMapper;
        this.messageReceiverRepo = messageReceiverRepo;
        this.messageFileRepo = messageFileRepo;
        this.messageReportService = messageReportService;
        this.messageTypeMapper = messageTypeMapper;
        this.messageReportRepo = messageReportRepo;
        this.chatRoomGroupRepo = chatRoomGroupRepo;
        this.attributeRepo = attributeRepo;
        this.contactMapper = contactMapper;
        this.messageAttributesRepo = messageAttributesRepo;
        this.attributeTaskScheduleRepo = attributeTaskScheduleRepo;
        this.memberTelegramUserGroupRepo = memberTelegramUserGroupRepo;
        this.chatRoomGroupMemberRepo = chatRoomGroupMemberRepo;
    }

    /**
     * send message immediate, recurring, once-off
     * check message type
     * get receivers
     * process send message
     */
    public void addMessageTask(AddMessageBean addMessageBean) throws ParseException {
        logger.info("getOnceOffDate ::: " + addMessageBean.getOnceOffDate());
        logger.info("getOnceOffTime ::: " + addMessageBean.getOnceOffTime());

        String daysValue[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        AtomicReference<String> messageTypeCode = new AtomicReference<>();
        messageTypeRepo.findById(addMessageBean.getMessageTypeBean().getId()).ifPresentOrElse(mt -> {
            messageTypeCode.set(mt.getCode());
            if (!messageTypeCode.get().equals(addMessageBean.getMessageTypeBean().getCode())) {
                throw new HandledException("Message type tidak sama");
            }
        }, () -> {
            throw new HandledException("Message type tidak ditemukan");
        });


        MessageTask messageTask = messageTaskMapper.toMessageTask(addMessageBean);
        List<MessageReceiver> messageReceivers = getMessageReceiver(addMessageBean, messageTask);
        messageTask.setReceiverList(messageReceivers);


        /** Message Attributes */
        List<Attribute> attributes = extractionMessageAttribute(addMessageBean.getContent());
        List<MessageAttributes> messageAttributes = new ArrayList<>();

        if (attributes != null && attributes.size() > 0) {
            attributes.stream().forEach(a -> {
                MessageAttributes msgAttr = new MessageAttributes();
                msgAttr.setMessageTaskAttr(messageTask);
                msgAttr.setAttribute(a);
                msgAttr.setType(GeneralConstant.MESSAGE_ATTRIBUTE_TYPE);
                msgAttr.setKeyAttribute("#" + a.getName() + "#");
                messageAttributes.add(msgAttr);

            });

        }


        if (addMessageBean.getMessageTypeBean().getCode().equals(GeneralConstant.RECURRING_CODE) && addMessageBean.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_ATTRIBUTE)) {
            Attribute attribute = attributeRepo.findById(Long.parseLong(addMessageBean.getRecurringExecute())).orElseThrow(EntityNotFoundException::new);
            MessageAttributes recAttr = new MessageAttributes();
            recAttr.setMessageTaskAttr(messageTask);
            recAttr.setAttribute(attribute);
            recAttr.setType(GeneralConstant.RECURRING_ATTRIBUTE_TYPE);
            recAttr.setKeyAttribute("#" + attribute.getName() + "#");
            messageAttributes.add(recAttr);

        }

        if (messageAttributes.size() > 0) {
            messageTask.setAttributesList(messageAttributes);
        }


        messageTaskRepo.save(messageTask);

        if (addMessageBean.getMessageTypeBean().getCode().equals(GeneralConstant.IMMEDIATE_CODE)) {
            messageReportService.save(messageTask, new Date(), 1);
        } else if (addMessageBean.getMessageTypeBean().getCode().equals(GeneralConstant.RECURRING_CODE)) {
            processRecurringMessage(addMessageBean, messageTask, daysValue);
        } else if (addMessageBean.getMessageTypeBean().getCode().equals(GeneralConstant.ONCE_OFF_CODE)) {
            messageReportService.save(messageTask, null, 1);
            messageTaskScheduleRepo.save(setMessageTaskSchedule(addMessageBean, messageTask, addMessageBean.getOnceOffDate(), 1));
        } else {
            throw new HandledException("Kesalahan proses recurring");
        }
    }


    public Page<MessageTaskBean> getMessages(String subject, String type, Integer status, Pageable pageable) {
        Page<MessageTask> messageTaskPage = null;

        if (subject == null && type != null && status == null) {
            messageTaskPage = messageTaskRepo.findAllByMessageType(type, pageable);
        } else if (subject == null && type == null && status != null) {
            messageTaskPage = messageTaskRepo.findAllByStatusEquals(status, pageable);
        } else if (subject == null && type != null && status != null) {
            messageTaskPage = messageTaskRepo.findAllByMessageTypeStatusEquals(type, status, pageable);
        } else if (subject != null && type != null && status != null) {
            messageTaskPage = messageTaskRepo.findAllBySubjectAndMessageTypeAndStatus(subject, type, status, pageable);
        } else if (subject != null && type == null && status != null) {
            messageTaskPage = messageTaskRepo.findAllBySubjectAndStatus(subject, status, pageable);
        } else if (subject != null && type != null && status == null) {
            messageTaskPage = messageTaskRepo.findAllBySubjectAndMessageType(subject, type, pageable);
        } else if (subject != null && type == null && status == null) {
            messageTaskPage = messageTaskRepo.findAllBySubject(subject, pageable);
        } else {
            messageTaskPage = messageTaskRepo.findAll(pageable);
        }

        List<MessageTaskBean> messageTaskBeans = new ArrayList<>();
        messageTaskPage.getContent().forEach(m -> {
            MessageTaskBean messageTaskBean = new MessageTaskBean();
            messageTaskBean.setId(m.getId());
            messageTaskBean.setSubject(m.getSubject());
            messageTaskBean.setStatus(m.getStatus());

            List<String> receivers = new ArrayList<>();
            m.getReceiverList().parallelStream().forEach(r -> {
                receivers.add(r.getNameReceiver());
            });
            messageTaskBean.setReceivers(String.join(",", receivers));
            messageTaskBean.setType(m.getMessageType().getName());
            messageTaskBean.setCreated(m.getCreatedDate());
            messageTaskBeans.add(messageTaskBean);
        });

        return new PageImpl<>(messageTaskBeans, messageTaskPage.getPageable(), messageTaskPage.getTotalElements());
    }


    public Map<String, String> findById(long id) throws ParseException {
        MessageTask messageTask = messageTaskRepo.findById(id).orElseThrow(EntityNotFoundException::new);

        Map<String, String> objectMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        if (messageTask.getMessageType().getCode().equals(GeneralConstant.IMMEDIATE_CODE)) {
            objectMap = getMessageTaskImmediate(messageTask);
        } else if (messageTask.getMessageType().getCode().equals(GeneralConstant.ONCE_OFF_CODE)) {
            objectMap = getMessageTaskOnceOff(messageTask);
        } else if (messageTask.getMessageType().getCode().equals(GeneralConstant.RECURRING_CODE)) {
            objectMap = getMessageRecurring(messageTask);
        }

        return objectMap;
    }

    @Transactional
    public void editMessage(EditMessageBean editMessageBean) {
        MessageTask messageTask = messageTaskRepo.findById(editMessageBean.getId()).orElseThrow(EntityNotFoundException::new);

        if (messageTask.getStatus() == 3) {
            throw new HandledException("Message sudah terkirim");
        }

        messageTask.setContent(editMessageBean.getContent());
        messageTask.setStatus(editMessageBean.getStatus());
        messageTask.setSubject(editMessageBean.getSubject());
        messageTask.setModifiedBy(editMessageBean.getModifiedBy());

        if (editMessageBean.getMessageFileBean() != null) {
            MessageFile messageFile = messageFileRepo.findById(editMessageBean.getMessageFileBean().getId()).orElseThrow();
            messageTask.setMessageFile(messageFile);
        }

        messageTaskRepo.save(messageTask);

        /**remove receiver*/
        removeReceiverInTask(editMessageBean, messageTask);
        /**add receiver*/
        addReceiverInTask(editMessageBean, messageTask);

    }

    public void delete(long id) {
        MessageTask messageTask = messageTaskRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        if (messageTask.getStatus() != 3) {
            throw new HandledException("Status belum Selesai");
        }
        messageTask.setDeleted(true);
        messageTaskRepo.save(messageTask);
    }

    public Date getSysDate() {
        return messageTaskRepo.getSysDate();
    }


    /**
     * ===============PRIVATE==================
     */

    private List<Attribute> extractionMessageAttribute(String content) {
        List<String> attributes = new ArrayList<>();
        AtomicInteger index = new AtomicInteger();
        AtomicInteger limit = new AtomicInteger();

        StringBuilder stringBuilder = new StringBuilder();
        AtomicBoolean isAttribute = new AtomicBoolean(false);

        content.codePoints().mapToObj(Character::toString).forEach(s -> {
            index.getAndIncrement();
            if (s.equals("#")) {
                isAttribute.set(true);
                limit.getAndIncrement();


                stringBuilder.append(index.get());
                if (limit.get() == 1) {
                    stringBuilder.append(",");
                } else {
                    stringBuilder.append("#");
                }


                if (limit.get() == 2) {

                    limit.getAndSet(0);
                }
            }
        });

        String[] splitString = stringBuilder.toString().split("#");

        List<Attribute> attributeList = new ArrayList<>();

        if (isAttribute.get()) {
            for (int i = 0; i < splitString.length; i++) {
                String tmp = splitString[i].toString();
                String tmpAttr = content.substring(Integer.parseInt(tmp.split(",")[0]), Integer.parseInt(tmp.split(",")[1]) - 1);
                attributes.add(tmpAttr);
            }

            attributes.forEach(a -> {
                Attribute attribute = attributeRepo.findByNameAndDeletedEquals(a, false).orElseThrow(EntityNotFoundException::new);
                attributeList.add(attribute);
            });
        }


        return attributeList;
    }

    private void addReceiverInTask(EditMessageBean editMessageBean, MessageTask messageTask) {
        if (editMessageBean.getUsers() != null && editMessageBean.getUsers().size() > 0) {
            List<MessageReceiver> userMessageReceivers = new ArrayList<>();
            editMessageBean.getUsers().parallelStream().forEach(ar -> {
                Optional<MessageReceiver> messageReceiverExist = messageReceiverRepo.findByIdReferenceReceiverAndMessageTaskReceiver(ar.getId(), messageTask);
                if (messageReceiverExist.isEmpty()) {
                    MessageReceiver messageReceiver = setNewUserReceiver(ar, messageTask);
                    userMessageReceivers.add(messageReceiver);
                }
            });
            messageReceiverRepo.saveAll(userMessageReceivers);
        }

        if (editMessageBean.getUserGroup() != null && editMessageBean.getUserGroup().size() > 0) {
            List<MessageReceiver> userGroupMessageReceivers = new ArrayList<>();
            editMessageBean.getUserGroup().parallelStream().forEach(ar -> {
                Optional<MessageReceiver> messageReceiverExist = messageReceiverRepo.findByIdReferenceReceiverAndMessageTaskReceiver(ar.getId(), messageTask);
                if (messageReceiverExist.isEmpty()) {
                    MessageReceiver messageReceiver = setNewUserGroupReceiver(ar, messageTask);
                    userGroupMessageReceivers.add(messageReceiver);
                }
            });
            messageReceiverRepo.saveAll(userGroupMessageReceivers);
        }

        if (editMessageBean.getChatRoom() != null && editMessageBean.getChatRoom().size() > 0) {
            List<MessageReceiver> chatRoomMessageReceivers = new ArrayList<>();
            editMessageBean.getChatRoom().parallelStream().forEach(ar -> {
                Optional<MessageReceiver> messageReceiverExist = messageReceiverRepo.findByIdReferenceReceiverAndMessageTaskReceiver(ar.getId(), messageTask);
                if (messageReceiverExist.isEmpty()) {
                    MessageReceiver messageReceiver = setNewChatRoomReceiver(ar, messageTask);
                    chatRoomMessageReceivers.add(messageReceiver);
                }
            });
            messageReceiverRepo.saveAll(chatRoomMessageReceivers);
        }

        if (editMessageBean.getChatRoomGroup() != null && editMessageBean.getChatRoomGroup().size() > 0) {
            List<MessageReceiver> chatRoomMessageReceivers = new ArrayList<>();
            editMessageBean.getChatRoomGroup().parallelStream().forEach(ar -> {
                Optional<MessageReceiver> messageReceiverExist = messageReceiverRepo.findByIdReferenceReceiverAndMessageTaskReceiver(ar.getId(), messageTask);
                if (messageReceiverExist.isEmpty()) {
                    MessageReceiver messageReceiver = setNewChatRoomGroupReceiver(ar, messageTask);
                    chatRoomMessageReceivers.add(messageReceiver);
                }
            });
            messageReceiverRepo.saveAll(chatRoomMessageReceivers);
        }
    }

    private MessageReceiver setNewUserReceiver(MessageReceiverBean messageReceiverBean, MessageTask messageTask) {
        MessageReceiver messageReceiver = new MessageReceiver();
        TelegramUser telegramUser = telegramUserRepo.findById(messageReceiverBean.getId()).orElseThrow();
        messageReceiver.setIdReferenceReceiver(messageReceiverBean.getId());
        messageReceiver.setNameReceiver(telegramUser.getFirstName());
        messageReceiver.setType(GeneralConstant.RECEIVER_TYPE_SINGLE_USER);
        messageReceiver.setMessageTaskReceiver(messageTask);
        return messageReceiver;
    }

    private MessageReceiver setNewUserGroupReceiver(MessageReceiverBean messageReceiverBean, MessageTask messageTask) {
        MessageReceiver messageReceiver = new MessageReceiver();
        TelegramUserGroup telegramUserGroup = telegramUserGroupRepo.findById(messageReceiverBean.getId()).orElseThrow();
        messageReceiver.setIdReferenceReceiver(messageReceiverBean.getId());
        messageReceiver.setNameReceiver(telegramUserGroup.getName());
        messageReceiver.setType(GeneralConstant.RECEIVER_TYPE_MULTIPLE_USER);
        messageReceiver.setMessageTaskReceiver(messageTask);
        return messageReceiver;
    }

    private MessageReceiver setNewChatRoomReceiver(MessageReceiverBean messageReceiverBean, MessageTask messageTask) {
        MessageReceiver messageReceiver = new MessageReceiver();
        ChatRoom chatRoom = chatRoomRepo.findById(messageReceiverBean.getId()).orElseThrow();
        messageReceiver.setIdReferenceReceiver(messageReceiverBean.getId());
        messageReceiver.setNameReceiver(chatRoom.getName());
        messageReceiver.setType(GeneralConstant.RECEIVER_TYPE_SINLGE_CHATROOM);
        messageReceiver.setMessageTaskReceiver(messageTask);
        return messageReceiver;
    }

    private MessageReceiver setNewChatRoomGroupReceiver(MessageReceiverBean messageReceiverBean, MessageTask messageTask) {
        MessageReceiver messageReceiver = new MessageReceiver();
        ChatRoomGroup chatRoomGroup = chatRoomGroupRepo.findById(messageReceiverBean.getId()).orElseThrow();
        messageReceiver.setIdReferenceReceiver(messageReceiverBean.getId());
        messageReceiver.setNameReceiver(chatRoomGroup.getName());
        messageReceiver.setType(GeneralConstant.RECEIVER_TYPE_MULTIPLE_CHATROOM);
        messageReceiver.setMessageTaskReceiver(messageTask);
        return messageReceiver;
    }


    private List<MessageReceiver> getMessageReceiver(AddMessageBean addMessageBean, MessageTask messageTask) {
        List<MessageReceiverBean> usersBean = addMessageBean.getUsers();
        List<MessageReceiverBean> userGroupsBean = addMessageBean.getUserGroup();
        List<MessageReceiverBean> chatRooms = addMessageBean.getChatRoom();
        List<MessageReceiverBean> chatRoomGroups = addMessageBean.getChatRoomGroup();
        List<MessageReceiver> messageReceivers = new ArrayList<>();
        if (usersBean != null && usersBean.size() > 0) {
            usersBean.parallelStream().forEach(ub -> {
                MessageReceiver messageReceiver = setNewUserReceiver(ub, messageTask);
                messageReceivers.add(messageReceiver);
            });
        }

        if (userGroupsBean != null && userGroupsBean.size() > 0) {
            userGroupsBean.parallelStream().forEach(ub -> {
                MessageReceiver messageReceiver = setNewUserGroupReceiver(ub, messageTask);
                messageReceivers.add(messageReceiver);
            });
        }

        if (chatRooms != null && chatRooms.size() > 0) {
            chatRooms.parallelStream().forEach(ub -> {
                MessageReceiver messageReceiver = setNewChatRoomReceiver(ub, messageTask);
                messageReceivers.add(messageReceiver);
            });
        }

        if (chatRoomGroups != null && chatRoomGroups.size() > 0) {
            chatRoomGroups.parallelStream().forEach(ub -> {
                MessageReceiver messageReceiver = setNewChatRoomGroupReceiver(ub, messageTask);
                messageReceivers.add(messageReceiver);
            });
        }

        return messageReceivers;
    }

    private MessageTaskSchedule setMessageTaskSchedule(AddMessageBean addMessageBean, MessageTask messageTask, Date dateR, int batch) {
        MessageTaskSchedule messageTaskSchedule = new MessageTaskSchedule();
        messageTaskSchedule.setMessageTask(messageTask);
        messageTaskSchedule.setDateExecute(dateR);
        if (addMessageBean.getMessageTypeBean().getCode().equals(GeneralConstant.IMMEDIATE_CODE)) {
            messageTaskSchedule.setTimeExecute(new Date());
        }
        if (addMessageBean.getMessageTypeBean().getCode().equals(GeneralConstant.ONCE_OFF_CODE)) {
            messageTaskSchedule.setTimeExecute(addMessageBean.getOnceOffTime());
        } else if (addMessageBean.getMessageTypeBean().getCode().equals(GeneralConstant.RECURRING_CODE)) {
            messageTaskSchedule.setTimeExecute(addMessageBean.getRecurringTimeExecute());
        }
        messageTaskSchedule.setStatus(GeneralConstant.STATUS_QUEUE_MESSAGE_SCHEDULE);
        messageTaskSchedule.setBatch(batch);
        return messageTaskSchedule;
    }

    private void processRecurringMessage(AddMessageBean addMessageBean, MessageTask messageTask, String[] daysValue) throws ParseException {

        if (addMessageBean.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_WEEKLY)) {
            processIterateScheduleWeekly(addMessageBean, messageTask, daysValue);
        } else if (addMessageBean.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_MONTHLY)) {
            processIterateScheduleMonthly(addMessageBean, messageTask);
        } else if (addMessageBean.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_ANNUALLY)) {
            processIterateScheduleAnnually(addMessageBean, messageTask);
        } else if (addMessageBean.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_DAILY)) {
            processIterateScheduleDaily(addMessageBean, messageTask);
        } else if (addMessageBean.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_ATTRIBUTE)) {
            processIterateScheduleAttribute(addMessageBean, messageTask, 1);
        }
    }

    private AttributeTaskSchedule setNewAttributeSchedule(MessageTask messageTask, String receiverType, long idRefReceiverAttribute, int batch, Date recurringDate) {
        AttributeTaskSchedule attributeTaskSchedule = new AttributeTaskSchedule();
        attributeTaskSchedule.setMessageTaskId(messageTask.getId());
        attributeTaskSchedule.setBatch(batch);
        attributeTaskSchedule.setReceiverType(receiverType);
        attributeTaskSchedule.setDateExecute(recurringDate);
        attributeTaskSchedule.setTimeExecute(messageTask.getRecurringTimeExecute());
        attributeTaskSchedule.setStatus(GeneralConstant.STATUS_QUEUE_MESSAGE_SCHEDULE);
        attributeTaskSchedule.setIdRefReceiver(idRefReceiverAttribute);
        return attributeTaskSchedule;
    }

    private void generatedRecurringAttribute(MemberAttribute memberAttribute, MessageTask messageTask, String receiverType, long idRefReceiverAttribute, int recurringMode, String contactType) {
        List<AttributeTaskSchedule> attributeTaskSchedules = new ArrayList<>();

        Date startRecurring = messageTask.getRecurringStartDate();


        Date dateF = null;
        try {
            String yearStart = GeneralUtil.dateToStr(startRecurring, "YYYY");
            String dateMonthStart = memberAttribute.getAttributeValue().substring(0, 6);
            String dateFMan = dateMonthStart + yearStart;

            dateF = GeneralUtil.strToDate(dateFMan, "dd-MM-yyyy");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (dateF.before(messageTask.getRecurringStartDate())) {
            dateF = LocalDate.fromDateFields(dateF).plusYears(1).toDate();
        }


        Calendar calExecute = Calendar.getInstance();
        calExecute.setTime(dateF);

        attributeTaskSchedules.add(setNewAttributeSchedule(messageTask, receiverType, idRefReceiverAttribute, 1, dateF));


        Date dateR;
        int stop = -1;
        int batchR = 2;
        do {
            calExecute.add(Calendar.YEAR, recurringMode);
            dateR = calExecute.getTime();
            stop = dateR.compareTo(messageTask.getRecurringEndDate());
            if (dateR.before(messageTask.getRecurringEndDate()) || stop == 0) {

                attributeTaskSchedules.add(setNewAttributeSchedule(messageTask, receiverType, idRefReceiverAttribute, batchR, dateR));
            }
            batchR++;
        } while (stop < 0);

        attributeTaskScheduleRepo.saveAll(attributeTaskSchedules);

        recAttributeMember.put(idRefReceiverAttribute + contactType, idRefReceiverAttribute);

    }

    private void processIterateScheduleAttribute(AddMessageBean addMessageBean, MessageTask messageTask, int recurringMode) {
        /** use ANNUALLY temp */
        recAttributeMember.clear();
        List<MessageAttributes> messageAttributes = messageAttributesRepo.findByMessageTaskAttrAndTypeEquals(messageTask, GeneralConstant.RECURRING_ATTRIBUTE_TYPE);


        List<MessageReceiver> messageReceivers = messageReceiverRepo.findByMessageTaskReceiver(messageTask);

        if (messageReceivers.size() > 0) {
            final List<AttributeTaskSchedule>[] attributeTaskSchedules = new List[]{new ArrayList<>()};
            AtomicInteger row = new AtomicInteger(0);

            messageReceivers.stream().forEach(mr -> {
                Date attributeValue;
                if (messageAttributes.size() > 0) {

                    if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINGLE_USER)) {
                        Optional<MemberAttribute> optionalTuMemberAttribute = messageAttributes.get(0).getAttribute().getMemberAttributeList().stream().filter(mt -> mt.getIdRefContact() == mr.getIdReferenceReceiver() && mt.getContactType().equals(GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER)).findFirst();
                        /** receiver exist in member attribute selected*/
                        if (optionalTuMemberAttribute.isPresent()) {
                            generatedRecurringAttribute(optionalTuMemberAttribute.get(), messageTask, mr.getType(), mr.getIdReferenceReceiver(), recurringMode, GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER);
                        }
                    }

                    if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_USER)) {
                        TelegramUserGroup telegramUserGroup = telegramUserGroupRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                        List<MemberTelegramUserGroup> memberTelegramUserGroups = memberTelegramUserGroupRepo.findAllByUserGroup(telegramUserGroup);

                        if (memberTelegramUserGroups.size() > 0) {
                            memberTelegramUserGroups.forEach(tu -> {
                                Optional<MemberAttribute> optionalTugMemberAttribute = messageAttributes.get(0).getAttribute().getMemberAttributeList().stream().filter(mt -> mt.getIdRefContact() == tu.getTelegramUser().getId() && mt.getContactType().equals(GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER)).findFirst();
                                if (optionalTugMemberAttribute.isPresent()) {
                                    Long existAttributeRec = recAttributeMember.get(optionalTugMemberAttribute.get().getIdRefContact() + GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER);
                                    if (existAttributeRec == null || existAttributeRec.compareTo(tu.getTelegramUser().getId()) > 0) {
                                        generatedRecurringAttribute(optionalTugMemberAttribute.get(), messageTask, mr.getType(), tu.getTelegramUser().getId(), recurringMode, GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER);
                                    }

                                }

                            });
                        }
                    }

                    if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINLGE_CHATROOM)) {
                        ChatRoom ct = chatRoomRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();

                        Optional<MemberAttribute> optionalCrmMemberAttribute = messageAttributes.get(0).getAttribute().getMemberAttributeList().stream().filter(mt -> mt.getIdRefContact() == mr.getIdReferenceReceiver() && mt.getContactType().equals(GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM)).findFirst();

                        /** receiver exist in member attribute selected*/
                        if (optionalCrmMemberAttribute.isPresent()) {
                            generatedRecurringAttribute(optionalCrmMemberAttribute.get(), messageTask, mr.getType(), mr.getIdReferenceReceiver(), recurringMode, GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM);
                        }
                    }

                    if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_CHATROOM)) {
                        ChatRoomGroup cgr = chatRoomGroupRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                        List<ChatRoomGroupMember> chatRoomGroupMembers = chatRoomGroupMemberRepo.findAllByChatRoomGroup(cgr);
                        if (chatRoomGroupMembers != null && chatRoomGroupMembers.size() > 0) {
                            chatRoomGroupMembers.forEach(cgm -> {

                                Optional<MemberAttribute> optionalCrgMemberAttribute = messageAttributes.get(0).getAttribute().getMemberAttributeList().stream().filter(mt -> mt.getIdRefContact() == cgm.getChatRoom().getId() && mt.getContactType().equals(GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM)).findFirst();

                                if (optionalCrgMemberAttribute.isPresent()) {
                                    Long existAttributeRec = recAttributeMember.get(optionalCrgMemberAttribute.get().getIdRefContact() + GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM);
                                    if (existAttributeRec == null || existAttributeRec.compareTo(cgm.getChatRoom().getId()) > 0) {
                                        generatedRecurringAttribute(optionalCrgMemberAttribute.get(), messageTask, mr.getType(), cgm.getChatRoom().getId(), recurringMode, GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM);
                                    }
                                }

                            });
                        }
                    }


                }

            });

        }

        messageReportService.save(messageTask, null, 1);

    }

    private void processIterateScheduleMonthly(AddMessageBean addMessageBean, MessageTask messageTask) throws ParseException {

        String my = GeneralUtil.dateToStr(addMessageBean.getRecurringStartDate(), "MM-yyyy");
        Date recStart = GeneralUtil.strToDate(addMessageBean.getRecurringExecute() + "-" + my, "dd-MM-yyyy");
        LocalDate dateF = LocalDate.fromDateFields(recStart);


        //set firstdate
        Period diff = Period.between(java.time.LocalDate.parse(GeneralUtil.dateToStr(recStart, "yyyy-MM-dd")), java.time.LocalDate.now());
        Date fisrtDate = dateF.plusMonths(diff.getMonths()).toDate();
        if (fisrtDate.before(new Date())) {
            LocalDate fff = LocalDate.fromDateFields(fisrtDate);
            fisrtDate = fff.plusMonths(1).toDate();
        }

        List<MessageTaskSchedule> messageTaskSchedules = new ArrayList<>();
        messageTaskSchedules.add(setMessageTaskSchedule(addMessageBean, messageTask, fisrtDate, 1));


        Calendar calExecute = Calendar.getInstance();
        calExecute.setTime(fisrtDate);

        String endDate = GeneralUtil.dateToStr(addMessageBean.getRecurringEndDate(), "dd-MM-yyyy");
        Date endDateRec = GeneralUtil.strToDate(endDate, "dd-MM-yyyy");


        Date dateR;
        int stop = -1;
        int batchR = 2;
        do {
            calExecute.add(Calendar.MONTH, 1);
            dateR = calExecute.getTime();
            stop = dateR.compareTo(endDateRec);
            if (dateR.before(endDateRec) || stop == 0) {
                messageTaskSchedules.add(setMessageTaskSchedule(addMessageBean, messageTask, dateR, batchR));
            }
            batchR++;
        } while (stop < 0);
        messageTaskScheduleRepo.saveAll(messageTaskSchedules);
        initReportFromRecurring(messageTaskSchedules);

    }

    private void processIterateScheduleAnnually(AddMessageBean addMessageBean, MessageTask messageTask) throws ParseException {
        Date dateF = GeneralUtil.strToDate(addMessageBean.getRecurringExecute(), "dd-MM-yyyy");
        Calendar calExecute = Calendar.getInstance();
        calExecute.setTime(dateF);

        List<MessageTaskSchedule> messageTaskSchedules = new ArrayList<>();
        messageTaskSchedules.add(setMessageTaskSchedule(addMessageBean, messageTask, dateF, 1));
        Date dateR;
        int stop = -1;
        int batchR = 2;
        do {
            calExecute.add(Calendar.YEAR, 1);
            dateR = calExecute.getTime();
            stop = dateR.compareTo(addMessageBean.getRecurringEndDate());
            if (dateR.before(addMessageBean.getRecurringEndDate()) || stop == 0) {
                messageTaskSchedules.add(setMessageTaskSchedule(addMessageBean, messageTask, dateR, batchR));
            }
            batchR++;
        } while (stop < 0);
        messageTaskScheduleRepo.saveAll(messageTaskSchedules);
        initReportFromRecurring(messageTaskSchedules);

    }

    private void processIterateScheduleWeekly(AddMessageBean addMessageBean, MessageTask messageTask, String[] daysValue) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(addMessageBean.getRecurringStartDate());


        String startDay = GeneralUtil.dateToStr(addMessageBean.getRecurringStartDate(), "EEE");
        if (startDay.equalsIgnoreCase(addMessageBean.getRecurringExecute())) {
            int dayint = calendar.get(Calendar.DAY_OF_WEEK);
            int paramDay = Arrays.asList(daysValue).indexOf(addMessageBean.getRecurringExecute());
            if ((paramDay + 1) - dayint > 0) {
                calendar.add(Calendar.DATE, paramDay + 1 - dayint);
            }
        } else {
            String dayFromStart = startDay.toUpperCase();
            String dayFromExe = addMessageBean.getRecurringExecute();
            int dayStart = IntStream.range(0, daysValue.length)
                    .filter(i -> dayFromStart.equals(daysValue[i]))
                    .findFirst()
                    .orElse(-1);

            int dayExe = IntStream.range(0, daysValue.length)
                    .filter(i -> dayFromExe.equals(daysValue[i]))
                    .findFirst()
                    .orElse(-1);

            int max = 6;
            int fromMax = max - dayStart;


            int startDayExe = 0;
            if (dayStart < dayExe) {
                startDayExe = dayExe - dayStart;
            } else {
                startDayExe = fromMax + dayExe + 1;
            }

            calendar.add(Calendar.DATE, startDayExe);
        }


        Date dateF = calendar.getTime();

        List<MessageTaskSchedule> messageTaskSchedules = new ArrayList<>();
        messageTaskSchedules.add(setMessageTaskSchedule(addMessageBean, messageTask, dateF, 1));
        Date dateR;
        int stop = -1;
        int batchWR = 2;
        do {
            calendar.add(Calendar.DATE, 7);
            dateR = calendar.getTime();
            stop = dateR.compareTo(addMessageBean.getRecurringEndDate());
            if (dateR.before(addMessageBean.getRecurringEndDate()) || stop == 0) {
                messageTaskSchedules.add(setMessageTaskSchedule(addMessageBean, messageTask, dateR, batchWR));
            }
            batchWR++;
        } while (stop < 0);
        messageTaskScheduleRepo.saveAll(messageTaskSchedules);
        initReportFromRecurring(messageTaskSchedules);

    }

    private void processIterateScheduleDaily(AddMessageBean addMessageBean, MessageTask messageTask) throws ParseException {

        Period diff = Period.between(java.time.LocalDate.parse(GeneralUtil.dateToStr(addMessageBean.getRecurringStartDate(), "yyyy-MM-dd")), java.time.LocalDate.now());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(addMessageBean.getRecurringStartDate());
        calendar.add(Calendar.DATE, diff.getDays());
        Date dateF = calendar.getTime();

        List<MessageTaskSchedule> messageTaskSchedules = new ArrayList<>();
        messageTaskSchedules.add(setMessageTaskSchedule(addMessageBean, messageTask, dateF, 1));

        Calendar calExecute = Calendar.getInstance();
        calExecute.setTime(dateF);

        Date dateR;
        int stop = -1;
        int batchDR = 2;
        do {
            calExecute.add(Calendar.DATE, 1);
            dateR = calExecute.getTime();
            stop = dateR.compareTo(addMessageBean.getRecurringEndDate());
            if (dateR.before(addMessageBean.getRecurringEndDate()) || stop == 0) {
                messageTaskSchedules.add(setMessageTaskSchedule(addMessageBean, messageTask, dateR, batchDR));

            }
            batchDR++;
        } while (stop < 0);
        messageTaskScheduleRepo.saveAll(messageTaskSchedules);
        initReportFromRecurring(messageTaskSchedules);

    }

    private void initReportFromRecurring(List<MessageTaskSchedule> messageTaskSchedules) {
        messageTaskSchedules.parallelStream().forEach(r -> {
            messageReportService.save(r.getMessageTask(), null, r.getBatch());
        });

    }


    private void removeReceiverInTask(EditMessageBean editMessageBean, MessageTask messageTask) {
        if (editMessageBean.getDeleteUsers() != null && editMessageBean.getDeleteUsers().size() > 0) {
            editMessageBean.getDeleteUsers().parallelStream().forEach(du -> {
                Optional<MessageReceiver> messageReceiver = messageReceiverRepo.findByIdReferenceReceiverAndMessageTaskReceiver(du.getId(), messageTask);
                messageReceiver.ifPresent(dr -> {
                    execDeleteReceiver(dr.getIdReferenceReceiver(), messageTask);
                });
            });
        }
        if (editMessageBean.getDeleteUserGroup() != null && editMessageBean.getDeleteUserGroup().size() > 0) {
            editMessageBean.getDeleteUserGroup().parallelStream().forEach(du -> {
                execDeleteReceiver(du.getId(), messageTask);
            });
        }
        if (editMessageBean.getDeleteChatRoom() != null && editMessageBean.getDeleteChatRoom().size() > 0) {
            editMessageBean.getDeleteChatRoom().parallelStream().forEach(du -> {
                execDeleteReceiver(du.getId(), messageTask);
            });
        }
        if (editMessageBean.getDeleteChatRoomGroup() != null && editMessageBean.getDeleteChatRoomGroup().size() > 0) {
            editMessageBean.getDeleteChatRoomGroup().parallelStream().forEach(du -> {
                execDeleteReceiver(du.getId(), messageTask);
            });
        }
    }


    private void execDeleteReceiver(long idRef, MessageTask messageTask) {
        Optional<MessageReceiver> messageReceiver = Optional.ofNullable(messageReceiverRepo.findByIdReferenceReceiverAndMessageTaskReceiver(idRef, messageTask).orElseThrow());
        messageReceiverRepo.delete(messageReceiver.get());
    }


    private Map<String, String> getMessageRecurring(MessageTask messageTask) throws ParseException {
        Map<String, String> objectMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        ViewMessageTaskBean viewMessageTaskBean = contactMapper.toReceiverView(messageTask);

        ViewRecurringMessageBean viewRecurringMessageBean = contactMapper.toViewRecurringMessageBean(messageTask, viewMessageTaskBean);


        if (messageTask.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_WEEKLY) || messageTask.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_MONTHLY)) {
            viewRecurringMessageBean.setRecurringExecute(messageTask.getRecurringExecute());
        } else if (messageTask.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_ANNUALLY)) {
            Date recExe = GeneralUtil.strToDate(messageTask.getRecurringExecute(), "dd-MM-yyyy");
            String recExeStr = GeneralUtil.dateToStr(recExe, "yyyy-MM-dd");
            viewRecurringMessageBean.setRecurringExecute(recExeStr);
        }


        viewRecurringMessageBean.setMessageFileBean(messageFileMapper.toBean(messageTask.getMessageFile()));
        viewRecurringMessageBean.setMessageTypeBean(messageTypeMapper.toDto(messageTask.getMessageType()));


        List<MessageAttributes> messageAttributes = messageAttributesRepo.findByMessageTaskAttrAndTypeEquals(messageTask, GeneralConstant.RECURRING_ATTRIBUTE_TYPE);
        if (messageAttributes != null && messageAttributes.size() > 0) {
            AttributeBean attributeBean = contactMapper.toAttributeBean(messageAttributes.get(0).getAttribute());
            viewRecurringMessageBean.setAttribute(attributeBean);
        }
        objectMap = objectMapper.convertValue(viewRecurringMessageBean, Map.class);


        return objectMap;
    }

    private Map<String, String> getMessageTaskImmediate(MessageTask messageTask) {
        Map<String, String> objectMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        ViewMessageTaskBean viewMessageTaskBean = contactMapper.toReceiverView(messageTask);

        ViewImmediateMessageBean viewImmediateMessageBean = contactMapper.toViewImmediateMessageBean(messageTask, viewMessageTaskBean);

        viewImmediateMessageBean.setMessageFileBean(messageFileMapper.toBean(messageTask.getMessageFile()));
        viewImmediateMessageBean.setMessageTypeBean(messageTypeMapper.toDto(messageTask.getMessageType()));

        objectMap = objectMapper.convertValue(viewImmediateMessageBean, Map.class);


        return objectMap;
    }

    private Map<String, String> getMessageTaskOnceOff(MessageTask messageTask) {
        Map<String, String> objectMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        ViewMessageTaskBean viewMessageTaskBean = contactMapper.toReceiverView(messageTask);

        ViewOnceOffMessgeBean viewOnceOffMessgeBean = contactMapper.toViewOnceOffMessgeBean(messageTask, viewMessageTaskBean);

        viewOnceOffMessgeBean.setMessageFileBean(messageFileMapper.toBean(messageTask.getMessageFile()));
        viewOnceOffMessgeBean.setMessageTypeBean(messageTypeMapper.toDto(messageTask.getMessageType()));


        objectMap = objectMapper.convertValue(viewOnceOffMessgeBean, Map.class);


        return objectMap;
    }


}
