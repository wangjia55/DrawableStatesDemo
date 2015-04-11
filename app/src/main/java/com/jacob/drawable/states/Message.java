package com.jacob.drawable.states;

/**
 * Package : com.jacob.drawable.states
 * Author : jacob
 * Date : 15-4-11
 * Description : 这个类是用来xxx
 */
public class Message {

    private String message;

    private boolean isUnRead;

    public Message(String message, boolean isUnRead) {
        this.message = message;
        this.isUnRead = isUnRead;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isUnRead() {
        return isUnRead;
    }
}
