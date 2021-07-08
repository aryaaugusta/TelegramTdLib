package com.edts.tdlib.repository;

import com.edts.tdlib.model.message.MessageReceiver;
import com.edts.tdlib.model.message.MessageTask;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessageReceiverRepo extends CrudRepository<MessageReceiver, Long> {

    Optional<MessageReceiver> findByIdReferenceReceiverAndMessageTaskReceiver(long idReferenceReceiver, MessageTask messageTaskReceiver);

    List<MessageReceiver> findByMessageTaskReceiver(MessageTask messageTaskReceiver);

    List<MessageReceiver> findByMessageTaskReceiverAndType(MessageTask messageTaskReceiver, String type);

}
