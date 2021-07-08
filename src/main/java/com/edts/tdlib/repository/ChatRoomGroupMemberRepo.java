package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.ChatRoomGroup;
import com.edts.tdlib.model.contact.ChatRoomGroupMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomGroupMemberRepo extends CrudRepository<ChatRoomGroupMember, Long> {

    @Query("select cg from ChatRoomGroupMember cg where cg.chatRoom.id = :chatRoomId and cg.chatRoomGroup.id = :chatRoomGroupId")
    Optional<ChatRoomGroupMember> findByIdAndChatRoomGroupId(long chatRoomId, long chatRoomGroupId);

    List<ChatRoomGroupMember> findAllByChatRoomGroup(ChatRoomGroup chatRoomGroup);

}
