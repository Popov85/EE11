package com.goit.popov.ee09.dao.impl;

import com.goit.popov.ee09.dao.entity.EmployeeDAO;
import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.model.Position;
import org.apache.commons.dbcp2.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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

        private static final String INSERT_SQL = "INSERT INTO employee (name, dob, phone, position_id, salary)" +
                " VALUES (?, ?, ?, ?, ?)";

        private static final String UPDATE_SQL = "UPDATE employee SET name = ?, dob = ?, phone = ?, position_id = ?, salary = ?" +
                " WHERE id = ?";

        private static final String SELECT_NAME_SQL = "SELECT employee.id, employee.name," +
                " dob, phone, position_id, salary, position.title as position_name" +
                " FROM employee INNER JOIN position ON employee.position_id  = position.id WHERE employee.name = ? ";

        private static final String SELECT_ID_SQL = "SELECT employee.id, employee.name," +
                " dob, phone, position_id, salary, position.title as position_name" +
                " FROM employee INNER JOIN position ON employee.position_id  = position.id WHERE employee.id = ? ";

        private static final String SELECT_ALL_SQL = "SELECT employee.id, employee.name," +
                " dob, phone, position_id, salary, position.title as position_name" +
                " FROM employee INNER JOIN position ON employee.position_id  = position.id";

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
                        statement.setDate(2, new java.sql.Date(employee.getDob().getTime()));
                        statement.setString(3, employee.getPhone());
                        statement.setInt(4, employee.getPosition().getId());
                        statement.setBigDecimal(5, employee.getSalary());
                        if (1 == statement.executeUpdate() && statement.getGeneratedKeys().next()) {
                                System.out.println("true");
                                id = statement.getGeneratedKeys().getInt("id");
                                System.out.println("id = "+id);
                                employee.setId(id);
                                System.out.println("set finished");
                        } else {
                                LOGGER.error(ERROR);
                                throw new RuntimeException(ERROR);
                        }
                        System.out.println("last before catch");
                        //LOGGER.info("INSERT NEW employee " + employee.toString());
                } catch (SQLException ex) {
                        LOGGER.error(ex.getMessage());
                        throw new RuntimeException(ex);
                }
                System.out.println("new id = "+id);
                return id;
        }

        @Override
        public void update(Employee employee) {
                try (Connection connection = dataSource.getConnection();
                     PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                        statement.setString(1, employee.getName());
                        //System.out.println("DOB is: "+employee.getDob());
                        statement.setDate(2, new java.sql.Date(employee.getDob().getTime()));
                        statement.setString(3, employee.getPhone());
                        statement.setInt(4, employee.getPosition().getId());
                        statement.setBigDecimal(5, employee.getSalary());
                        statement.setInt(6, employee.getId());
                        statement.executeUpdate();
                        LOGGER.info("UPDATE EMPLOYEE " + employee.toString());
                } catch (SQLException ex) {
                        LOGGER.error(ex.getMessage());
                        throw new RuntimeException(ex);
                }
        }

        @Override
        public List<Employee> getAll() {
                List<Employee> employees = new ArrayList<>();
                Employee employee;
                Position position;
                try (Connection connection = dataSource.getConnection();
                     Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
                        while (resultSet.next()) {
                                employee = new Employee();
                                position = new Position();
                                employee.setId(resultSet.getInt("id"));
                                employee.setName(resultSet.getString("name"));
                                employee.setDob(resultSet.getDate("dob"));
                                employee.setPhone(resultSet.getString("phone"));
                                position.setId(resultSet.getInt("position_id"));
                                position.setName(resultSet.getString("position_name"));
                                employee.setPosition(position);
                                employee.setSalary(resultSet.getBigDecimal("salary"));
                                employees.add(employee);
                        }
                } catch (SQLException ex) {
                        LOGGER.error(ex.getMessage());
                        throw new RuntimeException(ex);
                }
                return employees;
        }

        @Override
        public Employee getByName(String name) {
                ResultSet resultSet = null;
                Employee employee;
                Position position;
                try (Connection connection = dataSource.getConnection();
                     PreparedStatement statement = connection.prepareStatement(SELECT_NAME_SQL)) {
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
                                position.setName(resultSet.getString("position_name"));
                                employee.setPosition(position);
                                employee.setSalary(resultSet.getBigDecimal("salary"));
                                LOGGER.info("GET EMPLOYEE BY NAME " + employee.toString());
                        } else {
                                LOGGER.info("No such Employee in DB...");
                                return null;
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
                final String DELETE_SQL = "DELETE FROM employee WHERE id = ?";
                try (Connection connection = dataSource.getConnection();
                     PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
                        statement.setInt(1, id);
                        statement.executeUpdate();
                        LOGGER.info("DELETE ENTITY WITH ID = " + id + " FROM TABLE " + "employee");
                } catch (SQLException ex) {
                        LOGGER.error(ex.getMessage());
                        throw new RuntimeException(ex);
                }
        }

        @Override
        public Employee getById(int id) {
                ResultSet resultSet = null;
                Employee employee;
                Position position;
                try (Connection connection = dataSource.getConnection();
                     PreparedStatement statement = connection.prepareStatement(SELECT_ID_SQL)) {
                        statement.setInt(1, id);
                        resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                                employee = new Employee();
                                position = new Position();
                                employee.setId(resultSet.getInt("id"));
                                employee.setName(resultSet.getString("name"));
                                employee.setDob(resultSet.getTimestamp("dob"));
                                employee.setPhone(resultSet.getString("phone"));
                                position.setId(resultSet.getInt("position_id"));
                                position.setName(resultSet.getString("position_name"));
                                employee.setPosition(position);
                                employee.setSalary(resultSet.getBigDecimal("salary"));
                                LOGGER.info("GET EMPLOYEE BY ID " + employee.toString());
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
}
