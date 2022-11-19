package ru.gamesphere.dao;

import generated.tables.records.CompaniesRecord;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ru.gamesphere.dto.CompanyDto;
import ru.gamesphere.entity.Company;
import ru.gamesphere.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static generated.Tables.COMPANIES;

public class CompanyDao implements Dao<Company, CompanyDto> {
    @Override
    public @NotNull List<@NotNull Company> all() {
        List<Company> companies = new ArrayList<>();

        try (Connection connection = ConnectionManager.open()) {
            DSLContext context = DSL.using(connection, SQLDialect.POSTGRES);

            List<CompaniesRecord> records = context.selectFrom(COMPANIES)
                    .fetch();

            for (CompaniesRecord record : records) {
                companies.add(new Company(record.getId(), record.getName()));
            }
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
