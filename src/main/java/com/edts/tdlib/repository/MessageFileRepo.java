package com.edts.tdlib.repository;

import com.edts.tdlib.model.message.MessageFile;
import org.springframework.data.repository.CrudRepository;

public interface MessageFileRepo extends CrudRepository<MessageFile, Long> {
}
