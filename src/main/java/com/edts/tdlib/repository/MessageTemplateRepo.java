package com.edts.tdlib.repository;

import com.edts.tdlib.model.message.MessageTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MessageTemplateRepo extends CrudRepository<MessageTemplate, Long> {

    @Query("select t from MessageTemplate t where t.deleted = false")
    Page<MessageTemplate> findAll(Pageable pageable);

    @Query("select t from MessageTemplate t where t.title like %:title%  and  t.deleted = false")
    Page<MessageTemplate> findAllByTitle(@Param("title")String title , Pageable pageable);

}
