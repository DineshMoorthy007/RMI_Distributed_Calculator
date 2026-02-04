package com.example.calculator;

import java.rmi.Naming;

public class RmiClient {

    private static Calculator service;

    static {
        try {
            service = (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");
        } catch (Exception e) {
            System.out.println("RMI Client Connection Failed: " + e.getMessage());
        }
    }

    public static double calculate(String op, double a, double b) {
        try {
            if (service == null) return Double.NaN;
            return switch (op) {
                case "add" -> service.add(a, b);
                case "subtract" -> service.subtract(a, b);
                case "multiply" -> service.multiply(a, b);
                case "divide" -> service.divide(a, b);
                default -> Double.NaN;
            };
        } catch (Exception e) {
            System.out.println("RMI Error: " + e.getMessage());
            return Double.NaN;
        }
    }
}
