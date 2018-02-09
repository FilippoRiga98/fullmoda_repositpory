-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: fullmoda
-- ------------------------------------------------------
-- Server version	5.6.37-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id_Address` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `line1` varchar(45) NOT NULL,
  `line2` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) NOT NULL,
  `town` varchar(45) NOT NULL,
  `country_code` varchar(45) NOT NULL,
  PRIMARY KEY (`id_Address`),
  KEY `address_to_country_idx` (`country_code`),
  CONSTRAINT `address_to_country` FOREIGN KEY (`country_code`) REFERENCES `country` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,NULL,'via roma 1',NULL,'20090','cesano boscone','IT'),(2,NULL,'piazza garibaldi 1',NULL,'20090','corsico','IT'),(3,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(4,NULL,'via filippo lippi 1',NULL,'20180','roma','AA'),(5,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(6,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(7,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(8,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(9,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(10,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(11,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(12,'','via filippo lippi 1','','20180','roma','IT'),(13,'','via filippo lippi 1','','20180','roma','IT'),(14,'','via filippo lippi 1','','20180','roma','IT'),(15,'','via filippo lippi 1','','20180','roma','IT'),(16,'','via filippo lippi 1','','20180','roma','IT'),(17,'','via filippo lippi 1','','20180','roma','IT'),(18,'','via filippo lippi 1','','20180','roma','FR'),(19,'','via filippo lippi 1','','20180','roma','IT'),(20,'','via filippo lippi 1','','20180','roma','FR');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_product`
--

DROP TABLE IF EXISTS `base_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_product` (
  `code` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `onlinedate` datetime NOT NULL,
  `offlinedate` datetime NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_product`
--

LOCK TABLES `base_product` WRITE;
/*!40000 ALTER TABLE `base_product` DISABLE KEYS */;
INSERT INTO `base_product` VALUES ('0000000001','IPhone X','Da sempre immaginiamo un iPhone fatto di solo schermo. Un oggetto cos√É¬¨ coinvolgente che ti fa immergere in quello che vedi. E cos√É¬¨ intelligente che sa rispondere a un tuo tocco, a una parola, persino a uno sguardo. Con iPhone X quella visione diventa realt√É¬†. E il futuro pu√É¬≤ cominciare.','2017-07-01 00:00:00','2999-12-31 00:00:00'),('0000000002','IPhone 8','Splendida intelligenza.Per iPhone 8 abbiamo creato un inedito design in vetro, una versione evoluta della fotocamera pi√É¬π amata al mondo, e il chip pi√É¬π potente e intelligente che uno smartphone abbia mai avuto. Gli abbiamo dato la semplicit√É¬† della ricarica wireless e tecnologie di realt√É¬† aumentata mai viste prima. Ecco iPhone 8: una nuova generazione di iPhone.','2017-07-01 00:00:00','2999-12-31 00:00:00'),('00087','prodotto base 00087','bel prodotto base 00087','2017-12-01 00:01:47','2999-12-31 23:59:47'),('807869293','Sandalo in camoscio con cristalli','Caratterizzato da una silhouette sottile ed elegante, questo sandalo in camoscio rosa peonia chiaro √É¬® impreziosito da file di cristalli dello stesso colore che ornano i listini frontali e il retro. La fodera in pelle con stampa floreale e la suola rosa in cuoio definiscono le scarpe della collezione Autunno Inverno 2017.','2017-03-01 00:00:00','2999-12-31 00:00:00');
/*!40000 ALTER TABLE `base_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `website` varchar(45) NOT NULL,
  `lastmodified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cart_id`),
  KEY `fk_Cart_user_idx` (`user`),
  KEY `fk_cart_website_idx` (`website`),
  CONSTRAINT `fk_Cart_user` FOREIGN KEY (`user`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_website` FOREIGN KEY (`website`) REFERENCES `website` (`website_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,1,'fullmoda_it','2018-01-09 14:20:38','2018-01-09 14:20:38'),(2,2,'fullmoda_it','2018-01-09 14:20:38','2018-01-09 14:20:38'),(6,5,'fullmoda_it','2018-01-09 14:20:38','2018-01-09 14:20:38');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_entries`
--

DROP TABLE IF EXISTS `cart_entries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_entries` (
  `idcart_entries` int(11) NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) NOT NULL,
  `product` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idcart_entries`),
  KEY `cart_entries_to_cart_idx` (`cart_id`),
  KEY `cart_entries_to_product_idx` (`product`),
  CONSTRAINT `cart_entries_to_cart` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cart_entries_to_product` FOREIGN KEY (`product`) REFERENCES `size_product` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_entries`
