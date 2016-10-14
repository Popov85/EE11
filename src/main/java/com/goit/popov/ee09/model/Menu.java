package com.goit.popov.ee09.model;

import java.util.List;

/**
 * Menu class. A restaurant menu consists of a number of Dishes
 * @Author: Andrey P.
 * @version 1.0
 */
public class Menu {
        private int id;

        private String name;

        private List<Dish> dishes;

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public List<Dish> getDishes() {
                return dishes;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setDishes(List<Dish> dishes) {
                this.dishes = dishes;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Menu menu = (Menu) o;

                if (id != menu.id) return false;
                if (!name.equals(menu.name)) return false;
                return dishes.equals(menu.dishes);
        }

        @Override
        public int hashCode() {
                int result = id;
                result = 31 * result + name.hashCode();
                result = 31 * result + dishes.hashCode();
                return result;
        }

        @Override
        public String toString() {
                return "Menu{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", dishes=" + dishes +
                        '}';
        }
}
