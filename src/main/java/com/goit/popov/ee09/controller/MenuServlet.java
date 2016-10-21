package com.goit.popov.ee09.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 21.10.2016.
 */
public class MenuServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                int menu = Integer.valueOf(req.getParameter("menu"));
                switch (menu) {
                        case 1:
                                resp.sendRedirect("/employee.jsp");
                                break;
                        case 2:
                                // TODO
                                req.getRequestDispatcher("/dish.jsp").forward(req, resp);
                                break;
                        case 3:
                                // TODO
                                req.getRequestDispatcher("/menu.jsp").forward(req, resp);
                                break;
                        case 4:
                                // TODO
                                req.getRequestDispatcher("/order.jsp").forward(req, resp);
                                break;
                        case 5:
                                // TODO
                                req.getRequestDispatcher("/history.jsp").forward(req, resp);
                                break;
                        case 6:
                                // TODO
                                req.getRequestDispatcher("/stock.jsp").forward(req, resp);
                                break;
                        default:
                                // TODO
                                req.getRequestDispatcher("/error.jsp").forward(req, resp);
                                break;
                }
        }
}
