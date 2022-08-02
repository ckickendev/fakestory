CREATE DATABASE  IF NOT EXISTS `fakebook` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fakebook`;
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
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `user_rep_id` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `post_id` int DEFAULT NULL,
  `date_comment` datetime DEFAULT NULL,
  `reply_comment_id` int DEFAULT NULL,
  `status` int DEFAULT '1',
  PRIMARY KEY (`comment_id`),
  KEY `user_rep_id` (`user_rep_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_rep_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,'Ai đồng ý giơ tay',25,'2022-03-16 18:16:07',-1,1),(2,6,'Tôi đồng ý',25,'2022-03-16 19:16:07',-1,1),(3,20,'Tôi đồng ý',25,'2022-03-16 20:16:07',-1,1),(60,1,'xinh qua',13,'2022-03-17 16:06:13',-1,1),(61,1,'xinh qua',13,'2022-03-17 16:06:15',-1,1),(62,1,'xinh qua',13,'2022-03-17 16:06:16',-1,1),(63,1,'tuyet voi ',13,'2022-03-17 16:06:21',-1,-1),(74,1,'123',25,'2022-03-17 16:36:36',-1,1),(75,1,'heloo',25,'2022-03-17 16:37:35',-1,1),(76,1,'hello ',25,'2022-03-18 08:16:29',-1,1),(77,1,'123',25,'2022-03-19 08:09:37',-1,1),(78,1,'123',25,'2022-03-19 08:14:49',-1,1),(79,1,'chinh xac',25,'2022-03-19 08:22:11',-1,1),(80,1,'',25,'2022-03-23 11:05:53',-1,1),(81,1,'hello',12,'2022-03-23 22:56:26',-1,1),(82,1,'hic',12,'2022-03-23 22:57:59',-1,1),(83,1,'khong co gi',25,'2022-03-23 23:01:39',-1,1),(84,1,'phan doi ',25,'2022-03-23 23:07:07',-1,1),(85,1,'123',25,'2022-03-23 23:07:54',-1,1),(86,1,'Xinh qua ik',29,'2022-03-23 23:09:44',-1,1),(87,4,'Thương thằng bạn tui ',30,'2022-03-24 09:41:01',-1,1),(88,1,'Thật là sâu xắc',31,'2022-03-24 09:46:05',-1,1),(89,4,'<3 ',30,'2022-03-24 09:46:21',-1,1),(90,1,'<3 <3 <3 ',30,'2022-03-24 09:46:28',-1,1),(91,1,'Yeu Anh',30,'2022-03-24 15:12:15',-1,1),(92,1,'good',37,'2022-03-25 13:38:46',-1,-1),(93,1,'good luck',38,'2022-03-25 13:40:56',-1,1),(94,1,'...',38,'2022-03-25 13:41:00',-1,1),(95,1,'đần vl',32,'2022-04-02 00:01:09',-1,1),(96,1,'asd',11,'2022-04-02 09:07:35',-1,1),(97,1,'m ngu lamws',37,'2022-04-25 22:00:42',-1,-1),(98,1,'gaf',7,'2022-05-11 17:41:57',-1,-1),(99,1,'ga',28,'2022-05-11 17:42:03',-1,1),(100,1,'t thấy xấu',42,'2022-06-13 20:57:16',-1,-1),(103,1,'asdasd',49,'2022-07-12 14:18:19',-1,-1),(104,1,'asdasd',49,'2022-07-12 14:18:24',-1,-1),(105,1,'asdasd',49,'2022-07-12 14:18:50',-1,-1),(106,1,'world',49,'2022-07-12 14:18:54',-1,-1),(107,1,'aasdasd',49,'2022-07-12 14:38:42',-1,-1),(108,1,'asdasd',49,'2022-07-12 14:40:01',-1,-1),(109,1,'asdasd',49,'2022-07-12 14:40:13',-1,-1),(110,1,'asdasd',49,'2022-07-12 14:40:15',-1,-1),(111,1,'asdasd',49,'2022-07-12 14:40:16',-1,-1),(112,1,'asdasd',49,'2022-07-12 15:11:00',-1,-1),(113,1,'asdasd',49,'2022-07-12 15:11:01',-1,-1),(114,1,'asdasdasd',49,'2022-07-12 15:11:12',-1,-1),(115,1,'asdasdasdsadasdasd',49,'2022-07-12 15:11:17',-1,-1),(116,1,'asdasdasdasdsad',49,'2022-07-12 15:11:20',-1,-1),(117,1,'a',49,'2022-07-12 15:11:58',-1,-1),(118,1,'b',49,'2022-07-12 15:12:00',-1,-1),(119,1,'c',49,'2022-07-12 15:12:02',-1,-1),(120,1,'asdasd',49,'2022-07-12 15:12:31',-1,1),(121,1,'cung dc',42,'2022-07-12 15:13:52',-1,-1),(122,1,'good',49,'2022-07-12 16:00:40',-1,1),(123,1,'sadsadasd',7,'2022-07-29 10:25:20',-1,-1),(124,1,'asdasdasd',7,'2022-07-29 10:25:38',-1,-1),(125,1,'sdfsdf',9,'2022-07-31 20:09:22',-1,1),(126,1,'asda',9,'2022-07-31 20:09:25',-1,1),(127,4,'Xinh dep tuyet voi ',59,'2022-08-01 16:59:15',-1,1),(128,4,'Very beautiful',59,'2022-08-01 16:59:42',-1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend_status`
--

LOCK TABLES `friend_status` WRITE;
/*!40000 ALTER TABLE `friend_status` DISABLE KEYS */;
INSERT INTO `friend_status` VALUES (43,5,1,1),(46,1,4,1),(47,6,1,1);
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
INSERT INTO `group_fb` VALUES (1,'Hội những người cô đơn','Group là nơi giao lưu ','2022-01-01 03:43:20',0,'https://cms.luatvietnam.vn/uploaded/Images/Original/2018/07/13/di-tu_1307171739.jpg'),(2,'Hội những anh em FA','Group FA','2022-01-01 03:43:20',0,'https://mcdn.coolmate.me/image/September2021/fa-la-gi-13.jpg'),(3,'Lập trình viên Java ','Group for JAVA','2022-01-01 03:43:20',0,'https://bizflyportal.mediacdn.vn/bizflyportal/364/347/2020/04/23/20/01/jav15876253130732.png'),(4,'bay nu cuoi xuan ','7 nu','2022-03-02 23:45:02',0,'https://i.ytimg.com/vi/F4XVra-nsxM/maxresdefault.jpg');
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
  `role` int DEFAULT '2',
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
INSERT INTO `like_page` VALUES (6,1,'2021-12-31 20:43:20',2),(1,1,'2021-12-31 20:43:20',1),(1,2,'2021-12-31 20:43:20',1);
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
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `user_to` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `user_to` (`user_to`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`user_to`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,1,5,'ALo','2021-12-31 20:43:20',1),(2,5,1,'ALo2','2021-12-31 20:43:21',2),(3,1,4,'ALo','2021-12-31 20:43:20',1),(4,4,1,'Hello em','2021-12-31 20:43:21',2),(5,1,4,'Hello em','2021-12-31 20:43:22',1),(6,4,1,'Hello em','2021-12-31 20:43:23',2),(7,1,6,'baba333','2021-12-31 20:43:26',1),(8,1,4,'yes','2022-07-31 20:35:54',1),(9,1,4,'yes','2022-07-31 20:36:06',1),(10,1,4,'ALo em','2022-08-01 09:43:10',1),(11,1,4,'Alo Son','2022-08-01 09:43:14',1),(12,1,4,'asd','2022-08-01 09:43:45',1),(13,1,4,'Hello Em','2022-08-01 10:24:31',1),(14,1,4,'Chào em','2022-08-01 10:25:15',1),(15,1,5,'Hello ','2022-08-01 10:38:36',1),(16,4,1,'??','2022-08-01 14:22:55',1),(17,4,1,'chuyện gì vậy','2022-08-01 14:22:59',1),(18,1,5,'sdfsd','2022-08-01 14:25:50',1);
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
  `forward_id` int DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (9,1,'Đã gửi cho bạn lời mời kết bạn',NULL,'2022-07-22 14:36:10',3,5),(12,4,'Đã gửi cho bạn lời mời kết bạn',NULL,'2022-07-22 17:08:49',3,1),(13,1,'Đã chấp nhận lời mời kết bạn',NULL,'2022-07-22 17:09:27',3,4),(14,4,'Đã đăng một bài viết mới','55','2022-07-24 17:44:32',1,1),(15,5,'Đã đăng một bài viết mới','55','2022-07-24 17:44:32',1,1),(16,1,'Đã gửi cho bạn lời mời kết bạn',NULL,'2022-07-27 14:10:31',3,6),(17,6,'Đã chấp nhận lời mời kết bạn',NULL,'2022-07-27 14:11:13',3,1);
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
  `background` varchar(500) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`page_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page`
--

LOCK TABLES `page` WRITE;
/*!40000 ALTER TABLE `page` DISABLE KEYS */;
INSERT INTO `page` VALUES (1,'Sơn Tùng MTP','Fanpage duy nhất của Sơn Tùng MTP','2021-12-31 20:43:20',0,'https://scontent.fdad3-1.fna.fbcdn.net/v/t1.6435-9/177935712_315062263309507_5381542721433177633_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=e3f864&_nc_ohc=wfIq7_j8ySAAX_CtuTy&_nc_ht=scontent.fdad3-1.fna&oh=00_AT-GL2Dhy-W5B0uvTBeSOgNYffjSINpgWnSQRzAp_KC7-w&oe=6260F07D','https://static2.yan.vn/YanNews/2167221/201904/ca-si-son-tung-mtp-la-ai-30b0e282.png'),(2,'Thiều Bảo Trâm ','Fanpage duy nhất của Thiều Bảo Trâm','2021-12-31 20:43:20',0,'https://scontent.fdad3-3.fna.fbcdn.net/v/t1.6435-9/180510285_301765567986382_7860148609185062803_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=e3f864&_nc_ohc=Dg9MzXsTjqsAX_zCUgQ&_nc_ht=scontent.fdad3-3.fna&oh=00_AT9aDgUYp0vUtki364qTtEQqyaefC_W052Ue8Ed-RIYwCw&oe=626131B1','https://media-cdn-v2.laodong.vn/storage/newsportal/2021/5/2/904726/Ts03-Love-Rosie---Th.jpeg?w=960&crop=auto&scale=both');
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
  `status` int DEFAULT '1',
  `tag` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (3,'Hôm nay tôi chia tay, buồn quá','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fimager_25787.jpg?alt=media&token=f718115d-88d9-487e-8bde-f34ef0b63e38',1,'2022-03-02 21:38:18',1,1,NULL),(5,'Tao là trùm Vỹ Dạ','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fgiangho.jpg?alt=media&token=de140eb7-ceb0-4d17-b6ff-6fcbd35c7441',3,'2022-03-02 21:43:22',0,1,NULL),(6,'Tôi buồn quá mọi người à','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Ftoibuon.jpg?alt=media&token=6f83c24d-3543-49cf-8986-5e28edd055cd',20,'2022-03-11 15:20:07',0,1,NULL),(7,'VIETNAMNUMBERONE','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fvietnam.jpg?alt=media&token=0cdd9839-cc5e-43eb-81ca-6739dce7d5d9',1,'2022-03-11 15:37:37',1,1,NULL),(8,'asdasd','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F4fj40e305jh98?alt=media&token=52d71543-a3cc-485b-af94-a50e61b785b4',6,'2022-03-16 08:43:38',0,1,NULL),(9,'hello world','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fgdce175a0ggj7?alt=media&token=534e588c-2b7a-4bef-bc05-73a46eaafd5d',1,'2022-03-16 14:59:55',1,1,NULL),(10,'A good day','',1,'2022-03-16 15:34:17',1,1,NULL),(11,'Đạo trời không thiên vị ai, luôn giúp đỡ cho người lương thiện. Lưới trời lồng lộng, tuy thưa nhưng khó lọt','',1,'2022-03-16 15:36:36',1,1,NULL),(12,'New Background','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fi8bf7d323588d?alt=media&token=02176a51-c1ac-4c00-b4f5-e9925d27089e',1,'2022-03-16 15:37:31',3,1,NULL),(13,'My idol','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fece2h8bcb11h8?alt=media&token=0cec58c7-3023-41c1-958e-2d7cf671e6ea',1,'2022-03-16 15:38:21',1,1,NULL),(25,'HM','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F6271967de454?alt=media&token=3b5381f2-404f-4784-86d5-d88d0ac6065a',1,'2022-03-16 17:16:07',1,-1,NULL),(28,'My friend','',1,'2022-03-23 23:08:51',1,1,NULL),(29,'My friend','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F23cj6dh2j4781?alt=media&token=80e8e6a1-9393-4aa4-b04f-45bb3454ebf5',1,'2022-03-23 23:09:28',1,-1,NULL),(30,'❌❌❌TÌM XE MÁY BỊ MẤT CẮP❌❌❌ Vào khoảng từ 3h đến 6h sáng ngày 21/03/2022, bạn mình bị mất một chiếc xe Honda Blade Đỏ Đen, mang biển kiểm soát 75M1-05691 tại  số 135 đường Nguyễn Minh Châu, Hòa Hải, Ngũ Hành Sơn, Đà Nẵng.  Hiện tại bạn mình đã trích xuất một số hình ảnh của xe từ camera an ninh, tuy nhiên chỉ có phần đầu xe nên khá khó để nhận diện.  Rất mong mọi người có thể SHARE bài viết này để giúp bạn mình có cơ hội tìm lại chiếc xe trên.  Mọi thông tin liên hệ SĐT: 0827299123 Trân trọng cảm ơn!','',4,'2022-03-24 09:40:42',2,1,NULL),(31,'Cây lớn sinh ra từ một cái mầm nhỏ; tháp cao chín tầng khởi đầu từ một sọt đất, đi xa ngàn dặm bắt đầu từ một bước chân.','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F718adic24gihb?alt=media&token=3af67c77-9bc9-488b-89ce-a55682378452',4,'2022-03-24 09:43:19',2,1,NULL),(32,'Baba bị covid','',1,'2022-03-24 09:53:50',1,-1,NULL),(33,'Baba bị covid ngu vcl','',1,'2022-03-24 11:03:48',0,-1,NULL),(34,'Con Covid này ác quá','',1,'2022-03-24 11:13:00',1,1,NULL),(35,'Hôm nay tôi buồn quá mọi người tôi đã bị mất xe rồi tôi ngu quá','',1,'2022-03-24 15:16:16',1,1,NULL),(36,'Baba bị covid','',1,'2022-03-24 15:26:06',1,1,NULL),(37,'hôm nay tôi muốn điểm cao','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fc05545i7jb83?alt=media&token=0804e772-99e8-4290-9050-d10a335ddc51',1,'2022-03-25 13:00:28',1,1,NULL),(38,'Hôm nay tôi thuyết trình 25/3/2022','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fi0j0a5ef9def?alt=media&token=c0f8e921-9c96-4d70-93b3-ee42a9a1fa71',1,'2022-03-25 13:40:31',1,1,NULL),(39,'Baba bị covid','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fc3ebe2d10df4?alt=media&token=5839708f-5e39-47db-aa3c-6eb81ad1fddd',1,'2022-03-25 13:42:05',1,1,NULL),(40,'hôm nay tôi muốn điểm cao','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F6ea6fd7a01gi4?alt=media&token=7fa6f2f0-4c1f-419a-b715-818ecc062f4e',1,'2022-04-27 21:28:42',0,-1,NULL),(41,'Seo phi`','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fef7bj005d2h1a?alt=media&token=a9589ac1-3eaf-4671-9871-9440386f05e6',1,'2022-05-11 17:42:17',0,-1,NULL),(42,'Ảnh này đẹp v','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F8ce0gj4327j85?alt=media&token=7b555fed-d6de-4b0a-bbd0-5db0662981af',1,'2022-06-13 20:55:55',1,1,NULL),(43,'','',1,'2022-07-07 13:57:00',0,-1,NULL),(49,'Đã đổi avatar ne','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F83e3c9343h369?alt=media&token=7f994fa6-0e01-4c8e-8c34-fa36aa63c711',1,'2022-07-11 13:43:39',1,-1,NULL),(50,'','',1,'2022-07-11 14:26:59',0,-1,NULL),(51,'Hello world','',1,'2022-07-11 15:28:04',0,-1,NULL),(52,'','',1,'2022-07-11 16:18:50',0,-1,NULL),(53,'','',1,'2022-07-11 16:19:33',0,-1,NULL),(54,'1','2',NULL,NULL,NULL,1,NULL),(55,'Jisoo mu xanh','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F9fc2323de6df?alt=media&token=26b2e200-71b2-4c92-8fe1-a6b4abb5de32',1,'2022-07-24 17:44:32',0,1,NULL),(56,'Đã đổi avatar','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fia0f85572cah7?alt=media&token=14f59364-5d3c-4bb8-bb9e-8d0424567c58',4,'2022-07-31 20:11:30',0,1,NULL),(57,'Đã đổi avatar','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F3daibb1jhej9j?alt=media&token=a1085fe6-d69c-4f22-ac58-0f99cd6ba428',1,'2022-08-01 11:11:54',0,1,NULL),(58,'Đã đổi avatar','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2F23e12e875g0ab?alt=media&token=45fed459-18e7-4a87-9aae-a65a3afb5e74',1,'2022-08-01 14:20:50',0,1,NULL),(59,'Đã đổi avatar','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fd23je1aij3bia?alt=media&token=811bdba3-6902-4ca0-af8e-d7b44e71116d',1,'2022-08-01 14:21:19',0,1,NULL),(60,'Đã đổi avatar','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fch486db0fa9i9?alt=media&token=d64ed91a-7c6d-4e0b-a0cd-9822a70c3835',4,'2022-08-01 14:22:40',0,1,NULL);
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
INSERT INTO `post_in_group` VALUES (5,3),(36,1),(37,1),(39,1);
/*!40000 ALTER TABLE `post_in_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `react`
--

DROP TABLE IF EXISTS `react`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `react` (
  `react_id` int NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `react`
--

LOCK TABLES `react` WRITE;
/*!40000 ALTER TABLE `react` DISABLE KEYS */;
INSERT INTO `react` VALUES (37,1,1,25),(40,1,1,11),(42,1,1,9),(45,1,4,30),(46,1,4,31),(47,1,1,31),(48,1,1,30),(57,1,1,35),(65,1,1,12),(69,1,1,39),(71,1,1,34),(72,1,1,36),(75,1,1,37),(78,1,1,7),(79,1,1,42),(81,1,1,28),(85,1,1,29),(86,1,1,10),(87,1,1,38),(91,1,1,32),(93,1,1,49),(94,1,1,13),(95,1,1,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'thesoonafu@gmail.com','MTIz','Nguyễn Hoài Thùy Linh','0827299123',1,'Anh không làm được nhưng anh hứa được',0,'Huế','2021-12-31 20:43:20','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fd23je1aij3bia?alt=media&token=811bdba3-6902-4ca0-af8e-d7b44e71116d','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang',NULL,1),(3,'ngoluongdanvanngu@gmail.com','MTIz','Ngô Hoàng Sơn','0828282822',1,'Sơn Xấu',0,'Huế','2022-01-01 03:43:20','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang',NULL,1),(4,'tranvanson@gmail.com','MTIz','Hoàng Văn Thái','0228288282',1,'Thái đẹp trai',0,'Đà Nẵng','2022-01-01 03:43:20','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2Fch486db0fa9i9?alt=media&token=d64ed91a-7c6d-4e0b-a0cd-9822a70c3835','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang',NULL,1),(5,'tranthithuhoai@gmail.com','MTIz','Trần Đức Bo','0387372727',1,'Who',0,'Đà Nẵng','2022-01-01 03:43:20','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang',NULL,1),(6,'babangu@gmail.com','MTIz','Thái Văn Cơ','0477372772',1,':( ',0,'Đà Nẵng','2022-01-01 03:43:20','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang',NULL,1),(20,'huycute@gmail.com','MTIz','Lê Hoàng Anh','none',0,'none',0,'none','2022-03-11 13:39:09','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Da Nang','2022-03-31 00:00:00',1),(21,'ltd@gmail.com','MTIz','Trần Đình Dũng','none',0,'Em khong la nang tho',0,'Quảng Bình','2022-03-14 16:27:54','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652','Đà Nẵng','2001-06-19 00:00:00',1),(22,'dungbone@gmail.com','MTIzMTIz','Hoàng Thùy Chi','none',0,'none',0,'none','2022-03-14 16:31:47','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaulAvatarFemale.png?alt=media&token=0fc589be-e8b1-42db-a16b-0b4a9333513b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652',NULL,'2022-11-29 00:00:00',2),(23,'vbvc2001@gmail.com','MTIzMTIzMTIz','Trần Văn Hoàng','none',0,'none',0,'none','2022-03-14 16:32:17','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaulAvatarFemale.png?alt=media&token=0fc589be-e8b1-42db-a16b-0b4a9333513b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652',NULL,'2022-11-29 00:00:00',2),(24,'httm.m@gmail.com','MTIzMTIz','Đình Văn Dũng','none',0,'none',0,'none','2022-03-14 16:33:05','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaulAvatarFemale.png?alt=media&token=0fc589be-e8b1-42db-a16b-0b4a9333513b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652',NULL,'2001-01-16 00:00:00',2),(25,'xuanaile@gmail.com','MTIzMTIzMTIz','Xuân Ái Lê','none',0,'none',0,'none','2022-03-14 16:33:29','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaulAvatarFemale.png?alt=media&token=0fc589be-e8b1-42db-a16b-0b4a9333513b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652',NULL,'2001-01-16 00:00:00',2),(26,'dohhh@gmail.com','MTIzMTIz','Nguyễn Văn A','none',0,'none',0,'none','2022-03-25 11:18:49','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652',NULL,'2022-03-15 00:00:00',1),(27,'thaya@gmail.com','MTIzMTIzMTIz','Thầy A','none',0,'none',0,'none','2022-03-25 13:37:29','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b','https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultBackground.png?alt=media&token=1593e00a-c090-4ac3-9cf7-2863b71d1652',NULL,'2001-03-24 00:00:00',1);
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

-- Dump completed on 2022-08-02 16:00:02
