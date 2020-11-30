-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: Examen Backend CashOnline
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan` (
  `loan_id` int NOT NULL AUTO_INCREMENT,
  `total` decimal(16,2) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`loan_id`),
  KEY `loan_user_fk_idx` (`user_id`),
  CONSTRAINT `loan_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES (1,2500.00,1),(2,150.00,3),(3,180.00,1),(5,918.48,71),(6,918.48,71),(7,432.84,7),(8,877.12,40),(9,761.97,99),(10,438.41,84),(11,60146.91,104),(12,28189.62,45),(13,90755.55,25),(14,1059.79,77),(15,89760.07,98),(16,55546.09,70),(17,92262.97,30),(18,91135.97,37),(19,57046.44,44),(20,6466.12,37),(21,2810.24,81),(22,4967.94,220),(23,9418.69,47),(24,287.65,11),(25,4661.77,134),(26,3524.75,126),(27,6476.06,160),(28,9756.09,167),(29,518.56,108),(30,8743.12,82),(31,5848.34,186),(32,6728.34,232),(33,2717.89,202),(34,8483.56,184),(35,4414.08,13),(36,4171.70,143),(37,5350.48,134),(38,9655.43,38),(39,4114.97,125),(40,61.35,96),(41,3778.12,116),(42,2954.86,102),(43,478.47,171),(44,6929.44,225),(45,7741.42,136),(46,9151.38,162),(47,2120.84,85),(48,4034.18,105),(49,5104.31,205),(50,8410.68,189),(51,2347.90,52),(52,2835.17,212),(53,5159.66,120),(54,887.94,6),(55,4118.11,147),(56,6324.86,186),(57,5953.44,144),(58,2105.31,142),(59,7446.26,181),(60,2183.61,59),(61,8305.23,196),(62,216.15,112),(63,7309.94,214),(64,1501.97,63),(65,8520.57,153),(66,1789.93,148),(67,7721.82,20),(68,6446.04,114),(69,9553.99,149),(70,2839.63,165),(71,180.00,10);
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `loan_id` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `user_loan_fk_idx` (`loan_id`),
  CONSTRAINT `user_loan_fk` FOREIGN KEY (`loan_id`) REFERENCES `loan` (`loan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user@test.com','Guillermo','Francella',1),(3,'user3@test.com','Antonia','Stark',NULL),(6,'test0@test.com','Juan0','Perez0',NULL),(7,'test1@test.com','Juan1','Perez1',NULL),(8,'test2@test.com','Juan2','Perez2',NULL),(9,'test3@test.com','Juan3','Perez3',NULL),(10,'test4@test.com','Juan4','Perez4',NULL),(11,'test5@test.com','Juan5','Perez5',NULL),(12,'test6@test.com','Juan6','Perez6',NULL),(13,'test7@test.com','Juan7','Perez7',NULL),(14,'test8@test.com','Juan8','Perez8',NULL),(15,'test9@test.com','Juan9','Perez9',NULL),(16,'test10@test.com','Juan10','Perez10',NULL),(17,'test11@test.com','Juan11','Perez11',NULL),(18,'test12@test.com','Juan12','Perez12',NULL),(19,'test13@test.com','Juan13','Perez13',NULL),(20,'test14@test.com','Juan14','Perez14',NULL),(21,'test15@test.com','Juan15','Perez15',NULL),(22,'test16@test.com','Juan16','Perez16',NULL),(23,'test17@test.com','Juan17','Perez17',NULL),(24,'test18@test.com','Juan18','Perez18',NULL),(25,'test19@test.com','Juan19','Perez19',NULL),(26,'test20@test.com','Juan20','Perez20',NULL),(27,'test21@test.com','Juan21','Perez21',NULL),(28,'test22@test.com','Juan22','Perez22',NULL),(29,'test23@test.com','Juan23','Perez23',NULL),(30,'test24@test.com','Juan24','Perez24',NULL),(31,'test25@test.com','Juan25','Perez25',NULL),(32,'test26@test.com','Juan26','Perez26',NULL),(33,'test27@test.com','Juan27','Perez27',NULL),(34,'test28@test.com','Juan28','Perez28',NULL),(35,'test29@test.com','Juan29','Perez29',NULL),(36,'test30@test.com','Juan30','Perez30',NULL),(37,'test31@test.com','Juan31','Perez31',NULL),(38,'test32@test.com','Juan32','Perez32',NULL),(39,'test33@test.com','Juan33','Perez33',NULL),(40,'test34@test.com','Juan34','Perez34',NULL),(41,'test35@test.com','Juan35','Perez35',NULL),(42,'test36@test.com','Juan36','Perez36',NULL),(43,'test37@test.com','Juan37','Perez37',NULL),(44,'test38@test.com','Juan38','Perez38',NULL),(45,'test39@test.com','Juan39','Perez39',NULL),(46,'test40@test.com','Juan40','Perez40',NULL),(47,'test41@test.com','Juan41','Perez41',NULL),(48,'test42@test.com','Juan42','Perez42',NULL),(49,'test43@test.com','Juan43','Perez43',NULL),(50,'test44@test.com','Juan44','Perez44',NULL),(51,'test45@test.com','Juan45','Perez45',NULL),(52,'test46@test.com','Juan46','Perez46',NULL),(53,'test47@test.com','Juan47','Perez47',NULL),(54,'test48@test.com','Juan48','Perez48',NULL),(55,'test49@test.com','Juan49','Perez49',NULL),(56,'test50@test.com','Juan50','Perez50',NULL),(57,'test51@test.com','Juan51','Perez51',NULL),(58,'test52@test.com','Juan52','Perez52',NULL),(59,'test53@test.com','Juan53','Perez53',NULL),(60,'test54@test.com','Juan54','Perez54',NULL),(61,'test55@test.com','Juan55','Perez55',NULL),(62,'test56@test.com','Juan56','Perez56',NULL),(63,'test57@test.com','Juan57','Perez57',NULL),(64,'test58@test.com','Juan58','Perez58',NULL),(65,'test59@test.com','Juan59','Perez59',NULL),(66,'test60@test.com','Juan60','Perez60',NULL),(67,'test61@test.com','Juan61','Perez61',NULL),(68,'test62@test.com','Juan62','Perez62',NULL),(69,'test63@test.com','Juan63','Perez63',NULL),(70,'test64@test.com','Juan64','Perez64',NULL),(71,'test65@test.com','Juan65','Perez65',NULL),(72,'test66@test.com','Juan66','Perez66',NULL),(73,'test67@test.com','Juan67','Perez67',NULL),(74,'test68@test.com','Juan68','Perez68',NULL),(75,'test69@test.com','Juan69','Perez69',NULL),(76,'test70@test.com','Juan70','Perez70',NULL),(77,'test71@test.com','Juan71','Perez71',NULL),(78,'test72@test.com','Juan72','Perez72',NULL),(79,'test73@test.com','Juan73','Perez73',NULL),(80,'test74@test.com','Juan74','Perez74',NULL),(81,'test75@test.com','Juan75','Perez75',NULL),(82,'test76@test.com','Juan76','Perez76',NULL),(83,'test77@test.com','Juan77','Perez77',NULL),(84,'test78@test.com','Juan78','Perez78',NULL),(85,'test79@test.com','Juan79','Perez79',NULL),(86,'test80@test.com','Juan80','Perez80',NULL),(87,'test81@test.com','Juan81','Perez81',NULL),(88,'test82@test.com','Juan82','Perez82',NULL),(89,'test83@test.com','Juan83','Perez83',NULL),(90,'test84@test.com','Juan84','Perez84',NULL),(91,'test85@test.com','Juan85','Perez85',NULL),(92,'test86@test.com','Juan86','Perez86',NULL),(93,'test87@test.com','Juan87','Perez87',NULL),(94,'test88@test.com','Juan88','Perez88',NULL),(95,'test89@test.com','Juan89','Perez89',NULL),(96,'test90@test.com','Juan90','Perez90',NULL),(97,'test91@test.com','Juan91','Perez91',NULL),(98,'test92@test.com','Juan92','Perez92',NULL),(99,'test93@test.com','Juan93','Perez93',NULL),(100,'test94@test.com','Juan94','Perez94',NULL),(101,'test95@test.com','Juan95','Perez95',NULL),(102,'test96@test.com','Juan96','Perez96',NULL),(103,'test97@test.com','Juan97','Perez97',NULL),(104,'test98@test.com','Juan98','Perez98',NULL),(105,'test99@test.com','Juan99','Perez99',NULL),(107,'test0@test4.com','Juan0','Perez0',NULL),(108,'test1@test4.com','Juan1','Perez1',NULL),(109,'test2@test4.com','Juan2','Perez2',NULL),(110,'test3@test4.com','Juan3','Perez3',NULL),(111,'test4@test4.com','Juan4','Perez4',NULL),(112,'test5@test4.com','Juan5','Perez5',NULL),(113,'test6@test4.com','Juan6','Perez6',NULL),(114,'test7@test4.com','Juan7','Perez7',NULL),(115,'test8@test4.com','Juan8','Perez8',NULL),(116,'test9@test4.com','Juan9','Perez9',NULL),(117,'test10@test4.com','Juan10','Perez10',NULL),(118,'test11@test4.com','Juan11','Perez11',NULL),(119,'test12@test4.com','Juan12','Perez12',NULL),(120,'test13@test4.com','Juan13','Perez13',NULL),(121,'test14@test4.com','Juan14','Perez14',NULL),(122,'test15@test4.com','Juan15','Perez15',NULL),(123,'test16@test4.com','Juan16','Perez16',NULL),(124,'test17@test4.com','Juan17','Perez17',NULL),(125,'test18@test4.com','Juan18','Perez18',NULL),(126,'test19@test4.com','Juan19','Perez19',NULL),(127,'test20@test4.com','Juan20','Perez20',NULL),(128,'test21@test4.com','Juan21','Perez21',NULL),(129,'test22@test4.com','Juan22','Perez22',NULL),(130,'test23@test4.com','Juan23','Perez23',NULL),(131,'test24@test4.com','Juan24','Perez24',NULL),(132,'test25@test4.com','Juan25','Perez25',NULL),(133,'test26@test4.com','Juan26','Perez26',NULL),(134,'test27@test4.com','Juan27','Perez27',NULL),(135,'test28@test4.com','Juan28','Perez28',NULL),(136,'test29@test4.com','Juan29','Perez29',NULL),(137,'test30@test4.com','Juan30','Perez30',NULL),(138,'test31@test4.com','Juan31','Perez31',NULL),(139,'test32@test4.com','Juan32','Perez32',NULL),(140,'test33@test4.com','Juan33','Perez33',NULL),(141,'test34@test4.com','Juan34','Perez34',NULL),(142,'test35@test4.com','Juan35','Perez35',NULL),(143,'test36@test4.com','Juan36','Perez36',NULL),(144,'test37@test4.com','Juan37','Perez37',NULL),(145,'test38@test4.com','Juan38','Perez38',NULL),(146,'test39@test4.com','Juan39','Perez39',NULL),(147,'test40@test4.com','Juan40','Perez40',NULL),(148,'test41@test4.com','Juan41','Perez41',NULL),(149,'test42@test4.com','Juan42','Perez42',NULL),(150,'test43@test4.com','Juan43','Perez43',NULL),(151,'test44@test4.com','Juan44','Perez44',NULL),(152,'test45@test4.com','Juan45','Perez45',NULL),(153,'test46@test4.com','Juan46','Perez46',NULL),(154,'test47@test4.com','Juan47','Perez47',NULL),(155,'test48@test4.com','Juan48','Perez48',NULL),(156,'test49@test4.com','Juan49','Perez49',NULL),(157,'test50@test4.com','Juan50','Perez50',NULL),(158,'test51@test4.com','Juan51','Perez51',NULL),(159,'test52@test4.com','Juan52','Perez52',NULL),(160,'test53@test4.com','Juan53','Perez53',NULL),(161,'test54@test4.com','Juan54','Perez54',NULL),(162,'test55@test4.com','Juan55','Perez55',NULL),(163,'test56@test4.com','Juan56','Perez56',NULL),(164,'test57@test4.com','Juan57','Perez57',NULL),(165,'test58@test4.com','Juan58','Perez58',NULL),(166,'test59@test4.com','Juan59','Perez59',NULL),(167,'test60@test4.com','Juan60','Perez60',NULL),(168,'test61@test4.com','Juan61','Perez61',NULL),(169,'test62@test4.com','Juan62','Perez62',NULL),(170,'test63@test4.com','Juan63','Perez63',NULL),(171,'test64@test4.com','Juan64','Perez64',NULL),(172,'test65@test4.com','Juan65','Perez65',NULL),(173,'test66@test4.com','Juan66','Perez66',NULL),(174,'test67@test4.com','Juan67','Perez67',NULL),(175,'test68@test4.com','Juan68','Perez68',NULL),(176,'test69@test4.com','Juan69','Perez69',NULL),(177,'test70@test4.com','Juan70','Perez70',NULL),(178,'test71@test4.com','Juan71','Perez71',NULL),(179,'test72@test4.com','Juan72','Perez72',NULL),(180,'test73@test4.com','Juan73','Perez73',NULL),(181,'test74@test4.com','Juan74','Perez74',NULL),(182,'test75@test4.com','Juan75','Perez75',NULL),(183,'test76@test4.com','Juan76','Perez76',NULL),(184,'test77@test4.com','Juan77','Perez77',NULL),(185,'test78@test4.com','Juan78','Perez78',NULL),(186,'test79@test4.com','Juan79','Perez79',NULL),(187,'test80@test4.com','Juan80','Perez80',NULL),(188,'test81@test4.com','Juan81','Perez81',NULL),(189,'test82@test4.com','Juan82','Perez82',NULL),(190,'test83@test4.com','Juan83','Perez83',NULL),(191,'test84@test4.com','Juan84','Perez84',NULL),(192,'test85@test4.com','Juan85','Perez85',NULL),(193,'test86@test4.com','Juan86','Perez86',NULL),(194,'test87@test4.com','Juan87','Perez87',NULL),(195,'test88@test4.com','Juan88','Perez88',NULL),(196,'test89@test4.com','Juan89','Perez89',NULL),(197,'test90@test4.com','Juan90','Perez90',NULL),(198,'test91@test4.com','Juan91','Perez91',NULL),(199,'test92@test4.com','Juan92','Perez92',NULL),(200,'test93@test4.com','Juan93','Perez93',NULL),(201,'test94@test4.com','Juan94','Perez94',NULL),(202,'test95@test4.com','Juan95','Perez95',NULL),(203,'test96@test4.com','Juan96','Perez96',NULL),(204,'test97@test4.com','Juan97','Perez97',NULL),(205,'test98@test4.com','Juan98','Perez98',NULL),(206,'test99@test4.com','Juan99','Perez99',NULL),(207,'test0@test5.com','Juan0','Perez0',NULL),(208,'test1@test5.com','Juan1','Perez1',NULL),(211,'test0@test6.com','Juan0','Perez0',NULL),(212,'test1@test6.com','Juan1','Perez1',NULL),(213,'test0@test7.com','Juan0','Perez0',NULL),(214,'test1@test7.com','Juan1','Perez1',NULL),(216,'test0@test8.com','Juan0','Perez0',NULL),(217,'test1@test8.com','Juan1','Perez1',NULL),(219,'prueba0@test8.com','Juana0','Guay0',NULL),(220,'prueba1@test8.com','Juana1','Guay1',NULL),(221,'prueba0@prueba1.com','Juana0','Molina0',NULL),(222,'prueba1@prueba1.com','Juana1','Molina1',NULL),(224,'prueba0@prueba2.com','Juana0','Molina0',NULL),(225,'prueba1@prueba2.com','Juana1','Molina1',NULL),(226,'prueba0@prueba3.com','Juana0','Molina0',NULL),(227,'prueba1@prueba3.com','Juana1','Molina1',NULL),(228,'prueba0@prueba4.com','Juana0','Molina0',NULL),(229,'prueba1@prueba4.com','Juana1','Molina1',NULL),(230,'prueba0@prueba5.com','Juana0','Molina0',NULL),(231,'prueba1@prueba5.com','Juana1','Molina1',NULL),(232,'prueba0@prueba6.com','Juana0','Molina0',NULL),(233,'prueba1@prueba6.com','Juana1','Molina1',NULL),(234,'prueba0@prueba7.com','Juana0','Molina0',NULL),(235,'prueba1@prueba7.com','Juana1','Molina1',NULL),(236,'prueba0@prueba8.com','Juana0','Molina0',NULL),(237,'prueba1@prueba8.com','Juana1','Molina1',NULL),(238,'prueba0@prueba9.com','Juana0','Molina0',NULL),(239,'prueba1@prueba9.com','Juana1','Molina1',NULL),(240,'prueba0@prueba10.com','Juana0','Molina0',NULL),(241,'prueba1@prueba10.com','Juana1','Molina1',NULL),(243,'prueba0@prueba11.com','Juana0','Molina0',NULL),(244,'prueba1@prueba11.com','Juana1','Molina1',NULL),(245,'user60@test.com','Diego','Maradona',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-30 10:41:28
