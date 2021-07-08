package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.ChatRoomGroup;
import com.edts.tdlib.model.contact.TelegramUserGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ChatRoomGroupRepo extends CrudRepository<ChatRoomGroup, Long> {

    @Query("select t from ChatRoomGroup t where t.deleted = false ")
    Page<ChatRoomGroup> findAll(Pageable pageable);

    @Query("select t from ChatRoomGroup t where t.name like  %:name% and t.deleted = false")
    Page<ChatRoomGroup> findAllByName(@Param("name") String name, Pageable pageable);

}
