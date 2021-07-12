/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : jsu

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2021-06-23 16:56:48
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
-- Records of assets
-- ----------------------------
INSERT INTO `assets` VALUES ('0000000001', '唐僧', '8930.00', '979.02', '4589.21', '460.60');
INSERT INTO `assets` VALUES ('0000000002', '孙悟空', '4771.80', '499.72', '1600.00', '-5337.00');
INSERT INTO `assets` VALUES ('0000000012', '沙和尚', '0.00', '0.00', '0.00', '0.00');
INSERT INTO `assets` VALUES ('0000000013', 'YSC', '0.00', '0.00', '0.00', '0.00');
INSERT INTO `assets` VALUES ('0000000014', 'ABC', '0.00', '0.00', '0.00', '0.00');
INSERT INTO `assets` VALUES ('0000000015', 'JYJ', '0.00', '0.00', '0.00', '0.00');

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
) ENGINE=InnoDB AUTO_INCREMENT=252 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('0000000002', '孙悟空', '支出', '餐饮', '支付宝', '10.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000003', '孙悟空', '支出', '购物', '微信', '100.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000004', '孙悟空', '支出', '借出', '微信', '20.00', '2020-06-26', '借给XXX');
INSERT INTO `payment` VALUES ('0000000005', '孙悟空', '支出', '支出', '交通', '3.00', '2020-06-26', '公交');
INSERT INTO `payment` VALUES ('0000000006', '孙悟空', '支出', '娱乐', '其他', '20.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000007', '猪八戒', '支出', '餐饮', '支付宝', '25.00', '2020-06-26', '中饭');
INSERT INTO `payment` VALUES ('0000000008', '孙悟空', '支出', '交通', '银行卡', '1.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000010', '孙悟空', '支出', '交通', '银行卡', '20.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000011', '孙悟空', '支出', '交通', '银行卡', '20.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000012', '孙悟空', '支出', '交通', '银行卡', '20.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000013', '猪八戒', '收入', '餐饮', '银行卡', '1000.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000014', '孙悟空', '收入', '餐饮', '银行卡', '1000.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000017', '孙悟空', '支出', '购物', '微信', '100.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000018', '孙悟空', '支出', '旅游', '其他', '2000.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000019', '孙悟空', '支出', '学习', '银行卡', '30.00', '2020-06-26', '');
INSERT INTO `payment` VALUES ('0000000020', '孙悟空', '收入', '生活费', '支付宝', '2000.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000021', '孙悟空', '收入', '工资', '银行卡', '5000.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000022', '孙悟空', '支出', '购物', '其他', '200.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000023', '孙悟空', '支出', '医疗', '银行卡', '300.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000027', '孙悟空', '收入', '退款', '支付宝', '10.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000028', '猪八戒', '支出', '餐饮', '微信', '50.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000029', '孙悟空', '收入', '生活费', '支付宝', '200.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000030', '孙悟空', '支出', '餐饮', '其他', '20.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000032', '猪八戒', '支出', '购物', '支付宝', '100.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000033', '猪八戒', '支出', '娱乐', '支付宝', '200.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000035', '猪八戒', '收入', '退款', '支付宝', '30.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000036', '猪八戒', '支出', '餐饮', '微信', '10.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000037', '唐僧', '支出', '娱乐', '微信', '100.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000038', '唐僧', '支出', '学习', '银行卡', '100.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000039', '唐僧', '支出', '借出', '微信', '200.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000040', '唐僧', '支出', '餐饮', '其他', '10.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000041', '唐僧', '收入', '退款', '银行卡', '20.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000044', '猪八戒', '支出', '学习', '微信', '30.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000045', '孙悟空', '支出', '学习', '微信', '20.00', '2020-06-27', '');
INSERT INTO `payment` VALUES ('0000000064', '孙悟空', '支出', '餐饮', '其他', '10.00', '2020-06-30', '早餐');
INSERT INTO `payment` VALUES ('0000000069', '猪八戒', '支出', '餐饮', '支付宝', '25.00', '2020-06-30', '午餐');
INSERT INTO `payment` VALUES ('0000000071', '猪八戒', '支出', '交通', '微信', '1.00', '2020-06-30', '');
INSERT INTO `payment` VALUES ('0000000079', '唐僧', '支出', '借出', '银行卡', '1000.00', '2020-06-30', '');
INSERT INTO `payment` VALUES ('0000000080', '猪八戒', '支出', '餐饮', '银行卡', '100.00', '2020-06-30', '');
INSERT INTO `payment` VALUES ('0000000083', '猪八戒', '支出', '餐饮', '银行卡', '100.00', '2020-06-30', '');
INSERT INTO `payment` VALUES ('0000000085', '猪八戒', '支出', '餐饮', '银行卡', '100.00', '2020-06-30', '');
INSERT INTO `payment` VALUES ('0000000088', '唐僧', '收入', '生活费', '支付宝', '1500.00', '2020-07-01', '');
INSERT INTO `payment` VALUES ('0000000091', '猪八戒', '支出', '餐饮', '其他', '10.00', '2020-07-01', '');
INSERT INTO `payment` VALUES ('0000000093', '猪八戒', '支出', '餐饮', '银行卡', '10.00', '2020-07-01', '');
INSERT INTO `payment` VALUES ('0000000097', '唐僧', '收入', '退款', '支付宝', '10.00', '2020-07-01', '');
INSERT INTO `payment` VALUES ('0000000098', '唐僧', '收入', '退款', '支付宝', '15.00', '2020-07-01', '');
INSERT INTO `payment` VALUES ('0000000099', '孙悟空', '收入', '红包', '微信', '1.00', '2020-07-01', '');
INSERT INTO `payment` VALUES ('0000000102', '猪八戒', '收入', '工资', '支付宝', '123.00', '2020-07-01', '');
INSERT INTO `payment` VALUES ('0000000112', '唐僧', '支出', '餐饮', '其他', '23.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000113', '唐僧', '支出', '交通', '银行卡', '20.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000114', '唐僧', '支出', '餐饮', '微信', '20.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000116', '唐僧', '收入', '红包', '支付宝', '1.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000117', '唐僧', '支出', '餐饮', '支付宝', '25.00', '2020-07-02', '外卖');
INSERT INTO `payment` VALUES ('0000000120', '孙悟空', '收入', '红包', '微信', '12.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000125', '孙悟空', '支出', '交通', '微信', '12.30', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000126', '唐僧', '支出', '购物', '支付宝', '10.80', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000129', '唐僧', '支出', '餐饮', '其他', '13.60', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000132', '唐僧', '支出', '交通', '其他', '1.40', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000133', '唐僧', '支出', '餐饮', '其他', '1.40', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000134', '唐僧', '收入', '红包', '微信', '1.88', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000135', '唐僧', '支出', '娱乐', '微信', '1.99', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000136', '唐僧', '支出', '购物', '支付宝', '20.99', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000137', '孙悟空', '支出', '交通', '微信', '13.50', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000138', '孙悟空', '收入', '红包', '微信', '8.52', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000139', '唐僧', '收入', '红包', '微信', '1.33', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000140', '唐僧', '支出', '交通', '微信', '2.20', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000141', '孙悟空', '支出', '餐饮', '银行卡', '1.20', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000145', '孙悟空', '支出', '交通', '银行卡', '1.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000146', '孙悟空', '支出', '交通', '银行卡', '1.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000147', '孙悟空', '支出', '交通', '银行卡', '2.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000148', '孙悟空', '支出', '交通', '微信', '1.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000149', '孙悟空', '支出', '交通', '微信', '2.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000150', '孙悟空', '支出', '购物', '银行卡', '123.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000154', '猪八戒', '支出', '购物', '银行卡', '101.00', '2020-07-02', '');
INSERT INTO `payment` VALUES ('0000000248', '猪八戒', '支出', '购物', '微信', '100.00', '2020-12-19', null);
INSERT INTO `payment` VALUES ('0000000249', '孙悟空', '支出', '旅游', '其他', '5555.00', '2020-12-29', '');
INSERT INTO `payment` VALUES ('0000000251', '孙悟空', '收入', '红包', '微信', '20.00', '202012-30', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=373 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of total
-- ----------------------------
INSERT INTO `total` VALUES ('0000000346', '孙悟空', '10.00', null, null, '2020-06-30');
INSERT INTO `total` VALUES ('0000000349', '猪八戒', '326.00', null, null, '2020-06-30');
INSERT INTO `total` VALUES ('0000000350', '唐僧', null, '1525.00', null, '2020-07-01');
INSERT INTO `total` VALUES ('0000000351', '猪八戒', '20.00', '123.00', '103.00', '2020-07-01');
INSERT INTO `total` VALUES ('0000000352', '孙悟空', null, '1.00', '1.00', '2020-07-01');
INSERT INTO `total` VALUES ('0000000353', '唐僧', '140.38', '4.21', '-136.17', '2020-07-02');
INSERT INTO `total` VALUES ('0000000354', '孙悟空', '157.00', '20.52', '-136.48', '2020-07-02');
INSERT INTO `total` VALUES ('0000000355', '猪八戒', '101.00', null, null, '2020-07-02');
INSERT INTO `total` VALUES ('0000000370', '猪八戒', '100.00', null, '-100.00', '2020-12-19');
INSERT INTO `total` VALUES ('0000000371', '孙悟空', '5555.00', null, null, '2020-12-29');
INSERT INTO `total` VALUES ('0000000372', '孙悟空', null, '20.00', '20.00', '202012-30');

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
-- Records of totalincome
-- ----------------------------
INSERT INTO `totalincome` VALUES ('孙悟空', '2020-06-26', '10160.00');
INSERT INTO `totalincome` VALUES ('猪八戒', '2020-06-26', '1000.00');

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
-- Records of totalpay
-- ----------------------------
INSERT INTO `totalpay` VALUES ('孙悟空', '2020-06-26', '2852.00');
INSERT INTO `totalpay` VALUES ('猪八戒', '2020-06-26', '80.00');
INSERT INTO `totalpay` VALUES ('孙悟空', '2020-06-26', '2344.00');
INSERT INTO `totalpay` VALUES ('孙悟空', '2020-06-27', '508.00');
INSERT INTO `totalpay` VALUES ('猪八戒', '2020-06-26', '30.00');
INSERT INTO `totalpay` VALUES ('猪八戒', '2020-06-27', '50.00');

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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('孙悟空', '123456', null, null);
INSERT INTO `user` VALUES ('猪八戒', '1234567', null, null);
INSERT INTO `user` VALUES ('唐僧', '123456', null, null);
INSERT INTO `user` VALUES ('沙和尚', '654321', null, null);
INSERT INTO `user` VALUES ('YSC', '123456', null, null);
INSERT INTO `user` VALUES ('ABC', '123456', null, null);
INSERT INTO `user` VALUES ('JYJ', '123456', null, null);
INSERT INTO `user` VALUES ('SDF', '123456', null, null);

-- ----------------------------
-- View structure for sum_income
-- ----------------------------
DROP VIEW IF EXISTS `sum_income`;
CREATE ALGORITHM=UNDEFINED DEFINER=`skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `sum_income` AS select `payment`.`date` AS `date`,`payment`.`username` AS `username`,sum(`payment`.`money`) AS `sumIncome` from `payment` where (`payment`.`payments` = '收入') group by `payment`.`date` ;

-- ----------------------------
-- View structure for sum_pay
-- ----------------------------
DROP VIEW IF EXISTS `sum_pay`;
CREATE ALGORITHM=UNDEFINED DEFINER=`skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `sum_pay` AS select `payment`.`date` AS `date`,`payment`.`username` AS `username`,sum(`payment`.`money`) AS `sumPay` from `payment` where (`payment`.`payments` = '支出') group by `payment`.`date` ;
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
