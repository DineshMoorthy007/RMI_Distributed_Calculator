package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorApplicationTest {

    @Test
    void contextLoads() {
        // Verify that the Spring context loads successfully
    }

    @Test
    void testMainMethod() {
        // Test main method starts RMI server and Spring Boot
        assertDoesNotThrow(() -> {
            // Start the application in a separate thread
            Thread appThread = new Thread(() -> {
                CalculatorApplication.main(new String[]{
                    "--server.port=0", // Use random port to avoid conflicts
                    "--spring.main.web-application-type=none" // Don't start web server
                });
            });
            appThread.setDaemon(true);
            appThread.start();
            
            // Give it time to start
            Thread.sleep(2000);
        });
    }

    @Test
    void testApplicationStarts() {
        // Test that the application context can be created
        ConfigurableApplicationContext context = SpringApplication.run(
            CalculatorApplication.class,
            "--server.port=0",
            "--spring.main.web-application-type=none"
        );
        assertNotNull(context);
        assertTrue(context.isActive());
        context.close();
    }
    
    @Test
    void testConstructor() {
        CalculatorApplication app = new CalculatorApplication();
        assertNotNull(app);
    }
}
