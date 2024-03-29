package com.driver;

import java.util.Comparator;
import java.util.Date;

public class Mails{

    private Date date;

    private String sender;

    private String message;

    public Mails(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

}
