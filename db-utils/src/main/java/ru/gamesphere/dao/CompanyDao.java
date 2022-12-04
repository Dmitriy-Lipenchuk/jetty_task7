package ru.gamesphere.dao;

import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Records;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ru.gamesphere.dto.CompanyDto;
import ru.gamesphere.entity.Company;
import ru.gamesphere.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static generated.Tables.COMPANIES;

public class CompanyDao implements Dao<Company, CompanyDto> {
    @Override
    public @NotNull List<@NotNull Company> all() {
        List<Company> companies;

        try (Connection connection = ConnectionManager.open()) {
            DSLContext context = DSL.using(connection, SQLDialect.POSTGRES);

            companies = context.selectFrom(COMPANIES)
                    .fetch(Records.mapping(Company::new));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return companies;
    }

    @Override
    public void save(@NotNull CompanyDto companyDto) {
        try (Connection connection = ConnectionManager.open()) {
            DSLContext context = DSL.using(connection, SQLDialect.POSTGRES);

            context.insertInto(COMPANIES, COMPANIES.NAME)
                    .values(companyDto.getName())
                    .execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
