package org.autogeneral.api.tasks.entity;

import org.autogeneral.api.tasks.controller.request.ToDoItemAddRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String text;

    @NotNull
    private LocalDate createdDate = LocalDate.now();

    public Todo(){ }

    public Todo(@NotNull String text, @NotNull LocalDate createdDate) {
        this.text = text;
        this.createdDate = createdDate;
    }

    public Todo(ToDoItemAddRequest toDoItemAddRequest) {
        this.text = toDoItemAddRequest.getText();
        this.createdDate = LocalDate.now();
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) &&
                Objects.equals(text, todo.text) &&
                Objects.equals(createdDate, todo.createdDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, text, createdDate);
    }
}
