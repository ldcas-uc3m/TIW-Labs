use bbddimagenes;

create table IMAGENENBBDD(
id_imagen INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
titulo varchar(100) NOT NULL DEFAULT "sin titulo",
imagen LONGBLOB NOT NULL);

create table IMAGENENSFF(
id_imagen INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
titulo varchar(100) NOT NULL DEFAULT "sin titulo",
imagen varchar(100) NOT NULL);