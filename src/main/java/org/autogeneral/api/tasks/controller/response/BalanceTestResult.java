package org.autogeneral.api.tasks.controller.response;

public class BalanceTestResult {
    private String input;
    private boolean balanced;

    public BalanceTestResult(String input, boolean balanced) {
        this.input = input;
        this.balanced = balanced;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isBalanced() {
        return balanced;
    }

    public void setBalanced(boolean balanced) {
        this.balanced = balanced;
    }
}
