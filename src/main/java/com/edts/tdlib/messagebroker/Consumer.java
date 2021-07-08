package com.edts.tdlib.messagebroker;

import com.edts.tdlib.bean.LoggerBean;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.constant.TopicConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    private final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    private final Producer producer;
    private final CommonMapper commonMapper;

    @Autowired
    public Consumer(Producer producer, CommonMapper commonMapper) {
        this.producer = producer;
        this.commonMapper = commonMapper;
    }

    /**
     * Consume and process {@link TopicConstant#CREATE_SMS} data
     *
     * @param message data from {@link TopicConstant#CREATE_SMS} topic
     */
//    @KafkaListener(topics = TopicConstant.CREATE_SMS)
//    public void createSms(String message) {
//        try {
////            logger.info("received from create sms topic {}", message);
////            SmsBean smsBean = gson.fromJson(message, SmsBean.class);
////            smsService.sendSms(smsBean);
//        } catch (Exception ex) {
//            handleMessageBrokerErrorMessage(TopicConstant.CREATE_SMS, message, ex);
//        }
//    }

//    /**
//     * Consume and process {@link TopicConstant#ADD_TRANSACTION} data
//     *
//     * @param message data from {@link TopicConstant#ADD_TRANSACTION} topic
//     */
//    //@KafkaListener(topics = TopicConstant.ADD_TRANSACTION)
//    public void addTransaction(String message) {
//        try {
//            logger.info("received from add-transaction topic {}", message);
//           // transactionService.doAddTransaction(message);
//        } catch (Exception ex) {
//            handleMessageBrokerErrorMessage(TopicConstant.ADD_TRANSACTION, message, ex);
//        }
//    }

    /**
     * Handle error massage from exception.
     * Will send message to {@link Producer#sendLogger(LoggerBean)} with message-broker's data details
     *
     * @param topic        topic of message broker
     * @param topicMessage consumed data of message broker
     * @param ex           Exception
     */
   /* private void handleMessageBrokerErrorMessage(String topic, String topicMessage, Exception ex) {
        logger.error("Failed to process consumer, with topic : [{}], message : [{}]", topic, topicMessage, ex);
        LoggerBean loggerBean = commonMapper.toMessageBrokerLoggerBean(topic, topicMessage, ex);
        producer.sendLogger(loggerBean);
    }*/

}
