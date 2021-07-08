package com.edts.tdlib.bean.contact;

public class TelegramUserMemberGroupBean {

    private TelegramUserBean telegramUserBean;
    private boolean enable;

    public TelegramUserBean getTelegramUserBean() {
        return telegramUserBean;
    }

    public void setTelegramUserBean(TelegramUserBean telegramUserBean) {
        this.telegramUserBean = telegramUserBean;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
