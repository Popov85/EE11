package com.goit.popov.ee09.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey on 11/4/2016.
 */
@Entity
public class Waiter extends Employee {

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "waiter")
        List<Order> orders;


        public List<Order> getOrders() {
                return orders;
        }

        public void setOrders(List<Order> orders) {
                this.orders = orders;
        }

        @Override
        public String toString() {
                return "Waiter{" +
                        "id='" + id + '\'' +
                        "name='" + name + '\'' +
                        ", dob=" + dob +
                        ", phone='" + phone + '\'' +
                        ", position=" + position +
                        ", salary=" + salary +
                        ", orders=" + orders +
                        '}';
        }
}
