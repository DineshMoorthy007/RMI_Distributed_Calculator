package com.example.calculator;

import org.springframework.web.bind.annotation.*;

import java.rmi.Naming;

@RestController
@RequestMapping("/api/calculator")
@CrossOrigin("*")
public class CalculatorController {

    // Allow setter injection for testing
    private Calculator calculatorService;

    protected Calculator getService() throws Exception {
        if (calculatorService != null) {
            return calculatorService;
        }
        return (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");
    }

    // Package-private setter for testing
    void setCalculatorService(Calculator calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) throws Exception {
        return getService().add(a, b);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) throws Exception {
        return getService().subtract(a, b);
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) throws Exception {
        return getService().multiply(a, b);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) throws Exception {
        return getService().divide(a, b);
    }
}
