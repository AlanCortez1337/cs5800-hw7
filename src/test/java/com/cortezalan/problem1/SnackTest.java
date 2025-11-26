package com.cortezalan.problem1;

import com.cortezalan.problems.problem1.utils.Snack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnackTest {
    private Snack snack;

    @BeforeEach
    protected void setUp() {
        snack = new Snack("KitKat", 1.50, 2);
    }


    @Test
    public void getNameTest() {
        assertEquals("KitKat", snack.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(1.50, snack.getPrice());
    }

    @Test
    public void getQuantityTest() {
        assertEquals(2, snack.getQuantity());
    }

    @Test
    public void setQuantityTest() {
        snack.setQuantity(10);

        assertEquals(10, snack.getQuantity());
    }

    @Test
    public void getToString() {
        assertEquals("KitKat - $1.5 QTY: 2", snack.toString());
    }
}
