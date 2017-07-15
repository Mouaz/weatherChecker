-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.17-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema weatherchecker
--

CREATE DATABASE IF NOT EXISTS weatherchecker;
USE weatherchecker;

--
-- Definition of table `default_table`
--

DROP TABLE IF EXISTS `default_table`;
CREATE TABLE `default_table` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `min_value` int(11) DEFAULT NULL,
  `max_value` int(11) DEFAULT NULL,
  `text` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `default_table`
--

/*!40000 ALTER TABLE `default_table` DISABLE KEYS */;
INSERT INTO `default_table` (`id`,`min_value`,`max_value`,`text`) VALUES 
 (1,1,10,'30 min latency is allowed'),
 (2,10,15,'15 min latency is allowed '),
 (3,15,20,'5 min latency is allowed'),
 (4,20,9999999,'no latency,nice day');
/*!40000 ALTER TABLE `default_table` ENABLE KEYS */;


--
-- Definition of table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `date` date NOT NULL,
  `text` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `TABLE_NOTE_WEATHER_FK` (`date`),
  KEY `TABLE_NOTE_USER_FK` (`user_id`),
  CONSTRAINT `TABLE_NOTE_USER_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `email` varchar(500) NOT NULL,
  `password` varchar(500) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `EMAIL_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`name`,`email`,`password`,`isAdmin`) VALUES 
 (1,'admin','admin@admin.com','admin',1),
 (2,'user','user@user.com','user',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `weather_day`
--

DROP TABLE IF EXISTS `weather_day`;
CREATE TABLE `weather_day` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `value` int(11) DEFAULT NULL,
  `source` varchar(50) NOT NULL,
  `min_value` int(11) NOT NULL,
  `max_value` int(11) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
    UNIQUE KEY `date_UNIQUE` (`date`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
