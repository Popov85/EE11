package com.goit.popov.ee09.service;

import com.goit.popov.ee09.model.Employee;

import java.util.List;

/**
 * Created by Andrey on 10/18/2016.
 */
public interface EmployeeService {
        int insert(Employee employee);
        void update(Employee employee);
        List<Employee> getAll();
        Employee getByName(String name);
        void delete(int id);
        Employee getById(int id);
}
