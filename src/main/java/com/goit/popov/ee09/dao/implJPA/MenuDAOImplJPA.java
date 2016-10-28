package com.goit.popov.ee09.dao.implJPA;

import com.goit.popov.ee09.dao.entity.MenuDAO;
import com.goit.popov.ee09.model.Dish;
import com.goit.popov.ee09.model.Menu;

import java.util.List;

/**
 * Created by Andrey on 28.10.2016.
 */
public class MenuDAOImplJPA implements MenuDAO {

        @Override
        public int insert(Menu menu) {
                return 0;
        }

        @Override
        public void update(Menu menu) {

        }

        @Override
        public List<Menu> getAll() {
                return null;
        }

        @Override
        public Menu getById(int id) {
                return null;
        }

        @Override
        public void delete(Menu menu) {

        }

        @Override
        public void addDish(Dish dish) {

        }

        @Override
        public void deleteDish(Dish dish) {

        }
}
