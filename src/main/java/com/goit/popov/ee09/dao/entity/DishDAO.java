package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.Dish;
import com.goit.popov.ee09.model.DishIngredient;

import java.util.List;

/**
 * DishDAO interface
 * @Author: Andrey P.
 * @version 1.0
 */
public interface DishDAO extends GenericDAO<Dish> {

        //Gets all the ingredients needed to prepare a Dish
        List<DishIngredient> getIngredients(int id);
        /*
        @param: id - id of Dish we want to check
        if there are all needed ingredients are available in stock.
         */
        boolean isIngredientsInStock(int id);
}
