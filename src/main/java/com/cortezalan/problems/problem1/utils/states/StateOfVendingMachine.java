package com.cortezalan.problems.problem1.utils.states;

import com.cortezalan.problems.problem1.utils.VendingMachine;

public interface StateOfVendingMachine {
    String idle(VendingMachine vendingMachine);
    String waitingForMoney(VendingMachine vendingMachine);
    String dispenseItem(VendingMachine vendingMachine);
}
