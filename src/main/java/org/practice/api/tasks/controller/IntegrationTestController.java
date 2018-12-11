package org.practice.api.tasks.controller;

import org.practice.api.tasks.controller.response.BalanceTestResult;
import org.practice.api.tasks.controller.response.integrationtest.BalanceTestIntegrationTestResponse;
import org.practice.api.tasks.controller.response.integrationtest.IntegrationTestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/integrationTest")
@SuppressWarnings("unused")
public class IntegrationTestController {

    private RestTemplate restTemplate;

    public IntegrationTestController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public IntegrationTestResponse triggerIntegration(@RequestParam("url") String url){
        IntegrationTestResponse integrationTestResponse = new IntegrationTestResponse();
        List<BalanceTestIntegrationTestResponse> balanceTestIntegrationTestResponses = testValidateBrackets(url);
        integrationTestResponse.setBalanceTestIntegrationTestResponses(balanceTestIntegrationTestResponses);
        return integrationTestResponse;
    }

    private List<BalanceTestIntegrationTestResponse> testValidateBrackets(String url) {
        String testInput = "{}";
        List<BalanceTestIntegrationTestResponse> balanceTestIntegrationTestResponses = new ArrayList<>();

        UriComponents uriComponents = UriComponentsBuilder.
                fromUriString(url)
                .path("/tasks/validateBrackets")
                .queryParam("input",testInput)
                .build().encode();

        ResponseEntity<BalanceTestResult> balanceTestResultResponseEntity = restTemplate.getForEntity(uriComponents.toUri(), BalanceTestResult.class);
        BalanceTestIntegrationTestResponse balanceTestIntegrationTestResponse = new
                BalanceTestIntegrationTestResponse(balanceTestResultResponseEntity.getBody(),true,true);
        balanceTestIntegrationTestResponses.add(balanceTestIntegrationTestResponse);

        return balanceTestIntegrationTestResponses;

    }
}
