SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`wifi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`wifi` (
  `id` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `ssid` VARCHAR(45) NOT NULL,
  `bssid` VARCHAR(45) NOT NULL,
  `level` INT NOT NULL,
  `frequency` INT NOT NULL,
  `latitude` DOUBLE NOT NULL,
  `longitude` DOUBLE NOT NULL,
  `timestamp` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`gps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`gps` (
  `id` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `latitude` VARCHAR(45) NOT NULL,
  `longitude` VARCHAR(45) NOT NULL,
  `timestamp` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`battery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`battery` (
  `id` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `level` VARCHAR(45) NOT NULL,
  `plugged` VARCHAR(45) NOT NULL,
  `temperature` VARCHAR(45) NOT NULL,
  `valtage` VARCHAR(45) NOT NULL,
  `timestamp` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`base_station`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`base_station` (
  `id` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `operator` VARCHAR(45) NOT NULL,
  `mcc` VARCHAR(45) NOT NULL,
  `mnc` VARCHAR(45) NOT NULL,
  `cid` VARCHAR(45) NOT NULL,
  `lac` VARCHAR(45) NOT NULL,
  `latitude` VARCHAR(45) NOT NULL,
  `longitude` VARCHAR(45) NOT NULL,
  `timestamp` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
