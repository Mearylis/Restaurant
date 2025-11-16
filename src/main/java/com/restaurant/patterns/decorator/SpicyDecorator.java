package com.restaurant.patterns.decorator;
import com.restaurant.models.Dish;

public class SpicyDecorator extends DishDecorator {
    public SpicyDecorator(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return decoratedDish.getDescription() + " + Spicy Sauce ";
    }

    @Override
    public double getPrice() {
        return decoratedDish.getPrice() + 1.00;
    }
}