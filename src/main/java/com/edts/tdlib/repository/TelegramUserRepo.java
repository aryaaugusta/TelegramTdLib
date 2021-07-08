package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.TelegramUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TelegramUserRepo extends CrudRepository<TelegramUser, Long> {

    Optional<TelegramUser> findByUserTelegramId(int userTelegramId);

    @Query("select t from TelegramUser t where t.chatId like  %:chatId% and t.deleted = false")
    Page<TelegramUser> findAllByChatId(@Param("chatId") String chatId, Pageable pageable);


    @Query("select t from TelegramUser t where concat(t.firstName, t.lastName) like  %:name% and t.deleted = false and t.userType = :userType")
    Page<TelegramUser> findAllByFirstNameOrLastName(@Param("name") String name, @Param("userType") String userType, Pageable pageable);


    @Query("select t from TelegramUser t where t.deleted = false and t.userType = :userType")
    Page<TelegramUser> findAll(@Param("userType") String userType, Pageable pageable);

    Optional<TelegramUser> findOneByChatId(String chatId);

    Optional<TelegramUser> findByPhoneNumber(String phoneNumber);
}
