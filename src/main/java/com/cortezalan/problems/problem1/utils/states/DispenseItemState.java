package com.cortezalan.problems.problem1.utils.states;

import com.cortezalan.problems.problem1.utils.VendingMachine;

public class DispenseItemState implements StateOfVendingMachine {
    public void idle(VendingMachine vendingMachine) {
        System.out.println("Vending machine in idle state");
        vendingMachine.setState(new IdleState());
    }

    public void waitingForMoney(VendingMachine vendingMachine) {
        // nothing
    }

    public void dispenseItem(VendingMachine vendingMachine) {
        // nothing
    }
}
