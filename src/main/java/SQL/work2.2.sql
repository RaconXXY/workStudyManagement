-- MySQL Script generated by MySQL Workbench
-- Sun Sep 10 12:41:58 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_workstudy
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db_workstudy` ;

-- -----------------------------------------------------
-- Schema db_workstudy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_workstudy` DEFAULT CHARACTER SET utf8 ;
USE `db_workstudy` ;

-- -----------------------------------------------------
-- Table `db_workstudy`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`user` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`user` (
  `userId` VARCHAR(13) NOT NULL,
  `name` VARCHAR(8) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
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
  `finance` VARCHAR(7) NULL COMMENT '顺位：国家励志奖学金，国家助学金，山大助学金，社会助学金，临时困难补助，减免学费，其他\n',
  `otherFinance` VARCHAR(45) NULL,
  `financeNumber` SMALLINT(5) NULL COMMENT '本学年已获得资助金额\n',
  `reason` VARCHAR(200) NOT NULL,
  `teacherResult` INT(1) NOT NULL DEFAULT -1 COMMENT '教评结果 -1未评定、0不通过、1一般困难、2困难、3特别困难，管理员结果格式一样',
  `adminResult` INT(1) NOT NULL DEFAULT -1,
  PRIMARY KEY (`studentId`, `tableYear`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`stipend`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`stipend` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`stipend` (
  `studentId` VARCHAR(13) NOT NULL,
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
  `teacherResult` INT(1) NOT NULL DEFAULT -1 COMMENT '-1未评定、0未通过、1一档、2二档',
  `adminResult` INT(1) NOT NULL DEFAULT -1,
  PRIMARY KEY (`studentId`, `tableYear`))
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
  `residence` TINYINT NOT NULL COMMENT '家庭户口0为城镇、1为农村',
  `incomeSource` VARCHAR(20) NOT NULL,
  `incomePerMonth` INT(10) NOT NULL,
  `peopleNumber` TINYINT(2) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `postcode` VARCHAR(6) NOT NULL,
  `reason` VARCHAR(200) NOT NULL,
  `teacherResult` INT(1) NOT NULL DEFAULT -1 COMMENT '-1未评定、0未通过、1通过',
  `adminResult` INT(1) NOT NULL DEFAULT -1,
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
  `teacherResult` INT(1) NOT NULL DEFAULT -1 COMMENT '-1未评定、0未通过、1通过',
  `adminResult` INT(1) NOT NULL DEFAULT -1,
  PRIMARY KEY (`studentId`, `tableYear`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`prize`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`prize` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`prize` (
  `studentId` VARCHAR(13) NOT NULL,
  `date` VARCHAR(10) NOT NULL COMMENT '获奖日期',
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


-- -----------------------------------------------------
-- Table `db_workstudy`.`discountfee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`discountfee` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`discountfee` (
  `studentId` VARCHAR(13) NOT NULL,
  `tableYear` VARCHAR(10) NOT NULL,
  `sex` VARCHAR(3) NOT NULL,
  `birthYear` VARCHAR(4) NOT NULL,
  `birthMonth` VARCHAR(2) NOT NULL,
  `nation` VARCHAR(5) NOT NULL,
  `politicalStatus` VARCHAR(5) NOT NULL,
  `phone` VARCHAR(11) NOT NULL,
  `residence` TINYINT(1) NOT NULL,
  `incomeSource` VARCHAR(20) NOT NULL,
  `incomePerMonth` INT(10) NOT NULL,
  `peopleNumber` TINYINT(2) NOT NULL,
  `isLoan` INT(1) NOT NULL DEFAULT 0 COMMENT '是否申请助学贷款',
  `reason` VARCHAR(200) NOT NULL,
  `teacherResult` INT(5) NOT NULL DEFAULT -1 COMMENT '-1未评定 其他数值为评定金额',
  `adminResult` INT(5) NOT NULL DEFAULT -1,
  PRIMARY KEY (`studentId`, `tableYear`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`questionary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`questionary` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`questionary` (
  `studentId` VARCHAR(13) NOT NULL,
  `tableYear` VARCHAR(10) NOT NULL,
  `sex` VARCHAR(3) NOT NULL,
  `birthYear` VARCHAR(4) NOT NULL,
  `birthMonth` VARCHAR(2) NOT NULL,
  `nation` VARCHAR(5) NOT NULL,
  `residence` INT(1) NOT NULL,
  `isOrphan` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否是孤儿 0不是、1是',
  `isDeformity` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否残疾 0不是、1是',
  `isSingleFamily` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否单亲 0不是、1是',
  `isMartyr` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '烈士子女 0不是、1是',
  `isDiffFamily` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '农村贫困或城市低保户 0不是、1是',
  `phone` VARCHAR(11) NOT NULL,
  `identityCardId` VARCHAR(18) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `salaryPerYear` INT(10) NOT NULL COMMENT '家庭成员年工资合计',
  `indiOperPerYear` INT(10) NOT NULL COMMENT '家庭个体经营总收入',
  `assetsIncome` INT(10) NOT NULL,
  `agricultureIncome` INT(10) NOT NULL COMMENT '家庭农业年净收入',
  `sidelineIncome` INT(10) NOT NULL COMMENT '家庭副业年净收入',
  `otherIncome` INT(10) NOT NULL,
  `peopleNumber` INT(2) NOT NULL COMMENT '家庭人口数',
  `totalIncomePerYear` INT(10) NOT NULL COMMENT '家庭年收入总计',
  `yearIncomePerPerson` INT(10) NOT NULL COMMENT '人均年收入',
  `workPeople` INT(2) NOT NULL COMMENT '家庭劳动力',
  `illnessFee` INT(10) NOT NULL COMMENT '家庭成员大病支出',
  `tuition` INT(10) NOT NULL COMMENT '非义务制教育支出学费（含本人）',
  `accommodation` INT(10) NOT NULL COMMENT '非义务制教育支出住宿费（含本人）',
  `naturalLoss` INT(10) NOT NULL COMMENT '家庭遭受自然灾害，农作物或家庭财产受损',
  `other` VARCHAR(200) NOT NULL COMMENT '其他描述详细说明',
  PRIMARY KEY (`studentId`, `tableYear`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`family_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`family_member` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`family_member` (
  `studentId` VARCHAR(13) NOT NULL,
  `name` VARCHAR(10) NOT NULL,
  `age` INT(2) NOT NULL,
  `appellation` VARCHAR(5) NOT NULL COMMENT '称谓',
  `workCeremony` VARCHAR(45) NOT NULL COMMENT '工作或学习单位',
  `health` INT(1) NOT NULL COMMENT '健康情况 0为大病/重残、1为小病/轻残、2为健康',
  `study` INT(1) NOT NULL DEFAULT 0 COMMENT '在学情况。 0 为未在学、1为小学、2为初中、3为高中、4为大学（含研究生）',
  PRIMARY KEY (`studentId`, `name`, `age`, `appellation`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`award`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`award` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`award` (
  `studentId` VARCHAR(13) NOT NULL,
  `awardName` VARCHAR(25) NOT NULL,
  `awardNumber` INT(10) NOT NULL,
  PRIMARY KEY (`studentId`, `awardName`, `awardNumber`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`help`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`help` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`help` (
  `studentId` VARCHAR(13) NOT NULL,
  `helpName` VARCHAR(25) NOT NULL,
  `helpNumber` INT(10) NOT NULL,
  PRIMARY KEY (`studentId`, `helpName`, `helpNumber`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`studentlib`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`studentlib` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`studentlib` (
  `studentId` VARCHAR(13) NOT NULL,
  `tableYear` VARCHAR(10) NOT NULL,
  `isLoan` TINYINT(1) NOT NULL DEFAULT 0,
  `isWorkAndStudy` TINYINT(1) NOT NULL DEFAULT 0,
  `awardsName` VARCHAR(100) NOT NULL,
  `awardsNumber` VARCHAR(10) NOT NULL,
  `helpsName` VARCHAR(100) NOT NULL,
  `helpsNumber` VARCHAR(10) NOT NULL,
  `other` VARCHAR(100) NOT NULL,
  `isCheckin` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`studentId`, `tableYear`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_workstudy`.`timecontrol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_workstudy`.`timecontrol` ;

CREATE TABLE IF NOT EXISTS `db_workstudy`.`timecontrol` (
  `admitApplyTeacher` TINYINT(1) NOT NULL,
  `stipendTeacher` TINYINT(1) NOT NULL,
  `encouragementTeacher` TINYINT(1) NOT NULL,
  `scholarshipTeacher` TINYINT(1) NOT NULL,
  `discountFeeTeacher` TINYINT(1) NOT NULL,
  `admitApplySt` TINYINT(1) NOT NULL,
  `questionarySt` TINYINT(1) NOT NULL,
  `stipendSt` TINYINT(1) NOT NULL,
  `encouragementSt` TINYINT(1) NOT NULL,
  `scholarshipSt` TINYINT(1) NOT NULL,
  `discountFeeSt` TINYINT(1) NOT NULL)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;