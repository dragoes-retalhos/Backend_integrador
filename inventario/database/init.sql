-- MySQL Script generated by MySQL Workbench
-- qua 09 out 2024 20:39:05
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`laboratory_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`laboratory_item` (
  `id_laboratory_item_heritage` INT(11) NOT NULL AUTO_INCREMENT,
  `name_item` VARCHAR(250) NOT NULL,
  `brand` VARCHAR(250) NULL DEFAULT NULL,
  `description` VARCHAR(500) NULL DEFAULT NULL,
  `status` INT NULL DEFAULT NULL,
  `model` VARCHAR(250) NULL DEFAULT NULL,
  `serial_number` VARCHAR(250) NULL DEFAULT NULL,
  `invoice_number` VARCHAR(100) NULL DEFAULT NULL,
  `entry_date` DATE NULL DEFAULT NULL,
  `next_calibration` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_laboratory_item_heritage`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`maintenance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`maintenance` (
  `id_maintenance` INT(11) NOT NULL AUTO_INCREMENT,
  `maintenance_type` INT(11) NULL DEFAULT NULL,
  `description` VARCHAR(1000) NULL DEFAULT NULL,
  `status` INT(11) NULL DEFAULT NULL,
  `cost` DECIMAL(10,2) NULL DEFAULT NULL,
  `creation_date` TIMESTAMP NULL DEFAULT NULL,
  `delivery_date` DATE NULL DEFAULT NULL,
  `laboratory_item_id_laboratory_item_heritage` INT(11) NOT NULL,
  PRIMARY KEY (`id_maintenance`),
  INDEX `fk_maintenance_laboratory_item1_idx` (`laboratory_item_id_laboratory_item_heritage` ASC) VISIBLE,
  CONSTRAINT `fk_maintenance_laboratory_item1`
    FOREIGN KEY (`laboratory_item_id_laboratory_item_heritage`)
    REFERENCES `mydb`.`laboratory_item` (`id_laboratory_item_heritage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`attachment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`attachment` (
  `id_attachment` INT(11) NOT NULL AUTO_INCREMENT,
  `name_attachment` VARCHAR(250) NULL DEFAULT NULL,
  `path_attachment` VARCHAR(250) NULL DEFAULT NULL,
  `type_attachment` VARCHAR(50) NULL DEFAULT NULL,
  `size_attachment` BIGINT(20) NULL DEFAULT NULL,
  `creation_date` TIMESTAMP NULL DEFAULT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `laboratory_item_id_laboratory_item_heritage` INT(11) NOT NULL,
  `maintenance_id_maintenance` INT(11) NOT NULL,
  PRIMARY KEY (`id_attachment`),
  INDEX `fk_attachment_laboratory_item1_idx` (`laboratory_item_id_laboratory_item_heritage` ASC) VISIBLE,
  INDEX `fk_attachment_maintenance1_idx` (`maintenance_id_maintenance` ASC) VISIBLE,
  CONSTRAINT `fk_attachment_laboratory_item1`
    FOREIGN KEY (`laboratory_item_id_laboratory_item_heritage`)
    REFERENCES `mydb`.`laboratory_item` (`id_laboratory_item_heritage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_attachment_maintenance1`
    FOREIGN KEY (`maintenance_id_maintenance`)
    REFERENCES `mydb`.`maintenance` (`id_maintenance`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`category` (
  `id_category` INT(11) NOT NULL AUTO_INCREMENT,
  `laboratory_item_id_laboratory_item` INT(11) NOT NULL,
  `title_category` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`id_category`),
  INDEX `fk_category_laboratory_item1_idx` (`laboratory_item_id_laboratory_item` ASC) VISIBLE,
  CONSTRAINT `fk_category_laboratory_item1`
    FOREIGN KEY (`laboratory_item_id_laboratory_item`)
    REFERENCES `mydb`.`laboratory_item` (`id_laboratory_item_heritage`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id_user` INT(11) NOT NULL AUTO_INCREMENT,
  `name_user` VARCHAR(250) NULL DEFAULT NULL,
  `email` VARCHAR(250) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_loan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_loan` (
  `iduser_loan` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `rna` VARCHAR(10) NULL DEFAULT NULL,
  `enterprise` VARCHAR(200) NULL DEFAULT NULL,
  `identification` VARCHAR(20) NULL DEFAULT NULL,
  `phone` VARCHAR(20) NULL DEFAULT NULL,
  `status` INT NULL DEFAULT NULL,  -- Mantendo como INT
  `type_user` INT NULL DEFAULT NULL,  -- Mantendo como INT
  PRIMARY KEY (`iduser_loan`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `rna_UNIQUE` (`rna` ASC) VISIBLE
) ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `mydb`.`loan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`loan` (
  `id_loan` INT(11) NOT NULL AUTO_INCREMENT,
  `loan_date` TIMESTAMP NOT NULL,
  `return_date` TIMESTAMP NULL DEFAULT NULL,
  `status` INT(11) NOT NULL,
  `user_id_user` INT(11) NOT NULL,
  `user_loan_iduser_loan` INT(11) NOT NULL,
  PRIMARY KEY (`id_loan`),
  INDEX `fk_loan_user1_idx` (`user_id_user` ASC) VISIBLE,
  INDEX `fk_loan_user_loan1_idx` (`user_loan_iduser_loan` ASC) VISIBLE,
  CONSTRAINT `fk_loan_user1`
    FOREIGN KEY (`user_id_user`)
    REFERENCES `mydb`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_loan_user_loan1`
    FOREIGN KEY (`user_loan_iduser_loan`)
    REFERENCES `mydb`.`user_loan` (`iduser_loan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`loan_has_laboratory_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`loan_has_laboratory_item` (
  `loan_id_loan` INT(11) NOT NULL,
  `laboratory_item_id_laboratory_item` INT(11) NOT NULL,
  PRIMARY KEY (`loan_id_loan`, `laboratory_item_id_laboratory_item`),
  INDEX `fk_loan_has_laboratory_item_laboratory_item1_idx` (`laboratory_item_id_laboratory_item` ASC) VISIBLE,
  INDEX `fk_loan_has_laboratory_item_loan_idx` (`loan_id_loan` ASC) VISIBLE,
  CONSTRAINT `fk_loan_has_laboratory_item_laboratory_item1`
    FOREIGN KEY (`laboratory_item_id_laboratory_item`)
    REFERENCES `mydb`.`laboratory_item` (`id_laboratory_item_heritage`),
  CONSTRAINT `fk_loan_has_laboratory_item_loan`
    FOREIGN KEY (`loan_id_loan`)
    REFERENCES `mydb`.`loan` (`id_loan`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`location` (
  `id_location` INT(11) NOT NULL AUTO_INCREMENT,
  `laboratory_item_id_laboratory_item` INT(11) NOT NULL,
  `building` VARCHAR(250) NULL DEFAULT NULL,
  `room` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_location`),
  INDEX `fk_location_laboratory_item1_idx` (`laboratory_item_id_laboratory_item` ASC) VISIBLE,
  CONSTRAINT `fk_location_laboratory_item1`
    FOREIGN KEY (`laboratory_item_id_laboratory_item`)
    REFERENCES `mydb`.`laboratory_item` (`id_laboratory_item_heritage`))
