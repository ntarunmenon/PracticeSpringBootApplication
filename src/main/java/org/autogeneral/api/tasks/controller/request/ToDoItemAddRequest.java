package org.autogeneral.api.tasks.controller.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class ToDoItemAddRequest {

    @NotNull
    @Max(value = 50, message = "Must be between 1 and 50 chars long")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
