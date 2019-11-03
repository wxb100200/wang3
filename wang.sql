/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50637
Source Host           : 127.0.0.1:3306
Source Database       : wang

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2019-11-04 07:22:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bas_test
-- ----------------------------
DROP TABLE IF EXISTS `bas_test`;
CREATE TABLE `bas_test` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bas_test
-- ----------------------------
INSERT INTO `bas_test` VALUES ('1', 'wang', '123456', 'wang@163.com');
INSERT INTO `bas_test` VALUES ('2', 'wang1', '123456', 'wang1@163.com');
INSERT INTO `bas_test` VALUES ('3', 'wang2', '123456', 'wang2@163.com');
INSERT INTO `bas_test` VALUES ('4', 'wang3', '123456', 'wang3@163.com');
INSERT INTO `bas_test` VALUES ('5', 'wang4', '123456', 'wang4@163.com');
INSERT INTO `bas_test` VALUES ('6', 'wang5', '123456', 'wang5@163.com');
INSERT INTO `bas_test` VALUES ('7', 'wang6', '123456', 'wang6@163.com');
INSERT INTO `bas_test` VALUES ('8', 'wang7', '123456', 'wang7@163.com');
INSERT INTO `bas_test` VALUES ('9', 'wang8', '123456', 'wang8@163.com');
INSERT INTO `bas_test` VALUES ('10', 'wang9', '123456', 'wang9@163.com');
INSERT INTO `bas_test` VALUES ('11', 'wang10', '123456', 'wang10@163.com');
INSERT INTO `bas_test` VALUES ('12', 'wang11', '123456', 'wang11@163.com');
INSERT INTO `bas_test` VALUES ('13', 'wang12', '123456', 'wang12@163.com');
INSERT INTO `bas_test` VALUES ('14', 'wang13', '123456', 'wang13@163.com');
INSERT INTO `bas_test` VALUES ('15', 'wang14', '123456', 'wang14@163.com');
INSERT INTO `bas_test` VALUES ('16', 'wang15', '123456', 'wang15@163.com');
INSERT INTO `bas_test` VALUES ('17', 'wang16', '123456', 'wang16@163.com');
INSERT INTO `bas_test` VALUES ('18', 'wang17', '123456', 'wang17@163.com');
INSERT INTO `bas_test` VALUES ('19', 'wang18', '123456', 'wang18@163.com');
INSERT INTO `bas_test` VALUES ('20', 'wang19', '123456', 'wang19@163.com');
INSERT INTO `bas_test` VALUES ('21', 'wang20', '123456', 'wang20@163.com');
INSERT INTO `bas_test` VALUES ('22', 'wang21', '123456', 'wang21@163.com');
INSERT INTO `bas_test` VALUES ('23', 'wang22', '123456', 'wang22@163.com');
INSERT INTO `bas_test` VALUES ('24', 'wang23', '123456', 'wang23@163.com');
INSERT INTO `bas_test` VALUES ('25', 'wang24', '123456', 'wang24@163.com');
INSERT INTO `bas_test` VALUES ('26', 'wang25', '123456', 'wang25@163.com');
INSERT INTO `bas_test` VALUES ('27', 'wang26', '123456', 'wang26@163.com');
INSERT INTO `bas_test` VALUES ('28', 'wang27', '123456', 'wang27@163.com');
INSERT INTO `bas_test` VALUES ('29', 'wang28', '123456', 'wang28@163.com');
INSERT INTO `bas_test` VALUES ('30', 'wang29', '123456', 'wang29@163.com');
INSERT INTO `bas_test` VALUES ('31', 'wang30', '123456', 'wang30@163.com');
INSERT INTO `bas_test` VALUES ('32', 'wang31', '123456', 'wang31@163.com');
INSERT INTO `bas_test` VALUES ('33', 'wang32', '123456', 'wang32@163.com');
INSERT INTO `bas_test` VALUES ('34', 'wang33', '123456', 'wang33@163.com');
INSERT INTO `bas_test` VALUES ('35', 'wang34', '123456', 'wang34@163.com');
INSERT INTO `bas_test` VALUES ('36', 'wang35', '123456', 'wang35@163.com');
INSERT INTO `bas_test` VALUES ('37', 'wang36', '123456', 'wang36@163.com');
INSERT INTO `bas_test` VALUES ('38', 'wang37', '123456', 'wang37@163.com');
INSERT INTO `bas_test` VALUES ('39', 'wang38', '123456', 'wang38@163.com');
INSERT INTO `bas_test` VALUES ('40', 'wang39', '123456', 'wang39@163.com');
INSERT INTO `bas_test` VALUES ('41', 'wang40', '123456', 'wang40@163.com');
INSERT INTO `bas_test` VALUES ('42', 'wang41', '123456', 'wang41@163.com');
INSERT INTO `bas_test` VALUES ('43', 'wang42', '123456', 'wang42@163.com');
INSERT INTO `bas_test` VALUES ('44', 'wang43', '123456', 'wang43@163.com');
INSERT INTO `bas_test` VALUES ('45', 'wang44', '123456', 'wang44@163.com');
INSERT INTO `bas_test` VALUES ('46', 'wang45', '123456', 'wang45@163.com');
INSERT INTO `bas_test` VALUES ('47', 'wang46', '123456', 'wang46@163.com');
INSERT INTO `bas_test` VALUES ('48', 'wang47', '123456', 'wang47@163.com');
INSERT INTO `bas_test` VALUES ('49', 'wang48', '123456', 'wang48@163.com');
INSERT INTO `bas_test` VALUES ('50', 'wang49', '123456', 'wang49@163.com');
INSERT INTO `bas_test` VALUES ('51', 'wang50', '123456', 'wang50@163.com');
INSERT INTO `bas_test` VALUES ('52', 'wang51', '123456', 'wang51@163.com');
INSERT INTO `bas_test` VALUES ('53', 'wang52', '123456', 'wang52@163.com');
INSERT INTO `bas_test` VALUES ('54', 'wang53', '123456', 'wang53@163.com');
INSERT INTO `bas_test` VALUES ('55', 'wang54', '123456', 'wang54@163.com');
INSERT INTO `bas_test` VALUES ('56', 'wang55', '123456', 'wang55@163.com');
INSERT INTO `bas_test` VALUES ('57', 'wang56', '123456', 'wang56@163.com');
INSERT INTO `bas_test` VALUES ('58', 'wang57', '123456', 'wang57@163.com');
INSERT INTO `bas_test` VALUES ('59', 'wang58', '123456', 'wang58@163.com');
INSERT INTO `bas_test` VALUES ('60', 'wang59', '123456', 'wang59@163.com');
INSERT INTO `bas_test` VALUES ('61', 'wang60', '123456', 'wang60@163.com');
INSERT INTO `bas_test` VALUES ('62', 'wang61', '123456', 'wang61@163.com');
INSERT INTO `bas_test` VALUES ('63', 'wang62', '123456', 'wang62@163.com');
INSERT INTO `bas_test` VALUES ('64', 'wang63', '123456', 'wang63@163.com');
INSERT INTO `bas_test` VALUES ('65', 'wang64', '123456', 'wang64@163.com');
INSERT INTO `bas_test` VALUES ('66', 'wang65', '123456', 'wang65@163.com');
INSERT INTO `bas_test` VALUES ('67', 'wang66', '123456', 'wang66@163.com');
INSERT INTO `bas_test` VALUES ('68', 'wang67', '123456', 'wang67@163.com');
INSERT INTO `bas_test` VALUES ('69', 'wang68', '123456', 'wang68@163.com');
INSERT INTO `bas_test` VALUES ('70', 'wang69', '123456', 'wang69@163.com');
INSERT INTO `bas_test` VALUES ('71', 'wang70', '123456', 'wang70@163.com');
INSERT INTO `bas_test` VALUES ('72', 'wang71', '123456', 'wang71@163.com');
INSERT INTO `bas_test` VALUES ('73', 'wang72', '123456', 'wang72@163.com');
INSERT INTO `bas_test` VALUES ('74', 'wang73', '123456', 'wang73@163.com');
INSERT INTO `bas_test` VALUES ('75', 'wang74', '123456', 'wang74@163.com');
INSERT INTO `bas_test` VALUES ('76', 'wang75', '123456', 'wang75@163.com');
INSERT INTO `bas_test` VALUES ('77', 'wang76', '123456', 'wang76@163.com');
INSERT INTO `bas_test` VALUES ('78', 'wang77', '123456', 'wang77@163.com');
INSERT INTO `bas_test` VALUES ('79', 'wang78', '123456', 'wang78@163.com');
INSERT INTO `bas_test` VALUES ('80', 'wang79', '123456', 'wang79@163.com');
INSERT INTO `bas_test` VALUES ('81', 'wang80', '123456', 'wang80@163.com');
INSERT INTO `bas_test` VALUES ('82', 'wang81', '123456', 'wang81@163.com');
INSERT INTO `bas_test` VALUES ('83', 'wang82', '123456', 'wang82@163.com');
INSERT INTO `bas_test` VALUES ('84', 'wang83', '123456', 'wang83@163.com');
INSERT INTO `bas_test` VALUES ('85', 'wang84', '123456', 'wang84@163.com');
INSERT INTO `bas_test` VALUES ('86', 'wang85', '123456', 'wang85@163.com');
INSERT INTO `bas_test` VALUES ('87', 'wang86', '123456', 'wang86@163.com');
INSERT INTO `bas_test` VALUES ('88', 'wang87', '123456', 'wang87@163.com');
INSERT INTO `bas_test` VALUES ('89', 'wang88', '123456', 'wang88@163.com');
INSERT INTO `bas_test` VALUES ('90', 'wang89', '123456', 'wang89@163.com');
INSERT INTO `bas_test` VALUES ('91', 'wang90', '123456', 'wang90@163.com');
INSERT INTO `bas_test` VALUES ('92', 'wang91', '123456', 'wang91@163.com');
INSERT INTO `bas_test` VALUES ('93', 'wang92', '123456', 'wang92@163.com');
INSERT INTO `bas_test` VALUES ('94', 'wang93', '123456', 'wang93@163.com');
INSERT INTO `bas_test` VALUES ('95', 'wang94', '123456', 'wang94@163.com');
INSERT INTO `bas_test` VALUES ('96', 'wang95', '123456', 'wang95@163.com');
INSERT INTO `bas_test` VALUES ('97', 'wang96', '123456', 'wang96@163.com');
INSERT INTO `bas_test` VALUES ('98', 'wang97', '123456', 'wang97@163.com');
INSERT INTO `bas_test` VALUES ('99', 'wang98', '123456', 'wang98@163.com');
INSERT INTO `bas_test` VALUES ('100', 'wang99', '123456', 'wang99@163.com');
INSERT INTO `bas_test` VALUES ('101', 'wang100', '123456', 'wang100@163.com');
INSERT INTO `bas_test` VALUES ('102', 'wang101', '123456', 'wang101@163.com');
INSERT INTO `bas_test` VALUES ('103', 'wang102', '123456', 'wang102@163.com');
INSERT INTO `bas_test` VALUES ('104', 'wang103', '123456', 'wang103@163.com');
INSERT INTO `bas_test` VALUES ('105', 'wang104', '123456', 'wang104@163.com');
INSERT INTO `bas_test` VALUES ('106', 'wang105', '123456', 'wang105@163.com');
INSERT INTO `bas_test` VALUES ('107', 'wang106', '123456', 'wang106@163.com');
INSERT INTO `bas_test` VALUES ('108', 'wang107', '123456', 'wang107@163.com');
INSERT INTO `bas_test` VALUES ('109', 'wang108', '123456', 'wang108@163.com');
INSERT INTO `bas_test` VALUES ('110', 'wang109', '123456', 'wang109@163.com');
INSERT INTO `bas_test` VALUES ('111', 'wang110', '123456', 'wang110@163.com');
INSERT INTO `bas_test` VALUES ('112', 'wang111', '123456', 'wang111@163.com');
INSERT INTO `bas_test` VALUES ('113', 'wang112', '123456', 'wang112@163.com');
INSERT INTO `bas_test` VALUES ('114', 'wang113', '123456', 'wang113@163.com');
INSERT INTO `bas_test` VALUES ('115', 'wang114', '123456', 'wang114@163.com');
INSERT INTO `bas_test` VALUES ('116', 'wang115', '123456', 'wang115@163.com');
INSERT INTO `bas_test` VALUES ('117', 'wang116', '123456', 'wang116@163.com');
INSERT INTO `bas_test` VALUES ('118', 'wang117', '123456', 'wang117@163.com');
INSERT INTO `bas_test` VALUES ('119', 'wang118', '123456', 'wang118@163.com');
INSERT INTO `bas_test` VALUES ('120', 'wang119', '123456', 'wang119@163.com');
INSERT INTO `bas_test` VALUES ('121', 'wang120', '123456', 'wang120@163.com');
INSERT INTO `bas_test` VALUES ('122', 'wang121', '123456', 'wang121@163.com');
INSERT INTO `bas_test` VALUES ('123', 'wang122', '123456', 'wang122@163.com');
INSERT INTO `bas_test` VALUES ('124', 'wang123', '123456', 'wang123@163.com');
INSERT INTO `bas_test` VALUES ('125', 'wang124', '123456', 'wang124@163.com');
INSERT INTO `bas_test` VALUES ('126', 'wang125', '123456', 'wang125@163.com');

