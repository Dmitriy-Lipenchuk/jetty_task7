/*
 * This file is generated by jOOQ.
 */
package generated;


import generated.tables.Companies;
import generated.tables.Products;
import generated.tables.Roles;
import generated.tables.Users;
import generated.tables.UsersRoles;
import generated.tables.records.CompaniesRecord;
import generated.tables.records.ProductsRecord;
import generated.tables.records.RolesRecord;
import generated.tables.records.UsersRecord;
import generated.tables.records.UsersRolesRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CompaniesRecord> COMPANIES_NAME_KEY = Internal.createUniqueKey(Companies.COMPANIES, DSL.name("companies_name_key"), new TableField[] { Companies.COMPANIES.NAME }, true);
    public static final UniqueKey<CompaniesRecord> COMPANIES_PKEY = Internal.createUniqueKey(Companies.COMPANIES, DSL.name("companies_pkey"), new TableField[] { Companies.COMPANIES.ID }, true);
    public static final UniqueKey<ProductsRecord> PRODUCTS_PKEY = Internal.createUniqueKey(Products.PRODUCTS, DSL.name("products_pkey"), new TableField[] { Products.PRODUCTS.ID }, true);
    public static final UniqueKey<RolesRecord> ROLES_PKEY = Internal.createUniqueKey(Roles.ROLES, DSL.name("roles_pkey"), new TableField[] { Roles.ROLES.ID }, true);
    public static final UniqueKey<RolesRecord> ROLES_ROLE_KEY = Internal.createUniqueKey(Roles.ROLES, DSL.name("roles_role_key"), new TableField[] { Roles.ROLES.ROLE }, true);
    public static final UniqueKey<UsersRecord> USERS_NAME_KEY = Internal.createUniqueKey(Users.USERS, DSL.name("users_name_key"), new TableField[] { Users.USERS.NAME }, true);
    public static final UniqueKey<UsersRecord> USERS_PKEY = Internal.createUniqueKey(Users.USERS, DSL.name("users_pkey"), new TableField[] { Users.USERS.ID }, true);
    public static final UniqueKey<UsersRolesRecord> USERS_ROLES_PKEY = Internal.createUniqueKey(UsersRoles.USERS_ROLES, DSL.name("users_roles_pkey"), new TableField[] { UsersRoles.USERS_ROLES.USER_ID, UsersRoles.USERS_ROLES.ROLE_ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ProductsRecord, CompaniesRecord> PRODUCTS__PRODUCTS_COMPANY_ID_FKEY = Internal.createForeignKey(Products.PRODUCTS, DSL.name("products_company_id_fkey"), new TableField[] { Products.PRODUCTS.COMPANY_ID }, Keys.COMPANIES_PKEY, new TableField[] { Companies.COMPANIES.ID }, true);
    public static final ForeignKey<UsersRolesRecord, RolesRecord> USERS_ROLES__USERS_ROLES_ROLE_ID_FKEY = Internal.createForeignKey(UsersRoles.USERS_ROLES, DSL.name("users_roles_role_id_fkey"), new TableField[] { UsersRoles.USERS_ROLES.ROLE_ID }, Keys.ROLES_PKEY, new TableField[] { Roles.ROLES.ID }, true);
    public static final ForeignKey<UsersRolesRecord, UsersRecord> USERS_ROLES__USERS_ROLES_USER_ID_FKEY = Internal.createForeignKey(UsersRoles.USERS_ROLES, DSL.name("users_roles_user_id_fkey"), new TableField[] { UsersRoles.USERS_ROLES.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
}
