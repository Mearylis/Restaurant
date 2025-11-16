package com.restaurant;

import javafx.application.Application;

/**
 * RESTAURANT MANAGEMENT SYSTEM - MAIN ENTRY POINT
 * Clean separation: Only responsible for launching the application
 */
public class Main {

    /**
     * Main method - pure startup logic only
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║               RESTAURANT MANAGEMENT SYSTEM         ║");
        System.out.println("║          6 DESIGN PATTERNS DEMONSTRATION           ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println("Implemented Patterns:");
        System.out.println("  🔨 Builder     🏭 Factory     💵 Strategy");
        System.out.println("  🎨 Decorator   👁️ Observer    🎭 Facade");
        System.out.println();

        // Run pattern tests before UI starts
        com.restaurant.ui.PatternTests.runAllTests();

        // Launch JavaFX application
        Application.launch(RestaurantApplication.class, args);
    }
}