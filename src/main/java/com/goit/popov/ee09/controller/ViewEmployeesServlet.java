package com.goit.popov.ee09.controller;

import com.goit.popov.ee09.dao.impl.EmployeeDAOImpl;
import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.service.EmployeeService;
import com.goit.popov.ee09.service.EmployeeServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
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
                List<Employee> employeeList = employeeService.getAll();
                req.setAttribute("employeeList", employeeList);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view_employees.jsp");
                requestDispatcher.forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                Employee employee = employeeService.getByName(req.getParameter("name"));
                req.setAttribute("employeeList", employee);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view_employees.jsp");
                requestDispatcher.forward(req, resp);
        }
}
