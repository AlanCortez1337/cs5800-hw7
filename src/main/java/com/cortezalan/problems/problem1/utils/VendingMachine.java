package com.cortezalan.problems.problem1.utils;

import com.cortezalan.problems.problem1.utils.states.IdleState;
import com.cortezalan.problems.problem1.utils.states.StateOfVendingMachine;

import java.util.ArrayList;

public class VendingMachine {
    private StateOfVendingMachine state;
    private ArrayList<Snack> snacks = new ArrayList<>();

    public VendingMachine() {
        this.state = new IdleState();
    }

    public StateOfVendingMachine getState() {
        return this.state;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public void idle() {
        getState().idle(this);
    }

    public void waitForMoney() {
        getState().waitingForMoney(this);
    }

    public void dispense() {
        getState().dispenseItem(this);
    }
}
