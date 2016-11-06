package com.goit.popov.ee09.model;

import javax.persistence.*;

/**
 * Created by Andrey on 10/28/2016.
 */
@Deprecated
/*@Entity
@Table(name = "order_dish")*/
public class OrderDish {
        @ManyToMany
        @JoinTable(name = "order_dish",
                joinColumns = @JoinColumn(name = "order_id"),
                inverseJoinColumns = @JoinColumn(name = "dish_id"))
        private Dish dish;

        @Column(name = "quantity")
        private double quantityOrdered;

        public Dish getDish() {
                return dish;
        }

        public void setDish(Dish dish) {
                this.dish = dish;
        }

        public double getQuantityOrdered() {
                return quantityOrdered;
        }

        public void setQuantityOrdered(double quantityOrdered) {
                this.quantityOrdered = quantityOrdered;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                OrderDish orderDish = (OrderDish) o;

                if (Double.compare(orderDish.quantityOrdered, quantityOrdered) != 0) return false;
                return dish.equals(orderDish.dish);

        }

        @Override
        public int hashCode() {
                int result;
                long temp;
                result = dish.hashCode();
                temp = Double.doubleToLongBits(quantityOrdered);
                result = 31 * result + (int) (temp ^ (temp >>> 32));
                return result;
        }

        @Override
        public String toString() {
                return "OrderDish{" +
                        "dish=" + dish +
                        ", quantityOrdered=" + quantityOrdered +
                        '}';
        }
}
