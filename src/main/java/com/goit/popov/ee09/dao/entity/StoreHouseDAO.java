package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.Ingredient;

import java.util.List;

/**
 * StoreHouseDAO interface for basic CRUD operations
 * @Author: Andrey P.
 * @version 1.0
 */
public interface StoreHouseDAO extends GenericDAO<Ingredient> {
        List<Ingredient> getAllRunOut();
}
