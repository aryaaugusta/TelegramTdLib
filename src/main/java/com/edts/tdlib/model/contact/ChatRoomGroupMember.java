package com.edts.tdlib.model.contact;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ChatRoomGroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreationTimestamp
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private ChatRoomGroup chatRoomGroup;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private ChatRoom chatRoom;


    public ChatRoomGroupMember() {
    }

    public ChatRoomGroupMember(ChatRoomGroup chatRoomGroup, ChatRoom chatRoom) {
        this.chatRoomGroup = chatRoomGroup;
        this.chatRoom = chatRoom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ChatRoomGroup getChatRoomGroup() {
        return chatRoomGroup;
    }

    public void setChatRoomGroup(ChatRoomGroup chatRoomGroup) {
        this.chatRoomGroup = chatRoomGroup;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
}
