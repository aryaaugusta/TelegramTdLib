package com.edts.tdlib.repository;

import com.edts.tdlib.model.TelegramAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TelegramAccountRepo extends CrudRepository<TelegramAccount, Long> {

    Optional<TelegramAccount> findByEnableEquals(boolean enable);

    @Modifying
    @Query("update TelegramAccount ta set ta.enable = false")
    void disableAccount(@Param("phoneNumber") String phoneNumber);

    @Modifying
    @Query("update TelegramAccount ta set ta.enable = true where ta.phoneNumber = :phoneNumber")
    void enableAccount(@Param("phoneNumber") String phoneNumber);


}
