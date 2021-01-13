package com.udacity.jwdnd.c1.review.model;

public class ChatForm {

    private String userName;
    private String messageText;
    private String messageType;

    public ChatForm(String userName, String messageText, String messageType) {
        this.userName = userName;
        this.messageText = messageText;
        this.messageType = messageType;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageType() {
        return messageType;
    }
}
