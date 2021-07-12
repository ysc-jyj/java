/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : jsu

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2021-07-12 15:58:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for assets
-- ----------------------------
DROP TABLE IF EXISTS `assets`;
CREATE TABLE `assets` (
  `A_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `card` double(32,2) DEFAULT NULL,
  `weChat` double(32,2) DEFAULT NULL,
  `alipay` double(32,2) DEFAULT NULL,
  `other` double(32,2) DEFAULT NULL,
  PRIMARY KEY (`A_id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `username` varchar(16) CHARACTER SET utf8mb4 NOT NULL,
  `payments` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `way` varchar(10) DEFAULT NULL,
  `money` double(32,2) DEFAULT NULL,
  `pdate` varchar(20) DEFAULT NULL,
  `remarks` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for total
-- ----------------------------
DROP TABLE IF EXISTS `total`;
CREATE TABLE `total` (
  `T_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `totalPay` double(32,2) DEFAULT NULL,
  `totalIncome` double(32,2) DEFAULT NULL,
  `balance` double(32,2) DEFAULT NULL,
  `Time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`T_id`)
) ENGINE=InnoDB AUTO_INCREMENT=375 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for totalincome
-- ----------------------------
DROP TABLE IF EXISTS `totalincome`;
CREATE TABLE `totalincome` (
  `username` varchar(255) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  `totalincome` double(32,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for totalpay
-- ----------------------------
DROP TABLE IF EXISTS `totalpay`;
CREATE TABLE `totalpay` (
  `username` varchar(255) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `totalpay` double(32,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(16) DEFAULT NULL,
  `headshot` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TRIGGER IF EXISTS `A`;
DELIMITER ;;
CREATE TRIGGER `A` AFTER INSERT ON `payment` FOR EACH ROW begin
if new.payments='支出'
THEN
case new.way
when '银行卡' then update assets set card=card-new.money where username=new.username;
when '微信' then update assets set weChat=weChat-new.money where username=new.username;
when '支付宝' then update assets set alipay=alipay-new.money where username=new.username;
when '其他' then update assets set other=other-new.money where username=new.username;
end case;
else
case  new.way
when '银行卡' then update assets set card=card+new.money where username=new.username;
when '微信' then update assets set weChat=weChat+new.money where username=new.username;
when '支付宝' then update assets set alipay=alipay+new.money where username=new.username;
when '其他' then update assets set other=other+new.money where username=new.username;
end case;
end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `T`;
DELIMITER ;;
CREATE TRIGGER `T` AFTER INSERT ON `payment` FOR EACH ROW begin
if EXISTS(select * from total where Time=new.pdate and total.username=new.username LIMIT 1)
THEN
if new.payments='支出'
THEN
update total set totalPay=(select sum(money) from payment where payments=new.payments and payments='支出' and pdate=new.pdate and username=new.username group by username,pdate)  where Time=new.pdate and total.username=new.username;
else
update total set totalIncome=(select sum(money) from payment where payments=new.payments and payments='收入' and pdate=new.pdate and username=new.username group by username,pdate) where Time=new.pdate and total.username=new.username;
end if;
else
if new.payments='支出'
THEN
insert into total(username,totalPay,balance,Time)
select username,money,(-sum(money)),pdate
from payment
where payments=new.payments and payments='支出' and money=new.money and pdate=new.pdate and username=new.username
group by username,pdate;
else
insert into total(username,totalIncome,balance,Time)
select username,money,(sum(money)),pdate
from payment
where payments=new.payments and payments='收入' and money=new.money and pdate=new.pdate and username=new.username
group by username,pdate;
end if;
end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `DA`;
DELIMITER ;;
CREATE TRIGGER `DA` AFTER DELETE ON `payment` FOR EACH ROW begin
if old.payments='收入'
THEN
case old.way
when '银行卡' then update assets set card=card-old.money where username=old.username;
when '微信' then update assets set weChat=weChat-old.money where username=old.username;
when '支付宝' then update assets set alipay=alipay-old.money where username=old.username;
when '其他' then update assets set other=other-old.money where username=old.username;
end case;
else
case  old.way
when '银行卡' then update assets set card=card+old.money where username=old.username;
when '微信' then update assets set weChat=weChat+old.money where username=old.username;
when '支付宝' then update assets set alipay=alipay+old.money where username=old.username;
when '其他' then update assets set other=other+old.money where username=old.username;
end case;
end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `DT`;
DELIMITER ;;
CREATE TRIGGER `DT` AFTER DELETE ON `payment` FOR EACH ROW begin
if EXISTS(select * from total where Time=old.pdate and total.username=old.username LIMIT 1)
THEN
if old.payments='支出'
THEN
update total set totalPay=(select sum(money) from payment where payments=old.payments and payments='支出' and pdate=old.pdate and username=old.username group by username,pdate) where Time=old.pdate and total.username=old.username;
else
update total set totalIncome=(select sum(money) from payment where payments=old.payments and payments='收入' and pdate=old.pdate and username=old.username group by username,pdate) where Time=old.pdate and total.username=old.username;
end if;
end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `B`;
DELIMITER ;;
CREATE TRIGGER `B` BEFORE UPDATE ON `total` FOR EACH ROW begin
if(new.username=old.username) and (new.Time=old.Time)
THEN
set new.balance=(new.totalIncome-new.totalPay);
end if;
end
;;
DELIMITER ;
