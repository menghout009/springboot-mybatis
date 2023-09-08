CREATE TABLE products(
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(255),
    product_price DOUBLE PRECISION
);

CREATE TABLE customers(
    id SERIAL PRIMARY KEY,
    customer_name VARCHAR(255),
    customer_phone VARCHAR(255),
    customer_address VARCHAR(255)

);


CREATE TABLE invoiceDetail(
    id SERIAL PRIMARY KEY,
    invoice_detail_id INTEGER,
    FOREIGN KEY (invoice_detail_id) REFERENCES invoice(invoice_id)

);

CREATE TABLE invoice(
    invoice_id SERIAL PRIMARY KEY ,
    invoice_date TIMESTAMP ,
    customer_id INTEGER,
    FOREIGN KEY(customer_id) REFERENCES customers(id)
);

-- CREATE TABLE invoice_detail(
--     invoidd SERIAL PRIMARY KEY,
--     invoice_id INTEGER,
--     FOREIGN KEY (invoice_id) REFERENCES invoice (invoice_id),
--     product_id INTEGER,
--     FOREIGN KEY (product_id) REFERENCES products (id)
-- );

CREATE TABLE invoice_details(
    invoice_detail_id SERIAL PRIMARY KEY ,
    invoice_id INT REFERENCES invoice(invoice_id) ON DELETE CASCADE ON UPDATE CASCADE,
    product_id INT REFERENCES products(id) ON DELETE CASCADE ON UPDATE CASCADE);


DELETE FROM products WHERE id = 2;
DROP TABLE invoice_details;