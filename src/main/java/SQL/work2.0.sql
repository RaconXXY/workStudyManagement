SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `db_workstudy` ;
CREATE SCHEMA IF NOT EXISTS `db_workstudy` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `db_workstudy` ;

-- -----------------------------------------------------
-- Table `db_workstudy`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`user` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`user` (
  `userId` VARCHAR(13) NOT NULL,
  `name` VARCHAR(8) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(11) NOT NULL,
  `academy` VARCHAR(20) NULL,
  `major` VARCHAR(20) NULL,
  `className` VARCHAR(20) NULL,
  `type` INT NOT NULL COMMENT '0 student,1 teacher,2 manager',
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `studentId_UNIQUE` (`userId` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`admitapply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`admitapply` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`admitapply` (
  `studentId` VARCHAR(13) NOT NULL,
  `tableYear` VARCHAR(10) NOT NULL COMMENT '学年字段\nYYYY-YYYY格式',
  `sex` VARCHAR(3) NOT NULL,
  `birthYear` VARCHAR(4) NOT NULL,
  `birthMonth` VARCHAR(2) NOT NULL,
  `nation` VARCHAR(5) NOT NULL COMMENT '民族',
  `politicalStatus` VARCHAR(5) NOT NULL COMMENT '政治面貌',
  `birthPlace` VARCHAR(50) NOT NULL COMMENT '籍贯',
  `phone` VARCHAR(11) NOT NULL,
  `isContinue` TINYINT NOT NULL,
  `isRender` TINYINT NOT NULL,
  `workAndStudy` VARCHAR(200) NULL,
  `socialActivity` VARCHAR(200) NULL,
  `finance` VARCHAR(6) NULL COMMENT '顺位：国家励志奖学金，国家助学金，山大助学金，社会助学金，临时困难补助，减免学费\n',
  `otherFinance` VARCHAR(45) NULL,
  `financeNumber` SMALLINT(5) NULL COMMENT '本学年已获得资助金额\n',
  `reason` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`studentId`, `tableYear`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`stipend`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`stipend` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`stipend` (
  `studnetId` VARCHAR(13) NOT NULL,
  `tableYear` VARCHAR(10) NOT NULL,
  `sex` VARCHAR(3) NOT NULL,
  `birthYear` VARCHAR(4) NOT NULL,
  `birthMonth` VARCHAR(2) NOT NULL,
  `nation` VARCHAR(5) NOT NULL,
  `startYear` VARCHAR(4) NOT NULL,
  `startMonth` VARCHAR(2) NOT NULL,
  `politicalStatus` VARCHAR(5) NOT NULL,
  `identityCardId` VARCHAR(18) NOT NULL,
  `phone` VARCHAR(11) NOT NULL,
  `residence` TINYINT NOT NULL COMMENT '户口类型：0为城镇，1为农村',
  `incomeSource` VARCHAR(20) NOT NULL COMMENT '收入来源描述',
  `incomePerMonth` INT(10) NOT NULL COMMENT '家庭月总收入',
  `peopleNumber` TINYINT(2) NOT NULL COMMENT '家庭人口总数',
  `address` VARCHAR(45) NOT NULL COMMENT '家庭地址',
  `postcode` VARCHAR(6) NOT NULL COMMENT '邮编',
  `reason` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`studnetId`, `tableYear`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`encouragement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`encouragement` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`encouragement` (
  `studentId` VARCHAR(13) NOT NULL,
  `tableYear` VARCHAR(10) NOT NULL,
  `sex` VARCHAR(3) NOT NULL,
  `birthYear` VARCHAR(4) NOT NULL,
  `birthMonth` VARCHAR(2) NOT NULL,
  `nation` VARCHAR(5) NOT NULL,
  `startYear` VARCHAR(4) NOT NULL,
  `startMonth` VARCHAR(2) NOT NULL,
  `politicalStatus` VARCHAR(5) NOT NULL,
  `phone` VARCHAR(11) NOT NULL,
  `identityCardId` VARCHAR(18) NOT NULL,
  `grade` VARCHAR(15) NOT NULL COMMENT '成绩排名格式：名次/总人数',
  `courseNum` VARCHAR(2) NOT NULL COMMENT '必修课门数',
  `passNum` VARCHAR(2) NOT NULL COMMENT '必修课及格门数',
  `rank` TINYINT NOT NULL COMMENT '是否实行综合考评排名：0为否，1为是',
  `residence` TINYINT NOT NULL,
  `incomeSource` VARCHAR(20) NOT NULL,
  `incomePerMonth` INT(10) NOT NULL,
  `peopleNumber` TINYINT(2) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `postcode` VARCHAR(6) NOT NULL,
  `reason` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`studentId`, `tableYear`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`scholarship`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`scholarship` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`scholarship` (
  `studentId` VARCHAR(13) NOT NULL,
  `tableYear` VARCHAR(10) NOT NULL,
  `sex` VARCHAR(3) NOT NULL,
  `birthYear` VARCHAR(4) NOT NULL,
  `birthMonth` VARCHAR(2) NOT NULL,
  `politicalStatus` VARCHAR(5) NOT NULL,
  `nation` VARCHAR(5) NOT NULL,
  `startYear` VARCHAR(4) NOT NULL,
  `startMonth` VARCHAR(2) NOT NULL,
  `studyYears` VARCHAR(3) NOT NULL COMMENT '学制：肆年',
  `phone` VARCHAR(11) NOT NULL,
  `identityCardId` VARCHAR(18) NOT NULL,
  `grade` VARCHAR(15) NOT NULL,
  `courseNum` VARCHAR(2) NOT NULL,
  `passNum` VARCHAR(2) NOT NULL,
  `rank` TINYINT NOT NULL,
  `reason` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`studentId`, `tableYear`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`prize`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`prize` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`prize` (
  `studentId` VARCHAR(13) NOT NULL,
  `date` DATE NOT NULL COMMENT '获奖日期',
  `priceName` VARCHAR(30) NOT NULL COMMENT '奖项名称',
  `awardCeremony` VARCHAR(45) NOT NULL COMMENT '颁奖单位',
  PRIMARY KEY (`studentId`, `date`, `priceName`, `awardCeremony`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`class`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`class` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`class` (
  `academy` VARCHAR(20) NOT NULL,
  `major` VARCHAR(20) NOT NULL,
  `class` VARCHAR(20) NOT NULL,
  `teacherId` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`academy`, `major`, `class`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`t_todo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`t_todo` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`t_todo` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(255) NULL DEFAULT '',
  `isfinish` TINYINT(1) NULL DEFAULT false,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
