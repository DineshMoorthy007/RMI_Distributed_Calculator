package com.example.calculator;

import org.junit.jupiter.api.Test;

import java.rmi.Naming;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServerTest {

    @Test
    void testStartRmiServer() throws Exception {
        // Start the RMI server
        assertDoesNotThrow(() -> CalculatorServer.startRmiServer());
        
        // Verify that the service is bound and accessible
        Calculator service = (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");
        assertNotNull(service);
        
        // Test basic operation to ensure it works
        assertEquals(5.0, service.add(2, 3), 0.001);
    }

    @Test
    void testStartRmiServerMultipleTimes() {
        // Should handle multiple calls gracefully
        assertDoesNotThrow(() -> {
            CalculatorServer.startRmiServer();
            CalculatorServer.startRmiServer();
        });
    }

    @Test
    void testServerWithAllOperations() throws Exception {
        CalculatorServer.startRmiServer();
        Calculator service = (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");
        
        assertEquals(8.0, service.add(5, 3), 0.001);
        assertEquals(2.0, service.subtract(5, 3), 0.001);
        assertEquals(15.0, service.multiply(5, 3), 0.001);
        assertEquals(2.0, service.divide(6, 3), 0.001);
    }
}
