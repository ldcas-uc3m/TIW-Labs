CREATE DATABASE IF NOT EXISTS `usersdb`;
USE `usersdb`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `idusers` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


LOCK TABLES `users` WRITE;
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (1, 'Waylon', 'Dalton');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (2, 'Justine', 'Henderson');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (3, 'Abdullah', 'Lang');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (4, 'Marcus', 'Cruz');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (5, 'Thalia', 'Cobb');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (6, 'Mathias', 'Little');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (7, 'Eddie', 'Randolph');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (8, 'Angela', 'Walker');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (9, 'Lia', 'Shelton');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (10, 'Hadassah', 'Hartman');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (11, 'Joanna', 'Shaffer');
INSERT INTO `users` (`idusers`, `name`, `surname`) VALUES (12, 'Jonathon', 'Sheppard');

UNLOCK TABLES;