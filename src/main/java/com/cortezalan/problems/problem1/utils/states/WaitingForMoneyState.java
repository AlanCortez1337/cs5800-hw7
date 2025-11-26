package com.cortezalan.problems.problem1.utils.states;

import com.cortezalan.problems.problem1.utils.VendingMachine;

public class WaitingForMoneyState implements StateOfVendingMachine {
    public String idle(VendingMachine vendingMachine) {
        return "";
    }

    public String waitingForMoney(VendingMachine vendingMachine) {
        vendingMachine.setState(new WaitingForMoneyState());
        return "waiting";
    }

    public String dispenseItem(VendingMachine vendingMachine) {
        return "";
    }
}
