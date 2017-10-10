CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `contact` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `customer` VALUES ('1', 'customer1', 'Jack', '1234556789', 'javk@email.com', null);
INSERT INTO `customer` VALUES ('2', 'customer2', 'Rose', '1233123132', 'rose@email.com', null);