package com.edts.tdlib.messagebroker;

import com.edts.tdlib.bean.LoggerBean;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    /*private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }*/

    /**
     * Send exception logger to centralized exception services
     *
     * @param loggerBean {@link LoggerBean} data
     */
  /*  public void sendLogger(LoggerBean loggerBean) {
        String topic = TopicConstant.CREATE_LOGGER;
        String message = gson.toJson(loggerBean);
        sendMessage(topic, message);
    }*/

    /**
     * Send data to message broker
     *
     * @param topic   topic of message broker
     * @param message message data  of message broker
     */
   /* public void sendMessage(String topic, String message) {
        this.kafkaTemplate.send(topic, message);
    }*/
}
