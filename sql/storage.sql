/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : storage

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 29/10/2022 15:57:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_client
-- ----------------------------
DROP TABLE IF EXISTS `t_client`;
CREATE TABLE `t_client`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_client
-- ----------------------------

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `quantity` bigint UNSIGNED NULL DEFAULT NULL COMMENT '数量',
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '进价',
  `sell_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '售价',
  `create_time` datetime NULL DEFAULT NULL COMMENT '货品创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------

-- ----------------------------
-- Table structure for t_purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `t_purchase_order`;
CREATE TABLE `t_purchase_order`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '阶段（创建/完成）',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_purchase_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_purchase_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_purchase_order_item`;
CREATE TABLE `t_purchase_order_item`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `purchase_order_id` bigint NOT NULL COMMENT '进货单id',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品id',
  `quantity` bigint UNSIGNED NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_purchase_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_sale_note
-- ----------------------------
DROP TABLE IF EXISTS `t_sale_note`;
CREATE TABLE `t_sale_note`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `client_id` bigint NULL DEFAULT NULL COMMENT '客户id',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `stage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '阶段',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sale_note
-- ----------------------------

-- ----------------------------
-- Table structure for t_sale_note_item
-- ----------------------------
DROP TABLE IF EXISTS `t_sale_note_item`;
CREATE TABLE `t_sale_note_item`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sale_note_id` bigint NULL DEFAULT NULL COMMENT '售货单id',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品id',
  `quantity` bigint NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sale_note_item
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
