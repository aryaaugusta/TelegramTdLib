package com.edts.tdlib.repository.uam;

import com.edts.tdlib.model.uam.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByIdAndStatusEquals(long id, int status);
    Page<User> findUsersByUsernameContainingAndRoleIdAndStatusEquals(String username, long roleId, int status, Pageable pageable);
    Page<User> findUsersByRoleIdAndStatusEquals(long roleId, int status, Pageable pageable);
    Page<User> findUsersByUsernameContainingAndStatusEquals(String username, int status, Pageable pageable);
    Page<User> findUserByStatusEquals(int status, Pageable pageable);
    List<User> findUsersByRoleId(long roleId);
    Integer countByRoleId(long id);
    Boolean existsByUsernameOrEmail(String username, String email);


    @Query("select u from User u where concat(u.firstName, u.lastName) like %:name% and u.role.id = :roleId and u.status != :status")
    Page<User> findUsersByNameContainingAndRoleIdAndStatusNotEquals(@Param("name")String  name, @Param("roleId") long roleId, @Param("status") int status, Pageable pageable);

    @Query("select u from User u where concat(u.firstName, u.lastName) like %:name%   and u.status != :status")
    Page<User> findUsersByNameContainingAndStatusNotEquals(@Param("name")String  name,  int status, Pageable pageable);

    @Query("select u from User u where  u.status != :status")
    Page<User> findUserByStatusNotEquals(int status, Pageable pageable);

    @Query("select u from User u where u.id = :id and status != 0")
    Optional<User> findByIdAndStatusNotEquals(@Param("id") long id);

    @Query("select u from User u where u.role.id = :roleId and status != 0")
    Page<User> findUsersByRoleIdAndStatusNotEquals(@Param("roleId") long roleId, Pageable pageable);


}
