/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : web

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2016-08-25 09:31:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `MENU_ID` varchar(40) NOT NULL default '' COMMENT '菜单ID',
  `MENU_NAME` varchar(50) default NULL COMMENT '菜单名称',
  `PARENT_ID` varchar(40) default '' COMMENT '上级菜单ID',
  `MENU_URL` varchar(50) default NULL COMMENT '菜单URL',
  `ORDER_NO` int(20) default NULL COMMENT '排序号',
  `PERMITION` int(10) NOT NULL COMMENT '菜单的访问权限 0：普通用户 1：管理员',
  PRIMARY KEY  (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='èœå•';

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES ('0e194817-bb35-1034-b7aa-d1fa71470f76', '娱乐', '0', '无', '1', '1');
INSERT INTO `s_menu` VALUES ('1000', '系统管理', '0', 'none', '1000', '1');
INSERT INTO `s_menu` VALUES ('1200', '菜单管理', '1000', '/Menu.html', '1200', '1');
INSERT INTO `s_menu` VALUES ('1600', '用户管理', '1000', '/User.html', '1400', '1');
INSERT INTO `s_menu` VALUES ('2e55fe71-bb35-1034-b7aa-d1fa71470f76', '网络音乐', '0e194817-bb35-1034-b7aa-d1fa71470f76', '/Music.html', '1', '1');

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id` int(5) NOT NULL COMMENT '角色标志位(0位普通用户,1位管理员)',
  `roleName` varchar(50) NOT NULL COMMENT '用户角色名称',
  PRIMARY KEY  (`id`)
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
  `id` int(20) NOT NULL auto_increment COMMENT '主键 id',
  `accountNumber` char(20) NOT NULL COMMENT '账号',
  `nickName` varchar(40) NOT NULL default '' COMMENT '昵称',
  `password` char(40) NOT NULL default '' COMMENT '密码',
  `role` int(2) NOT NULL default '0' COMMENT '用户类型：1 admin 0 普通用户',
  `enable` char(10) NOT NULL default '' COMMENT '账户是否可用 是  “可用”  否 “禁用”',
  `createDate` varchar(40) NOT NULL COMMENT '创建时间',
  `e_mail` char(100) default '',
  `image` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'admin', '管理员', 'ce93dc0787c6ba2db2feaac461cc13fa', '1', '可用', '2016-08-09', 'baijw12@lzu.edu.cn', '598bc9db-97e0-40e4-bf0d-5a11a6c27933.jpg');
INSERT INTO `s_user` VALUES ('37', 'baijw', '白江伟', 'fe30b260f79c0173ebb4453dd8fbd0ad', '1', '可用', '2016-08-24 11:30:05', 'baijw12@lzu.edu.cn', 'daae7230-a071-49fb-bf28-a2b29eb60667.jpg?imageView2/2/w/100/h/100/interlace/0/q/50');
INSERT INTO `s_user` VALUES ('38', 'renyy', 'renyy', 'fe30b260f79c0173ebb4453dd8fbd0ad', '0', '可用', '2016-08-24 17:10:01', 'lj@lkj.com', '000.jpg');
