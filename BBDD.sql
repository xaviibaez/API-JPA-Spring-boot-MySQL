CREATE DATABASE db1;
COMMIT;
USE db1;

DROP TABLE concesionarios;

CREATE TABLE concesionarios (
id INT(6) AUTO_INCREMENT PRIMARY KEY,
direccion VARCHAR(30) NOT NULL
);

DROP TABLE coches;

CREATE TABLE coches (
id INT(6) AUTO_INCREMENT PRIMARY KEY,
marca VARCHAR(30),
coste FLOAT(30),
fecha_venta timestamp,
fecha_ingreso timestamp,
vendido boolean,
matricula VARCHAR(30),
precio_venta FLOAT(30),
id_concesionario INT(6)
);

SET GLOBAL time_zone = '-3:00';

ALTER TABLE coches
ADD FOREIGN KEY (id_concesionario) REFERENCES concesionarios(id);

SHOW TABLES;
SELECT * FROM coches;
INSERT INTO concesionarios (direccion)
VALUES ("calle falsa");

INSERT INTO coches (marca, coste, fecha_ingreso, vendido, matricula, precio_venta, id_concesionario)
VALUES ("ferrari", 100.2, NOW(), false, "", 150.3, 1);

INSERT INTO coches (marca, coste, fecha_ingreso, vendido, matricula, precio_venta, id_concesionario)
VALUES ("honda", 120.2, NOW(), false, "", 170.3, 1);