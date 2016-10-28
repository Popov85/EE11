package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.PreparedDish;

import java.util.List;

/**
 * Created by Andrey on 10/14/2016.
 */
public interface PreparedDishHistoryDAO {
        int addPreparedDish(PreparedDish dish);
        List<PreparedDish> getAll();
}
