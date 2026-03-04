CREATE DATABASE taxi_control;
USE taxi_control;

-- =========================
-- ROLES
-- =========================
CREATE TABLE roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL,
    deleted_by BIGINT NULL
);

-- =========================
-- USERS
-- =========================
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_id BIGINT NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(150),
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL,
    deleted_by BIGINT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- =========================
-- DRIVERS (CONDUCTORES)
-- =========================
CREATE TABLE drivers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(150) NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255),
    license_number VARCHAR(100),
    hire_date DATE,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL,
    deleted_by BIGINT NULL
);

-- =========================
-- TAXIS
-- =========================
CREATE TABLE taxis (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(100) NOT NULL,
    brand VARCHAR(100),
    model VARCHAR(100),
    year INT,
    license_plate VARCHAR(20),
    purchase_price DECIMAL(12,2),
    purchase_date DATE,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL,
    deleted_by BIGINT NULL
);

-- =========================
-- HISTORIAL TAXI - DRIVER
-- =========================
CREATE TABLE taxi_driver_assignments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    taxi_id BIGINT NOT NULL,
    driver_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NULL,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (taxi_id) REFERENCES taxis(id),
    FOREIGN KEY (driver_id) REFERENCES drivers(id)
);

-- =========================
-- GASTOS INICIALES (UNA SOLA VEZ)
-- =========================
CREATE TABLE taxi_initial_expenses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    taxi_id BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    expense_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL,
    deleted_by BIGINT NULL,
    FOREIGN KEY (taxi_id) REFERENCES taxis(id)
);

-- =========================
-- INGRESOS (ENTRADAS)
-- =========================
CREATE TABLE incomes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    taxi_id BIGINT NOT NULL,
    driver_id BIGINT NULL,
    amount DECIMAL(12,2) NOT NULL,
    income_date DATE NOT NULL,
    notes TEXT,
    created_by BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL,
    deleted_by BIGINT NULL,
    FOREIGN KEY (taxi_id) REFERENCES taxis(id),
    FOREIGN KEY (driver_id) REFERENCES drivers(id),
    FOREIGN KEY (created_by) REFERENCES users(id)
);

-- =========================
-- GASTOS OPERATIVOS
-- =========================
CREATE TABLE expenses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    taxi_id BIGINT NOT NULL,
    driver_id BIGINT NULL,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    expense_date DATE NOT NULL,
    notes TEXT,
    created_by BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL,
    deleted_by BIGINT NULL,
    FOREIGN KEY (taxi_id) REFERENCES taxis(id),
    FOREIGN KEY (driver_id) REFERENCES drivers(id),
    FOREIGN KEY (created_by) REFERENCES users(id)
);

-- =========================
-- ÍNDICES IMPORTANTES
-- =========================
CREATE INDEX idx_income_date ON incomes(income_date);
CREATE INDEX idx_expense_date ON expenses(expense_date);
CREATE INDEX idx_taxi_income ON incomes(taxi_id);
CREATE INDEX idx_taxi_expense ON expenses(taxi_id);

-- =========================
-- ROLES BASE
-- =========================
INSERT INTO roles (name, description) VALUES
('ADMIN_GENERAL', 'Puede ver reportes y administrar todo'),
('ADMIN_OPERATIVO', 'Puede capturar ingresos y gastos');