package com.Achal.Water.tracker.app.response;

public class CreateUserResponse {
    private String message;
    private Long userId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CreateUserResponse(Long userId, String message) {
        this.userId = userId;
        this.message = message;
    }
}
