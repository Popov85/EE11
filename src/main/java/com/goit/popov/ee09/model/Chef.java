package com.goit.popov.ee09.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Andrey on 11/4/2016.
 */
@Entity
public class Chef extends Employee {

        @OneToMany(mappedBy="chef")
        List<PreparedDish> preparedDishes;
}
