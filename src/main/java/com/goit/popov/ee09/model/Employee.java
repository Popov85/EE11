package com.goit.popov.ee09.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Employee class
 * @Author: Andrey P.
 * @version 1.0
 */
public class Employee {

        private int id;

        private String name;

        private Date dob;

        private String phone;

        private Position position;

        private BigDecimal salary;

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public Date getDob() {
                return dob;
        }

        public String getPhone() {
                return phone;
        }

        public Position getPosition() {
                return position;
        }

        public BigDecimal getSalary() {
                return salary;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setDob(Date dob) {
                this.dob = dob;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public void setPosition(Position position) {
                this.position = position;
        }

        public void setSalary(BigDecimal salary) {
                this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Employee employee = (Employee) o;

                if (!name.equals(employee.name)) return false;
                if (!dob.equals(employee.dob)) return false;
                return phone.equals(employee.phone);

        }

        @Override
        public int hashCode() {
                int result = name.hashCode();
                result = 31 * result + dob.hashCode();
                result = 31 * result + phone.hashCode();
                return result;
        }

        @Override
        public String toString() {
                return "Employee{" +
                        "id='" + id + '\'' +
                        "name='" + name + '\'' +
                        ", dob=" + dob +
                        ", phone='" + phone + '\'' +
                        ", position=" + position +
                        ", salary=" + salary +
                        '}';
        }
}
