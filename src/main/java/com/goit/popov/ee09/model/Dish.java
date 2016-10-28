package com.goit.popov.ee09.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Dish class
 * @Author: Andrey P.
 * @version 1.0
 */
@Entity
@Table(name = "dish")
public class Dish {
        @Id
        @GeneratedValue(generator = "increment")
        @GenericGenerator(name = "increment", strategy = "increment")
        @Column(name = "id")
        private int id;

        @Column(name = "dish_name")
        private String name;

        @Column(name = "category")
        private String category;

        @Column(name = "price")
        private BigDecimal price;

        @Column(name = "weight")
        private double weight;

        @ManyToMany
        @JoinTable(name = "dish_ingredient",
                joinColumns = @JoinColumn(name = "dish_id"),
                inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
        private List<Ingredient> ingredients;

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getCategory() {
                return category;
        }

        public BigDecimal getPrice() {
                return price;
        }

        public double getWeight() {
                return weight;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public void setPrice(BigDecimal price) {
                this.price = price;
        }

        public void setWeight(double weight) {
                this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Dish dish = (Dish) o;

                if (id != dish.id) return false;
                if (Double.compare(dish.weight, weight) != 0) return false;
                if (!name.equals(dish.name)) return false;
                if (!category.equals(dish.category)) return false;
                return price.equals(dish.price);

        }

        @Override
        public int hashCode() {
                int result;
                long temp;
                result = id;
                result = 31 * result + name.hashCode();
                result = 31 * result + category.hashCode();
                result = 31 * result + price.hashCode();
                temp = Double.doubleToLongBits(weight);
                result = 31 * result + (int) (temp ^ (temp >>> 32));
                return result;
        }

        @Override
        public String toString() {
                return "Dish{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", category='" + category + '\'' +
                        ", price=" + price +
                        ", weight=" + weight +
                        '}';
        }
}
