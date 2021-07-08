package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.ChatRoom;
import com.edts.tdlib.model.message.MessageTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MessageTaskRepo extends CrudRepository<MessageTask, Long> {

    List<MessageTask> findAllByOnceOffDateAndStatusEquals(Date onceOffDate, int status);

    @Query("select mt from MessageTask mt where mt.messageType.code = :messageType and mt.status = 1")
    List<MessageTask> findAllByMessageTypeAndStatus(@Param("messageType") String messageType);

    @Query("select mt from MessageTask mt order by mt.createdDate desc")
    Page<MessageTask> findAllDefault(Pageable pageable);

    @Query("select mt from MessageTask mt where mt.deleted = false")
    Page<MessageTask> findAll(Pageable pageable);

    @Query("select mt from MessageTask mt where mt.subject like %:subject%  and mt.deleted = false")
    Page<MessageTask> findAllBySubject(@Param("subject") String subject, Pageable pageable);

    @Query("select mt from MessageTask mt where mt.messageType.name = :messageType and mt.deleted = false")
    Page<MessageTask> findAllByMessageType(@Param("messageType") String messageType, Pageable pageable);

    @Query("select mt from MessageTask mt where mt.status = :status and mt.deleted = false")
    Page<MessageTask> findAllByStatusEquals(@Param("status") Integer status, Pageable pageable);

    @Query("select mt from MessageTask mt where mt.messageType.name = :messageType and mt.status = :status and mt.deleted = false")
    Page<MessageTask> findAllByMessageTypeStatusEquals(@Param("messageType") String messageType, @Param("status") Integer status, Pageable pageable);

    @Query("select mt from MessageTask mt where mt.subject like %:subject% and mt.messageType.name = :messageType and mt.deleted = false")
    Page<MessageTask> findAllBySubjectAndMessageType(@Param("subject") String subject, @Param("messageType") String messageType, Pageable pageable);

    @Query("select mt from MessageTask mt where mt.subject like %:subject% and mt.status = :status and mt.deleted = false")
    Page<MessageTask> findAllBySubjectAndStatus(@Param("subject") String subject, @Param("status") Integer status, Pageable pageable);

    @Query("select mt from MessageTask mt where mt.subject like %:subject% and mt.messageType.name = :messageType and mt.status = :status and mt.deleted = false ")
    Page<MessageTask> findAllBySubjectAndMessageTypeAndStatus(@Param("subject") String subject, @Param("messageType") String messageType, @Param("status") Integer status, Pageable pageable);

    @Query(value = "select sysdate() from dual", nativeQuery = true)
    Date getSysDate();

    List<MessageTask> findAllByRecurringTypeAndStatusEquals(String recurringType, int status);

}
