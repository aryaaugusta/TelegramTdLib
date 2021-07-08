package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.Attribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AttributeRepo extends CrudRepository<Attribute, Long> {


    Page<Attribute> findByDeletedEquals(boolean deleted, Pageable pageable);

    @Query("select a from Attribute a where a.name like %:name%  and a.deleted=false ")
    Page<Attribute> findByNameAndDeletedEquals(@Param("name") String name, Pageable pageable);

    Page<Attribute> findByDataTypeAndDeletedEquals(String dataType, boolean deleted, Pageable pageable);

    @Query("select a from Attribute a where a.dataType = :dataType and a.name like %:name% and a.deleted = false")
    Page<Attribute> findByNameAndDataTypeAndDeletedEquals(String name, String dataType, Pageable pageable);

    Optional<Attribute> findByNameAndDeletedEquals(String name, boolean deleted);
}
