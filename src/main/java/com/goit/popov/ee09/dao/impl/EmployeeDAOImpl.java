package com.goit.popov.ee09.dao.impl;

import com.goit.popov.ee09.dao.entity.EmployeeDAO;
import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.model.Position;
import org.apache.commons.dbcp2.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * EmployeeDAO implementation for CRUD operations
 * @Author: Andrey P.
 * @version 1.0
 */
public class EmployeeDAOImpl implements EmployeeDAO {

        private DataSource dataSource;

        private static final String ERROR = "Cannot get employee id from database...";

        private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOImpl.class);

        private static final String INSERT_SQL = "INSERT INTO employee (name, dob, phone, position, salary)" +
                " VALUES (?, ?, ?, ?, ?)";

        private static final String SELECT_NAME_SQL = "SELECT *" +
                " FROM employee WHERE";


        public void setDataSource(DataSource dataSource) {
                this.dataSource = dataSource;
        }

        @Override
        public int insert(Employee employee) {
                int id;
                try (Connection connection = dataSource.getConnection();
                     PreparedStatement statement = connection.prepareStatement(INSERT_SQL,
                             Statement.RETURN_GENERATED_KEYS)) {
                        statement.setString(1, employee.getName());
                        statement.setTimestamp(2, new java.sql.Timestamp(employee.getDob().getTime()));
                        statement.setString(3, employee.getPhone());
                        statement.setBigDecimal(4, employee.getSalary());
                        if (1 == statement.executeUpdate() && statement.getGeneratedKeys().next()) {
                                id = statement.getGeneratedKeys().getInt("id");
                                employee.setId(id);
                        } else {
                                LOGGER.error(ERROR);
                                throw new RuntimeException(ERROR);
                        }
                        LOGGER.info("INSERT NEW employee " + employee.toString());

                } catch (SQLException ex) {
                        LOGGER.error(ex.getMessage());
                        throw new RuntimeException(ex);
                }
                return id;
        }

        @Override
        public void update(Employee employee) {

        }

        @Override
        public List<Employee> getAll() {
                return null;
        }

        @Override
        public Employee getByName(String name) {
                ResultSet resultSet = null;
                Employee employee;
                Position position;
                try (Connection connection = dataSource.getConnection();
                     PreparedStatement statement = connection.prepareStatement(SELECT_NAME_SQL + " name = ?")) {
                        statement.setString(1, name);
                        resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                                employee = new Employee();
                                position = new Position();
                                employee.setId(resultSet.getInt("id"));
                                employee.setName(resultSet.getString("name"));
                                employee.setDob(resultSet.getTimestamp("dob"));
                                employee.setPhone(resultSet.getString("phone"));
                                position.setId(resultSet.getInt("position_id"));
                                employee.setPosition(position);
                                employee.setSalary(resultSet.getBigDecimal("salary"));
                                LOGGER.info("GET EMPLOYEE BY NAME " + employee.toString());

                        } else {
                                LOGGER.error("Error loading Employee form DB...");
                                throw new RuntimeException("Error loading Employee form DB...");
                        }

                } catch (SQLException ex) {
                        LOGGER.error(ex.getMessage());
                        throw new RuntimeException(ex);
                } finally {
                        if (resultSet != null) {
                                Utils.closeQuietly(resultSet);
                        }
                }
                return employee;
        }

        @Override
        public void delete(int id) {

        }
}
