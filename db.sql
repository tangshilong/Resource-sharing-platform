/*
SQLyog Enterprise - MySQL GUI v7.0 Beta 1
MySQL - 5.0.22-community-nt : Database - web
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`web` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `web`;

/*Table structure for table `s_menu` */

DROP TABLE IF EXISTS `s_menu`;

CREATE TABLE `s_menu` (
  `MENU_ID` varchar(40) NOT NULL default '' COMMENT '菜单ID',
  `MENU_NAME` varchar(50) default NULL COMMENT '菜单名称',
  `PARENT_ID` varchar(40) default '' COMMENT '上级菜单ID',
  `MENU_URL` varchar(50) default NULL COMMENT '菜单URL',
  `ORDER_NO` int(20) default NULL COMMENT '排序号',
  `PERMITION` varchar(50) NOT NULL COMMENT '菜单的访问权限',
  PRIMARY KEY  (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='èœå•';

/*Data for the table `s_menu` */

insert  into `s_menu`(`MENU_ID`,`MENU_NAME`,`PARENT_ID`,`MENU_URL`,`ORDER_NO`,`PERMITION`) values ('1000','系统管理','0','none',1000,'admin'),('1100','用户管理','1000','getLogin()',1700,'admin'),('1200','菜单管理','1000','menu.html',1200,'admin'),('1300','安全拦截器管理','1000','/sys/urlfilterchain/list.do',1500,'admin'),('1500','角色管理','1000','/sys/role/list.do',1300,'admin'),('1600','字典管理','1000','/sys/dictionary/list.do',1400,'admin'),('7f68d8c4-c5ff-4221-a534-ca6456bf4eec','正则表达式','10001','exp.do',3,'admin'),('7f68d8c4-c5ff-4221-a534-ca645ebf4eec','个人中心','0','none',1,'admin'),('a6cdf4de-0b20-480c-a443-f89217dedec2','配置管理','1000','/sys/config/list.do	',1600,'admin'),('cb3ccfd6-9f39-42ef-8241-127329cebc0b','酒店号','0','list.do',1,'admin'),('f312ae4d-06c5-42c3-94ee-a5831bf25801','设备类型表','0','dev_list.do',2,'admin');

/*Table structure for table `s_user` */

DROP TABLE IF EXISTS `s_user`;

CREATE TABLE `s_user` (
  `id` char(40) NOT NULL default '',
  `user_name` char(40) default '',
  `password` char(100) default '',
  `role` char(50) default '',
  `enable` char(1) default '1',
  `createdate` date default NULL,
  `e_mail` char(100) default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_user` */

insert  into `s_user`(`id`,`user_name`,`password`,`role`,`enable`,`createdate`,`e_mail`) values ('admin','白江伟','ce93dc0787c6ba2db2feaac461cc13fa','admin','1','2016-06-17','baijw12@lzu.edu.cn');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
