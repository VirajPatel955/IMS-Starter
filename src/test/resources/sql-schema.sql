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