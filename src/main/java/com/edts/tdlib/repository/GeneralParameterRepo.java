package com.edts.tdlib.repository;

import com.edts.tdlib.model.GeneralParameter;
import org.springframework.data.repository.CrudRepository;

public interface GeneralParameterRepo extends CrudRepository<GeneralParameter, Long> {

    Iterable<GeneralParameter> findAllByGroupParam(String groupParam);
}
