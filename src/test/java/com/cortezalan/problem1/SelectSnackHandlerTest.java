package com.cortezalan.problem1;

import com.cortezalan.problems.problem1.utils.vendingResponsibilities.SelectSnackHandler;
import com.cortezalan.problems.problem1.utils.vendingResponsibilities.SnackDispenserHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectSnackHandlerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private SnackDispenserHandler selectSnackHandler;

    @BeforeEach
    protected void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        this.selectSnackHandler = new SelectSnackHandler(null);
    }

    @AfterEach
    protected void cleanUp() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void whenStateIsSelect() {
        selectSnackHandler.handleState("select");

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("Handling selecting snack from vending machine.", output);
    }

    @Test
    public void whenStateIsOther() {
        selectSnackHandler.handleState("other");

        String output = outContent.toString().trim().replace("\r\n", "\n");

        assertEquals("I was passed by SelectSnackHandler", output);
    }
}
