package com.goit.popov.ee09.controller;

import com.goit.popov.ee09.dao.impl.EmployeeDAOImpl;
import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.service.EmployeeService;
import com.goit.popov.ee09.service.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
                // Actual logic goes here.
                PrintWriter out = resp.getWriter();
                out.println("<h1>" + "doGet" + "</h1>");
                //companyList.sort((Company company1, Company company2) -> company1.getName().compareTo(company2.getName()));
                /*req.setAttribute("employeeList", employeeList);

                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("view_employees.jsp");
                requestDispatcher.forward(req, resp);*/
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                List<Employee> employeeList = employeeService.getAll();
                // Actual logic goes here.
                PrintWriter out = resp.getWriter();
                out.println("<h1>" + "doPost" + "</h1>");

        }

        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                List<Employee> employeeList = employeeService.getAll();
                // Actual logic goes here.
                PrintWriter out = resp.getWriter();
                out.println("<h1>" + "service" + "</h1>");
        }
}