-- ----------------------------
-- Table structure for config_param
-- ----------------------------
DROP TABLE IF EXISTS `config_param`;
CREATE TABLE `config_param` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `code` varchar(100) DEFAULT NULL COMMENT '编码',
  `value` varchar(255) DEFAULT NULL COMMENT '值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统参数配置表';

-- ----------------------------
-- Records of config_param
-- ----------------------------
INSERT INTO `config_param` VALUES ('1', '应用环境', 'environment', 'dev', '开发环境', '2019-10-05 10:41:16');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'role_admin');
INSERT INTO `sys_role` VALUES ('2', 'role_user');

-- ----------------------------
-- Table structure for sys_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_token`;
CREATE TABLE `sys_token` (
  `id` varchar(100) DEFAULT NULL COMMENT 'uuid值',
  `value` text COMMENT '值',
  `expire_time` datetime DEFAULT NULL COMMENT '有效时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `change_time` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统令牌表';

-- ----------------------------
-- Records of sys_token
-- ----------------------------
INSERT INTO `sys_token` VALUES ('934036af-349b-44be-bec5-eff708ee5b1d', '{\"id\":2,\"username\":null,\"password\":\"123456\",\"realName\":\"小明\",\"mobile\":\"17747470011\",\"status\":1,\"lastLoginTime\":null,\"createTime\":1571148626000,\"changeTime\":1571148629000,\"token\":\"934036af-349b-44be-bec5-eff708ee5b1d\",\"loginTime\":1572655111802,\"expireTime\":1572662311802}', '2019-11-01 10:38:32', '2019-11-02 08:38:32', null);
INSERT INTO `sys_token` VALUES ('57b80235-bc8c-4ab3-9ac1-679dbf546cf4', '{\"id\":2,\"username\":null,\"password\":\"123456\",\"realName\":\"小明\",\"mobile\":\"17747470011\",\"status\":1,\"lastLoginTime\":null,\"createTime\":1571148626000,\"changeTime\":1571148629000,\"token\":\"57b80235-bc8c-4ab3-9ac1-679dbf546cf4\",\"loginTime\":1572659909625,\"expireTime\":1572667109625}', '2019-11-02 11:58:30', '2019-11-02 09:58:30', null);
INSERT INTO `sys_token` VALUES ('0e2ce1cc-7bfe-469e-8653-b74f907c0b8e', '{\"id\":2,\"username\":null,\"password\":\"123456\",\"realName\":\"小明\",\"mobile\":\"17747470011\",\"status\":1,\"lastLoginTime\":null,\"createTime\":1571148626000,\"changeTime\":1571148629000,\"authorities\":null,\"enabled\":false,\"credentialsNonExpired\":false,\"accountNonLocked\":false,\"accountNonExpired\":false}', '2019-11-02 12:18:59', '2019-11-02 10:18:59', null);
INSERT INTO `sys_token` VALUES ('c58ae30d-e14f-4ea5-9c64-e0faebd1533b', '{\"id\":2,\"username\":null,\"password\":\"123456\",\"realName\":\"小明\",\"mobile\":\"17747470011\",\"status\":1,\"lastLoginTime\":null,\"createTime\":1571148626000,\"changeTime\":1571148629000,\"enabled\":false,\"credentialsNonExpired\":false,\"accountNonLocked\":false,\"accountNonExpired\":false,\"authorities\":null}', '2019-11-02 19:22:27', '2019-11-02 17:22:27', null);
INSERT INTO `sys_token` VALUES ('04f1410b-28f3-4a25-a3be-6633712520ab', '{\"accountNonExpired\":false,\"accountNonLocked\":false,\"changeTime\":1571148629000,\"createTime\":1571148626000,\"credentialsNonExpired\":false,\"enabled\":false,\"id\":2,\"mobile\":\"17747470011\",\"password\":\"123456\",\"realName\":\"小明\",\"status\":1}', '2019-11-02 22:20:12', '2019-11-02 20:20:12', null);
INSERT INTO `sys_token` VALUES ('f052bc9a-d8f1-4971-9ca9-9e0f6c6986d8', '{\"accountNonExpired\":false,\"accountNonLocked\":false,\"changeTime\":1571148629000,\"createTime\":1571148626000,\"credentialsNonExpired\":false,\"enabled\":false,\"id\":2,\"mobile\":\"17747470011\",\"password\":\"123456\",\"realName\":\"小明\",\"status\":1}', '2019-11-02 22:29:58', '2019-11-02 20:29:58', null);
INSERT INTO `sys_token` VALUES ('037c85dc-e5d2-4a6a-b381-6877b8af44ba', '{\"accountNonExpired\":false,\"accountNonLocked\":false,\"changeTime\":1571148629000,\"createTime\":1571148626000,\"credentialsNonExpired\":false,\"enabled\":false,\"id\":2,\"mobile\":\"17747470011\",\"password\":\"123456\",\"realName\":\"小明\",\"status\":1}', '2019-11-03 01:28:23', '2019-11-02 23:28:23', null);
INSERT INTO `sys_token` VALUES ('2274a04c-98d2-4f6b-bd7b-0a387c339ae2', '{\"accountNonExpired\":false,\"accountNonLocked\":false,\"changeTime\":1571148629000,\"createTime\":1571148626000,\"credentialsNonExpired\":false,\"enabled\":false,\"id\":2,\"mobile\":\"17747470011\",\"password\":\"123456\",\"realName\":\"小明\",\"status\":1}', '2019-11-03 01:54:00', '2019-11-02 23:54:00', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(10) DEFAULT NULL COMMENT '盐',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `status` int(1) DEFAULT NULL COMMENT '账号状态：0、禁用，1、启用',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间(当为空表示第一次登录，提示修改密码)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `change_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', null, '争鸣', '17747470010', '1', null, '2019-10-15 22:09:27', '2019-10-15 22:09:31');
INSERT INTO `sys_user` VALUES ('2', 'user', '123456', null, '小明', '17747470011', '1', null, '2019-10-15 22:10:26', '2019-10-15 22:10:29');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `role_id` int(10) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2');
