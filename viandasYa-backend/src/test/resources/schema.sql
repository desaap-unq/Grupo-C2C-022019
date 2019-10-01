
DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    fecha_de_nacimiento DATETIME
    
);

INSERT INTO usuario 
(nombre, apellido, fecha_de_nacimiento) VALUES 
('Mauricio','Zanon', '2019-06-05 14:53:01'),
('Sergio','Guzman', '2019-04-16 14:53:01'),
('Leandro','Rojas', '2019-07-05 14:53:01');
