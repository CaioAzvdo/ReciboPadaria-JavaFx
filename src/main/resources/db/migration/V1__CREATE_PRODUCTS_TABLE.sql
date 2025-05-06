CREATE TABLE Product (
                         id SERIAL PRIMARY KEY,
                         code VARCHAR(50) NOT NULL,
                         name VARCHAR(100) NOT NULL,
                         price NUMERIC(10, 2) NOT NULL
);