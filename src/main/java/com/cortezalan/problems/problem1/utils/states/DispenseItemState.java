package com.cortezalan.problems.problem1.utils.states;

import com.cortezalan.problems.problem1.utils.VendingMachine;

public class DispenseItemState implements StateOfVendingMachine {
    public String idle(VendingMachine vendingMachine) {
        // nothing
    }

    public String waitingForMoney(VendingMachine vendingMachine) {
        // nothing
    }

    public String dispenseItem(VendingMachine vendingMachine) {
        vendingMachine.setState(new DispenseItemState());
    }
}