ENGINE = InnoDB;




INSERT INTO `mydb`.`laboratory_item` (name_item, brand, model, serial_number, invoice_number, entry_date, next_calibration) VALUES
('Microscope A', 'BrandX', 'Model1', 'SN123456', 'INV1001', '2024-01-15', '2025-01-15'),
('Spectrophotometer B', 'BrandY', 'Model2', 'SN789012', 'INV1002', '2024-02-20', '2025-02-20'),
('Pipette C', 'BrandZ', 'Model3', 'SN345678', 'INV1003', '2024-03-25', '2025-03-25'),
('Centrifuge D', 'BrandX', 'Model4', 'SN901234', 'INV1004', '2024-04-10', '2025-04-10'),
('Incubator E', 'BrandY', 'Model5', 'SN567890', 'INV1005', '2024-05-15', '2025-05-15'),
('Biosafety Cabinet F', 'BrandZ', 'Model6', 'SN135792', 'INV1006', '2024-06-20', '2025-06-20'),
('Refrigerator G', 'BrandX', 'Model7', 'SN246803', 'INV1007', '2024-07-25', '2025-07-25'),
('Fume Hood H', 'BrandY', 'Model8', 'SN864209', 'INV1008', '2024-08-30', '2025-08-30'),
('Water Bath I', 'BrandZ', 'Model9', 'SN975310', 'INV1009', '2024-09-05', '2025-09-05'),
('pH Meter J', 'BrandX', 'Model10', 'SN111213', 'INV1010', '2024-10-01', '2025-10-01');



