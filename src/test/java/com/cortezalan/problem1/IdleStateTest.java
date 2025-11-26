package com.cortezalan.problem1;

import com.cortezalan.problems.problem1.utils.VendingMachine;
import com.cortezalan.problems.problem1.utils.states.IdleState;
import com.cortezalan.problems.problem1.utils.states.StateOfVendingMachine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdleStateTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private StateOfVendingMachine idleState;
    private VendingMachine vendingMachine;

    @BeforeEach
    protected void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        this.vendingMachine = new VendingMachine(new ArrayList<>());
        this.idleState = new IdleState();
    }

    @AfterEach
    protected void cleanUp() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void callingIdleStateWhenIdle() {
        idleState.idle(vendingMachine);

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("", output);
    }

    @Test
    public void callingWaitingStateWhenIdle() {
        idleState.waitingForMoney(vendingMachine);

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("Vending machine in waiting for money state", output);
    }

    @Test
    public void callingDispenseStateWhenIdle() {
        idleState.dispenseItem(vendingMachine);

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("", output);
    }
}
