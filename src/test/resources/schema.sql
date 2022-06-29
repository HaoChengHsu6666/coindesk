CREATE TABLE `cryptocoin` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `name` char(32) NOT NULL COMMENT '加密貨幣名稱',
                              `code` char(8) NOT NULL COMMENT '加密貨幣代號',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `name_UNIQUE` (`name`)
);