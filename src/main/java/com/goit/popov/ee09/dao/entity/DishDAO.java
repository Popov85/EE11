package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.Dish;
import com.goit.popov.ee09.model.Ingredient;

import java.util.List;

/**
 * DishDAO interface
 * @Author: Andrey P.
 * @version 1.0
 */
public interface DishDAO extends GenericDAO<Dish> {
        List<Ingredient> getIngredients(Dish dish);
        boolean isIngredientsInStock(Dish dish);
}
