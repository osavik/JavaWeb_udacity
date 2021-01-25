package com.udacity.jwdnd.c1.review.pages;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement messageText;

    @FindBy(id = "messageType")
    private WebElement messageType;

    @FindBy(id = "submit-message")
    private WebElement submitMessage;

    @FindBy(id = "logout")
    private WebElement logout;

    @FindBy(className = "chatMessageUsername")
    private WebElement chatMessageUsername;

    @FindBy(className = "chatMessageText")
    private WebElement chatMessageText;

    public ChatPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setMessageText(String messageText) {
        this.messageText.sendKeys(messageText);
    }

    public void setMessageType(String messageType) {
        this.messageType.sendKeys(messageType);
    }

    public void submitMessageButton(){
        this.submitMessage.click();
    }

    public void logoutButton(){
        logout.click();
    }

    public String getChatMessageUsername() {
        return chatMessageUsername.getText();
    }

    public String getChatMessageText() {
        return chatMessageText.getText();
    }

    public void submitMessageProcess(String text, String type){
        setMessageText(text);
        setMessageType(type);
        submitMessageButton();
    }
}
