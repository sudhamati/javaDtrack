-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: drivetracker
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `drive`
--

DROP TABLE IF EXISTS `drive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive` (
  `DID` int(11) NOT NULL AUTO_INCREMENT,
  `COMPANY_NAME` varchar(45) DEFAULT NULL,
  `NO_OF_RSRES` int(11) DEFAULT NULL,
  `EXP_REQ` tinyint(4) DEFAULT NULL,
  `CTC` float DEFAULT NULL,
  `JOINT_CRT` tinyint(4) DEFAULT NULL,
  `BOND` float DEFAULT NULL,
  `POSITION` tinyint(4) DEFAULT NULL,
  `FOLLOW_UP_DATE` date DEFAULT NULL,
  `EDU_CRT` tinyint(4) DEFAULT NULL,
  `CUR_STATUS` tinyint(4) DEFAULT NULL,
  `NXT_ACT` tinyint(4) DEFAULT NULL,
  `NXT_DATE` timestamp NULL DEFAULT NULL,
  `PS_YR-REQ` int(11) DEFAULT NULL,
  `GAP_REQ` tinyint(4) DEFAULT NULL,
  `CREATION_DATE` date DEFAULT NULL,
  `TPOID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DID`),
  UNIQUE KEY `DID_UNIQUE` (`DID`),
  KEY `TPOID_idx` (`TPOID`),
  CONSTRAINT `TPOID` FOREIGN KEY (`TPOID`) REFERENCES `tpo` (`TPOID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive`
--

LOCK TABLES `drive` WRITE;
/*!40000 ALTER TABLE `drive` DISABLE KEYS */;
INSERT INTO `drive` VALUES (2,'Amdocs',2,0,300000,0,1,1,'2019-03-19',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Tcs',8,0,500000,1,2,2,'2019-06-21',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'cognizant',5,1,300000,0,1,0,'2017-02-11',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'wipro',10,0,250000,1,1.5,2,'2019-09-09',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'Accenture',18,0,450000,1,2,2,'2017-09-12',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'ThinkQutient',2,1,250000,1,2,1,'2019-12-12',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'Persistant',6,1,200000,0,3,1,'2018-05-05',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'SystemPlus',15,0,300000,1,2.5,0,'2019-04-11',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'Infosys',1,0,20000,0,2,2,'2017-05-09',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'infotech',2,1,300000,0,1,0,'2019-01-01',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'synechron',2,1,300000,0,1,0,'2019-01-01',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'WWW',6,3,5,0,3,1,'2020-01-01',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `drive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_stud_track`
--

DROP TABLE IF EXISTS `drive_stud_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive_stud_track` (
  `DSR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DIDD` int(11) DEFAULT NULL,
  `STID` int(11) DEFAULT NULL,
  `TPO_IDD` int(11) DEFAULT NULL,
  `SURVIVED_STATUS` tinyint(4) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`DSR_ID`),
  KEY `TPO_IDD_idx` (`TPO_IDD`),
  CONSTRAINT `TPO_IDD` FOREIGN KEY (`TPO_IDD`) REFERENCES `tpo` (`TPOID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_stud_track`
--

LOCK TABLES `drive_stud_track` WRITE;
/*!40000 ALTER TABLE `drive_stud_track` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_stud_track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_student`
--

DROP TABLE IF EXISTS `drive_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive_student` (
  `DSID` int(11) NOT NULL,
  `DID` int(11) DEFAULT NULL,
  `STID` int(11) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `TPO_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DSID`),
  UNIQUE KEY `DSID_UNIQUE` (`DSID`),
  KEY `TPOID_idx` (`TPO_ID`),
  KEY `TPO_ID_idx` (`TPO_ID`),
  CONSTRAINT `TPO_ID` FOREIGN KEY (`TPO_ID`) REFERENCES `tpo` (`TPOID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_student`
--

LOCK TABLES `drive_student` WRITE;
/*!40000 ALTER TABLE `drive_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_track`
--

DROP TABLE IF EXISTS `drive_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive_track` (
  `TR_ID` int(11) NOT NULL,
  `DID_ID` int(11) DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `TPO_IDII` int(11) DEFAULT NULL,
  `REMARK` varchar(45) DEFAULT NULL,
  `NO_OF_STUDENT` int(11) DEFAULT NULL,
  PRIMARY KEY (`TR_ID`),
  KEY `TPO_ID_idx` (`TPO_IDII`),
  CONSTRAINT `TPO_IDII` FOREIGN KEY (`TPO_IDII`) REFERENCES `tpo` (`TPOID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_track`
--

LOCK TABLES `drive_track` WRITE;
/*!40000 ALTER TABLE `drive_track` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `Country` varchar(45) DEFAULT NULL,
  `MobileNo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (1,'sudha','12345','sudha@gmail.com','female','India','8888888888'),(2,'radha','1111','radha@gmail.com','female','USA','1111111111'),(3,'samy','0902','samy@gmail.com','male','Germany','2222222222'),(4,'Ansh','12345','a@gmail.com','female','India','1234567890');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tpo`
--

DROP TABLE IF EXISTS `tpo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tpo` (
  `TPOID` int(11) NOT NULL,
  `TPO_NAME` varchar(45) DEFAULT NULL,
  `TPO_EMAIL` varchar(45) DEFAULT NULL,
  `TPO_USERNAME` varchar(45) DEFAULT NULL,
  `TPO_PASSWORD` varchar(45) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `ROLE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`TPOID`),
  UNIQUE KEY `TPOID_UNIQUE` (`TPOID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tpo`
--

LOCK TABLES `tpo` WRITE;
/*!40000 ALTER TABLE `tpo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tpo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-28 11:37:38
