package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List <ChatMessage> chatMessages;

    private String bannedWords[] = new String[] {"badword1", "badword2"};

    public MessageService() {
    }

    @PostConstruct
    public void postConstruct(){
        chatMessages = new ArrayList<>();
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void addMessage(ChatForm chatForm){
        if (validateMessage(chatForm.getMessageText())){
            String messageText = caseModifier(chatForm.getMessageType(), chatForm.getMessageText());
            ChatMessage chatMessage = new ChatMessage(chatForm.getUserName(), messageText);
            chatMessages.add(chatMessage);
        }
    }

    private String caseModifier(String modifier, String original){

        switch (modifier){
            case "Shout":
                return original.toUpperCase();
            case "Whisper":
                return original.toLowerCase();
            default:
                return original;
        }
    }

    private boolean validateMessage(String original){
        for (String word : bannedWords){
            if (original.contains(word))
                return false;
        }

        return true;
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
