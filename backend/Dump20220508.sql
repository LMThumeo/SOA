-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: qa
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
-- Table structure for table `field`
--

DROP TABLE IF EXISTS `field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `field` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `field`
--

LOCK TABLES `field` WRITE;
/*!40000 ALTER TABLE `field` DISABLE KEYS */;
INSERT INTO `field` VALUES (1,'Mã Sinh Viên'),(2,'Môn Học'),(3,'Kì Học'),(4,'Lớp'),(5,'Số Căn Cước'),(6,'Mail'),(7,'Phone');
/*!40000 ALTER TABLE `field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filed_form`
--

DROP TABLE IF EXISTS `filed_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `filed_form` (
  `id` int NOT NULL AUTO_INCREMENT,
  `form_id` int DEFAULT NULL,
  `field_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_fieldform_field_idx` (`field_id`),
  KEY `fk_fieldform_form_idx` (`form_id`),
  CONSTRAINT `fk_fieldform_field` FOREIGN KEY (`field_id`) REFERENCES `field` (`id`),
  CONSTRAINT `fk_fieldform_form` FOREIGN KEY (`form_id`) REFERENCES `form` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filed_form`
--

LOCK TABLES `filed_form` WRITE;
/*!40000 ALTER TABLE `filed_form` DISABLE KEYS */;
INSERT INTO `filed_form` VALUES (1,1,1),(2,1,2),(3,1,3);
/*!40000 ALTER TABLE `filed_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `form` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form`
--

LOCK TABLES `form` WRITE;
/*!40000 ALTER TABLE `form` DISABLE KEYS */;
INSERT INTO `form` VALUES (1,'Phúc Khảo'),(2,'Chuyển Học Phần');
/*!40000 ALTER TABLE `form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `point`
--

DROP TABLE IF EXISTS `point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `point` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `point`
--

LOCK TABLES `point` WRITE;
/*!40000 ALTER TABLE `point` DISABLE KEYS */;
INSERT INTO `point` VALUES (1,'Chuyên cần'),(2,'Bài tập lớn'),(3,'Thực hành'),(4,'Kiểm tra'),(5,'Thuyết trình'),(6,'Cuối kỳ');
/*!40000 ALTER TABLE `point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reexamination`
--

DROP TABLE IF EXISTS `reexamination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reexamination` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(45) DEFAULT NULL,
  `point` double DEFAULT NULL,
  `transcript_line_id` int DEFAULT NULL,
  `submit_time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reex_transline_idx` (`transcript_line_id`),
  CONSTRAINT `FKb4ypdy7r58kvtxej4bfix1wva` FOREIGN KEY (`transcript_line_id`) REFERENCES `transcript_line` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reexamination`
--

LOCK TABLES `reexamination` WRITE;
/*!40000 ALTER TABLE `reexamination` DISABLE KEYS */;
INSERT INTO `reexamination` VALUES (1,'ACCEPT',NULL,15,'2021-07-05'),(2,'ACCEPT',NULL,19,'2022-05-08');
/*!40000 ALTER TABLE `reexamination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester`
--

DROP TABLE IF EXISTS `semester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semester` (
  `id` int NOT NULL AUTO_INCREMENT,
  `semester_num` int DEFAULT NULL,
  `year_start` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester`
--

LOCK TABLES `semester` WRITE;
/*!40000 ALTER TABLE `semester` DISABLE KEYS */;
INSERT INTO `semester` VALUES (1,2,2021),(2,1,2021);
/*!40000 ALTER TABLE `semester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_code` varchar(10) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_code_UNIQUE` (`student_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'B18DCCN666','Lê Anh','anhl@ptit.edu.vn',NULL,'1'),(2,'B18DCCN213','Phạm Khoa','khoap@ptit.edu.vn',NULL,'1'),(3,'B17DCAT112','Nguyễn Vân','vann@ptit.edu.vn',NULL,'1'),(4,'B19DCMR181','Đào Quân','quand@ptit.edu.vn',NULL,'1');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_class`
--

DROP TABLE IF EXISTS `study_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `room` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `subject_semester_id` int DEFAULT NULL,
  `shift` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5lexs6oxlnxwysr8duhf04jgt` (`subject_semester_id`),
  CONSTRAINT `FK5lexs6oxlnxwysr8duhf04jgt` FOREIGN KEY (`subject_semester_id`) REFERENCES `subject_semester` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_class`
--

LOCK TABLES `study_class` WRITE;
/*!40000 ALTER TABLE `study_class` DISABLE KEYS */;
INSERT INTO `study_class` VALUES (1,'Nhóm 2','601-A2',1,1),(2,'Nhóm 3','102-A2',3,2),(3,'Nhóm2','301-A2',3,1),(4,'Nhóm 3','602-A2',1,3),(5,'Nhóm 1','104-A2',4,2),(6,'Nhóm 2','104-A2',4,4),(7,'Nhóm 1','201-A3',5,5),(8,'Nhóm 2','201-A3',5,6);
/*!40000 ALTER TABLE `study_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `subject_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Đảm bảo chất lượng phần mềm','INT1416'),(2,'Kiến trúc và thiết kế phần mềm','INT1427'),(3,'Ứng dụng thiết bị di động','INT1449');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_point`
--

DROP TABLE IF EXISTS `subject_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_point` (
  `id` int NOT NULL AUTO_INCREMENT,
  `weight` int DEFAULT NULL,
  `point_id` int DEFAULT NULL,
  `subject_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj6j4xe5if49m0yqi0eseavhpj` (`point_id`),
  KEY `FKd1cwkka30ychkb9f6jj013n51` (`subject_id`),
  CONSTRAINT `FKd1cwkka30ychkb9f6jj013n51` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FKj6j4xe5if49m0yqi0eseavhpj` FOREIGN KEY (`point_id`) REFERENCES `point` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_point`
--

LOCK TABLES `subject_point` WRITE;
/*!40000 ALTER TABLE `subject_point` DISABLE KEYS */;
INSERT INTO `subject_point` VALUES (1,10,1,1),(2,10,2,1),(3,10,4,1),(4,70,6,1),(5,10,1,2),(6,20,2,2),(7,70,6,2);
/*!40000 ALTER TABLE `subject_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_semester`
--

DROP TABLE IF EXISTS `subject_semester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_semester` (
  `id` int NOT NULL AUTO_INCREMENT,
  `semester_id` int DEFAULT NULL,
  `subject_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKte0rfdc5syu8w1o1lxt77cfx0` (`semester_id`),
  KEY `FKd4cdg77nt4xly4ecd062ehkw4_idx` (`subject_id`),
  CONSTRAINT `FKbi711vmu1qb1ob3oxx9f9kv59` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FKte0rfdc5syu8w1o1lxt77cfx0` FOREIGN KEY (`semester_id`) REFERENCES `semester` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_semester`
--

LOCK TABLES `subject_semester` WRITE;
/*!40000 ALTER TABLE `subject_semester` DISABLE KEYS */;
INSERT INTO `subject_semester` VALUES (1,1,1),(3,2,1),(4,1,2),(5,2,2);
/*!40000 ALTER TABLE `subject_semester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transcript_item`
--

DROP TABLE IF EXISTS `transcript_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transcript_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `point` double DEFAULT NULL,
  `subject_point_id` int DEFAULT NULL,
  `transcript_line_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK908unpiu8q84g2svqo889cbqm` (`subject_point_id`),
  KEY `fk_transitem_transline_idx` (`transcript_line_id`),
  CONSTRAINT `FK908unpiu8q84g2svqo889cbqm` FOREIGN KEY (`subject_point_id`) REFERENCES `subject_point` (`id`),
  CONSTRAINT `fk_transitem_transline` FOREIGN KEY (`transcript_line_id`) REFERENCES `transcript_line` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transcript_item`
--

LOCK TABLES `transcript_item` WRITE;
/*!40000 ALTER TABLE `transcript_item` DISABLE KEYS */;
INSERT INTO `transcript_item` VALUES (1,9,1,15),(2,8,1,16),(3,10,3,17),(4,8,3,18),(5,0,4,19),(6,4,4,15),(7,0,4,16),(8,0,2,17),(9,0,2,18),(10,0,2,19),(11,4,2,15),(12,0,3,16),(13,0,2,17),(14,0,3,18),(15,0,1,19),(16,0,4,17),(17,0,1,18),(18,0,4,18),(19,0,1,19),(20,0,3,19);
/*!40000 ALTER TABLE `transcript_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transcript_line`
--

DROP TABLE IF EXISTS `transcript_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transcript_line` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int DEFAULT NULL,
  `study_class_id` int DEFAULT NULL,
  `reexamination_deadline` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK13h26wpviqbgvpigghol8sp5g` (`student_id`),
  KEY `FKod59cpdhljyfbwu1fp4cyhhoo` (`study_class_id`),
  CONSTRAINT `FK13h26wpviqbgvpigghol8sp5g` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FKod59cpdhljyfbwu1fp4cyhhoo` FOREIGN KEY (`study_class_id`) REFERENCES `study_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transcript_line`
--

LOCK TABLES `transcript_line` WRITE;
/*!40000 ALTER TABLE `transcript_line` DISABLE KEYS */;
INSERT INTO `transcript_line` VALUES (15,1,1,'2021-05-28'),(16,2,1,NULL),(17,3,1,NULL),(18,4,1,NULL),(19,2,5,NULL),(20,3,5,NULL),(21,4,5,NULL);
/*!40000 ALTER TABLE `transcript_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'qa'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-08 22:13:06
