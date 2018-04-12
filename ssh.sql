/*
 Navicat Premium Data Transfer

 Source Server         : 114.67.144.50 2
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 114.67.144.50
 Source Database       : ssh

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : utf-8

 Date: 04/12/2018 21:05:53 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `adminuser`
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `adminuser`
-- ----------------------------
BEGIN;
INSERT INTO `adminuser` VALUES ('1', 'admin', 'admin');
COMMIT;

-- ----------------------------
--  Table structure for `cartitem`
-- ----------------------------
DROP TABLE IF EXISTS `cartitem`;
CREATE TABLE `cartitem` (
  `caid` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `uploaddate` varchar(255) DEFAULT NULL,
  `updatedate` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`caid`),
  KEY `FK6D66333F4319D9` (`uid`),
  KEY `FK6D6633A56D3FC` (`pid`),
  CONSTRAINT `FK6D66333F4319D9` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `FK6D6633A56D3FC` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cartitem`
-- ----------------------------
BEGIN;
INSERT INTO `cartitem` VALUES ('4', '2', '2017-07-20 17:19:22', '2017-07-20 17:19:34', '68', '9'), ('23', '1', '2017-08-08 13:17:14', '2017-08-08 13:17:14', '2', '15'), ('25', '1', '2018-04-03 13:41:12', '2018-04-03 13:41:12', '60', '36');
COMMIT;

-- ----------------------------
--  Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `category`
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES ('1', '女装男装'), ('2', '鞋靴箱包'), ('3', '运动户外'), ('4', '珠宝配饰'), ('5', '手机数码'), ('6', '家电办公'), ('7', '护肤彩妆'), ('13', '家具饰品');
COMMIT;

-- ----------------------------
--  Table structure for `categorysecond`
-- ----------------------------
DROP TABLE IF EXISTS `categorysecond`;
CREATE TABLE `categorysecond` (
  `csid` int(11) NOT NULL AUTO_INCREMENT,
  `csname` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`csid`),
  KEY `FK936FCAF21DB1FD15` (`cid`),
  CONSTRAINT `FK936FCAF21DB1FD15` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `categorysecond`
-- ----------------------------
BEGIN;
INSERT INTO `categorysecond` VALUES ('1', '潮流女装', '1'), ('2', '初冬羽绒', '1'), ('3', '毛呢大衣', '1'), ('4', '温暖毛衣', '1'), ('5', '精选男装', '1'), ('6', '冬季外套', '1'), ('7', '羽绒服', '1'), ('9', '女鞋', '2'), ('10', '短靴', '2'), ('11', '男鞋', '2'), ('12', '女包', '2'), ('13', '男包', '2'), ('14', '服饰配件', '2'), ('15', '运动鞋', '3'), ('16', '运动服', '3'), ('17', '户外运动', '3'), ('18', '健身装备', '3'), ('19', '骑行装备', '3'), ('20', '珠宝首饰', '4'), ('21', '时尚饰品', '4'), ('22', '品质手表', '4'), ('23', '眼镜配饰', '4'), ('24', '手机', '5'), ('25', '平板', '5'), ('26', '电脑', '5'), ('27', '相机', '5'), ('28', '大家电', '6'), ('29', '厨房电器', '6'), ('30', '生活电器', '6'), ('31', '个户电器', '6'), ('32', '办公耗材', '6'), ('33', '美容护肤', '7'), ('34', '强效保养', '7'), ('35', '超值彩妆', '7'), ('36', '换季保养', '7'), ('40', '组合衣柜', '13');
COMMIT;

-- ----------------------------
--  Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `FKE8B2AB61A56D3FC` (`pid`),
  KEY `FKE8B2AB61A896031A` (`oid`),
  CONSTRAINT `FKE8B2AB61A56D3FC` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `FKE8B2AB61A896031A` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `orderitem`
-- ----------------------------
BEGIN;
INSERT INTO `orderitem` VALUES ('16', '1', '186', '5', '36'), ('17', '1', '172', '5', '2'), ('18', '1', '186', '5', '35'), ('19', '3', '897', '5', '57'), ('20', '1', '186', '5', '37'), ('21', '1', '83', '6', '64'), ('22', '1', '83', '7', '64'), ('23', '1', '83', '8', '64'), ('24', '1', '83', '9', '64'), ('25', '1', '186', '10', '35'), ('26', '1', '186', '10', '36'), ('27', '1', '172', '10', '2'), ('28', '3', '897', '10', '57'), ('29', '1', '186', '10', '37'), ('30', '1', '83', '11', '62'), ('31', '1', '299', '11', '60'), ('32', '1', '186', '11', '38'), ('33', '1', '299', '11', '61'), ('34', '1', '83', '11', '63'), ('35', '2', '716', '12', '51'), ('36', '2', '598', '13', '57'), ('37', '3', '594', '15', '30'), ('38', '1', '228', '15', '1'), ('39', '1', '119', '15', '5'), ('40', '1', '7599', '16', '73'), ('41', '1', '358', '16', '51'), ('42', '1', '7599', '17', '73'), ('43', '1', '7599', '18', '73'), ('44', '1', '299', '19', '57'), ('45', '1', '7599', '19', '73'), ('46', '6', '1188', '20', '21'), ('47', '1', '358', '20', '45'), ('48', '1', '119', '22', '3'), ('49', '2', '238', '23', '6'), ('50', '1', '228', '23', '1'), ('51', '1', '83', '23', '72'), ('52', '4', '30396', '23', '73'), ('53', '1', '172', '23', '2'), ('54', '1', '83', '24', '68'), ('55', '1', '228', '25', '1'), ('56', '1', '358', '26', '51'), ('57', '8', '2392', '27', '57'), ('58', '1', '299', '27', '60'), ('59', '1', '83', '28', '72'), ('60', '1', '83', '29', '72'), ('61', '1', '228', '29', '1'), ('62', '1', '299', '30', '54'), ('63', '1', '228', '33', '1');
COMMIT;

-- ----------------------------
--  Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FKC3DF62E53F4319D9` (`uid`),
  CONSTRAINT `FKC3DF62E53F4319D9` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `orders`
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES ('5', '1627', '2017-07-16 12:53:05', null, null, null, '4', '8'), ('6', '83', '2017-07-16 12:59:14', null, null, null, '4', '8'), ('7', '83', '2017-07-16 12:59:33', null, null, null, '1', '8'), ('8', '83', '2017-07-16 13:01:05', null, null, null, '1', '8'), ('9', '83', '2017-07-17 09:10:30', null, null, null, '1', '8'), ('10', '1627', '2017-07-17 09:10:49', null, null, null, '1', '8'), ('11', '950', '2017-07-17 09:10:54', null, null, null, '1', '8'), ('12', '716', '2017-07-17 09:52:02', null, null, null, '1', '8'), ('13', '598', '2017-07-20 17:18:49', null, null, null, '1', '9'), ('15', '941', '2017-07-27 16:20:40', null, null, null, '1', '8'), ('16', '7957', '2017-08-01 16:55:28', null, null, null, '1', '8'), ('17', '7599', '2017-08-01 16:56:00', null, null, null, '1', '8'), ('18', '7599', '2017-08-01 16:56:38', null, null, null, '1', '8'), ('19', '7898', '2017-08-01 16:57:27', null, null, null, '1', '8'), ('20', '1546', '2017-08-02 10:43:03', null, null, null, '1', '8'), ('22', '119', '2017-08-06 00:07:33', null, null, null, '1', '8'), ('23', '31117', '2017-09-03 11:58:19', null, null, null, '1', '8'), ('24', '83', '2017-09-11 11:26:41', null, null, null, '1', '16'), ('25', '228', '2017-10-12 20:18:03', null, null, null, '1', '17'), ('26', '358', '2017-10-22 19:26:01', null, null, null, '1', '17'), ('27', '2691', '2017-12-15 19:36:26', null, null, null, '1', '8'), ('28', '83', '2018-01-11 11:25:41', null, null, null, '1', '8'), ('29', '311', '2018-01-22 20:06:05', null, null, null, '1', '8'), ('30', '299', '2018-04-03 13:39:53', null, null, null, '1', '36'), ('31', '0', '2018-04-11 20:33:49', null, null, null, '1', '39'), ('32', '0', '2018-04-11 20:34:44', null, null, null, '1', '39'), ('33', '228', '2018-04-11 20:37:37', null, null, null, '1', '41');
COMMIT;

-- ----------------------------
--  Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `pdate` datetime DEFAULT NULL,
  `csid` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FKED8DCCEFB9B74E02` (`csid`),
  CONSTRAINT `FKED8DCCEFB9B74E02` FOREIGN KEY (`csid`) REFERENCES `categorysecond` (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `product`
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES ('1', '韩版连帽加厚毛衣女外套', '558', '228', 'products/1/cs10001.jpg', '双11限量200件，拍完下架，加车享优惠，早下手早发货。。秋冬个性中长款毛衣，美丽和温度同在！限量供应，拒绝撞衫！迫于纱线和人工在不断上涨的双重压力下，产品涨价在即！少量现货出售中，手快有，手慢等哦，赶紧抢哦，绝对高大上。', '1', '2014-11-02 20:18:00', '1'), ('2', '女装立领长袖拼接PU皮毛呢外套', '436', '172', 'products/1/cs10002.jpg', '【现在拍下并支付定金，即可获得双12当天10元无门槛优惠券一张。注：只限有预付定金款~优惠券统一在12月11号发放】 毛呢外套 整洁干练的长款版型 整个肩部给予皮绒拼接 与毛呢一起撑起品质感 立领 长袖 肩部往下做流行加层拼接 一粒扣收合门襟 特意做的夹棉里层（袖里无） 不必再畏惧冷冽寒风', '0', '2014-11-04 20:18:00', '1'), ('3', '韩版女装翻领羔绒夹棉格子毛呢外套', '238', '119', 'products/1/cs10003.jpg', '外套款。 称为棉衣也不为过 或者因为它的表层毛呢　称呼为毛呢外套 ｙａｎｇ　羔绒位于翻领及袖口 从视觉着手　带来温暖无限 夹棉里衬（袖里也有）再次提升御寒功能 流行元素上　选择红黑格纹理　大气而又经典 金属拉链开叉　插袋自不会少', '0', '2014-10-01 20:18:00', '1'), ('4', '韩版女装翻领羔绒夹棉格子毛呢外套', '238', '119', 'products/1/cs10004.jpg', '外套款。 称为棉衣也不为过 或者因为它的表层毛呢　称呼为毛呢外套 ｙａｎｇ　羔绒位于翻领及袖口 从视觉着手　带来温暖无限 夹棉里衬（袖里也有）再次提升御寒功能 流行元素上　选择红黑格纹理　大气而又经典 金属拉链开叉　插袋自不会少', '0', '2014-12-07 20:18:00', '1'), ('5', '韩版女装翻领羔绒夹棉格子毛呢外套', '238', '119', 'products/1/cs10005.jpg', '外套款。 称为棉衣也不为过 或者因为它的表层毛呢　称呼为毛呢外套 ｙａｎｇ　羔绒位于翻领及袖口 从视觉着手　带来温暖无限 夹棉里衬（袖里也有）再次提升御寒功能 流行元素上　选择红黑格纹理　大气而又经典 金属拉链开叉　插袋自不会少', '0', '2014-11-02 20:18:00', '1'), ('6', '冬装韩版女装翻领羔绒夹棉格子毛呢外套', '238', '119', 'products/1/cs10006.jpg', '外套款。 称为棉衣也不为过 或者因为它的表层毛呢　称呼为毛呢外套 ｙａｎｇ　羔绒位于翻领及袖口 从视觉着手　带来温暖无限 夹棉里衬（袖里也有）再次提升御寒功能 流行元素上　选择红黑格纹理　大气而又经典 金属拉链开叉　插袋自不会少', '0', '2014-11-10 15:18:00', '1'), ('7', '新款优雅奢华毛领白鸭绒轻薄羽绒服', '1120', '590', 'products/1/cs10007.jpg', '秋冬热卖款，今日特惠！库存有限，卖完即止！喜欢的赶紧出手哦！', '0', '2014-11-03 20:18:00', '1'), ('8', '秋冬季毛呢外套女中长款圆领小香风呢子大衣', '672', '336', 'products/1/cs10008.jpg', '【双12预售】双12提前开抢，11月24日—12月11日抢先付预付款33.6元，12月12日付剩余尾款，先付先发货，提前引爆双12！！！买就【送】双十二10元无门槛优惠券！！！商家【赠】运费险！！！', '0', '2014-11-03 20:18:00', '1'), ('9', '女装貉子毛大衣 时尚修身长袖淑女毛呢外套', '238', '119', 'products/1/cs10009.jpg', '秋冬热卖款，今日特惠！库存有限，卖完即止！喜欢的赶紧出手哦！', '0', '2014-11-03 20:18:00', '1'), ('10', '修身显瘦淑女针织长袖打底连衣裙女', '356', '158', 'products/1/cs10010.jpg', '【1212万能盛典预售抢先购,早买早便宜！】定金15.80元，预售价158.00元，双12价涨价至178.00元!', '0', '2014-11-03 20:18:00', '1'), ('11', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20001.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2'), ('12', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20002.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2'), ('13', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20003.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2'), ('14', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20004.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2'), ('15', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20005.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2'), ('16', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20006.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2'), ('17', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20007.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2'), ('18', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20008.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2'), ('19', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20009.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-10-01 20:18:00', '2'), ('20', '中长款貂皮大衣整貂女装', '17900', '7290', 'products/1/cs20010.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】【售后保障】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货', '0', '2014-11-03 20:18:00', '2'), ('21', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30001.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '1', '2014-11-03 20:18:00', '3'), ('22', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30002.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3'), ('23', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30003.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3'), ('24', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30004.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3'), ('25', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30005.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3'), ('26', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30006.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3'), ('27', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30007.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3'), ('28', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30008.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3'), ('29', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30009.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3'), ('30', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30010.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-10 20:18:00', '3'), ('31', '打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40001.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4'), ('32', '打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40002.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4'), ('33', '打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40003.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4'), ('34', '性感时尚 酷感黑色小圆领露肩修身长袖针织衫', '387', '186', 'products/1/cs40004.jpg', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4'), ('35', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40005.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '1', '2014-11-03 20:18:00', '4'), ('36', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40006.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4'), ('37', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40007.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4'), ('38', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40008.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4'), ('39', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40009.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4'), ('40', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40010.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4'), ('41', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40011.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '1', '2014-11-03 20:18:00', '4'), ('42', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50001.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-11-03 20:18:00', '5'), ('43', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50002.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-11-03 20:18:00', '5'), ('44', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50003.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-11-03 20:18:00', '5'), ('45', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50004.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-12-07 20:18:00', '5'), ('46', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50005.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-11-03 20:18:00', '5'), ('47', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50006.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-11-03 20:18:00', '5'), ('48', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50007.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-11-03 20:18:00', '5'), ('49', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50008.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-11-03 20:18:00', '5'), ('50', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50009.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-11-03 20:18:00', '5'), ('51', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50010.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-12-07 20:18:00', '5'), ('52', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60001.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6'), ('53', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60002.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '1', '2014-11-03 20:18:00', '6'), ('54', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60003.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6'), ('55', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60004.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6'), ('56', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60005.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6'), ('57', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60006.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '1', '2014-12-07 22:18:00', '6'), ('58', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60007.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6'), ('59', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60008.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6'), ('60', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60009.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '1', '2014-12-02 20:18:00', '6'), ('61', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60010.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6'), ('62', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83', 'products/1/cs70001.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7'), ('63', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83', 'products/1/cs70002.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7'), ('64', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83', 'products/1/cs70003.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '0', '2014-11-03 20:18:00', '7'), ('65', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83', 'products/1/cs70004.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7'), ('66', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83', 'products/1/cs70005.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '0', '2014-11-03 20:18:00', '7'), ('67', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83', 'products/1/cs70006.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7'), ('68', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83', 'products/1/cs70007.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-12-04 20:18:00', '7'), ('69', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83', 'products/1/cs70008.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7'), ('70', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83', 'products/1/cs70009.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '0', '2014-11-03 20:18:00', '7'), ('72', '女鞋', '198', '83', 'products/1/nvxie.jpg', '韩版女鞋...', '0', '2015-02-10 12:02:54', '9'), ('73', 'mac', '7999', '7599', 'products/1/dn1.jpg', 'macbook！\r\n值得你的信赖', '0', '2017-07-28 08:40:37', '26');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('3', 'OMG丶爱月', '147258', '王文超', '1252078414@qq.com', '15927287429', '湖北省', '0', '458d8fe3319647d3bdee4d90945a246adc02c819c7a64291af6d1be1887f038f'), ('8', '小王爱学习', '147258', '小王', 'aaa@shop.com', '15927287429', '湖北', '1', null), ('9', '小王小朋友', '147258', '王文超', 'aaa@shop.com', '15927287429', '湖北省', '1', null), ('10', 'OMG丶爱月99', '147258', '小吴', 'aaa@shop.com', '15927287429', '湖北', '0', '953180410b8d46748ab492330a959e0001935de265ff4f1191555d8bb8d09fc5'), ('11', '小王不爱学习', '147258', '王文超', '1252078414@qq.com', '15927287429', '湖北省', '0', 'd643c91d343a48dd92670874c423e3a7678ad562aeae4bffa3d018a314f75ae4'), ('12', '小王很爱学习', '147258', '王文超', '1252078414@qq.com', '15927287429', '', '0', '0dce1d1b17864a628b4d54bda5b218d7a542723a5d224108851cbd4880c62364'), ('13', '小李爱学习', '147258', '小李', '1252078414@qq.com', '15927287429', '湖北', '0', 'd4e4bf2b03604d6d8d3941b820c17a1667edae756b7343ce86b30e1c249c1a32'), ('14', '小张爱学习', '147258', '小张', '1252078414@qq.com', '15927287429', '湖北', '0', '8f9c8142c60047868b4fdab0762f1e490b778f7580de417caf4203dc0a6def6e'), ('15', '小吴爱学习', '147258', '小吴', '1252078414@qq.com', '15927287429', '湖北', '1', 'b202bfa3e225466c95fcbfc931ebf835dcf21765bf5446a39e289693173cb36c'), ('16', '肥肥月', '147258', 'xcy', '1102451184@qq.com', '15607123653', ' 武汉纺织大学', '1', 'f57d4aa9734844e6a1c0705afd092715fe6955c08a4f48589f7a355d4dba3dee'), ('17', '24811', '248113004', '吴恒', '248113004@qq.com', '18827552515', 'www.', '1', '8d5453be2f314b3a9a7f950e2b645161138b38e0862d4011b558f019a17578dc'), ('18', '123', '147258', '', '1252078414@qq.com', '', '', '1', null), ('19', '王文超', '147258', '', '1252078414@qq.com', '', '', '1', null), ('20', '1234', '147258', '', '1102451184@qq.com', '', '', '1', null), ('21', '111', '111111', '1111', '1252078414@qq.com', '1111', '111', '0', '834df0b0b7ec41f4ae4969c9292b8be32aa2f339c9244094b5d9afba4b871b64'), ('22', '1112', '111111', '111', '1252078414@qq.com', '1111', '111', '0', 'eb24eb6a0d7e478b80085aa361b366b8bc5858ac45a041d39cc6fae15763b1cc'), ('23', '2486761144', 'LLF19960519', '', '2486761144@qq.com', '', '', '0', '9b5dd62a99094fc5adb57034c14ef9ff1c365c601dba443988f3d2272cff7fe1'), ('24', '11111', '222222', '', '1252078414@qq.com', '', '', '0', '6c7b5d3f51a347f289e28c0a5737d6436db602a0bdd34bbba6765651bd3bbbba'), ('25', 'zzz', '123456', '', '870343780@qq.com', '', '', '0', 'd2279d12ee5f426c94c4a4e350d70d735ebc67a83d444d4ca60b25d504df7767'), ('26', '1111', '111111', '', '1252078414@qq.com', '', '', '0', 'cd5035be48c64d4a9b7f42f3c001e7340ce184930c764a2e8fa081ff57217586'), ('27', '222', '111111', '', '1252078414@qq.com', '15927287429', '', '0', '349b89f758fd48238fabef7e4e11b91f9254e0d316654ed0a7348315eb31bcb7'), ('28', '11233', '111111', '', '1252078414@qq.com', '15927287429', '', '1', null), ('29', '213311', '222222', '111', '2634230985@qq.com', '15927287429', '', '0', 'a39835cf74f44aeaab5ad665c80fe4b1d0db5b6b3efa4cb9a82792b727ad9568'), ('30', 'NNNN', 'NNNNNN', '111', '2634230985@qq.com', '15927287429', '', '0', 'a1801b1a35ca40fa8dc7e8c283be5140c44df573f9624150a4ebc43f3f7b032c'), ('31', '1114432', '147258', '1112', '1252078414@qq.com', '15927287429', '', '0', 'ac3f675c090a468eb8c861d015d173b55062274ad53d46129dab79d36c5fdd0d'), ('32', '12151', '147258', '147258', '2634230985@qq.com', '15927287429', '', '0', '6547ce2775b14dc1af17be2514aee7221550b7e068a244fbac3047aae114d53c'), ('33', '1111112', '1111111', '111', '1252078414@qq.com', '15927287429', '', '1', null), ('34', 'zhang', '123456', '??', '632023455@qq.com', '18895359951', '123123123', '0', 'fff9d52721b446cf83ad22b3e2581572e04feab32c854bed894a1a78e9e49310'), ('35', 'zhang123', '123456', 'zhangsan', '632023455@qq.com', '18895359951', 'anhui', '0', '24e35ef956174500bdc437d1a791b26296fb66eb5e09436aaf926487a6c44037'), ('36', 'zhangsan', '123456', 'zhang', '632023454@qq.com', '18895359951', 'anhui', '1', null), ('37', 'xiao', '123456', 'xxx', 'xxx@qq.com', '13819995468', 'nj', '0', '52cf85c870674b23addbd704e5cacbfc209ce708273e4e2194ff8f9e4f347179'), ('38', 'xiao1', '123123', 'xxx', 'xxx@qq.com', '13819995468', 'sdfs', '0', 'acc11996a5d94a6996a66f89367a5581a80253575a9949cdbd41addbb5057796'), ('39', '11111111', '111111', 'qqq', '1252078414@qq.com', '15927287429', '111', '1', null), ('40', 'xxxx', '111111', 'xxx', 'xxx@qq.com', '13565498567', 'sdfs', '0', 'dc4de16ebac34b5f92b49fb8d786592d4f13963c67ce41ab8f74b60e8fc1b462'), ('41', 'xxxxxx', '111111', 'xxx', '739014607@qq.com', '13819995468', 'sdfs', '1', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
