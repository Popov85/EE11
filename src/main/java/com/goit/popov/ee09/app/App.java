package com.goit.popov.ee09.app;

import com.goit.popov.ee09.dao.entity.EmployeeDAO;
import com.goit.popov.ee09.dao.entity.PositionDAO;
import com.goit.popov.ee09.dao.impl.EmployeeDAOImpl;
import com.goit.popov.ee09.dao.impl.PositionDAOImpl;
import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.model.Position;
import com.goit.popov.ee09.service.EmployeeService;
import com.goit.popov.ee09.service.EmployeeServiceImpl;
import com.goit.popov.ee09.service.PositionServiceImpl;
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
                /*EmployeeDAO employeeDAO = applicationContext.getBean("employeeDAO", EmployeeDAOImpl.class);
                Employee employee = employeeDAO.getByName("Mr. Black");
                System.out.println("Employee by name is: "+employee.toString());

                System.out.println("All existing employees are: ");
                List<Employee> employees = employeeDAO.getAll();
                for (Employee emp : employees) {
                        System.out.println(emp.toString());
                }
                System.out.println("Finished!");*/


                /*EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeServiceImpl.class);

                System.out.println("All existing employees are: ");
                List<Employee> employees = employeeService.getAll();
                for (Employee emp : employees) {
                        System.out.println(emp.toString());
                }
                System.out.println("Finished!");*/

                PositionServiceImpl positionDAO = applicationContext.getBean("positionService", PositionServiceImpl.class);
                System.out.println("All existing employees are: ");
                List<Position> positions = positionDAO.getPositions();
                for (Position pos : positions) {
                        System.out.println(pos.toString());
                }
                System.out.println("Finished!");
        }
}
