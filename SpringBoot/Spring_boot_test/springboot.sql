/*
 Navicat Premium Data Transfer

 Source Server         : shy
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 29/03/2021 17:47:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for diary
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `date_day` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of diary
-- ----------------------------
INSERT INTO `diary` VALUES (1, '2021-03-11', '张培恒', '我爱你');
INSERT INTO `diary` VALUES (2, '2021-03-11', '张培恒', '我爱你');
INSERT INTO `diary` VALUES (3, '3.2', '绍', '我爱你');
INSERT INTO `diary` VALUES (4, '2021-03-28', '爱爱', '撒打发');
INSERT INTO `diary` VALUES (5, '2021-03-28', '爱爱', '撒打发');
INSERT INTO `diary` VALUES (6, '2021-03-28', '', '');
INSERT INTO `diary` VALUES (7, '2021-03-20', '', '');
INSERT INTO `diary` VALUES (8, '2021-03-20', '', '');
INSERT INTO `diary` VALUES (9, '', '绍', '');
INSERT INTO `diary` VALUES (10, '', '绍', '');
INSERT INTO `diary` VALUES (11, '', '绍', '');
INSERT INTO `diary` VALUES (12, '', '绍', '');
INSERT INTO `diary` VALUES (13, '', '绍', '');
INSERT INTO `diary` VALUES (14, '2021-03-05', '所发生的', '阿斯顿发胜多负少 阿斯顿发说的发的方式打发送发送到发的发的发大水飞阿道夫的示范法');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `permission_id` int(0) NOT NULL AUTO_INCREMENT,
  `permission_code` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permission_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES (1, 'sys:1', 'home');
INSERT INTO `permissions` VALUES (2, 'sys:2', 'inif');
INSERT INTO `permissions` VALUES (3, 'sys:3', 'banner');
INSERT INTO `permissions` VALUES (4, 'sys:4', 'idea');

-- ----------------------------
-- Table structure for personal
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(0) NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personal
-- ----------------------------
INSERT INTO `personal` VALUES (1, '男', '2001115', 19, '18869709117');
INSERT INTO `personal` VALUES (4, 'on', '1991', 2, '18860132893');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `role_id` int(0) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, 'general');
INSERT INTO `roles` VALUES (2, 'vip');
INSERT INTO `roles` VALUES (3, 'system');

-- ----------------------------
-- Table structure for rps
-- ----------------------------
DROP TABLE IF EXISTS `rps`;
CREATE TABLE `rps`  (
  `rid` int(0) NOT NULL,
  `pid` int(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rps
-- ----------------------------
INSERT INTO `rps` VALUES (1, 1);
INSERT INTO `rps` VALUES (1, 2);
INSERT INTO `rps` VALUES (1, 3);
INSERT INTO `rps` VALUES (1, 4);
INSERT INTO `rps` VALUES (2, 1);
INSERT INTO `rps` VALUES (2, 2);
INSERT INTO `rps` VALUES (2, 3);
INSERT INTO `rps` VALUES (2, 4);
INSERT INTO `rps` VALUES (3, 1);
INSERT INTO `rps` VALUES (3, 2);
INSERT INTO `rps` VALUES (3, 3);

-- ----------------------------
-- Table structure for urs
-- ----------------------------
DROP TABLE IF EXISTS `urs`;
CREATE TABLE `urs`  (
  `uid` int(0) NOT NULL,
  `rid` int(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of urs
-- ----------------------------
INSERT INTO `urs` VALUES (1, 1);
INSERT INTO `urs` VALUES (2, 2);
INSERT INTO `urs` VALUES (3, 3);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password_salt` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (2, 'zph', '1234', '1234');
INSERT INTO `users` VALUES (3, 'zs', '1234', '1234');
INSERT INTO `users` VALUES (5, 'shy1', '1234', '1234');
INSERT INTO `users` VALUES (6, 'lixx', '123456', '123456');

SET FOREIGN_KEY_CHECKS = 1;
