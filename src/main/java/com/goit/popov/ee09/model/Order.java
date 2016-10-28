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
        private Date openedTimeStamp;

        @Column(name = "closed_date")
        private Date closedTimeStamp;

        @Column(name = "table_number")
        private int table;

        @ManyToOne
        @JoinColumn(name = "employee_id")
        private Employee employee;

        @ManyToMany
        @JoinTable(name = "dish_order",
                joinColumns = @JoinColumn(name = "order_id"),
                inverseJoinColumns = @JoinColumn(name = "dish_id"))
        private List<OrderDish> dishes;

        public int getId() {
                return id;
        }

        public boolean isOpened() {
                return isOpened;
        }

        public int getTable() {
                return table;
        }

        public Employee getEmployee() {
                return employee;
        }

        public List<OrderDish> getDishes() {
                return dishes;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setOpened(boolean opened) {
                isOpened = opened;
        }

        public void setTable(int table) {
                this.table = table;
        }

        public void setEmployee(Employee employee) {
                this.employee = employee;
        }

        public void setDishes(List<OrderDish> dishes) {
                this.dishes = dishes;
        }

        public Date getOpenedTimeStamp() {
                return openedTimeStamp;
        }

        public void setOpenedTimeStamp(Date openedTimeStamp) {
                this.openedTimeStamp = openedTimeStamp;
        }

        public Date getClosedTimeStamp() {
                return closedTimeStamp;
        }

        public void setClosedTimeStamp(Date closedTimeStamp) {
                this.closedTimeStamp = closedTimeStamp;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Order order = (Order) o;

                if (isOpened != order.isOpened) return false;
                if (table != order.table) return false;
                if (!openedTimeStamp.equals(order.openedTimeStamp)) return false;
                if (closedTimeStamp != null ? !closedTimeStamp.equals(order.closedTimeStamp) : order.closedTimeStamp != null)
                        return false;
                if (!employee.equals(order.employee)) return false;
                return dishes.equals(order.dishes);

        }

        @Override
        public int hashCode() {
                int result = (isOpened ? 1 : 0);
                result = 31 * result + openedTimeStamp.hashCode();
                result = 31 * result + (closedTimeStamp != null ? closedTimeStamp.hashCode() : 0);
                result = 31 * result + table;
                result = 31 * result + employee.hashCode();
                result = 31 * result + dishes.hashCode();
                return result;
        }

        @Override
        public String toString() {
                return "Order{" +
                        "id=" + id +
                        ", isOpened=" + isOpened +
                        ", openedTimeStamp=" + openedTimeStamp +
                        ", closedTimeStamp=" + closedTimeStamp +
                        ", table=" + table +
                        ", employee=" + employee +
                        ", dishes=" + dishes +
                        '}';
        }
}
