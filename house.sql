/*
Navicat MySQL Data Transfer

Source Server         : 2016
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2022-01-03 22:23:01
*/

create database house;
use house;
-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `userpwd` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'sizhou', '123456');

-- ----------------------------
-- Table structure for t_house
-- ----------------------------
DROP TABLE IF EXISTS `t_house`;
CREATE TABLE `t_house` (
  `h_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `house_desc` varchar(255) NOT NULL COMMENT '租房描述',
  `house_model` varchar(20) NOT NULL COMMENT '房屋类型，几室几厅',
  `house_area` varchar(20) NOT NULL COMMENT '房屋面积',
  `house_floor` varchar(20) NOT NULL COMMENT '房屋楼层',
  `house_type` varchar(20) NOT NULL COMMENT '出租方式',
  `house_price` int(10) NOT NULL COMMENT '出租价格',
  `house_address` varchar(100) NOT NULL COMMENT '出租地址',
  `house_image` varchar(1000) NOT NULL COMMENT '房屋简介照片',
  `community_name` varchar(100) NOT NULL COMMENT '小区名字',
  `house_link_man` varchar(11) NOT NULL COMMENT '房屋联系电话',
  `house_oriented` varchar(20) NOT NULL COMMENT '房屋朝向',
  `house_detailes_img` varchar(1000) NOT NULL COMMENT '房屋详细页面展示图片',
  `publisher` varchar(50) NOT NULL DEFAULT '管理员' COMMENT '发布人',
  `publish_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `status` int(2) unsigned zerofill NOT NULL DEFAULT '00',
  PRIMARY KEY (`h_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_house
-- ----------------------------
INSERT INTO `t_house` VALUES ('1', '房山城关 原香漫谷三区 满五 三居室 南北向 中高层', '三室两厅一卫', '100', '低层', '整租', '3001', '房山城关', 'http://youngblogupload.oss-cn-beijing.aliyuncs.com/3c0a31e8-713a-44ca-b040-da161d5c22b2.jpg?Expires=1956567194&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=qrxr3ri%2BuXJtMfjS0GART6SMhN0%3D', ' 中国铁建原香漫谷三区', '19974387941', '南北', 'http://youngblogupload.oss-cn-beijing.aliyuncs.com/dbe2b4f0-e127-498b-8c19-2fd690d509b0.jpg?Expires=1956567202&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=HNT%2B2TJ6q8OM3JULEIVPZ%2FGLCZ8%3D~http://youngblogupload.oss-cn-beijing.aliyuncs.com/391ac1a8-e551-4587-a33f-e1f9ba850733.jpg?Expires=1956567202&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=b6IHQmX6safzT30iDKaZ6WT07dc%3D~http://youngblogupload.oss-cn-beijing.aliyuncs.com/d17a6612-f576-43fa-bf2c-cfc585e7f9f0.jpg?Expires=1956567202&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=evMEf4DbsAzLFttbnd0W9TTUc8Q%3D~http://youngblogupload.oss-cn-beijing.aliyuncs.com/b270b238-65fd-40cb-8993-3c9565e6e430.jpg?Expires=1956567202&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=anPYYCWSL5VqjDUkRIoyrqh%2FJNg%3D~http://youngblogupload.oss-cn-beijing.aliyuncs.com/0da77dc7-59a3-4180-97cf-f0175d6974c2.png?Expires=1956567203&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=ivHnR%2BD7PCucZnyWSJ2auYLukTs%3D~', 'sizhou', '2022-01-03 10:53:33', '01');
INSERT INTO `t_house` VALUES ('2', '太平庄东里 干净两居2300 包物业取暖 随时入住', '两室一厅一卫', '85', '高层', '整租', '2300', '北京房山良乡', 'http://youngblogupload.oss-cn-beijing.aliyuncs.com/e425d62a-2384-441e-b7c5-4d8eedd627e1.jpg?Expires=1956576333&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=iC4J9sxP4IrirYA33%2FzP%2BHJGkBQ%3D', '太平庄东里  (房山 良乡)', '15273219756', '东西', 'http://youngblogupload.oss-cn-beijing.aliyuncs.com/101b3031-ff32-43cb-aa1c-6f922a7cacae.jpg?Expires=1956576341&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=y2vzbs1UUBFwjy6HGER0QXl0PgM%3D~http://youngblogupload.oss-cn-beijing.aliyuncs.com/ef048d80-69b3-454d-9c75-146a0d0a5763.jpg?Expires=1956576341&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=3Av9Gl8b33UCi5o%2Fs6UmbcrMP0c%3D~http://youngblogupload.oss-cn-beijing.aliyuncs.com/08c60783-beaf-411e-b0c1-eca01f6d9a5b.jpg?Expires=1956576341&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=VuoBXucWJoSDl1n%2FW0pFUgkpK84%3D~http://youngblogupload.oss-cn-beijing.aliyuncs.com/c3a84782-5304-4cf5-83bc-d7e29a66cb74.jpg?Expires=1956576341&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=3Yi3foCNtrC0desQYxulUioqWLE%3D~', '管理员', '2022-01-03 13:25:43', '01');
INSERT INTO `t_house` VALUES ('3', '新上！南海家园二里 3室2卫 随时看房 有钥匙', '三室两厅', '108', '中层', '整租', '5600', '北京大兴亦庄南海家园二里', 'http://youngblogupload.oss-cn-beijing.aliyuncs.com/cd75a493-199c-4723-8003-e57c3fff8de3.jpg?Expires=1956576740&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=nvx6FtRiYDq7cZsWu%2F2NPwwQe9M%3D', '南海家园二里  (大兴 亦庄)', '18378956724', '南北', 'http://youngblogupload.oss-cn-beijing.aliyuncs.com/a86a08fc-446e-4336-a4ed-fdec7d6cd96c.jpg?Expires=1956576750&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=AflaKLC8E152DRuKk34K0Z5TqCA%3D~http://youngblogupload.oss-cn-beijing.aliyuncs.com/e8c92b02-956c-4303-8406-e3e25f87218c.jpg?Expires=1956576750&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=O23yWyyuDMO1WO8tA0ZHky%2FPs%2BQ%3D~http://youngblogupload.oss-cn-beijing.aliyuncs.com/758cf193-5655-4d84-ab84-d94d55a0b453.jpg?Expires=1956576750&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=1K%2BregoiCuuEFi9XCIEcuq6nQ2s%3D~http://youngblogupload.oss-cn-beijing.aliyuncs.com/b0adcb25-74c3-4aac-8dc0-1d6ae6e05412.jpg?Expires=1956576750&OSSAccessKeyId=LTAI5tKGXkQ9snHjMQXj93UN&Signature=1XI%2Fpxs%2F4v%2Bksgj%2B2y1LZQxNNy4%3D~', '管理员', '2022-01-03 13:32:31', '00');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `o_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `h_id` bigint(11) NOT NULL COMMENT '房屋租赁id',
  `u_id` bigint(11) NOT NULL COMMENT '用户id',
  `order_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `order_user` varchar(20) NOT NULL,
  PRIMARY KEY (`o_id`),
  KEY `fk1` (`h_id`),
  KEY `fk2` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('13', '2', '3', '2022-01-03 14:16:26', '思周1');

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `u_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(20) NOT NULL,
  `u_password` varchar(100) NOT NULL,
  `u_phone_number` varchar(11) DEFAULT NULL COMMENT '用户注册手机号码，用于找回密码',
  `u_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '昵称',
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `uniq` (`u_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('3', 'sizhou', 'sizhou', '19974387940', '思周1');
