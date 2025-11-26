package com.cortezalan.problems.problem1.utils.states;

import com.cortezalan.problems.problem1.utils.VendingMachine;

public class WaitingForMoneyState implements StateOfVendingMachine {
    public void idle(VendingMachine vendingMachine) {
        // do nothing
    }

    public void waitingForMoney(VendingMachine vendingMachine) {
        // do nothing
    }

    public void dispenseItem(VendingMachine vendingMachine) {
        System.out.println("Vending machine in dispense snack state");
        vendingMachine.setState(new DispenseItemState());
    }
}
