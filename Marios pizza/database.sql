-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: mariospizza
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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `Order_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Pizza_ID_FK` int(11) NOT NULL,
  `Is_Active` tinyint(1) NOT NULL DEFAULT '1',
  `Customer_ID` int(11) NOT NULL,
  `Order_Time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Order_ID`),
  KEY `Pizza_ID_FK` (`Pizza_ID_FK`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Pizza_ID_FK`) REFERENCES `pizza` (`Pizza_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (63,3,1,2,'15:40'),(64,3,1,2,'15:40'),(65,3,1,2,'15:40');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pizza` (
  `Pizza_ID` int(11) NOT NULL,
  `Pizza_Name` varchar(20) NOT NULL,
  `Pizza_Topping` varchar(100) NOT NULL,
  `Pizza_Price` double NOT NULL,
  PRIMARY KEY (`Pizza_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza`
--

LOCK TABLES `pizza` WRITE;
/*!40000 ALTER TABLE `pizza` DISABLE KEYS */;
INSERT INTO `pizza` VALUES (1,'Visuvio','Tomatsauce, ost, skinke og oregano',57),(2,'Amerikaner','Tomatsauce, ost, oksefars og oregano',53),(3,'Cacciatore','Tomatsauce, ost, pepperoni og oregano',57),(4,'Carbona','Tomatsauce, ost, kødsauce, spaghetti, coctailpølser og oregano',63),(5,'Dennis','Tomatsauce, ost, skinke, pepperoni, coctailpølser og oregano',65),(6,'Bertil','Tomatsauce, ost, bacon og oregano',57),(7,'Silvia','Tomatsauce, ost, pepperoni, rød peber,løg, oliven og oregano',61),(8,'Victoria','Tomatsauce, ost, skinke, ananas, champignon, løg og oregano',61),(9,'Toronfo','Tomatsauce, ost, skinke, bacon, kebab, chili og oregano',61),(10,'Capricciosa','Tomatsauce, ost, skinke, champignon og oregano',61),(11,'Hawai',' Tomatsauce, ost, skinke, champignon og oregano',61),(12,'Le Blissola','Tomatsauce, ost skinke, rejer og oregano',61),(13,'Venezia','Tomatsauce, ost, skinke, bacon og oregano',61),(14,'Mafia','Tomatsauce, ost, pepperoni, bacon, løg og oregano',61);
/*!40000 ALTER TABLE `pizza` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-14 12:46:52
