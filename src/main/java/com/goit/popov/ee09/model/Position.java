package com.goit.popov.ee09.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Positions class, positions available at restaurant
 * @Author: Andrey P.
 * @version 1.0
 */
@Entity
public class Position {

        @Id
        @GeneratedValue(generator = "increment")
        @GenericGenerator(name = "increment", strategy = "increment")
        private int id;

        @Column(name = "title")
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

                return name.equals(position.name);

        }

        @Override
        public int hashCode() {
                return name.hashCode();
        }

        @Override
        public String toString() {
                return "Position{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
        }
}
