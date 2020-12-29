/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : word_drill

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2020-12-01 18:06:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for new_word
-- ----------------------------
DROP TABLE IF EXISTS `new_word`;
CREATE TABLE `new_word` (
  `word` varchar(255) NOT NULL,
  `phonetic_symbol` varchar(255) DEFAULT NULL,
  `chinese` varchar(255) NOT NULL,
  `memory_time` datetime DEFAULT NULL,
  `last_lethe_time` datetime DEFAULT NULL,
  `last_memory_time` datetime DEFAULT NULL,
  `lethe_count` int(11) unsigned zerofill DEFAULT NULL,
  `success_count` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `flag` varchar(255) NOT NULL,
  PRIMARY KEY (`word`,`flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
