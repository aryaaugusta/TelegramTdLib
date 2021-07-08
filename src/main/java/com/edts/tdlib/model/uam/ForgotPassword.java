package com.edts.tdlib.model.uam;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ForgotPassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
    private String code;
    private String codeEncryption;
    private Date generateDate = new Date();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeEncryption() {
        return codeEncryption;
    }

    public void setCodeEncryption(String codeEncryption) {
        this.codeEncryption = codeEncryption;
    }

    public Date getGenerateDate() {
        return generateDate;
    }

    public void setGenerateDate(Date generateDate) {
        this.generateDate = generateDate;
    }
}
