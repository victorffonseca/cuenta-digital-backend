DROP ALL OBJECTS;

CREATE TABLE persona (
    cedula VARCHAR(15) IDENTITY PRIMARY KEY,
    primer_nombre VARCHAR(50) NOT NULL,
    segundo_nombre VARCHAR(50),
    primer_apellido VARCHAR(50) NOT NULL,
    segundo_apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    telefono VARCHAR(25) NOT NULL,
    email VARCHAR(150) NOT NULL,
    direccion VARCHAR(250) NOT NULL,
    ciudad_residencia VARCHAR(150) NOT NULL,
    profesion VARCHAR(100) NOT NULL,
    trabajo VARCHAR(50) NOT NULL,
    ingresos NUMERIC(10, 0) NOT NULL,
    egresos NUMERIC(10, 0) NOT NULL
);

CREATE TABLE cuenta_ahorros (
    id BIGINT PRIMARY KEY,
    clave SMALLINT NOT NULL,
    balance NUMERIC(20, 2) NOT NULL,
    estado BOOLEAN NOT NULL,
    persona_cedula VARCHAR(15)
);

INSERT INTO persona (cedula, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_nacimiento, telefono, email, direccion, ciudad_residencia, profesion, trabajo, ingresos, egresos)
VALUES ('1048754986', 'Jose', 'Pedro', 'Morantes', 'Ayala', '1990-01-01', '3248567845', 'jose@gmail.com', 'Calle 11 #45-85', 'Bogotá', 'Contador', 'Empleado', 3500000, 2500000);

INSERT INTO cuenta_ahorros (id, clave, balance, estado, persona_cedula)
VALUES (10000000000, 4152, 1500000, true, '1048754986');

ALTER TABLE cuenta_ahorros ADD FOREIGN KEY (persona_cedula) REFERENCES persona(cedula);