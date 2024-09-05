CREATE TABLE IF NOT EXISTS product (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    price REAL NOT NULL
);

-- Insert sample data into the Product table
INSERT INTO product (name, price) VALUES ('Laptop', 999.99);
INSERT INTO product (name, price) VALUES ('Smartphone', 699.99);
INSERT INTO product (name, price) VALUES ('Headphones', 199.99);
INSERT INTO product (name, price) VALUES ('Smartwatch', 249.99);
INSERT INTO product (name, price) VALUES ('Tablet', 399.99);
INSERT INTO product (name, price) VALUES ('Gaming Console', 499.99);
