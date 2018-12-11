package org.autogeneral.api.tasks.controller.error;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ToDoError {

    private String name;

    private List<ErrorDetail> details = new ArrayList<>();

    ToDoError(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ErrorDetail> getDetails() {
        return details;
    }

    public void addErrorDetail(ErrorDetail detail) {
        this.details.add(detail);
    }
}
