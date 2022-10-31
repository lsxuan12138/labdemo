/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 05/06/2022 11:36:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area`  (
  `area_id` int(2) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `priority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `last_edit_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`area_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES (5, '邓州', '23', '2022-06-04 22:50:35', '2022-06-04 22:50:35');
INSERT INTO `tb_area` VALUES (6, '江苏', '2', '2022-06-04 22:51:33', '2022-06-04 22:51:33');
INSERT INTO `tb_area` VALUES (8, '南京', '3', NULL, '2022-06-04 23:04:12');
INSERT INTO `tb_area` VALUES (10, '南阳', '1', '2022-06-05 11:34:58', '2022-06-05 11:34:58');

SET FOREIGN_KEY_CHECKS = 1;
