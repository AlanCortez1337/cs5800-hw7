package com.cortezalan.problems.problem1.utils.vendingResponsibilities;

public class DispenseSnackHandler extends SnackDispenserHandler {
    public DispenseSnackHandler(SnackDispenserHandler next) {
        super(next);
    }

    public void handleState(String state) {
        if (state.equals("dispense")) {
            System.out.println("Dispensing snack from vending machine.");
        } else {
            System.out.println("I was passed by DispenseSnackHandler");
            super.handleState(state);
        }
    }
}
