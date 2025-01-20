package com.Achal.Water.tracker.app.response;

public class response {

    private String message;
    private String status;

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

    public response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public response() {
    }
}
