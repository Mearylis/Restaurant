package com.restaurant.patterns.decorator;
import com.restaurant.models.Dish;

public class BaconDecorator extends DishDecorator {
    public BaconDecorator(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return decoratedDish.getDescription() + " + Bacon";
    }

    @Override
    public double getPrice() {
        return decoratedDish.getPrice() + 3.50;
    }
}