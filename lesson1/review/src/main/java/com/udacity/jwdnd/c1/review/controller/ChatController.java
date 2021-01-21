package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Scanner;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public String printMessages(ChatForm chatForm, Model model){
        model.addAttribute("messages", messageService.getChatMessages());
        return "chat";
    }

    @PostMapping()
    public String submitMessage(Authentication authentication, ChatForm chatForm, Model model){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String currentPrincipalName = authentication.getName();

        // get currently sign-in user
        chatForm.setUserName(authentication.getName());

        messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("messages", messageService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper" };
    }
}
