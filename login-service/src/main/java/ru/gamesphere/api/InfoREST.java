package ru.gamesphere.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/info")
public class InfoREST {
    @GET
    public String get() {
        return """
                API

                GET  /products - returns list of all products
                Only authorized users can use it
                ---------------------------------
                GET /productsListByCompanyName?companyName=company name - returns list of all products
                Only authorized users can use it
                ---------------------------------
                GET /info - returns API info
                ---------------------------------
                POST /save - add product to DB
                Only users with MANAGER status can use it
                Parameters format:
                Content-Type: application/x-www-form-urlencoded
                productName=someName&companyName=someCompany2&quantity=1
                ---------------------------------
                POST /delete - delete products from DB with specified name
                Only users with MANAGER status can use it
                Parameters format:
                Content-Type: application/x-www-form-urlencoded
                productName=someName
                                
                                
                Default accounts:
                login: Guest
                password: guest

                login: Manager
                password: manager          
                """;
    }
}
