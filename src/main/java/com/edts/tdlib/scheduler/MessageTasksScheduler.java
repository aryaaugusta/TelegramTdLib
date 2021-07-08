package com.edts.tdlib.scheduler;

import com.edts.tdlib.bean.TelegramMessageBean;
import com.edts.tdlib.bean.message.AttributeRecurringTaskBean;
import com.edts.tdlib.bean.message.MessageRecurringTaskBean;
import com.edts.tdlib.bean.message.TransferMessageBean;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.helper.CoreHelper;
import com.edts.tdlib.model.SystemConfiguration;
import com.edts.tdlib.model.contact.*;
import com.edts.tdlib.model.message.*;
import com.edts.tdlib.repository.*;
import com.edts.tdlib.service.MessageReportService;
import com.edts.tdlib.service.MessageService;
import com.edts.tdlib.util.GeneralUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class MessageTasksScheduler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MessageTaskScheduleRepo messageTaskScheduleRepo;
    private final MessageTaskRepo messageTaskRepo;
    private final ChatRoomRepo chatRoomRepo;
    private final MessageService messageService;
    private final TelegramUserRepo telegramUserRepo;
    private final TelegramUserGroupRepo telegramUserGroupRepo;
    private final MemberTelegramUserGroupRepo memberTelegramUserGroupRepo;
    private final MessageReceiverRepo messageReceiverRepo;
    private final MessageReportRepo messageReportRepo;
    private final SystemConfigurationRepo systemConfigurationRepo;
    private final MessageReportService messageReportService;
    private final ChatRoomGroupRepo chatRoomGroupRepo;
    private final ChatRoomGroupMemberRepo chatRoomGroupMemberRepo;
    private final MessageAttributesRepo messageAttributesRepo;
    private final MemberAttributeRepo memberAttributeRepo;
    private final AttributeTaskScheduleRepo attributeTaskScheduleRepo;

    @Autowired
    public MessageTasksScheduler(MessageTaskScheduleRepo messageTaskScheduleRepo, MessageTaskRepo messageTaskRepo,
                                 ChatRoomRepo chatRoomRepo, MessageService messageService, TelegramUserRepo telegramUserRepo,
                                 TelegramUserGroupRepo telegramUserGroupRepo, MemberTelegramUserGroupRepo memberTelegramUserGroupRepo,
                                 MessageReceiverRepo messageReceiverRepo, MessageReportRepo messageReportRepo, SystemConfigurationRepo systemConfigurationRepo,
                                 MessageReportService messageReportService, ChatRoomGroupRepo chatRoomGroupRepo, ChatRoomGroupMemberRepo chatRoomGroupMemberRepo,
                                 MessageAttributesRepo messageAttributesRepo, MemberAttributeRepo memberAttributeRepo, AttributeTaskScheduleRepo attributeTaskScheduleRepo) {
        this.messageTaskScheduleRepo = messageTaskScheduleRepo;
        this.messageTaskRepo = messageTaskRepo;
        this.chatRoomRepo = chatRoomRepo;
        this.messageService = messageService;
        this.telegramUserRepo = telegramUserRepo;
        this.telegramUserGroupRepo = telegramUserGroupRepo;
        this.memberTelegramUserGroupRepo = memberTelegramUserGroupRepo;
        this.messageReceiverRepo = messageReceiverRepo;
        this.messageReportRepo = messageReportRepo;
        this.systemConfigurationRepo = systemConfigurationRepo;
        this.messageReportService = messageReportService;
        this.chatRoomGroupRepo = chatRoomGroupRepo;
        this.chatRoomGroupMemberRepo = chatRoomGroupMemberRepo;
        this.messageAttributesRepo = messageAttributesRepo;
        this.memberAttributeRepo = memberAttributeRepo;
        this.attributeTaskScheduleRepo = attributeTaskScheduleRepo;
    }

    @Scheduled(fixedDelay = 2000, initialDelay = 180000)//180000 780000
    public void recurringDailyMessageTask() throws ParseException {
        //logger.info("Fixed Delay Task :: Execution Time - {recurringDailyMessageTask} " + GeneralUtil.dateToStr(new Date(), "dd/MM/yyyy hh:mm:ss"));
        //Date executeDate = GeneralUtil.strToDate(GeneralUtil.dateToStr(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
        Date executeDate = getExecuteDate(GeneralConstant.GROUP_KEY_RECURRING, GeneralConstant.KEY_PARAM_EXECUTE_DATE);

        String executeTime = GeneralUtil.dateToStr(new Date(), "HH:mm:00");
        List<MessageRecurringTaskBean> messageRecurringTaskBeans = messageTaskScheduleRepo.
                findAllByRecurringTypeAndStatusAndExecuteDate(GeneralConstant.RECURRING_TYPE_DAILY, executeDate);

        processRecurringTask(messageRecurringTaskBeans, executeTime);

    }

    @Scheduled(fixedDelay = 2000, initialDelay = 360000)
    public void recurringWeeklyMessageTask() throws ParseException {
        //logger.info("Fixed Delay Task :: Execution Time - {recurringWeeklyMessageTask} " + GeneralUtil.dateToStr(new Date(), "dd/MM/yyyy hh:mm:ss"));
        //Date executeDate = GeneralUtil.strToDate(GeneralUtil.dateToStr(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
        Date executeDate = getExecuteDate(GeneralConstant.GROUP_KEY_RECURRING, GeneralConstant.KEY_PARAM_EXECUTE_DATE);

        String executeTime = GeneralUtil.dateToStr(new Date(), "HH:mm:ss");
        List<MessageRecurringTaskBean> messageRecurringTaskBeans = messageTaskScheduleRepo.
                findAllByRecurringTypeAndStatusAndExecuteDate(GeneralConstant.RECURRING_TYPE_WEEKLY, executeDate);

        processRecurringTask(messageRecurringTaskBeans, executeTime);
    }


    @Scheduled(fixedDelay = 2000, initialDelay = 540000)
    public void recurringMonthlyMessageTask() throws ParseException {
        //logger.info("Fixed Delay Task :: Execution Time - {recurringMonthlyMessageTask} " + GeneralUtil.dateToStr(new Date(), "dd/MM/yyyy hh:mm:ss"));
        //Date executeDate = GeneralUtil.strToDate(GeneralUtil.dateToStr(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
        Date executeDate = getExecuteDate(GeneralConstant.GROUP_KEY_RECURRING, GeneralConstant.KEY_PARAM_EXECUTE_DATE);

        String executeTime = GeneralUtil.dateToStr(new Date(), "HH:mm:ss");
        List<MessageRecurringTaskBean> messageRecurringTaskBeans = messageTaskScheduleRepo.
                findAllByRecurringTypeAndStatusAndExecuteDate(GeneralConstant.RECURRING_TYPE_MONTHLY, executeDate);

        processRecurringTask(messageRecurringTaskBeans, executeTime);
    }


    @Scheduled(fixedDelay = 2000, initialDelay = 660000)
    public void recurringAnnuallyMessageTask() throws ParseException {
        //logger.info("Fixed Delay Task :: Execution Time - {recurringAnnuallyMessageTask} " + GeneralUtil.dateToStr(new Date(), "dd/MM/yyyy hh:mm:ss"));
        //Date executeDate = GeneralUtil.strToDate(GeneralUtil.dateToStr(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
        Date executeDate = getExecuteDate(GeneralConstant.GROUP_KEY_RECURRING, GeneralConstant.KEY_PARAM_EXECUTE_DATE);
        String executeTime = GeneralUtil.dateToStr(new Date(), "HH:mm:ss");


        List<MessageRecurringTaskBean> messageRecurringTaskBeans = messageTaskScheduleRepo.
                findAllByRecurringTypeAndStatusAndExecuteDate(GeneralConstant.RECURRING_TYPE_ANNUALLY, executeDate);

        processRecurringTask(messageRecurringTaskBeans, executeTime);
    }


    @Scheduled(fixedDelay = 2000, initialDelay = 180009)//180000 780000
    public void onceOffMessageTask() throws ParseException {
        //logger.info("Fixed Delay Task :: Execution Time - {onceOffMessageTask} " + GeneralUtil.dateToStr(new Date(), "dd/MM/yyyy hh:mm:ss"));

        Date executeDate = getExecuteDate(GeneralConstant.GROUP_KEY_ONCE_OFF, GeneralConstant.KEY_PARAM_EXECUTE_DATE);

        List<MessageTask> messageTasks = messageTaskRepo.findAllByOnceOffDateAndStatusEquals(executeDate, 1);
        if (messageTasks.size() > 0) {
            messageTasks.forEach(mt -> {

                MessageTask messageTask = mt;
                AtomicInteger sendCount = new AtomicInteger();

                AtomicReference<String> contentMessage = new AtomicReference<>(messageTask.getContent());
                List<MessageAttributes> messageAttributes = messageAttributesRepo.findByMessageTaskAttrAndTypeEquals(messageTask, GeneralConstant.MESSAGE_ATTRIBUTE_TYPE);


                synchronized (messageTask) {
                    long idScheduler = messageTaskScheduleRepo.findByMessageTask(mt).get(0).getId();


                    List<MessageTaskSchedule> messageTaskSchedules = messageTaskScheduleRepo.findByMessageTask(mt);
                    MessageTaskSchedule messageTaskSchedule = null;
                    if (messageTaskSchedules != null && messageTaskSchedules.size() > 0) {
                        messageTaskSchedule = messageTaskSchedules.get(0);
                    }
                    try {
                        String strDate = GeneralUtil.dateToStr(messageTaskSchedule.getTimeExecute(), "HH:mm:ss");
                        Date manDate = manipulateDate(strDate);
                        Date compareDate = messageTaskRepo.getSysDate();

                        String isProd = systemConfigurationRepo.findByGroupKeyAndKeyParam("ENV", "PROD").get().getValueParam();
                        if (isProd.equals("TRUE")) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(compareDate);
                            calendar.add(Calendar.HOUR_OF_DAY, 6);
                            compareDate = calendar.getTime();
                        }

                        logger.info("Fixed Delay Task :: Execution Time - {onceOffMessageTask} " + manDate + " -- " + new Date() + " -- " + messageTaskRepo.getSysDate());
                        if (manDate.before(compareDate) || manDate.compareTo(compareDate) == 0) {
                            updateProcessing(idScheduler);
                            //cause lazy find again
                            List<MessageReceiver> messageReceivers = messageReceiverRepo.findByMessageTaskReceiver(mt);
                            if (messageReceivers != null && messageReceivers.size() > 0) {
                                AtomicReference<String> keyName = new AtomicReference<>();
                                if (mt.getMessageFile() != null) {
                                    keyName.set(mt.getMessageFile().getFileId());
                                }

                                messageReceivers.forEach(mr -> {
                                    if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINGLE_USER)) {
                                        TelegramUser tu = telegramUserRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();

                                        sendCount.getAndIncrement();

                                        if (messageAttributes != null && messageAttributes.size() > 0) {
                                            contentMessage.set(messageContentManipulation(messageAttributes, messageTask, tu.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER));
                                        }


                                        CoreHelper.messageTransfer.put(Long.parseLong(tu.getChatId()), new TransferMessageBean(mt.getId(), 1));
                                        messageService.sendTelegram(new TelegramMessageBean(Long.parseLong(tu.getChatId()), contentMessage.get(), keyName.get()));
                                    }

                                    if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_USER)) {
                                        //receiver group telegram user
                                        TelegramUserGroup telegramUserGroup = telegramUserGroupRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                                        List<MemberTelegramUserGroup> memberTelegramUserGroups = memberTelegramUserGroupRepo.findAllByUserGroup(telegramUserGroup);
                                        if (memberTelegramUserGroups.size() > 0) {
                                            memberTelegramUserGroups.forEach(tu -> {
                                                sendCount.getAndIncrement();

                                                if (messageAttributes != null && messageAttributes.size() > 0) {
                                                    contentMessage.set(messageContentManipulation(messageAttributes, messageTask, tu.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER));
                                                }

                                                CoreHelper.messageTransfer.put(Long.parseLong(tu.getTelegramUser().getChatId()), new TransferMessageBean(mt.getId(), 1));
                                                messageService.sendTelegram(new TelegramMessageBean(Long.parseLong(tu.getTelegramUser().getChatId()), mt.getContent(), keyName.get()));

                                            });
                                        }
                                    }

                                    if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINLGE_CHATROOM)) {
                                        //receiver chatroom telegram
                                        ChatRoom ct = chatRoomRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();

                                        sendCount.getAndIncrement();


                                        if (messageAttributes != null && messageAttributes.size() > 0) {
                                            contentMessage.set(messageContentManipulation(messageAttributes, messageTask, ct.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM));
                                        }

                                        CoreHelper.messageTransfer.put(ct.getChatId(), new TransferMessageBean(mt.getId(), 1));
                                        messageService.sendTelegram(new TelegramMessageBean(ct.getChatId(), mt.getContent(), keyName.get()));
                                    }

                                    if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_CHATROOM)) {
                                        ChatRoomGroup crg = chatRoomGroupRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                                        List<ChatRoomGroupMember> chatRoomGroupMembers = chatRoomGroupMemberRepo.findAllByChatRoomGroup(crg);

                                        if (chatRoomGroupMembers.size() > 0) {
                                            chatRoomGroupMembers.forEach(cgm -> {
                                                sendCount.getAndIncrement();

                                                if (messageAttributes != null && messageAttributes.size() > 0) {
                                                    contentMessage.set(messageContentManipulation(messageAttributes, messageTask, cgm.getChatRoom().getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM));
                                                }

                                                CoreHelper.messageTransfer.put(cgm.getChatRoom().getChatId(), new TransferMessageBean(messageTask.getId(), 1));
                                                messageService.sendTelegram(new TelegramMessageBean(cgm.getChatRoom().getChatId(), messageTask.getContent(), keyName.get()));
                                            });
                                        }
                                    }
                                });
                            }

                            updateProcessed(idScheduler);

                            mt.setStatus(3);
                            messageTaskRepo.save(mt);

                            Optional<MessageReport> optionalMessageReport = messageReportRepo.findByMessageTaskIdAndBatch(mt.getId(), 1);
                            if (optionalMessageReport.isPresent()) {
                                logger.info("##################### Update send Count Once-Off :");
                                MessageReport messageReport = optionalMessageReport.get();
                                messageReport.setSendCount(messageReport.getSendCount() + sendCount.get());
                                messageReport.setSendDate(new Date());
                                messageReportRepo.save(messageReport);
                            }


                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }


            });
        }
    }


    @Scheduled(fixedDelay = 2000, initialDelay = 180001)//180000 780000
    public void immediateMessageTask() throws ParseException {
        //logger.info("Fixed Delay Task :: Execution Time - {immediateMessageTask} " + GeneralUtil.dateToStr(new Date(), "dd/MM/yyyy hh:mm:ss"));

        List<MessageTask> messageTasks = messageTaskRepo.findAllByMessageTypeAndStatus(GeneralConstant.IMMEDIATE_CODE);
        if (messageTasks != null && messageTasks.size() > 0) {
            logger.info("Fixed Delay Task :: Execution Time - {immediateMessageTask} " + GeneralUtil.dateToStr(new Date(), "dd/MM/yyyy hh:mm:ss"));
            messageTasks.forEach(messageTask -> {
                AtomicReference<String> contentMessage = new AtomicReference<>(messageTask.getContent());
                List<MessageAttributes> messageAttributes = messageAttributesRepo.findByMessageTaskAttrAndTypeEquals(messageTask, GeneralConstant.MESSAGE_ATTRIBUTE_TYPE);

                List<MessageReceiver> messageReceivers = messageReceiverRepo.findByMessageTaskReceiver(messageTask);

                AtomicReference<String> keyName = new AtomicReference<>();
                if (messageTask.getMessageFile() != null) {
                    keyName.set(messageTask.getMessageFile().getFileId());
                }


                AtomicInteger sendCount = new AtomicInteger();
                if (messageReceivers != null && messageReceivers.size() > 0) {


                    messageReceivers.forEach(mr -> {
                        if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINGLE_USER)) {
                            TelegramUser tu = telegramUserRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                            sendCount.getAndIncrement();


                            if (messageAttributes != null && messageAttributes.size() > 0) {
                                contentMessage.set(messageContentManipulation(messageAttributes, messageTask, tu.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER));
                            }

                            CoreHelper.messageTransfer.put(Long.parseLong(tu.getChatId()), new TransferMessageBean(messageTask.getId(), 1));
                            messageService.sendTelegram(new TelegramMessageBean(Long.parseLong(tu.getChatId()), contentMessage.get(), keyName.get()));
                        }

                        if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_USER)) {
                            //receiver group telegram user
                            TelegramUserGroup tug = telegramUserGroupRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                            List<MemberTelegramUserGroup> memberTelegramUserGroups = memberTelegramUserGroupRepo.findAllByUserGroup(tug);
                            if (memberTelegramUserGroups.size() > 0) {
                                memberTelegramUserGroups.stream().forEach(tu -> {
                                    sendCount.getAndIncrement();

                                    if (messageAttributes != null && messageAttributes.size() > 0) {
                                        contentMessage.set(messageContentManipulation(messageAttributes, messageTask, tu.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER));
                                    }

                                    CoreHelper.messageTransfer.put(Long.parseLong(tu.getTelegramUser().getChatId()), new TransferMessageBean(messageTask.getId(), 1));
                                    messageService.sendTelegram(new TelegramMessageBean(Long.parseLong(tu.getTelegramUser().getChatId()), contentMessage.get(), keyName.get()));
                                });
                            }
                        }

                        if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINLGE_CHATROOM)) {
                            //receiver chatroom telegram
                            ChatRoom ct = chatRoomRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                            sendCount.getAndIncrement();

                            if (messageAttributes != null && messageAttributes.size() > 0) {
                                contentMessage.set(messageContentManipulation(messageAttributes, messageTask, ct.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM));
                            }

                            CoreHelper.messageTransfer.put(ct.getChatId(), new TransferMessageBean(messageTask.getId(), 1));
                            messageService.sendTelegram(new TelegramMessageBean(ct.getChatId(), contentMessage.get(), keyName.get()));
                        }

                        if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_CHATROOM)) {
                            ChatRoomGroup crg = chatRoomGroupRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                            List<ChatRoomGroupMember> chatRoomGroupMembers = chatRoomGroupMemberRepo.findAllByChatRoomGroup(crg);

                            if (chatRoomGroupMembers.size() > 0) {
                                chatRoomGroupMembers.forEach(cgm -> {
                                    sendCount.getAndIncrement();

                                    if (messageAttributes != null && messageAttributes.size() > 0) {
                                        contentMessage.set(messageContentManipulation(messageAttributes, messageTask, cgm.getChatRoom().getChatId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM));
                                    }

                                    CoreHelper.messageTransfer.put(cgm.getChatRoom().getChatId(), new TransferMessageBean(messageTask.getId(), 1));
                                    messageService.sendTelegram(new TelegramMessageBean(cgm.getChatRoom().getChatId(), contentMessage.get(), keyName.get()));
                                });
                            }
                        }
                    });


                }

               /* if (messageAttributes != null && messageAttributes.size() > 0) {
                    sendMessageFromAttribute(messageAttributes, messageReceivers, messageTask, keyName.get(), 1);
                }*/

                messageTask.setStatus(3);
                messageTaskRepo.save(messageTask);

                Optional<MessageReport> optionalMessageReport = messageReportRepo.findByMessageTaskIdAndBatch(messageTask.getId(), 1);
                if (optionalMessageReport.isPresent()) {
                    logger.info("##################### Update send Count Immediate :" + sendCount.get());
                    MessageReport messageReport = optionalMessageReport.get();
                    messageReport.setSendCount(messageReport.getSendCount() + sendCount.get());
                    messageReport.setSendDate(new Date());
                    messageReportRepo.save(messageReport);
                }

            });
        }


    }

    @Scheduled(fixedDelay = 2000, initialDelay = 360009)
    private void attributeMessageTask() throws ParseException {
        Date executeDate = getExecuteDate(GeneralConstant.GROUP_KEY_RECURRING_ATTRIBUTE, GeneralConstant.KEY_PARAM_EXECUTE_DATE);

        List<AttributeRecurringTaskBean> attributeRecurringTaskBeanList = attributeTaskScheduleRepo.findAllByRecurringTypeAndStatusAndExecuteDate(executeDate);

        if (attributeRecurringTaskBeanList != null && attributeRecurringTaskBeanList.size() > 0) {
            attributeRecurringTaskBeanList.forEach(st -> {

                Date manDate = manipulateDate(st.getTimeExecute());
                logger.info("processRecurringTask manDate : " + manDate);
                Date compareDate = messageTaskRepo.getSysDate();
                logger.info("processRecurringTask compareDate : " + compareDate);

                String isProd = systemConfigurationRepo.findByGroupKeyAndKeyParam("ENV", "PROD").get().getValueParam();
                if (isProd.equals("TRUE")) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(compareDate);
                    calendar.add(Calendar.HOUR_OF_DAY, 6);
                    compareDate = calendar.getTime();
                }

                logger.info("processRecurringTask compareDate after : " + compareDate);


                logger.info("::: " + st.getTimeExecute() + " ::: " + manDate);
                try {
                    Date timeDate = GeneralUtil.strToDate(st.getTimeExecute(), "HH:mm:ss");
                    logger.info("::: timeExeDate ::: " + timeDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (manDate.before(compareDate) || manDate.compareTo(compareDate) == 0) {
                    updateProcessingAttrRecurring(st.getAttributeTaskId());
                    AtomicInteger sendCount = new AtomicInteger(0);
                    MessageTask messageTask = messageTaskRepo.findById(st.getMessageTaskId()).orElseThrow();

                    AtomicReference<String> keyName = new AtomicReference<>();
                    if (messageTask.getMessageFile() != null) {
                        keyName.set(messageTask.getMessageFile().getFileId());
                    }

                    AtomicReference<String> contentMessage = new AtomicReference<>(messageTask.getContent());
                    List<MessageAttributes> messageAttributes = messageAttributesRepo.findByMessageTaskAttrAndTypeEquals(messageTask, GeneralConstant.MESSAGE_ATTRIBUTE_TYPE);

                    if (st.getReceiverType().equals(GeneralConstant.RECEIVER_TYPE_SINGLE_USER) || st.getReceiverType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_USER)) {
                        TelegramUser tu = telegramUserRepo.findById(st.getIdRefReceiver()).orElseThrow();
                        if (messageAttributes != null && messageAttributes.size() > 0) {
                            contentMessage.set(messageContentManipulation(messageAttributes, messageTask, tu.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER));
                        }

                        sendCount.getAndIncrement();

                        CoreHelper.messageTransfer.put(Long.parseLong(tu.getChatId()), new TransferMessageBean(messageTask.getId(), st.getBatch()));
                        messageService.sendTelegram(new TelegramMessageBean(Long.parseLong(tu.getChatId()), contentMessage.get(), keyName.get()));

                    } else {
                        ChatRoom cr = chatRoomRepo.findById(st.getIdRefReceiver()).orElseThrow();
                        if (messageAttributes != null && messageAttributes.size() > 0) {
                            contentMessage.set(messageContentManipulation(messageAttributes, messageTask, cr.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM));
                        }

                        sendCount.getAndIncrement();

                        CoreHelper.messageTransfer.put(cr.getChatId(), new TransferMessageBean(messageTask.getId(), st.getBatch()));
                        messageService.sendTelegram(new TelegramMessageBean(cr.getChatId(), contentMessage.get(), keyName.get()));
                    }


                    /**-====*/
                    updateProcessedAttrRecurring(st.getAttributeTaskId());


                    if (messageTask.getRecurringEndDate().before(new Date())) {
                        messageTask.setStatus(3);
                        messageTaskRepo.save(messageTask);
                    }

                    Optional<MessageReport> optionalMessageReport = messageReportRepo.findByMessageTaskIdAndBatch(messageTask.getId(), 1);
                    if (optionalMessageReport.isPresent()) {
                        logger.info("##################### Update send Count Recurring :");
                        MessageReport messageReport = optionalMessageReport.get();
                        messageReport.setSendCount(messageReport.getSendCount() + sendCount.get());
                        messageReport.setSendDate(new Date());
                        messageReportRepo.save(messageReport);
                    }


                }
            });
        }

    }

    /**
     * =========
     */


    private void sendMessageFromAttribute(List<MessageAttributes> messageAttributes, List<MessageReceiver> messageReceivers, MessageTask messageTask, String keyName, int batch) {
        if (messageAttributes != null && messageAttributes.size() > 0) {
            List<Long> idRefReceiverUser = new ArrayList<>();
            List<Long> idRefReceiverChatroom = new ArrayList<>();

            List<Long> idRefAttributeUser = new ArrayList<>();
            List<Long> idRefAttributeChatRoom = new ArrayList<>();

            messageReceivers.stream().forEach(mr -> {
                if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINGLE_USER)) {
                    idRefReceiverUser.add(mr.getIdReferenceReceiver());
                } else if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINLGE_CHATROOM)) {
                    idRefReceiverChatroom.add(mr.getIdReferenceReceiver());
                }

                if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_USER)) {
                    Optional<TelegramUserGroup> optionalTelegramUserGroup = telegramUserGroupRepo.findById(mr.getIdReferenceReceiver());
                    if (optionalTelegramUserGroup.isPresent()) {
                        List<MemberTelegramUserGroup> memberTelegramUserGroups = memberTelegramUserGroupRepo.findAllByUserGroup(optionalTelegramUserGroup.get());
                        if (memberTelegramUserGroups != null && memberTelegramUserGroups.size() > 0) {
                            memberTelegramUserGroups.stream().forEach(mtg -> {
                                idRefReceiverUser.add(mtg.getTelegramUser().getId());
                            });
                        }
                    }
                }

                if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_CHATROOM)) {
                    Optional<ChatRoomGroup> optionalChatRoomGroup = chatRoomGroupRepo.findById(mr.getIdReferenceReceiver());
                    if (optionalChatRoomGroup.isPresent()) {
                        List<ChatRoomGroupMember> chatRoomGroupMembers = chatRoomGroupMemberRepo.findAllByChatRoomGroup(optionalChatRoomGroup.get());
                        if (chatRoomGroupMembers != null && chatRoomGroupMembers.size() > 0) {
                            chatRoomGroupMembers.stream().forEach(crg -> {
                                idRefReceiverChatroom.add(crg.getChatRoom().getId());
                            });
                        }
                    }
                }

            });


            messageAttributes.stream().forEach(ma -> {
                List<MemberAttribute> memberAttributes = memberAttributeRepo.findAllByAttribute(ma.getAttribute());
                if (memberAttributes != null && memberAttributes.size() > 0) {
                    memberAttributes.stream().forEach(mtr -> {
                        if (mtr.getContactType().equals(GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER)) {

                            Optional<Long> refUser = idRefAttributeUser.stream().filter(v1 -> v1.compareTo(mtr.getIdRefContact()) == 0).findFirst();

                            if (refUser.isEmpty()) {
                                idRefAttributeUser.add(mtr.getIdRefContact());
                            }

                        }

                        if (mtr.getContactType().equals(GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM)) {
                            idRefAttributeChatRoom.add(mtr.getIdRefContact());
                        }

                    });
                }
            });

            idRefAttributeUser.removeAll(idRefReceiverUser);
            idRefAttributeChatRoom.removeAll(idRefReceiverChatroom);

            AtomicInteger sendCount = new AtomicInteger();
            AtomicReference<String> contentMessage = new AtomicReference<>(messageTask.getContent());
            idRefAttributeUser.forEach(rau -> {
                sendCount.getAndIncrement();
                TelegramUser tu = telegramUserRepo.findById(rau).orElseThrow();


                if (messageAttributes != null && messageAttributes.size() > 0) {
                    //contentMessage.set(messageContentManipulation(messageAttributes, messageTask, tu.getId()));
                }

                CoreHelper.messageTransfer.put(Long.parseLong(tu.getChatId()), new TransferMessageBean(messageTask.getId(), batch));
                messageService.sendTelegram(new TelegramMessageBean(Long.parseLong(tu.getChatId()), contentMessage.get(), keyName));
            });


            MessageReport messageReport = messageReportRepo.findByMessageTaskIdAndBatch(messageTask.getId(), 1).orElseThrow();
            messageReport.setSendCount(messageReport.getSendCount() + sendCount.get());
            messageReportRepo.save(messageReport);
        }
    }

    private String messageContentManipulation(List<MessageAttributes> messageAttributes, MessageTask messageTask, long idRefFromMessageTask, String contactType) {
        AtomicReference<String> contentMessage = new AtomicReference<>(messageTask.getContent());
        if (messageAttributes != null && messageAttributes.size() > 0) {
            messageAttributes.stream().forEach(ma -> {
                Optional<MemberAttribute> optionalMemberAttribute = memberAttributeRepo.findByIdRefContactAndAttributeAndContactTypeEquals(idRefFromMessageTask, ma.getAttribute(), contactType);
                if (optionalMemberAttribute.isPresent()) {
                    String tmpContent = contentMessage.get().replaceAll(ma.getKeyAttribute(), optionalMemberAttribute.get().getAttributeValue());
                    contentMessage.getAndSet(tmpContent);
                }
            });
        }
        return contentMessage.get();
    }

    private Date getExecuteDate(String groupKey, String keyParam) throws ParseException {
        Optional<SystemConfiguration> optionalSystemConfiguration = systemConfigurationRepo.findByGroupKeyAndKeyParam(groupKey, keyParam);
        Date executeDate;

        if (optionalSystemConfiguration.isEmpty()) {
            executeDate = GeneralUtil.strToDate(GeneralUtil.dateToStr(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
        } else {
            if (optionalSystemConfiguration.get().getValueParam().equals(GeneralConstant.VALUE_PARAM_EXECUTE_DATE)) {
                executeDate = GeneralUtil.strToDate(GeneralUtil.dateToStr(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
            } else {
                executeDate = GeneralUtil.strToDate(optionalSystemConfiguration.get().getValueParam(), "yyyy-MM-dd");
            }
        }
        return executeDate;
    }

    private Date manipulateDate(String executeTime) {
        Date tmpDate = null;
        try {
            String strDate = GeneralUtil.dateToStr(new Date(), "dd-MM-yyyy");
            tmpDate = GeneralUtil.strToDate(strDate + " " + executeTime, "dd-MM-yyyy HH:mm:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tmpDate;
    }

    private void processRecurringTask(List<MessageRecurringTaskBean> messageRecurringTaskBeans, String executeTime) {
        if (messageRecurringTaskBeans != null && messageRecurringTaskBeans.size() > 0) {
            messageRecurringTaskBeans.forEach(st -> {

                Date manDate = manipulateDate(st.getTimeExecute());
                logger.info("processRecurringTask manDate : " + manDate);
                Date compareDate = messageTaskRepo.getSysDate();
                logger.info("processRecurringTask compareDate : " + compareDate);

                String isProd = systemConfigurationRepo.findByGroupKeyAndKeyParam("ENV", "PROD").get().getValueParam();
                if (isProd.equals("TRUE")) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(compareDate);
                    calendar.add(Calendar.HOUR_OF_DAY, 6);
                    compareDate = calendar.getTime();
                }

                logger.info("processRecurringTask compareDate after : " + compareDate);


                logger.info("::: " + st.getTimeExecute() + " :: " + executeTime + " ::: " + manDate);
                try {
                    Date timeDate = GeneralUtil.strToDate(st.getTimeExecute(), "HH:mm:ss");
                    logger.info("::: timeExeDate ::: " + timeDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (manDate.before(compareDate) || manDate.compareTo(compareDate) == 0) {
                    updateProcessing(st.getSchedulerTaskId());
                    AtomicInteger sendCount = new AtomicInteger();
                    MessageTask messageTask = messageTaskRepo.findById(st.getMessageTaskId()).orElseThrow();

                    AtomicReference<String> contentMessage = new AtomicReference<>(messageTask.getContent());
                    List<MessageAttributes> messageAttributes = messageAttributesRepo.findByMessageTaskAttrAndTypeEquals(messageTask, GeneralConstant.MESSAGE_ATTRIBUTE_TYPE);


                    synchronized (messageTask) {
                        List<MessageReceiver> messageReceivers = messageReceiverRepo.findByMessageTaskReceiver(messageTask);
                        if (messageReceivers != null && messageReceivers.size() > 0) {
                            AtomicReference<String> keyName = new AtomicReference<>();
                            if (messageTask.getMessageFile() != null) {
                                keyName.set(messageTask.getMessageFile().getFileId());
                            }

                            messageReceivers.forEach(mr -> {
                                if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINGLE_USER)) {
                                    TelegramUser tu = telegramUserRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();

                                    sendCount.getAndIncrement();

                                    if (messageAttributes != null && messageAttributes.size() > 0) {
                                        contentMessage.set(messageContentManipulation(messageAttributes, messageTask, tu.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER));
                                    }


                                    CoreHelper.messageTransfer.put(Long.parseLong(tu.getChatId()), new TransferMessageBean(messageTask.getId(), st.getBatch()));
                                    messageService.sendTelegram(new TelegramMessageBean(Long.parseLong(tu.getChatId()), contentMessage.get(), keyName.get()));
                                }

                                if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_USER)) {
                                    //receiver group telegram user
                                    TelegramUserGroup tug = telegramUserGroupRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                                    List<MemberTelegramUserGroup> memberTelegramUserGroups = memberTelegramUserGroupRepo.findAllByUserGroup(tug);
                                    if (memberTelegramUserGroups.size() > 0) {
                                        memberTelegramUserGroups.forEach(tu -> {
                                            sendCount.getAndIncrement();

                                            if (messageAttributes != null && messageAttributes.size() > 0) {
                                                contentMessage.set(messageContentManipulation(messageAttributes, messageTask, tu.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER));
                                            }

                                            CoreHelper.messageTransfer.put(Long.parseLong(tu.getTelegramUser().getChatId()), new TransferMessageBean(messageTask.getId(), st.getBatch()));
                                            messageService.sendTelegram(new TelegramMessageBean(Long.parseLong(tu.getTelegramUser().getChatId()), contentMessage.get(), keyName.get()));
                                        });
                                    }

                                }

                                if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINLGE_CHATROOM)) {
                                    //receiver chatroom telegram
                                    ChatRoom ct = chatRoomRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                                    sendCount.getAndIncrement();

                                    if (messageAttributes != null && messageAttributes.size() > 0) {
                                        contentMessage.set(messageContentManipulation(messageAttributes, messageTask, ct.getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM));
                                    }


                                    CoreHelper.messageTransfer.put(ct.getChatId(), new TransferMessageBean(messageTask.getId(), st.getBatch()));
                                    messageService.sendTelegram(new TelegramMessageBean(ct.getChatId(), contentMessage.get(), keyName.get()));

                                }

                                if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_CHATROOM)) {
                                    ChatRoomGroup cgr = chatRoomGroupRepo.findById(mr.getIdReferenceReceiver()).orElseThrow();
                                    List<ChatRoomGroupMember> chatRoomGroupMembers = chatRoomGroupMemberRepo.findAllByChatRoomGroup(cgr);

                                    if (chatRoomGroupMembers.size() > 0) {
                                        chatRoomGroupMembers.forEach(cgm -> {
                                            sendCount.getAndIncrement();

                                            if (messageAttributes != null && messageAttributes.size() > 0) {
                                                contentMessage.set(messageContentManipulation(messageAttributes, messageTask, cgm.getChatRoom().getId(), GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM));
                                            }

                                            CoreHelper.messageTransfer.put(cgm.getChatRoom().getChatId(), new TransferMessageBean(messageTask.getId(), st.getBatch()));
                                            messageService.sendTelegram(new TelegramMessageBean(cgm.getChatRoom().getChatId(), contentMessage.get(), keyName.get()));
                                        });
                                    }
                                }
                            });
                        }
                    }
                    updateProcessed(st.getSchedulerTaskId());


                    List<MessageTaskSchedule> messageTaskSchedules = messageTaskScheduleRepo.findByMessageTaskAndStatusEquals(messageTask, GeneralConstant.STATUS_QUEUE_MESSAGE_SCHEDULE);

                    if (messageTaskSchedules == null || messageTaskSchedules.size() < 1) {
                        messageTask.setStatus(3);
                        messageTaskRepo.save(messageTask);
                    }

                    Optional<MessageReport> optionalMessageReport = messageReportRepo.findByMessageTaskIdAndBatch(messageTask.getId(), st.getBatch());
                    if (optionalMessageReport.isPresent()) {
                        logger.info("##################### Update send Count Recurring :");
                        MessageReport messageReport = optionalMessageReport.get();
                        messageReport.setSendCount(messageReport.getSendCount() + sendCount.get());
                        messageReport.setSendDate(new Date());
                        messageReportRepo.save(messageReport);
                    }


                }
            });
        }
    }

    private void updateProcessed(long schedulerId) {
        MessageTaskSchedule messageTaskSchedule = messageTaskScheduleRepo.findById(schedulerId).orElseThrow();
        messageTaskSchedule.setStatus(GeneralConstant.STATUS_PROCESSED_MESSAGE_SCHEDULE);
        messageTaskSchedule.setRealEndExecuteDate(new Date());
        messageTaskScheduleRepo.save(messageTaskSchedule);
    }

    private void updateProcessing(long schedulerId) {
        MessageTaskSchedule messageTaskSchedule = messageTaskScheduleRepo.findById(schedulerId).orElseThrow();
        messageTaskSchedule.setStatus(GeneralConstant.STATUS_PROCESSING_MESSAGE_SCHEDULE);
        messageTaskSchedule.setRealStartExecuteDate(new Date());
        messageTaskScheduleRepo.save(messageTaskSchedule);
    }

    private void updateProcessingAttrRecurring(long schedulerId) {
        AttributeTaskSchedule attributeTaskSchedule = attributeTaskScheduleRepo.findById(schedulerId).orElseThrow();
        attributeTaskSchedule.setStatus(GeneralConstant.STATUS_PROCESSING_MESSAGE_SCHEDULE);
        attributeTaskSchedule.setRealStartExecuteDate(new Date());
        attributeTaskScheduleRepo.save(attributeTaskSchedule);
    }

    private void updateProcessedAttrRecurring(long schedulerId) {
        AttributeTaskSchedule attributeTaskSchedule = attributeTaskScheduleRepo.findById(schedulerId).orElseThrow();
        attributeTaskSchedule.setStatus(GeneralConstant.STATUS_PROCESSED_MESSAGE_SCHEDULE);
        attributeTaskSchedule.setRealStartExecuteDate(new Date());
        attributeTaskScheduleRepo.save(attributeTaskSchedule);
    }
}
