CREATE DATABASE  IF NOT EXISTS `tiw2223`;
USE `tiw2223`;

DROP TABLE IF EXISTS `disco`;
CREATE TABLE `disco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `interprete` varchar(45) NOT NULL,
  `anyo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3;

LOCK TABLES `disco` WRITE;
INSERT INTO `disco` VALUES (1,'asdf1','asdf1',2000),(2,'asdf2','asdf2',2001);
UNLOCK TABLES;
