package com.goit.popov.ee09.dao.entity;

import com.goit.popov.ee09.model.Employee;
/**
 * EmployeeDAO interface for CRUD operations
 * @Author: Andrey P.
 * @version 1.0
 */
public interface EmployeeDAO extends GenericDAO<Employee> {
        Employee getById(int id);
}
