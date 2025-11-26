package com.cortezalan.problem1;

import com.cortezalan.problems.problem1.utils.vendingResponsibilities.DispenseSnackHandler;
import com.cortezalan.problems.problem1.utils.vendingResponsibilities.SnackDispenserHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispenseSnackHandlerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private SnackDispenserHandler selectDispenseSnackHandler;

    @BeforeEach
    protected void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        this.selectDispenseSnackHandler = new DispenseSnackHandler(null);
    }

    @AfterEach
    protected void cleanUp() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void whenStateIsDispense() {
        selectDispenseSnackHandler.handleState("dispense");

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("Dispensing snack from vending machine.", output);
    }

    @Test
    public void whenStateIsOther() {
        selectDispenseSnackHandler.handleState("other");

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("I was passed by DispenseSnackHandler", output);
    }
}
