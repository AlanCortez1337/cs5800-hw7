package com.cortezalan.problems.problem1.utils;

import com.cortezalan.problems.problem1.utils.states.IdleState;
import com.cortezalan.problems.problem1.utils.states.StateOfVendingMachine;
import com.cortezalan.problems.problem1.utils.vendingResponsibilities.DispenseSnackHandler;
import com.cortezalan.problems.problem1.utils.vendingResponsibilities.InsertMoneyHandler;
import com.cortezalan.problems.problem1.utils.vendingResponsibilities.SelectSnackHandler;
import com.cortezalan.problems.problem1.utils.vendingResponsibilities.SnackDispenserHandler;

import java.util.ArrayList;

public class VendingMachine {
    private StateOfVendingMachine state;
    private SnackDispenserHandler dispenserHandler;
    private ArrayList<Snack> snacks = new ArrayList<>();
    private Snack selectedSnack;
    private int selectedSnackIndex;

    public VendingMachine(ArrayList<Snack> snacks) {
        this.dispenserHandler = new SelectSnackHandler(new InsertMoneyHandler( new DispenseSnackHandler(null)));
        this.state = new IdleState();
        this.snacks = snacks;
    }

    public StateOfVendingMachine getState() {
        return this.state;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public void selectSnack(Snack snack) {
        this.dispenserHandler.handleState("select");
        for (int i = 0; i < this.snacks.size(); i++) {
            if (this.snacks.get(i).equals(snack)) {
                this.selectedSnackIndex = i;
                this.selectedSnack = this.snacks.get(i);
                System.out.println("SELECTED SNACK: " + selectedSnack.toString());
                this.getState().waitingForMoney(this);
                return;
            }
        }
        System.out.println("Invalid snack in vending machine");
        this.getState().idle(this);
    }

    public double insertMoney(double money) {
        if (selectedSnack == null) {
            System.out.println("No Selected Snack");
            return money;
        }

        this.dispenserHandler.handleState("insert");
        if (money >= this.selectedSnack.getPrice()) {
            this.getState().dispenseItem(this);

            double change = money - this.selectedSnack.getPrice();
            System.out.println("Your change: $" + change);
            return change;
        }
        System.out.println("Not enough money inserted");
        this.selectedSnack = null;
        return money;
    }

    public void dispenseSnack() {

        if (selectedSnack == null) {
            System.out.println("No Selected Snack");
            return;
        }

        this.selectedSnack.setQuantity(this.selectedSnack.getQuantity() - 1);
        this.snacks.remove(this.selectedSnackIndex);
        this.snacks.add(this.selectedSnack);

        this.dispenserHandler.handleState("dispense");

        System.out.println("Enjoy your " + this.selectedSnack.getName() + " snack! QTY LEFT: " + this.selectedSnack.getQuantity());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        this.selectedSnack = null;
        this.getState().idle(this);
    }
}
