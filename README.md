CREATE DATABASE test;


use TEST

CREATE TABLE car_types (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    attributes VARCHAR(255) NOT NULL
);

CREATE TABLE cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    car_name VARCHAR(255) NOT NULL,
    car_year INT NOT NULL,
    car_type_id INT,
    car_brand_id INT,
    FOREIGN KEY (car_type_id) REFERENCES car_types(id),
    FOREIGN KEY (car_brand_id) REFERENCES car_brands(id)
);

CREATE TABLE car_brands (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

