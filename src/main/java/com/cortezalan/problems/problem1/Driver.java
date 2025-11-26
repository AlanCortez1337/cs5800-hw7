package com.cortezalan.problems.problem1;

import com.cortezalan.problems.problem1.utils.Snack;
import com.cortezalan.problems.problem1.utils.VendingMachine;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Snack coke = new Snack("Coke", 2.25, 10);
        Snack pepsi = new Snack("Pepsi", 2.25, 5);
        Snack cheetos = new Snack("Cheetos", 1.99, 7);
        Snack doritos = new Snack("Doritos", 1.99, 3);
        Snack kitkat = new Snack("KitKat", 1.50, 2);
        Snack snickers = new Snack("Snickers", 1.75, 1);

        ArrayList<Snack> availableSnacks = new ArrayList<>();

        availableSnacks.add(coke);
        availableSnacks.add(pepsi);
        availableSnacks.add(cheetos);
        availableSnacks.add(doritos);
        availableSnacks.add(kitkat);
        availableSnacks.add(snickers);


        VendingMachine vendingMachine = new VendingMachine(availableSnacks);

        vendingMachine.selectSnack(coke);
        vendingMachine.insertMoney(3.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack(pepsi);
        vendingMachine.insertMoney(4.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack(cheetos);
        vendingMachine.insertMoney(3.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack(doritos);
        vendingMachine.insertMoney(3.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack(kitkat);
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack(snickers);
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();
    }
}
