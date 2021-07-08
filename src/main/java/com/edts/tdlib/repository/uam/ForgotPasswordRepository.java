package com.edts.tdlib.repository.uam;

import com.edts.tdlib.model.uam.ForgotPassword;
import com.edts.tdlib.model.uam.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ForgotPasswordRepository extends CrudRepository<ForgotPassword, Long> {

    Optional<ForgotPassword> findByUser(User user);

}
