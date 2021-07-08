package com.edts.tdlib.model.contact;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ChatRoomMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userTelegramId;
    private Date joinDate;
    private boolean restrictedStatus;

    @OneToOne
    @JoinColumn
    private TelegramUser telegramUser;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn
    private ChatRoom chatRoom;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserTelegramId() {
        return userTelegramId;
    }

    public void setUserTelegramId(String userTelegramId) {
        this.userTelegramId = userTelegramId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public boolean isRestrictedStatus() {
        return restrictedStatus;
    }

    public void setRestrictedStatus(boolean restrictedStatus) {
        this.restrictedStatus = restrictedStatus;
    }

    public TelegramUser getTelegramUser() {
        return telegramUser;
    }

    public void setTelegramUser(TelegramUser telegramUser) {
        this.telegramUser = telegramUser;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
}
