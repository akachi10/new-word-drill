/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : word_drill

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2020-10-29 23:07:28
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
  `memory_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_lethe_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_memory_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `lethe_count` int(11) unsigned zerofill DEFAULT NULL,
  `success_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`word`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of new_word
-- ----------------------------
INSERT INTO `new_word` VALUES ('book', null, '书', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:48:59', '00000000000', '1');
INSERT INTO `new_word` VALUES ('car', null, '小汽车', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:50:23', '00000000000', '1');
INSERT INTO `new_word` VALUES ('cloakroom', null, '衣帽间、斗篷间', '2020-10-29 23:00:02', '2020-10-29 23:00:02', '2020-10-29 23:00:02', '00000000000', '0');
INSERT INTO `new_word` VALUES ('coat', null, '上衣', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:48:33', '00000000000', '1');
INSERT INTO `new_word` VALUES ('daughter', null, '女儿', '2020-10-29 23:02:05', '2020-10-29 23:02:05', '2020-10-29 23:02:05', '00000000000', '0');
INSERT INTO `new_word` VALUES ('dress', null, '连衣裙', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:48:44', '00000000000', '1');
INSERT INTO `new_word` VALUES ('excuse', '', '原谅、打扰了', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:49:16', '00000000000', '2');
INSERT INTO `new_word` VALUES ('five', null, '五', '2020-10-29 22:56:32', '2020-10-29 22:56:32', '2020-10-29 22:56:32', '00000000000', '0');
INSERT INTO `new_word` VALUES ('handbag', '', '(女用)手提包', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:48:56', '00000000000', '2');
INSERT INTO `new_word` VALUES ('house', null, '房子', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:49:50', '00000000000', '1');
INSERT INTO `new_word` VALUES ('is', '', '动词现在时第三人称单数', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:50:29', '00000000000', '2');
INSERT INTO `new_word` VALUES ('it', '', '它', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:48:57', '00000000000', '2');
INSERT INTO `new_word` VALUES ('me', '', '我(宾格)', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:47:51', '00000000000', '2');
INSERT INTO `new_word` VALUES ('my', null, '我的', '2020-10-29 22:57:55', '2020-10-29 22:57:55', '2020-10-29 22:57:55', '00000000000', '0');
INSERT INTO `new_word` VALUES ('number', null, '号码', '2020-10-29 22:55:47', '2020-10-29 22:55:47', '2020-10-29 22:55:47', '00000000000', '0');
INSERT INTO `new_word` VALUES ('pardon', '', '原谅、请再说一遍', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:50:07', '00000000000', '2');
INSERT INTO `new_word` VALUES ('pen', null, '钢笔', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:48:46', '00000000000', '1');
INSERT INTO `new_word` VALUES ('pencil', null, '铅笔', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:50:02', '00000000000', '1');
INSERT INTO `new_word` VALUES ('please', null, '请', '2020-10-29 22:56:09', '2020-10-29 22:56:09', '2020-10-29 22:56:09', '00000000000', '0');
INSERT INTO `new_word` VALUES ('school', null, '学校', '2020-10-29 23:01:43', '2020-10-29 23:01:43', '2020-10-29 23:01:43', '00000000000', '0');
INSERT INTO `new_word` VALUES ('shirt', null, '衬衣', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:48:26', '00000000000', '1');
INSERT INTO `new_word` VALUES ('sir', null, '先生', '2020-10-29 22:58:04', '2020-10-29 22:58:04', '2020-10-29 22:58:04', '00000000000', '0');
INSERT INTO `new_word` VALUES ('skirt', null, '裙子', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:48:41', '00000000000', '1');
INSERT INTO `new_word` VALUES ('son', null, '儿子', '2020-10-29 23:01:10', '2020-10-29 23:01:10', '2020-10-29 23:01:10', '00000000000', '0');
INSERT INTO `new_word` VALUES ('sorry', null, '抱歉、对不起', '2020-10-29 22:57:39', '2020-10-29 22:57:39', '2020-10-29 22:57:39', '00000000000', '0');
INSERT INTO `new_word` VALUES ('suit', null, '套装、一套衣服', '2020-10-29 23:00:41', '2020-10-29 23:00:41', '2020-10-29 23:00:41', '00000000000', '0');
INSERT INTO `new_word` VALUES ('teacher', null, '老师', '2020-10-29 23:02:49', '2020-10-29 23:02:49', '2020-10-29 23:02:49', '00000000000', '0');
INSERT INTO `new_word` VALUES ('thank', '', '感谢你', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:47:46', '00000000000', '2');
INSERT INTO `new_word` VALUES ('this', '', '这', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:49:20', '00000000000', '2');
INSERT INTO `new_word` VALUES ('ticket', null, '票', '2020-10-29 22:59:04', '2020-10-29 22:59:04', '2020-10-29 22:59:04', '00000000000', '0');
INSERT INTO `new_word` VALUES ('umbrella', null, '伞', '2020-10-29 22:55:32', '2020-10-29 22:55:32', '2020-10-29 22:55:32', '00000000000', '0');
INSERT INTO `new_word` VALUES ('very_much', '', '非常的', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:47:41', '00000000000', '2');
INSERT INTO `new_word` VALUES ('watch', null, '手表、注意、观察、值班', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:47:55', '00000000000', '1');
INSERT INTO `new_word` VALUES ('yes', '', '是的、对的', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:47:49', '00000000000', '2');
INSERT INTO `new_word` VALUES ('your', '', '你的', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-29 22:50:22', '00000000000', '2');
