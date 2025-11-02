package com.example.calculator;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {

    public static void startRmiServer() {
        try {
            LocateRegistry.createRegistry(1099); // RMI registry port
            CalculatorImpl calculator = new CalculatorImpl();
            Naming.rebind("rmi://localhost:1099/CalculatorService", calculator);
            System.out.println(" RMI Calculator Server started at rmi://localhost:1099/CalculatorService");
        } catch (Exception e) {
            System.err.println(" Error starting RMI server: " + e.getMessage());
        }
    }
}
