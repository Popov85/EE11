package com.goit.popov.ee09.dao.implJPA;

import com.goit.popov.ee09.dao.entity.IngredientDAO;
import com.goit.popov.ee09.model.Ingredient;

import java.util.List;

/**
 * Created by Andrey on 28.10.2016.
 */
public class IngredientDAOImplJPA implements IngredientDAO {

        @Override
        public int insert(Ingredient ingredient) {
                return 0;
        }

        @Override
        public void update(Ingredient ingredient) {

        }

        @Override
        public List<Ingredient> getAll() {
                return null;
        }

        @Override
        public Ingredient getById(int id) {
                return null;
        }

        @Override
        public void delete(Ingredient ingredient) {

        }
}
