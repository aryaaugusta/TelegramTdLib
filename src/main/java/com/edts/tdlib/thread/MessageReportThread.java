package com.edts.tdlib.thread;


import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.model.message.MessageReport;
import com.edts.tdlib.repository.MessageReceiverRepo;
import com.edts.tdlib.repository.MessageReportRepo;
import com.edts.tdlib.repository.MessageTypeRepo;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class MessageReportThread {

    private final MessageReportRepo messageReportRepo;
    private final MessageReceiverRepo messageReceiverRepo;
    private final MessageTypeRepo messageTypeRepo;
    private final CommonMapper commonMapper;

    public MessageReportThread(MessageReportRepo messageReportRepo, MessageReceiverRepo messageReceiverRepo, MessageTypeRepo messageTypeRepo, CommonMapper commonMapper) {
        this.messageReportRepo = messageReportRepo;
        this.messageReceiverRepo = messageReceiverRepo;
        this.messageTypeRepo = messageTypeRepo;
        this.commonMapper = commonMapper;
    }


    public void updateSendMessage(long idMessageTask, int batch, long senderId) {
        MessageReport messageReport = messageReportRepo.findByMessageTaskIdAndBatch(idMessageTask, batch).orElseThrow();
        messageReport.setSender(String.valueOf(senderId));
        messageReport.setSendCount(messageReport.getSendCount() + 1);
        messageReportRepo.save(messageReport);
    }

}
