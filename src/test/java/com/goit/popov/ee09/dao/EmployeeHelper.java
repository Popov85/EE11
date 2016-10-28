package com.goit.popov.ee09.dao;

import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.model.Position;
import org.apache.commons.dbcp2.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 10/26/2016.
 */
public class EmployeeHelper {

        private static String SQL_COUNT = "SELECT COUNT(*) FROM EMPLOYEE";
        private static String SQL_DELETE = "DELETE FROM EMPLOYEE";
        private static String SQL_INSERT = "INSERT INTO EMPLOYEE(name, dob, phone, position_id, salary) VALUES(?,?,?,?,?)";
        private static String SQL_SELECT = "SELECT * FROM EMPLOYEE WHERE ID=?";


        private static Connection getConnection() throws SQLException {
                return DriverManager.getConnection(Connect.URL,Connect.USER,Connect.PASSWORD);
        }

        // Clears the DB
        public static void delete(){
                try(Connection c = getConnection()){
                        PreparedStatement ps = c.prepareStatement(SQL_DELETE);
                        ps.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        // Returns a generated ID of a newly inserted entry
        /*public static int insert(Employee employee, Position position){
                int id;
                try (Connection connection = getConnection();
                     PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                             Statement.RETURN_GENERATED_KEYS)) {
                        statement.setString(1, employee.getName());
                        statement.setDate(2, new java.sql.Date(employee.getDob().getTime()));
                        statement.setString(3, employee.getPhone());
                        statement.setObject(4, position);
                        statement.setBigDecimal(5, employee.getSalary());
                        if (1 == statement.executeUpdate() && statement.getGeneratedKeys().next()) {
                                id = statement.getGeneratedKeys().getInt("id");
                                employee.setId(id);
                        } else {
                                throw new RuntimeException();
                        }
                } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                }
                return id;
        }*/

        // Counts entries in Employee table
        public static int count(){
                int count = 0;
                try(Connection c = getConnection()){
                        PreparedStatement ps = c.prepareStatement(SQL_COUNT);
                        ResultSet rs=ps.executeQuery();
                        while(rs.next()){
                                count=rs.getInt(1);
                        }
                        return count;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        /*public static List<Employee> getAll(){
                try(Connection c = getConnection()){
                        List<Employee> list = new ArrayList();
                        ResultSet rs=c.createStatement().executeQuery("SELECT * FROM EMPLOYEE");
                        while(rs.next()){
                                Employee emp = new Employee();
                                emp.setName(rs.getString("name"));
                                emp.setAge(rs.getInt("age"));
                                list.add(emp);
                        }
                        return list;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }*/

        public static Employee getById(int id) {
                ResultSet resultSet = null;
                Employee employee;
                Position position;
                try (Connection connection = getConnection();
                     PreparedStatement statement = connection.prepareStatement(SQL_SELECT)) {
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
                                employee.setPosition(position);
                                employee.setSalary(resultSet.getBigDecimal("salary"));
                        } else {
                                throw new RuntimeException();
                        }

                } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                } finally {
                        if (resultSet != null) {
                                Utils.closeQuietly(resultSet);
                        }
                }
                return employee;
        }
}
