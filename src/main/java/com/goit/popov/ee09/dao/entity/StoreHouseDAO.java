package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.StoreHouse;
import java.util.List;

/**
 * StoreHouseDAO interface for basic CRUD operations
 * @Author: Andrey P.
 * @version 1.0
 */
public interface StoreHouseDAO extends GenericDAO<StoreHouse> {
        /*
        Obtains all the ingredients that are present in stock
        in very small quantities (less than a predefined threshold
        value, say 10 kg/L)
         */
        List<StoreHouse> getAllRunOut(double threshold);
}
