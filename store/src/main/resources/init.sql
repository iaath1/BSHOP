DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS cart_items;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS colors;
DROP TABLE IF EXISTS materials;
DROP TABLE IF EXISTS sizes;
DROP TABLE IF EXISTS carts;
DROP TABLE IF EXISTS statuses;
DROP TABLE IF EXISTS shop_users;
DROP TABLE IF EXISTS roles;

-- Роли
CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

-- Пользователи
CREATE TABLE IF NOT EXISTS shop_users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Статусы заказов
CREATE TABLE IF NOT EXISTS statuses (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

-- Корзины
CREATE TABLE IF NOT EXISTS carts (
    id SERIAL PRIMARY KEY,
    user_id INT UNIQUE,
    FOREIGN KEY (user_id) REFERENCES shop_users(id) ON DELETE CASCADE
);

-- Справочники
CREATE TABLE IF NOT EXISTS sizes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS materials (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS colors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

-- Товары
CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    size_id INT,
    category_id INT,
    material_id INT,
    color_id INT,
    image_url VARCHAR(255),
    FOREIGN KEY (size_id) REFERENCES sizes(id),
    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY (material_id) REFERENCES materials(id),
    FOREIGN KEY (color_id) REFERENCES colors(id)
);

-- Элементы корзины
CREATE TABLE IF NOT EXISTS cart_items (
    id SERIAL PRIMARY KEY,
    cart_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES carts(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Заказы
CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    status_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES shop_users(id),
    FOREIGN KEY (status_id) REFERENCES statuses(id)
);

-- Элементы заказа
CREATE TABLE IF NOT EXISTS order_items (
    id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id)
);


-- Роли
INSERT INTO roles (name) VALUES 
('ADMIN'),
('CUSTOMER');

-- Статусы заказов
INSERT INTO statuses (name) VALUES 
('NEW'),
('PAID'),
('SHIPPED'),
('DELIVERED'),
('CANCELED');

-- Размеры
INSERT INTO sizes (name) VALUES 
('XS'),
('S'),
('M'),
('L'),
('XL');

-- Материалы
INSERT INTO materials (name) VALUES 
('Хлопок'),
('Шёлк'),
('Атлас'),
('Кружево');

-- Цвета
INSERT INTO colors (name) VALUES 
('Белый'),
('Черный'),
('Красный'),
('Синий'),
('Бежевый');

-- Категории
INSERT INTO categories (name) VALUES 
('Бюстгальтеры'),
('Трусы'),
('Комплекты'),
('Пижамы'),
('Аксессуары');

-- Пользователь-админ
-- INSERT INTO shop_users (name, surname, email, phone, password, address, role_id) VALUES 
-- ('Admin', 'User', 'admin@example.com', '+79990001122', 'admin123', 'Москва, ул. Ленина, 1', 1);

-- -- Тестовый покупатель
-- INSERT INTO shop_users (name, surname, email, phone, password, address, role_id) VALUES 
-- ('Иван', 'Иванов', 'ivan@example.com', '+79998887766', '12345', 'Санкт-Петербург, Невский проспект, 10', 2);

-- Товары
INSERT INTO products (name, description, price, quantity, size_id, category_id, material_id, color_id, image_url) VALUES
('Кружевной бюстгальтер', 'Элегантный кружевной бюстгальтер', 2499.99, 50, 3, 1, 4, 2, 'images/bra1.jpg'),
('Атласная пижама', 'Мягкая и удобная пижама из атласа', 3999.00, 20, 4, 4, 3, 5, 'images/pajama1.jpg');

