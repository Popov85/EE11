package com.goit.popov.ee09.app;

import com.goit.popov.ee09.dao.entity.EmployeeDAO;
import com.goit.popov.ee09.dao.entity.OrderDAO;
import com.goit.popov.ee09.dao.entity.StoreHouseDAO;
import com.goit.popov.ee09.dao.impl.EmployeeDAOImplJPA;
import com.goit.popov.ee09.dao.entity.WaiterDAO;
import com.goit.popov.ee09.dao.impl.OrderDAOImplJPA;
import com.goit.popov.ee09.dao.impl.StoreHouseDAOImplJPA;
import com.goit.popov.ee09.dao.impl.WaiterDAOImplJPA;
import com.goit.popov.ee09.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by Andrey on 10/14/2016.
 */
public class App {

        private static ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml","hibernate-context.xml");

        public static void main(String[] args) {
                EmployeeDAO employeeDAO = (EmployeeDAOImplJPA) applicationContext.getBean("employeeDAO");
                OrderDAO orderDAO = (OrderDAOImplJPA) applicationContext.getBean("orderDAO");
                StoreHouseDAO stock = (StoreHouseDAOImplJPA) applicationContext.getBean("stockDAO");
                /*Employee employee = new Manager();
                employee.setName("Mr. Test");
                employee.setDob(new Date());
                employee.setPhone("+30969999999");
                employee.setSalary(new BigDecimal(19600));
                Position position = new Position();
                position.setId(1);
                position.setName("Manager");
                employee.setPosition(position);
                try {
                        System.out.println("Trying to insert");
                        System.out.println("New id= "+employeeDAO.insert(employee));
                        System.out.println("Inserted!");
                } catch (Throwable e) {
                        System.out.println(e.getMessage());
                        System.out.println("Failed to insert...");
                }*/

                /*Employee employee = new Employee();
                employee.setId(6);
                employee.setName("Mr. AnotherTest");
                employee.setDob(new Date());
                employee.setPhone("+30990663252");
                employee.setSalary(new BigDecimal(10499));
                Position position = new Position();
                position.setId(2);
                position.setName("Chef");
                employee.setPosition(position);

                employeeDAO.update(employee);*/


                //PositionServiceImpl positionDAO = applicationContext.getBean("positionService", PositionServiceImpl.class);*/
                /*System.out.println("All existing employees are: ");
                List<Employee> employees = employeeDAO.getAll();*/
                /*System.out.println("All existing waiters are: ");
                List<Waiter> employees = waiterDAO.getAll();
                for (Employee emp : employees) {
                        System.out.println(emp);
                }*/
                /*Employee employee = employeeDAO.getByName("Mr. Black");
                System.out.println(employee);*/


                /*System.out.println("All existing orders are: ");
                List<Order> orders = orderDAO.getAll();
                for (Order order : orders) {
                        System.out.println(order);
                        Map<Dish, Integer> dishes = order.getDishes();
                        System.out.println("Dishes of this order "+order.getId());
                        for (Dish dish : dishes.keySet()) {
                                System.out.println(dish.toString());
                        }
                }*/

                System.out.println("Stock condition:");
                List<StoreHouse> ingredients = stock.getAll();
                for (StoreHouse ingredient : ingredients) {
                        System.out.println(ingredient.toString());
                }
                System.out.println("Finished!");
        }

}