INSERT INTO `mydb`.`maintenance` (maintenance_type, description, status, cost, creation_date, delivery_date, laboratory_item_id_laboratory_item_heritage) VALUES
(1, 'Routine checkup', 1, 150.00, '2024-01-20 10:00:00', '2024-01-22', 1),
(1, 'Calibration required', 1, 200.00, '2024-02-25 11:00:00', '2024-02-27', 2),
(1, 'Part replacement', 2, 300.00, '2024-03-30 12:00:00', '2024-04-01', 3),
(0, 'Software update', 1, 100.00, '2024-04-05 09:00:00', '2024-04-06', 4),
(1, 'Cleaning and service', 1, 250.00, '2024-05-10 14:00:00', '2024-05-12', 5),
(1, 'Calibration and check', 1, 175.00, '2024-06-15 08:00:00', '2024-06-16', 6),
(1, 'Repair needed', 0, 400.00, '2024-07-20 13:00:00', '2024-07-22', 7),
(0, 'Replacement of filters', 1, 120.00, '2024-08-25 15:00:00', '2024-08-26', 8),
(1, 'Annual service', 1, 350.00, '2024-09-15 10:30:00', '2024-09-18', 9),
(0, 'General maintenance', 1, 200.00, '2024-10-01 16:00:00', '2024-10-03', 10);



INSERT INTO `mydb`.`attachment` (name_attachment, path_attachment, type_attachment, size_attachment, creation_date, description, laboratory_item_id_laboratory_item_heritage, maintenance_id_maintenance) VALUES
('Microscope Manual', '/attachments/microscope_manual.pdf', 'document', 51200, '2024-01-21 10:00:00', 'User manual for microscope', 1, 1),
('Calibration Report', '/attachments/calibration_report.pdf', 'document', 102400, '2024-02-26 11:00:00', 'Calibration report for spectrophotometer', 2, 2),
('Pipette Service Log', '/attachments/pipette_service_log.pdf', 'document', 25600, '2024-03-31 12:00:00', 'Service log for pipette', 3, 3),
('Centrifuge Manual', '/attachments/centrifuge_manual.pdf', 'document', 51200, '2024-04-06 09:00:00', 'User manual for centrifuge', 4, 4),
('Incubator Calibration', '/attachments/incubator_calibration.pdf', 'document', 76800, '2024-05-11 14:00:00', 'Calibration document for incubator', 5, 5),
('Maintenance Report', '/attachments/maintenance_report.pdf', 'document', 128000, '2024-06-17 08:00:00', 'Maintenance report for biosafety cabinet', 6, 6),
('Refrigerator Inspection', '/attachments/refrigerator_inspection.pdf', 'document', 25600, '2024-07-23 13:00:00', 'Inspection report for refrigerator', 7, 7),
('Fume Hood Compliance', '/attachments/fume_hood_compliance.pdf', 'document', 51200, '2024-08-28 15:00:00', 'Compliance report for fume hood', 8, 8),
('Water Bath Manual', '/attachments/water_bath_manual.pdf', 'document', 51200, '2024-09-06 10:30:00', 'User manual for water bath', 9, 9),
('pH Meter Calibration', '/attachments/ph_meter_calibration.pdf', 'document', 25600, '2024-10-02 16:00:00', 'Calibration document for pH meter', 10, 10);




INSERT INTO `mydb`.`category` (laboratory_item_id_laboratory_item, title_category, description) VALUES
(1, 'Optical Instruments', 'Instruments that use optics.'),
(2, 'Spectrometry', 'Instruments for spectrometry analysis.'),
(3, 'Liquid Handling', 'Instruments for handling liquids.'),
(4, 'Separation Techniques', 'Instruments for separating substances.'),
(5, 'Incubation Equipment', 'Equipment for incubating samples.'),
(6, 'Safety Equipment', 'Equipment designed for safety.'),
(7, 'Refrigeration', 'Instruments for cooling substances.'),
(8, 'Fume Extraction', 'Instruments for fume extraction.'),
(9, 'Temperature Control', 'Instruments for controlling temperature.'),
(10, 'Chemical Analysis', 'Instruments for chemical analysis.');



INSERT INTO `mydb`.`user` (name_user, email, password) VALUES
('Alice Johnson', 'alice.johnson@example.com', 'password123'),
('Bob Smith', 'bob.smith@example.com', 'password123'),
('Charlie Brown', 'charlie.brown@example.com', 'password123'),
('Diana Prince', 'diana.prince@example.com', 'password123'),
('Edward Elric', 'edward.elric@example.com', 'password123'),
('Fiona Gallagher', 'fiona.gallagher@example.com', 'password123'),
('George Michael', 'george.michael@example.com', 'password123'),
('Hannah Baker', 'hannah.baker@example.com', 'password123'),
('Ivy League', 'ivy.league@example.com', 'password123'),
('Jack Daniels', 'jack.daniels@example.com', 'password123');



INSERT INTO `mydb`.`user_loan` 
  (`name`, `email`, `rna`, `enterprise`, `identification`, `phone`, `status`, `type_user`) 
