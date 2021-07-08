package com.edts.tdlib.repository;

import com.edts.tdlib.model.message.MessageReport;
import com.edts.tdlib.model.message.MessageTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MessageReportRepo extends CrudRepository<MessageReport, Long> {


    Optional<MessageReport> findByMessageTaskIdAndBatch(long messageTaskId, int batch);


    @Query("select mrp from MessageReport mrp where mrp.type = :type and mrp.subject like %:subject%")
    Page<MessageReport> findAllBySubjectAndType(@Param("subject") String subject, @Param("type") String type, Pageable pageable);

    @Query("select mrp from MessageReport mrp")
    Page<MessageReport> findAllDefault(Pageable pageable);

    Page<MessageReport> findAllByType(String type, Pageable pageable);

    @Query("select mrp from MessageReport mrp where  mrp.subject like %:subject%")
    Page<MessageReport> findAllBySubject(@Param("subject") String subject, Pageable pageable);


    @Query("select mr from MessageReport mr where mr.messageTaskId = :messageTaskId order by mr.batch asc")
    List<MessageReport> findAllByMessageTaskId(@Param("messageTaskId") long messageTaskId);

    @Modifying
    @Query("update MessageReport r set r.sendCount = r.sendCount+1, r.sender = :sender  where r.messageTaskId = :messageTaskId and r.batch = :batch")
    void updateNewSend(@Param("messageTaskId") long messageTaskId, @Param("batch") int batch, @Param("sender") String sender);

}
