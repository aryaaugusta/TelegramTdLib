package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.Attribute;
import com.edts.tdlib.model.contact.MemberAttribute;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MemberAttributeRepo extends CrudRepository<MemberAttribute, Long> {

    Optional<MemberAttribute> findByIdRefContactAndAttributeAndContactTypeEquals(long idRefContact, Attribute attribute, String contactType);

    List<MemberAttribute> findAllByAttribute(Attribute attribute);
}
