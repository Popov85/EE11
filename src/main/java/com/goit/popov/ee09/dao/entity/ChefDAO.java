package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.Chef;

/**
 * Created by Andrey on 11/5/2016.
 */
public interface ChefDAO extends GenericDAO<Chef> {
        Chef getByName(String name);
}
