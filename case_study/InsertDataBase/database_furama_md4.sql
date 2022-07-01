-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: furama_management_md4
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `academic_level`
--

DROP TABLE IF EXISTS `academic_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academic_level` (
  `id` int NOT NULL AUTO_INCREMENT,
  `academic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_level`
--

LOCK TABLES `academic_level` WRITE;
/*!40000 ALTER TABLE `academic_level` DISABLE KEYS */;
INSERT INTO `academic_level` VALUES (1,'Trung Cấp'),(2,'Cao Đẳng'),(3,'Đại Học'),(4,'Sau Đại Học');
/*!40000 ALTER TABLE `academic_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_role`
--

DROP TABLE IF EXISTS `app_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `APP_ROLE_UK` (`ROLE_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_role`
--

LOCK TABLES `app_role` WRITE;
/*!40000 ALTER TABLE `app_role` DISABLE KEYS */;
INSERT INTO `app_role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `app_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(36) NOT NULL,
  `ENCRYTED_PASSWORD` varchar(128) NOT NULL,
  `ENABLED` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `APP_USER_UK` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (1,'annguyen@gmail.com','$2a$10$Kjn3LEqLyO.LUVsmi7J.cuEg5onsJ3IG7bP1/1K8x.V5Jwbi6Lqei',_binary ''),(2,'binhlv@gmail.com','$2a$10$Kjn3LEqLyO.LUVsmi7J.cuEg5onsJ3IG7bP1/1K8x.V5Jwbi6Lqei',_binary ''),(3,'thiyen@gmail.com','$2a$10$Kjn3LEqLyO.LUVsmi7J.cuEg5onsJ3IG7bP1/1K8x.V5Jwbi6Lqei',_binary ''),(4,'toan0404@gmail.com','$2a$10$Kjn3LEqLyO.LUVsmi7J.cuEg5onsJ3IG7bP1/1K8x.V5Jwbi6Lqei',_binary ''),(5,'phatphat@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(6,'annghi20@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(7,'nhh0101@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(8,'donghanguyen@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(9,'hoangtong@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(10,'nguyencongdao12@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(11,'vietkhoa93@gmail.com','$2a$10$Kjn3LEqLyO.LUVsmi7J.cuEg5onsJ3IG7bP1/1K8x.V5Jwbi6Lqei',_binary ''),(12,'phanan@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(13,'nghianguyen@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(17,'lqad1649engineer@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(18,'nguyen2697s@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(19,'chanh.tran@codegym.vn','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(20,'nguyenthong2652000@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(21,'nguyenquanghuu2010@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(22,'longhoang6668@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(23,'huutrungg02@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(24,'chaumy791993@gmail.com','$2a$10$zLLp0ZDLLGlO8bAXIQwBIO4K/Ru/gdO/lpgVl.iMxLMTCtYh11TCS',_binary ''),(25,'tuanpham8196@gmail.com','$2a$10$jsUsMGkD5dfDpAPA.5aPVO0KGtL9IPCVxPxUkKqAkFgtDJRjzCLLq',_binary ''),(26,'luatzxcv@gmail.com','$2a$10$1uS99SDB.NAFOuvZA14r.eJFFfjnPZPtkCDyi1lstc9Knpama6RES',_binary ''),(27,'tien.nguyen@codegym.vn','$2a$10$.kx1dehEilff8GrFYKwSreRfVQmh0aoIXsiGUfLKCg73mP7Ol8fmy',_binary '');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deposit` double DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `facility_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq28qogy68douoc4gkgcy3ow9p` (`customer_id`),
  KEY `FKr2iw6grixlkbx43q2svdrhbb9` (`employee_id`),
  KEY `FKfpr2da875egm1qu47dew6ed43` (`facility_id`),
  CONSTRAINT `FKfpr2da875egm1qu47dew6ed43` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`id`),
  CONSTRAINT `FKq28qogy68douoc4gkgcy3ow9p` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKr2iw6grixlkbx43q2svdrhbb9` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,0,'2020-12-08','2020-12-08',_binary '',NULL,1,3,3),(2,200000,'2020-07-21','2020-07-14',_binary '',NULL,3,7,1),(3,50000,'2021-03-17','2021-03-15',_binary '',NULL,4,3,2),(4,100000,'2021-01-18','2021-01-14',_binary '',NULL,5,7,5),(5,0,'2021-07-15','2021-07-14',_binary '',NULL,2,7,6),(6,0,'2021-06-03','2021-06-01',_binary '',NULL,7,7,6),(7,100000,'2021-09-05','2021-09-02',_binary '',NULL,4,7,4),(8,150000,'2021-06-18','2021-06-17',_binary '',NULL,4,3,1),(9,0,'2020-11-19','2020-11-19',_binary '',NULL,4,3,3),(10,0,'2021-04-14','2021-04-12',_binary '',NULL,3,10,5),(11,0,'2021-04-25','2021-04-25',_binary '',NULL,2,2,1),(12,0,'2021-05-27','2021-05-25',_binary '',NULL,10,7,1),(13,500000,'2022-05-11','2022-05-03',_binary '',NULL,4,6,2),(14,500000,'2022-06-03','2022-06-01',_binary '',NULL,6,10,2);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_detail`
--

DROP TABLE IF EXISTS `contract_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `contract_id` int NOT NULL,
  `service_include_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CONTRACT_DETAIL_UK` (`contract_id`,`service_include_id`),
  KEY `FK919j979cntlky65qd4a7hxa3v` (`service_include_id`),
  CONSTRAINT `FK919j979cntlky65qd4a7hxa3v` FOREIGN KEY (`service_include_id`) REFERENCES `service_include` (`id`),
  CONSTRAINT `FKh3a73928bh54b95v82kwthjrk` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_detail`
--

LOCK TABLES `contract_detail` WRITE;
/*!40000 ALTER TABLE `contract_detail` DISABLE KEYS */;
INSERT INTO `contract_detail` VALUES (1,5,_binary '',2,4),(2,8,_binary '',2,5),(3,15,_binary '',2,6),(4,1,_binary '',3,1),(5,11,_binary '',3,2),(6,1,_binary '',1,3),(7,2,_binary '',1,2),(8,2,_binary '',12,2),(9,4,_binary '',13,4),(10,1,_binary '',1,1),(11,533,_binary '',2,2),(12,10,_binary '',13,5),(13,10,_binary '',12,4),(14,20,_binary '',7,3),(15,11,_binary '',7,4),(16,22,_binary '',3,3),(17,222,_binary '',2,3),(19,33,_binary '',3,5),(20,11,_binary '',5,4),(21,10,_binary '',13,2),(22,1,_binary '',1,4),(23,1,_binary '',4,1),(24,1,_binary '',4,2),(25,2,_binary '',5,1),(26,1,_binary '',4,3);
/*!40000 ALTER TABLE `contract_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `customer_type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn8vf9jf3m29plqn6rx45p2pl7` (`customer_type_id`),
  CONSTRAINT `FKn8vf9jf3m29plqn6rx45p2pl7` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'23 Nguyễn Hoàng, Đà Nẵng','1970-11-07','thihao07@gmail.com','643431213','Nguyễn Thị Hào','0901111564',_binary '\0','KH-0001',_binary '\0',1),(2,'K77/22 Thái Phiên, Quảng Trị','1992-08-08','xuandieu92@gmail.com','865342123','Phạm Xuân Diệu','954333333',_binary '','KH-0002',_binary '',3),(3,'K323/12 Ông Ích Khiêm, Vinh','1990-02-27','nghenhan2702@gmail.com','488645199','Trương Đình Nghệ','373213122',_binary '','KH-0003',_binary '',1),(4,'K453/12 Lê Lợi, Đà Nẵng','1981-07-08','duongquan@gmail.com','543432111','Dương Văn Quan','490039241',_binary '','KH-0004',_binary '',1),(5,'224 Lý Thái Tổ, Gia Lai','1995-12-09','nhinhi123@gmail.com','795453345','Hoàng Trần Nhi Nhi','312345678',_binary '','KH-0005',_binary '\0',4),(6,'37 Yên Thế, Đà Nẵng','2005-12-06','tonnuchau@gmail.com','732434215','Tôn Nữ Mộc Châu','988888844',_binary '','KH-0006',_binary '\0',4),(7,'K123/45 Lê Lợi, Hồ Chí Minh','1984-04-08','kimcuong84@gmail.com','856453123','Nguyễn Mỹ Kim','912345698',_binary '','KH-0007',_binary '\0',1),(8,'55 Nguyễn Văn Linh, Kon Tum','1999-04-08','haohao99@gmail.com','965656433','Nguyễn Thị Hào','763212345',_binary '','KH-0008',_binary '\0',3),(9,'24 Lý Thường Kiệt, Quảng Ngãi','1994-07-01','danhhai99@gmail.com','432341235','Trần Đại Danh','643343433',_binary '','KH-0009',_binary '',1),(10,'22 Ngô Quyền, Đà Nẵng','1989-07-01','dactam@gmail.com','344343432','Nguyễn Tâm Đắc','987654321',_binary '','KH-0010',_binary '',2),(11,'Da Nang','1993-01-27','vietkhoa@gmail.com','212327554','Phạm Việt Khoa','0901265897',_binary '','KH-1254',_binary '',1),(12,'Da Nang','2000-01-01','hai@gmail.com','254679542','Nguyễn Xuân Hải Long','0901546876',_binary '','KH-0111',_binary '',2),(13,'Quang Nam','2003-01-01','luatzxcv@gmail.com','212333445','Trần Ngọc Luật','0901546975',_binary '','KH-0101',_binary '',3);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'Kim cương'),(2,'Bạch kim'),(3,'Vàng'),(4,'Bạc'),(5,'Tìm năng');
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Sale-Marketing'),(2,'Hành chính'),(3,'Phục vụ'),(4,'Quản lý');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `username_id` int DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `academic_id` int DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKituxitwyvh1p26xxwmrdmkh33` (`academic_id`),
  KEY `FKbejtwvg9bxus2mffsm3swj3u9` (`department_id`),
  KEY `FKbc8rdko9o9n1ri9bpdyxv3x7i` (`position_id`),
  KEY `username_id` (`username_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`username_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FKbc8rdko9o9n1ri9bpdyxv3x7i` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
  CONSTRAINT `FKbejtwvg9bxus2mffsm3swj3u9` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FKituxitwyvh1p26xxwmrdmkh33` FOREIGN KEY (`academic_id`) REFERENCES `academic_level` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'295 Nguyễn Tất Thành, Đà Nẵng','1971-11-07','annguyen@gmail.com','456231786','Nguyễn Văn An','0901234121',_binary '',NULL,12000000,3,1,1),(2,'22 Yên Bái, Đà Nẵng','1997-04-09','binhlv@gmail.com','654231234','Lê Văn Bình','934212314',_binary '',2,7000000,2,2,1),(3,'K234/11 Điện Biên Phủ, Gia Lai','1995-12-12','thiyen@gmail.com','999231723','Hồ Thị Yến','0901123456',_binary '',NULL,14000000,3,2,1),(4,'77 Hoàng Diệu, Quảng Trị','1980-04-04','toan0404@gmail.com','123231365','Võ Công Toản','374443232',_binary '',4,17000000,4,4,1),(5,'43 Yên Bái, Đà Nẵng','1999-12-09','phatphat@gmail.com','454363232','Nguyễn Bỉnh Phát','902341231',_binary '',5,6000000,1,1,2),(6,'294 Nguyễn Tất Thành, Đà Nẵng','2000-11-08','annghi20@gmail.com','964542311','Khúc Nguyễn An Nghi','978653213',_binary '',6,7000000,2,3,2),(7,'4 Nguyễn Chí Thanh, Huế','1993-01-01','nhh0101@gmail.com','534323231','Nguyễn Hữu Hà','941234553',_binary '',7,8000000,3,2,2),(8,'111 Hùng Vương, Hà Nội','1989-09-03','donghanguyen@gmail.com','234414123','Nguyễn Hà Đông','642123111',_binary '',8,9000000,4,4,2),(9,'213 Hàm Nghi, Đà Nẵng','1982-09-03','hoangtong@gmail.com','256781231','Tòng Hoang','245144444',_binary '',9,6000000,4,4,2),(10,'6 Hoà Khánh, Đồng Nai','1994-01-08','nguyencongdao12@gmail.com','755434343','Nguyễn Công Đạo','988767111',_binary '',10,8000000,3,2,2),(11,'Da Nang','2000-01-03','vietkhoa@gmail.com','212327660','Khoa','0905007021',_binary '',11,1000000,3,1,1),(12,'Da Nang','2000-02-23','phanan@gmail.com','111222333','An Ngu','0905997021',_binary '\0',12,NULL,3,2,2),(13,'Da Nang','2000-01-01','nghianguyen@gmail.com','222333666','Nghia','0901111222',_binary '',NULL,1000000,3,1,2),(15,'Da Nang','2000-06-06','lqad1649engineer@gmail.com','212369852','Đà','0905456985',_binary '',17,10000000,1,2,2),(16,'Đà Nẵng','1997-01-26','nguyen2697s@gmail.com','123568478','Nguyen Tran Thanh Nghia','0901236525',_binary '',NULL,10000000000,2,1,1),(17,'Da Nang','1985-01-10','chanh.tran@codegym.vn','205456953','Trần Văn Chánh','0901123658',_binary '',NULL,15000000,3,2,2),(18,'Da Nang','2000-01-05','nguyenthong2652000@gmail.com','205639459','Nguyễn Văn Thông','0901456321',_binary '',NULL,10000000,2,2,2),(19,'Da Nang','1994-02-09','nguyenquanghuu2010@gmail.com','205456328','Nguyễn Quang Hữu','0901365894',_binary '',NULL,15000000,1,2,2),(20,'Da Nang','1998-01-01','longhoang6668@gmail.com','205654125','Ngô Hoàng Long','0901587894',_binary '',22,10000000,3,1,2),(21,'Huế','2000-01-01','huutrungg02@gmail.com','215648789','Trần Văn Hữu Trung','0901054265',_binary '',23,10000000,2,2,2),(22,'Da Nang','1993-01-01','chaumy791993@gmail.com','204003093','Châu Mỹ','0901111555',_binary '',24,10000000,3,2,2),(23,'Da Nang','1996-01-01','tuanpham8196@gmail.com','206145987','Phạm Anh Tuấn','0901456325',_binary '',25,1000000,3,2,2),(24,'Quang Nam','2003-01-01','luatzxcv@gmail.com','201564356','Trần Ngọc Luật','0901256478',_binary '',26,10000000,2,2,2),(25,'Da Nang','1993-01-01','tien.nguyen@codegym.vn','205146489','Nguyễn Vũ Thành Tiến','0905002013',_binary '',27,10000,3,2,2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facility` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `floor_square` double DEFAULT NULL,
  `free_service_include` varchar(255) DEFAULT NULL,
  `maximum_people` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number_floor` int DEFAULT NULL,
  `pool_square` double DEFAULT NULL,
  `rental_fee` double DEFAULT NULL,
  `room_standard` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `facility_type_id` int DEFAULT NULL,
  `rent_type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKigr2fb4t1jy9niygn2v1f9jbv` (`facility_type_id`),
  KEY `FKio4pwma47b0svcwoo8filc036` (`rent_type_id`),
  CONSTRAINT `FKigr2fb4t1jy9niygn2v1f9jbv` FOREIGN KEY (`facility_type_id`) REFERENCES `facility_type` (`id`),
  CONSTRAINT `FKio4pwma47b0svcwoo8filc036` FOREIGN KEY (`rent_type_id`) REFERENCES `rent_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES (1,'DV-0001','Có hồ bơi',25000,NULL,10,'Villa Beach Front',4,500,10000000,'vip',_binary '',1,3),(2,'DV-0002','Có thêm bếp nướng',14000,NULL,7,'House Princess 01',3,NULL,5000000,'vip',_binary '',2,2),(3,'DV-0003','Có tivi',5000,NULL,2,'Room Twin 01',NULL,NULL,1000000,'normal',_binary '',3,4),(4,'DV-0004','Có hồ bơi',22000,NULL,8,'Villa No Beach Front',3,300,9000000,'normal',_binary '',1,3),(5,'DV-0005','Có thêm bếp nướng',10000,NULL,5,'House Princess 02',2,NULL,4000000,'normal',_binary '',2,3),(6,'DV-0006','Có tivi',3000,NULL,2,'Room Twin 02',NULL,NULL,900000,'normal',_binary '',3,4);
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility_type`
--

DROP TABLE IF EXISTS `facility_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facility_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `facility_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_type`
--

LOCK TABLES `facility_type` WRITE;
/*!40000 ALTER TABLE `facility_type` DISABLE KEYS */;
INSERT INTO `facility_type` VALUES (1,'Villa'),(2,'House'),(3,'Room');
/*!40000 ALTER TABLE `facility_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `id` int NOT NULL AUTO_INCREMENT,
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Quản Lý'),(2,'Nhân Viên');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_type`
--

DROP TABLE IF EXISTS `rent_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rent_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_type`
--

LOCK TABLES `rent_type` WRITE;
/*!40000 ALTER TABLE `rent_type` DISABLE KEYS */;
INSERT INTO `rent_type` VALUES (1,'year'),(2,'month'),(3,'day'),(4,'hour');
/*!40000 ALTER TABLE `rent_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_include`
--

DROP TABLE IF EXISTS `service_include`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_include` (
  `id` int NOT NULL AUTO_INCREMENT,
  `detail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_include`
--

LOCK TABLES `service_include` WRITE;
/*!40000 ALTER TABLE `service_include` DISABLE KEYS */;
INSERT INTO `service_include` VALUES (1,'tiện nghi, hiện tại','Karaoke',10000,'giờ'),(2,'hỏng 1 xe','Thuê xe máy',10000,'chiếc'),(3,'tốt','Thuê xe đạp',20000,'chiếc'),(4,'đầy đủ đồ ăn, tráng miệng','Buffet buổi sáng',15000,'suất'),(5,'đầy đủ đồ ăn, tráng miệng','Buffet buổi trưa',90000,'suất'),(6,'đầy đủ đồ ăn, tráng miệng','Buffet buổi tối',16000,'suất');
/*!40000 ALTER TABLE `service_include` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `USER_ID` int NOT NULL,
  `ROLE_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_ROLE_UK` (`USER_ID`,`ROLE_ID`),
  KEY `ROLE_ID` (`ROLE_ID`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `app_user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `app_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(12,1,2),(2,2,1),(13,2,2),(3,3,1),(14,3,2),(4,4,1),(15,4,2),(16,5,2),(6,6,2),(7,7,2),(8,8,2),(9,9,2),(10,10,2),(11,11,1),(17,11,2),(18,12,2),(20,13,2),(23,17,2),(25,18,2),(27,19,2),(29,20,2),(31,21,2),(32,22,2),(33,23,2),(34,24,2),(35,25,2),(36,26,2),(37,27,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-21 14:41:48
