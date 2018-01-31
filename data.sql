SET FOREIGN_KEY_CHECKS=0;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,NULL,'via roma 1',NULL,'20090','cesano boscone','IT'),(2,NULL,'piazza garibaldi 1',NULL,'20090','corsico','IT'),(3,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(4,NULL,'via filippo lippi 1',NULL,'20180','roma','AA'),(5,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(6,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(7,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(8,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(9,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(10,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(11,NULL,'via filippo lippi 1',NULL,'20180','roma','IT'),(12,'','via filippo lippi 1','','20180','roma','IT'),(13,'','via filippo lippi 1','','20180','roma','IT'),(14,'','via filippo lippi 1','','20180','roma','IT'),(15,'','via filippo lippi 1','','20180','roma','IT'),(16,'','via filippo lippi 1','','20180','roma','IT'),(17,'','via filippo lippi 1','','20180','roma','IT'),(18,'','via filippo lippi 1','','20180','roma','FR'),(19,'','via filippo lippi 1','','20180','roma','IT'),(20,'','via filippo lippi 1','','20180','roma','FR');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `base_product`
--

LOCK TABLES `base_product` WRITE;
/*!40000 ALTER TABLE `base_product` DISABLE KEYS */;
INSERT INTO `base_product` VALUES ('0000000001','IPhone X','Da sempre immaginiamo un iPhone fatto di solo schermo. Un oggetto così coinvolgente che ti fa immergere in quello che vedi. E così intelligente che sa rispondere a un tuo tocco, a una parola, persino a uno sguardo. Con iPhone X quella visione diventa realtà. E il futuro può cominciare.','2017-07-01 00:00:00','2999-12-31 00:00:00'),('0000000002','IPhone 8','Splendida intelligenza.Per iPhone 8 abbiamo creato un inedito design in vetro, una versione evoluta della fotocamera più amata al mondo, e il chip più potente e intelligente che uno smartphone abbia mai avuto. Gli abbiamo dato la semplicità della ricarica wireless e tecnologie di realtà aumentata mai viste prima. Ecco iPhone 8: una nuova generazione di iPhone.','2017-07-01 00:00:00','2999-12-31 00:00:00'),('00087','prodotto base 00087','bel prodotto base 00087','2017-12-01 00:01:47','2999-12-31 23:59:47'),('807869293','Sandalo in camoscio con cristalli','Caratterizzato da una silhouette sottile ed elegante, questo sandalo in camoscio rosa peonia chiaro è impreziosito da file di cristalli dello stesso colore che ornano i listini frontali e il retro. La fodera in pelle con stampa floreale e la suola rosa in cuoio definiscono le scarpe della collezione Autunno Inverno 2017.','2017-03-01 00:00:00','2999-12-31 00:00:00');
/*!40000 ALTER TABLE `base_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,1,'fullmoda_it','2018-01-09 14:20:38','2018-01-09 14:20:38'),(2,2,'fullmoda_it','2018-01-09 14:20:38','2018-01-09 14:20:38'),(6,5,'fullmoda_it','2018-01-09 14:20:38','2018-01-09 14:20:38');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cart_entries`
--

LOCK TABLES `cart_entries` WRITE;
/*!40000 ALTER TABLE `cart_entries` DISABLE KEYS */;
INSERT INTO `cart_entries` VALUES (1,1,'000000000111',1),(2,1,'000000000211',1),(3,2,'000000000111',2),(8,6,'0007811',2),(9,6,'0007812',1);
/*!40000 ALTER TABLE `cart_entries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES ('adasd','fdkjs'),('aqua','#00FFFF'),('black','#000000'),('blue','#0000FF'),('fuchsia','#FF00FF'),('gray','#808080'),('green','#008000'),('lime','#00FF00'),('maroon','#800000'),('na','na'),('navy','#000080'),('olive','#808000'),('purple','#800080'),('red','#FF0000'),('silver','#C0C0C0'),('teal','#008080'),('white','#FFFFFF'),('yellow','#FFFF00');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `color_product`
--

LOCK TABLES `color_product` WRITE;
/*!40000 ALTER TABLE `color_product` DISABLE KEYS */;
INSERT INTO `color_product` VALUES ('00000000011','gray','0000000001'),('00000000021','gray','0000000002'),('000781','aqua','00087'),('000782','adasd','00087'),('8078692931','fuchsia','807869293');
/*!40000 ALTER TABLE `color_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('AA','AA'),('FR','Francia'),('IT','ITALIA'),('UK','GREAT BRITAIN'),('US','UNITED STATES');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES ('EUR','€','IT',2,1),('GBP','£','UK',2,0),('USD','$','US',2,0);
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES ('de','de'),('en_GB','gb'),('en_US','us'),('es','es'),('fr','fr'),('it_IT','it');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,2160,'2017-12-18 18:34:00',1,2,'transfer'),(2,2,1280,'2017-12-18 19:34:00',1,1,'paypal'),(3,6,10000,'2018-01-05 09:23:32',18,18,'creditcard');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('creditcard','carta di credito'),('paypal','paypal'),('transfer','bonifico bancario');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1280,'EUR','0000000001'),(880,'EUR','0000000002'),(123.34,'EUR','00087'),(980,'EUR','807869293'),(980,'GBP','0000000001'),(800,'GBP','0000000002'),(1130,'USD','0000000001'),(780,'USD','0000000002'),(100.34,'USD','00087');
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES ('no_size'),('s_36'),('s_37'),('s_38'),('s_39'),('s_40'),('s_41'),('s_42');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `size_product`
--

LOCK TABLES `size_product` WRITE;
/*!40000 ALTER TABLE `size_product` DISABLE KEYS */;
INSERT INTO `size_product` VALUES ('000000000111','00000000011','s_36'),('000000000211','00000000021','s_37'),('0007811','000781','s_36'),('0007812','000781','s_37'),('0007821','000782','s_38'),('0007822','000782','s_39'),('80786929311','8078692931','s_36'),('80786929312','8078692931','s_37'),('80786929313','8078692931','s_38'),('80786929314','8078692931','s_39'),('80786929315','8078692931','s_40');
/*!40000 ALTER TABLE `size_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `size_to_country`
--

LOCK TABLES `size_to_country` WRITE;
/*!40000 ALTER TABLE `size_to_country` DISABLE KEYS */;
INSERT INTO `size_to_country` VALUES (9,'no_size','IT','NA'),(10,'no_size','UK','U'),(11,'no_size','US','U'),(12,'s_36','IT','36'),(13,'s_37','IT','37'),(14,'s_38','IT','38'),(15,'s_39','IT','39'),(16,'s_40','IT','40'),(17,'s_41','IT','41'),(18,'s_42','IT','42');
/*!40000 ALTER TABLE `size_to_country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `spring_session`
--

LOCK TABLES `spring_session` WRITE;
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
INSERT INTO `spring_session` VALUES ('f8f99528-42e6-4556-ae8f-7a234dd5fb6f',1517217811902,1517217831116,1800,NULL);
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `spring_session_attributes`
--

LOCK TABLES `spring_session_attributes` WRITE;
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
INSERT INTO `spring_session_attributes` VALUES ('f8f99528-42e6-4556-ae8f-7a234dd5fb6f','javax.servlet.jsp.jstl.fmt.request.charset','͜t\0UTF-8');
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES ('000000000111','warehouse_it',200,10),('000000000111','warehouse_uk',0,0),('000000000111','warehouse_us',2,1),('000000000211','warehouse_it',200,10),('000000000211','warehouse_uk',0,0),('000000000211','warehouse_us',2,1),('0007811','warehouse_it',100,0),('80786929311','warehouse_it',20,10),('80786929312','warehouse_it',2,2),('80786929313','warehouse_it',4,2),('80786929314','warehouse_it',10,0),('80786929315','warehouse_it',20,1);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sara','pirola','customer','sara.pirola@soprasteria.com','123456',NULL,NULL,NULL,NULL,1,NULL),(2,'luca','ghezzi','administrator','luca.ghezzi@soprasteria.com','123456',NULL,NULL,NULL,NULL,1,NULL),(5,'luigi','di maio','CUSTOMER','giggetto@yopmail.com','giggetto',18,'04908304593',NULL,NULL,1,NULL),(10,'sara','test','CUSTOMER','sara.test@soprasteria.com','123456',NULL,NULL,NULL,NULL,1,NULL),(15,'sss','ffff','CUSTOMER','awwer@yopmail.com','f',NULL,NULL,NULL,NULL,1,NULL),(17,'sara','test','CUSTOMER','sara.test2@soprasteria.com','123456',NULL,NULL,NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES ('warehouse_it','warehouse italia'),('warehouse_uk','warehouse great britain'),('warehouse_us','warehouse_us');
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `website`
--

LOCK TABLES `website` WRITE;
/*!40000 ALTER TABLE `website` DISABLE KEYS */;
INSERT INTO `website` VALUES ('fullmoda_it','it_IT');
/*!40000 ALTER TABLE `website` ENABLE KEYS */;
UNLOCK TABLES;


SET FOREIGN_KEY_CHECKS=1;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
