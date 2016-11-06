package com.goit.popov.ee09.controller;

import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.model.Position;
import com.goit.popov.ee09.model.Waiter;
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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                // Save data to DB
                Employee employee = new Waiter();
                employee.setName(req.getParameter("name"));
                Date dob = null;
                try {
                        dob = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("dob"));
                } catch (ParseException e) {
                        throw new ServletException();
                }
                employee.setDob(dob);
                employee.setPhone(req.getParameter("phone"));
                Position position = new Position();
                position.setId(Integer.parseInt(req.getParameter("position")));
                employee.setPosition(position);
                employee.setSalary(BigDecimal.valueOf(Long.parseLong(req.getParameter("salary"))));
                String id = req.getParameter("id");
                if(id == null || id.isEmpty()) { // new
                        employeeService.insert(employee);
                }
                else {// edit
                        System.out.println("I am going to edit!");
                        employee.setId(Integer.parseInt(id));
                        employeeService.update(employee);
                }
                //req.setAttribute("employees", employeeService.getAll());
                //RequestDispatcher view = req.getRequestDispatcher("/employees");
                //view.forward(req, resp);
                resp.sendRedirect("/employees");
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                // Set data from DB to page
                String action = req.getParameter("action");
                if (action.equalsIgnoreCase("edit")) {
                        Employee employee = employeeService.getById(Integer.parseInt(req.getParameter("id")));
                        req.setAttribute("employee", employee);
                        req.setAttribute("position", employee.getPosition().getId());
                        // update
                        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/employee.jsp");
                        requestDispatcher.forward(req, resp);
                } else if (action.equalsIgnoreCase("delete")) {
                        employeeService.delete(Integer.parseInt(req.getParameter("id")));
                        resp.sendRedirect("/employees");
                }
        }
}
