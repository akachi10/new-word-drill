/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : word_drill

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2020-11-07 21:33:42
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
  PRIMARY KEY (`word`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of new_word
-- ----------------------------
INSERT INTO `new_word` VALUES ('airhostss', null, '空姐', '2020-11-01 21:08:14', '2020-11-01 21:08:14', '2020-11-07 15:54:01', '00000000000', '4', '2020-11-01 21:08:14');
INSERT INTO `new_word` VALUES ('am', null, '第一人称单数用的动词现在时', '2020-11-01 19:29:38', '2020-11-01 19:29:38', '2020-11-07 15:57:39', '00000000000', '4', '2020-11-01 19:29:38');
INSERT INTO `new_word` VALUES ('American', null, '美国的', '2020-10-31 21:50:57', '2020-10-31 21:50:57', '2020-11-07 15:56:06', '00000000000', '4', '2020-10-31 21:50:57');
INSERT INTO `new_word` VALUES ('are', null, '动词现在时复数 对you时用的', '2020-11-01 19:28:46', '2020-11-01 19:28:46', '2020-11-07 15:58:58', '00000000000', '4', '2020-11-01 19:28:46');
INSERT INTO `new_word` VALUES ('ask', null, '请求、征求、求见', '2020-11-05 22:15:53', '2020-11-05 22:15:53', '2020-11-07 15:49:21', '00000000000', '1', '2020-11-05 22:15:53');
INSERT INTO `new_word` VALUES ('blue', null, '蓝色', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:54:15', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('book', null, '书', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:32:13', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('busy', null, '忙的', '2020-11-03 23:29:55', '2020-11-03 23:29:55', '2020-11-07 15:51:35', '00000000000', '3', '2020-11-03 23:29:55');
INSERT INTO `new_word` VALUES ('car', null, '小汽车', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:32:55', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('Chinese', null, '中国人', '2020-10-31 18:24:41', '2020-10-31 18:24:41', '2020-11-07 16:02:00', '00000000000', '4', '2020-10-31 18:24:41');
INSERT INTO `new_word` VALUES ('clean', null, '干净的', '2020-11-03 23:31:16', '2020-11-03 23:31:16', '2020-11-07 16:01:57', '00000000000', '3', '2020-11-03 23:31:16');
INSERT INTO `new_word` VALUES ('cloakroom', null, '衣帽间、斗篷间', '2020-10-29 23:00:02', '2020-10-29 23:00:02', '2020-11-04 00:48:04', '00000000000', '4', '2020-10-29 23:00:02');
INSERT INTO `new_word` VALUES ('coat', null, '上衣', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:31:38', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('cold', null, '冷的', '2020-11-03 23:29:25', '2020-11-03 23:29:25', '2020-11-07 15:57:53', '00000000000', '3', '2020-11-03 23:29:25');
INSERT INTO `new_word` VALUES ('Daewoo', null, '大宇', '2020-10-31 21:57:03', '2020-10-31 21:57:03', '2020-11-07 15:51:26', '00000000000', '4', '2020-10-31 21:57:03');
INSERT INTO `new_word` VALUES ('daughter', null, '女儿', '2020-10-29 23:02:05', '2020-10-29 23:02:05', '2020-11-04 00:50:33', '00000000000', '4', '2020-10-29 23:02:05');
INSERT INTO `new_word` VALUES ('Dave', null, '大卫', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:51:00', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('dirty', null, '脏的', '2020-11-03 23:31:05', '2020-11-03 23:31:05', '2020-11-07 15:49:31', '00000000000', '3', '2020-11-03 23:31:05');
INSERT INTO `new_word` VALUES ('dress', null, '连衣裙', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:34:52', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('eight', null, '8', '2020-11-05 21:36:59', '2020-11-05 21:36:59', '2020-11-07 15:50:30', '00000000000', '1', '2020-11-05 21:36:59');
INSERT INTO `new_word` VALUES ('Emma', null, '艾玛', '2020-11-03 23:48:56', '2020-11-03 23:48:56', '2020-11-07 15:50:50', '00000000000', '3', '2020-11-03 23:48:56');
INSERT INTO `new_word` VALUES ('engineer', null, '工程师', '2020-11-01 19:27:44', '2020-11-01 19:27:44', '2020-11-07 15:55:59', '00000000000', '4', '2020-11-01 19:27:44');
INSERT INTO `new_word` VALUES ('English', null, '英国的', '2020-10-31 18:27:18', '2020-10-31 18:27:18', '2020-11-07 15:54:17', '00000000000', '4', '2020-10-31 18:27:18');
INSERT INTO `new_word` VALUES ('excuse', '', '原谅、打扰了', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:33:17', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('fat', null, '胖的', '2020-11-03 23:29:03', '2020-11-03 23:29:03', '2020-11-07 15:54:45', '00000000000', '3', '2020-11-03 23:29:03');
INSERT INTO `new_word` VALUES ('father', null, '父亲', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 16:00:02', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('Fiat', null, '菲亚特', '2020-10-31 21:57:19', '2020-10-31 21:57:19', '2020-11-07 16:00:10', '00000000000', '4', '2020-10-31 21:57:19');
INSERT INTO `new_word` VALUES ('fine', null, '还行、蛮不错、也行吧、还可以', '2020-11-03 23:23:58', '2020-11-03 23:23:58', '2020-11-07 16:02:18', '00000000000', '3', '2020-11-03 23:23:58');
INSERT INTO `new_word` VALUES ('first', null, '第一个', '2020-11-05 21:51:43', '2020-11-05 21:51:43', '2020-11-07 16:00:56', '00000000000', '1', '2020-11-05 21:51:43');
INSERT INTO `new_word` VALUES ('five', null, '五', '2020-10-29 22:56:32', '2020-10-29 22:56:32', '2020-11-04 00:48:29', '00000000000', '4', '2020-10-29 22:56:32');
INSERT INTO `new_word` VALUES ('Ford', null, '福特', '2020-10-31 21:57:11', '2020-10-31 21:57:11', '2020-11-07 16:00:17', '00000000000', '4', '2020-10-31 21:57:11');
INSERT INTO `new_word` VALUES ('four', null, '4', '2020-11-05 21:36:15', '2020-11-05 21:36:15', '2020-11-07 15:58:20', '00000000000', '1', '2020-11-05 21:36:15');
INSERT INTO `new_word` VALUES ('French', null, '法国人', '2020-10-31 18:21:27', '2020-10-31 18:21:27', '2020-11-07 15:51:54', '00000000000', '4', '2020-10-31 18:21:27');
INSERT INTO `new_word` VALUES ('German', null, '德国人', '2020-10-31 18:22:27', '2020-10-31 18:22:27', '2020-11-07 16:01:31', '00000000000', '4', '2020-10-31 18:22:27');
INSERT INTO `new_word` VALUES ('gives', null, '给与(的第三人称单数)', '2020-11-05 21:47:04', '2020-11-05 21:47:04', '2020-11-07 15:58:18', '00000000000', '1', '2020-11-05 21:47:04');
INSERT INTO `new_word` VALUES ('good', null, '好的', '2020-10-31 18:19:21', '2020-10-31 18:19:21', '2020-11-07 15:52:46', '00000000000', '4', '2020-10-31 18:19:21');
INSERT INTO `new_word` VALUES ('goodbye', null, '再见', '2020-11-03 23:27:48', '2020-11-03 23:27:48', '2020-11-07 15:58:40', '00000000000', '3', '2020-11-03 23:27:48');
INSERT INTO `new_word` VALUES ('greet', null, '同…打招呼', '2020-11-05 21:53:32', '2020-11-05 21:53:32', '2020-11-07 15:53:50', '00000000000', '1', '2020-11-05 21:53:32');
INSERT INTO `new_word` VALUES ('hairdresser', null, '理发师', '2020-11-01 21:05:28', '2020-11-01 21:05:28', '2020-11-07 16:00:42', '00000000000', '4', '2020-11-01 21:05:28');
INSERT INTO `new_word` VALUES ('handbag', '', '(女用)手提包', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:33:37', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('hear', null, '听见', '2020-11-05 21:45:20', '2020-11-05 21:45:20', '2020-11-07 15:51:48', '00000000000', '1', '2020-11-05 21:45:20');
INSERT INTO `new_word` VALUES ('Helen', null, '火把、海伦', '2020-11-03 23:48:16', '2020-11-03 23:48:16', '2020-11-07 15:50:14', '00000000000', '3', '2020-11-03 23:48:16');
INSERT INTO `new_word` VALUES ('her', null, '她的、宾格她', '2020-11-05 21:31:55', '2020-11-05 21:31:55', '2020-11-07 15:54:09', '00000000000', '1', '2020-11-05 21:31:55');
INSERT INTO `new_word` VALUES ('here', null, '这里、这时、这个地点、在这。', '2020-11-05 21:55:57', '2020-11-05 21:55:57', '2020-11-07 15:54:40', '00000000000', '1', '2020-11-05 21:55:57');
INSERT INTO `new_word` VALUES ('here you are', null, '给你、注意这里', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:53:42', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('him', null, '宾格他', '2020-11-05 21:48:21', '2020-11-05 21:48:21', '2020-11-07 15:49:34', '00000000000', '1', '2020-11-05 21:48:21');
INSERT INTO `new_word` VALUES ('his', null, '他的', '2020-11-05 21:31:32', '2020-11-05 21:31:32', '2020-11-07 15:59:28', '00000000000', '1', '2020-11-05 21:31:32');
INSERT INTO `new_word` VALUES ('hot', null, '热的', '2020-11-03 23:29:18', '2020-11-03 23:29:18', '2020-11-07 15:53:52', '00000000000', '3', '2020-11-03 23:29:18');
INSERT INTO `new_word` VALUES ('house', null, '房子', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:32:02', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('housewife', null, '家庭主妇', '2020-11-01 21:08:31', '2020-11-01 21:08:31', '2020-11-07 16:00:31', '00000000000', '4', '2020-11-01 21:08:31');
INSERT INTO `new_word` VALUES ('how', null, '怎样、健康状况如何、以任何方式、到何种地步', '2020-11-03 23:26:22', '2020-11-03 23:26:22', '2020-11-07 15:56:17', '00000000000', '3', '2020-11-03 23:26:22');
INSERT INTO `new_word` VALUES ('introduces', null, '介绍、引荐', '2020-11-05 22:49:55', '2020-11-05 22:49:55', '2020-11-07 16:00:50', '00000000000', '1', '2020-11-05 22:49:55');
INSERT INTO `new_word` VALUES ('is', '', '动词现在时第三人称单数', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:33:29', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('is this umbrella,Steven\'s?', null, '这把伞是史蒂芬的吗？', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:53:03', '00000000000', '1', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('is this your watch,Sophie?', null, '这是你手表吗，索菲？', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:55:12', '00000000000', '1', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('it', '', '它', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:31:21', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('Italian', null, '意大利的', '2020-10-31 21:54:20', '2020-10-31 21:54:20', '2020-11-07 15:49:36', '00000000000', '4', '2020-10-31 21:54:20');
INSERT INTO `new_word` VALUES ('Japanese', null, '日本人', '2020-10-31 18:23:33', '2020-10-31 18:23:33', '2020-11-07 16:00:20', '00000000000', '4', '2020-10-31 18:23:33');
INSERT INTO `new_word` VALUES ('job', null, '工作', '2020-11-01 19:29:53', '2020-11-01 19:29:53', '2020-11-07 15:59:58', '00000000000', '4', '2020-11-01 19:29:53');
INSERT INTO `new_word` VALUES ('keyboard', null, '电脑键盘', '2020-11-01 19:27:26', '2020-11-01 19:27:26', '2020-11-07 15:49:43', '00000000000', '4', '2020-11-01 19:27:26');
INSERT INTO `new_word` VALUES ('Korean', null, '韩国人', '2020-10-31 18:24:19', '2020-10-31 18:24:19', '2020-11-07 15:54:44', '00000000000', '4', '2020-10-31 18:24:19');
INSERT INTO `new_word` VALUES ('lazy', null, '懒的', '2020-11-03 23:30:25', '2020-11-03 23:30:25', '2020-11-07 15:59:14', '00000000000', '3', '2020-11-03 23:30:25');
INSERT INTO `new_word` VALUES ('Lily', null, '莉莉', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:52:34', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('look at man,he\'s very fat.', null, '看那个男人，他非常胖。', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 16:01:18', '00000000000', '1', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('look at that', null, '看那个', '2020-11-03 00:04:03', '2020-11-03 00:04:03', '2020-11-07 15:50:18', '00000000000', '3', '2020-11-03 00:04:03');
INSERT INTO `new_word` VALUES ('make', null, '制造、厂商', '2020-10-31 18:26:05', '2020-10-31 18:26:05', '2020-11-07 15:58:52', '00000000000', '4', '2020-10-31 18:26:05');
INSERT INTO `new_word` VALUES ('meet', null, '遇见', '2020-10-31 18:23:10', '2020-10-31 18:23:10', '2020-11-07 15:57:35', '00000000000', '4', '2020-10-31 18:23:10');
INSERT INTO `new_word` VALUES ('Mercedes', null, '梅赛德斯奔驰', '2020-10-31 21:56:27', '2020-10-31 21:56:27', '2020-11-07 16:01:29', '00000000000', '4', '2020-10-31 21:56:27');
INSERT INTO `new_word` VALUES ('milkman', null, '送牛奶的人', '2020-11-01 21:10:09', '2020-11-01 21:10:09', '2020-11-07 15:51:59', '00000000000', '4', '2020-11-01 21:10:09');
INSERT INTO `new_word` VALUES ('Mini', null, '迷你', '2020-10-31 22:06:01', '2020-10-31 22:06:01', '2020-11-07 16:00:22', '00000000000', '4', '2020-10-31 22:06:01');
INSERT INTO `new_word` VALUES ('Miss', null, '小姐', '2020-10-31 18:20:43', '2020-10-31 18:20:43', '2020-11-07 15:50:00', '00000000000', '4', '2020-10-31 18:20:43');
INSERT INTO `new_word` VALUES ('morning', null, '早晨', '2020-10-31 18:20:18', '2020-10-31 18:20:18', '2020-11-07 15:53:55', '00000000000', '4', '2020-10-31 18:20:18');
INSERT INTO `new_word` VALUES ('mother', null, '母亲', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:55:19', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('Mr.', null, '写信时用的先生', '2020-10-31 18:19:10', '2020-10-31 18:19:10', '2020-11-07 15:49:15', '00000000000', '4', '2020-10-31 18:19:10');
INSERT INTO `new_word` VALUES ('nationality', null, '国籍', '2020-11-01 19:26:08', '2020-11-01 19:26:08', '2020-11-07 16:01:43', '00000000000', '4', '2020-11-01 19:26:08');
INSERT INTO `new_word` VALUES ('new', null, '新的', '2020-10-31 18:20:54', '2020-10-31 18:20:54', '2020-11-07 15:59:13', '00000000000', '4', '2020-10-31 18:20:54');
INSERT INTO `new_word` VALUES ('nice', null, '美好的、干得好', '2020-10-31 18:22:42', '2020-10-31 18:22:42', '2020-11-07 15:54:41', '00000000000', '4', '2020-10-31 18:22:42');
INSERT INTO `new_word` VALUES ('nine', null, '9', '2020-11-05 21:37:50', '2020-11-05 21:37:50', '2020-11-07 15:59:11', '00000000000', '1', '2020-11-05 21:37:50');
INSERT INTO `new_word` VALUES ('number', null, '号码', '2020-10-29 22:55:47', '2020-10-29 22:55:47', '2020-11-04 00:51:20', '00000000000', '4', '2020-10-29 22:55:47');
INSERT INTO `new_word` VALUES ('nurse', null, '护士', '2020-11-01 21:09:04', '2020-11-01 21:09:04', '2020-11-07 15:59:05', '00000000000', '4', '2020-11-01 21:09:04');
INSERT INTO `new_word` VALUES ('old', null, '老的', '2020-11-03 23:29:34', '2020-11-03 23:29:34', '2020-11-07 15:52:42', '00000000000', '3', '2020-11-03 23:29:34');
INSERT INTO `new_word` VALUES ('one', null, '1', '2020-11-05 21:36:07', '2020-11-05 21:36:07', '2020-11-07 15:57:09', '00000000000', '1', '2020-11-05 21:36:07');
INSERT INTO `new_word` VALUES ('operator', null, '输入者', '2020-11-01 19:26:53', '2020-11-01 19:26:53', '2020-11-07 15:55:31', '00000000000', '4', '2020-11-01 19:26:53');
INSERT INTO `new_word` VALUES ('pardon', '', '原谅、请再说一遍', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:31:20', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('Paul', null, '倒齿、保罗', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:50:11', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('pen', null, '钢笔', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:34:53', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('pencil', null, '铅笔', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:31:42', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('perhaps', null, '也许、可能、大概', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:58:49', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('Peugeot', null, '标志', '2020-10-31 21:56:09', '2020-10-31 21:56:09', '2020-11-07 16:01:48', '00000000000', '4', '2020-10-31 21:56:09');
INSERT INTO `new_word` VALUES ('please', null, '请', '2020-10-29 22:56:09', '2020-10-29 22:56:09', '2020-11-04 00:51:22', '00000000000', '4', '2020-10-29 22:56:09');
INSERT INTO `new_word` VALUES ('police', null, '警察', '2020-11-01 19:30:04', '2020-11-01 19:30:04', '2020-11-07 15:59:56', '00000000000', '4', '2020-11-01 19:30:04');
INSERT INTO `new_word` VALUES ('postman', null, '跑死他们', '2020-11-01 21:08:47', '2020-11-01 21:08:47', '2020-11-07 15:51:37', '00000000000', '4', '2020-11-01 21:08:47');
INSERT INTO `new_word` VALUES ('say', null, '讲话、讲（名词）', '2020-11-05 21:46:04', '2020-11-05 21:46:04', '2020-11-07 15:49:54', '00000000000', '1', '2020-11-05 21:46:04');
INSERT INTO `new_word` VALUES ('school', null, '学校', '2020-10-29 23:01:43', '2020-10-29 23:01:43', '2020-11-04 00:52:36', '00000000000', '4', '2020-10-29 23:01:43');
INSERT INTO `new_word` VALUES ('see', null, '见到、理解、查看', '2020-11-03 23:28:12', '2020-11-03 23:28:12', '2020-11-07 16:01:50', '00000000000', '3', '2020-11-03 23:28:12');
INSERT INTO `new_word` VALUES ('seven', null, '7', '2020-11-05 21:37:16', '2020-11-05 21:37:16', '2020-11-07 15:54:31', '00000000000', '1', '2020-11-05 21:37:16');
INSERT INTO `new_word` VALUES ('shirt', null, '衬衣', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:31:25', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('short', null, '矮的', '2020-11-03 23:30:43', '2020-11-03 23:30:43', '2020-11-07 15:54:48', '00000000000', '3', '2020-11-03 23:30:43');
INSERT INTO `new_word` VALUES ('sir', null, '先生', '2020-10-29 22:58:04', '2020-10-29 22:58:04', '2020-11-04 00:51:03', '00000000000', '4', '2020-10-29 22:58:04');
INSERT INTO `new_word` VALUES ('sister', null, '姐妹', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:52:41', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('six', null, '6', '2020-11-05 21:36:31', '2020-11-05 21:36:31', '2020-11-07 15:52:44', '00000000000', '1', '2020-11-05 21:36:31');
INSERT INTO `new_word` VALUES ('skirt', null, '裙子', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:31:40', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('some', null, '一些; 某个; 部分; 相当多的;', '2020-11-05 14:53:13', '2020-11-05 14:53:13', '2020-11-07 16:02:15', '00000000000', '1', '2020-11-05 14:53:13');
INSERT INTO `new_word` VALUES ('someone', null, '某人', '2020-11-05 21:46:48', '2020-11-05 21:46:48', '2020-11-07 15:49:49', '00000000000', '1', '2020-11-05 21:46:48');
INSERT INTO `new_word` VALUES ('something', null, '某事', '2020-11-05 21:45:51', '2020-11-05 21:45:51', '2020-11-07 15:50:26', '00000000000', '1', '2020-11-05 21:45:51');
INSERT INTO `new_word` VALUES ('son', null, '儿子', '2020-10-29 23:01:10', '2020-10-29 23:01:10', '2020-11-04 00:50:58', '00000000000', '4', '2020-10-29 23:01:10');
INSERT INTO `new_word` VALUES ('Sophie', null, '索菲', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:55:36', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('sorry', null, '抱歉、对不起', '2020-10-29 22:57:39', '2020-10-29 22:57:39', '2020-11-04 00:48:16', '00000000000', '4', '2020-10-29 22:57:39');
INSERT INTO `new_word` VALUES ('speak', null, '说话(动作)', '2020-11-05 21:51:22', '2020-11-05 21:51:22', '2020-11-07 15:57:44', '00000000000', '1', '2020-11-05 21:51:22');
INSERT INTO `new_word` VALUES ('Stella', null, '斯黛拉', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:55:41', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('Steven', null, '史蒂芬', '2020-11-03 23:48:33', '2020-11-03 23:48:33', '2020-11-07 15:54:12', '00000000000', '3', '2020-11-03 23:48:33');
INSERT INTO `new_word` VALUES ('student', null, '学生', '2020-10-31 18:21:04', '2020-11-03 09:50:51', '2020-11-07 15:52:36', '00000000000', '4', '2020-10-31 18:21:04');
INSERT INTO `new_word` VALUES ('suit', null, '套装、一套衣服', '2020-10-29 23:00:41', '2020-10-29 23:00:41', '2020-11-04 00:47:50', '00000000000', '4', '2020-10-29 23:00:41');
INSERT INTO `new_word` VALUES ('Swedish', null, '瑞典的', '2020-10-31 18:27:03', '2020-10-31 18:27:03', '2020-11-07 15:59:44', '00000000000', '4', '2020-10-31 18:27:03');
INSERT INTO `new_word` VALUES ('tall', null, '高的', '2020-11-03 23:30:35', '2020-11-03 23:30:35', '2020-11-07 16:00:35', '00000000000', '3', '2020-11-03 23:30:35');
INSERT INTO `new_word` VALUES ('taxidriver', null, '出租车司机', '2020-11-01 21:05:06', '2020-11-04 00:49:29', '2020-11-07 15:51:14', '00000000001', '4', '2020-11-01 21:05:06');
INSERT INTO `new_word` VALUES ('teacher', null, '老师', '2020-10-29 23:02:49', '2020-10-29 23:02:49', '2020-11-04 00:48:58', '00000000000', '4', '2020-10-29 23:02:49');
INSERT INTO `new_word` VALUES ('ten', null, '10', '2020-11-05 21:36:00', '2020-11-05 21:36:00', '2020-11-07 15:54:32', '00000000000', '1', '2020-11-05 21:36:00');
INSERT INTO `new_word` VALUES ('test', null, '测试', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '00000000000', '4', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('thank', '', '感谢你', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:33:05', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('thanks', null, '谢谢的复数形式', '2020-11-03 23:27:34', '2020-11-03 23:27:34', '2020-11-07 16:00:14', '00000000000', '3', '2020-11-03 23:27:34');
INSERT INTO `new_word` VALUES ('that', null, '那个', '2020-11-03 23:56:40', '2020-11-03 23:56:40', '2020-11-07 15:56:12', '00000000000', '3', '2020-11-03 23:56:40');
INSERT INTO `new_word` VALUES ('thin', null, '瘦的', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:54:28', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('thing', null, '事件，形势; 东西，事物; 家伙; 事业;', '2020-11-05 14:53:13', '2020-11-05 14:53:13', '2020-11-07 15:52:32', '00000000000', '1', '2020-11-05 14:53:13');
INSERT INTO `new_word` VALUES ('this', '', '这', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:31:54', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('three', null, '3', '2020-11-05 21:35:53', '2020-11-05 21:35:53', '2020-11-07 16:02:20', '00000000000', '1', '2020-11-05 21:35:53');
INSERT INTO `new_word` VALUES ('ticket', null, '票', '2020-10-29 22:59:04', '2020-10-29 22:59:04', '2020-11-04 00:47:37', '00000000000', '4', '2020-10-29 22:59:04');
INSERT INTO `new_word` VALUES ('Tim', null, '提姆', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:55:43', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('today', null, '今天', '2020-11-03 23:28:32', '2020-11-03 23:28:32', '2020-11-07 16:01:20', '00000000000', '3', '2020-11-03 23:28:32');
INSERT INTO `new_word` VALUES ('Tony', null, '托尼', '2020-11-03 23:48:45', '2020-11-03 23:48:45', '2020-11-07 15:59:46', '00000000000', '3', '2020-11-03 23:48:45');
INSERT INTO `new_word` VALUES ('too', null, '也、强调、太', '2020-10-31 18:25:35', '2020-10-31 18:25:35', '2020-11-07 15:53:46', '00000000000', '4', '2020-10-31 18:25:35');
INSERT INTO `new_word` VALUES ('Toyota', null, '丰田', '2020-10-31 21:56:39', '2020-10-31 21:56:39', '2020-11-07 16:01:03', '00000000000', '4', '2020-10-31 21:56:39');
INSERT INTO `new_word` VALUES ('two', null, '2', '2020-11-05 21:37:33', '2020-11-05 21:37:33', '2020-11-07 15:59:31', '00000000000', '1', '2020-11-05 21:37:33');
INSERT INTO `new_word` VALUES ('umbrella', null, '伞', '2020-10-29 22:55:32', '2020-10-29 22:55:32', '2020-11-04 00:52:42', '00000000000', '4', '2020-10-29 22:55:32');
INSERT INTO `new_word` VALUES ('very much', null, '非常的', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:34:03', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('Volvo', null, '沃尔沃', '2020-10-31 21:54:08', '2020-10-31 21:54:08', '2020-11-07 16:01:00', '00000000000', '4', '2020-10-31 21:54:08');
INSERT INTO `new_word` VALUES ('want', null, '希望', '2020-11-05 21:50:47', '2020-11-05 21:50:47', '2020-11-07 15:49:56', '00000000000', '1', '2020-11-05 21:50:47');
INSERT INTO `new_word` VALUES ('watch', null, '手表、注意、观察、值班', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:33:19', '00000000000', '5', '2020-10-26 21:43:43');
INSERT INTO `new_word` VALUES ('well', null, '好的、健康的、涌出、完全的', '2020-11-03 23:28:21', '2020-11-03 23:28:21', '2020-11-07 15:59:07', '00000000000', '3', '2020-11-03 23:28:21');
INSERT INTO `new_word` VALUES ('what', null, '什么', '2020-11-01 19:28:05', '2020-11-01 19:28:05', '2020-11-07 15:50:47', '00000000000', '4', '2020-11-01 19:28:05');
INSERT INTO `new_word` VALUES ('when', null, '时候;场合;什么时候;', '2020-11-05 22:16:19', '2020-11-05 22:16:19', '2020-11-07 15:57:27', '00000000000', '1', '2020-11-05 22:16:19');
INSERT INTO `new_word` VALUES ('which', null, '指前面提到的事物;哪一个中的“哪”', '2020-11-05 22:13:33', '2020-11-05 22:13:33', '2020-11-07 15:58:36', '00000000000', '1', '2020-11-05 22:13:33');
INSERT INTO `new_word` VALUES ('white', null, '白色', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:53:10', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('whose', null, '谁的', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 16:02:09', '00000000000', '2', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('whose shirt is that?', null, '谁的衬衣在那', '2020-11-04 15:59:10', '2020-11-04 15:59:10', '2020-11-07 15:56:39', '00000000000', '1', '2020-11-04 15:59:10');
INSERT INTO `new_word` VALUES ('woman', null, '女人', '2020-11-03 23:29:12', '2020-11-03 23:29:12', '2020-11-07 15:53:44', '00000000000', '3', '2020-11-03 23:29:12');
INSERT INTO `new_word` VALUES ('wrong', null, '错误的、不适合的', '2020-11-05 22:10:44', '2020-11-05 22:10:44', '2020-11-07 15:54:35', '00000000000', '1', '2020-11-05 22:10:44');
INSERT INTO `new_word` VALUES ('young', null, '年轻的', '2020-11-03 23:29:42', '2020-11-03 23:29:42', '2020-11-07 15:59:53', '00000000000', '3', '2020-11-03 23:29:42');
INSERT INTO `new_word` VALUES ('your', '', '你的', '2020-10-26 21:43:43', '2020-10-26 21:43:43', '2020-11-05 10:34:49', '00000000000', '5', '2020-10-26 21:43:43');

-- ----------------------------
-- View structure for v_new_word
-- ----------------------------
DROP VIEW IF EXISTS `v_new_word`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v_new_word` AS select `new_word`.`word` AS `word`,`new_word`.`phonetic_symbol` AS `phonetic_symbol`,`new_word`.`chinese` AS `chinese`,`new_word`.`memory_time` AS `memory_time`,`new_word`.`last_lethe_time` AS `last_lethe_time`,`new_word`.`last_memory_time` AS `last_memory_time`,`new_word`.`lethe_count` AS `lethe_count`,`new_word`.`success_count` AS `success_count` from `new_word` order by `new_word`.`memory_time` desc ;