package com.cortezalan.problems.problem1.utils.vendingResponsibilities;

public class SelectSnackHandler extends SnackDispenserHandler{

    public SelectSnackHandler(SnackDispenserHandler next) {
        super(next);
    }

    public void handleState(String state) {
        if (state.equals("select")) {
            System.out.println("Handling selecting snack from vending machine.");
        } else {
            System.out.println("I was passed by Select");
            super.handleState(state);
        }
    }
}
