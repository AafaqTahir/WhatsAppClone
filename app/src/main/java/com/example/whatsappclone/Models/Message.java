package com.example.whatsappclone.Models;

public class Message {
    String id, message , messageID;
    int timestamp;

    public Message(String id, String message, int timestamp) {
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Message(String id, String message) {
        this.id = id;
        this.message = message;
    }
    public Message(){ }

    public String getId() {
        return id;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}