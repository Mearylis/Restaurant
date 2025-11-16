package com.restaurant.patterns.decorator;
import com.restaurant.models.Dish;

public class GlutenFreeDecorator extends DishDecorator {
    public GlutenFreeDecorator(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return decoratedDish.getDescription() + " (Gluten Free)";
    }

    @Override
    public double getPrice() {
        return decoratedDish.getPrice() + 2.50;
    }
}