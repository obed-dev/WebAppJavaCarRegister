-- Crear la base de datos
CREATE DATABASE parqueo_db;

-- Usar la base de datos
USE parqueo_db;

-- Crear la tabla de clientes
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,      -- Identificador único
    nombre VARCHAR(100) NOT NULL,           -- Nombre del cliente
    cedula VARCHAR(20) NOT NULL UNIQUE,     -- Cédula única
    telefono VARCHAR(15),                   -- Teléfono del cliente
    email VARCHAR(100) UNIQUE               -- Email único
);

-- Crear la tabla de vehiculos
CREATE TABLE vehiculos (
    id INT AUTO_INCREMENT PRIMARY KEY,      -- Identificador único
    tipo VARCHAR(50) NOT NULL,              -- Tipo de vehículo (ej: carro, moto)
    placa VARCHAR(20) NOT NULL UNIQUE,      -- Placa del vehículo
    modelo VARCHAR(50),                     -- Modelo del vehículo
    marca VARCHAR(50),                      -- Marca del vehículo
    cliente_id INT,                         -- Relación con el cliente
    FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE SET NULL
); 



INSERT INTO clientes (nombre, cedula, telefono, email) VALUES 
('Juan Pérez', '123456789', '8888-1234', 'juan.perez@example.com'),
('María López', '987654321', '8888-5678', 'maria.lopez@example.com'),
('Carlos Ramírez', '456123789', '8999-1234', 'carlos.ramirez@example.com'),
('Ana Morales', '789456123', '8777-4321', 'ana.morales@example.com'),
('Luis González', '321654987', '8555-9876', 'luis.gonzalez@example.com');


INSERT INTO vehiculos (tipo, placa, modelo, marca, cliente_id) VALUES 
('Carro', 'ABC123', 'Corolla', 'Toyota', 1), -- Asignado a Juan Pérez
('Moto', 'XYZ789', 'CB500X', 'Honda', 2),   -- Asignado a María López
('Carro', 'DEF456', 'Civic', 'Honda', 3),   -- Asignado a Carlos Ramírez
('Carro', 'GHI321', 'CX-5', 'Mazda', 4),    -- Asignado a Ana Morales
('Moto', 'JKL987', 'Ninja', 'Kawasaki', 5), -- Asignado a Luis González
('Automovil', 'BVF502', 'Elantra', 'Hyundai', 1), -- Asignado a Juan Pérez
('Automovil', 'BVF509', 'Accent', 'Hyundai', 2),  -- Asignado a María López
('Automovil', 'BVF515', 'Lancer', 'Mitsubishi', 3); -- Asignado a Carlos Ramírez




