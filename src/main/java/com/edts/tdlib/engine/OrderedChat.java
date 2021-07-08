package com.edts.tdlib.engine;

public class OrderedChat implements Comparable<OrderedChat> {

    private long chatId;
    private long order;

    OrderedChat(long chatId, long order) {
        this.chatId = chatId;
        this.order = order;
    }

    @Override
    public int compareTo(OrderedChat o) {
        if (this.order != o.order) {
            return o.order < this.order ? -1 : 1;
        }
        if (this.chatId != o.chatId) {
            return o.chatId < this.chatId ? -1 : 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        OrderedChat o = (OrderedChat) obj;
        return this.chatId == o.chatId && this.order == o.order;
    }


    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }
}
