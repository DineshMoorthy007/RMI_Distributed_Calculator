package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorApplicationTest {

    @Test
    void contextLoads() {
        // Verify that the Spring context loads successfully
    }

    @Test
    void testMainMethod() {
        // Verify main method can be called without exception
        assertDoesNotThrow(() -> {
            // Note: We don't actually call main() as it would start the server
            // This test verifies the class structure is valid
            CalculatorApplication app = new CalculatorApplication();
        });
    }
    
    private void assertDoesNotThrow(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            throw new AssertionError("Should not throw exception", e);
        }
    }
}
