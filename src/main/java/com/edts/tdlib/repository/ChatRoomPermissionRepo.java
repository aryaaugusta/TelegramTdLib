package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.ChatRoomPermission;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ChatRoomPermissionRepo extends CrudRepository<ChatRoomPermission, Long> {

    Optional<ChatRoomPermission> findByChatId(Long chatId);
}
