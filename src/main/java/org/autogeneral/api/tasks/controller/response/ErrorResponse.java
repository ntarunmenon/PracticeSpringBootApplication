package org.autogeneral.api.tasks.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

    private String name;

    private List<ErrorDetail> details = new ArrayList<>();

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
