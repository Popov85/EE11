package com.goit.popov.ee09.dao;

import com.goit.popov.ee09.dao.entity.EmployeeDAO;
import com.goit.popov.ee09.dao.implJPA.EmployeeDAOImplJPA;
import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.model.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrey on 10/17/2016.
 */
public class EmployeeDAOTest {

        private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-mm-dd");

        private static final String NAME = "Mr. Test";
        private static final String DOB = "1990-10-25";
        private static final String PHONE = "+380669856352";
        private static final BigDecimal SALARY = new BigDecimal(12000);
        // 1 - Manager, 2 - Chef, 3 - Waiter
        private static final int POSITION_ID = 1;

        private EmployeeDAO employeeDAO;
        private Employee employee;
        private Position position;

        @Before
        public void setUp() throws Exception {
                employeeDAO = new EmployeeDAOImplJPA();
                employee = new Employee();
                employee.setName(NAME);
                employee.setDob(FORMAT.parse(DOB));
                employee.setPhone(PHONE);
                employee.setSalary(SALARY);
                position = new Position();
                position.setId(POSITION_ID);
                employee.setPosition(position);
        }

        @After
        public void tearDown() throws Exception {
        }

        @Test
        public void insert() {
                EmployeeHelper.delete();
                int idGenerated = employeeDAO.insert(employee);
                assertEquals(idGenerated, 1);
                Employee expected = EmployeeHelper.getById(1);
                assertEquals(expected, employee);
        }

        @Test
        public void update() {
                assertEquals(0, 0);
        }

        @Test
        public void getAll() {
                assertEquals(0, 0);
        }

        @Test
        public void getByName() {
                assertEquals(0, 0);
        }

        @Test
        public void delete() {
                assertEquals(0, 0);
        }
}
