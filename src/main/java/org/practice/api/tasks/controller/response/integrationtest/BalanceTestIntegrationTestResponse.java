package org.practice.api.tasks.controller.response.integrationtest;

import org.practice.api.tasks.controller.response.BalanceTestResult;

@SuppressWarnings("unused")
public class BalanceTestIntegrationTestResponse {
    private String input;
    private boolean result;
    private boolean expected;
    private boolean isCorrect;

    public BalanceTestIntegrationTestResponse(BalanceTestResult balanceTestResult, boolean expected, boolean result) {
        this.input = balanceTestResult.getInput();
        this.isCorrect = balanceTestResult.isBalanced();
        this.expected = expected;
        this.result = result;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isExpected() {
        return expected;
    }

    public void setExpected(boolean expected) {
        this.expected = expected;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
