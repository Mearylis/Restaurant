package com.restaurant.patterns.factory;

import com.restaurant.models.Dish;


public abstract class DishFactory {
    public abstract Dish createDish(String name, double price);

    public Dish orderDish(String name, double price) {
        Dish dish = createDish(name, price);
        System.out.println(" Factory created: " + dish.getDescription());
        return dish;
    }
}