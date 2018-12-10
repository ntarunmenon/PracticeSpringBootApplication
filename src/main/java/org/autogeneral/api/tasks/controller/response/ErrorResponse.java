package org.autogeneral.api.tasks.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class NotFoundErrorResponse {

    private String name = "NotFoundError";

    private List<NotFoundErrorDetail> details = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NotFoundErrorDetail> getDetails() {
        return details;
    }

    public void addErrorDetail(NotFoundErrorDetail details) {
        this.details.add(details);
    }
}
