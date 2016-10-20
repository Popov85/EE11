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
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Andrey on 10/17/2016.
 */
public class EmployeeServlet extends HttpServlet {

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
                // Set info from DB to page
                String action = req.getParameter("action");
                if (action.equalsIgnoreCase("edit")) {
                        Employee employee = employeeService.getById(Integer.parseInt(req.getParameter("id")));
                        req.setAttribute("employee", employee);
                        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/employee.jsp");
                        requestDispatcher.forward(req, resp);
                }
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                // Save date to DB

        }
}
