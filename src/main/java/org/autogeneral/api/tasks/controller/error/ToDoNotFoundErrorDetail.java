package org.autogeneral.api.tasks.controller.error;

@SuppressWarnings("unused")
public class ToDoNotFoundErrorDetail extends ErrorDetail {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
