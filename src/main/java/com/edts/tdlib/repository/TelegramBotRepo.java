package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.TelegramBot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TelegramBotRepo extends CrudRepository<TelegramBot, Long> {


    Page<TelegramBot> findByDeletedEquals(boolean deleted, Pageable pageable);

    @Query("select t from TelegramBot t where concat(t.username,t.name) like %:name% and t.deleted = false")
    Page<TelegramBot> searchByParam(@Param("name") String name, Pageable pageable);


}
