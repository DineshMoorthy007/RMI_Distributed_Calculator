package com.example.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.rmi.RemoteException;

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

    @Test
    void testAllOperationsWithDifferentValues() {
        assertEquals(100.0, RmiClient.calculate("add", 75, 25), 0.001);
        assertEquals(50.0, RmiClient.calculate("subtract", 75, 25), 0.001);
        assertEquals(200.0, RmiClient.calculate("multiply", 8, 25), 0.001);
        assertEquals(4.0, RmiClient.calculate("divide", 100, 25), 0.001);
    }

    @Test
    void testEdgeCases() {
        assertEquals(0.0, RmiClient.calculate("add", 0, 0), 0.001);
        assertEquals(-15.0, RmiClient.calculate("add", -10, -5), 0.001);
        assertEquals(0.0, RmiClient.calculate("multiply", 0, 100), 0.001);
    }

    @Test
    void testNullServiceError() throws Exception {
        // Force the service to be null to test error handling
        Field serviceField = RmiClient.class.getDeclaredField("service");
        serviceField.setAccessible(true);
        Object originalService = serviceField.get(null);
        
        try {
            serviceField.set(null, null);
            double result = RmiClient.calculate("add", 10, 5);
            assertTrue(Double.isNaN(result));
        } finally {
            serviceField.set(null, originalService);
        }
    }

    @Test
    void testAllSwitchBranches() {
        // Test all switch cases are covered
        assertNotEquals(Double.NaN, RmiClient.calculate("add", 1, 1));
        assertNotEquals(Double.NaN, RmiClient.calculate("subtract", 1, 1));
        assertNotEquals(Double.NaN, RmiClient.calculate("multiply", 1, 1));
        assertNotEquals(Double.NaN, RmiClient.calculate("divide", 1, 1));
        assertTrue(Double.isNaN(RmiClient.calculate("unknown", 1, 1)));
    }

    @Test
    void testExceptionHandlingInCalculate() throws Exception {
        // Create a mock service that throws exception
        Field serviceField = RmiClient.class.getDeclaredField("service");
        serviceField.setAccessible(true);
        Object originalService = serviceField.get(null);
        
        Calculator faultyService = new Calculator() {
            @Override
            public double add(double a, double b) throws RemoteException {
                throw new RemoteException("Test exception");
            }
            @Override
            public double subtract(double a, double b) throws RemoteException {
                throw new RemoteException("Test exception");
            }
            @Override
            public double multiply(double a, double b) throws RemoteException {
                throw new RemoteException("Test exception");
            }
            @Override
            public double divide(double a, double b) throws RemoteException {
                throw new RemoteException("Test exception");
            }
        };
        
        try {
            serviceField.set(null, faultyService);
            
            // All operations should return NaN when exception occurs
            assertTrue(Double.isNaN(RmiClient.calculate("add", 10, 5)));
            assertTrue(Double.isNaN(RmiClient.calculate("subtract", 10, 5)));
            assertTrue(Double.isNaN(RmiClient.calculate("multiply", 10, 5)));
            assertTrue(Double.isNaN(RmiClient.calculate("divide", 10, 5)));
        } finally {
            serviceField.set(null, originalService);
        }
    }

    @Test
    void testStaticInitializerSuccess() {
        // The static initializer runs when class loads
        // This test verifies successful initialization
        assertNotNull(RmiClient.class);
        // After setUp, service should be initialized
        double result = RmiClient.calculate("add", 2, 3);
        assertEquals(5.0, result, 0.001);
    }
}
