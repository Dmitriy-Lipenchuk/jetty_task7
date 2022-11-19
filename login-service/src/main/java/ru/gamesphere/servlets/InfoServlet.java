package ru.gamesphere.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");

        try (final PrintWriter out = response.getWriter()) {
            out.println("API\n");
            out.println("GET  /get - returns list of all products. Only authorized users can use it\n");
            out.println("""
                    POST /post?productName=someName&companyName=someCompany2&quantity=1 - add product to DB
                    Only users with MANAGER status can use it
                    """);
            out.println("GET /info - returns API info\n");
            out.println("""
                    Default accounts:
                    login: Guest
                    password: guest
                                        
                    login: Manager
                    password: manager
                    """);
        }
    }
}
