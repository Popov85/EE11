package com.goit.popov.ee09.service;

import com.goit.popov.ee09.dao.entity.EmployeeDAO;
import com.goit.popov.ee09.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Andrey on 10/18/2016.
 */
public class EmployeeServiceImpl implements EmployeeService {

        @Autowired
        private EmployeeDAO employeeDAO;

        public void setEmployeeDAO(EmployeeDAO employeeDAO) {
                this.employeeDAO = employeeDAO;
        }

        @Override
        public int insert(Employee employee) {
                return employeeDAO.insert(employee);
        }

        @Override
        public void update(Employee employee) {
                employeeDAO.update(employee);
        }

        @Override
        public List<Employee> getAll() {
                return employeeDAO.getAll();
        }

        @Override
        public Employee getByName(String name) {
                return employeeDAO.getByName(name);
        }

        @Override
        public void delete(int id) {
                Employee employee = getById(id);
                employeeDAO.delete(employee);
        }

        @Override
        public Employee getById(int id) {
                return employeeDAO.getById(id);
        }
}
