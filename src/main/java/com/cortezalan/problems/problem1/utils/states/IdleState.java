package com.cortezalan.problems.problem1.utils.states;

import com.cortezalan.problems.problem1.utils.VendingMachine;

public class IdleState implements StateOfVendingMachine {
    public void idle(VendingMachine vendingMachine) {
        // nothing
    }

    public void waitingForMoney(VendingMachine vendingMachine) {
        System.out.println("Vending machine in waiting for money state");
        vendingMachine.setState(new WaitingForMoneyState());
    }

    public void dispenseItem(VendingMachine vendingMachine) {
        // nothing
    }
}
