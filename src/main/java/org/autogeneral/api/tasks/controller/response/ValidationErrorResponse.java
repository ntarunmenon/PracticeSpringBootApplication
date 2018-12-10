package org.autogeneral.api.tasks.controller.response;

import java.util.List;

public class ValidationErrorResponse {

    private String name = "ValidationError";
    private List<ValidationErrorDetail> details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ValidationErrorDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ValidationErrorDetail> details) {
        this.details = details;
    }
}
