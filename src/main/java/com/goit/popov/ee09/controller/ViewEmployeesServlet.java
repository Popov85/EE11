package com.goit.popov.ee09.controller;

import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 10/18/2016.
 */
public class ViewEmployeesServlet extends HttpServlet {

        @Autowired
        private EmployeeService employeeService;

        @Override
        public void init(ServletConfig config) throws ServletException {
                super.init(config);
                SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                        config.getServletContext());
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                // Show all employees
                List<Employee> employeeList = employeeService.getAll();
                req.setAttribute("employeeList", employeeList);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view_employees.jsp");
                requestDispatcher.forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                Employee employee = employeeService.getByName(req.getParameter("name"));
                List<Employee> employeeList = new ArrayList<>();
                if (employee!=null) {
                        employeeList.add(employee);
                }
                req.setAttribute("employeeList", employeeList);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view_employees.jsp");
                requestDispatcher.forward(req, resp);
        }
}
