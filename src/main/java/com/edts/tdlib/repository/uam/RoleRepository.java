package com.edts.tdlib.repository.uam;

import com.edts.tdlib.model.uam.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository  extends JpaRepository<Role, Long> {

    @Query(value = "select r.id as roleId,count(u.id) as userCount from role r inner join user u on r.id = u.role_id group by r.id;", nativeQuery = true)
    List<IUserCountByRole> getUserCountGroupByRole();

    @Query(value = "select distinct r from Role r inner join User u on r.id = u.role.id")
    List<Role> findAllRolesAssignedToUser();
}
