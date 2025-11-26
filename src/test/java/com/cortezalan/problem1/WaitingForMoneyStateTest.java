package com.cortezalan.problem1;

import com.cortezalan.problems.problem1.utils.VendingMachine;
import com.cortezalan.problems.problem1.utils.states.DispenseItemState;
import com.cortezalan.problems.problem1.utils.states.StateOfVendingMachine;
import com.cortezalan.problems.problem1.utils.states.WaitingForMoneyState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaitingForMoneyStateTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private StateOfVendingMachine waitingState;
    private VendingMachine vendingMachine;

    @BeforeEach
    protected void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        this.vendingMachine = new VendingMachine(new ArrayList<>());
        this.waitingState = new WaitingForMoneyState();
    }

    @AfterEach
    protected void cleanUp() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void callingIdleStateWhenDispenseState() {
        waitingState.idle(vendingMachine);

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("", output);
    }

    @Test
    public void callingWaitingStateWhenDispenseState() {
        waitingState.waitingForMoney(vendingMachine);

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("", output);
    }

    @Test
    public void callingDispenseStateWhenDispenseState() {
        waitingState.dispenseItem(vendingMachine);

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("Vending machine in dispense snack state", output);
    }
}
