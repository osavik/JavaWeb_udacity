package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
    private Integer messageId;
    private String userName;
    private String messageText;

    public ChatMessage(Integer messageId, String userName, String messageText) {
        this.messageId = messageId;
        this.userName = userName;
        this.messageText = messageText;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessageText() {
        return messageText;
    }
}
