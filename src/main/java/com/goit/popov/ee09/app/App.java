package com.goit.popov.ee09.app;

import com.goit.popov.ee09.dao.entity.EmployeeDAO;
import com.goit.popov.ee09.dao.impl.EmployeeDAOImpl;
import com.goit.popov.ee09.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Andrey on 10/14/2016.
 */
public class App {
        private static ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml");
        public static void main(String[] args) {
                EmployeeDAO employeeDAO = applicationContext.getBean("employeeDAO", EmployeeDAOImpl.class);
                Employee employee = employeeDAO.getByName("Mr. Black");
                System.out.println("Employee by name is: "+employee.toString());

                System.out.println("All existing employees are: ");
                List<Employee> employees = employeeDAO.getAll();
                for (Employee emp : employees) {
                        System.out.println(emp.toString());
                }
                System.out.println("Finished!");
        }
}
