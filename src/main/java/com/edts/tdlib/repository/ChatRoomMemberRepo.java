package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.ChatRoom;
import com.edts.tdlib.model.contact.ChatRoomMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatRoomMemberRepo extends CrudRepository<ChatRoomMember, Long> {

    Optional<ChatRoomMember> findOneByUserTelegramIdAndChatRoom(String userTelegramId, ChatRoom chatRoom);

    @Query(value = "select c.* from chat_room_member c where c.chat_room_id = :chatRoomId limit  1", nativeQuery = true)
    Optional<ChatRoomMember> findByChatRoom(@Param("chatRoomId") long  chatRoomId);


}
