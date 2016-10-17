package com.goit.popov.ee09.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Andrey on 10/17/2016.
 */
public class EmployeeServlet extends HttpServlet {

        private String message;

        public void init() throws ServletException {
                // Do required initialization
                this.message = "Hello Employee!!! Changed!";
        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                super.doGet(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                super.doPost(req, resp);
        }

        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                // Actual logic goes here.
                PrintWriter out = resp.getWriter();
                out.println("<h1>" + message + "</h1>");
        }
}
