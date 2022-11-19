package ru.gamesphere.servlets;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.gamesphere.dao.ProductDao;

import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends HttpServlet {
    private final ProductDao productDao = new ProductDao();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        try (final PrintWriter out = response.getWriter()) {
            out.println(gson.toJson(productDao.all()));
        }
    }
}
