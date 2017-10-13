DROP SCHEMA IF EXISTS `springtutorial` ;

-- -----------------------------------------------------
-- Schema springtutorial
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springtutorial` DEFAULT CHARACTER SET utf8 ;
USE `springtutorial` ;

-- -----------------------------------------------------
-- Table `springtutorial`.`users`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `springtutorial`.`users` (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(80) NULL,
  `authority` VARCHAR(45) NULL,
  `name` VARCHAR(100) NOT NULL,
  `enabled` TINYINT(1) NULL DEFAULT 1,
  `email` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springtutorial`.`offers`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `springtutorial`.`offers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` TEXT NOT NULL,
  `username` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`, `username`),
  INDEX `fk_offers_users_idx` (`username` ASC),
  CONSTRAINT `fk_offers_users`
    FOREIGN KEY (`username`)
    REFERENCES `springtutorial`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springtutorial`.`messages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springtutorial`.`messages` ;

CREATE TABLE IF NOT EXISTS `springtutorial`.`messages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(100) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `username` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_messages_users1_idx` (`username` ASC),
  CONSTRAINT `fk_messages_users1`
    FOREIGN KEY (`username`)
    REFERENCES `springtutorial`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
