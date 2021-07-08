package com.edts.tdlib.service;

import com.edts.tdlib.bean.MessageReportReceiverBean;
import com.edts.tdlib.bean.StatisticDataBean;
import com.edts.tdlib.bean.message.*;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.mapper.ContactMapper;
import com.edts.tdlib.mapper.MessageFileMapper;
import com.edts.tdlib.mapper.MessageTypeMapper;
import com.edts.tdlib.model.contact.ChatRoom;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.model.message.*;
import com.edts.tdlib.repository.*;
import com.edts.tdlib.util.GeneralUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MessageReportService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MessageReportRepo messageReportRepo;
    private final MessageReceiverRepo messageReceiverRepo;
    private final MessageTypeRepo messageTypeRepo;
    private final CommonMapper commonMapper;
    private final MessageTaskRepo messageTaskRepo;
    private final ContactMapper contactMapper;
    private final MessageFileMapper messageFileMapper;
    private final MessageTypeMapper messageTypeMapper;
    private final TelegramMessageRepo telegramMessageRepo;
    private final TelegramUserRepo telegramUserRepo;
    private final ChatRoomRepo chatRoomRepo;
    private final AttributeTaskScheduleRepo attributeTaskScheduleRepo;

    public MessageReportService(MessageReportRepo messageReportRepo, MessageReceiverRepo messageReceiverRepo, MessageTypeRepo messageTypeRepo, CommonMapper commonMapper, MessageTaskRepo messageTaskRepo,
                                ContactMapper contactMapper, MessageFileMapper messageFileMapper, MessageTypeMapper messageTypeMapper, TelegramMessageRepo telegramMessageRepo,
                                TelegramUserRepo telegramUserRepo, ChatRoomRepo chatRoomRepo, AttributeTaskScheduleRepo attributeTaskScheduleRepo) {
        this.messageReportRepo = messageReportRepo;
        this.messageReceiverRepo = messageReceiverRepo;
        this.messageTypeRepo = messageTypeRepo;
        this.commonMapper = commonMapper;
        this.messageTaskRepo = messageTaskRepo;
        this.contactMapper = contactMapper;
        this.messageFileMapper = messageFileMapper;
        this.messageTypeMapper = messageTypeMapper;
        this.telegramMessageRepo = telegramMessageRepo;
        this.telegramUserRepo = telegramUserRepo;
        this.chatRoomRepo = chatRoomRepo;
        this.attributeTaskScheduleRepo = attributeTaskScheduleRepo;
    }


    public void save(MessageTask messageTask, Date sendDate, int batch) {
        MessageReport messageReport = new MessageReport();
        messageReport.setMessageTaskId(messageTask.getId());
        messageReport.setSubject(messageTask.getSubject());
        messageReport.setSendDate(sendDate);
        MessageType messageType = messageTypeRepo.findById(messageTask.getMessageType().getId()).orElseThrow();
        messageReport.setType(messageType.getName());
        List<MessageReceiver> receiverList = messageReceiverRepo.findByMessageTaskReceiver(messageTask);
        List<String> receivers = new ArrayList<>();
        receiverList.parallelStream().forEach(r -> {
            receivers.add(r.getNameReceiver());
        });
        messageReport.setReceiver(String.join(",", receivers));
        messageReport.setBatch(batch);

        messageReportRepo.save(messageReport);

    }

    public void updateSendMessage(long idMessageTask, int batch, long senderId) {
        MessageReport messageReport = messageReportRepo.findByMessageTaskIdAndBatch(idMessageTask, batch).orElseThrow();
        messageReport.setSender(String.valueOf(senderId));
        messageReportRepo.save(messageReport);
    }

    public void updateDeliverMessage(long idMessageTask, int batch, long senderId) {
        MessageTask messageTask = messageTaskRepo.findById(idMessageTask).orElseThrow();

        if (messageTask.getRecurringType() != null && messageTask.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_ATTRIBUTE)) {
            Optional<MessageReport> optionalMessageReport = messageReportRepo.findByMessageTaskIdAndBatch(idMessageTask, 1);
            if (optionalMessageReport.isPresent()) {
                MessageReport messageReport = optionalMessageReport.get();
                messageReport.setDeliverCount(messageReport.getDeliverCount() + 1);
                messageReport.setSender(String.valueOf(senderId));
                messageReportRepo.save(messageReport);
            }

        } else {
            Optional<MessageReport> optionalMessageReport = messageReportRepo.findByMessageTaskIdAndBatch(idMessageTask, batch);
            if (optionalMessageReport.isPresent()) {
                MessageReport messageReport = optionalMessageReport.get();
                messageReport.setDeliverCount(messageReport.getDeliverCount() + 1);
                messageReport.setSender(String.valueOf(senderId));
                messageReportRepo.save(messageReport);
            }
        }


    }

    public void updateReadMessage(long idMessageTask, int batch) {
        MessageTask messageTask = messageTaskRepo.findById(idMessageTask).orElseThrow();

        if (messageTask.getRecurringType() != null && messageTask.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_ATTRIBUTE)) {
            Optional<MessageReport> optionalMessageReport = messageReportRepo.findByMessageTaskIdAndBatch(idMessageTask, 1);
            if (optionalMessageReport.isPresent()) {
                MessageReport messageReport = optionalMessageReport.get();
                messageReport.setReadCount(messageReport.getReadCount() + 1);
                messageReportRepo.save(messageReport);
            }
        } else {
            Optional<MessageReport> optionalMessageReport = messageReportRepo.findByMessageTaskIdAndBatch(idMessageTask, batch);
            if (optionalMessageReport.isPresent()) {
                MessageReport messageReport = optionalMessageReport.get();
                messageReport.setReadCount(messageReport.getReadCount() + 1);
                messageReportRepo.save(messageReport);
            }
        }


    }


    public Page<MessageReportBean> getMessagesReport(String subject, String type, Pageable pageable) {
        Page<MessageReport> messageReportPage;
        if (subject != null && type != null) {
            messageReportPage = messageReportRepo.findAllBySubjectAndType(subject, type, pageable);
        } else if (subject == null && type != null) {
            messageReportPage = messageReportRepo.findAllByType(type, pageable);
        } else if (subject != null && type == null) {
            messageReportPage = messageReportRepo.findAllBySubject(subject, pageable);
        } else {
            messageReportPage = messageReportRepo.findAllDefault(pageable);
        }

        Page<MessageReportBean> messageReportBeans = commonMapper.mapEntityPageIntoDtoPage(messageReportPage, MessageReportBean.class);
        return messageReportBeans;
    }

    public List<MessageReportBean> findAllByMessageTaskId(long messageTaskId) {
        List<MessageReport> messageReports = messageReportRepo.findAllByMessageTaskId(messageTaskId);
        return commonMapper.mapList(messageReports, MessageReportBean.class);
    }

    public Map<String, Object> reportDetail(long idMessageTask, int batch) throws ParseException {
        MessageTask messageTask = messageTaskRepo.findById(idMessageTask).orElseThrow(EntityNotFoundException::new);

        Map<String, Object> objectMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        if (messageTask.getMessageType().getCode().equals(GeneralConstant.IMMEDIATE_CODE)) {
            objectMap = getMessageTaskImmediate(messageTask);
        } else if (messageTask.getMessageType().getCode().equals(GeneralConstant.ONCE_OFF_CODE)) {
            objectMap = getMessageTaskOnceOff(messageTask);
        } else if (messageTask.getMessageType().getCode().equals(GeneralConstant.RECURRING_CODE)) {
            objectMap = getMessageRecurring(messageTask);
        }

        Optional<MessageReport> optionalMessageReport = messageReportRepo.findByMessageTaskIdAndBatch(idMessageTask, batch);
        StatisticDataBean statisticDataBean = new StatisticDataBean();
        double sendCountPercentage = 0;
        double deliverCountPercentage = 0;
        double readCountPercentage = 0;
        double engagementRatePercentage = 0;

        int notDeliverCount = 0;
        int notReadCount = 0;

        double notDeliverPercentage = 0;
        double notReadPercentage = 0;


        if (optionalMessageReport.isPresent()) {
            MessageReport messageReport = optionalMessageReport.get();

            if (messageReport.getSendCount() > 0) {
                sendCountPercentage = 100;
                deliverCountPercentage = ((double) messageReport.getDeliverCount() / (double) messageReport.getSendCount()) * 100;
                readCountPercentage = ((double) messageReport.getReadCount() / (double) messageReport.getSendCount()) * 100;
                engagementRatePercentage = ((double) messageReport.getReadCount() / (double) messageReport.getDeliverCount()) * 100;

                notDeliverCount = messageReport.getSendCount() - messageReport.getDeliverCount();
                notReadCount = messageReport.getDeliverCount() - messageReport.getReadCount();
            }

            if (messageReport.getDeliverCount() > 0) {
                notDeliverPercentage = ((double) notDeliverCount / (double) messageReport.getDeliverCount()) * 100;
            }

            if (messageReport.getReadCount() > 0) {
                double r = (double) messageReport.getReadCount();
                notReadPercentage = ((double) notReadCount / r) * 100;
            }


            statisticDataBean = new StatisticDataBean(messageReport.getSendCount(), messageReport.getDeliverCount(), messageReport.getReadCount(), notDeliverCount, notReadCount, notDeliverPercentage, notReadPercentage, sendCountPercentage, deliverCountPercentage
                    , readCountPercentage, engagementRatePercentage);
        }


        objectMap.put("statisticData", statisticDataBean);

        return objectMap;
    }


    public Page<MessageReportReceiverBean> recipientList(long idMessageTask, int batch, String name, String status, Pageable pageable) {
        List<MessageReportReceiverBean> messageReportReceiverBeans = new ArrayList<>();

        Page<TelegramMessage> telegramMessagePage;
        Page<AttributeTaskSchedule> attributeTaskSchedulePage;

        MessageTask messageTask = messageTaskRepo.findById(idMessageTask).orElseThrow();


        long totalElement = 0;
        Pageable pageable1 = null;

        StringBuilder stringBuilder = new StringBuilder();
        if (pageable.getSort().isSorted()) {
            Sort sort = pageable.getSort();
            sort.stream().forEach(s -> {
                stringBuilder.append(s.toString());
            });
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        }
        String manSort[] = stringBuilder.toString().split(":");


        if (messageTask.getRecurringType() != null && messageTask.getRecurringType().equals(GeneralConstant.RECURRING_TYPE_ATTRIBUTE)) {
            attributeTaskSchedulePage = attributeTaskScheduleRepo.findByMessageTaskId(idMessageTask, pageable);
            if (attributeTaskSchedulePage.getSize() > 0) {
                attributeTaskSchedulePage.getContent().forEach(at -> {
                    long chatId = 0;
                    Optional<TelegramUser> telegramUser = telegramUserRepo.findById(at.getIdRefReceiver());
                    String fullName = null;
                    String statusMessage = null;
                    if (telegramUser.isPresent()) {
                        chatId = Long.parseLong(telegramUser.get().getChatId());
                        fullName = telegramUser.get().getFirstName() + " " + telegramUser.get().getLastName();
                    } else {
                        Optional<ChatRoom> optionalChatRoom = chatRoomRepo.findById(at.getIdRefReceiver());
                        if (optionalChatRoom.isPresent()) {
                            chatId = optionalChatRoom.get().getChatId();
                            fullName = optionalChatRoom.get().getName();
                        }
                    }

                    Date sendDate = null;
                    if (at.getStatus().equals(GeneralConstant.STATUS_PROCESSED_MESSAGE_SCHEDULE)) {
                        Optional<TelegramMessage> optionalTelegramMessage = telegramMessageRepo.findByChatIdAndMessageTaskIdAndBatchAndMessageIdSuccessGreaterThan(chatId, idMessageTask, at.getBatch(), 0l);
                        if (optionalTelegramMessage.isPresent()) {
                            TelegramMessage tm = optionalTelegramMessage.get();
                            if (!tm.isMessageDelivered() && !tm.isMessageRead()) {
                                statusMessage = "Sent";
                            } else if (tm.isMessageDelivered() && !tm.isMessageRead()) {
                                statusMessage = "Delivered";
                            } else if (tm.isMessageDelivered() && tm.isMessageRead()) {
                                statusMessage = "Read";
                            }
                            sendDate = tm.getCreatedDate();
                        }
                    } else {
                        statusMessage = "Waiting";
                    }


                    MessageReportReceiverBean messageReportReceiverBean = null;

                    if (name != null && status == null) {
                        if (fullName.toUpperCase(Locale.ROOT).contains(name.toUpperCase())) {
                            messageReportReceiverBean = new MessageReportReceiverBean(fullName, statusMessage, sendDate);
                            messageReportReceiverBeans.add(messageReportReceiverBean);
                        }
                    } else if (name == null && status != null) {
                        if (statusMessage.toUpperCase(Locale.ROOT).contains(status.toUpperCase())) {
                            messageReportReceiverBean = new MessageReportReceiverBean(fullName, statusMessage, sendDate);
                            messageReportReceiverBeans.add(messageReportReceiverBean);
                        }
                    } else if (name != null && status != null) {
                        if (fullName.toUpperCase(Locale.ROOT).contains(name.toUpperCase()) && statusMessage.toUpperCase(Locale.ROOT).contains(status.toUpperCase())) {
                            messageReportReceiverBean = new MessageReportReceiverBean(fullName, statusMessage, sendDate);
                            messageReportReceiverBeans.add(messageReportReceiverBean);
                        }
                    } else {
                        messageReportReceiverBean = new MessageReportReceiverBean(fullName, statusMessage, sendDate);
                        messageReportReceiverBeans.add(messageReportReceiverBean);
                    }
                });
            }

            totalElement = attributeTaskSchedulePage.getTotalElements();
            if (name != null || status != null) {
                totalElement = messageReportReceiverBeans.size();
            }

            pageable1 = attributeTaskSchedulePage.getPageable();

        } else {
            telegramMessagePage = telegramMessageRepo.findAllByMessageTaskIdAndBatch(idMessageTask, batch, pageable);

            if (telegramMessagePage.getSize() > 0) {
                telegramMessagePage.getContent().forEach(tm -> {
                    Optional<TelegramUser> telegramUser = telegramUserRepo.findOneByChatId(String.valueOf(tm.getChatId()));
                    String fullName = null;
                    String statusMessage = null;
                    if (telegramUser.isPresent()) {
                        fullName = telegramUser.get().getFirstName() + " " + telegramUser.get().getLastName();
                    } else {
                        Optional<ChatRoom> optionalChatRoom = chatRoomRepo.findByChatId(tm.getChatId());
                        if (optionalChatRoom.isPresent()) {
                            fullName = optionalChatRoom.get().getName();
                        }
                    }


                    if (!tm.isMessageDelivered() && !tm.isMessageRead()) {
                        statusMessage = "Sent";
                    } else if (tm.isMessageDelivered() && !tm.isMessageRead()) {
                        statusMessage = "Delivered";
                    } else if (tm.isMessageDelivered() && tm.isMessageRead()) {
                        statusMessage = "Read";
                    }

                    MessageReportReceiverBean messageReportReceiverBean = null;

                    if (name != null && status == null) {
                        if (fullName.toUpperCase(Locale.ROOT).contains(name.toUpperCase())) {
                            messageReportReceiverBean = new MessageReportReceiverBean(fullName, statusMessage, tm.getCreatedDate());
                            messageReportReceiverBeans.add(messageReportReceiverBean);
                        }
                    } else if (name == null && status != null) {
                        if (statusMessage.toUpperCase(Locale.ROOT).contains(status.toUpperCase())) {
                            messageReportReceiverBean = new MessageReportReceiverBean(fullName, statusMessage, tm.getCreatedDate());
                            messageReportReceiverBeans.add(messageReportReceiverBean);
                        }
                    } else if (name != null && status != null) {
                        if (fullName.toUpperCase(Locale.ROOT).contains(name.toUpperCase()) && statusMessage.toUpperCase(Locale.ROOT).contains(status.toUpperCase())) {
                            messageReportReceiverBean = new MessageReportReceiverBean(fullName, statusMessage, tm.getCreatedDate());
                            messageReportReceiverBeans.add(messageReportReceiverBean);
                        }
                    } else {
                        messageReportReceiverBean = new MessageReportReceiverBean(fullName, statusMessage, tm.getCreatedDate());
                        messageReportReceiverBeans.add(messageReportReceiverBean);
                    }
                });
            }

            totalElement = telegramMessagePage.getTotalElements();
            if (name != null || status != null) {
                totalElement = messageReportReceiverBeans.size();
            }

            pageable1 = telegramMessagePage.getPageable();
        }


        if (manSort.length > 1) {
            String sortBy = manSort[0].trim();
            String asc = manSort[1].trim();
            if (sortBy.equals("name")) {
                if (asc.equals("ASC")) {
                    Collections.sort(messageReportReceiverBeans, MessageReportReceiverBean.NameComparatorASC);
                } else {
                    Collections.sort(messageReportReceiverBeans, MessageReportReceiverBean.NameComparatorDESC);
                }
            } else if (sortBy.equals("status")) {
                if (asc.equals("ASC")) {
                    Collections.sort(messageReportReceiverBeans, MessageReportReceiverBean.StatusComparatorASC);
                } else {
                    Collections.sort(messageReportReceiverBeans, MessageReportReceiverBean.StatusComparatorDESC);
                }
            }

        }


        return new PageImpl<>(messageReportReceiverBeans, pageable1, totalElement);
    }


    /***/
    private Map<String, Object> getMessageTaskImmediate(MessageTask messageTask) {
        Map<String, Object> objectMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        ViewMessageTaskBean viewMessageTaskBean = contactMapper.toReceiverView(messageTask);

        ViewImmediateMessageBean viewImmediateMessageBean = contactMapper.toViewImmediateMessageBean(messageTask, viewMessageTaskBean);

        viewImmediateMessageBean.setMessageFileBean(messageFileMapper.toBean(messageTask.getMessageFile()));
        viewImmediateMessageBean.setMessageTypeBean(messageTypeMapper.toDto(messageTask.getMessageType()));

        objectMap = objectMapper.convertValue(viewImmediateMessageBean, Map.class);


        return objectMap;
    }


    private Map<String, Object> getMessageTaskOnceOff(MessageTask messageTask) {
        Map<String, Object> objectMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        ViewMessageTaskBean viewMessageTaskBean = contactMapper.toReceiverView(messageTask);

        ViewOnceOffMessgeBean viewOnceOffMessgeBean = contactMapper.toViewOnceOffMessgeBean(messageTask, viewMessageTaskBean);

        viewOnceOffMessgeBean.setMessageFileBean(messageFileMapper.toBean(messageTask.getMessageFile()));
        viewOnceOffMessgeBean.setMessageTypeBean(messageTypeMapper.toDto(messageTask.getMessageType()));


        objectMap = objectMapper.convertValue(viewOnceOffMessgeBean, Map.class);


        return objectMap;
    }

    private Map<String, Object> getMessageRecurring(MessageTask messageTask) throws ParseException {
        Map<String, Object> objectMap = new HashMap<>();
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


        objectMap = objectMapper.convertValue(viewRecurringMessageBean, Map.class);


        return objectMap;
    }
}
