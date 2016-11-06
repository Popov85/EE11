package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.Dish;
import com.goit.popov.ee09.model.Ingredient;

import java.util.Map;

/**
 * DishDAO interface
 * @Author: Andrey P.
 * @version 1.0
 */
public interface DishDAO extends GenericDAO<Dish> {

        //Gets all the ingredients needed to prepare a Dish
        Map<Ingredient, Double> getIngredients(int id);

        /**
         * @param: id - Dish we want to check
         * @param: number - quantity of dishes
         * */
        boolean validateIngredients(int id, int number);
}
