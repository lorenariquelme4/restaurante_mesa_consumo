CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE producto (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    id_categoria INT REFERENCES categoria (id),
    precio DECIMAL(10, 2) NOT NULL
);

CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE mesas (
    id SERIAL PRIMARY KEY,
    numero_mesa INT NOT NULL UNIQUE
);

CREATE TABLE consumo (
    id SERIAL PRIMARY KEY,
    id_mesa INT REFERENCES mesas(id),
    id_cliente INT REFERENCES clientes(id),
    estado VARCHAR(50) NOT NULL CHECK (estado IN ('abierto', 'cerrado')),
    total DECIMAL(10, 2) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_cierre TIMESTAMP
);

CREATE TABLE detalle_consumo (
    id SERIAL PRIMARY KEY,
    id_consumo INT REFERENCES consumo(id),
    id_producto INT REFERENCES producto(id),
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL
);

