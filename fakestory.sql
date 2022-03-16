-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: fakebook
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_id` int NOT NULL,
  `user_rep_id` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `post_id` int DEFAULT NULL,
  `date_comment` datetime DEFAULT NULL,
  `reply_comment_id` int DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `user_rep_id` (`user_rep_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_rep_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend_status`
--

DROP TABLE IF EXISTS `friend_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friend_status` (
  `fs_id` int NOT NULL AUTO_INCREMENT,
  `user_id_1` int DEFAULT NULL,
  `user_id_2` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`fs_id`),
  KEY `user_id_1` (`user_id_1`),
  KEY `user_id_2` (`user_id_2`),
  CONSTRAINT `friend_status_ibfk_1` FOREIGN KEY (`user_id_1`) REFERENCES `user` (`user_id`),
  CONSTRAINT `friend_status_ibfk_2` FOREIGN KEY (`user_id_2`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend_status`
--

LOCK TABLES `friend_status` WRITE;
/*!40000 ALTER TABLE `friend_status` DISABLE KEYS */;
INSERT INTO `friend_status` VALUES (1,1,3,1),(2,1,4,1),(3,3,4,1),(4,1,1,0);
/*!40000 ALTER TABLE `friend_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_fb`
--

DROP TABLE IF EXISTS `group_fb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_fb` (
  `group_id` int unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) DEFAULT NULL,
  `group_description` varchar(255) DEFAULT NULL,
  `date_create` datetime DEFAULT NULL,
  `total_member` int DEFAULT NULL,
  `background` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_fb`
--

LOCK TABLES `group_fb` WRITE;
/*!40000 ALTER TABLE `group_fb` DISABLE KEYS */;
INSERT INTO `group_fb` VALUES (1,'Hội những người từng đi tù','Group là nơi giao lưu ','2022-01-01 03:43:20',0,'https://cms.luatvietnam.vn/uploaded/Images/Original/2018/07/13/di-tu_1307171739.jpg'),(2,'Hội những anh em FA','Group FA','2022-01-01 03:43:20',0,'https://mcdn.coolmate.me/image/September2021/fa-la-gi-13.jpg'),(3,'Lập trình viên Java ','Group for JAVA','2022-01-01 03:43:20',0,NULL),(4,'bay nu cuoi xuan ','7 nu','2022-03-02 23:45:02',0,NULL);
/*!40000 ALTER TABLE `group_fb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_action`
--

DROP TABLE IF EXISTS `history_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history_action` (
  `history_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `forward` int DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`history_id`),
  KEY `user_id` (`user_id`),
  KEY `forward` (`forward`),
  CONSTRAINT `history_action_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `history_action_ibfk_2` FOREIGN KEY (`forward`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_action`
--

LOCK TABLES `history_action` WRITE;
/*!40000 ALTER TABLE `history_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `history_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `image_id` int NOT NULL AUTO_INCREMENT,
  `image_name` varchar(255) DEFAULT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like_page`
--

DROP TABLE IF EXISTS `like_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `like_page` (
  `user_id` int DEFAULT NULL,
  `page_id` int DEFAULT NULL,
  `date_like` datetime DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `page_id` (`page_id`),
  CONSTRAINT `like_page_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `like_page_ibfk_2` FOREIGN KEY (`page_id`) REFERENCES `page` (`page_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_page`
--

LOCK TABLES `like_page` WRITE;
/*!40000 ALTER TABLE `like_page` DISABLE KEYS */;
INSERT INTO `like_page` VALUES (6,1,'2021-12-31 20:43:20'),(1,1,'2021-12-31 20:43:20'),(1,2,'2021-12-31 20:43:20');
/*!40000 ALTER TABLE `like_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `user_id` int DEFAULT NULL,
  `group_id` int DEFAULT NULL,
  `role_member_id` int DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `group_id` (`group_id`),
  KEY `role_member_id` (`role_member_id`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `member_ibfk_3` FOREIGN KEY (`role_member_id`) REFERENCES `role_group` (`role_member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (6,1,1),(6,2,1),(1,1,1),(1,2,1);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `user_id` int DEFAULT NULL,
  `user_to` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `user_to` (`user_to`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`user_to`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `message_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page`
--

DROP TABLE IF EXISTS `page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `page` (
  `page_id` int NOT NULL AUTO_INCREMENT,
  `page_name` varchar(255) DEFAULT NULL,
  `page_description` varchar(255) DEFAULT NULL,
  `date_create` datetime DEFAULT NULL,
  `total_like` int DEFAULT NULL,
  PRIMARY KEY (`page_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page`
--

LOCK TABLES `page` WRITE;
/*!40000 ALTER TABLE `page` DISABLE KEYS */;
INSERT INTO `page` VALUES (1,'Sơn Tùng MTP','Fanpage duy nhất của Sơn Tùng MTP','2021-12-31 20:43:20',0),(2,'Thiều Bảo Trâm ','Fanpage duy nhất của Thiều Bảo Trâm','2021-12-31 20:43:20',0);
/*!40000 ALTER TABLE `page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page_post`
--

DROP TABLE IF EXISTS `page_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `page_post` (
  `post_id` int DEFAULT NULL,
  `page_id` int DEFAULT NULL,
  KEY `post_id` (`post_id`),
  KEY `page_id` (`page_id`),
  CONSTRAINT `page_post_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`),
  CONSTRAINT `page_post_ibfk_2` FOREIGN KEY (`page_id`) REFERENCES `page` (`page_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page_post`
--

LOCK TABLES `page_post` WRITE;
/*!40000 ALTER TABLE `page_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `page_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `post_id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `number_react` int DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (2,'Vì sao mình lại phải làm cái dự án chít tịt này','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fh993c38difc0e?alt=media&token=3470e7c2-0bc3-4a10-9db2-f2120bab751d',1,'2022-02-15 15:45:15',7),(3,'Hôm nay tôi chia tay, buồn quá','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fimager_25787.jpg?alt=media&token=f718115d-88d9-487e-8bde-f34ef0b63e38',1,'2022-03-02 21:38:18',0),(5,'Tao là trùm Vỹ Dạ','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fgiangho.jpg?alt=media&token=de140eb7-ceb0-4d17-b6ff-6fcbd35c7441',3,'2022-03-02 21:43:22',0),(6,'Tôi buồn quá mọi người à','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Ftoibuon.jpg?alt=media&token=6f83c24d-3543-49cf-8986-5e28edd055cd',20,'2022-03-11 15:20:07',0),(7,'VIETNAMNUMBERONE','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fvietnam.jpg?alt=media&token=0cdd9839-cc5e-43eb-81ca-6739dce7d5d9',1,'2022-03-11 15:37:37',0),(8,'asdasd','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F4fj40e305jh98?alt=media&token=52d71543-a3cc-485b-af94-a50e61b785b4',6,'2022-03-16 08:43:38',0);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_in_group`
--

DROP TABLE IF EXISTS `post_in_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_in_group` (
  `post_id` int DEFAULT NULL,
  `group_id` int DEFAULT NULL,
  KEY `post_id` (`post_id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `post_in_group_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_in_group`
--

LOCK TABLES `post_in_group` WRITE;
/*!40000 ALTER TABLE `post_in_group` DISABLE KEYS */;
INSERT INTO `post_in_group` VALUES (5,3);
/*!40000 ALTER TABLE `post_in_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `react`
--

DROP TABLE IF EXISTS `react`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `react` (
  `react_id` int NOT NULL,
  `react_type` int DEFAULT NULL,
  `user_react` int DEFAULT NULL,
  `post_id` int DEFAULT NULL,
  PRIMARY KEY (`react_id`),
  KEY `react_type` (`react_type`),
  KEY `user_react` (`user_react`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `react_ibfk_1` FOREIGN KEY (`react_type`) REFERENCES `type_react` (`react_type`),
  CONSTRAINT `react_ibfk_2` FOREIGN KEY (`user_react`) REFERENCES `user` (`user_id`),
  CONSTRAINT `react_ibfk_3` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `react`
--

LOCK TABLES `react` WRITE;
/*!40000 ALTER TABLE `react` DISABLE KEYS */;
/*!40000 ALTER TABLE `react` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (0,'user','User of the system, no more permission'),(1,'admin_system','Admin of the system, this role is higest role');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_group`
--

DROP TABLE IF EXISTS `role_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_group` (
  `role_member_id` int NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_group`
--

LOCK TABLES `role_group` WRITE;
/*!40000 ALTER TABLE `role_group` DISABLE KEYS */;
INSERT INTO `role_group` VALUES (1,'Admin','Admin of the group'),(2,'Censorship','Censorship of the group, filter post in group'),(3,'User','User of the group');
/*!40000 ALTER TABLE `role_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_page`
--

DROP TABLE IF EXISTS `role_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_page` (
  `role_member_id` int NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_page`
--

LOCK TABLES `role_page` WRITE;
/*!40000 ALTER TABLE `role_page` DISABLE KEYS */;
INSERT INTO `role_page` VALUES (1,'Boss','Boss of the group, create a page.'),(2,'User','User like page.'),(3,'Manager','Manager of the group');
/*!40000 ALTER TABLE `role_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_post`
--

DROP TABLE IF EXISTS `tag_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_post` (
  `post_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  KEY `post_id` (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tag_post_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`),
  CONSTRAINT `tag_post_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_post`
--

LOCK TABLES `tag_post` WRITE;
/*!40000 ALTER TABLE `tag_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_react`
--

DROP TABLE IF EXISTS `type_react`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_react` (
  `react_type` int NOT NULL,
  `react_name` varchar(255) DEFAULT NULL,
  `react_icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`react_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_react`
--

LOCK TABLES `type_react` WRITE;
/*!40000 ALTER TABLE `type_react` DISABLE KEYS */;
INSERT INTO `type_react` VALUES (1,'Like','like_link'),(2,'Heart ','heart_link'),(3,'Haha','haha_link'),(4,'Wow','wow_link'),(5,'Angry','Angry');
/*!40000 ALTER TABLE `type_react` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `number_friends` int DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `date_create` datetime DEFAULT NULL,
  `avatar` varchar(500) DEFAULT NULL,
  `background` varchar(500) DEFAULT NULL,
  `live` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `sex` int DEFAULT '1',
  PRIMARY KEY (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'thesoonafu@gmail.com','MTIz','Nguyễn Văn Đức Độ','0827299123',1,'Anh không làm được nhưng anh hứa được',0,'Huế','2021-12-31 20:43:20','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang',NULL,1),(3,'ngoluongdanvanngu@gmail.com','MTIz','Ngô Lương Văn Dần','0828282822',1,'Dần xấu ',0,'Huế','2022-01-01 03:43:20','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang',NULL,1),(4,'tranvanson@gmail.com','MTIz','Trần Văn Sơn','0228288282',1,'Sơn xấu trai ',0,'Đà Nẵng','2022-01-01 03:43:20','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang',NULL,1),(5,'tranthithuhoai@gmail.com','MTIz','Hoài Kute','0387372727',1,'Hoài xấu gái',0,'Đà Nẵng','2022-01-01 03:43:20','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang',NULL,1),(6,'babangu@gmail.com','MTIz','Hoàng Thịnh','0477372772',1,'Thích bé Ai',0,'Đà Nẵng','2022-01-01 03:43:20','https://scontent.fhan14-1.fna.fbcdn.net/v/t39.30808-6/274874049_1682612112084696_1887295902668061243_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=ad2b24&_nc_ohc=Io9esu08XrMAX_OpQBo&tn=lvRwZm_Uarm2tvVg&_nc_ht=scontent.fhan14-1.fna&oh=00_AT8BwL52wOBDA3eYiafgk-pUcTT6ssUCw-DtYC6ODyvjug&oe=62331364','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang',NULL,1),(20,'huycute@gmail.com','MTIz','Nguyễn Minh Huy','none',0,'none',0,'none','2022-03-11 13:39:09','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang','2022-03-31 00:00:00',1),(21,'ltd@gmail.com','MTIz','Lê Trung Dũng','none',0,'Phở Phở',0,'Quảng Bình','2022-03-14 16:27:54','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Đà Nẵng','2001-06-19 00:00:00',1),(22,'dungbone@gmail.com','MTIzMTIz','Dương Nguyễn Thùy Dung','none',0,'none',0,'none','2022-03-14 16:31:47','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaulAvatarFemale.png?alt=media&token=0fc589be-e8b1-42db-a16b-0b4a9333513b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652',NULL,'2022-11-29 00:00:00',2),(23,'vbvc2001@gmail.com','MTIzMTIzMTIz','Võ Bảo Văn Chương','none',0,'none',0,'none','2022-03-14 16:32:17','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaulAvatarFemale.png?alt=media&token=0fc589be-e8b1-42db-a16b-0b4a9333513b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652',NULL,'2022-11-29 00:00:00',2),(24,'httm.m@gmail.com','MTIzMTIz','Hà Thị Thùy Mến ','none',0,'none',0,'none','2022-03-14 16:33:05','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaulAvatarFemale.png?alt=media&token=0fc589be-e8b1-42db-a16b-0b4a9333513b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652',NULL,'2001-01-16 00:00:00',2),(25,'xuanaile@gmail.com','MTIzMTIzMTIz','Xuân Ái Lê','none',0,'none',0,'none','2022-03-14 16:33:29','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaulAvatarFemale.png?alt=media&token=0fc589be-e8b1-42db-a16b-0b4a9333513b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652',NULL,'2001-01-16 00:00:00',2);
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

-- Dump completed on 2022-03-16 13:46:53
