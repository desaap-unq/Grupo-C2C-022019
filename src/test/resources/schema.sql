DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS menu_category;
DROP TABLE IF EXISTS business;
DROP TABLE IF EXISTS virtual_wallet;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS order_table;

CREATE TABLE menu (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45),
    description VARCHAR(45),
    delivery_cost Double,
    start_date DATETIME, 
    due_date DATETIME,
    delivery_time DATETIME,
    average_delivery_time DATETIME, 
    price Double, 
    minimum_quantity BIGINT,
    minimum_quantity_price Double,
    minimum_quantity_two BIGINT,
    minimum_quantity_price_two Double,
    maximum_amount_sales_per_day BIGINT,
    active Boolean,
    business_id BIGINT NOT NULL
);

CREATE TABLE menu_category (menu_id  BIGINT NOT NULL  , category BIGINT);
CREATE TABLE order_table_menus (order_id BIGINT , menus_id  BIGINT);

CREATE TABLE virtual_wallet (id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, balance BIGINT);

CREATE TABLE business (id BIGINT PRIMARY KEY AUTO_INCREMENT,
     address VARCHAR(45),
     days VARCHAR(45),
     delivery VARCHAR(45),
     description VARCHAR(45),
     email VARCHAR(45),
     link VARCHAR(45),
     locality VARCHAR(45),
     location VARCHAR(45),
     logo VARCHAR(45),
     name VARCHAR(45),
     phone BIGINT,
     schedule VARCHAR(45),
     wallet_id BIGINT
);

CREATE TABLE client (id BIGINT PRIMARY KEY AUTO_INCREMENT, address VARCHAR(45), email VARCHAR(45), locality VARCHAR(45), name VARCHAR(45), phone VARCHAR(45), surname VARCHAR(45), wallet_id BIGINT);
CREATE TABLE order_table (id BIGINT PRIMARY KEY AUTO_INCREMENT, business_id BIGINT, client_id BIGINT, delivery_time DATETIME, dispatch_date DATETIME, dispatch_time DATETIME, dispatch_type BIGINT, order_date DATETIME, score BIGINT, state BIGINT );