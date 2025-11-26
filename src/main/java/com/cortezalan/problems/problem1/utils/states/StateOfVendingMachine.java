package com.cortezalan.problems.problem1.utils.states;

import com.cortezalan.problems.problem1.utils.VendingMachine;

public interface StateOfVendingMachine {
    void idle(VendingMachine vendingMachine);
    void waitingForMoney(VendingMachine vendingMachine);
    void dispenseItem(VendingMachine vendingMachine);
}
