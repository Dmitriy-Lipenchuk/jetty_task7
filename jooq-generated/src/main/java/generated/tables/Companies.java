/*
 * This file is generated by jOOQ.
 */
package generated.tables;


import generated.Keys;
import generated.Public;
import generated.tables.records.CompaniesRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Companies extends TableImpl<CompaniesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.companies</code>
     */
    public static final Companies COMPANIES = new Companies();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CompaniesRecord> getRecordType() {
        return CompaniesRecord.class;
    }

    /**
     * The column <code>public.companies.id</code>.
     */
    public final TableField<CompaniesRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.companies.name</code>.
     */
    public final TableField<CompaniesRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    private Companies(Name alias, Table<CompaniesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Companies(Name alias, Table<CompaniesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.companies</code> table reference
     */
    public Companies(String alias) {
        this(DSL.name(alias), COMPANIES);
    }

    /**
     * Create an aliased <code>public.companies</code> table reference
     */
    public Companies(Name alias) {
        this(alias, COMPANIES);
    }

    /**
     * Create a <code>public.companies</code> table reference
     */
    public Companies() {
        this(DSL.name("companies"), null);
    }

    public <O extends Record> Companies(Table<O> child, ForeignKey<O, CompaniesRecord> key) {
        super(child, key, COMPANIES);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CompaniesRecord, Integer> getIdentity() {
        return (Identity<CompaniesRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<CompaniesRecord> getPrimaryKey() {
        return Keys.COMPANIES_PKEY;
    }

    @Override
    public List<UniqueKey<CompaniesRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.COMPANIES_NAME_KEY);
    }

    @Override
    public Companies as(String alias) {
        return new Companies(DSL.name(alias), this);
    }

    @Override
    public Companies as(Name alias) {
        return new Companies(alias, this);
    }

    @Override
    public Companies as(Table<?> alias) {
        return new Companies(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Companies rename(String name) {
        return new Companies(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Companies rename(Name name) {
        return new Companies(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Companies rename(Table<?> name) {
        return new Companies(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Integer, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Integer, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
