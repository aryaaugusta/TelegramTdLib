package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.ChatRoomMemberPermission;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ChatRoomMemberPermissionRepo extends CrudRepository<ChatRoomMemberPermission, Long> {

    Optional<ChatRoomMemberPermission> findByChatIdAndTelegramUserId(long chatId, int telegramUserId);
}