--

LOCK TABLES `cart_entries` WRITE;
/*!40000 ALTER TABLE `cart_entries` DISABLE KEYS */;
INSERT INTO `cart_entries` VALUES (1,1,'000000000111',1),(2,1,'000000000211',1),(3,2,'000000000111',2),(8,6,'0007811',2),(9,6,'0007812',1);
/*!40000 ALTER TABLE `cart_entries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `color` (
  `code` varchar(45) NOT NULL,
  `html_code` varchar(45) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES ('adasd','fdkjs'),('aqua','#00FFFF'),('black','#000000'),('blue','#0000FF'),('fuchsia','#FF00FF'),('gray','#808080'),('green','#008000'),('lime','#00FF00'),('maroon','#800000'),('na','na'),('navy','#000080'),('olive','#808000'),('purple','#800080'),('red','#FF0000'),('silver','#C0C0C0'),('teal','#008080'),('white','#FFFFFF'),('yellow','#FFFF00');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color_product`
--

DROP TABLE IF EXISTS `color_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `color_product` (
  `code` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `baseproduct` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `fk_product_color_idx` (`color`),
  KEY `fk_product_base_product_idx` (`baseproduct`),
  CONSTRAINT `fk_prodcut_to_color` FOREIGN KEY (`color`) REFERENCES `color` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_base_product` FOREIGN KEY (`baseproduct`) REFERENCES `base_product` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color_product`
--

LOCK TABLES `color_product` WRITE;
/*!40000 ALTER TABLE `color_product` DISABLE KEYS */;
INSERT INTO `color_product` VALUES ('00000000011','gray','0000000001'),('00000000021','gray','0000000002'),('000781','aqua','00087'),('000782','adasd','00087'),('8078692931','fuchsia','807869293');
/*!40000 ALTER TABLE `color_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('AA','AA'),('FR','Francia'),('IT','ITALIA'),('UK','GREAT BRITAIN'),('US','UNITED STATES');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `code` varchar(45) NOT NULL,
  `symbol` varchar(5) NOT NULL,
  `country` varchar(45) NOT NULL,
  `decimal` int(11) NOT NULL,
  `base` tinyint(1) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `curr_to_country_idx` (`country`),
  CONSTRAINT `curr_to_country` FOREIGN KEY (`country`) REFERENCES `country` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES ('EUR','√¢‚Äö¬¨','IT',2,1),('GBP','√Ç¬£','UK',2,0),('USD','$','US',2,0);
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `isocode` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`isocode`),
  UNIQUE KEY `code_UNIQUE` (`isocode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES ('de','de'),('en_GB','gb'),('en_US','us'),('es','es'),('fr','fr'),('it_IT','it');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) NOT NULL,
  `total_price` double NOT NULL,
  `order_date` datetime NOT NULL,
  `shipping_address` int(11) NOT NULL,
  `billing_address` int(11) NOT NULL,
  `payment_method` varchar(45) NOT NULL,
  PRIMARY KEY (`orderId`,`cart_id`,`shipping_address`,`billing_address`,`payment_method`),
  KEY `fk_Order_Carriage1_idx` (`cart_id`),
  KEY `fk_Shipping_Address_idx` (`shipping_address`),
  KEY `fk_billing_address_idx` (`billing_address`),
  KEY `fk_Order_payment_method_idx` (`payment_method`),
  CONSTRAINT `fk_Order_Cart` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Shipping_Address` FOREIGN KEY (`shipping_address`) REFERENCES `address` (`id_Address`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_billing_address` FOREIGN KEY (`billing_address`) REFERENCES `address` (`id_Address`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_payment_method` FOREIGN KEY (`payment_method`) REFERENCES `payment` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,2160,'2017-12-18 18:34:00',1,2,'transfer'),(2,2,1280,'2017-12-18 19:34:00',1,1,'paypal'),(3,6,10000,'2018-01-05 09:23:32',18,18,'creditcard');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_token`
--

DROP TABLE IF EXISTS `password_reset_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `password_reset_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(64) NOT NULL,
  `expiry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `token_UNIQUE` (`token`),
  KEY `fk_user_fullmoda.user_idx` (`user_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_token`
--

LOCK TABLES `password_reset_token` WRITE;
/*!40000 ALTER TABLE `password_reset_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_reset_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('creditcard','carta di credito'),('paypal','paypal'),('transfer','bonifico bancario');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(100) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
INSERT INTO `persistent_logins` VALUES ('sara.test@soprasteria.com','ecwErYJ+Dc2xyx5s/HXbiA==','5GmxxVcRQwOIR1Moy+G1Dg==','2018-02-06 10:23:26');
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price` (
  `value` double NOT NULL,
  `currency` varchar(45) NOT NULL,
  `product` varchar(45) NOT NULL,
  PRIMARY KEY (`currency`,`product`),
  KEY `fk_Price_Currency1_idx` (`currency`),
  KEY `fk_price_product_idx` (`product`),
  CONSTRAINT `fk_Price_Currency1` FOREIGN KEY (`currency`) REFERENCES `currency` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_price_product` FOREIGN KEY (`product`) REFERENCES `base_product` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1280,'EUR','0000000001'),(880,'EUR','0000000002'),(123.34,'EUR','00087'),(980,'EUR','807869293'),(980,'GBP','0000000001'),(800,'GBP','0000000002'),(1130,'USD','0000000001'),(780,'USD','0000000002'),(100.34,'USD','00087');
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `size` (
  `code` varchar(10) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES ('no_size'),('s_36'),('s_37'),('s_38'),('s_39'),('s_40'),('s_41'),('s_42');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size_product`
--

DROP TABLE IF EXISTS `size_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `size_product` (
  `code` varchar(45) NOT NULL,
  `baseproduct` varchar(45) NOT NULL,
  `size` varchar(10) NOT NULL,
  PRIMARY KEY (`code`),
  KEY `fk_size_to_size_idx` (`size`),
  KEY `fk_size_to_baseproduct_idx` (`baseproduct`),
  CONSTRAINT `fk_size_to_baseproduct` FOREIGN KEY (`baseproduct`) REFERENCES `color_product` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_size_to_size` FOREIGN KEY (`size`) REFERENCES `size` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size_product`
--

LOCK TABLES `size_product` WRITE;
/*!40000 ALTER TABLE `size_product` DISABLE KEYS */;
INSERT INTO `size_product` VALUES ('000000000111','00000000011','s_36'),('000000000211','00000000021','s_37'),('0007811','000781','s_36'),('0007812','000781','s_37'),('0007821','000782','s_38'),('0007822','000782','s_39'),('80786929311','8078692931','s_36'),('80786929312','8078692931','s_37'),('80786929313','8078692931','s_38'),('80786929314','8078692931','s_39'),('80786929315','8078692931','s_40');
/*!40000 ALTER TABLE `size_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size_to_country`
--

DROP TABLE IF EXISTS `size_to_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `size_to_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(10) NOT NULL,
  `country` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sizerow_to_size_idx` (`size`),
  KEY `sizecountry_to_county_idx` (`country`),
  CONSTRAINT `sizecountry_to_county` FOREIGN KEY (`country`) REFERENCES `country` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sizecountry_to_size` FOREIGN KEY (`size`) REFERENCES `size` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size_to_country`
--

LOCK TABLES `size_to_country` WRITE;
/*!40000 ALTER TABLE `size_to_country` DISABLE KEYS */;
INSERT INTO `size_to_country` VALUES (9,'no_size','IT','NA'),(10,'no_size','UK','U'),(11,'no_size','US','U'),(12,'s_36','IT','36'),(13,'s_37','IT','37'),(14,'s_38','IT','38'),(15,'s_39','IT','39'),(16,'s_40','IT','40'),(17,'s_41','IT','41'),(18,'s_42','IT','42');
/*!40000 ALTER TABLE `size_to_country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spring_session`
--

DROP TABLE IF EXISTS `spring_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spring_session` (
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`SESSION_ID`),
  KEY `SPRING_SESSION_IX1` (`LAST_ACCESS_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_session`
--

LOCK TABLES `spring_session` WRITE;
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
INSERT INTO `spring_session` VALUES ('2bd15b7b-c035-44ca-acc7-e3279145c7b0',1517912606199,1517912642216,1800,'sara.test@soprasteria.com');
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spring_session_attributes`
--

DROP TABLE IF EXISTS `spring_session_attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spring_session_attributes` (
  `SESSION_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_ID`,`ATTRIBUTE_NAME`),
  KEY `SPRING_SESSION_ATTRIBUTES_IX1` (`SESSION_ID`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_ID`) REFERENCES `spring_session` (`SESSION_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_session_attributes`
--

LOCK TABLES `spring_session_attributes` WRITE;
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
INSERT INTO `spring_session_attributes` VALUES ('2bd15b7b-c035-44ca-acc7-e3279145c7b0','javax.servlet.jsp.jstl.fmt.request.charset','¨\Ì\0t\0UTF-8'),('2bd15b7b-c035-44ca-acc7-e3279145c7b0','org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN','¨\Ì\0sr\06org.springframework.security.web.csrf.DefaultCsrfTokenZ\Ô∑\»/¢˚\’\0L\0\nheaderNamet\0Ljava/lang/String;L\0\rparameterNameq\0~\0L\0tokenq\0~\0xpt\0X-CSRF-TOKENt\0_csrft\0$ce3b9a57-c62a-415a-b11b-a9fec8086b6f'),('2bd15b7b-c035-44ca-acc7-e3279145c7b0','SPRING_SECURITY_CONTEXT','¨\Ì\0sr\0=org.springframework.security.core.context.SecurityContextImpl\0\0\0\0\0\0§\0L\0authenticationt\02Lorg/springframework/security/core/Authentication;xpsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0§\0L\0credentialst\0Ljava/lang/Object;L\0	principalq\0~\0xr\0Gorg.springframework.security.authentication.AbstractAuthenticationToken”™(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailsq\0~\0xpsr\0&java.util.Collections$UnmodifiableList¸%1µ\Ïé\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0Ä\À^˜\0L\0cq\0~\0xpsr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0§\0L\0rolet\0Ljava/lang/String;xpt\0CUSTOMERxq\0~\0\rsr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0§\0L\0\rremoteAddressq\0~\0L\0	sessionIdq\0~\0xpt\00:0:0:0:0:0:0:1t\0$c344e95f-811f-4391-86b2-7c1c4247ef48psr\0\"it.sopra.stage.fullmoda.model.User\04ı	\¬HÒ\0Z\0privacyAgreementL\0addresst\0\'Lit/sopra/stage/fullmoda/model/Address;L\0	birthDatet\0Ljava/util/Date;L\0\nbirthPlaceq\0~\0L\0customerTypeq\0~\0L\0emailq\0~\0L\0\nfiscalCodeq\0~\0L\0idt\0Ljava/lang/Long;L\0nameq\0~\0L\0passwordq\0~\0L\0phoneNumberq\0~\0L\0surnameq\0~\0xppppq\0~\0t\0sara.test@soprasteria.compsr\0java.lang.Long;ã\‰êÃè#\ﬂ\0J\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0\0\0\0\0t\0Sarat\0<$2a$10$3CNOpcG65npK./NxbU5RA.ZqY0RtootUuF0XyyvFRwekxUUJZenxmpt\0Test');
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `product` varchar(45) NOT NULL,
  `warehouse` varchar(45) NOT NULL,
  `available` int(11) NOT NULL DEFAULT '0',
  `reserved` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product`,`warehouse`),
  KEY `fk_Product_has_Warehouse_Warehouse1_idx` (`warehouse`),
  KEY `fk_Product_has_Warehouse_Product1_idx` (`product`),
  CONSTRAINT `fk_Product_has_Warehouse_Product1` FOREIGN KEY (`product`) REFERENCES `size_product` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_has_Warehouse_Warehouse1` FOREIGN KEY (`warehouse`) REFERENCES `warehouse` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES ('000000000111','warehouse_it',200,10),('000000000111','warehouse_uk',0,0),('000000000111','warehouse_us',2,1),('000000000211','warehouse_it',200,10),('000000000211','warehouse_uk',0,0),('000000000211','warehouse_us',2,1),('0007811','warehouse_it',100,0),('80786929311','warehouse_it',20,10),('80786929312','warehouse_it',2,2),('80786929313','warehouse_it',4,2),('80786929314','warehouse_it',10,0),('80786929315','warehouse_it',20,1);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `address` int(11) DEFAULT NULL,
  `phonenumber` varchar(45) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `birthplace` varchar(45) DEFAULT NULL,
  `privacy_agreement` tinyint(1) NOT NULL,
  `fiscalcode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `fiscalcode_UNIQUE` (`fiscalcode`),
  KEY `fk_User_Address_idx` (`address`),
  CONSTRAINT `fk_User_Address` FOREIGN KEY (`address`) REFERENCES `address` (`id_Address`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sara','pirola','customer','sara.pirola@soprasteria.com','$2a$10$wS.42dGff2aMYa6hwIKea.LJnCdHj4NLlfsTtsT.11S/JyEUIJBxW',NULL,NULL,NULL,NULL,1,NULL),(2,'luca','ghezzi','administrator','luca.ghezzi@soprasteria.com','$2a$10$qjq4u.QXpsQ9elrXmPlOxOLvfYRi2BIM20EF4UrsFfri3bhMWq63e',NULL,NULL,NULL,NULL,1,NULL),(5,'luigi','di maio','CUSTOMER','giggetto@yopmail.com','$2a$10$VpmdMVAkpI8Z4QirSLQid.U0wJJ4ZaMljNsATte8BhDffXWoiU7Cq',18,'04908304593',NULL,NULL,1,NULL),(17,'sara','test','CUSTOMER','sara.test2@soprasteria.com','$2a$10$KUpdE8AYPbzT9pVRxONFf.isXS90NzgS7LsWdzb/.TGkoxZVW.gy6',NULL,NULL,NULL,NULL,1,NULL),(20,'Sara','Test','CUSTOMER','sara.test@soprasteria.com','$2a$10$3CNOpcG65npK./NxbU5RA.ZqY0RtootUuF0XyyvFRwekxUUJZenxm',NULL,NULL,NULL,NULL,1,NULL),(21,'Filippo','Rigamonti','CUSTOMER','filippo.rigamonti@soprasteria.com','$2a$10$83sE/jk/j2DJJJT9NrRADe5obZoUZ7tPQsJLLkRCAJ6tf2yRwPkj2',NULL,NULL,NULL,NULL,1,NULL),(29,'Test','Test','CUSTOMER','test@soprasteria.com','$2a$10$3tdpqS2PRpFGooSvhdoyyerQbr.7bfCpiWdHhU04EPVyTvlazktNK',NULL,NULL,NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse` (
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `id_Warehouse_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES ('warehouse_it','warehouse italia'),('warehouse_uk','warehouse great britain'),('warehouse_us','warehouse_us');
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `website`
--

DROP TABLE IF EXISTS `website`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `website` (
  `website_id` varchar(45) NOT NULL,
  `language` varchar(45) NOT NULL,
  PRIMARY KEY (`website_id`),
  UNIQUE KEY `id_website_UNIQUE` (`website_id`),
  KEY `website_to_lang_idx` (`language`),
  CONSTRAINT `website_to_lang` FOREIGN KEY (`language`) REFERENCES `language` (`isocode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `website`
--

LOCK TABLES `website` WRITE;
/*!40000 ALTER TABLE `website` DISABLE KEYS */;
INSERT INTO `website` VALUES ('fullmoda_it','it_IT');
/*!40000 ALTER TABLE `website` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-06 11:34:11
