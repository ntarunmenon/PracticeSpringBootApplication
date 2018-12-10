package org.autogeneral.api.tasks.controller.response;

public class NotFoundErrorDetail extends ErrorDetail{
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
