DROP TABLE IF EXISTS menu;

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
    minimum_Quantitytwo BIGINT,
    minimum_quantity_price_two Double,
    maximum_amount_sales_per_day BIGINT
);

CREATE TABLE menu_category (menu_id  BIGINT NOT NULL  , category BIGINT);
-- INSERT INTO usuario 
-- (nombre, apellido, fecha_de_nacimiento) VALUES 
-- ('Mauricio','Zanon', '2019-06-05 14:53:01'),
-- ('Sergio','Guzman', '2019-04-16 14:53:01'),
-- ('Leandro','Rojas', '2019-07-05 14:53:01');
