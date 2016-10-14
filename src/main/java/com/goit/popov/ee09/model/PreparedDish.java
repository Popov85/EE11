package com.goit.popov.ee09.model;

/**
 * Created by Andrey on 10/14/2016.
 */
public class PreparedDish {
        private int id;

        private Dish dish;

        private Employee employee;

        private Order order;

        public int getId() {
                return id;
        }

        public Dish getDish() {
                return dish;
        }

        public Employee getEmployee() {
                return employee;
        }

        public Order getOrder() {
                return order;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setDish(Dish dish) {
                this.dish = dish;
        }

        public void setEmployee(Employee employee) {
                this.employee = employee;
        }

        public void setOrder(Order order) {
                this.order = order;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                PreparedDish that = (PreparedDish) o;

                if (id != that.id) return false;
                if (!dish.equals(that.dish)) return false;
                if (!employee.equals(that.employee)) return false;
                return order.equals(that.order);

        }

        @Override
        public int hashCode() {
                int result = id;
                result = 31 * result + dish.hashCode();
                result = 31 * result + employee.hashCode();
                result = 31 * result + order.hashCode();
                return result;
        }

        @Override
        public String toString() {
                return "PreparedDish{" +
                        "id=" + id +
                        ", dish=" + dish +
                        ", employee=" + employee +
                        ", order=" + order +
                        '}';
        }
}
