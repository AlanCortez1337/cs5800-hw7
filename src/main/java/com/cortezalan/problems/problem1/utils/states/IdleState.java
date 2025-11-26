package com.cortezalan.problems.problem1.utils.states;

import com.cortezalan.problems.problem1.utils.VendingMachine;

public class IdleState implements StateOfVendingMachine {
    public String idle(VendingMachine vendingMachine) {
        vendingMachine.setState(new IdleState());
    }

    public String waitingForMoney(VendingMachine vendingMachine) {
        // nothing
    }

    public String dispenseItem(VendingMachine vendingMachine) {
        // nothing
    }
}
