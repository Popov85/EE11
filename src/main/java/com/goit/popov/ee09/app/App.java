package com.goit.popov.ee09.app;

import com.goit.popov.ee09.dao.entity.EmployeeDAO;
import com.goit.popov.ee09.dao.impl.EmployeeDAOImpl;
import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.model.Position;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrey on 10/14/2016.
 */
public class App {

        private static ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml");

        public static void main(String[] args) {
                EmployeeDAO employeeDAO = (EmployeeDAOImpl) applicationContext.getBean("employeeDAO");
                /*Employee employee = new Employee();
                employee.setName("Mr. FifthTest");
                employee.setDob(new Date());
                employee.setPhone("+30502365920");
                employee.setSalary(new BigDecimal(9750));
                Position position = new Position();
                position.setId(3);
                position.setName("Waiter");
                employee.setPosition(position);
                try {
                        System.out.println("Trying to insert");
                        System.out.println("New id= "+employeeDAO.insert(employee));
                        System.out.println("Inserted!");
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Failed to insert...");
                }*/

                Employee employee = new Employee();
                employee.setId(6);
                employee.setName("Mr. AnotherTest");
                employee.setDob(new Date());
                employee.setPhone("+30990663252");
                employee.setSalary(new BigDecimal(10499));
                Position position = new Position();
                position.setId(2);
                position.setName("Chef");
                employee.setPosition(position);

                employeeDAO.update(employee);


                /*PositionServiceImpl positionDAO = applicationContext.getBean("positionService", PositionServiceImpl.class);*/
                System.out.println("All existing employees are: ");
                List<Employee> employees = employeeDAO.getAll();
                for (Employee emp : employees) {
                        System.out.println(emp);
                }
                System.out.println("Finished!");
        }

}
