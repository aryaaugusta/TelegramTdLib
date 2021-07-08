package com.edts.tdlib.repository;

import com.edts.tdlib.model.message.MessageType;
import org.springframework.data.repository.CrudRepository;

public interface MessageTypeRepo extends CrudRepository<MessageType, Long> {
}
