package com.example.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RmiClientTest {

    @BeforeAll
    static void setUp() {
        // Ensure RMI server is running
        CalculatorServer.startRmiServer();
    }

    @Test
    void testAddOperation() {
        double result = RmiClient.calculate("add", 10, 5);
        assertEquals(15.0, result, 0.001);
    }

    @Test
    void testSubtractOperation() {
        double result = RmiClient.calculate("subtract", 10, 5);
        assertEquals(5.0, result, 0.001);
    }

    @Test
    void testMultiplyOperation() {
        double result = RmiClient.calculate("multiply", 10, 5);
        assertEquals(50.0, result, 0.001);
    }

    @Test
    void testDivideOperation() {
        double result = RmiClient.calculate("divide", 10, 5);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    void testInvalidOperation() {
        double result = RmiClient.calculate("invalid", 10, 5);
        assertTrue(Double.isNaN(result));
    }
}
