package org.autogeneral.api.tasks.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ToDoItemAddRequest {

    @NotNull
    @Size(min=1, max=50,message = "Must be between 1 and 50 chars long")
    private String text;

    @JsonProperty("isCompleted")
    private boolean completed;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
