package com.goit.popov.ee09.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Order class. A restaurant order is made by its visitors, it may contain many dishes
 * @Author: Andrey P.
 * @version 1.0
 */
@Entity
@Table(name = "order")
public class Order {
        @Id
        @GeneratedValue(generator = "increment")
        @GenericGenerator(name = "increment", strategy = "increment")
        @Column(name = "id")
        private int id;

        //Closed order cannot be deleted from the DB.
        @Column(name = "is_opened")
        private boolean isOpened;

        @Column(name = "opened_date")
        private Date orderTimeStamp;

        @Column(name = "table_number")
        private int table;

        @ManyToOne
        @JoinColumn(name = "employee_id")
        private Employee employee;

        @ManyToMany
        @JoinTable(name = "dish_order",
                joinColumns = @JoinColumn(name = "order_id"),
                inverseJoinColumns = @JoinColumn(name = "dish_id"))
        private List<Dish> dishes;

        public int getId() {
                return id;
        }

        public boolean isOpened() {
                return isOpened;
        }

        public Date getOrderTimeStamp() {
                return orderTimeStamp;
        }

        public int getTable() {
                return table;
        }

        public Employee getEmployee() {
                return employee;
        }

        public List<Dish> getDishes() {
                return dishes;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setOpened(boolean opened) {
                isOpened = opened;
        }

        public void setOrderTimeStamp(Date orderTimeStamp) {
                this.orderTimeStamp = orderTimeStamp;
        }

        public void setTable(int table) {
                this.table = table;
        }

        public void setEmployee(Employee employee) {
                this.employee = employee;
        }

        public void setDishes(List<Dish> dishes) {
                this.dishes = dishes;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Order order = (Order) o;

                if (id != order.id) return false;
                if (isOpened != order.isOpened) return false;
                return orderTimeStamp.equals(order.orderTimeStamp);

        }

        @Override
        public int hashCode() {
                int result = id;
                result = 31 * result + (isOpened ? 1 : 0);
                result = 31 * result + orderTimeStamp.hashCode();
                return result;
        }

        @Override
        public String toString() {
                return "Order{" +
                        "id=" + id +
                        ", isOpened=" + isOpened +
                        ", orderTimeStamp=" + orderTimeStamp +
                        ", table=" + table +
                        ", employee=" + employee +
                        ", dishes=" + dishes +
                        '}';
        }
}
