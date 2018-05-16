/*
Navicat MySQL Data Transfer

Source Server         : librarian数据库
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : yunqi_test

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-05-16 20:34:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(8) NOT NULL DEFAULT '0',
  `name` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('10', 'ROLE_ADMIN');
INSERT INTO `role` VALUES ('20', 'ROLE_USER');

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `userId` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `roleId` int(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES ('558ed0b44b2a46f9a755e66d54b467af', 'edf4fdf4e16b41608da95077339bfef8', '20');
INSERT INTO `role_user` VALUES ('b28ed18beccf472c84ba19b2496b5ca1', '3157eab8d21941a5a5021a65cf1a79ae', '20');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `identity` varchar(64) CHARACTER SET utf8mb4 NOT NULL COMMENT '身份令牌',
  `username` varchar(16) CHARACTER SET utf8mb4 NOT NULL,
  `password` varchar(72) CHARACTER SET utf8mb4 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('edf4fdf4e16b41608da95077339bfef8', '10086', 'Jesse', '$2a$10$bg/oyB/VE9ruYpiUSb3oAebL.bnLdMfHoTBXjDwdXm1HjELf08ul2');
INSERT INTO `user` VALUES ('3157eab8d21941a5a5021a65cf1a79ae', 'www', 'zzz', '$2a$10$x9K6diCLqLqDX69Q7qO/He3zi9YV.PIBZbLz.dnIbNDs.aGfRRGrq');
