package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorImplTest {

    private CalculatorImpl calculator;

    @BeforeEach
    void setUp() throws RemoteException {
        calculator = new CalculatorImpl();
    }

    @Test
    void testAdd() {
        assertEquals(5.0, calculator.add(2, 3));
        assertEquals(0.0, calculator.add(-5, 5));
        assertEquals(-10.0, calculator.add(-5, -5));
        assertEquals(7.5, calculator.add(2.5, 5.0));
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, calculator.subtract(3, 2));
        assertEquals(-10.0, calculator.subtract(-5, 5));
        assertEquals(0.0, calculator.subtract(5, 5));
        assertEquals(-2.5, calculator.subtract(2.5, 5.0));
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, calculator.multiply(2, 3));
        assertEquals(-25.0, calculator.multiply(-5, 5));
        assertEquals(25.0, calculator.multiply(-5, -5));
        assertEquals(12.5, calculator.multiply(2.5, 5.0));
        assertEquals(0.0, calculator.multiply(0, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3));
        assertEquals(-1.0, calculator.divide(-5, 5));
        assertEquals(1.0, calculator.divide(-5, -5));
        assertEquals(0.5, calculator.divide(2.5, 5.0));
    }

    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(
            ArithmeticException.class,
            () -> calculator.divide(5, 0)
        );
        assertEquals("Division by zero", exception.getMessage());
    }
}
