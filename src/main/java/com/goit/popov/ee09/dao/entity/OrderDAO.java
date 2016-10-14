package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.Dish;
import com.goit.popov.ee09.model.Order;

import java.util.List;

/**
 * Created by Andrey on 10/14/2016.
 */
public interface OrderDAO extends GenericDAO<Order> {
        void addDish(Dish dish);
        void deleteDish(Dish dish);
        void close();
        List<Order> getAllClosed();
        List<Order> getAllOpened();
}
