package com.goit.popov.ee09.model;

/**
 * StoreHouse class keeps info about ingredients in stock and their quantity
 * @Author: Andrey P.
 * @version 1.0
 */
public class StoreHouse {

        private Ingredient ingredient;

        private String quantity;

        public Ingredient getIngredient() {
                return ingredient;
        }

        public String getQuantity() {
                return quantity;
        }

        public void setIngredient(Ingredient ingredient) {
                this.ingredient = ingredient;
        }

        public void setQuantity(String quantity) {
                this.quantity = quantity;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                StoreHouse that = (StoreHouse) o;

                if (!ingredient.equals(that.ingredient)) return false;
                return quantity.equals(that.quantity);

        }

        @Override
        public int hashCode() {
                int result = ingredient.hashCode();
                result = 31 * result + quantity.hashCode();
                return result;
        }

        @Override
        public String toString() {
                return "StoreHouse{" +
                        "ingredient=" + ingredient +
                        ", quantity='" + quantity + '\'' +
                        '}';
        }
}
