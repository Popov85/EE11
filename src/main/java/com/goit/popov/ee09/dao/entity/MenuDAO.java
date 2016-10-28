package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.Dish;
import com.goit.popov.ee09.model.Menu;

/**
 * MenuDAO interface for CRUD and add/delete operations
 * @Author: Andrey P.
 * @version 1.0
 */
public interface MenuDAO extends GenericDAO<Menu> {

        void addDish(Dish dish);

        void deleteDish(Dish dish);

}
