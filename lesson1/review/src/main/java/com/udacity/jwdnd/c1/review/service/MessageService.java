package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List <ChatMessage> chatMessages;

    public MessageService() {
    }

    @PostConstruct
    public void postConstruct(){
        chatMessages = new ArrayList<>();
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void addMessage(ChatMessage message){
        chatMessages.add(message);
    }

    /*
    private String message;


    public MessageService(String message){
        System.out.println("Bean MessageService is created (constructor with parameter)");
        this.message = message;
    }

    public String uppercase(){
        return this.message.toUpperCase();
    }

    public String lowercase(){
        return this.message.toLowerCase();
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Bean MessageService is created (post constructor)");
    }
    */





}
