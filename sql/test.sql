/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 16/12/2022 13:14:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_adjustment_order
-- ----------------------------
DROP TABLE IF EXISTS `t_adjustment_order`;
CREATE TABLE `t_adjustment_order`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '阶段',
  `src_store_id` bigint NULL DEFAULT NULL COMMENT '源仓库id',
  `dest_store_id` bigint NULL DEFAULT NULL COMMENT '目的仓库id',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_adjustment_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_adjustment_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_adjustment_order_item`;
CREATE TABLE `t_adjustment_order_item`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint NULL DEFAULT NULL COMMENT '调货单id',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品id',
  `quantity` bigint NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_adjustment_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_client
-- ----------------------------
DROP TABLE IF EXISTS `t_client`;
CREATE TABLE `t_client`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名字',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_client
-- ----------------------------

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, 'client:insert', NULL);
INSERT INTO `t_permission` VALUES (2, 'client:delete', NULL);
INSERT INTO `t_permission` VALUES (3, 'client:update', NULL);
INSERT INTO `t_permission` VALUES (4, 'client:select', NULL);
INSERT INTO `t_permission` VALUES (5, 'product:insert', NULL);
INSERT INTO `t_permission` VALUES (6, 'product:delete', NULL);
INSERT INTO `t_permission` VALUES (7, 'product:update', NULL);
INSERT INTO `t_permission` VALUES (8, 'product:select', NULL);
INSERT INTO `t_permission` VALUES (9, 'store:insert', NULL);
INSERT INTO `t_permission` VALUES (10, 'store:delete', NULL);
INSERT INTO `t_permission` VALUES (11, 'store:update', NULL);
INSERT INTO `t_permission` VALUES (12, 'store:read', NULL);
INSERT INTO `t_permission` VALUES (13, 'saleNote:insert', NULL);
INSERT INTO `t_permission` VALUES (14, 'saleNote:edit', NULL);
INSERT INTO `t_permission` VALUES (15, 'saleNote:audit', NULL);
INSERT INTO `t_permission` VALUES (16, 'saleNote:collect', NULL);
INSERT INTO `t_permission` VALUES (17, 'saleNote:return', NULL);
INSERT INTO `t_permission` VALUES (18, 'adjustment:insert', NULL);
INSERT INTO `t_permission` VALUES (19, 'adjustment:edit', NULL);
INSERT INTO `t_permission` VALUES (20, 'adjustment:audit', NULL);
INSERT INTO `t_permission` VALUES (21, 'adjustment:return', NULL);
INSERT INTO `t_permission` VALUES (22, 'purchase:insert', NULL);
INSERT INTO `t_permission` VALUES (23, 'purchase:edit', NULL);
INSERT INTO `t_permission` VALUES (24, 'purchase:audit', NULL);
INSERT INTO `t_permission` VALUES (25, 'purchase:return', NULL);
INSERT INTO `t_permission` VALUES (26, 'adjustment:read', NULL);
INSERT INTO `t_permission` VALUES (27, 'purchase:read', NULL);
INSERT INTO `t_permission` VALUES (28, 'saleNote:read', NULL);
INSERT INTO `t_permission` VALUES (29, 'user:edit', NULL);
INSERT INTO `t_permission` VALUES (30, 'statistics:read', NULL);

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '进货价',
  `wholesale_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '批发价',
  `retail_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '零售价',
  `create_time` datetime NULL DEFAULT NULL COMMENT '货品创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_product
-- ----------------------------

-- ----------------------------
-- Table structure for t_purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `t_purchase_order`;
CREATE TABLE `t_purchase_order`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` bigint NULL DEFAULT NULL COMMENT '仓库id',
  `stage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '阶段（创建/完成）',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_purchase_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'owner', '店长');
INSERT INTO `t_role` VALUES (2, 'admin', '管理员');
INSERT INTO `t_role` VALUES (3, 'buyer', '采购员');
INSERT INTO `t_role` VALUES (4, 'warehouseManager', '仓库管理员');
INSERT INTO `t_role` VALUES (5, 'salesperson', '销售员');

-- ----------------------------
-- Table structure for t_role_permission_map
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission_map`;
CREATE TABLE `t_role_permission_map`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission_map
-- ----------------------------
INSERT INTO `t_role_permission_map` VALUES (1, 1, 1);
INSERT INTO `t_role_permission_map` VALUES (2, 1, 2);
INSERT INTO `t_role_permission_map` VALUES (3, 1, 3);
INSERT INTO `t_role_permission_map` VALUES (4, 1, 4);
INSERT INTO `t_role_permission_map` VALUES (5, 1, 5);
INSERT INTO `t_role_permission_map` VALUES (6, 1, 6);
INSERT INTO `t_role_permission_map` VALUES (7, 1, 7);
INSERT INTO `t_role_permission_map` VALUES (8, 1, 8);
INSERT INTO `t_role_permission_map` VALUES (9, 1, 9);
INSERT INTO `t_role_permission_map` VALUES (10, 1, 10);
INSERT INTO `t_role_permission_map` VALUES (11, 1, 11);
INSERT INTO `t_role_permission_map` VALUES (12, 1, 12);
INSERT INTO `t_role_permission_map` VALUES (13, 1, 13);
INSERT INTO `t_role_permission_map` VALUES (14, 1, 14);
INSERT INTO `t_role_permission_map` VALUES (15, 1, 15);
INSERT INTO `t_role_permission_map` VALUES (16, 1, 16);
INSERT INTO `t_role_permission_map` VALUES (17, 1, 17);
INSERT INTO `t_role_permission_map` VALUES (18, 1, 18);
INSERT INTO `t_role_permission_map` VALUES (19, 1, 19);
INSERT INTO `t_role_permission_map` VALUES (20, 1, 20);
INSERT INTO `t_role_permission_map` VALUES (21, 1, 21);
INSERT INTO `t_role_permission_map` VALUES (22, 1, 22);
INSERT INTO `t_role_permission_map` VALUES (23, 1, 23);
INSERT INTO `t_role_permission_map` VALUES (24, 1, 24);
INSERT INTO `t_role_permission_map` VALUES (25, 1, 25);
INSERT INTO `t_role_permission_map` VALUES (26, 1, 26);
INSERT INTO `t_role_permission_map` VALUES (27, 1, 27);
INSERT INTO `t_role_permission_map` VALUES (28, 1, 28);
INSERT INTO `t_role_permission_map` VALUES (29, 1, 30);
INSERT INTO `t_role_permission_map` VALUES (30, 1, 1);
INSERT INTO `t_role_permission_map` VALUES (31, 2, 2);
INSERT INTO `t_role_permission_map` VALUES (32, 2, 3);
INSERT INTO `t_role_permission_map` VALUES (33, 2, 4);
INSERT INTO `t_role_permission_map` VALUES (34, 2, 5);
INSERT INTO `t_role_permission_map` VALUES (35, 2, 6);
INSERT INTO `t_role_permission_map` VALUES (36, 2, 7);
INSERT INTO `t_role_permission_map` VALUES (37, 2, 8);
INSERT INTO `t_role_permission_map` VALUES (38, 2, 9);
INSERT INTO `t_role_permission_map` VALUES (39, 2, 10);
INSERT INTO `t_role_permission_map` VALUES (40, 2, 11);
INSERT INTO `t_role_permission_map` VALUES (41, 2, 12);
INSERT INTO `t_role_permission_map` VALUES (42, 2, 13);
INSERT INTO `t_role_permission_map` VALUES (43, 2, 14);
INSERT INTO `t_role_permission_map` VALUES (44, 2, 15);
INSERT INTO `t_role_permission_map` VALUES (45, 2, 16);
INSERT INTO `t_role_permission_map` VALUES (46, 2, 17);
INSERT INTO `t_role_permission_map` VALUES (47, 2, 18);
INSERT INTO `t_role_permission_map` VALUES (48, 2, 19);
INSERT INTO `t_role_permission_map` VALUES (49, 2, 20);
INSERT INTO `t_role_permission_map` VALUES (50, 2, 21);
INSERT INTO `t_role_permission_map` VALUES (51, 2, 22);
INSERT INTO `t_role_permission_map` VALUES (52, 2, 23);
INSERT INTO `t_role_permission_map` VALUES (53, 2, 24);
INSERT INTO `t_role_permission_map` VALUES (54, 2, 25);
INSERT INTO `t_role_permission_map` VALUES (55, 2, 26);
INSERT INTO `t_role_permission_map` VALUES (56, 2, 27);
INSERT INTO `t_role_permission_map` VALUES (57, 2, 28);
INSERT INTO `t_role_permission_map` VALUES (58, 2, 29);
INSERT INTO `t_role_permission_map` VALUES (59, 2, 30);
INSERT INTO `t_role_permission_map` VALUES (60, 3, 22);
INSERT INTO `t_role_permission_map` VALUES (61, 3, 23);
INSERT INTO `t_role_permission_map` VALUES (62, 3, 24);
INSERT INTO `t_role_permission_map` VALUES (63, 3, 25);
INSERT INTO `t_role_permission_map` VALUES (64, 3, 27);
INSERT INTO `t_role_permission_map` VALUES (65, 3, 12);
INSERT INTO `t_role_permission_map` VALUES (66, 3, 8);
INSERT INTO `t_role_permission_map` VALUES (67, 4, 12);
INSERT INTO `t_role_permission_map` VALUES (68, 4, 18);
INSERT INTO `t_role_permission_map` VALUES (69, 4, 19);
INSERT INTO `t_role_permission_map` VALUES (70, 4, 20);
INSERT INTO `t_role_permission_map` VALUES (71, 4, 21);
INSERT INTO `t_role_permission_map` VALUES (72, 4, 26);
INSERT INTO `t_role_permission_map` VALUES (73, 4, 24);
INSERT INTO `t_role_permission_map` VALUES (74, 4, 25);
INSERT INTO `t_role_permission_map` VALUES (75, 4, 27);
INSERT INTO `t_role_permission_map` VALUES (76, 4, 8);
INSERT INTO `t_role_permission_map` VALUES (77, 5, 4);
INSERT INTO `t_role_permission_map` VALUES (78, 5, 8);
INSERT INTO `t_role_permission_map` VALUES (79, 5, 13);
INSERT INTO `t_role_permission_map` VALUES (80, 5, 14);
INSERT INTO `t_role_permission_map` VALUES (81, 5, 15);
INSERT INTO `t_role_permission_map` VALUES (82, 5, 16);
INSERT INTO `t_role_permission_map` VALUES (83, 5, 17);
INSERT INTO `t_role_permission_map` VALUES (84, 5, 28);

-- ----------------------------
-- Table structure for t_sale_note
-- ----------------------------
DROP TABLE IF EXISTS `t_sale_note`;
CREATE TABLE `t_sale_note`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` bigint NOT NULL COMMENT '仓库id',
  `client_id` bigint NULL DEFAULT NULL COMMENT '客户id',
  `stage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '阶段',
  `cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '总成本',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '售价',
  `received_payment` decimal(10, 2) NULL DEFAULT NULL COMMENT '已收款项',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sale_note_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_store
-- ----------------------------
DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `owner_id` bigint NULL DEFAULT NULL COMMENT '拥有者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_store
-- ----------------------------

-- ----------------------------
-- Table structure for t_store_item
-- ----------------------------
DROP TABLE IF EXISTS `t_store_item`;
CREATE TABLE `t_store_item`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` bigint NULL DEFAULT NULL COMMENT '仓库id',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品id',
  `quantity` bigint NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_store_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色id',
  `is_alive` tinyint NULL DEFAULT 0 COMMENT '是否激活(0否1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (26, 'dianzhang', 'test', '$2a$10$x68Ur/xFuGltbuybwBKdbe1YdXScfMmdDA6i4eEmJi2cyFb5fKJZu', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
