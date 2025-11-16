package com.restaurant.patterns.decorator;

import com.restaurant.models.Dish;

public abstract class DishDecorator extends Dish {
    protected Dish decoratedDish;

    public DishDecorator(Dish dish) {
        super(dish.getName(), dish.getPrice());
        this.decoratedDish = dish;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getPrice();
}