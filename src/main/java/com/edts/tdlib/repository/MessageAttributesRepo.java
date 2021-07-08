package com.edts.tdlib.repository;

import com.edts.tdlib.model.message.MessageAttributes;
import com.edts.tdlib.model.message.MessageTask;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageAttributesRepo extends CrudRepository<MessageAttributes, Long> {

    List<MessageAttributes> findByMessageTaskAttrAndTypeEquals(MessageTask messageTask, int type);

}
