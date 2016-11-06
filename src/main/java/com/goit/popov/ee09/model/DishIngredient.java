package com.goit.popov.ee09.model;

import javax.persistence.*;

/**
 * Created by Andrey on 10/28/2016.
 */
@Deprecated
/*@Entity
@Table(name = "dish_ingredient")*/
public class DishIngredient {

        @ManyToMany
        @JoinTable(name = "dish_ingredient",
                joinColumns = @JoinColumn(name = "D_ID"),
                inverseJoinColumns = @JoinColumn(name = "ING_ID"))
        private Ingredient ingredient;

        @Column(name = "quantity")
        private double quantityRequired;

        public Ingredient getIngredient() {
                return ingredient;
        }

        public void setIngredient(Ingredient ingredient) {
                this.ingredient = ingredient;
        }

        public double getQuantityRequired() {
                return quantityRequired;
        }

        public void setQuantityRequired(double quantityRequired) {
                this.quantityRequired = quantityRequired;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                DishIngredient that = (DishIngredient) o;

                if (Double.compare(that.quantityRequired, quantityRequired) != 0) return false;
                return ingredient.equals(that.ingredient);

        }

        @Override
        public int hashCode() {
                int result;
                long temp;
                result = ingredient.hashCode();
                temp = Double.doubleToLongBits(quantityRequired);
                result = 31 * result + (int) (temp ^ (temp >>> 32));
                return result;
        }

        @Override
        public String toString() {
                return "DishIngredient{" +
                        "ingredient=" + ingredient +
                        ", quantityRequired=" + quantityRequired +
                        '}';
        }
}
