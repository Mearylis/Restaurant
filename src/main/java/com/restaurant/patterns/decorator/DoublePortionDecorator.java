package com.restaurant.patterns.decorator;

import com.restaurant.models.Dish;

public class DoublePortionDecorator extends DishDecorator {
    public DoublePortionDecorator(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return decoratedDish.getDescription() + " (Double Portion)";
    }

    @Override
    public double getPrice() {
        return decoratedDish.getPrice() * 1.8;
    }
}