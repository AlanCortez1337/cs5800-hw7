package com.cortezalan.problems.problem1.utils.vendingResponsibilities;

public abstract class SnackDispenserHandler {
    private SnackDispenserHandler next;

    public SnackDispenserHandler(SnackDispenserHandler next) {
        this.next = next;
    }

    public void handleState(String state) {
        if (next != null) {
            next.handleState(state);
        }
    }
}
