CREATE SCHEMA `projectdb` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `projectdb`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `enabled` TINYINT NOT NULL,
  PRIMARY KEY (`user_id`));

INSERT INTO `projectdb`.`users` (`username`, `password`, `enabled`) VALUES ('admin', '$2a$10$QF/YQ9BzZoPmi5of5kkNeOP0bre/XmlsxyMX61aEeKwBsSxsfv1/u', '1');
INSERT INTO `projectdb`.`users` (`username`, `password`, `enabled`) VALUES ('green', '$2a$10$QF/YQ9BzZoPmi5of5kkNeOP0bre/XmlsxyMX61aEeKwBsSxsfv1/u', '1');
SELECT * FROM `projectdb`.`users`;
CREATE TABLE `projectdb`.`user_role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`));

INSERT INTO `projectdb`.`user_role` (`name`) values ("ADMIN"),("PRODUCT_MANAGER") ,("USER");
CREATE TABLE `projectdb`.`manage_roles` (
  `User_ID` INT NOT NULL AUTO_INCREMENT,
  `Role_ID` INT NOT NULL,
  PRIMARY KEY (`User_ID`, `Role_ID`),
  CONSTRAINT `users_fk_id`
    FOREIGN KEY (`User_ID`)
    REFERENCES `projectdb`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `role_fk_id`
    FOREIGN KEY (`Role_ID`)
    REFERENCES `projectdb`.`user_role` (`role_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
Select * from `projectdb`.`user_role`;
INSERT INTO `projectdb`.`manage_roles`  values (1,1), (2,2);
select* from `projectdb`.`user_role`;
select* from `projectdb`.`manage_roles`;
select * from `projectdb`.`users`;
SET FOREIGN_KEY_CHECKS=0;

Create table  `projectdb`.`products`(
	`productID` INT NOT NULL AUTO_INCREMENT,
    `name` varchar(50) not null,
    `img` varchar(100) not null,
    `price_old` long,
    `price_new` long not null,
    `intro` varchar(5000) not null,
     PRIMARY KEY (`productID`)
);
INSERT INTO `projectdb`.`products` (`name`,`img`, `price_old`, `price_new`, `intro`) values 
("Samsung A1","product-1", 800, 700," Samsung Galaxy A01 is released as an entry-level smartphone that has been unveiled quietly at the market in the month of December 2019. The Galaxy A01 has a display of 5.7 inches that provides 720 x 1560 pixels resolution"),
("Samsung A2","product-2", 800, 700, "Description 2"), 
("Samsung A3", "product-3", 800, 700, "Description 3"),
("Samsung A4","product-4", 800, 700, "Description 4"), 
("Samsung A5","product-5", 800, 700, "Description 5"),
("Samsung A6","product-6", 800, 700, "Description 6");
select * from `projectdb`.`products`;