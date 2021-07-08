package com.edts.tdlib.repository;

import com.edts.tdlib.bean.message.AttributeRecurringTaskBean;
import com.edts.tdlib.model.message.AttributeTaskSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AttributeTaskScheduleRepo extends CrudRepository<AttributeTaskSchedule, Long> {

    @Query(name = "findAttributeTask", nativeQuery = true)
    List<AttributeRecurringTaskBean> findAllByRecurringTypeAndStatusAndExecuteDate(@Param("executeDate") Date executeDate);

    Page<AttributeTaskSchedule> findByMessageTaskId(Long messageTaskId, Pageable pageable);

}
