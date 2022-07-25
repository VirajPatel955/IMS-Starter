drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims`; DROP TABLE `orderline`;
DROP TABLE `orders`;
DROP TABLE `items`;
DROP TABLE `customers`;

DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    `address` VARCHAR(40) DEFAULT NULL,
    `post_code` VARCHAR(10) DEFAULT NULL,
    `email` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    `item_id` INT (11) NOT NULL AUTO_INCREMENT,
    `item_title` VARCHAR(40) DEFAULT NULL,
    `item_price` DECIMAL (6,2) DEFAULT NULL,
    `quantity` INT (20) DEFAULT NULL,
    `age_rating` INT (20) DEFAULT NULL,
    PRIMARY KEY (`item_id`)
 );
 
  CREATE TABLE IF NOT EXISTS `orders` (
 `order_id` INT (11) NOT NULL AUTO_INCREMENT,
 `order_date` DATE DEFAULT NULL,
 `fk_id` INT (11),
 PRIMARY KEY (`order_id`),
 FOREIGN KEY (`fk_id`) REFERENCES customers(`id`)
 );