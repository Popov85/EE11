package com.goit.popov.ee09.app;

import com.goit.popov.ee09.dao.entity.EmployeeDAO;
import com.goit.popov.ee09.dao.impl.EmployeeDAOImpl;
import com.goit.popov.ee09.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Andrey on 10/14/2016.
 */
public class App {
        private static ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml");
        public static void main(String[] args) {
                EmployeeDAO employeeDAO = applicationContext.getBean("employeeDAOImpl", EmployeeDAOImpl.class);
                Employee employee = employeeDAO.getByName("Mr. Black");
                employee.toString();
                System.out.println("Finished!");
        }
}
