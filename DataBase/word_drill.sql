/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : word_drill

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2020-11-11 16:12:04
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

-- ----------------------------
-- Records of new_word
-- ----------------------------
INSERT INTO `new_word` VALUES ('airhostss', null, '空姐', '2020-11-01 21:08:14', null, '2020-11-11 15:00:12', '00000000000', '5', '2020-11-01 21:08:14', 'default');
INSERT INTO `new_word` VALUES ('all right', null, '准备好了吗？（确保对方同意或理解）如何', '2020-11-10 16:46:31', null, '2020-11-11 15:06:30', '00000000000', '1', '2020-11-10 16:46:31', 'default');
INSERT INTO `new_word` VALUES ('am', null, '第一人称单数用的动词现在时', '2020-11-01 19:29:38', null, '2020-11-11 15:03:21', '00000000000', '5', '2020-11-01 19:29:38', 'default');
INSERT INTO `new_word` VALUES ('American', null, '美国的', '2020-10-31 21:50:57', null, '2020-11-10 14:04:34', '00000000000', '5', '2020-10-31 21:50:57', 'default');
INSERT INTO `new_word` VALUES ('are', null, '动词现在时复数 对you时用的', '2020-11-01 19:28:46', null, '2020-11-11 15:00:54', '00000000000', '5', '2020-11-01 19:28:46', 'default');
INSERT INTO `new_word` VALUES ('aren\'t', null, '他们不是', '2020-11-08 22:41:03', null, '2020-11-11 14:58:00', '00000000000', '3', '2020-11-08 22:41:03', 'default');
INSERT INTO `new_word` VALUES ('ask', null, '请求、征求、求见', '2020-11-05 22:15:53', null, '2020-11-11 15:15:17', '00000000000', '4', '2020-11-05 22:15:53', 'default');
INSERT INTO `new_word` VALUES ('assist', null, '帮助', '2020-11-09 23:48:31', null, '2020-11-11 14:59:03', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('assistant', null, '助手', '2020-11-09 23:48:31', null, '2020-11-11 14:58:08', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('big', null, '大的', '2020-11-10 21:06:51', null, '2020-11-11 15:15:39', '00000000000', '1', '2020-11-10 21:06:51', 'default');
INSERT INTO `new_word` VALUES ('black', null, '黑色', '2020-11-07 23:14:10', null, '2020-11-10 14:01:56', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('blouse', null, '女衬衫', '2020-11-07 22:05:54', null, '2020-11-10 13:59:47', '00000000000', '3', '2020-11-07 22:05:54', 'default');
INSERT INTO `new_word` VALUES ('blue', null, '蓝色', '2020-11-04 15:59:10', null, '2020-11-10 14:44:08', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('book', null, '书', '2020-10-26 21:43:43', null, '2020-11-10 14:03:05', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('boy', null, '男孩', '2020-11-10 21:06:02', null, '2020-11-11 15:16:16', '00000000000', '1', '2020-11-10 21:06:02', 'default');
INSERT INTO `new_word` VALUES ('bread', null, '面包', '2020-11-09 23:48:31', null, '2020-11-11 15:08:33', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('brother', null, '兄弟', '2020-11-07 22:03:32', null, '2020-11-10 13:59:24', '00000000000', '3', '2020-11-07 22:03:32', 'default');
INSERT INTO `new_word` VALUES ('brown', null, '棕色', '2020-11-07 23:14:10', null, '2020-11-10 13:58:47', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('busy', null, '忙的', '2020-11-03 23:29:55', null, '2020-11-09 10:11:39', '00000000000', '4', '2020-11-03 23:29:55', 'default');
INSERT INTO `new_word` VALUES ('car', null, '小汽车', '2020-10-26 21:43:43', null, '2020-11-10 14:24:00', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('carpet', null, '地毯', '2020-11-07 23:14:10', null, '2020-11-10 14:00:00', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('case', null, '箱子', '2020-11-07 23:14:10', null, '2020-11-10 14:03:09', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('children', null, '孩子们', '2020-11-10 16:44:31', null, '2020-11-11 15:10:29', '00000000000', '1', '2020-11-10 16:44:31', 'default');
INSERT INTO `new_word` VALUES ('Chinese', null, '中国人', '2020-10-31 18:24:41', null, '2020-11-10 13:59:11', '00000000000', '5', '2020-10-31 18:24:41', 'default');
INSERT INTO `new_word` VALUES ('Claire Taylor', null, '克莱尔·泰勒', '2020-11-09 23:46:11', null, '2020-11-11 14:59:28', '00000000000', '2', '2020-11-09 23:46:11', 'default');
INSERT INTO `new_word` VALUES ('clean', null, '干净的', '2020-11-03 23:31:16', null, '2020-11-09 10:13:59', '00000000000', '4', '2020-11-03 23:31:16', 'default');
INSERT INTO `new_word` VALUES ('cloakroom', null, '衣帽间、斗篷间', '2020-10-29 23:00:02', null, '2020-11-08 00:38:04', '00000000000', '5', '2020-10-29 23:00:02', 'default');
INSERT INTO `new_word` VALUES ('coat', null, '上衣', '2020-10-26 21:43:43', null, '2020-11-10 14:16:51', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('cold', null, '冷的', '2020-11-03 23:29:25', null, '2020-11-09 10:12:12', '00000000000', '4', '2020-11-03 23:29:25', 'default');
INSERT INTO `new_word` VALUES ('colour', null, '颜色', '2020-11-07 23:14:10', null, '2020-11-10 14:00:44', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('come', null, '来', '2020-11-07 23:14:10', null, '2020-11-10 14:25:55', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('customs', null, '海关', '2020-11-09 23:43:19', null, '2020-11-11 15:03:52', '00000000000', '2', '2020-11-09 23:43:19', 'default');
INSERT INTO `new_word` VALUES ('Daewoo', null, '大宇', '2020-10-31 21:57:03', null, '2020-11-10 14:03:49', '00000000000', '5', '2020-10-31 21:57:03', 'default');
INSERT INTO `new_word` VALUES ('Danish', null, '丹麦人', '2020-11-08 22:38:17', null, '2020-11-11 15:04:07', '00000000000', '3', '2020-11-08 22:38:17', 'default');
INSERT INTO `new_word` VALUES ('daughter', null, '女儿', '2020-10-29 23:02:05', null, '2020-11-08 00:33:44', '00000000000', '5', '2020-10-29 23:02:05', 'default');
INSERT INTO `new_word` VALUES ('Dave', null, '大卫', '2020-11-04 15:59:10', null, '2020-11-10 13:53:45', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('desk', null, '桌子', '2020-11-09 23:48:31', null, '2020-11-11 15:10:03', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('dirty', null, '脏的', '2020-11-03 23:31:05', null, '2020-11-09 10:10:52', '00000000000', '4', '2020-11-03 23:31:05', 'default');
INSERT INTO `new_word` VALUES ('dress', null, '连衣裙', '2020-10-26 21:43:43', null, '2020-11-10 13:58:40', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('Dutch', null, '荷兰人', '2020-11-08 22:42:11', null, '2020-11-11 15:16:51', '00000000000', '3', '2020-11-08 22:42:11', 'default');
INSERT INTO `new_word` VALUES ('eight', null, '8', '2020-11-05 21:36:59', null, '2020-11-11 15:15:53', '00000000000', '4', '2020-11-05 21:36:59', 'default');
INSERT INTO `new_word` VALUES ('Emma', null, '艾玛', '2020-11-03 23:48:56', null, '2020-11-09 10:12:40', '00000000000', '4', '2020-11-03 23:48:56', 'default');
INSERT INTO `new_word` VALUES ('employ', null, '雇佣', '2020-11-09 23:48:31', null, '2020-11-11 15:03:12', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('employee', null, '雇员', '2020-11-09 23:43:53', null, '2020-11-11 15:16:39', '00000000000', '2', '2020-11-09 23:43:53', 'default');
INSERT INTO `new_word` VALUES ('engineer', null, '工程师', '2020-11-01 19:27:44', null, '2020-11-11 15:06:57', '00000000000', '5', '2020-11-01 19:27:44', 'default');
INSERT INTO `new_word` VALUES ('English', null, '英国的', '2020-10-31 18:27:18', null, '2020-11-10 13:53:33', '00000000000', '5', '2020-10-31 18:27:18', 'default');
INSERT INTO `new_word` VALUES ('excuse', '', '原谅、打扰了', '2020-10-26 21:43:43', null, '2020-11-10 14:03:12', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('fat', null, '胖的', '2020-11-03 23:29:03', null, '2020-11-09 10:09:37', '00000000000', '4', '2020-11-03 23:29:03', 'default');
INSERT INTO `new_word` VALUES ('father', null, '父亲', '2020-11-04 15:59:10', null, '2020-11-10 14:00:35', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('Fiat', null, '菲亚特', '2020-10-31 21:57:19', null, '2020-11-10 13:53:19', '00000000000', '5', '2020-10-31 21:57:19', 'default');
INSERT INTO `new_word` VALUES ('fine', null, '还行、蛮不错、也行吧、还可以', '2020-11-03 23:23:58', null, '2020-11-09 10:17:00', '00000000000', '4', '2020-11-03 23:23:58', 'default');
INSERT INTO `new_word` VALUES ('first', null, '第一个', '2020-11-05 21:51:43', null, '2020-11-11 15:09:54', '00000000000', '4', '2020-11-05 21:51:43', 'default');
INSERT INTO `new_word` VALUES ('five', null, '五', '2020-10-29 22:56:32', null, '2020-11-08 00:37:16', '00000000000', '5', '2020-10-29 22:56:32', 'default');
INSERT INTO `new_word` VALUES ('Ford', null, '福特', '2020-10-31 21:57:11', null, '2020-11-10 14:42:05', '00000000000', '5', '2020-10-31 21:57:11', 'default');
INSERT INTO `new_word` VALUES ('four', null, '4', '2020-11-05 21:36:15', null, '2020-11-11 15:16:17', '00000000000', '4', '2020-11-05 21:36:15', 'default');
INSERT INTO `new_word` VALUES ('French', null, '法国人', '2020-10-31 18:21:27', null, '2020-11-10 14:03:23', '00000000000', '5', '2020-10-31 18:21:27', 'default');
INSERT INTO `new_word` VALUES ('friend', null, '朋友', '2020-11-08 22:41:38', null, '2020-11-11 15:08:59', '00000000000', '3', '2020-11-08 22:41:38', 'default');
INSERT INTO `new_word` VALUES ('German', null, '德国人', '2020-10-31 18:22:27', null, '2020-11-10 14:16:47', '00000000000', '5', '2020-10-31 18:22:27', 'default');
INSERT INTO `new_word` VALUES ('girl', null, '女孩', '2020-11-08 22:42:21', null, '2020-11-11 14:58:56', '00000000000', '3', '2020-11-08 22:42:21', 'default');
INSERT INTO `new_word` VALUES ('gives', null, '给与(的第三人称单数)', '2020-11-05 21:47:04', null, '2020-11-11 15:04:14', '00000000000', '4', '2020-11-05 21:47:04', 'default');
INSERT INTO `new_word` VALUES ('good', null, '好的', '2020-10-31 18:19:21', null, '2020-11-10 14:04:18', '00000000000', '5', '2020-10-31 18:19:21', 'default');
INSERT INTO `new_word` VALUES ('goodbye', null, '再见', '2020-11-03 23:27:48', null, '2020-11-09 10:09:40', '00000000000', '4', '2020-11-03 23:27:48', 'default');
INSERT INTO `new_word` VALUES ('grand', null, '伟大的', '2020-11-10 21:08:54', null, '2020-11-11 15:16:06', '00000000000', '1', '2020-11-10 21:08:54', 'default');
INSERT INTO `new_word` VALUES ('green', null, '绿色', '2020-11-07 23:14:10', null, '2020-11-10 13:58:19', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('greet', null, '同…打招呼', '2020-11-06 21:53:32', '2020-11-08 00:32:00', '2020-11-11 14:54:45', '00000000001', '4', '2020-11-05 21:53:32', 'default');
INSERT INTO `new_word` VALUES ('grey', null, '灰色', '2020-11-07 23:14:10', null, '2020-11-10 14:00:26', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('hairdresser', null, '理发师', '2020-11-05 21:05:28', '2020-11-11 15:11:54', '2020-11-11 15:11:54', '00000000001', '4', '2020-11-01 21:05:28', 'default');
INSERT INTO `new_word` VALUES ('handbag', '', '(女用)手提包', '2020-10-26 21:43:43', null, '2020-11-10 14:11:46', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('hard-working', null, '勤奋的', '2020-11-09 23:47:00', null, '2020-11-11 15:02:59', '00000000000', '2', '2020-11-09 23:47:00', 'default');
INSERT INTO `new_word` VALUES ('hat', null, '帽子', '2020-11-07 23:14:10', null, '2020-11-10 14:23:51', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('he', null, '他', '2020-11-11 16:04:31', null, '2020-11-11 16:04:31', '00000000000', '0', '2020-11-11 16:04:31', 'pron');
INSERT INTO `new_word` VALUES ('hear', null, '听见', '2020-11-05 21:45:20', null, '2020-11-11 14:58:46', '00000000000', '4', '2020-11-05 21:45:20', 'default');
INSERT INTO `new_word` VALUES ('heavy', null, '重的', '2020-11-10 21:07:27', null, '2020-11-11 15:04:03', '00000000000', '1', '2020-11-10 21:07:27', 'default');
INSERT INTO `new_word` VALUES ('Helen', null, '火把、海伦', '2020-11-03 23:48:16', null, '2020-11-09 10:12:07', '00000000000', '4', '2020-11-03 23:48:16', 'default');
INSERT INTO `new_word` VALUES ('her', null, '她的、宾格她', '2020-11-05 21:31:55', null, '2020-11-11 15:19:39', '00000000000', '4', '2020-11-05 21:31:55', 'default');
INSERT INTO `new_word` VALUES ('her', null, '她的、她(宾格)', '2020-11-11 16:05:24', null, '2020-11-11 16:05:24', '00000000000', '0', '2020-11-11 16:05:24', 'pron');
INSERT INTO `new_word` VALUES ('here', null, '这里、这时、这个地点、在这。', '2020-11-05 21:55:57', null, '2020-11-11 14:54:51', '00000000000', '4', '2020-11-05 21:55:57', 'default');
INSERT INTO `new_word` VALUES ('Here they are.', null, '他们在这.', '2020-11-09 20:00:17', null, '2020-11-11 15:11:21', '00000000000', '2', '2020-11-09 20:00:17', 'default');
INSERT INTO `new_word` VALUES ('Here you are.', null, '给你、注意这里', '2020-11-04 15:59:10', null, '2020-11-10 14:26:41', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('him', null, '宾格他', '2020-11-05 21:48:21', null, '2020-11-11 15:09:58', '00000000000', '4', '2020-11-05 21:48:21', 'default');
INSERT INTO `new_word` VALUES ('him', null, '他(宾格)', '2020-11-11 16:04:42', null, '2020-11-11 16:04:42', '00000000000', '0', '2020-11-11 16:04:42', 'pron');
INSERT INTO `new_word` VALUES ('his', null, '他的', '2020-11-05 21:31:32', null, '2020-11-11 15:15:15', '00000000000', '4', '2020-11-05 21:31:32', 'default');
INSERT INTO `new_word` VALUES ('his', null, '他的', '2020-11-11 16:04:51', null, '2020-11-11 16:04:51', '00000000000', '0', '2020-11-11 16:04:51', 'pron');
INSERT INTO `new_word` VALUES ('hot', null, '热的', '2020-11-03 23:29:18', null, '2020-11-09 10:12:00', '00000000000', '4', '2020-11-03 23:29:18', 'default');
INSERT INTO `new_word` VALUES ('house', null, '房子', '2020-10-26 21:43:43', null, '2020-11-10 13:58:53', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('housewife', null, '家庭主妇', '2020-11-01 21:08:31', null, '2020-11-11 15:07:02', '00000000000', '5', '2020-11-01 21:08:31', 'default');
INSERT INTO `new_word` VALUES ('how', null, '怎样、健康状况如何、以任何方式、到何种地步', '2020-11-03 23:26:22', null, '2020-11-09 10:08:12', '00000000000', '4', '2020-11-03 23:26:22', 'default');
INSERT INTO `new_word` VALUES ('hundred', null, '100', '2020-11-08 01:06:53', null, '2020-11-11 15:04:11', '00000000000', '3', '2020-11-08 01:06:53', 'default');
INSERT INTO `new_word` VALUES ('i', null, '我', '2020-11-11 16:00:46', null, '2020-11-11 16:00:46', '00000000000', '0', '2020-11-11 16:00:46', 'pron');
INSERT INTO `new_word` VALUES ('ice cream', null, '冰果', '2020-11-10 16:45:31', null, '2020-11-11 15:15:25', '00000000000', '1', '2020-11-10 16:45:31', 'default');
INSERT INTO `new_word` VALUES ('introduces', null, '介绍、引荐', '2020-11-05 22:49:55', null, '2020-11-11 14:59:37', '00000000000', '4', '2020-11-05 22:49:55', 'default');
INSERT INTO `new_word` VALUES ('is', null, '是,动词现在时第三人称单数', '2020-10-26 21:43:43', null, '2020-11-10 14:12:13', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('Is this umbrella,Steven\'s?', null, '这把伞是史蒂芬的吗？', '2020-11-04 15:59:10', null, '2020-11-10 14:02:32', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('Is this your watch,Sophie?', null, '这是你手表吗，索菲？', '2020-11-05 15:59:10', '2020-11-08 00:25:55', '2020-11-11 15:06:54', '00000000001', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('it', '', '它', '2020-10-26 21:43:43', null, '2020-11-10 13:57:23', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('it', null, '它、它(宾格)', '2020-11-11 16:09:01', null, '2020-11-11 16:09:01', '00000000000', '0', '2020-11-11 16:09:01', 'pron');
INSERT INTO `new_word` VALUES ('Italian', null, '意大利的', '2020-10-31 21:54:20', null, '2020-11-10 14:25:53', '00000000000', '5', '2020-10-31 21:54:20', 'default');
INSERT INTO `new_word` VALUES ('its', null, '它的', '2020-11-11 16:09:38', null, '2020-11-11 16:09:38', '00000000000', '0', '2020-11-11 16:09:38', 'pron');
INSERT INTO `new_word` VALUES ('Jackson', null, '杰克逊', '2020-11-09 23:44:35', null, '2020-11-11 15:01:02', '00000000000', '2', '2020-11-09 23:44:35', 'default');
INSERT INTO `new_word` VALUES ('Japanese', null, '日本人', '2020-10-31 18:23:33', null, '2020-11-10 14:11:43', '00000000000', '5', '2020-10-31 18:23:33', 'default');
INSERT INTO `new_word` VALUES ('Jeremy', null, '杰里米', '2020-11-09 23:48:31', null, '2020-11-11 14:56:38', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('Jim', null, '吉姆', '2020-11-09 23:48:31', null, '2020-11-11 15:15:27', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('job', null, '工作', '2020-11-01 19:29:53', null, '2020-11-11 14:54:37', '00000000000', '5', '2020-11-01 19:29:53', 'default');
INSERT INTO `new_word` VALUES ('keyboard', null, '电脑键盘', '2020-11-01 19:27:26', null, '2020-11-11 15:15:37', '00000000000', '5', '2020-11-01 19:27:26', 'default');
INSERT INTO `new_word` VALUES ('knife', null, '匕首', '2020-11-09 23:48:31', null, '2020-11-11 15:18:23', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('Korean', null, '韩国人', '2020-10-31 18:24:19', null, '2020-11-10 13:59:27', '00000000000', '5', '2020-10-31 18:24:19', 'default');
INSERT INTO `new_word` VALUES ('lazy', null, '懒的', '2020-11-03 23:30:25', null, '2020-11-09 10:17:17', '00000000000', '4', '2020-11-03 23:30:25', 'default');
INSERT INTO `new_word` VALUES ('light', null, '光、轻的', '2020-11-10 21:08:27', null, '2020-11-11 14:59:06', '00000000000', '1', '2020-11-10 21:08:27', 'default');
INSERT INTO `new_word` VALUES ('Lily', null, '莉莉', '2020-11-04 15:59:10', null, '2020-11-10 13:58:42', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('Look at man,he\'s very fat.', null, '看那个男人，他非常胖。', '2020-11-04 15:59:10', null, '2020-11-10 14:17:38', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('Look at that.', null, '看那个', '2020-11-03 00:04:03', null, '2020-11-09 10:10:32', '00000000000', '4', '2020-11-03 00:04:03', 'default');
INSERT INTO `new_word` VALUES ('lovely', null, '可爱的', '2020-11-07 23:14:10', null, '2020-11-10 14:00:33', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('make', null, '制造、厂商', '2020-10-31 18:26:05', null, '2020-11-10 14:02:05', '00000000000', '5', '2020-10-31 18:26:05', 'default');
INSERT INTO `new_word` VALUES ('mam', null, '妈妈', '2020-11-10 21:05:01', null, '2020-11-11 15:00:18', '00000000000', '1', '2020-11-10 21:05:01', 'default');
INSERT INTO `new_word` VALUES ('matter', null, '毛病、你有什么毛病中的毛病', '2020-11-10 16:43:56', null, '2020-11-11 15:18:31', '00000000000', '1', '2020-11-10 16:43:56', 'default');
INSERT INTO `new_word` VALUES ('me', null, '宾格我', '2020-11-11 16:01:16', null, '2020-11-11 16:01:16', '00000000000', '0', '2020-11-11 16:01:16', 'pron');
INSERT INTO `new_word` VALUES ('meet', null, '遇见', '2020-10-31 18:23:10', null, '2020-11-10 14:00:37', '00000000000', '5', '2020-10-31 18:23:10', 'default');
INSERT INTO `new_word` VALUES ('men', null, '男人们', '2020-11-09 23:48:31', null, '2020-11-11 15:08:23', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('Mercedes', null, '梅赛德斯奔驰', '2020-10-31 21:56:27', null, '2020-11-10 14:16:59', '00000000000', '5', '2020-10-31 21:56:27', 'default');
INSERT INTO `new_word` VALUES ('Michael Baker', null, '迈克尔·贝克', '2020-11-09 23:48:31', null, '2020-11-11 15:18:11', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('milkman', null, '送牛奶的人', '2020-11-01 21:10:09', null, '2020-11-11 15:10:44', '00000000000', '5', '2020-11-01 21:10:09', 'default');
INSERT INTO `new_word` VALUES ('Mini', null, '迷你', '2020-10-31 22:06:01', null, '2020-11-10 14:23:53', '00000000000', '5', '2020-10-31 22:06:01', 'default');
INSERT INTO `new_word` VALUES ('Miss', null, '小姐', '2020-10-31 18:20:43', null, '2020-11-10 14:16:54', '00000000000', '5', '2020-10-31 18:20:43', 'default');
INSERT INTO `new_word` VALUES ('morning', null, '早晨', '2020-10-31 18:20:18', null, '2020-11-10 14:03:18', '00000000000', '5', '2020-10-31 18:20:18', 'default');
INSERT INTO `new_word` VALUES ('mother', null, '母亲', '2020-11-04 15:59:10', null, '2020-11-10 14:43:02', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('Mr.', null, '写信时用的先生', '2020-10-31 18:19:10', null, '2020-11-10 14:41:59', '00000000000', '5', '2020-10-31 18:19:10', 'default');
INSERT INTO `new_word` VALUES ('my', null, '我的', '2020-11-11 16:02:21', null, '2020-11-11 16:02:21', '00000000000', '0', '2020-11-11 16:02:21', 'pron');
INSERT INTO `new_word` VALUES ('nationality', null, '国籍', '2020-11-01 19:26:08', null, '2020-11-11 14:54:57', '00000000000', '5', '2020-11-01 19:26:08', 'default');
INSERT INTO `new_word` VALUES ('new', null, '新的', '2020-10-31 18:20:54', null, '2020-11-10 14:02:49', '00000000000', '5', '2020-10-31 18:20:54', 'default');
INSERT INTO `new_word` VALUES ('nice', null, '美好的、干得好', '2020-10-31 18:22:42', null, '2020-11-10 13:53:54', '00000000000', '5', '2020-10-31 18:22:42', 'default');
INSERT INTO `new_word` VALUES ('Nicola Grey', null, '尼古拉·格雷', '2020-11-09 23:45:21', null, '2020-11-11 15:08:20', '00000000000', '2', '2020-11-09 23:45:21', 'default');
INSERT INTO `new_word` VALUES ('nine', null, '9', '2020-11-05 21:37:50', null, '2020-11-11 15:09:49', '00000000000', '4', '2020-11-05 21:37:50', 'default');
INSERT INTO `new_word` VALUES ('Norwegian', null, '挪威人', '2020-11-08 22:38:59', null, '2020-11-11 14:56:55', '00000000000', '3', '2020-11-08 22:38:59', 'default');
INSERT INTO `new_word` VALUES ('number', null, '号码', '2020-10-29 22:55:47', null, '2020-11-08 00:31:40', '00000000000', '5', '2020-10-29 22:55:47', 'default');
INSERT INTO `new_word` VALUES ('nurse', null, '护士', '2020-11-01 21:09:04', null, '2020-11-11 15:10:40', '00000000000', '5', '2020-11-01 21:09:04', 'default');
INSERT INTO `new_word` VALUES ('office', null, '办公室', '2020-11-09 23:47:27', null, '2020-11-11 15:09:51', '00000000000', '2', '2020-11-09 23:47:27', 'default');
INSERT INTO `new_word` VALUES ('officer', null, '官员', '2020-11-08 22:42:40', null, '2020-11-11 15:00:15', '00000000000', '3', '2020-11-08 22:42:40', 'default');
INSERT INTO `new_word` VALUES ('old', null, '老的', '2020-11-03 23:29:34', null, '2020-11-09 10:07:12', '00000000000', '4', '2020-11-03 23:29:34', 'default');
INSERT INTO `new_word` VALUES ('one', null, '1', '2020-11-05 21:36:07', null, '2020-11-11 15:05:45', '00000000000', '4', '2020-11-05 21:36:07', 'default');
INSERT INTO `new_word` VALUES ('open', null, '打开', '2020-11-10 21:10:39', null, '2020-11-11 15:17:50', '00000000000', '1', '2020-11-10 21:10:39', 'default');
INSERT INTO `new_word` VALUES ('operator', null, '输入者', '2020-11-01 19:26:53', null, '2020-11-11 15:16:32', '00000000000', '5', '2020-11-01 19:26:53', 'default');
INSERT INTO `new_word` VALUES ('orange', null, '橙色', '2020-11-07 23:14:10', null, '2020-11-10 14:01:39', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('our', null, '我们的', '2020-11-08 22:41:13', null, '2020-11-11 15:10:15', '00000000000', '3', '2020-11-08 22:41:13', 'default');
INSERT INTO `new_word` VALUES ('our', null, '我们的', '2020-11-11 16:08:52', null, '2020-11-11 16:08:52', '00000000000', '0', '2020-11-11 16:08:52', 'pron');
INSERT INTO `new_word` VALUES ('pardon', '', '原谅、请再说一遍', '2020-10-26 21:43:43', null, '2020-11-10 13:53:41', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('pass', null, '通过、通道', '2020-11-07 22:39:04', null, '2020-11-10 14:23:59', '00000000000', '3', '2020-11-07 22:39:04', 'default');
INSERT INTO `new_word` VALUES ('passport', null, '护照', '2020-11-08 22:39:42', null, '2020-11-11 15:18:56', '00000000000', '3', '2020-11-08 22:39:42', 'default');
INSERT INTO `new_word` VALUES ('Paul', null, '倒齿、保罗', '2020-11-04 15:59:10', null, '2020-11-10 14:03:55', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('pen', null, '钢笔', '2020-10-26 21:43:43', null, '2020-11-10 13:53:59', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('pencil', null, '铅笔', '2020-10-26 21:43:43', null, '2020-11-10 13:58:55', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('perhaps', null, '也许、可能、大概', '2020-11-04 15:59:10', null, '2020-11-10 13:53:39', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('Peugeot', null, '标志', '2020-10-31 21:56:09', null, '2020-11-10 13:58:23', '00000000000', '5', '2020-10-31 21:56:09', 'default');
INSERT INTO `new_word` VALUES ('photo', null, '照片', '2020-11-09 23:48:31', null, '2020-11-11 15:04:17', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('please', null, '请', '2020-10-29 22:56:09', null, '2020-11-08 00:31:32', '00000000000', '5', '2020-10-29 22:56:09', 'default');
INSERT INTO `new_word` VALUES ('police', null, '警察', '2020-11-01 19:30:04', null, '2020-11-11 14:56:57', '00000000000', '5', '2020-11-01 19:30:04', 'default');
INSERT INTO `new_word` VALUES ('postman', null, '跑死他们', '2020-11-01 21:08:47', null, '2020-11-11 15:13:53', '00000000000', '5', '2020-11-01 21:08:47', 'default');
INSERT INTO `new_word` VALUES ('red', null, '红色', '2020-11-07 23:14:10', null, '2020-11-10 14:00:38', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('Richards', null, '理查兹', '2020-11-09 23:44:16', null, '2020-11-11 15:10:08', '00000000000', '2', '2020-11-09 23:44:16', 'default');
INSERT INTO `new_word` VALUES ('right', null, '正确的、右边', '2020-11-10 21:04:35', null, '2020-11-11 14:59:40', '00000000000', '1', '2020-11-10 21:04:35', 'default');
INSERT INTO `new_word` VALUES ('Russian', null, '俄罗斯人', '2020-11-08 22:41:52', null, '2020-11-11 14:59:55', '00000000000', '3', '2020-11-08 22:41:52', 'default');
INSERT INTO `new_word` VALUES ('sales rep', null, '销售代表', '2020-11-09 23:48:31', null, '2020-11-11 15:01:39', '00000000000', '2', '2020-11-09 23:48:31', 'default');
INSERT INTO `new_word` VALUES ('same', null, '同样的', '2020-11-07 23:14:10', null, '2020-11-10 14:14:19', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('say', null, '讲话、讲（名词）', '2020-11-05 21:46:04', null, '2020-11-11 15:11:07', '00000000000', '4', '2020-11-05 21:46:04', 'default');
INSERT INTO `new_word` VALUES ('school', null, '学校', '2020-10-29 23:01:43', null, '2020-11-08 00:35:24', '00000000000', '5', '2020-10-29 23:01:43', 'default');
INSERT INTO `new_word` VALUES ('see', null, '见到、理解、查看', '2020-11-03 23:28:12', null, '2020-11-09 10:10:56', '00000000000', '4', '2020-11-03 23:28:12', 'default');
INSERT INTO `new_word` VALUES ('seven', null, '7', '2020-11-05 21:37:16', null, '2020-11-11 15:01:34', '00000000000', '4', '2020-11-05 21:37:16', 'default');
INSERT INTO `new_word` VALUES ('she', null, '她', '2020-11-11 16:04:58', null, '2020-11-11 16:04:58', '00000000000', '0', '2020-11-11 16:04:58', 'pron');
INSERT INTO `new_word` VALUES ('shirt', null, '衬衣', '2020-10-26 21:43:43', null, '2020-11-10 14:15:54', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('shoe', null, '鞋子', '2020-11-10 21:10:03', null, '2020-11-11 15:02:29', '00000000000', '1', '2020-11-10 21:10:03', 'default');
INSERT INTO `new_word` VALUES ('short', null, '矮的', '2020-11-03 23:30:43', null, '2020-11-09 10:12:27', '00000000000', '4', '2020-11-03 23:30:43', 'default');
INSERT INTO `new_word` VALUES ('shut', null, '关闭', '2020-11-10 21:10:17', null, '2020-11-11 15:17:52', '00000000000', '1', '2020-11-10 21:10:17', 'default');
INSERT INTO `new_word` VALUES ('sir', null, '先生', '2020-10-29 22:58:04', null, '2020-11-08 00:29:06', '00000000000', '5', '2020-10-29 22:58:04', 'default');
INSERT INTO `new_word` VALUES ('sister', null, '姐妹', '2020-11-04 15:59:10', null, '2020-11-10 13:58:51', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('sit down', null, '坐下', '2020-11-10 16:45:19', null, '2020-11-11 15:03:58', '00000000000', '1', '2020-11-10 16:45:19', 'default');
INSERT INTO `new_word` VALUES ('situation', null, '情况、职业、地理位置', '2020-11-07 22:40:49', null, '2020-11-10 13:57:21', '00000000000', '3', '2020-11-07 22:40:49', 'default');
INSERT INTO `new_word` VALUES ('six', null, '6', '2020-11-05 21:36:31', null, '2020-11-11 15:07:04', '00000000000', '4', '2020-11-05 21:36:31', 'default');
INSERT INTO `new_word` VALUES ('skirt', null, '裙子', '2020-10-26 21:43:43', null, '2020-11-10 13:58:35', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('small', null, '小的', '2020-11-10 21:07:53', null, '2020-11-11 14:57:53', '00000000000', '1', '2020-11-10 21:07:53', 'default');
INSERT INTO `new_word` VALUES ('smart', null, '聪明的', '2020-11-07 23:14:10', null, '2020-11-10 14:23:57', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('some', null, '一些; 某个; 部分; 相当多的;', '2020-11-05 14:53:13', null, '2020-11-11 15:08:46', '00000000000', '4', '2020-11-05 14:53:13', 'default');
INSERT INTO `new_word` VALUES ('someone', null, '某人', '2020-11-05 21:46:48', null, '2020-11-11 15:18:41', '00000000000', '4', '2020-11-05 21:46:48', 'default');
INSERT INTO `new_word` VALUES ('something', null, '某事', '2020-11-05 21:45:51', null, '2020-11-11 15:10:22', '00000000000', '4', '2020-11-05 21:45:51', 'default');
INSERT INTO `new_word` VALUES ('son', null, '儿子', '2020-10-29 23:01:10', null, '2020-11-08 00:40:40', '00000000000', '5', '2020-10-29 23:01:10', 'default');
INSERT INTO `new_word` VALUES ('Sophie', null, '索菲', '2020-11-04 15:59:10', null, '2020-11-10 14:02:10', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('sorry', null, '抱歉、对不起', '2020-10-29 22:57:39', null, '2020-11-08 00:28:02', '00000000000', '5', '2020-10-29 22:57:39', 'default');
INSERT INTO `new_word` VALUES ('speak', null, '说话(动作)', '2020-11-05 21:51:22', null, '2020-11-11 15:18:17', '00000000000', '4', '2020-11-05 21:51:22', 'default');
INSERT INTO `new_word` VALUES ('Stella', null, '斯黛拉', '2020-11-04 15:59:10', null, '2020-11-10 14:25:33', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('Steven', null, '史蒂芬', '2020-11-03 23:48:33', null, '2020-11-09 10:07:01', '00000000000', '4', '2020-11-03 23:48:33', 'default');
INSERT INTO `new_word` VALUES ('student', null, '学生', '2020-10-31 18:21:04', null, '2020-11-10 14:15:48', '00000000000', '5', '2020-10-31 18:21:04', 'default');
INSERT INTO `new_word` VALUES ('suit', null, '套装、一套衣服', '2020-10-29 23:00:41', null, '2020-11-08 00:32:39', '00000000000', '5', '2020-10-29 23:00:41', 'default');
INSERT INTO `new_word` VALUES ('Swedish', null, '瑞典的', '2020-11-04 18:27:03', '2020-11-10 14:16:27', '2020-11-11 14:58:49', '00000000001', '5', '2020-10-31 18:27:03', 'default');
INSERT INTO `new_word` VALUES ('tall', null, '高的', '2020-11-03 23:30:35', null, '2020-11-09 10:17:12', '00000000000', '4', '2020-11-03 23:30:35', 'default');
INSERT INTO `new_word` VALUES ('taxidriver', null, '出租车司机', '2020-11-01 21:05:06', '2020-11-04 00:49:29', '2020-11-11 14:57:46', '00000000001', '6', '2020-11-01 21:05:06', 'default');
INSERT INTO `new_word` VALUES ('teacher', null, '老师', '2020-10-29 23:02:49', null, '2020-11-08 00:32:19', '00000000000', '5', '2020-10-29 23:02:49', 'default');
INSERT INTO `new_word` VALUES ('ten', null, '10', '2020-11-05 21:36:00', null, '2020-11-11 15:00:17', '00000000000', '4', '2020-11-05 21:36:00', 'default');
INSERT INTO `new_word` VALUES ('terrorist', null, '恐怖分子', '2020-11-10 21:04:18', null, '2020-11-11 15:14:44', '00000000000', '1', '2020-11-10 21:04:18', 'default');
INSERT INTO `new_word` VALUES ('test', null, '测试', '2020-10-26 21:43:43', null, '2020-11-10 14:45:15', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('thank', '', '感谢你', '2020-10-26 21:43:43', null, '2020-11-10 14:14:24', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('Thank you all the same.', null, '仍然感谢你.', '2020-11-07 23:14:10', null, '2020-11-10 14:11:16', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('thanks', null, '谢谢的复数形式', '2020-11-03 23:27:34', null, '2020-11-09 10:11:42', '00000000000', '4', '2020-11-03 23:27:34', 'default');
INSERT INTO `new_word` VALUES ('that', null, '那个', '2020-11-03 23:56:40', null, '2020-11-09 10:15:26', '00000000000', '4', '2020-11-03 23:56:40', 'default');
INSERT INTO `new_word` VALUES ('their', null, '他们的', '2020-11-09 10:04:44', null, '2020-11-11 15:06:37', '00000000000', '2', '2020-11-09 10:04:44', 'default');
INSERT INTO `new_word` VALUES ('their', null, '他们的', '2020-11-11 16:06:55', null, '2020-11-11 16:06:55', '00000000000', '0', '2020-11-11 16:06:55', 'pron');
INSERT INTO `new_word` VALUES ('them', null, '他们(宾格)', '2020-11-09 10:05:25', null, '2020-11-11 15:00:28', '00000000000', '2', '2020-11-09 10:05:25', 'default');
INSERT INTO `new_word` VALUES ('them', null, '他们(宾格)', '2020-11-11 16:06:14', null, '2020-11-11 16:06:14', '00000000000', '0', '2020-11-11 16:06:14', 'pron');
INSERT INTO `new_word` VALUES ('there', null, '那边、那里', '2020-11-10 16:46:39', '2020-11-11 15:19:31', '2020-11-11 15:19:31', '00000000001', '0', '2020-11-10 16:46:39', 'default');
INSERT INTO `new_word` VALUES ('these', null, '这些', '2020-11-10 22:39:53', '2020-11-11 14:56:31', '2020-11-11 14:56:31', '00000000001', '2', '2020-11-08 22:39:53', 'default');
INSERT INTO `new_word` VALUES ('they', null, '他们', '2020-11-08 22:39:28', null, '2020-11-11 14:57:50', '00000000000', '3', '2020-11-08 22:39:28', 'default');
INSERT INTO `new_word` VALUES ('they', null, '他们', '2020-11-11 16:06:04', null, '2020-11-11 16:06:04', '00000000000', '0', '2020-11-11 16:06:04', 'pron');
INSERT INTO `new_word` VALUES ('They are engineers.', null, '他们是工程师', '2020-11-10 16:12:02', null, '2020-11-11 15:15:03', '00000000000', '1', '2020-11-10 16:12:02', 'default');
INSERT INTO `new_word` VALUES ('They are sales reps.', null, '他们是推销员.', '2020-11-10 15:29:13', '2020-11-11 15:13:18', '2020-11-11 15:13:18', '00000000001', '0', '2020-11-10 15:29:13', 'default');
INSERT INTO `new_word` VALUES ('thin', null, '瘦的', '2020-11-04 15:59:10', null, '2020-11-10 14:12:06', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('thing', null, '事件，形势; 东西，事物; 家伙; 事业;', '2020-11-05 14:53:13', null, '2020-11-11 15:18:28', '00000000000', '4', '2020-11-05 14:53:13', 'default');
INSERT INTO `new_word` VALUES ('thirsty', null, '渴的', '2020-11-10 16:44:42', null, '2020-11-11 15:11:04', '00000000000', '1', '2020-11-10 16:44:42', 'default');
INSERT INTO `new_word` VALUES ('thirty', null, '30', '2020-11-07 22:00:07', null, '2020-11-10 13:57:31', '00000000000', '3', '2020-11-07 22:00:07', 'default');
INSERT INTO `new_word` VALUES ('this', '', '这、这个、这事', '2020-10-31 21:43:43', '2020-11-10 13:54:17', '2020-11-11 14:57:26', '00000000001', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('those', null, '那些', '2020-11-09 23:47:44', null, '2020-11-11 15:02:01', '00000000000', '2', '2020-11-09 23:47:44', 'default');
INSERT INTO `new_word` VALUES ('Those women are very hard-working.', null, '那些女人非常努力工作。', '2020-11-10 15:41:18', null, '2020-11-11 15:17:48', '00000000000', '1', '2020-11-10 15:41:18', 'default');
INSERT INTO `new_word` VALUES ('three', null, '3', '2020-11-05 21:35:53', null, '2020-11-11 14:58:03', '00000000000', '4', '2020-11-05 21:35:53', 'default');
INSERT INTO `new_word` VALUES ('throw', null, '投出、丢、抛', '2020-11-07 22:39:51', null, '2020-11-10 14:12:36', '00000000000', '3', '2020-11-07 22:39:51', 'default');
INSERT INTO `new_word` VALUES ('ticket', null, '票', '2020-10-29 22:59:04', null, '2020-11-08 00:40:00', '00000000000', '5', '2020-10-29 22:59:04', 'default');
INSERT INTO `new_word` VALUES ('tie', null, '领带', '2020-11-07 22:03:52', null, '2020-11-10 14:11:48', '00000000000', '3', '2020-11-07 22:03:52', 'default');
INSERT INTO `new_word` VALUES ('Tim', null, '提姆', '2020-11-04 15:59:10', null, '2020-11-10 13:58:01', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('tired', null, '累', '2020-11-10 16:44:21', null, '2020-11-11 14:58:15', '00000000000', '1', '2020-11-10 16:44:21', 'default');
INSERT INTO `new_word` VALUES ('today', null, '今天', '2020-11-03 23:28:32', null, '2020-11-09 10:07:03', '00000000000', '4', '2020-11-03 23:28:32', 'default');
INSERT INTO `new_word` VALUES ('Tony', null, '托尼', '2020-11-03 23:48:45', null, '2020-11-09 10:15:31', '00000000000', '4', '2020-11-03 23:48:45', 'default');
INSERT INTO `new_word` VALUES ('too', null, '也、强调、太', '2020-10-31 18:25:35', null, '2020-11-10 14:11:04', '00000000000', '5', '2020-10-31 18:25:35', 'default');
INSERT INTO `new_word` VALUES ('tourist', null, '旅行者', '2020-11-09 22:41:28', '2020-11-10 14:47:09', '2020-11-11 15:15:48', '00000000001', '2', '2020-11-08 22:41:28', 'default');
INSERT INTO `new_word` VALUES ('Toyota', null, '丰田', '2020-10-31 21:56:39', null, '2020-11-10 13:59:50', '00000000000', '5', '2020-10-31 21:56:39', 'default');
INSERT INTO `new_word` VALUES ('two', null, '2', '2020-11-05 21:37:33', null, '2020-11-11 14:54:41', '00000000000', '4', '2020-11-05 21:37:33', 'default');
INSERT INTO `new_word` VALUES ('umbrella', null, '伞', '2020-10-29 22:55:32', null, '2020-11-08 00:29:09', '00000000000', '5', '2020-10-29 22:55:32', 'default');
INSERT INTO `new_word` VALUES ('upstairs', null, '楼上', '2020-11-07 23:14:10', null, '2020-11-10 14:11:02', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('us', null, '我们(宾格)', '2020-11-11 16:08:46', null, '2020-11-11 16:08:46', '00000000000', '0', '2020-11-11 16:08:46', 'pron');
INSERT INTO `new_word` VALUES ('very much', null, '非常的', '2020-10-26 21:43:43', null, '2020-11-10 14:11:40', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('Volvo', null, '沃尔沃', '2020-10-31 21:54:08', null, '2020-11-10 13:55:34', '00000000000', '5', '2020-10-31 21:54:08', 'default');
INSERT INTO `new_word` VALUES ('want', null, '希望', '2020-11-05 21:50:47', null, '2020-11-11 14:59:42', '00000000000', '4', '2020-11-05 21:50:47', 'default');
INSERT INTO `new_word` VALUES ('watch', null, '手表、注意、观察、值班', '2020-10-26 21:43:43', null, '2020-11-10 14:14:41', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('we', null, '我们', '2020-11-08 22:38:24', null, '2020-11-11 15:16:14', '00000000000', '3', '2020-11-08 22:38:24', 'default');
INSERT INTO `new_word` VALUES ('we', null, '我们', '2020-11-11 16:07:27', null, '2020-11-11 16:07:27', '00000000000', '0', '2020-11-11 16:07:27', 'pron');
INSERT INTO `new_word` VALUES ('well', null, '好的、健康的、涌出、完全的', '2020-11-03 23:28:21', null, '2020-11-09 10:08:29', '00000000000', '4', '2020-11-03 23:28:21', 'default');
INSERT INTO `new_word` VALUES ('what', null, '什么', '2020-11-01 19:28:05', null, '2020-11-11 15:15:40', '00000000000', '5', '2020-11-01 19:28:05', 'default');
INSERT INTO `new_word` VALUES ('What are their jobs?', null, '他们的工作是什么', '2020-11-10 15:41:56', '2020-11-11 15:05:35', '2020-11-11 15:05:35', '00000000001', '0', '2020-11-10 15:41:56', 'default');
INSERT INTO `new_word` VALUES ('What colour is this car?', null, '这辆车是什么颜色的', '2020-11-10 15:32:03', '2020-11-11 15:08:05', '2020-11-11 15:08:05', '00000000001', '0', '2020-11-10 15:32:03', 'default');
INSERT INTO `new_word` VALUES ('when', null, '时候;场合;什么时候;', '2020-11-05 22:16:19', null, '2020-11-11 15:18:53', '00000000000', '4', '2020-11-05 22:16:19', 'default');
INSERT INTO `new_word` VALUES ('which', null, '指前面提到的事物;哪一个中的“哪”', '2020-11-05 22:13:33', null, '2020-11-11 15:01:32', '00000000000', '4', '2020-11-05 22:13:33', 'default');
INSERT INTO `new_word` VALUES ('white', null, '白色', '2020-11-04 15:59:10', null, '2020-11-10 14:11:58', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('whose', null, '谁的', '2020-11-04 15:59:10', null, '2020-11-10 13:55:32', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('Whose shirt is that?', null, '谁的衬衣在那', '2020-11-04 15:59:10', null, '2020-11-10 14:49:28', '00000000000', '4', '2020-11-04 15:59:10', 'default');
INSERT INTO `new_word` VALUES ('woman', null, '女人', '2020-11-03 23:29:12', null, '2020-11-09 10:15:46', '00000000000', '4', '2020-11-03 23:29:12', 'default');
INSERT INTO `new_word` VALUES ('women', null, '女人们', '2020-11-09 23:48:20', null, '2020-11-11 14:57:00', '00000000000', '2', '2020-11-09 23:48:20', 'default');
INSERT INTO `new_word` VALUES ('wrong', null, '错误的、不适合的', '2020-11-05 22:10:44', null, '2020-11-11 15:03:02', '00000000000', '4', '2020-11-05 22:10:44', 'default');
INSERT INTO `new_word` VALUES ('yellow', null, '黄色', '2020-11-07 23:14:10', null, '2020-11-10 14:24:37', '00000000000', '3', '2020-11-07 23:14:10', 'default');
INSERT INTO `new_word` VALUES ('you', null, '你、你们、(宾格)你、(宾格)你们', '2020-11-11 16:04:13', null, '2020-11-11 16:04:13', '00000000000', '0', '2020-11-11 16:04:13', 'pron');
INSERT INTO `new_word` VALUES ('young', null, '年轻的', '2020-11-03 23:29:42', null, '2020-11-09 10:13:14', '00000000000', '4', '2020-11-03 23:29:42', 'default');
INSERT INTO `new_word` VALUES ('your', '', '你的', '2020-10-26 21:43:43', null, '2020-11-10 14:17:46', '00000000000', '6', '2020-10-26 21:43:43', 'default');
INSERT INTO `new_word` VALUES ('your', null, '你的、你们的', '2020-11-11 16:04:22', null, '2020-11-11 16:04:22', '00000000000', '0', '2020-11-11 16:04:22', 'pron');

-- ----------------------------
-- View structure for v_new_word
-- ----------------------------
DROP VIEW IF EXISTS `v_new_word`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v_new_word` AS select `new_word`.`word` AS `word`,`new_word`.`phonetic_symbol` AS `phonetic_symbol`,`new_word`.`chinese` AS `chinese`,`new_word`.`memory_time` AS `memory_time`,`new_word`.`last_lethe_time` AS `last_lethe_time`,`new_word`.`last_memory_time` AS `last_memory_time`,`new_word`.`lethe_count` AS `lethe_count`,`new_word`.`success_count` AS `success_count` from `new_word` order by `new_word`.`memory_time` desc ;
