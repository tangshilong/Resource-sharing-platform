/*
Navicat MySQL Data Transfer

Source Server         : 懒虫之家
Source Server Version : 50633
Source Host           : 118.178.228.37:3306
Source Database       : ReShare

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-11-08 20:10:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for a_resource
-- ----------------------------
DROP TABLE IF EXISTS `a_resource`;
CREATE TABLE `a_resource` (
  `id` varchar(40) NOT NULL COMMENT '资源id',
  `type` varchar(10) DEFAULT NULL COMMENT '资源类型',
  `name` varchar(10) DEFAULT NULL COMMENT '资源名称',
  `content` text COMMENT '资源内容（账号密码）',
  `describe` varchar(40) DEFAULT NULL COMMENT '资源描述',
  `owner` varchar(20) DEFAULT NULL COMMENT '资源拥有者',
  `createTime` date DEFAULT NULL COMMENT '资源生成时间',
  `url` varchar(120) DEFAULT NULL COMMENT '资源链接地址',
  `permitAccountNum` text COMMENT '有权限用户账号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_resource
-- ----------------------------
INSERT INTO `a_resource` VALUES ('5e8d4fa7-a5aa-11e6-930d-00163e0d48c0', '0', '爱奇艺会员', '账号：18393918636 密码：m12345678', '还有30天到期', 'admin', '2016-11-08', '', null);
INSERT INTO `a_resource` VALUES ('6035cd8f-a4bd-11e6-930d-00163e0d48c0', '2', '英雄联盟账号', '逗你玩', '英雄联盟账号', 'tangshilong', '2016-11-07', '1606f20d-e8ec-4495-9c58-b888bbf353a7.jpg', null);
INSERT INTO `a_resource` VALUES ('9aceff0b-a5aa-11e6-930d-00163e0d48c0', '2', 'NBA2KOL', '账号：295188526  密码：sd6482228', '玫瑰花园满级', 'admin', '2016-11-08', '', null);
INSERT INTO `a_resource` VALUES ('fe5f8428-a5aa-11e6-930d-00163e0d48c0', '1', '大数据还是小数据', '详细请下载附件', '李廉老师的授课ppt，有关大数据的', 'admin', '2016-11-08', '54e39e4a-485b-4364-a0d1-2db1b88553f0.pptx', null);

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `MENU_ID` varchar(40) NOT NULL DEFAULT '' COMMENT '菜单ID',
  `MENU_NAME` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `PARENT_ID` varchar(40) DEFAULT '' COMMENT '上级菜单ID',
  `MENU_URL` varchar(50) DEFAULT NULL COMMENT '菜单URL',
  `ORDER_NO` int(20) DEFAULT NULL COMMENT '排序号',
  `PERMITION` varchar(3) NOT NULL COMMENT '菜单的访问权限 0：普通用户 1：管理员',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='èœå•';

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES ('1000', '系统管理', '0', 'none', '200', '0,1');
INSERT INTO `s_menu` VALUES ('1200', '菜单管理', '1000', '/Menu.html', '210', '1');
INSERT INTO `s_menu` VALUES ('1600', '用户管理', '1000', '/User.html', '220', '1');
INSERT INTO `s_menu` VALUES ('2a9b3c18-911e-11e6-9ce2-525400dcd386', '学习资源', '96cec5f6-911d-11e6-9ce2-525400dcd386', '/Study.html', '110', '0,1');
INSERT INTO `s_menu` VALUES ('49d9f33b-911e-11e6-9ce2-525400dcd386', '游戏账号', '96cec5f6-911d-11e6-9ce2-525400dcd386', '/Game.html', '120', '0,1');
INSERT INTO `s_menu` VALUES ('6c662d8e-bbc8-1034-945a-4626eb2c17f1', '娱乐', '0', 'none', '300', '0,1');
INSERT INTO `s_menu` VALUES ('6fb7c615-911e-11e6-9ce2-525400dcd386', '视频网站VIP', '96cec5f6-911d-11e6-9ce2-525400dcd386', '/vip.html', '130', '0,1');
INSERT INTO `s_menu` VALUES ('8517e52b-911e-11e6-9ce2-525400dcd386', '我的资源', '96cec5f6-911d-11e6-9ce2-525400dcd386', '/MyResource.html', '140', '0,1');
INSERT INTO `s_menu` VALUES ('96cec5f6-911d-11e6-9ce2-525400dcd386', '资源共享', '0', 'none', '100', '0,1');
INSERT INTO `s_menu` VALUES ('9d2bc264-bbc8-1034-945a-4626eb2c17f1', '音乐', '6c662d8e-bbc8-1034-945a-4626eb2c17f1', '/Music.html', '310', '1');

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id` int(5) NOT NULL COMMENT '角色标志位(0位普通用户,1位管理员)',
  `roleName` varchar(50) NOT NULL COMMENT '用户角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('0', '普通用户');
INSERT INTO `s_role` VALUES ('1', '管理员');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键 id',
  `accountNumber` char(20) NOT NULL COMMENT '账号',
  `nickName` varchar(40) NOT NULL DEFAULT '' COMMENT '昵称',
  `password` char(40) NOT NULL DEFAULT '' COMMENT '密码',
  `role` int(2) NOT NULL DEFAULT '0' COMMENT '用户类型：1 admin 0 普通用户',
  `enable` char(10) NOT NULL DEFAULT '' COMMENT '账户是否可用 是  “可用”  否 “禁用”',
  `createDate` varchar(40) NOT NULL COMMENT '创建时间',
  `e_mail` char(100) DEFAULT '',
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'admin', '管理员', 'ce93dc0787c6ba2db2feaac461cc13fa', '1', '可用', '2016-08-09', 'baijw12@lzu.edu.cn', '598bc9db-97e0-40e4-bf0d-5a11a6c27933.jpg');
INSERT INTO `s_user` VALUES ('37', 'baijw', '白江伟', 'fe30b260f79c0173ebb4453dd8fbd0ad', '1', '可用', '2016-08-24 11:30:05', 'baijw12@lzu.edu.cn', 'f5506ac1-56f5-47a5-9d11-66c0b8e64c45.png?imageView2/2/w/100/h/100/interlace/0/q/50');
INSERT INTO `s_user` VALUES ('38', 'renyy', 'renyy', 'fe30b260f79c0173ebb4453dd8fbd0ad', '0', '可用', '2016-08-24 17:10:01', 'lj@lkj.com', '000.jpg');
INSERT INTO `s_user` VALUES ('39', 'tangshilong', '汤士龙', '6e19e74d4e09efb05ef5e05a6045939d', '1', '可用', '2016-08-25 11:57:15', '834848102@qq.com', '624aab9b-cf6d-4c75-9509-ceaf6e1f7a5a.jpg?imageView2/2/w/100/h/100/interlace/0/q/50');
INSERT INTO `s_user` VALUES ('40', 'tangshilong1', '汤士龙', '1848a5e63e583351c8100e77291413ad', '0', '', '2016-11-07 15:37:35.752', '834848102@qq.com', '90b4e946-de44-49b2-af3c-c395e8c9457a.jpg?imageView2/2/w/100/h/100/interlace/0/q/50');
