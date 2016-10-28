package com.goit.popov.ee09.dao.implJPA;

import com.goit.popov.ee09.dao.entity.DishDAO;
import com.goit.popov.ee09.model.Dish;
import com.goit.popov.ee09.model.Ingredient;

import java.util.List;

/**
 * Created by Andrey on 28.10.2016.
 */
public class DishDAOImplJPA implements DishDAO {

        @Override
        public int insert(Dish dish) {
                return 0;
        }

        @Override
        public void update(Dish dish) {

        }

        @Override
        public List<Dish> getAll() {
                return null;
        }

        @Override
        public Dish getById(int id) {
                return null;
        }

        @Override
        public void delete(Dish dish) {

        }

        @Override
        public List<Ingredient> getIngredients(Dish dish) {
                return null;
        }

        @Override
        public boolean isIngredientsInStock(Dish dish) {
                return false;
        }
}
