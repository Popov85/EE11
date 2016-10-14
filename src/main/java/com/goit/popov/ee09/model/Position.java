package com.goit.popov.ee09.model;

/**
 * Positions class, positions available at restaurant
 * @Author: Andrey P.
 * @version 1.0
 */
public class Position {

        private int id;

        private String name;

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Position position = (Position) o;

                if (id != position.id) return false;
                return name.equals(position.name);

        }

        @Override
        public int hashCode() {
                int result = id;
                result = 31 * result + name.hashCode();
                return result;
        }

        @Override
        public String toString() {
                return "Position{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
        }
}
