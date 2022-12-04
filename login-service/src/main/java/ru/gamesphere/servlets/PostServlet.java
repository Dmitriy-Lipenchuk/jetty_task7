package ru.gamesphere.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpStatus;
import ru.gamesphere.dao.ProductDao;
import ru.gamesphere.dto.CompanyDto;
import ru.gamesphere.dto.ProductDto;

public class PostServlet extends HttpServlet {
    private final ProductDao productDao = new ProductDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        final String productName = req.getParameter("productName");
        final String companyName = req.getParameter("companyName");
        final String quantity = req.getParameter("quantity");

        if (productName == null || companyName == null || quantity == null) {
            resp.setStatus(HttpStatus.BAD_REQUEST_400);
            return;
        }

        productDao.save(new ProductDto(
                        productName,
                        new CompanyDto(companyName),
                        Integer.parseInt(quantity)
                )
        );
    }
}
