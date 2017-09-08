-- MySQL Script generated by MySQL Workbench
-- Thu Sep  7 23:32:39 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema centroDeportivo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema centroDeportivo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `centroDeportivo` DEFAULT CHARACTER SET utf8 ;
USE `centroDeportivo` ;

-- -----------------------------------------------------
-- Table `centroDeportivo`.`Estatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Estatus` (
  `idEstatus` INT NOT NULL AUTO_INCREMENT,
  `estatus` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstatus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Membresia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Membresia` (
  `idMembresia` VARCHAR(20) NOT NULL,
  `costo` DOUBLE NOT NULL,
  `Estatus_idEstatus` INT NOT NULL,
  PRIMARY KEY (`idMembresia`),
  INDEX `fk_Membresia_Estatus1_idx` (`Estatus_idEstatus` ASC),
  CONSTRAINT `fk_Membresia_Estatus1`
    FOREIGN KEY (`Estatus_idEstatus`)
    REFERENCES `centroDeportivo`.`Estatus` (`idEstatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Ubicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Ubicacion` (
  `idUbicacion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUbicacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Servicio` (
  `idServicio` INT NOT NULL AUTO_INCREMENT,
  `nombreServicio` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `Estatus_idEstatus` INT NOT NULL,
  `Ubicacion_idUbicacion` INT NOT NULL,
  PRIMARY KEY (`idServicio`),
  INDEX `fk_Servicio_Estatus1_idx` (`Estatus_idEstatus` ASC),
  INDEX `fk_Servicio_Ubicacion1_idx` (`Ubicacion_idUbicacion` ASC),
  CONSTRAINT `fk_Servicio_Estatus1`
    FOREIGN KEY (`Estatus_idEstatus`)
    REFERENCES `centroDeportivo`.`Estatus` (`idEstatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Servicio_Ubicacion1`
    FOREIGN KEY (`Ubicacion_idUbicacion`)
    REFERENCES `centroDeportivo`.`Ubicacion` (`idUbicacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Resumen_Medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Resumen_Medico` (
  `idResumen_Medico` INT NOT NULL AUTO_INCREMENT,
  `tipoSangre` VARCHAR(5) NOT NULL,
  `peso` FLOAT NOT NULL,
  `altura` FLOAT NOT NULL,
  `condicionMedica` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idResumen_Medico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Estado_Republica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Estado_Republica` (
  `idEstadoRepublica` INT NOT NULL AUTO_INCREMENT,
  `nombreEstado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstadoRepublica`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Direccion` (
  `idDireccion` INT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(45) NOT NULL,
  `numInt` VARCHAR(10) NULL,
  `numExt` SMALLINT NOT NULL,
  `colonia` VARCHAR(45) NOT NULL,
  `cp` INT NOT NULL,
  `Estado_Republica_idEstadoRepublica` INT NOT NULL,
  PRIMARY KEY (`idDireccion`),
  INDEX `fk_Direccion_Estado_Republica_idx` (`Estado_Republica_idEstadoRepublica` ASC),
  CONSTRAINT `fk_Direccion_Estado_Republica`
    FOREIGN KEY (`Estado_Republica_idEstadoRepublica`)
    REFERENCES `centroDeportivo`.`Estado_Republica` (`idEstadoRepublica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = big5;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Socio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Socio` (
  `curp` VARCHAR(18) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidoP` VARCHAR(45) NOT NULL,
  `apellidoM` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `Estatus_idEstatus` INT NOT NULL,
  `Resumen_Medico_idResumen_Medico` INT NOT NULL,
  `Direccion_idDireccion` INT NOT NULL,
  PRIMARY KEY (`curp`, `Resumen_Medico_idResumen_Medico`),
  INDEX `fk_Socio_Estatus1_idx` (`Estatus_idEstatus` ASC),
  INDEX `fk_Socio_Resumen_Medico1_idx` (`Resumen_Medico_idResumen_Medico` ASC),
  INDEX `fk_Socio_Direccion1_idx` (`Direccion_idDireccion` ASC),
  CONSTRAINT `fk_Socio_Estatus1`
    FOREIGN KEY (`Estatus_idEstatus`)
    REFERENCES `centroDeportivo`.`Estatus` (`idEstatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Socio_Resumen_Medico1`
    FOREIGN KEY (`Resumen_Medico_idResumen_Medico`)
    REFERENCES `centroDeportivo`.`Resumen_Medico` (`idResumen_Medico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Socio_Direccion1`
    FOREIGN KEY (`Direccion_idDireccion`)
    REFERENCES `centroDeportivo`.`Direccion` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Telefono` (
  `idTelefono` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NOT NULL,
  `Socio_curp` VARCHAR(18) NOT NULL,
  PRIMARY KEY (`idTelefono`),
  INDEX `fk_Telefono_Socio1_idx` (`Socio_curp` ASC),
  CONSTRAINT `fk_Telefono_Socio1`
    FOREIGN KEY (`Socio_curp`)
    REFERENCES `centroDeportivo`.`Socio` (`curp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Deleg_Muni`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Deleg_Muni` (
  `idDelegMuni` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `Estado_Republica_idEstadoRepublica` INT NOT NULL,
  PRIMARY KEY (`idDelegMuni`),
  INDEX `fk_Deleg_Muni_Estado_Republica1_idx` (`Estado_Republica_idEstadoRepublica` ASC),
  CONSTRAINT `fk_Deleg_Muni_Estado_Republica1`
    FOREIGN KEY (`Estado_Republica_idEstadoRepublica`)
    REFERENCES `centroDeportivo`.`Estado_Republica` (`idEstadoRepublica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Email` (
  `idEmail` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `Socio_curp` VARCHAR(18) NOT NULL,
  PRIMARY KEY (`idEmail`),
  INDEX `fk_Email_Socio1_idx` (`Socio_curp` ASC),
  CONSTRAINT `fk_Email_Socio1`
    FOREIGN KEY (`Socio_curp`)
    REFERENCES `centroDeportivo`.`Socio` (`curp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Enfermedad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Enfermedad` (
  `idEnfermedad` INT NOT NULL AUTO_INCREMENT,
  `enfermedad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEnfermedad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Tipo_Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Tipo_Empleado` (
  `idTipoEmpleado` INT NOT NULL AUTO_INCREMENT,
  `empleado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoEmpleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Empleado` (
  `curp` VARCHAR(18) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `apellidoP` VARCHAR(45) NOT NULL,
  `apellidoM` VARCHAR(45) NOT NULL,
  `nss` VARCHAR(45) NOT NULL,
  `fechaIngreso` DATE NOT NULL,
  `fechaBaja` DATE NULL,
  `fechaFinContrato` DATE NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `Tipo_Empleado_idTipoEmpleado` INT NOT NULL,
  `Direccion_idDireccion` INT NOT NULL,
  `Estatus_idEstatus` INT NOT NULL,
  PRIMARY KEY (`curp`),
  INDEX `fk_Empleado_Tipo_Empleado1_idx` (`Tipo_Empleado_idTipoEmpleado` ASC),
  INDEX `fk_Empleado_Direccion1_idx` (`Direccion_idDireccion` ASC),
  INDEX `fk_Empleado_Estatus1_idx` (`Estatus_idEstatus` ASC),
  CONSTRAINT `fk_Empleado_Tipo_Empleado1`
    FOREIGN KEY (`Tipo_Empleado_idTipoEmpleado`)
    REFERENCES `centroDeportivo`.`Tipo_Empleado` (`idTipoEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Direccion1`
    FOREIGN KEY (`Direccion_idDireccion`)
    REFERENCES `centroDeportivo`.`Direccion` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Estatus1`
    FOREIGN KEY (`Estatus_idEstatus`)
    REFERENCES `centroDeportivo`.`Estatus` (`idEstatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Sucursal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Sucursal` (
  `idSucursal` INT NOT NULL AUTO_INCREMENT,
  `sucursal` VARCHAR(45) NOT NULL,
  `fechaInauguracion` DATE NOT NULL,
  `fechaCierre` DATE NULL,
  `Direccion_idDireccion` INT NOT NULL,
  PRIMARY KEY (`idSucursal`),
  INDEX `fk_Sucursal_Direccion1_idx` (`Direccion_idDireccion` ASC),
  CONSTRAINT `fk_Sucursal_Direccion1`
    FOREIGN KEY (`Direccion_idDireccion`)
    REFERENCES `centroDeportivo`.`Direccion` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Tarjeta_Credito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Tarjeta_Credito` (
  `idTarjeta_Credito` VARCHAR(16) NOT NULL,
  `banco` VARCHAR(20) NOT NULL,
  `fechaVencimiento` DATE NOT NULL,
  `cvv` SMALLINT NOT NULL,
  `Socio_curp` VARCHAR(18) NOT NULL,
  PRIMARY KEY (`idTarjeta_Credito`),
  INDEX `fk_Tarjeta_Credito_Socio1_idx` (`Socio_curp` ASC),
  CONSTRAINT `fk_Tarjeta_Credito_Socio1`
    FOREIGN KEY (`Socio_curp`)
    REFERENCES `centroDeportivo`.`Socio` (`curp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Resumen_Medico_has_Enfermedad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Resumen_Medico_has_Enfermedad` (
  `Resumen_Medico_idResumen_Medico` INT NOT NULL,
  `Enfermedad_idEnfermedad` INT NOT NULL,
  PRIMARY KEY (`Resumen_Medico_idResumen_Medico`, `Enfermedad_idEnfermedad`),
  INDEX `fk_Resumen_Medico_has_Enfermedad_Enfermedad1_idx` (`Enfermedad_idEnfermedad` ASC),
  INDEX `fk_Resumen_Medico_has_Enfermedad_Resumen_Medico1_idx` (`Resumen_Medico_idResumen_Medico` ASC),
  CONSTRAINT `fk_Resumen_Medico_has_Enfermedad_Resumen_Medico1`
    FOREIGN KEY (`Resumen_Medico_idResumen_Medico`)
    REFERENCES `centroDeportivo`.`Resumen_Medico` (`idResumen_Medico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Resumen_Medico_has_Enfermedad_Enfermedad1`
    FOREIGN KEY (`Enfermedad_idEnfermedad`)
    REFERENCES `centroDeportivo`.`Enfermedad` (`idEnfermedad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Membresia_has_Servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Membresia_has_Servicio` (
  `Membresia_idMembresia` VARCHAR(20) NOT NULL,
  `Servicio_idServicio` INT NOT NULL,
  PRIMARY KEY (`Membresia_idMembresia`, `Servicio_idServicio`),
  INDEX `fk_Membresia_has_Servicio_Servicio1_idx` (`Servicio_idServicio` ASC),
  INDEX `fk_Membresia_has_Servicio_Membresia1_idx` (`Membresia_idMembresia` ASC),
  CONSTRAINT `fk_Membresia_has_Servicio_Membresia1`
    FOREIGN KEY (`Membresia_idMembresia`)
    REFERENCES `centroDeportivo`.`Membresia` (`idMembresia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Membresia_has_Servicio_Servicio1`
    FOREIGN KEY (`Servicio_idServicio`)
    REFERENCES `centroDeportivo`.`Servicio` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Sucursal_has_Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Sucursal_has_Empleado` (
  `Sucursal_idSucursal` INT NOT NULL,
  `Empleado_curp` VARCHAR(18) NOT NULL,
  PRIMARY KEY (`Sucursal_idSucursal`, `Empleado_curp`),
  INDEX `fk_Sucursal_has_Empleado_Empleado1_idx` (`Empleado_curp` ASC),
  INDEX `fk_Sucursal_has_Empleado_Sucursal1_idx` (`Sucursal_idSucursal` ASC),
  CONSTRAINT `fk_Sucursal_has_Empleado_Sucursal1`
    FOREIGN KEY (`Sucursal_idSucursal`)
    REFERENCES `centroDeportivo`.`Sucursal` (`idSucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sucursal_has_Empleado_Empleado1`
    FOREIGN KEY (`Empleado_curp`)
    REFERENCES `centroDeportivo`.`Empleado` (`curp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Empleado_Vende_Membresia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Empleado_Vende_Membresia` (
  `Empleado_curp` VARCHAR(18) NOT NULL,
  `Membresia_idMembresia` VARCHAR(20) NOT NULL,
  `fechaVenta` DATE NOT NULL,
  `formaPago` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`Empleado_curp`, `Membresia_idMembresia`),
  INDEX `fk_Empleado_has_Membresia_Membresia1_idx` (`Membresia_idMembresia` ASC),
  INDEX `fk_Empleado_has_Membresia_Empleado1_idx` (`Empleado_curp` ASC),
  CONSTRAINT `fk_Empleado_has_Membresia_Empleado1`
    FOREIGN KEY (`Empleado_curp`)
    REFERENCES `centroDeportivo`.`Empleado` (`curp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_has_Membresia_Membresia1`
    FOREIGN KEY (`Membresia_idMembresia`)
    REFERENCES `centroDeportivo`.`Membresia` (`idMembresia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centroDeportivo`.`Socio_has_Membresia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centroDeportivo`.`Socio_has_Membresia` (
  `Socio_curp` VARCHAR(18) NOT NULL,
  `Socio_Resumen_Medico_idResumen_Medico` INT NOT NULL,
  `Membresia_idMembresia` VARCHAR(20) NOT NULL,
  `fechaActivacion` DATE NOT NULL,
  `fechaVencimiento` DATE NOT NULL,
  PRIMARY KEY (`Socio_curp`, `Socio_Resumen_Medico_idResumen_Medico`, `Membresia_idMembresia`),
  INDEX `fk_Socio_has_Membresia_Membresia1_idx` (`Membresia_idMembresia` ASC),
  INDEX `fk_Socio_has_Membresia_Socio1_idx` (`Socio_curp` ASC, `Socio_Resumen_Medico_idResumen_Medico` ASC),
  CONSTRAINT `fk_Socio_has_Membresia_Socio1`
    FOREIGN KEY (`Socio_curp` , `Socio_Resumen_Medico_idResumen_Medico`)
    REFERENCES `centroDeportivo`.`Socio` (`curp` , `Resumen_Medico_idResumen_Medico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Socio_has_Membresia_Membresia1`
    FOREIGN KEY (`Membresia_idMembresia`)
    REFERENCES `centroDeportivo`.`Membresia` (`idMembresia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
