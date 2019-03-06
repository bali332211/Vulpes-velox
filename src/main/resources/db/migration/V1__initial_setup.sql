CREATE TABLE product_ids (
  product_id          BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL
);

CREATE TABLE identified_products (
  id                  BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name                VARCHAR(255)
);

CREATE TABLE bulk_products (
  id                  BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name                VARCHAR(255)
);

CREATE TABLE products (
  id                  BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name                VARCHAR(255),
  dtype               VARCHAR(255)
);

CREATE TABLE items (
  id                  BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  product_number      VARCHAR(255),
  identified_product_id  BIGINT
);

CREATE TABLE product_without_id_items (
  id                  BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  quantity            BIGINT,
  arrival             VARCHAR(255),
  best_before         VARCHAR(255),
  bulk_product_id VARCHAR(255)
);

CREATE TABLE users (
  id                  BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name                VARCHAR(255),
  email               VARCHAR(255),
  image_url           VARCHAR(255),
  user_role           VARCHAR(255)
)
