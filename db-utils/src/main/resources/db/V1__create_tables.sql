CREATE TABLE companies
(
    id   SERIAL       NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE products
(
    id         SERIAL       NOT NULL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    company_id INT          NOT NULL REFERENCES companies (id) ON UPDATE CASCADE,
    quantity   INT          NOT NULL
);

INSERT INTO companies (name)
VALUES ('init company');

INSERT INTO products (name, company_id, quantity)
VALUES ('init product', 1, 100);

INSERT INTO products (name, company_id, quantity)
VALUES ('second init product', 1, 1);
