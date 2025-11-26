package com.cortezalan.problem1;

import com.cortezalan.problems.problem1.utils.Snack;
import com.cortezalan.problems.problem1.utils.VendingMachine;
import com.cortezalan.problems.problem1.utils.states.WaitingForMoneyState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private VendingMachine vendingMachine;
    private Snack kitkat;
    private Snack snickers;

    @BeforeEach
    protected void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        this.kitkat = new Snack("KitKat", 1.50, 2);
        this.snickers = new Snack("Snickers", 1.75, 1);

        ArrayList<Snack> availableSnacks = new ArrayList<>();

        availableSnacks.add(kitkat);
        availableSnacks.add(snickers);

        this.vendingMachine = new VendingMachine(availableSnacks);
    }

    @AfterEach
    protected void cleanUp() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void getStateTest() {
        vendingMachine.getState().waitingForMoney(vendingMachine);

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("Vending machine in waiting for money state", output);
    }

    @Test
    public void setStateTest() {
        vendingMachine.setState(new WaitingForMoneyState());
        vendingMachine.getState().dispenseItem(vendingMachine);

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("Vending machine in dispense snack state", output);
    }

    @Test
    public void selectValidSnack() {
        vendingMachine.selectSnack(kitkat);

        String output = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "Handling selecting snack from vending machine.\n" +
                                "SELECTED SNACK: KitKat - $1.5 QTY: 2\n" +
                                "Vending machine in waiting for money state";

        assertEquals(expectedOutput, output);
    }

    @Test
    public void selectInValidSnack() {
        Snack pepsi = new Snack("Pepsi", 2.25, 5);

        vendingMachine.selectSnack(pepsi);

        String output = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "Handling selecting snack from vending machine.\n" +
                "Invalid snack in vending machine";

        assertEquals(expectedOutput, output);
    }

    @Test
    public void insertMoneyWithNoSnackSelected() {
        vendingMachine.insertMoney(20);

        String output = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "No Selected Snack";

        assertEquals(expectedOutput, output);
    }

    @Test
    public void insertMoneyWithValidBalance() {
        vendingMachine.selectSnack(kitkat);
        vendingMachine.insertMoney(20);

        String output = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "Handling selecting snack from vending machine.\n" +
                "SELECTED SNACK: KitKat - $1.5 QTY: 2\n" +
                "Vending machine in waiting for money state\n" +
                "I was passed by SelectSnackHandler\n" +
                "Accepting money from vending machine.\n" +
                "Vending machine in dispense snack state\n" +
                "Your change: $18.5";

        assertEquals(expectedOutput, output);
    }

    @Test
    public void insertMoneyWithInsufficientBalance() {
        vendingMachine.selectSnack(kitkat);
        vendingMachine.insertMoney(-1);

        String output = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "Handling selecting snack from vending machine.\n" +
                "SELECTED SNACK: KitKat - $1.5 QTY: 2\n" +
                "Vending machine in waiting for money state\n" +
                "I was passed by SelectSnackHandler\n" +
                "Accepting money from vending machine.\n" +
                "Not enough money inserted";

        assertEquals(expectedOutput, output);
    }

    @Test
    public void dispenseSnackWithNoSnackSelected() {
        vendingMachine.dispenseSnack();

        String output = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "No Selected Snack";

        assertEquals(expectedOutput, output);
    }

    @Test
    public void dispenseSnackWithSnackSelectedAndNotPaid() {
        vendingMachine.selectSnack(kitkat);
        vendingMachine.dispenseSnack();

        boolean result = vendingMachine.getState() instanceof DispenseItemStateTest;

        assertFalse(result);
    }

    @Test
    public void dispenseSnackWithNoSnackSelectedAndPaid() {
        vendingMachine.selectSnack(kitkat);
        vendingMachine.insertMoney(20);
        vendingMachine.dispenseSnack();

        String output = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "Handling selecting snack from vending machine.\n" +
                "SELECTED SNACK: KitKat - $1.5 QTY: 2\n" +
                "Vending machine in waiting for money state\n" +
                "I was passed by SelectSnackHandler\n" +
                "Accepting money from vending machine.\n" +
                "Vending machine in dispense snack state\n" +
                "Your change: $18.5\n" +
                "I was passed by SelectSnackHandler\n" +
                "I was passed by InsertMoneyHandler\n" +
                "Dispensing snack from vending machine.\n" +
                "Enjoy your KitKat snack! QTY LEFT: 1\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Vending machine in idle state";

        assertEquals(expectedOutput, output);
    }
}
