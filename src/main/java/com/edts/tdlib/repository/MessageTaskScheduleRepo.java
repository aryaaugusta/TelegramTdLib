package com.edts.tdlib.repository;

import com.edts.tdlib.bean.message.MessageRecurringTaskBean;
import com.edts.tdlib.model.message.MessageTask;
import com.edts.tdlib.model.message.MessageTaskSchedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MessageTaskScheduleRepo extends CrudRepository<MessageTaskSchedule, Long> {

    @Query(name = "findSchedulerTask", nativeQuery = true)
    List<MessageRecurringTaskBean> findAllByRecurringTypeAndStatusAndExecuteDate(@Param("recurringType") String recurringType, @Param("executeDate") Date executeDate);

    List<MessageTaskSchedule> findByMessageTask(MessageTask messageTask);

    List<MessageTaskSchedule> findByMessageTaskAndStatusEquals(MessageTask messageTask, String status);

}
