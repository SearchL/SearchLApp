package com.eduardo.workcomm.workcomm;

/**
 * Created by eduardo on 7/10/17.
 */

public class Message {
    private String message;
    private String name;
    private String photo;
    private String typeMessage;
    private String time;

    public Message() {
    }

    public Message(String message, String name, String photo, String typeMessage, String time) {
        this.message = message;
        this.name = name;
        this.photo = photo;
        this.typeMessage = typeMessage;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
