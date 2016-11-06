package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.Waiter;

/**
 * Created by Andrey on 11/5/2016.
 */
public interface WaiterDAO extends GenericDAO<Waiter> {
        Waiter getByName(String name);
}
