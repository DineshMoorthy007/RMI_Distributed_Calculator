package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoverageResourceConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void testCoverageResourceConfigBean() {
        CoverageResourceConfig config = context.getBean(CoverageResourceConfig.class);
        assertNotNull(config);
    }

    @Test
    void testConfigInstantiation() {
        CoverageResourceConfig config = new CoverageResourceConfig();
        assertNotNull(config);
    }
}
