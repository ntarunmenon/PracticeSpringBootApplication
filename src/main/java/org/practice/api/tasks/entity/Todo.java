package org.practice.api.tasks.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.practice.api.tasks.controller.request.ToDoItemAddRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@SuppressWarnings("unused")
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String text;

    @JsonProperty("isCompleted")
    private boolean completed = false;

    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    public Todo() {
    }

    public Todo(@NotNull String text, @NotNull LocalDateTime createdDate) {
        this.text = text;
        this.createdAt = createdDate;
    }

    public Todo(ToDoItemAddRequest toDoItemAddRequest) {
        this.text = toDoItemAddRequest.getText();
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return completed == todo.completed &&
                Objects.equals(id, todo.id) &&
                Objects.equals(text, todo.text) &&
                Objects.equals(createdAt, todo.createdAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, text, completed, createdAt);
    }
}
