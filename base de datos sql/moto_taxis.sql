CREATE DATABASE control_taxis;
USE control_taxis;

-- =========================
-- ROLES
-- =========================
CREATE TABLE roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- USUARIOS
-- =========================
CREATE TABLE usuarios (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    rol_id BIGINT NOT NULL,
    usuario VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nombre_completo VARCHAR(150),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (rol_id) REFERENCES roles(id)
);

-- =========================
-- CONDUCTORES
-- =========================
CREATE TABLE conductores (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre_completo VARCHAR(150) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    numero_licencia VARCHAR(100),
    fecha_contratacion DATE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- TAXIS
-- =========================
CREATE TABLE taxis (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre_unidad VARCHAR(100) NOT NULL,
    marca VARCHAR(100),
    modelo VARCHAR(100),
    anio INT,
    color VARCHAR(50),
    placa VARCHAR(20),
    precio_compra DECIMAL(12,2),
    fecha_compra DATE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- HISTORIAL TAXI - CONDUCTOR
-- =========================
CREATE TABLE asignaciones_taxi_conductor (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    taxi_id BIGINT NOT NULL,
    conductor_id BIGINT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (taxi_id) REFERENCES taxis(id),
    FOREIGN KEY (conductor_id) REFERENCES conductores(id)
);

-- =========================
-- CATEGORIAS DE GASTOS
-- =========================
CREATE TABLE categorias_gastos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

-- =========================
-- INGRESOS
-- =========================
CREATE TABLE ingresos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    taxi_id BIGINT NOT NULL,
    conductor_id BIGINT,
    monto DECIMAL(12,2) NOT NULL,
    fecha_hora_ingreso DATETIME NOT NULL,
    notas TEXT,
    creado_por BIGINT,
    FOREIGN KEY (taxi_id) REFERENCES taxis(id),
    FOREIGN KEY (conductor_id) REFERENCES conductores(id),
    FOREIGN KEY (creado_por) REFERENCES usuarios(id)
);

-- =========================
-- GASTOS
-- =========================
CREATE TABLE gastos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    taxi_id BIGINT NOT NULL,
    categoria_id BIGINT,
    descripcion VARCHAR(255),
    monto DECIMAL(12,2) NOT NULL,
    fecha_hora_gasto DATETIME NOT NULL,
    notas TEXT,
    creado_por BIGINT,
    FOREIGN KEY (taxi_id) REFERENCES taxis(id),
    FOREIGN KEY (categoria_id) REFERENCES categorias_gastos(id),
    FOREIGN KEY (creado_por) REFERENCES usuarios(id)
);

-- =========================
-- TIPOS DE MANTENIMIENTO
-- =========================
CREATE TABLE tipos_mantenimiento (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

-- =========================
-- MANTENIMIENTOS
-- =========================
CREATE TABLE mantenimientos_taxi (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    taxi_id BIGINT NOT NULL,
    tipo_mantenimiento_id BIGINT,
    descripcion VARCHAR(255),
    fecha_hora_mantenimiento DATETIME NOT NULL,
    costo DECIMAL(12,2),
    fecha_proximo_mantenimiento DATE,
    notas TEXT,
    creado_por BIGINT,
    FOREIGN KEY (taxi_id) REFERENCES taxis(id),
    FOREIGN KEY (tipo_mantenimiento_id) REFERENCES tipos_mantenimiento(id),
    FOREIGN KEY (creado_por) REFERENCES usuarios(id)
);

-- =========================
-- REGISTRO DE KILOMETRAJE
-- =========================
CREATE TABLE registro_kilometraje (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    taxi_id BIGINT NOT NULL,
    kilometraje INT NOT NULL,
    fecha DATE NOT NULL,
    notas TEXT,
    FOREIGN KEY (taxi_id) REFERENCES taxis(id)
);

-- =========================
-- INDICES
-- =========================
CREATE INDEX idx_ingresos_fecha ON ingresos(fecha_hora_ingreso);
CREATE INDEX idx_gastos_fecha ON gastos(fecha_hora_gasto);
CREATE INDEX idx_mantenimientos_fecha ON mantenimientos_taxi(fecha_hora_mantenimiento);

-- =========================
-- DATOS BASE
-- =========================
INSERT INTO roles (nombre, descripcion) VALUES
('ADMIN_GENERAL','Administrador total del sistema'),
('ADMIN_OPERATIVO','Captura ingresos y gastos');

INSERT INTO categorias_gastos (nombre) VALUES
('Gasolina'),
('Refacciones'),
('Mantenimiento'),
('Seguro'),
('Multa'),
('Verificación');

INSERT INTO tipos_mantenimiento (nombre) VALUES
('Cambio de aceite'),
('Cambio de balatas'),
('Afinación'),
('Servicio general');