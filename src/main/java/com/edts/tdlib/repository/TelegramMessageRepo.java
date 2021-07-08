package com.edts.tdlib.repository;

import com.edts.tdlib.bean.MessageReportReceiverBean;
import com.edts.tdlib.bean.message.MessageRecurringTaskBean;
import com.edts.tdlib.model.message.TelegramMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TelegramMessageRepo extends CrudRepository<TelegramMessage, Long> {

    Optional<TelegramMessage> findByMessageId(long messageId);

    Optional<TelegramMessage> findByChatIdAndMessageId(long chatId, long messageId);

    Optional<TelegramMessage> findByChatIdAndMessageIdSuccess(long chatId, long messageIdSuccess);

    @Query("select tm from TelegramMessage tm where tm.chatId = :chatId and tm.senderUserId = :senderUserId and tm.messageRead = false")
    List<TelegramMessage> findAllByChatIdAndSenderUserId(@Param("chatId") long chatId, @Param("senderUserId") long senderUserId);

    List<TelegramMessage> findAllByMessageTaskIdAndBatch(long messageTaskId, int batch);

    @Query("select tm from TelegramMessage tm where tm.messageTaskId = :messageTaskId and tm.batch = :batch and tm.messageIdSuccess > 0")
    Page<TelegramMessage> findAllByMessageTaskIdAndBatch(@Param("messageTaskId") long messageTaskId, @Param("batch") int batch, Pageable pageable);


    @Query(name = "recipientList", nativeQuery = true)
    Page<MessageReportReceiverBean> findAllReceiverByMessageTaskAndBatch(@Param("messageTaskId") long messageTaskId, @Param("batch") int batch, Pageable pageable);


    Optional<TelegramMessage> findByChatIdAndMessageTaskIdAndBatchAndMessageIdSuccessGreaterThan(Long chatId, Long MessageTaskId, int Batch, Long MessageIdSuccess);
}
