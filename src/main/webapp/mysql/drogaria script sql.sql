-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema drogaria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema drogaria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `drogaria` DEFAULT CHARACTER SET utf8 ;
USE `drogaria` ;

-- -----------------------------------------------------
-- Table `drogaria`.`fabricante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drogaria`.`fabricante` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `drogaria`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drogaria`.`produto` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `quantidade` INT NOT NULL,
  `preco` DECIMAL(5,2) NOT NULL,
  `fabricante_codigo` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_produto_fabricante_idx` (`fabricante_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_produto_fabricante`
    FOREIGN KEY (`fabricante_codigo`)
    REFERENCES `drogaria`.`fabricante` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
