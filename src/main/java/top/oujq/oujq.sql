/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : oujq

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-07-15 18:03:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('6', '蝴蝶蓝');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `content` mediumtext,
  `author_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`blog_id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('13', 'save测试', '务要成功', null);
INSERT INTO `blog` VALUES ('4', '标题2', '内容2', '6');
INSERT INTO `blog` VALUES ('12', '标题2', '内容3', '6');
INSERT INTO `blog` VALUES ('14', 'save测试', '务要成功', null);
INSERT INTO `blog` VALUES ('15', '测试0.6435492541667672', '务要成功', null);
INSERT INTO `blog` VALUES ('16', '测试0.23716765048059674', '务要成功', null);
INSERT INTO `blog` VALUES ('17', '测试0.2350582624312607', '务要成功', null);
INSERT INTO `blog` VALUES ('18', '测试0.4390106724624082', '务要成功', null);
INSERT INTO `blog` VALUES ('19', '测试0.15998053113846977', '务要成功', null);
INSERT INTO `blog` VALUES ('20', '测试0.601503906386314', '务要成功', null);
INSERT INTO `blog` VALUES ('21', '测试0.5466873904851886', '务要成功', '6');
INSERT INTO `blog` VALUES ('24', '测试0.5030257636164039', '务要成功', '6');
INSERT INTO `blog` VALUES ('27', '测试0.5648984094334402', '务要成功', '6');

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  KEY `category` (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES ('9', '4', '1');
INSERT INTO `blog_category` VALUES ('22', '21', '1');
INSERT INTO `blog_category` VALUES ('23', '21', '8');
INSERT INTO `blog_category` VALUES ('25', '24', '1');
INSERT INTO `blog_category` VALUES ('26', '24', '8');
INSERT INTO `blog_category` VALUES ('28', '27', '8');
INSERT INTO `blog_category` VALUES ('29', '27', '1');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('8', 'Java');
INSERT INTO `category` VALUES ('1', 'Vue');
INSERT INTO `category` VALUES ('10', 'JavaScript');
INSERT INTO `category` VALUES ('11', 'jQuery');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('33');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', '28', 'liubei');
INSERT INTO `user` VALUES ('1', '0', '28');
