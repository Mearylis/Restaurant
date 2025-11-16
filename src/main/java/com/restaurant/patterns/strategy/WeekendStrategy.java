package com.restaurant.patterns.strategy;

public class WeekendStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice * 1.10; // +10% surcharge on weekends
    }

    @Override
    public String getDescription() {
        return "Weekend +10% surcharge";
    }
}