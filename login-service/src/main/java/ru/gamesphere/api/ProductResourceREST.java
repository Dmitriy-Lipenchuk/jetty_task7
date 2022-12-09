package ru.gamesphere.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gamesphere.dao.ProductDao;
import ru.gamesphere.dto.CompanyDto;
import ru.gamesphere.dto.ProductDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resources")
public class ProductResourceREST {
    private final ProductDao productDao;
    private final ObjectMapper objectMapper;

    @Inject
    public ProductResourceREST(ProductDao productDao, ObjectMapper objectMapper) {
        this.productDao = productDao;
        this.objectMapper = objectMapper;
    }

    @POST
    @Path("/save")
    public Response save(@FormParam("productName") String productName,
                         @FormParam("companyName") String companyName,
                         @FormParam("quantity") Integer quantity) {
        if (productName == null || companyName == null || quantity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        productDao.save(new ProductDto(
                        productName,
                        new CompanyDto(companyName),
                        quantity
                )
        );

        return Response.ok().build();
    }

    @POST
    @Path("/delete")
    public Response delete(@FormParam("productName") String productName) {
        if (!productDao.deleteIfExistByProductName(productName)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().build();
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public String get() throws JsonProcessingException {
        return objectMapper.writeValueAsString(productDao.all());
    }

    @GET
    @Path("/productListByCompanyName")
    @Produces(MediaType.APPLICATION_JSON)
    public String productListByCompanyName(@QueryParam("companyName") String companyName) throws JsonProcessingException {
        return objectMapper.writeValueAsString(productDao.getProductsByCompanyName(companyName));
    }
}
