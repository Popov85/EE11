package com.goit.popov.ee09.service;

import com.goit.popov.ee09.dao.entity.EmployeeDAO;
import com.goit.popov.ee09.dao.impl.EmployeeDAOImpl;
import com.goit.popov.ee09.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Andrey on 10/18/2016.
 */
public class EmployeeServiceImpl implements EmployeeService {

        private EmployeeDAO employeeDAO;

        @Override
        public int insert(Employee employee) {
                return 0;
        }

        @Override
        public void update(Employee employee) {

        }

        @Override
        public List<Employee> getAll() {
                return employeeDAO.getAll();
        }

        @Override
        public Employee getByName(String name) {
                return null;
        }

        @Override
        public void delete(int id) {

        }
}