VALUES 
  ('João Silva', 'joao.silva1@example.com', '123456789', 'Empresa A', 'ID123456', '11987654321', 1, 1),
  ('João Silva', 'joao.silva2@example.com', '987654321', 'Empresa B', 'ID987654', '11912345678', 1, 2),
  ('Maria Oliveira', 'maria.oliveira@example.com', '112233445', 'Empresa C', 'ID112233', '11876543210', 1, 1),
  ('Maria Oliveira', 'maria.oliveira2@example.com', '223344556', 'Empresa D', 'ID223344', '11765432109', 0, 2),
  ('Carlos Pereira', 'carlos.pereira@example.com', '334455667', 'Empresa E', 'ID334455', '11654321098', 1, 1),
  ('Ana Costa', 'ana.costa@example.com', '445566778', 'Empresa F', 'ID445566', '11543210987', 1, 2),
  ('Carlos Pereira', 'carlos.pereira2@example.com', '556677889', 'Empresa G', 'ID556677', '11432109876', 1, 1),
  ('Patricia Souza', 'patricia.souza@example.com', '667788990', 'Empresa H', 'ID667788', '11321098765', 0, 2);



-- Inserindo Empréstimos
INSERT INTO `mydb`.`loan` (loan_date, return_date, status, user_id_user, user_loan_iduser_loan) VALUES
('2024-09-01 10:00:00', '2024-09-15 10:00:00', 1, 1, 1),
('2024-09-05 15:30:00', '2024-09-20 15:30:00', 0, 2, 2),
('2024-09-10 12:00:00', NULL, 1, 3, 3),
('2024-09-12 14:00:00', '2024-09-25 14:00:00', 1, 4, 1),
('2024-09-20 09:30:00', NULL, 0, 5, 2);

-- Associando Itens aos Empréstimos
INSERT INTO `mydb`.`loan_has_laboratory_item` (loan_id_loan, laboratory_item_id_laboratory_item) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6),
(5, 7);



-- =============================================
-- Views
-- =============================================

CREATE VIEW list_items AS
SELECT name_item, description, COUNT(*) AS amount
FROM laboratory_item
GROUP BY name_item, description;


CREATE VIEW loan_summary AS
SELECT 
    l.id_loan AS loan_id,
    l.status AS loan_status,
    l.return_date AS return_date,
    ul.name AS user_name,
    GROUP_CONCAT(li.name_item SEPARATOR ', ') AS loaned_items
FROM 
    loan l
JOIN 
    user_loan ul ON l.user_loan_iduser_loan = ul.iduser_loan
JOIN 
    loan_has_laboratory_item lli ON l.id_loan = lli.loan_id_loan
JOIN 
    laboratory_item li ON lli.laboratory_item_id_laboratory_item = li.id_laboratory_item_heritage
GROUP BY 
    l.id_loan, l.status, l.return_date, ul.name;




-- =============================================
-- Procedures
-- =============================================


DELIMITER $$

-- Trigger para atualizar a data de empréstimo automaticamente na inserção
CREATE TRIGGER before_insert_loan
BEFORE INSERT ON loan
FOR EACH ROW
BEGIN
    SET NEW.loan_date = NOW(); -- Define a data atual como a data de empréstimo
END$$

-- Trigger para atualizar a data de retorno automaticamente na atualização
CREATE TRIGGER before_update_loan
BEFORE UPDATE ON loan
FOR EACH ROW
BEGIN
    -- Se o status indicar que o item foi devolvido, atualiza a data de retorno
    IF NEW.status = 3 THEN  -- Status 1 pode representar "devolvido" (ajuste conforme seu sistema)
        SET NEW.return_date = NOW();
    END IF;
END$$

-- Trigger para atualizar a data de criação de arquivo automaticamente
CREATE TRIGGER before_insert_attachment
BEFORE INSERT ON attachment
FOR EACH ROW
BEGIN
	SET NEW.creation_date = NOW();
END$$

-- Trigger para atualizar data de inicio da manutenção
CREATE TRIGGER before_insert_maintenance
BEFORE INSERT ON maintenance
FOR EACH ROW
BEGIN
	SET NEW.creation_date = NOW();
END$$

-- Trigger para atualizar data de finalização manutenção
CREATE TRIGGER before_update_maintenance
BEFORE UPDATE ON maintenance
FOR EACH ROW
BEGIN
	IF NEW.status = 2 THEN
		SET NEW.delivery_date = NOW();
	END IF;
END$$
DELIMITER ;


DELIMITER $$

-- Trigger para atualizar a data de cadastro automaticamente na inserção
CREATE TRIGGER before_insert_laboratory_item
BEFORE INSERT ON laboratory_item
FOR EACH ROW
BEGIN
    SET NEW.entry_date = NOW(); -- Define a data atual como a data de cadastro
END$$

DELIMITER ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

