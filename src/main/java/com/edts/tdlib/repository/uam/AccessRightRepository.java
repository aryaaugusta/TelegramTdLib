package com.edts.tdlib.repository.uam;

import com.edts.tdlib.model.uam.AccessRight;
import org.springframework.data.repository.CrudRepository;

public interface AccessRightRepository extends CrudRepository<AccessRight, Long> {
    void deleteAccessRightsByRoleId(long id);
}
