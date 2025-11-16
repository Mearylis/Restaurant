package com.restaurant.patterns.decorator;

import com.restaurant.models.Dish;

public class ExtraCheeseDecorator extends DishDecorator {
    public ExtraCheeseDecorator(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return decoratedDish.getDescription() + " + Extra Cheese";
    }

    @Override
    public double getPrice() {
        return decoratedDish.getPrice() + 2.00;
    }
}