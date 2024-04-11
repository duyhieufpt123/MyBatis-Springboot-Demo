CREATE DATABASE test;


use TEST

CREATE TABLE car_brands (
id VARCHAR(255) PRIMARY KEY NOT NULL,
name VARCHAR(255) NOT NULL
);

CREATE TABLE car_types (
id VARCHAR(255) PRIMARY KEY NOT NULL,
type VARCHAR(255) NOT NULL,
attributes VARCHAR(255) NOT NULL
);

CREATE TABLE cars (
id VARCHAR(255) PRIMARY KEY NOT NULL,
car_name VARCHAR(255) NOT NULL,
car_year INT NOT NULL,
car_type_id VARCHAR(255) NOT NULL,
car_brand_id VARCHAR(255) NOT NULL,
FOREIGN KEY (car_type_id) REFERENCES car_types(id),
FOREIGN KEY (car_brand_id) REFERENCES car_brands(id)
);


http://localhost:8080/api/v1/swagger-ui/index.html#
