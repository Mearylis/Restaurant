package com.restaurant.patterns.factory;

import com.restaurant.models.Dish;

public class MainCourseFactory extends DishFactory {
    @Override
    public Dish createDish(String name, double price) {
        Dish dish = new Dish(name, price);
        dish.setCategory("Main Course");
        return dish;
    }
}

