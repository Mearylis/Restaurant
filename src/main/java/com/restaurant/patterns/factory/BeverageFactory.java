package com.restaurant.patterns.factory;
import com.restaurant.models.Dish;

public class BeverageFactory extends DishFactory {
    @Override
    public Dish createDish(String name, double price) {
        Dish dish = new Dish(name, price);
        dish.setCategory("Beverage");
        return dish;
    }
}