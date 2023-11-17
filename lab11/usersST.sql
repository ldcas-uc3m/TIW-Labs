CREATE DATABASE  IF NOT EXISTS `usersdbSP` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `usersdbSP`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `idaddress` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(45) NOT NULL,
  `postcode` int(6) DEFAULT NULL,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idaddress`),
  KEY `FK_Users_1` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `usersdbSP`.`user`
(`iduser`,
`name`,
`surname`)
VALUES
(1,'Frodo', 'Bolson'
);

INSERT INTO `usersdbSP`.`user`
(`iduser`,
`name`,
`surname`)
VALUES
(2,'Bilbo', 'Bolson'
);

INSERT INTO `usersdbSP`.`address`
(`idaddress`,
`street`,
`postcode`,
`iduser`)
VALUES
(1,
'HanburyST',
28014,
1);

INSERT INTO `usersdbSP`.`address`
(`idaddress`,
`street`,
`postcode`,
`iduser`)
VALUES
(2,
'Somewhere',
28017,
2);

