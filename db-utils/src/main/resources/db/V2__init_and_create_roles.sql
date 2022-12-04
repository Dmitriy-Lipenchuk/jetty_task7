CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     varchar(100) NOT NULL UNIQUE,
    password varchar(50)  NOT NULL
);

CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    role varchar(100) NOT NULL UNIQUE
);

CREATE TABLE users_roles
(
    user_id integer NOT NULL REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    role_id integer NOT NULL REFERENCES roles (id) ON UPDATE CASCADE,
    PRIMARY KEY (user_id, role_id)
);

INSERT INTO users (name, password)
VALUES ('Manager', 'manager');

INSERT INTO users (name, password)
VALUES ('Guest', 'guest');

INSERT INTO roles (role)
VALUES ('MANAGER');

INSERT INTO roles (role)
VALUES ('GUEST');

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO users_roles (user_id, role_id)
VALUES (2, 2);
