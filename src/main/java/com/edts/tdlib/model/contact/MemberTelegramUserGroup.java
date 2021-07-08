package com.edts.tdlib.model.contact;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.*;

@Entity
public class MemberTelegramUserGroup extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private TelegramUserGroup userGroup;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private TelegramUser telegramUser;

    private boolean enable;


    public TelegramUserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(TelegramUserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public TelegramUser getTelegramUser() {
        return telegramUser;
    }

    public void setTelegramUser(TelegramUser telegramUser) {
        this.telegramUser = telegramUser;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
