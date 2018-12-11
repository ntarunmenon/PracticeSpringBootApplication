package org.practice.api.tasks.controller.response.integrationtest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class IntegrationTestResponse {

    @JsonProperty("bracers")
    private List<BalanceTestIntegrationTestResponse> balanceTestIntegrationTestResponses
            = new ArrayList<>();

    public List<BalanceTestIntegrationTestResponse> getBalanceTestIntegrationTestResponses() {
        return balanceTestIntegrationTestResponses;
    }

    public void setBalanceTestIntegrationTestResponses(List<BalanceTestIntegrationTestResponse> balanceTestIntegrationTestResponses) {
        this.balanceTestIntegrationTestResponses = balanceTestIntegrationTestResponses;
    }
}
