package com.edts.tdlib.repository;

import com.edts.tdlib.model.contact.MemberTelegramUserGroup;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.model.contact.TelegramUserGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberTelegramUserGroupRepo extends CrudRepository<MemberTelegramUserGroup, Long> {

    @Query("select mtg from MemberTelegramUserGroup mtg where mtg.userGroup.id = :idUserGroup and mtg.telegramUser.id = :idUser")
    Optional<MemberTelegramUserGroup> findByIdUserGroupAndIdUser(@Param("idUserGroup") long idUserGroup, @Param("idUser") long idUser);

    List<MemberTelegramUserGroup> findAllByTelegramUser(TelegramUser telegramUser);

    List<MemberTelegramUserGroup> findAllByUserGroup(TelegramUserGroup telegramUserGroup);

}
