package com.example.consuming.entity;

public class Dog {

    private String message;
    private String status;

    public Dog(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public Dog() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
