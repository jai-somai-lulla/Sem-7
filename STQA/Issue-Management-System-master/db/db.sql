-- MySQL dump 10.15  Distrib 10.0.29-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 64.62.211.131    Database: 64.62.211.131
-- ------------------------------------------------------
-- Server version	5.6.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issue` (
  `UID` varchar(32) DEFAULT NULL,
  `Title` varchar(32) DEFAULT NULL,
  `Description` varchar(32) DEFAULT NULL,
  `Subject` varchar(32) DEFAULT NULL,
  `IID` int(11) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`IID`),
  KEY `UID` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` VALUES (NULL,NULL,NULL,NULL,2,NULL,NULL,NULL),(NULL,NULL,NULL,NULL,3,NULL,NULL,NULL),('U1510325','all','all','ISEE',7,999,'2017-09-04','Approved'),('U1510999','Econmoics','Simple and compund intrest','ISEE',1234,56,'2017-09-04','Awaiting approval'),('U1510232','JDBC','Connectivity','DBMS',11321,98,'2017-09-03','Awaiting approval'),('U1510532','PDA','States and transitions','TOC',35321,58,'2017-08-03','Awaiting approval'),('U1510783','Testing','Blackbox and whitebox','SEPM',56421,28,'2017-09-01','Solved');
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `password` char(15) DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `uname` varchar(32) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('qw','Admin','Saurabh',NULL),('onkar','Admin','Onkar',NULL),('admin','Admin','admin',NULL),('admin','Student','jai',NULL),('password','Student','U1510999',NULL),('password','Student','U1510232',NULL),('password','Student','U1510532',NULL),('password','Student','U1510783',NULL),('onkar','Student','ok1','C:\\userimages\\IMG-20161010-WA0001.jpg'),('1234','Student','mrunal','C:\\userimages\\IMG-20150707-WA0005.jpg'),('1234','Student','csd','C:\\userimages\\IMG-20160410-WA0016.jpg'),('1234','Student','chetan','C:\\userimages\\IMG-20170509-WA0019.jpg');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uinfo`
--

DROP TABLE IF EXISTS `uinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uinfo` (
  `uid` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobileno` varchar(10) DEFAULT NULL,
  `class` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `pass` varchar(10) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uinfo`
--

LOCK TABLES `uinfo` WRITE;
/*!40000 ALTER TABLE `uinfo` DISABLE KEYS */;
INSERT INTO `uinfo` VALUES ('Onkar1','onkarkulkarni5404@gmail.com','8007780943','SEA','Student','Onkar',NULL),('ok','onkarkulkarni5404@gmail.com','8007780943','TEA','Student','Onkar',NULL),('girish','girishb98@gmail.com','9664378768','TEA','Student','1234',NULL),('ok1','onkarkulkarni5404@gmail.com','8007780943','TEA','Student','onkar','C:\\userimages\\IMG-20161010-WA0001.jpg'),('mrunal','mrunalkolhe2011@gmail.com','9403816542','TEs','Student','1234','C:\\userimages\\IMG-20150707-WA0005.jpg'),('csd','csdeshpande19@gmail.com','7066529249','Te-C','Student','1234','C:\\userimages\\IMG-20160410-WA0016.jpg'),('chetan','chetanchauhan9762@gmail.com','9762822291','Te-a','Student','1234','C:\\userimages\\IMG-20170509-WA0019.jpg');
/*!40000 ALTER TABLE `uinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote` (
  `IID` int(11) NOT NULL,
  `UID` varchar(32) NOT NULL,
  `up_down` int(11) DEFAULT NULL,
  PRIMARY KEY (`IID`,`UID`),
  KEY `UID` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-11  9:49:44

