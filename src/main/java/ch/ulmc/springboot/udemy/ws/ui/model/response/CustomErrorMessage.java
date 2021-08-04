package ch.ulmc.springboot.udemy.ws.ui.model.response;

import java.util.Date;

public class CustomErrorMessage {
    private Date timestamp;

    private String message;

    public CustomErrorMessage(Date date, String message) {
        this.timestamp = date;
        this.message = message;
    }

    public CustomErrorMessage() {

    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
