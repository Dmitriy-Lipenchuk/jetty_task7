package ru.gamesphere.dao;

import generated.tables.records.CompaniesRecord;
import generated.tables.records.ProductsRecord;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.*;
import org.jooq.impl.DSL;
import ru.gamesphere.dto.ProductDto;
import ru.gamesphere.entity.Company;
import ru.gamesphere.entity.Product;
import ru.gamesphere.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static generated.Tables.COMPANIES;
import static generated.Tables.PRODUCTS;
import static org.jooq.impl.DSL.*;

public class ProductDao implements Dao<Product, ProductDto> {

    @Override
    public @NotNull List<@NotNull Product> all() {
        List<Product> products;

        try (Connection connection = ConnectionManager.open()) {
            DSLContext context = DSL.using(connection, SQLDialect.POSTGRES);

            products = context.select(
                            PRODUCTS.ID,
                            PRODUCTS.NAME,
                            COMPANIES.ID,
                            COMPANIES.NAME,
                            PRODUCTS.QUANTITY
                    ).from(PRODUCTS)
                    .innerJoin(COMPANIES).on(PRODUCTS.COMPANY_ID.eq(COMPANIES.ID))
                    .fetch(record -> new Product(record.get(PRODUCTS.ID),
                            record.get(PRODUCTS.NAME),
                            new Company(record.get(COMPANIES.ID), record.get(COMPANIES.NAME)),
                            record.get(PRODUCTS.QUANTITY)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    @Override
    public void save(@NotNull ProductDto productDto) {
        try (Connection connection = ConnectionManager.open()) {
            DSLContext context = DSL.using(connection, SQLDialect.POSTGRES);

            context.insertInto(COMPANIES, COMPANIES.NAME)
                    .select(
                            select(
                                    val(productDto.getCompany().getName())
                            ).whereNotExists(
                                    selectOne()
                                            .from(COMPANIES)
                                            .where(COMPANIES.NAME.eq(productDto.getCompany().getName()))
                            )
                    )
                    .execute();

            CompaniesRecord companyRecord = context.selectFrom(COMPANIES)
                    .where(COMPANIES.NAME.eq(productDto.getCompany().getName()))
                    .fetchOne();

            context.insertInto(PRODUCTS, PRODUCTS.NAME, PRODUCTS.COMPANY_ID, PRODUCTS.QUANTITY)
                    .values(productDto.getName(), companyRecord.getId(), productDto.getQuantity())
                    .execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
