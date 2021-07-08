package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.ChatRoom;
import com.edts.tdlib.model.message.MessageTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChatRoomRepo extends CrudRepository<ChatRoom, Long> {

    @Query("select bg from ChatRoom bg where bg.groupId = :groupId")
    Optional<ChatRoom> findByGroupId(@Param("groupId") int groupId);


    @Query("select cr from ChatRoom cr where cr.deleted = false")
    Page<ChatRoom> findAll(Pageable pageable);

    @Query("select cr from ChatRoom cr where cr.name like %:name%  and cr.deleted = false")
    Page<ChatRoom> findAllByNameGroup(@Param("name") String name, Pageable pageable);

    Optional<ChatRoom> findByChatId(long chatId);

}
