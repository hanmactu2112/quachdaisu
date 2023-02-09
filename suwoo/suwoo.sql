-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: suwoo
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKnu1hnaxdmf6lnlr9vniit5rsn` FOREIGN KEY (`id`) REFERENCES `nguoi_dung` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (26),(28),(133),(171);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `camera`
--

DROP TABLE IF EXISTS `camera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `camera` (
  `id` bigint NOT NULL,
  `dophangiai` varchar(10) DEFAULT NULL,
  `loai` varchar(255) DEFAULT NULL,
  `tinhnang` varchar(255) DEFAULT NULL,
  `dienthoai_id` bigint DEFAULT NULL,
  `dophangiaicamera` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK68asfahh3qu1sug0udh7ek0gt` (`dienthoai_id`),
  CONSTRAINT `FK68asfahh3qu1sug0udh7ek0gt` FOREIGN KEY (`dienthoai_id`) REFERENCES `dienthoai` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camera`
--

LOCK TABLES `camera` WRITE;
/*!40000 ALTER TABLE `camera` DISABLE KEYS */;
INSERT INTO `camera` VALUES (388,NULL,'Camera sau','Xóa phông',NULL,'40 MP'),(389,NULL,'Camera trước','Xóa phông',NULL,'120 MP'),(398,NULL,'Camera sau','aaaaaaaaa',NULL,'40 MP'),(399,NULL,'Camera trước','aaasasdfsds',NULL,'120 MP'),(468,NULL,'Camera sau','',NULL,'40 MP'),(469,NULL,'Camera trước','',NULL,'120 MP'),(481,NULL,'Camera sau','fss',NULL,'40 MP'),(482,NULL,'Camera trước','sdsds',NULL,'120 MP'),(496,NULL,'Camera sau','fss',NULL,'40 MP'),(497,NULL,'Camera trước','sdsds',NULL,'120 MP'),(505,NULL,'Camera sau','fss',NULL,'40 MP'),(506,NULL,'Camera trước','sdsds',NULL,'120 MP'),(514,NULL,'Camera sau','fss',NULL,'40 MP'),(515,NULL,'Camera trước','sdsds',NULL,'120 MP'),(523,NULL,'Camera sau','fss',NULL,'40 MP'),(524,NULL,'Camera trước','sdsds',NULL,'120 MP'),(532,NULL,'Camera sau','fss',NULL,'40 MP'),(533,NULL,'Camera trước','sdsds',NULL,'120 MP'),(541,NULL,'Camera sau','fss',NULL,'40 MP'),(542,NULL,'Camera trước','sdsds',NULL,'120 MP'),(550,NULL,'Camera sau','fss',NULL,'40 MP'),(551,NULL,'Camera trước','sdsds',NULL,'120 MP'),(558,NULL,'Camera sau','fss',NULL,'40 MP'),(559,NULL,'Camera trước','sdsds',NULL,'120 MP'),(574,NULL,'Camera sau','fss',NULL,'40 MP'),(575,NULL,'Camera trước','sdsds',NULL,'120 MP'),(582,NULL,'Camera sau','fss',NULL,'40 MP'),(583,NULL,'Camera trước','sdsds',NULL,'120 MP'),(590,NULL,'Camera sau','aaaaaaaaa',NULL,'40 MP'),(591,NULL,'Camera trước','aaasasdfsds',NULL,'120 MP'),(599,NULL,'Camera sau','aaaaaaaaa',NULL,'40 MP'),(600,NULL,'Camera trước','aaasasdfsds',NULL,'120 MP'),(607,NULL,'Camera sau','fss',NULL,'40 MP'),(608,NULL,'Camera trước','sdsds',NULL,'120 MP'),(615,NULL,'Camera sau','fss',NULL,'40 MP'),(616,NULL,'Camera trước','sdsds',NULL,'120 MP'),(663,NULL,'Camera sau','fss',NULL,'40 MP'),(664,NULL,'Camera trước','sdsds',NULL,'120 MP'),(674,NULL,'Camera sau','aaaaaaaaa',NULL,'40 MP'),(675,NULL,'Camera trước','aaasasdfsds',NULL,'120 MP'),(783,NULL,'','2xsasaas',NULL,'12'),(875,NULL,'','dsdsds',NULL,'12'),(886,NULL,'','ewdsfdsa',NULL,'12'),(895,NULL,'','xfsgsf',NULL,'12'),(906,NULL,NULL,'xfsgsf',NULL,'12'),(914,NULL,NULL,'xfsgsf',NULL,'12'),(921,NULL,NULL,'xfsgsf',NULL,'12'),(928,NULL,NULL,'xfsgsf',NULL,'12'),(935,NULL,NULL,'xfsgsf',NULL,'12'),(942,NULL,NULL,'xfsgsf',NULL,'12'),(949,NULL,NULL,'xfsgsf',NULL,'12'),(956,NULL,NULL,'xfsgsf',NULL,'12'),(963,NULL,NULL,'xfsgsf',NULL,'12'),(970,NULL,NULL,'xfsgsf',NULL,'12'),(977,NULL,NULL,'xfsgsf',NULL,'12'),(986,NULL,NULL,'xfsgsf',NULL,'12'),(993,NULL,NULL,'xfsgsf',NULL,'12'),(1000,NULL,NULL,'xfsgsf',NULL,'12'),(1007,NULL,NULL,'xfsgsf',NULL,'12'),(1047,NULL,NULL,'xfsgsf',NULL,'12'),(1055,NULL,NULL,'xfsgsf',NULL,'12'),(1063,NULL,NULL,'xfsgsf',NULL,'12'),(1071,NULL,NULL,'xfsgsf',NULL,'12'),(1078,NULL,NULL,'xfsgsf',NULL,'12'),(1085,NULL,NULL,'xfsgsf',NULL,'12'),(1092,NULL,NULL,'xfsgsf',NULL,'12'),(1100,NULL,NULL,'xfsgsf',NULL,'12'),(1121,NULL,NULL,'xfsgsf',NULL,'12'),(1128,NULL,NULL,'xfsgsf',NULL,'12'),(1135,NULL,NULL,'xfsgsf',NULL,'12'),(1142,NULL,NULL,'xfsgsf',NULL,'12'),(1157,NULL,'Camera sau','aaaaaaaaa',NULL,'40 MP'),(1158,NULL,'Camera trước','aaasasdfsds',NULL,'120 MP'),(1166,NULL,NULL,'fsafadfa',NULL,'12MP'),(1179,NULL,NULL,'xfsgsf',NULL,'12'),(1190,NULL,'Camera sau','fss',NULL,'40 MP'),(1191,NULL,'Camera trước','sdsds',NULL,'120 MP'),(1201,NULL,'Camera sau','fss',NULL,'40 MP'),(1202,NULL,'Camera trước','sdsds',NULL,'120 MP'),(1209,NULL,'Camera sau','fss',NULL,'40 MP'),(1210,NULL,'Camera trước','sdsds',NULL,'120 MP'),(1217,NULL,'Camera sau','fss',NULL,'40 MP'),(1218,NULL,'Camera trước','sdsds',NULL,'120 MP'),(1240,NULL,'Camera sau','fss',NULL,'40 MP'),(1241,NULL,'Camera trước','sdsds',NULL,'120 MP'),(1248,NULL,'Camera sau','fss',NULL,'40 MP'),(1249,NULL,'Camera trước','sdsds',NULL,'120 MP'),(1264,NULL,'Camera sau','fss',NULL,'40 MP'),(1265,NULL,'Camera trước','sdsds',NULL,'120 MP'),(1284,NULL,'Camera sau','fss',NULL,'40 MP'),(1285,NULL,'Camera trước','sdsds',NULL,'120 MP'),(1292,NULL,'Camera sau','fss',NULL,'40 MP'),(1293,NULL,'Camera trước','sdsds',NULL,'120 MP'),(1300,NULL,'Camera sau','fss',NULL,'40 MP'),(1301,NULL,'Camera trước','sdsds',NULL,'120 MP'),(1329,NULL,'Camera sau','Quay video 4K, Xóa phông',NULL,'12 MP'),(1330,NULL,'Camera trước','Zoom quang học, Quay chậm (Slow Motion), Trôi nhanh thời gian (Time Lapse)',NULL,'2 camera 12 MP'),(1331,NULL,'Camera sau','Quay video 4K, Xóa phông',NULL,'12 MP'),(1332,NULL,'Camera trước','Zoom quang học, Quay chậm (Slow Motion), Trôi nhanh thời gian (Time Lapse)',NULL,'2 camera 12 MP'),(1385,NULL,'Camera trước','Chụp bằng cử chỉ, Xóa phông, Quay video Full HD',1374,'32 MP'),(1386,NULL,'Camera sau','Zoom kỹ thuật số, Siêu cận (Macro), Góc siêu rộng (Ultrawide), Siêu độ phân giải',1374,'Chính 50 MP & Phụ 8 MP, 2 MP'),(1400,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), Tự động lấy nét (AF), Làm đẹp',1388,' 16 MP'),(1401,NULL,'Camera sau','Quay video hiển thị kép, Chuyên nghiệp (Pro), HDR, Toàn cảnh (Panorama)',1388,' Chính 108 MP & Phụ 8 MP, 2 MP'),(1415,NULL,'Camera trước','Quay video 4K, Cinematic, Trôi nhanh thời gian (Time Lapse), Tự động lấy nét (AF)',NULL,'12 MP'),(1416,NULL,'Camera sau','Quay Siêu chậm (Super Slow Motion), Toàn cảnh (Panorama), Chống rung quang học (OIS), Chế độ hành động (Action Mode)',NULL,'2 camera 12 MP'),(1429,NULL,'Camera trước','Nhãn dán (AR Stickers), Quay video 4K, Tự động lấy nét (AF), Nhận diện khuôn mặt',NULL,'12 MP'),(1430,NULL,'Camera sau','FullHD 1080p@60fps, 4K 2160p@60fps, FullHD 1080p@120fps',NULL,'2 camera 12 MP'),(1442,NULL,'Camera trước','Nhãn dán (AR Stickers), Quay video 4K, Tự động lấy nét (AF), Nhận diện khuôn mặt',1431,'12 MP'),(1443,NULL,'Camera sau','Tự động lấy nét (AF), Nhận diện khuôn mặt, Toàn cảnh (Panorama), Chống rung quang học (OIS)',1431,'2 camera 12 MP'),(1455,NULL,'Camera trước','Quay video 4K, Cinematic, Trôi nhanh thời gian (Time Lapse), Tự động lấy nét (AF)',1444,'12 MP'),(1456,NULL,'Camera sau','Toàn cảnh (Panorama), Chống rung quang học (OIS), Chế độ hành động (Action Mode), Ban đêm (Night Mode)',1444,'Chính 48 MP & Phụ 12 MP, 12 MP'),(1457,NULL,'Camera trước','Nhãn dán (AR Stickers), Quay video 4K, Tự động lấy nét (AF), Nhận diện khuôn mặt',1417,'12 MP'),(1458,NULL,'Camera sau','Toàn cảnh (Panorama), Chống rung quang học (OIS), Chế độ hành động (Action Mode), Ban đêm (Night Mode)',1417,'2 camera 12 MP'),(1465,NULL,'Camera trước','Quay video 4K, Cinematic, Trôi nhanh thời gian (Time Lapse), Tự động lấy nét (AF)',1402,'12 MP'),(1466,NULL,'Camera sau','Quay Siêu chậm (Super Slow Motion), Toàn cảnh (Panorama), Chống rung quang học (OIS), Chế độ hành động (Action Mode)',1402,'2 camera 12 MP'),(1484,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), Tự động lấy nét (AF), Nhận diện khuôn mặt, Làm đẹp',NULL,'40 MP'),(1485,NULL,'Camera sau','Quay video hiển thị kép, Chuyên nghiệp (Pro), Tự động lấy nét (AF), HDR',NULL,'Chính 108 MP & Phụ 12 MP, 10 MP, 10 MP'),(1497,NULL,'Camera trước','Quay video 4K, Trôi nhanh thời gian (Time Lapse), Tự động lấy nét (AF), Nhận diện khuôn mặt',NULL,'10 MP'),(1498,NULL,'Camera sau','Quay Siêu chậm (Super Slow Motion), Chuyên nghiệp (Pro), Tự động lấy nét (AF), HDR',NULL,'Chính 50 MP & Phụ 12 MP, 10 MP'),(1510,NULL,'Camera trước','Nhận diện khuôn mặt, Làm đẹp, HDR, Quay video Full HD',NULL,'32 MP'),(1511,NULL,'Camera sau','Chuyên nghiệp (Pro), Tự động lấy nét (AF), Chạm lấy nét, Nhận diện khuôn mặt',NULL,' Chính 108 MP & Phụ 12 MP, 5 MP, 5 MP'),(1523,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), Làm đẹp, Quay video Full HD, Toàn cảnh (Panorama)',1512,' 16 MP'),(1524,NULL,'Camera sau','Lấy nét theo pha (PDAF), AI Camera, Chuyên nghiệp (Pro), HDR',1512,'Chính 48 MP & Phụ 2 MP, 2 MP'),(1536,NULL,'Camera trước','Nhãn dán (AR Stickers), Làm đẹp A.I, Trôi nhanh thời gian (Time Lapse), Nhận diện khuôn mặt',1525,' 16 MP'),(1537,NULL,'Camera sau','AI Camera, Chuyên nghiệp (Pro), HDR, Toàn cảnh (Panorama)',1525,'Chính 64 MP & Phụ 2 MP, 2 MP'),(1549,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), Làm đẹp, HDR, Quay video Full HD',1538,'8 MP'),(1550,NULL,'Camera sau','Chuyên nghiệp (Pro), HDR, Toàn cảnh (Panorama), Nhãn dán (AR Stickers)',1538,' Chính 50 MP & Phụ 2 MP'),(1562,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), Làm đẹp, HDR, Toàn cảnh (Panorama)',1551,'8 MP'),(1563,NULL,'Camera sau','Chuyên nghiệp (Pro), HDR, Toàn cảnh (Panorama), Nhãn dán (AR Stickers)',1551,' Chính 13 MP & Phụ 2 MP'),(1575,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), HDR, Quay video Full HD, Toàn cảnh (Panorama)',NULL,'8 MP'),(1576,NULL,'Camera sau','Chuyên nghiệp (Pro), HDR, Toàn cảnh (Panorama), Nhãn dán (AR Stickers)',NULL,'Trôi nhanh thời gian (Time Lapse)  HDR  Quay video Full HD  Toàn cảnh (Panorama)'),(1588,NULL,'Camera trước','Tự động lấy nét (AF), Nhận diện khuôn mặt, Làm đẹp, HDR',1577,' 16 MP'),(1589,NULL,'Camera sau','Chuyên nghiệp (Pro), Tự động lấy nét (AF), Chạm lấy nét, Nhận diện khuôn mặt',1577,'Chính 50 MP & Phụ 2 MP, 2 MP'),(1601,NULL,'Camera trước','Nhãn dán (AR Stickers), Trôi nhanh thời gian (Time Lapse), Làm đẹp, HDR',1590,' 5 MP'),(1602,NULL,'Camera sau','AI Camera, Chuyên nghiệp (Pro), HDR, Toàn cảnh (Panorama)',1590,'Chính 50 MP & Phụ 0.3 MP'),(1614,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), Làm đẹp, HDR, Quay video Full HD',NULL,'32 MP'),(1615,NULL,'Camera sau','Quay video hiển thị kép, Chuyên nghiệp (Pro), Tự động lấy nét (AF), HDR',NULL,'Chính 50 MP & Phụ 8 MP, 2 MP'),(1626,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), HDR, Quay video Full HD, Toàn cảnh (Panorama)',NULL,'32 MP'),(1627,NULL,'Camera sau','Quay video hiển thị kép, Ảnh Raw, Chuyên nghiệp (Pro), Nhận diện khuôn mặt',NULL,'3 camera 50 MP'),(1628,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), Làm đẹp, HDR, Quay video Full HD',1604,'32 MP'),(1629,NULL,'Camera sau','Quay video hiển thị kép, Chuyên nghiệp (Pro), Tự động lấy nét (AF), HDR',1604,'Chính 50 MP & Phụ 8 MP, 2 MP'),(1636,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), HDR, Quay video Full HD, Toàn cảnh (Panorama)',1616,'32 MP'),(1637,NULL,'Camera sau','Quay video hiển thị kép, Ảnh Raw, Chuyên nghiệp (Pro), Nhận diện khuôn mặt',1616,'3 camera 50 MP'),(1654,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), Nhận diện khuôn mặt, Làm đẹp, HDR',1644,' 20 MP'),(1655,NULL,'Camera sau','AI Camera, Chuyên nghiệp (Pro), Nhận diện khuôn mặt, HDR',1644,' Chính 200 MP & Phụ 8 MP, 2 MP'),(1666,NULL,'Camera trước','Tự động lấy nét (AF), Nhận diện khuôn mặt, Làm đẹp, HDR',1656,' 20 MP'),(1667,NULL,'Camera sau','AI Camera, Tự động lấy nét (AF), Chạm lấy nét, Nhận diện khuôn mặt',1656,'Chính 64 MP & Phụ 8 MP, 5 MP'),(1678,NULL,'Camera trước','Tự động lấy nét (AF), Nhận diện khuôn mặt, Làm đẹp, Quay video Full HD',1668,'16 MP'),(1679,NULL,'Camera sau','Quay Siêu chậm (Super Slow Motion), Lấy nét theo pha (PDAF), AI Camera, Chuyên nghiệp (Pro)',1668,'Chính 108 MP & Phụ 8 MP, 5 MP, 2 MP'),(1690,NULL,'Camera trước','Làm đẹp, HDR, Xóa phông, Bộ lọc màu',1680,' 5 MP'),(1691,NULL,'Camera sau','Chuyên nghiệp (Pro), HDR, Ban đêm (Night Mode), Trôi nhanh thời gian (Time Lapse)',1680,'Chính 13 MP & Phụ 2 MP'),(1702,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), Làm đẹp, HDR, Quay video Full HD',1692,'5 MP'),(1703,NULL,'Camera sau','Chuyên nghiệp (Pro), Chạm lấy nét, HDR, Toàn cảnh (Panorama)',1692,'Chính 50 MP & Phụ 2 MP'),(1714,NULL,'Camera trước','Nhận diện khuôn mặt, HDR, Quay video Full HD, Xóa phông',1704,' 32 MP'),(1715,NULL,'Camera sau','Quay Siêu chậm (Super Slow Motion), Lấy nét theo pha (PDAF), Chuyên nghiệp (Pro), Tự động lấy nét (AF)',1704,'Chính 108 MP & Phụ 8 MP, 2 MP, 2 MP'),(1726,NULL,'Camera trước','Tự động lấy nét (AF), Nhận diện khuôn mặt, Làm đẹp, Quay video Full HD',1716,' 32 MP'),(1727,NULL,'Camera sau','AI Camera, Làm đẹp (Beautify), Tự động lấy nét (AF), Chạm lấy nét',1716,' Chính 12 MP & Phụ 12 MP, 8 MP'),(1739,NULL,'Camera trước','Làm đẹp, HDR, Quay video Full HD, Quay video HD',1729,' 32 MP'),(1740,NULL,'Camera sau','Quay video hiển thị kép, Lấy nét bằng laser, Chuyên nghiệp (Pro), Toàn cảnh (Panorama)',1729,'Chính 50 MP & Phụ 12 MP, 12 MP'),(1751,NULL,'Camera trước','Nhãn dán (AR Stickers), Làm đẹp, HDR, Quay video Full HD',1741,' 32 MP'),(1752,NULL,'Camera sau','AI Camera, Chuyên nghiệp (Pro), Tự động lấy nét (AF), HDR',1741,' Chính 64 MP & Phụ 8 MP, 2 MP'),(1810,NULL,NULL,'',NULL,'Full HD 1080p'),(1823,NULL,NULL,'',NULL,'Full HD 1080p'),(1917,NULL,NULL,'',NULL,'Full HD 1080p'),(2044,NULL,NULL,'',NULL,'Full HD 1080p'),(2107,NULL,NULL,'aaaa',NULL,'12MP'),(2123,NULL,NULL,'aaaa',NULL,'12MP'),(2132,NULL,NULL,'aaaa',NULL,'12MP'),(2144,NULL,NULL,'',NULL,'Full HD 1080p'),(2153,NULL,NULL,'',NULL,'Full HD 1080p'),(2165,NULL,NULL,'',NULL,' Full HD Webcam'),(2179,NULL,NULL,'',NULL,' Full HD Webcam'),(2192,NULL,NULL,'',NULL,' Full HD Webcam'),(2202,NULL,NULL,'',NULL,' Full HD Webcam'),(2216,NULL,NULL,'',NULL,' Full HD Webcam'),(2230,NULL,NULL,'',NULL,' Full HD Webcam'),(2244,NULL,NULL,'',NULL,' Full HD Webcam'),(2258,NULL,NULL,'',NULL,' Full HD Webcam'),(2300,NULL,NULL,'',NULL,' Full HD Webcam'),(2314,NULL,NULL,'',NULL,' Full HD Webcam'),(2328,NULL,NULL,'',NULL,' Full HD Webcam'),(2342,NULL,NULL,'',NULL,' Full HD Webcam'),(2355,NULL,NULL,'',NULL,'Không có'),(2364,NULL,NULL,'',NULL,'Không có'),(2374,NULL,NULL,'',NULL,' Full HD Webcam'),(2387,NULL,NULL,'',NULL,' Full HD Webcam'),(2397,NULL,NULL,'',NULL,' Full HD Webcam'),(2411,NULL,NULL,'',NULL,' Full HD Webcam'),(2425,NULL,NULL,'',NULL,' Full HD Webcam'),(2439,NULL,NULL,'',NULL,' Full HD Webcam'),(2453,NULL,NULL,'',NULL,' Full HD Webcam'),(2467,NULL,NULL,'',NULL,' Full HD Webcam'),(2481,NULL,NULL,'',NULL,' Full HD Webcam'),(2495,NULL,NULL,'',NULL,' Full HD Webcam'),(2509,NULL,NULL,'',NULL,' Full HD Webcam'),(2523,NULL,NULL,'',NULL,'Trước: 5 MP - Sau: 10 MP, quay video 4K'),(2537,NULL,NULL,'',NULL,' Full HD Webcam'),(2551,NULL,NULL,'',NULL,' Full HD Webcam'),(2565,NULL,NULL,'',NULL,' Full HD Webcam'),(2582,NULL,NULL,'',NULL,'Full HD 1080p'),(2591,NULL,NULL,'',NULL,'Full HD 1080p'),(2605,NULL,NULL,'xfsgsf',NULL,'12'),(2617,NULL,NULL,'',NULL,'Full HD 1080p'),(2626,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), HDR, Quay video Full HD, Toàn cảnh (Panorama)',1564,'8 MP'),(2627,NULL,'Camera sau','Chuyên nghiệp (Pro), HDR, Toàn cảnh (Panorama), Nhãn dán (AR Stickers)',1564,'64 MP'),(2634,NULL,'Camera trước','Trôi nhanh thời gian (Time Lapse), Tự động lấy nét (AF), Nhận diện khuôn mặt, Làm đẹp',1473,'40 MP'),(2635,NULL,'Camera sau','Quay video hiển thị kép, Chuyên nghiệp (Pro), Tự động lấy nét (AF), HDR',1473,'Chính 108 MP & Phụ 12 MP, 10 MP, 10 MP'),(2642,NULL,'Camera trước','Quay video 4K, Trôi nhanh thời gian (Time Lapse), Tự động lấy nét (AF), Nhận diện khuôn mặt',1486,'10 MP'),(2643,NULL,'Camera sau','Quay Siêu chậm (Super Slow Motion), Chuyên nghiệp (Pro), Tự động lấy nét (AF), HDR',1486,'Chính 50 MP & Phụ 12 MP, 10 MP'),(2650,NULL,'Camera trước','Nhận diện khuôn mặt, Làm đẹp, HDR, Quay video Full HD',1499,'32 MP'),(2651,NULL,'Camera sau','Chuyên nghiệp (Pro), Tự động lấy nét (AF), Chạm lấy nét, Nhận diện khuôn mặt',1499,' Chính 108 MP & Phụ 12 MP, 5 MP, 5 MP');
/*!40000 ALTER TABLE `camera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL,
  `loai` varchar(255) DEFAULT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (349,'dienthoai','Điện thoại SamSung','SamSung'),(449,'dienthoai','Điện thoại Iphone','Iphone'),(450,'dienthoai','Điện thoại oppo','Oppo'),(685,'dienthoai','Điện thoại oppo 2022','Oppo 2022'),(794,'laptop','San pham laptop','Laptop'),(1238,'dienthoai','Danh mục những sản phẩm điện thoại nokia','Nokia'),(1239,'phukien','Phụ kiện tai nghe','Tai nghe'),(1281,'phukien','Sạc dự phòng','Sạc dự phòng'),(1387,'dienthoai','Xiaomi','Xiaomi'),(1728,'dienthoai','Điện thoại Vivo','Vivo'),(1832,'laptop','Laptop Macbook','Macbook'),(2162,'laptop','Laptop gaming','Laptop Gaming'),(2163,'laptop','Laptop văn phòng','Laptop văn phòng');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dienthoai`
--

DROP TABLE IF EXISTS `dienthoai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dienthoai` (
  `id` bigint NOT NULL,
  `thiet_ke` varchar(255) DEFAULT NULL,
  `dthedieuhanhcpu_id` bigint DEFAULT NULL,
  `dtketnoi_id` bigint DEFAULT NULL,
  `dtbonho_id` bigint DEFAULT NULL,
  `manhinh_id` bigint DEFAULT NULL,
  `kichthuoctrongluong_id` bigint DEFAULT NULL,
  `pin_id` bigint DEFAULT NULL,
  `tienich_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdl5pnm9bpwxun9n1bbwegwgl9` (`dthedieuhanhcpu_id`),
  KEY `FKsipargumbeb8glpxi45int51l` (`dtketnoi_id`),
  KEY `FKj81rk4ah0wf4rda8uhf5dxti9` (`dtbonho_id`),
  KEY `FKbpomkqx685h5kxajn1ylkyhm3` (`manhinh_id`),
  KEY `FKkea27j1nl7phg1npfjr8w9lx` (`kichthuoctrongluong_id`),
  KEY `FK6xtpvppwlaxtjecog5mw6dype` (`pin_id`),
  KEY `FK6l0rpwe28aseyn28a8cbej26q` (`tienich_id`),
  CONSTRAINT `FK6l0rpwe28aseyn28a8cbej26q` FOREIGN KEY (`tienich_id`) REFERENCES `tienich` (`id`),
  CONSTRAINT `FK6xtpvppwlaxtjecog5mw6dype` FOREIGN KEY (`pin_id`) REFERENCES `pin` (`id`),
  CONSTRAINT `FKabs7poiaacqh783u4lr7sioei` FOREIGN KEY (`id`) REFERENCES `sanpham` (`id`),
  CONSTRAINT `FKbpomkqx685h5kxajn1ylkyhm3` FOREIGN KEY (`manhinh_id`) REFERENCES `manhinh` (`id`),
  CONSTRAINT `FKdl5pnm9bpwxun9n1bbwegwgl9` FOREIGN KEY (`dthedieuhanhcpu_id`) REFERENCES `dthedieuhanhcpu` (`id`),
  CONSTRAINT `FKj81rk4ah0wf4rda8uhf5dxti9` FOREIGN KEY (`dtbonho_id`) REFERENCES `dtbonho` (`id`),
  CONSTRAINT `FKkea27j1nl7phg1npfjr8w9lx` FOREIGN KEY (`kichthuoctrongluong_id`) REFERENCES `kichthuoctrongluong` (`id`),
  CONSTRAINT `FKsipargumbeb8glpxi45int51l` FOREIGN KEY (`dtketnoi_id`) REFERENCES `dtketnoi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dienthoai`
--

LOCK TABLES `dienthoai` WRITE;
/*!40000 ALTER TABLE `dienthoai` DISABLE KEYS */;
INSERT INTO `dienthoai` VALUES (1374,'Nguyên khối',1376,76,1375,1378,1377,1379,1380),(1388,'Nguyên khối',1390,77,1389,1392,1391,1393,1394),(1402,'Nguyên khối',1468,83,1467,1470,1469,1471,1472),(1417,'Nguyên khối',1460,82,1459,1462,1461,1463,1464),(1431,'Nguyên khối',1433,80,1432,1435,1434,1436,1437),(1444,'Nguyên khối',1446,81,1445,1448,1447,1449,1450),(1473,'Nguyên khối',2637,108,2636,2639,2638,2640,2641),(1486,'Nguyên khối',2645,109,2644,2647,2646,2648,2649),(1499,'Nguyên khối',2653,110,2652,2655,2654,2656,2657),(1512,'Nguyên khối',1514,87,1513,1516,1515,1517,1518),(1525,'Nguyên khối',1527,88,1526,1529,1528,1530,1531),(1538,'Nguyên khối',1540,89,1539,1542,1541,1543,1544),(1551,'Nguyên khối',1553,90,1552,1555,1554,1556,1557),(1564,'Nguyên khối',2629,107,2628,2631,2630,2632,2633),(1577,'Nguyên khối',1579,92,1578,1581,1580,1582,1583),(1590,'Nguyên khối',1592,93,1591,1594,1593,1595,1596),(1604,'Nguyên khối',1631,96,1630,1633,1632,1634,1635),(1616,'Nguyên khối',1639,97,1638,1641,1640,1642,1643),(1644,'Nguyên khối',1646,98,1645,1648,1647,1649,1650),(1656,'Nguyên khối',1658,99,1657,1660,1659,1661,1662),(1668,'Nguyên khối',1670,100,1669,1672,1671,1673,1674),(1680,'Nguyên khối',1682,101,1681,1684,1683,1685,1686),(1692,'Nguyên khối',1694,102,1693,1696,1695,1697,1698),(1704,'Nguyên khối',1706,103,1705,1708,1707,1709,1710),(1716,'Nguyên khối',1718,104,1717,1720,1719,1721,1722),(1729,'Nguyên khối',1731,105,1730,1733,1732,1734,1735),(1741,'Nguyên khối',1743,106,1742,1745,1744,1746,1747);
/*!40000 ALTER TABLE `dienthoai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dtbonho`
--

DROP TABLE IF EXISTS `dtbonho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dtbonho` (
  `id` bigint NOT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `rom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dtbonho`
--

LOCK TABLES `dtbonho` WRITE;
/*!40000 ALTER TABLE `dtbonho` DISABLE KEYS */;
INSERT INTO `dtbonho` VALUES (379,'6 GB','512 GB'),(391,'6 GB','128 GB'),(461,'6 GB','512 GB'),(471,'6 GB','512 GB'),(498,'6 GB','512 GB'),(507,'6 GB','512 GB'),(516,'6 GB','512 GB'),(525,'6 GB','512 GB'),(534,'6 GB','512 GB'),(543,'6 GB','512 GB'),(552,'6 GB','512 GB'),(560,'6 GB','512 GB'),(576,'6 GB','512 GB'),(584,'6 GB','512 GB'),(592,'6 GB','128 GB'),(601,'6 GB','128 GB'),(609,'6 GB','512 GB'),(617,'6 GB','512 GB'),(665,'6 GB','512 GB'),(676,'6 GB','128 GB'),(1159,'6 GB','128 GB'),(1192,'6 GB','512 GB'),(1203,'6 GB','512 GB'),(1211,'6 GB','512 GB'),(1219,'6 GB','512 GB'),(1242,'6 GB','512 GB'),(1250,'6 GB','512 GB'),(1266,'6 GB','512 GB'),(1286,'6 GB','512 GB'),(1294,'6 GB','512 GB'),(1302,'6 GB','512 GB'),(1318,'6 GB','512 GB'),(1333,'6 GB','512 GB'),(1375,'8 GB','256 GB'),(1389,'8 GB','128 GB'),(1403,'6 GB','128 GB'),(1418,'4 GB','64 GB'),(1432,'4 GB','64 GB'),(1445,'6 GB','512 GB'),(1459,'4 GB','64 GB'),(1467,'6 GB','128 GB'),(1474,'12 GB','256 GB'),(1487,'8 GB','128 GB'),(1500,'8 GB','128 GB'),(1513,'8 GB','128 GB'),(1526,'8 GB','128 GB'),(1539,'8 GB','128 GB'),(1552,'6 GB','128 GB'),(1565,'4 GB','64 GB'),(1578,'4 GB','64 GB'),(1591,'4 GB','64 GB'),(1605,'12 GB','256 GB'),(1617,'12 GB','256 GB'),(1630,'12 GB','256 GB'),(1638,'12 GB','256 GB'),(1645,'12 GB','256 GB'),(1657,'8 GB','128 GB'),(1669,'8 GB','128 GB'),(1681,'4 GB','64 GB'),(1693,'4 GB','64 GB'),(1705,'8 GB','256 GB'),(1717,'8 GB','256 GB'),(1730,'12 GB','256 GB'),(1742,'8 GB','128 GB'),(2628,'4 GB','64 GB'),(2636,'12 GB','256 GB'),(2644,'8 GB','128 GB'),(2652,'8 GB','128 GB');
/*!40000 ALTER TABLE `dtbonho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dthedieuhanhcpu`
--

DROP TABLE IF EXISTS `dthedieuhanhcpu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dthedieuhanhcpu` (
  `id` bigint NOT NULL,
  `cpu` varchar(255) DEFAULT NULL,
  `gpu` varchar(255) DEFAULT NULL,
  `hedieuhanh` varchar(30) DEFAULT NULL,
  `tocdocpu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dthedieuhanhcpu`
--

LOCK TABLES `dthedieuhanhcpu` WRITE;
/*!40000 ALTER TABLE `dthedieuhanhcpu` DISABLE KEYS */;
INSERT INTO `dthedieuhanhcpu` VALUES (150,'CPU AMD Contex 4 nhân','GPU tích hợp đồ họa','IOS','3.0'),(166,'CPU AMD Contex 4 nhân','GPU tích hợp đồ họa','IOS','3.0'),(269,' Snapdragon 8 Gen 1 8 nhân',' Adreno 730',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(284,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(306,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(317,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(328,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(339,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(352,'','','',''),(361,'','','',''),(370,'','','',''),(380,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(392,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(462,' Snapdragon 8 Gen 1 8 nhân',' Adreno 730',' Android 12','3.0'),(472,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(499,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(508,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(517,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(526,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(535,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(544,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(553,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(561,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(577,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(585,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(593,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(602,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(610,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(618,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(666,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(677,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1160,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1193,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1204,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1212,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1220,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1243,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1251,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1267,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1287,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1295,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1303,' Snapdragon 8 Gen 1 8 nhân','GPU tích hợp đồ họa',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1319,' Apple A15 Bionic 6 nhân','Apple GPU 5 nhân','iOS 16','3.22 GHz'),(1334,' Apple A15 Bionic 6 nhân','Apple GPU 5 nhân','iOS 16','3.22 GHz'),(1376,'MediaTek Dimensity 1300 8 nhân',' Mali-G77 MC9',' Android 12','3 GHz'),(1390,'Snapdragon 695 5G 8 nhân',' Adreno 619',' Android 11',' 2 nhân 2.2 GHz & 6 nhân 1.8 GHz'),(1404,' Apple A15 Bionic 6 nhân','Apple GPU 5 nhân','iOS 16','3.22 GHz'),(1419,'Apple A13 Bionic 6 nhân',' Apple GPU 4 nhân','iOS 15','2 nhân 2.65 GHz & 4 nhân 1.8 GHz'),(1433,' Apple A14 Bionic 6 nhân','Apple GPU 4 nhân','iOS 15','2 nhân 3.1 GHz & 4 nhân 1.8 GHz'),(1446,'Apple A16 Bionic','Apple GPU 5 nhân','iOS 16','3.46 GHz'),(1460,'Apple A13 Bionic 6 nhân',' Apple GPU 4 nhân','iOS 15','2 nhân 2.65 GHz & 4 nhân 1.8 GHz'),(1468,' Apple A15 Bionic 6 nhân','Apple GPU 5 nhân','iOS 16','3.22 GHz'),(1475,' Snapdragon 8 Gen 1 8 nhân',' Adreno 730','Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1488,'Snapdragon 8+ Gen 1 8 nhân',' Adreno 730',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1501,'Snapdragon 778G 5G 8 nhân',' Adreno 642L',' Android 12',' 4 nhân 2.4 GHz & 4 nhân 1.8 GHz'),(1514,' Snapdragon 662 8 nhân',' Adreno 610',' Android 11','4 nhân 2.0 GHz & 4 nhân 1.8 GHz'),(1527,' Snapdragon 695 5G 8 nhân',' Adreno 619',' Android 11',' 2.2 GHz'),(1540,' Snapdragon 680 8 nhân',' Adreno 610',' Android 12',' 2.4 GHz'),(1553,' Snapdragon 680 8 nhân',' Adreno 610',' Android 11','4 nhân 2.4 GHz & 4 nhân 1.9 GHz'),(1566,' MediaTek Helio G35 8 nhân',' IMG PowerVR GE8320','Android 12',' 2.3 GHz'),(1579,' MediaTek Helio G35 8 nhân',' IMG PowerVR GE8320',' Android 11',' 4 nhân 2.3 GHz & 4 nhân 1.8 GHz'),(1592,'MediaTek Helio G35 8 nhân',' IMG PowerVR GE8320',' Android 12',' 2.3 GHz'),(1606,'MediaTek Dimensity 8100 Max 8 nhân','Mali G610 MC6',' Android 12',' 2.85 GHz'),(1618,' Snapdragon 8 Gen 1 8 nhân',' Adreno 730',' Android 12','1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1631,'MediaTek Dimensity 8100 Max 8 nhân','Mali G610 MC6',' Android 12',' 2.85 GHz'),(1639,' Snapdragon 8 Gen 1 8 nhân',' Adreno 730',' Android 12','1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(1646,' Snapdragon 8+ Gen 1 8 nhân',' Adreno 670',' Android 12',' 3.2 GHz'),(1658,' Snapdragon 778G 5G 8 nhân',' Adreno 642L',' Android 11',' 1 nhân 2.4 GHz, 3 nhân 2.2 GHz & 4 nhân 1.9 GHz'),(1670,'Snapdragon 732G 8 nhân',' Adreno 618',' Android 11','2 nhân 2.3 GHz & 6 nhân 1.8 GHz'),(1682,'JLQ JR510 8 nhân',' Mali-G52',' Android 11','4 nhân 2.0 GHz & 4 nhân 1.5 GHz'),(1694,'Snapdragon 680 8 nhân',' Adreno 610',' Android 11',' 4 nhân 2.4 GHz & 4 nhân 1.9 GHz'),(1706,'MediaTek Dimensity 900 5G',' Mali-G68',' Android 12','2 nhân 2.4 GHz & 6 nhân 2 GHz'),(1718,' Snapdragon 865 8 nhân',' Adreno 650',' Android 12',' 1 nhân 2.84 GHz, 3 nhân 2.42 GHz & 4 nhân 1.8 GHz'),(1731,' MediaTek Dimensity 9000 8 nhân','Mali-G710 MC10',' Android 12',' 1 nhân 3.05 GHz, 3 nhân 2.85 GHz & 4 nhân 1.8 GHz'),(1743,'MediaTek Dimensity 1300 8 nhân',' Mali-G77',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.6 GHz & 4 nhân 2 GHz'),(2629,' MediaTek Helio G35 8 nhân',' IMG PowerVR GE8320','Android 12',' 2.3 GHz'),(2637,' Snapdragon 8 Gen 1 8 nhân',' Adreno 730','Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(2645,'Snapdragon 8+ Gen 1 8 nhân',' Adreno 730',' Android 12',' 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz'),(2653,'Snapdragon 778G 5G 8 nhân',' Adreno 642L',' Android 12',' 4 nhân 2.4 GHz & 4 nhân 1.8 GHz');
/*!40000 ALTER TABLE `dthedieuhanhcpu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dtketnoi`
--

DROP TABLE IF EXISTS `dtketnoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dtketnoi` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bluetooth` varchar(255) DEFAULT NULL,
  `congsac` varchar(255) DEFAULT NULL,
  `gps` varchar(255) DEFAULT NULL,
  `ketnoikhac` varchar(255) DEFAULT NULL,
  `mangdidong` varchar(255) DEFAULT NULL,
  `tainghe` varchar(255) DEFAULT NULL,
  `wifi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dtketnoi`
--

LOCK TABLES `dtketnoi` WRITE;
/*!40000 ALTER TABLE `dtketnoi` DISABLE KEYS */;
INSERT INTO `dtketnoi` VALUES (2,'V4.0','USB-c','GPS','khác','5G','type C','802.11g'),(4,'V4.0','USB-c','GPS','khác','5G','type C','802.11g'),(13,' v5.2',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(14,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(16,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(17,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(18,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(19,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(20,'','','','','','',''),(21,'','','','','','',''),(22,'','','','','','',''),(23,' v5.2',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(24,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(31,'V4.0',' Type-C','GPS','khác','5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(32,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(34,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(35,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(36,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(37,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(38,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(39,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(40,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(41,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(43,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(44,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(45,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(46,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(47,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(48,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(54,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(55,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(58,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(59,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(60,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(61,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(62,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(63,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(64,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(66,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(67,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(68,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(69,'V4.0',' Type-C','GPS',' NFC',' Hỗ trợ 5G',' Type-C','Wi-Fi 802.11 a/b/g/n/ac/ax'),(71,'v5.3','Lightning','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC','Hỗ trợ 5G','Lightning','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(72,'v5.3','Lightning','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC','Hỗ trợ 5G','Lightning','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(76,'v5.3',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(77,' v5.2',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 5G',' Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(78,'v5.3','Lightning','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC',' Hỗ trợ 5G','Lightning','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(79,'V5.0','Lightning','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC',' Hỗ trợ 4G','Lightning','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(80,'V5.0','Lightning','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC',' Hỗ trợ 5G','Lightning','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(81,'v5.3','Lightning','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC',' Hỗ trợ 5G','Lightning','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(82,'V5.0','Lightning','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC',' Hỗ trợ 4G','Lightning','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(83,'v5.3','Lightning','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC',' Hỗ trợ 5G','Lightning','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(84,'v5.3',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 5G',' Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(85,'v5.2','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(86,'V5.0',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC',' Hỗ trợ 5G','Type-C',' Wi-Fi Direct, Wi-Fi hotspot, Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(87,'V5.0',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 4G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO, 6 GHz'),(88,'V5.1',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 5G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(89,'V5.0','USB-c','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 4G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(90,'V5.0',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 4G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(91,'V5.3',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 4G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(92,'V5.0','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU',' OTG',' Hỗ trợ 4G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(93,'v5.3','Micro USB','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG',' Hỗ trợ 4G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(94,'v5.3','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU',' OTG',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO, 6 GHz'),(95,'v5.3','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','Hồng ngoại, NFC',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO, 6 GHz'),(96,'v5.3','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU',' OTG',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO, 6 GHz'),(97,'v5.3','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','Hồng ngoại, NFC',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO, 6 GHz'),(98,'v5.3','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','Hồng ngoại, NFC',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO, 6 GHz'),(99,'v5.2','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','Hồng ngoại, NFC',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(100,'V5.0','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 4G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(101,'V5.0','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG',' Hỗ trợ 4G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(102,'V5.0','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG',' Hỗ trợ 4G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(103,' v5.0',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC',' Hỗ trợ 5G',' Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(104,' v5.2','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(105,' v5.3','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(106,' v5.2','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(107,'V5.3',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 4G','3.5 mm','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax'),(108,'v5.3',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 5G',' Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(109,'v5.2','Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','OTG, NFC',' Hỗ trợ 5G','Type-C','Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax, Wi-Fi MIMO'),(110,'V5.0',' Type-C','GPS, GLONASS, GALILEO, QZSS, BEIDOU','NFC',' Hỗ trợ 5G','Type-C',' Wi-Fi Direct, Wi-Fi hotspot, Dual-band (2.4 GHz/5 GHz), Wi-Fi 802.11 a/b/g/n/ac/ax');
/*!40000 ALTER TABLE `dtketnoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giohang`
--

DROP TABLE IF EXISTS `giohang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giohang` (
  `id` bigint NOT NULL,
  `khachhang_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7nj6ctk5alp0csd5rh3t4foi2` (`khachhang_id`),
  CONSTRAINT `FKp9it8wbptmxoidis1ph02jfp` FOREIGN KEY (`khachhang_id`) REFERENCES `khachhang` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giohang`
--

LOCK TABLES `giohang` WRITE;
/*!40000 ALTER TABLE `giohang` DISABLE KEYS */;
INSERT INTO `giohang` VALUES (1,10),(4,22),(3,36),(6,2822),(5,2824),(2828,2826),(2833,2831);
/*!40000 ALTER TABLE `giohang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giohangsp`
--

DROP TABLE IF EXISTS `giohangsp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giohangsp` (
  `id` bigint NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  `giohang_id` bigint DEFAULT NULL,
  `sanpham_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8x7a9st8j39p02vc0q85e6t08` (`giohang_id`),
  KEY `FKljt6cushj5c911ffq8vka8uo7` (`sanpham_id`),
  CONSTRAINT `FK8x7a9st8j39p02vc0q85e6t08` FOREIGN KEY (`giohang_id`) REFERENCES `giohang` (`id`),
  CONSTRAINT `FKljt6cushj5c911ffq8vka8uo7` FOREIGN KEY (`sanpham_id`) REFERENCES `sanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giohangsp`
--

LOCK TABLES `giohangsp` WRITE;
/*!40000 ALTER TABLE `giohangsp` DISABLE KEYS */;
INSERT INTO `giohangsp` VALUES (2685,_binary '',1,3,1444),(2687,_binary '',1,3,1473),(2688,_binary '\0',1,4,1402),(2692,_binary '',3,3,1388),(2732,_binary '\0',1,4,894),(2735,_binary '\0',1,4,1486),(2737,_binary '\0',2,4,1374),(2739,_binary '\0',1,4,1388),(2741,_binary '\0',1,4,1374),(2743,_binary '\0',1,4,1473),(2745,_binary '\0',1,4,1444),(2747,_binary '\0',1,4,1417),(2749,_binary '\0',1,4,1644),(2750,_binary '\0',1,4,2299),(2752,_binary '\0',1,4,1444),(2754,_binary '\0',1,4,1473),(2760,_binary '\0',1,4,1402),(2763,_binary '\0',1,4,1809),(2764,_binary '\0',1,4,1444),(2769,_binary '\0',2,4,1374),(2772,_binary '\0',1,4,1402),(2775,_binary '\0',1,4,1417),(2778,_binary '\0',1,4,1388),(2781,_binary '\0',1,4,1538),(2782,_binary '\0',1,4,1388),(2783,_binary '\0',1,4,1473),(2788,_binary '\0',1,4,1388),(2791,_binary '\0',1,4,1473),(2792,_binary '\0',1,4,1486),(2796,_binary '\0',1,4,2106),(2797,_binary '\0',1,4,2373),(2798,_binary '\0',1,4,2410),(2803,_binary '\0',3,4,2438),(2834,_binary '\0',1,4,1809),(2835,_binary '\0',2,4,2164),(2836,_binary '\0',4,4,1604),(2837,_binary '\0',6,2833,2106),(2840,_binary '\0',1,2833,1402),(2843,_binary '\0',16,2833,894),(2846,_binary '',1,2833,894);
/*!40000 ALTER TABLE `giohangsp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (2864);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `id` bigint NOT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ghichu` varchar(500) DEFAULT NULL,
  `nguoinhan` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `magiamgia_id` bigint DEFAULT NULL,
  `khachhang_id` bigint DEFAULT NULL,
  `shipping` varchar(255) DEFAULT NULL,
  `xuathd` bit(1) DEFAULT NULL,
  `ngay_tao` date DEFAULT NULL,
  `tinhtrang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK30sgqqb7vx061fcbsc081r8oc` (`magiamgia_id`),
  KEY `FKa6vb7kwsuhyjr6p87p6a10vwa` (`khachhang_id`),
  CONSTRAINT `FK30sgqqb7vx061fcbsc081r8oc` FOREIGN KEY (`magiamgia_id`) REFERENCES `magiamgia` (`id`),
  CONSTRAINT `FKa6vb7kwsuhyjr6p87p6a10vwa` FOREIGN KEY (`khachhang_id`) REFERENCES `khachhang` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (2756,'Ninh Binh','nhanvien11122@gmail.com','1','Đại Sự Quách','+84386115804',NULL,22,'Miễn phí giao hàng',_binary '','2023-01-26','Chờ xác nhận'),(2758,'Ninh Binh','nhanvien11122@gmail.com','13233333','Đại Sự Quách','+84386115804',2693,22,'Miễn phí giao hàng',_binary '\0','2023-01-26','Chờ xác nhận'),(2761,'Ninh Binh','nhanvien11122@gmail.com','1','Đại Sự Quách','+84386115804',2693,22,'Miễn phí giao hàng',_binary '','2023-01-26','Chờ xác nhận'),(2765,'Ninh Binh','nhanvien11122@gmail.com','1','Đại Sự Quách','+84386115804',2693,22,'Miễn phí giao hàng',_binary '','2023-01-26','Chờ xác nhận'),(2770,'Ninh Binh','nhanvien11122@gmail.com','1','Đại Sự Quách','+84386115804',2693,22,'Miễn phí giao hàng',_binary '','2023-01-26','Chờ xác nhận'),(2773,'Ninh Binh','nhanvien11122@gmail.com','1','Đại Sự Quách','+84386115804',2693,22,'Lấy trực tiếp tại cửa hàng',_binary '','2023-01-26','Chờ xác nhận'),(2776,'Nho Quan - Ninh Binh','nhanvien11122@gmail.com','13222222','Đại Sự Quách','+84386115804',NULL,22,'Lấy trực tiếp tại cửa hàng',_binary '\0','2023-02-03','Chờ xác nhận'),(2779,'Nho Quan - Ninh Binh','nhanvien11122@gmail.com','1','Đại Sự Quách','+84386115804',NULL,22,'Miễn phí giao hàng',_binary '','2023-02-03','Đang xử lý'),(2789,'Nho Quan - Ninh Binh','nhanvien11122@gmail.com','1','Đại Sự Quách','+84386115804',NULL,22,'Miễn phí giao hàng',_binary '','2023-02-03','Giao hàng thành công'),(2793,'Nho Quan - Ninh Binh','nhanvien11122@gmail.com','Giao từ thứ 2 - 6 vào giờ hành chính','Đại Sự Quách','+84386115804',2693,22,'Miễn phí giao hàng',_binary '\0','2023-02-05','Giao hàng thất bại'),(2799,'Nho Quan - Ninh Binh','nhanvien11122@gmail.com','13222222','Đại Sự Quách','+84386115804',NULL,22,'Giao hàng nhanh',_binary '\0','2023-02-05','Chờ xác nhận'),(2804,'Nho Quan - Ninh Binh','nhanvien11122@gmail.com','1','Đại Sự Quách','+84386115804',NULL,22,'Lấy trực tiếp tại cửa hàng',_binary '','2023-02-05','Đang xử lý'),(2838,'Hà Nội','khachthuong01@gmail.com','1','Đỗ Thị V','+84+84199956789',2705,2831,'',_binary '','2023-02-08','Đang xử lý'),(2841,'Hà Nội','khachthuong01@gmail.com','1','Đỗ Thị V','+84+84199956789',NULL,2831,'Giao hàng nhanh',_binary '','2023-02-08','Đang xử lý'),(2844,'Hà Nội','khachthuong01@gmail.com','1','Đỗ Thị V','+84199956789',2705,2831,'',_binary '','2023-02-08','Đang xử lý'),(2847,'Hà Đông - Hà Nội','thic@gmail.com','Giao hàng giờ hành chính','Nguyễn Thị C','+84386115804',NULL,22,'Lấy trực tiếp tại cửa hàng',_binary '\0','2023-02-09','Đang xử lý');
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` bigint NOT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `urlimg` varchar(255) DEFAULT NULL,
  `sanpham_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgj8cy1b1nvxwispiet52r92yh` (`sanpham_id`),
  CONSTRAINT `FKgj8cy1b1nvxwispiet52r92yh` FOREIGN KEY (`sanpham_id`) REFERENCES `sanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1231,NULL,'167248579869254484.png',NULL),(1381,NULL,'167257487065135209.png',1374),(1382,NULL,'167257487068353380.png',1374),(1383,NULL,'167257487068649381.png',1374),(1384,NULL,'167257487068968156.png',1374),(1395,NULL,'167258489862120116.png',1388),(1396,NULL,'167258489895347074.png',1388),(1397,NULL,'167258489895528572.png',1388),(1398,NULL,'16725848989575888.png',1388),(1399,NULL,'167258489895865674.png',1388),(1409,NULL,'167258623713290582.png',1402),(1410,NULL,'167258623713583472.png',1402),(1411,NULL,'167258623713933393.png',1402),(1412,NULL,'16725862371422601.png',1402),(1413,NULL,'167258623714555687.png',1402),(1414,NULL,'167258623714785741.png',1402),(1424,NULL,'167258713729460492.png',1417),(1425,NULL,'167258713729944279.png',1417),(1426,NULL,'167258713731220070.png',1417),(1427,NULL,'16725871373176672.png',1417),(1428,NULL,'167258713732193224.png',1417),(1438,NULL,'167258783081166906.png',1431),(1439,NULL,'167258783081647784.png',1431),(1440,NULL,'167258783082025737.png',1431),(1441,NULL,'167258783082516573.png',1431),(1451,NULL,'167258859929681881.png',1444),(1452,NULL,'167258859930531247.png',1444),(1453,NULL,'167258859930871328.png',1444),(1454,NULL,'167258859931044130.png',1444),(1480,NULL,'167258934693174882.jpg',1473),(1493,NULL,'167259006024089092.jpg',1486),(1494,NULL,'167259006024237615.jpg',1486),(1495,NULL,'167259006024527118.jpg',1486),(1496,NULL,'167259006024610543.jpg',1486),(1506,NULL,'167259068355040497.png',1499),(1507,NULL,'167259068355977304.png',1499),(1508,NULL,'167259068356172929.png',1499),(1509,NULL,'167259068356354387.png',1499),(1519,NULL,'167259156492755441.png',1512),(1520,NULL,'167259156493425946.png',1512),(1521,NULL,'167259156493755038.png',1512),(1522,NULL,'167259156493967952.png',1512),(1532,NULL,'16725921452718122.png',1525),(1533,NULL,'167259214527432404.png',1525),(1534,NULL,'167259214527886522.png',1525),(1535,NULL,'167259214528176705.png',1525),(1545,NULL,'167259296052888137.png',1538),(1546,NULL,'167259296084199983.png',1538),(1547,NULL,'167259296084421452.png',1538),(1548,NULL,'167259296084767307.png',1538),(1558,NULL,'167259368522765767.png',1551),(1559,NULL,'167259368523325999.png',1551),(1560,NULL,'167259368523994605.png',1551),(1561,NULL,'167259368526283728.png',1551),(1571,NULL,'167259436779787799.jpg',1564),(1572,NULL,'167259436811426774.jpg',1564),(1573,NULL,'167259436811650202.jpg',1564),(1574,NULL,'167259436811853404.jpg',1564),(1584,NULL,'167259488862467642.png',1577),(1585,NULL,'167259488863046961.png',1577),(1586,NULL,'167259488863228281.png',1577),(1587,NULL,'167259488863416067.png',1577),(1597,NULL,'167259540001770658.png',1590),(1598,NULL,'167259540005468585.png',1590),(1599,NULL,'167259540007112171.png',1590),(1600,NULL,'167259540008773901.png',1590),(1611,NULL,'167267175186462275.png',1604),(1612,NULL,'167267175187614362.png',1604),(1613,NULL,'16726717518793777.png',1604),(1623,NULL,'167267273837382698.png',1616),(1624,NULL,'167267273837798471.png',1616),(1625,NULL,'167267273838327308.png',1616),(1651,NULL,'167267352987527848.jpg',1644),(1652,NULL,'16726735298817799.jpg',1644),(1653,NULL,'1672673529884853.jpg',1644),(1663,NULL,'167267403635024036.jpg',1656),(1664,NULL,'167267403635459962.jpg',1656),(1665,NULL,'167267403635795830.jpg',1656),(1675,NULL,'167267450456291827.jpg',1668),(1676,NULL,'167267450456764340.jpg',1668),(1677,NULL,'16726745045726349.jpg',1668),(1687,NULL,'16726749537771757.jpg',1680),(1688,NULL,'16726749537805654.jpeg',1680),(1689,NULL,'167267495378227263.jpg',1680),(1699,NULL,'167267548430050837.jpg',1692),(1700,NULL,'167267548430342313.jpg',1692),(1701,NULL,'167267548430576429.jpg',1692),(1711,NULL,'167267593386250584.png',1704),(1712,NULL,'167267593386593163.png',1704),(1713,NULL,'167267593386747059.png',1704),(1723,NULL,'16726766549189101.png',1716),(1724,NULL,'167267665492042292.png',1716),(1725,NULL,'167267665492457452.png',1716),(1736,NULL,'167267730930365032.jpg',1729),(1737,NULL,'167267730930632326.jpg',1729),(1738,NULL,'167267730930850803.jpg',1729),(1748,NULL,'167267776475983233.jpg',1741),(1749,NULL,'167267776476371626.jpg',1741),(1750,NULL,'167267776476726255.jpg',1741),(2119,NULL,'167268239549798634.png',2106),(2120,NULL,'167268239551943585.png',2106),(2121,NULL,'167268239552276873.png',2106),(2122,NULL,'167268239552493324.png',2106),(2174,NULL,'167275404511332896.png',2164),(2175,NULL,'167275404545419521.png',2164),(2176,NULL,'167275404545736666.png',2164),(2177,NULL,'167275404545949675.png',2164),(2188,NULL,'167275461862526508.png',2178),(2189,NULL,'167275461894434462.png',2178),(2190,NULL,'167275461894838487.png',2178),(2191,NULL,'167275461895398229.png',2178),(2211,NULL,'16727552470493666.png',2201),(2212,NULL,'167275524705610698.png',2201),(2213,NULL,'167275524705975628.png',2201),(2214,NULL,'167275524706151242.png',2201),(2225,NULL,'167275570602079002.png',2215),(2226,NULL,'167275570602686377.png',2215),(2227,NULL,'167275570603097780.png',2215),(2228,NULL,'167275570603883572.png',2215),(2239,NULL,'167275621856436509.png',2229),(2240,NULL,'167275621856721316.png',2229),(2241,NULL,'167275621857049586.png',2229),(2242,NULL,'167275621857346578.png',2229),(2253,NULL,'167275659261754395.png',2243),(2254,NULL,'167275659262060022.png',2243),(2255,NULL,'1672756592624976.png',2243),(2256,NULL,'167275659262626060.png',2243),(2267,NULL,'167275701294449013.png',2257),(2268,NULL,'167275701294850028.png',2257),(2269,NULL,'167275701295131561.png',2257),(2270,NULL,'167275701327164981.png',2257),(2309,NULL,'167275748794262118.png',2299),(2310,NULL,'167275748800974544.png',2299),(2311,NULL,'167275748801199379.png',2299),(2312,NULL,'167275748801210915.png',2299),(2323,NULL,'16727579698577192.png',2313),(2324,NULL,'167275796986061719.png',2313),(2325,NULL,'167275796986251600.png',2313),(2326,NULL,'167275796986462537.png',2313),(2337,NULL,'167275869465412782.png',2327),(2338,NULL,'167275869465740312.png',2327),(2339,NULL,'167275869466010670.png',2327),(2340,NULL,'167275869466340935.png',2327),(2351,NULL,'167275921363674518.png',2341),(2352,NULL,'167275921364419073.png',2341),(2353,NULL,'16727592136488014.png',2341),(2354,NULL,'167275921365171423.png',2341),(2383,NULL,'167275960049235405.png',2373),(2384,NULL,'167275960050170351.png',2373),(2385,NULL,'167275960050665240.png',2373),(2386,NULL,'167275960051020481.png',2373),(2406,NULL,'167276044436613262.png',2396),(2407,NULL,'16727604443693543.png',2396),(2408,NULL,'167276044437271477.png',2396),(2409,NULL,'167276044437769737.png',2396),(2420,NULL,'167276126103218927.png',2410),(2421,NULL,'167276126103516805.png',2410),(2422,NULL,'167276126104415666.png',2410),(2423,NULL,'167276126105152349.png',2410),(2434,NULL,'167276163046626224.png',2424),(2435,NULL,'167276163047191233.png',2424),(2436,NULL,'167276163047959973.png',2424),(2437,NULL,'167276163048155419.png',2424),(2448,NULL,'167276207630363309.png',2438),(2449,NULL,'167276207630677207.png',2438),(2450,NULL,'167276207631256201.png',2438),(2451,NULL,'167276207631496927.png',2438),(2462,NULL,'167276242989794744.png',2452),(2463,NULL,'167276242990354366.png',2452),(2464,NULL,'167276242990636082.png',2452),(2465,NULL,'167276242990957753.png',2452),(2476,NULL,'167276274275614427.png',2466),(2477,NULL,'167276274276338036.png',2466),(2478,NULL,'167276274276517759.png',2466),(2479,NULL,'16727627427674984.png',2466),(2490,NULL,'167276319155236760.png',2480),(2491,NULL,'167276319155997317.png',2480),(2492,NULL,'167276319156181922.png',2480),(2493,NULL,'167276319186079876.png',2480),(2504,NULL,'167276360211672864.png',2494),(2505,NULL,'167276360212278140.png',2494),(2506,NULL,'167276360212422844.png',2494),(2507,NULL,'167276360242778660.png',2494),(2518,NULL,'167276401317666484.png',2508),(2519,NULL,'167276401317935396.png',2508),(2520,NULL,'167276401318230420.png',2508),(2521,NULL,'167276401318477745.png',2508),(2532,NULL,'167276457586438666.png',2522),(2533,NULL,'167276457586825540.png',2522),(2534,NULL,'167276457587053959.png',2522),(2535,NULL,'167276457587291737.png',2522),(2546,NULL,'167276512199324095.png',2536),(2547,NULL,'167276512199690298.png',2536),(2548,NULL,'167276512199861726.png',2536),(2549,NULL,'167276512200088488.png',2536),(2560,NULL,'167276552953633649.png',2550),(2561,NULL,'167276552954494981.png',2550),(2562,NULL,'167276552954695176.png',2550),(2563,NULL,'167276552954917460.png',2550),(2574,NULL,'167276593104573116.png',2564),(2575,NULL,'167276593104854747.png',2564),(2576,NULL,'167276593105656468.png',2564),(2577,NULL,'16727659310623662.png',2564),(2600,NULL,'167290824078484461.png',894),(2601,NULL,'167290824080233756.png',894),(2602,NULL,'167290824082156347.png',894),(2603,NULL,'167290824083512700.png',894),(2604,NULL,'167290824084786268.png',894),(2614,NULL,'167290843665215329.png',1809),(2615,NULL,'167290843697620894.png',1809),(2616,NULL,'167290843698075735.png',1809);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `img`
--

DROP TABLE IF EXISTS `img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `img` (
  `id` bigint NOT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `img`
--

LOCK TABLES `img` WRITE;
/*!40000 ALTER TABLE `img` DISABLE KEYS */;
/*!40000 ALTER TABLE `img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ketnoilt`
--

DROP TABLE IF EXISTS `ketnoilt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ketnoilt` (
  `id` bigint NOT NULL,
  `conggiaotiep` varchar(255) DEFAULT NULL,
  `denbanphim` varchar(255) DEFAULT NULL,
  `ketnoikhongday` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ketnoilt`
--

LOCK TABLES `ketnoilt` WRITE;
/*!40000 ALTER TABLE `ketnoilt` DISABLE KEYS */;
INSERT INTO `ketnoilt` VALUES (1167,'USB & Type-C','Co','Bluetooth'),(1180,'USB & Type-C','Co','Bluetooth'),(1811,'HDMI, Jack tai nghe 3.5 mm, 3 x Thunderbolt 4 USB-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(1824,'HDMI, Jack tai nghe 3.5 mm, 3 x Thunderbolt 4 USB-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(1918,'HDMI, Jack tai nghe 3.5 mm, 3 x Thunderbolt 4 USB-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(2045,'HDMI, Jack tai nghe 3.5 mm, 3 x Thunderbolt 4 USB-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(2108,'USB & Type-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(2124,'USB & Type-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(2133,'USB & Type-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(2145,'HDMI, Jack tai nghe 3.5 mm, 3 x Thunderbolt 4 USB-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(2154,'HDMI, Jack tai nghe 3.5 mm, 3 x Thunderbolt 4 USB-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(2166,'1 x USB-C 3.2 Gen 2 (hỗ trợ truyền dữ liệu and DisplayPort 1.4), 2 x USB 3.2, 1 x Thunderbolt 4 (hỗ trợ DisplayPort)','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2180,'2 x USB Type-C, Jack tai nghe 3.5 mm, 3 x USB 3.2','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2193,'2 x USB Type-C, Jack tai nghe 3.5 mm, 3 x USB 3.2','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2203,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2217,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2231,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2245,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2259,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2301,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2315,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2329,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2343,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2356,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2365,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2375,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2388,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2398,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2412,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2426,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2440,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2454,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2468,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2482,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2496,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2510,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Có','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2524,'Jack tai nghe 3.5 mm  1 x Surface Connect  2 x Thunderbolt 4 USB-C','Không','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2538,'2 x USB Type-C, Jack tai nghe 3.5 mm, 2 x USB 3.2  HDMI','Co','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2552,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2566,'3 x USB 3.2, LAN (RJ45), HDMI, USB Type-C','Led RGB','Wi-Fi 6 (802.11ax), Bluetooth 5.1'),(2583,'HDMI, Jack tai nghe 3.5 mm, 3 x Thunderbolt 4 USB-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(2592,'HDMI, Jack tai nghe 3.5 mm, 3 x Thunderbolt 4 USB-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)'),(2606,'USB & Type-C','Co','Bluetooth'),(2618,'HDMI, Jack tai nghe 3.5 mm, 3 x Thunderbolt 4 USB-C','Có','Bluetooth 5.0Wi-Fi 6 (802.11ax)');
/*!40000 ALTER TABLE `ketnoilt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `ngaydangky` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK3n3dm134rbw1nambblw06ypbo` FOREIGN KEY (`id`) REFERENCES `nguoi_dung` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('2022/10/21 18:56:22',9),('2022/10/21 18:59:47',10),('2022/10/21 19:02:21',12),('2022/10/21 19:05:41',14),('2022/10/21 19:06:27',16),('2022/10/21 19:09:23',18),('2022/10/21 19:12:11',20),('2022/10/21 19:15:01',22),('2022/11/07 16:31:13',24),('2022/11/07 18:40:47',26),('2022/11/07 18:40:47',36),('2023-02-07',2822),('2023-02-07',2824),('2023-02-07',2826),('2023-02-08',2831);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang_magiamgia`
--

DROP TABLE IF EXISTS `khachhang_magiamgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang_magiamgia` (
  `id` bigint NOT NULL,
  `trangthai` bit(1) DEFAULT NULL,
  `khachhang_id` bigint DEFAULT NULL,
  `magiamgia_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjgaq765vt2nih1fete7epu8dh` (`khachhang_id`),
  KEY `FK8mqogbsgy21wj95ne3h41uc46` (`magiamgia_id`),
  CONSTRAINT `FK8mqogbsgy21wj95ne3h41uc46` FOREIGN KEY (`magiamgia_id`) REFERENCES `magiamgia` (`id`),
  CONSTRAINT `FKjgaq765vt2nih1fete7epu8dh` FOREIGN KEY (`khachhang_id`) REFERENCES `khachhang` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang_magiamgia`
--

LOCK TABLES `khachhang_magiamgia` WRITE;
/*!40000 ALTER TABLE `khachhang_magiamgia` DISABLE KEYS */;
INSERT INTO `khachhang_magiamgia` VALUES (2694,_binary '',9,2693),(2695,_binary '',10,2693),(2696,_binary '',12,2693),(2697,_binary '',14,2693),(2698,_binary '',16,2693),(2699,_binary '',18,2693),(2700,_binary '',20,2693),(2701,_binary '\0',22,2693),(2702,_binary '',24,2693),(2703,_binary '',26,2693),(2704,_binary '',36,2693),(2706,_binary '',9,2705),(2707,_binary '',10,2705),(2708,_binary '',12,2705),(2709,_binary '',14,2705),(2710,_binary '',16,2705),(2711,_binary '',18,2705),(2712,_binary '',20,2705),(2713,_binary '',22,2705),(2714,_binary '',24,2705),(2715,_binary '',26,2705),(2716,_binary '',36,2705);
/*!40000 ALTER TABLE `khachhang_magiamgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khuyenmai` (
  `id` bigint NOT NULL,
  `makm` varchar(255) DEFAULT NULL,
  `ngaybd` date DEFAULT NULL,
  `ngaykt` date DEFAULT NULL,
  `tile` float DEFAULT NULL,
  `trangthai` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuyenmai`
--

LOCK TABLES `khuyenmai` WRITE;
/*!40000 ALTER TABLE `khuyenmai` DISABLE KEYS */;
INSERT INTO `khuyenmai` VALUES (2,'KM02','2022-11-21','2024-11-28',20,_binary ''),(682,'KM002','2022-11-21','2024-12-16',15,_binary ''),(684,'KHT12','2022-12-29','2024-02-05',30,_binary ''),(1603,'KMNAMMOI','2023-01-01','2024-01-20',50,_binary '');
/*!40000 ALTER TABLE `khuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kichthuoctrongluong`
--

DROP TABLE IF EXISTS `kichthuoctrongluong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kichthuoctrongluong` (
  `id` bigint NOT NULL,
  `dodai` varchar(50) DEFAULT NULL,
  `domong` varchar(50) DEFAULT NULL,
  `dorong` varchar(50) DEFAULT NULL,
  `trongluong` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kichthuoctrongluong`
--

LOCK TABLES `kichthuoctrongluong` WRITE;
/*!40000 ALTER TABLE `kichthuoctrongluong` DISABLE KEYS */;
INSERT INTO `kichthuoctrongluong` VALUES (381,'163.3','8.9','77.9','600'),(393,'163.3','8.9','77.9','600'),(463,'163.3','8.9','77.9','600'),(473,'163.3','8.9','77.9','600'),(500,'163.3','8.9','77.9','600'),(509,'163.3','8.9','77.9','600'),(518,'163.3','8.9','77.9','600'),(527,'163.3','8.9','77.9','600'),(536,'163.3','8.9','77.9','600'),(545,'163.3','8.9','77.9','600'),(554,'163.3','8.9','77.9','600'),(562,'163.3','8.9','77.9','600'),(578,'163.3','8.9','77.9','600'),(586,'163.3','8.9','77.9','600'),(594,'163.3','8.9','77.9','600'),(603,'163.3','8.9','77.9','600'),(611,'163.3','8.9','77.9','600'),(619,'163.3','8.9','77.9','600'),(667,'163.3','8.9','77.9','600'),(678,'163.3','8.9','77.9','600'),(784,'163','89','77','228'),(876,'333','22','222','228'),(887,'104','23','32','600'),(896,'444','44','44','444'),(907,'444','44','44','444'),(915,'444','44','44','444'),(922,'444','44','44','444'),(929,'444','44','44','444'),(936,'444','44','44','444'),(943,'444','44','44','444'),(950,'444','44','44','444'),(957,'444','44','44','444'),(964,'444','44','44','444'),(971,'444','44','44','444'),(978,'444','44','44','444'),(987,'444','44','44','444'),(994,'444','44','44','444'),(1001,'444','44','44','444'),(1008,'444','44','44','444'),(1048,'444','44','44','444'),(1056,'444','44','44','444'),(1064,'444','44','44','444'),(1072,'444','44','44','444'),(1079,'444','44','44','444'),(1086,'444','44','44','444'),(1093,'444','44','44','444'),(1101,'444','44','44','444'),(1122,'444','44','44','444'),(1129,'444','44','44','444'),(1136,'444','44','44','444'),(1143,'444','44','44','444'),(1161,'163.3','8.9','77.9','600'),(1168,'163.3mm','8.9mm','77.9mm','1.2kg'),(1181,'444','44','44','444'),(1194,'163.3','8.9','77.9','600'),(1205,'163.3','8.9','77.9','600'),(1213,'163.3','8.9','77.9','600'),(1221,'163.3','8.9','77.9','600'),(1244,'163.3','8.9','77.9','600'),(1252,'163.3','8.9','77.9','600'),(1268,'163.3','8.9','77.9','600'),(1288,'163.3','8.9','77.9','600'),(1296,'163.3','8.9','77.9','600'),(1304,'163.3','8.9','77.9','600'),(1320,'146.7 mm','7.8 mm','71.5 mm','172 g'),(1335,'146.7 mm','7.8 mm','71.5 mm','172 g'),(1377,'160 mm','7.67 mm','73.4 mm','179 g'),(1391,'164.19 mm','8.12 mm','76.1 mm','202 g'),(1405,'146.7 mm','7.8 mm','71.5 mm','172 g'),(1420,'150.9 mm ',' 8.3 mm','75.7 mm','194 g'),(1434,'146.7 mm ','7.4 mm',' 71.5 mm ','164 g'),(1447,'160.7 mm','7.85 mm','77.6 mm','240 g'),(1461,'150.9 mm ',' 8.3 mm','75.7 mm','194 g'),(1469,'146.7 mm','7.8 mm','71.5 mm','172 g'),(1476,'163.3 mm','8.9 mm','77.9 mm','228 g'),(1489,'157.4 mm','7.6 mm','75.8 mm','195 g'),(1502,'163.7 mm','7.6 mm','76.1 mm','181 g'),(1515,'160.3 mm','7.95 mm','73.8 mm','175 g'),(1528,'159.85 mm','7.49 mm','73.17 mm ','173 g'),(1541,'163.74 mm','7.99 mm','75.03 mm','187 g'),(1554,'164.4 mm','8.39 mm','75.7 mm','189 g'),(1567,'163.74 mm','7.99 mm','75.03 mm','187 g'),(1580,'163.6 mm','8.4 mm','75.7 mm','193 g'),(1593,'164.2 mm','8.3 mm','75.6 mm','189 g'),(1607,'161.2 mm','7.34 mm','74.2 mm','183 g'),(1619,'163.6 mm','8.2 mm ','74.6 mm','205 g'),(1632,'161.2 mm','7.34 mm','74.2 mm','183 g'),(1640,'163.6 mm','8.2 mm ','74.6 mm','205 g'),(1647,'163.1 mm','8.6 mm','75.9 mm','205 g'),(1659,'160.5 ','6.8 ','75.7 ','158 '),(1671,'164 mm','8.1 mm','76.5 mm','193 g'),(1683,'169.59 mm','9.18 mm','76.56 mm','204 g'),(1695,'169 mm','8 mm','76 mm','180 g'),(1707,'164.7 mm','7.4 mm','77 mm','176 mm'),(1719,'159.8 mm','8.4mm','74.5 mm','190 g'),(1732,'164.95 mm','8.3 mm','75.23 mm','206 g'),(1744,'158.9 mm','8.62 mm','73.52 mm','190 mm'),(1812,'355.7 mm','16.8 mm','248.1 mm','2.1 kg'),(1825,'355.7 mm','16.8 mm','248.1 mm','2.1 kg'),(1919,'355.7 mm','16.8 mm','248.1 mm','2.1 kg'),(2046,'355.7 mm','16.8 mm','248.1 mm','2.1 kg'),(2109,'304.1 mm','7.8 mm','75.7 mm','172 g'),(2125,'304.1 mm','7.8 mm','75.7 mm','172 g'),(2134,'304.1 mm','7.8 mm','75.7 mm','172 g'),(2146,'355.7 mm','16.8 mm','248.1 mm','2.1 kg'),(2155,'355.7 mm','16.8 mm','248.1 mm','2.1 kg'),(2167,'358.8 mm','19.99 mm','262.35 mm','2.35 kg'),(2181,'362.56 mm','25.75 mm','260.61 mm','2.4 kg'),(2194,'362.56 mm','25.75 mm','260.61 mm','2.4 kg'),(2204,'360.4 mm','25.9 mm','271.09 mm','2.5 kg'),(2218,'360.4 mm','25.9 mm','271.09 mm','2.5 kg'),(2232,'354 mm','25.9 mm','259 mm','2.1 kg'),(2246,'354 mm','20.6 mm','259 mm','2.1 kg'),(2260,'359.6 mm','21.8 mm','266.4 mm','2.315 mm'),(2302,'359.6 mm','21.8 mm','266.4 mm','2.315 kg'),(2316,'354 mm','20.7 mm','251 mm','2 kg'),(2330,'354 mm','24.9 mm','251 mm','2.2 kg'),(2344,'363.4 mm','22.9 mm','254.5 mm','2.1 kg'),(2357,'354 mm','25.9 mm','259 mm','2.1 kg'),(2366,'354 mm','20.6 mm','259 mm','2.1 kg'),(2376,'363.4 mm','22.9 mm','254.5 mm','2.1 kg'),(2389,'363.4 mm','22.9 mm','254.5 mm','2.1 kg'),(2399,'370 mm','23.5 mm','260.61 mm','2.46 kg'),(2413,'298.3 mm','16.1 mm','214.9 mm','1.34 kg'),(2427,'306.9 mm','15.9 mm','208.4 mm ','1.28 kg'),(2441,'295.3 mm','15.28 mm','199 mm','1.26 kg'),(2455,'356 mm','18 mm','252 mm','1.97 kg'),(2469,'356.7 mm','17.95 mm','251.9 mm','1.87 kg'),(2483,'359 mm','23.95 mm','259 mm','2.35 mm'),(2497,'359 mm','21.7 mm','254 mm','1.86 kg'),(2511,'319 ','16.9 ','219 ','1.3 '),(2525,'287 mm','9.3 mm','208 mm','0.891 kg'),(2539,'378.8 mm','17.7 mm','258.8 mm','1.435 kg'),(2553,'356 mm','19 mm','272 mm','2.69 kg'),(2567,'323.5 mm','17.9 mm','224.7 mm','1.75 kg'),(2584,'355.7 mm','16.8 mm','248.1 mm','2.1 kg'),(2593,'355.7 mm','16.8 mm','248.1 mm','2.1 kg'),(2607,'444','44','44','444'),(2619,'355.7 mm','16.8 mm','248.1 mm','2.1 kg'),(2630,'163.74 mm','7.99 mm','75.03 mm','187 g'),(2638,'163.3 mm','8.9 mm','77.9 mm','228 g'),(2646,'157.4 mm','7.6 mm','75.8 mm','195 g'),(2654,'163.7 mm','7.6 mm','76.1 mm','181 g');
/*!40000 ALTER TABLE `kichthuoctrongluong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laptop`
--

DROP TABLE IF EXISTS `laptop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laptop` (
  `id` bigint NOT NULL,
  `camera_id` bigint DEFAULT NULL,
  `kich_thuoc_trong_luong_id` bigint DEFAULT NULL,
  `tien_ich_id` bigint DEFAULT NULL,
  `pin_id` bigint DEFAULT NULL,
  `lt_do_hoa_va_am_thanh_id` bigint DEFAULT NULL,
  `lt_ram_o_cung_id` bigint DEFAULT NULL,
  `ltcpu_id` bigint DEFAULT NULL,
  `tienich_id` bigint DEFAULT NULL,
  `manhinh` varchar(300) DEFAULT NULL,
  `ket_noi_lt_id` bigint DEFAULT NULL,
  `man_hinh_lt_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKte5veejecncd990sb0p8ipcut` (`camera_id`),
  KEY `FKopug6k29kvjmjuyfs5t4tuhcr` (`kich_thuoc_trong_luong_id`),
  KEY `FKs0a27a0d9vvjxtquvmqnvo7jw` (`tien_ich_id`),
  KEY `FKivs090oucucc8x6bqsxwltrvh` (`pin_id`),
  KEY `FK9vwqqe04ecasgfrv1o3i0sfu` (`lt_do_hoa_va_am_thanh_id`),
  KEY `FK1gda399nolu1menvqay64v8xk` (`lt_ram_o_cung_id`),
  KEY `FKgc4unyctc4x8i8gkqsxgoijfs` (`ltcpu_id`),
  KEY `FKssihnig3n3pycjnsk8s55jonp` (`tienich_id`),
  KEY `FK11edkjqvx155r2se3u98y5cb` (`ket_noi_lt_id`),
  KEY `FK88qvqllil66wvjkym5sa6u1ga` (`man_hinh_lt_id`),
  CONSTRAINT `FK11edkjqvx155r2se3u98y5cb` FOREIGN KEY (`ket_noi_lt_id`) REFERENCES `ketnoilt` (`id`),
  CONSTRAINT `FK1gda399nolu1menvqay64v8xk` FOREIGN KEY (`lt_ram_o_cung_id`) REFERENCES `ram_ocung` (`id`),
  CONSTRAINT `FK88qvqllil66wvjkym5sa6u1ga` FOREIGN KEY (`man_hinh_lt_id`) REFERENCES `manhinhlt` (`id`),
  CONSTRAINT `FK9vwqqe04ecasgfrv1o3i0sfu` FOREIGN KEY (`lt_do_hoa_va_am_thanh_id`) REFERENCES `ltdohoavaamthanh` (`id`),
  CONSTRAINT `FKgc4unyctc4x8i8gkqsxgoijfs` FOREIGN KEY (`ltcpu_id`) REFERENCES `ltcpu` (`id`),
  CONSTRAINT `FKhecojubs7fbf52pkac6rxcj1g` FOREIGN KEY (`id`) REFERENCES `sanpham` (`id`),
  CONSTRAINT `FKivs090oucucc8x6bqsxwltrvh` FOREIGN KEY (`pin_id`) REFERENCES `pin` (`id`),
  CONSTRAINT `FKopug6k29kvjmjuyfs5t4tuhcr` FOREIGN KEY (`kich_thuoc_trong_luong_id`) REFERENCES `kichthuoctrongluong` (`id`),
  CONSTRAINT `FKs0a27a0d9vvjxtquvmqnvo7jw` FOREIGN KEY (`tien_ich_id`) REFERENCES `tienich` (`id`),
  CONSTRAINT `FKssihnig3n3pycjnsk8s55jonp` FOREIGN KEY (`tienich_id`) REFERENCES `tienich` (`id`),
  CONSTRAINT `FKte5veejecncd990sb0p8ipcut` FOREIGN KEY (`camera_id`) REFERENCES `camera` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laptop`
--

LOCK TABLES `laptop` WRITE;
/*!40000 ALTER TABLE `laptop` DISABLE KEYS */;
INSERT INTO `laptop` VALUES (894,2605,2607,NULL,2612,2608,2609,2610,2613,NULL,2606,2611),(1809,2617,2619,NULL,2624,2620,2621,2622,2625,NULL,2618,2623),(2106,2132,2134,NULL,2139,2135,2136,2137,2140,NULL,2133,2138),(2164,2165,2167,NULL,2172,2168,2169,2170,2173,NULL,2166,2171),(2178,2192,2194,NULL,2199,2195,2196,2197,2200,NULL,2193,2198),(2201,2202,2204,NULL,2209,2205,2206,2207,2210,NULL,2203,2208),(2215,2216,2218,NULL,2223,2219,2220,2221,2224,NULL,2217,2222),(2229,2355,2357,NULL,2362,2358,2359,2360,2363,NULL,2356,2361),(2243,2364,2366,NULL,2371,2367,2368,2369,2372,NULL,2365,2370),(2257,2258,2260,NULL,2265,2261,2262,2263,2266,NULL,2259,2264),(2299,2300,2302,NULL,2307,2303,2304,2305,2308,NULL,2301,2306),(2313,2314,2316,NULL,2321,2317,2318,2319,2322,NULL,2315,2320),(2327,2328,2330,NULL,2335,2331,2332,2333,2336,NULL,2329,2334),(2341,2387,2389,NULL,2394,2390,2391,2392,2395,NULL,2388,2393),(2373,2374,2376,NULL,2381,2377,2378,2379,2382,NULL,2375,2380),(2396,2397,2399,NULL,2404,2400,2401,2402,2405,NULL,2398,2403),(2410,2411,2413,NULL,2418,2414,2415,2416,2419,NULL,2412,2417),(2424,2425,2427,NULL,2432,2428,2429,2430,2433,NULL,2426,2431),(2438,2439,2441,NULL,2446,2442,2443,2444,2447,NULL,2440,2445),(2452,2453,2455,NULL,2460,2456,2457,2458,2461,NULL,2454,2459),(2466,2467,2469,NULL,2474,2470,2471,2472,2475,NULL,2468,2473),(2480,2481,2483,NULL,2488,2484,2485,2486,2489,NULL,2482,2487),(2494,2495,2497,NULL,2502,2498,2499,2500,2503,NULL,2496,2501),(2508,2509,2511,NULL,2516,2512,2513,2514,2517,NULL,2510,2515),(2522,2523,2525,NULL,2530,2526,2527,2528,2531,NULL,2524,2529),(2536,2537,2539,NULL,2544,2540,2541,2542,2545,NULL,2538,2543),(2550,2551,2553,NULL,2558,2554,2555,2556,2559,NULL,2552,2557),(2564,2565,2567,NULL,2572,2568,2569,2570,2573,NULL,2566,2571);
/*!40000 ALTER TABLE `laptop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ltcpu`
--

DROP TABLE IF EXISTS `ltcpu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ltcpu` (
  `id` bigint NOT NULL,
  `bonhodem` varchar(255) DEFAULT NULL,
  `congnghe` varchar(255) DEFAULT NULL,
  `soluong` varchar(255) DEFAULT NULL,
  `sonhan` varchar(255) DEFAULT NULL,
  `tocdo` varchar(255) DEFAULT NULL,
  `tocdotoida` varchar(255) DEFAULT NULL,
  `tencpu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ltcpu`
--

LOCK TABLES `ltcpu` WRITE;
/*!40000 ALTER TABLE `ltcpu` DISABLE KEYS */;
INSERT INTO `ltcpu` VALUES (787,'24','Intel® Core™ i7-11800H','16','12','2.3','4.6','Intel® Core™ i7-11800H (upto 4.60GHz, 24MB)'),(879,'24','Intel® Core™ i7-11800H','16','3','2.3','4.6','Intel® Core™ i7-11800H (upto 4.60GHz, 24MB)'),(890,'24','Intel® Core™ i7-11800H','16','9','2.3','4.6','Intel® Core™ i7-11800H (upto 4.60GHz, 24MB)'),(899,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(910,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(918,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(925,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(932,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(939,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(946,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(953,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(960,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(967,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(974,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(981,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(990,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(997,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1004,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1011,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1051,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1059,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1067,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1075,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1082,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1089,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1096,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1104,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1125,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1132,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1139,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1146,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1171,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel® Core™ i7-11800H (upto 4.60GHz, 24MB)'),(1184,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(1815,'24','200 GB/s memory bandwidth','20','10','2.3','4.6','Apple M1 Pro'),(1828,'24','200 GB/s memory bandwidth','20','10','2.3','4.6','Apple M1 Pro'),(1922,'24','200 GB/s memory bandwidth','20','10','2.3','4.6','Apple M1 Pro'),(2049,'24','200 GB/s memory bandwidth','20','10','2.3','4.6','Apple M1 Pro'),(2112,'Không công bố','200 GB/s memory bandwidth','16 luồng','8 nhân','Không','Không','Apple M2'),(2128,'Không công bố','200 GB/s memory bandwidth','16 luồng','8 nhân','Không','Không','Apple M2'),(2137,'Không công bố','200 GB/s memory bandwidth','16 luồng','8 nhân','Không','Không','Apple M2'),(2149,'24','200 GB/s memory bandwidth','20','10','2.3','4.6','Apple M1 Pro'),(2158,'24','200 GB/s memory bandwidth','20','10','2.3','4.6','Apple M1 Pro'),(2170,'18 MB','Turbo Boost 4.5 GHz','16','12','2,5 gHz','4,5 gHz','Intel Core i5 Alder Lake - 12500H'),(2184,'','','','','','',''),(2197,'16 MB','','12','6','3,3 Ghz','4,2 Ghz','AMD Ryzen 5 - 5600H'),(2207,'24 MB','','20','14','2,3 GHz','4,7 Ghz','Intel Core i7 Alder Lake - 12700H'),(2221,'18 MB','','16','12','2,5 Ghz','4,5 GHz','Intel Core i5 Alder Lake - 12500H'),(2235,'20 MB','','16 luồng','8 nhân','3,2 GHz','4,7 GHz','AMD Ryzen 7 - 6800H'),(2249,'8 MB','','16 luồng','8 nhân','2,9 GHz','4,2 GHz','AMD Ryzen 7 - 4800H'),(2263,'18 MB','','16','12','2,5 gHz','4,5 gHz','Intel Core i5 Alder Lake - 12500H'),(2305,'24 MB','','20','14','2,3 GHz','4,7 Ghz','Intel Core i7 Alder Lake - 12700H'),(2319,'24 MB','','16','10','2,3 GHz','4,7 GHz','Intel Core i7 Alder Lake - 12650H'),(2333,'24 MB','','20','14','2,3 GHz','4,7 Ghz','Intel Core i7 Alder Lake - 12700H'),(2347,'8 MB','','12','6','2,1 GHz','4,0 GHz','AMD Ryzen 5 - 5500U'),(2360,'20 MB','','16 luồng','8 nhân','3,2 GHz','4,7 GHz','AMD Ryzen 7 - 6800H'),(2369,'8 MB','','16 luồng','8 nhân','2,9 GHz','4,2 GHz','AMD Ryzen 7 - 4800H'),(2379,'16 MB','','12','6','2,3 GHz','4,3 Gz','AMD Ryzen 5 - 5625U'),(2392,'8 MB','','12','6','2,1 GHz','4,0 GHz','AMD Ryzen 5 - 5500U'),(2402,'12 MB','','12','6','2,7','4,5','Intel Core i5 Tiger Lake - 11400H'),(2416,'12 MB','','12','10','1 GHz','4,4 Ghz','Intel Core i5 Alder Lake - 1230U'),(2430,'12 MB','','12','10','1,7 GHz','4,7 GHz','Intel Core i7 Alder Lake - 1255U'),(2444,'18 MB','','16','12','2,1 GHz','4,7 GHz','Intel Core i7 Alder Lake - 1260P'),(2458,'12 MB','','16','12','1,7 GHz','4,4 Ghz','Intel Core i5 Alder Lake - 1240P'),(2472,'12 MB','','16','12','1,7 GHz','4,4 Ghz','Intel Core i5 Alder Lake - 1240P'),(2486,'16','','16','8','3,2 GHz','4,4 GHz','AMD Ryzen 7 - 5800H'),(2500,'24 MB','','16','8','2,3 GHz','4,6 GHz','Intel Core i7 Tiger Lake - 11800H'),(2514,'12 MB','','8','4','2,9 GHz','5,0 GHz','Intel Core i7 Tiger Lake - 1195G7'),(2528,'8 MB','','8','4','2,4 GHz','4,2 GHz','Intel Core i5 Tiger Lake - 1135G7'),(2542,'18 MB','','16','12','2,1 GHz','4,7 GHz','Intel Core i7 Alder Lake - 1260P'),(2556,'24 MB','','16 luồng','8 nhân','2,3 GHz','4,6 GHz','Intel Core i7 Tiger Lake - 11800H'),(2570,'24 MB','','20','14','2,3 GHz','4,7 GHz','Intel Core i7 Alder Lake - 12700H'),(2587,'24','200 GB/s memory bandwidth','20','10','2.3','4.6','Apple M1 Pro'),(2596,'24','200 GB/s memory bandwidth','20','10','2.3','4.6','Apple M1 Pro'),(2610,'24','Intel® Core™ i7-11800H','16','8','2.3','4.6','Intel Core i7 1255U (3.50 GHz upto 4.70 GHz, 12MB)'),(2622,'24','200 GB/s memory bandwidth','20','10','2.3','4.6','Apple M1 Pro');
/*!40000 ALTER TABLE `ltcpu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ltdohoavaamthanh`
--

DROP TABLE IF EXISTS `ltdohoavaamthanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ltdohoavaamthanh` (
  `id` bigint NOT NULL,
  `cardamthanh` varchar(500) DEFAULT NULL,
  `carddohoa` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ltdohoavaamthanh`
--

LOCK TABLES `ltdohoavaamthanh` WRITE;
/*!40000 ALTER TABLE `ltdohoavaamthanh` DISABLE KEYS */;
INSERT INTO `ltdohoavaamthanh` VALUES (785,'am thanh','nVidia Geforce RTX 3060 6GB GDDR6'),(877,'am thanh','nVidia Geforce RTX 3060 6GB GDDR6'),(888,'am thanh','nVidia Geforce RTX 3060 6GB GDDR6'),(897,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(908,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(916,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(923,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(930,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(937,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(944,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(951,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(958,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(965,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(972,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(979,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(988,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(995,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1002,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1009,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1049,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1057,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1065,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1073,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1080,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1087,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1094,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1102,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1123,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1130,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1137,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1144,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1169,'High Definition (HD) Audio, Realtek ALC3287 codec','nVidia Geforce RTX 3060 6GB GDDR6'),(1182,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(1813,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(1826,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(1920,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(2047,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(2110,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(2126,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(2135,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(2147,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(2156,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(2168,' Nahimic Audio','Card rời - NVIDIA GeForce RTX 3060, 6 GB'),(2182,' Nahimic Audio','Card rời - NVIDIA GeForce RTX 3050, 4 GB'),(2195,' Nahimic Audio','Card rời - NVIDIA GeForce RTX 3050, 4 GB'),(2205,' Acer TrueHarmony, DTS X:Ultra Audio','Card rời - NVIDIA GeForce RTX 3050Ti, 4 GB'),(2219,' Acer TrueHarmony, DTS X:Ultra Audio','Card rời - NVIDIA GeForce RTX 3050, 4 GB'),(2233,' Dolby Atmos','Card rời - NVIDIA GeForce RTX 3050, 4 GB'),(2247,'Dolby Atmos','Card rời - NVIDIA GeForce GTX 1650 4 GB'),(2261,' Nahimic Audio','Card rời - NVIDIA GeForce RTX 3050, 4 GB'),(2303,' Nahimic Audio','Card rời - NVIDIA GeForce RTX 3050Ti, 4 GB'),(2317,'Dolby Atmos','nVidia Geforce RTX 3060 6GB GDDR6'),(2331,'Dolby Atmos','Card rời - NVIDIA GeForce RTX 3050, 4 GB'),(2345,'Acer TrueHarmony','Card rời - NVIDIA GeForce GTX 1650 4 GB'),(2358,' Dolby Atmos','Card rời - NVIDIA GeForce RTX 3050, 4 GB'),(2367,'Dolby Atmos','Card rời - NVIDIA GeForce GTX 1650 4 GB'),(2377,' Acer TrueHarmony, DTS X:Ultra Audio ','Card rời - NVIDIA GeForce RTX 3050, 4 GB'),(2390,'Acer TrueHarmony','Card rời - NVIDIA GeForce GTX 1650 4 GB'),(2400,'Audio by B&O, Realtek High Definition Audio','Card rời - NVIDIA GeForce RTX 3050Ti, 4 GB'),(2414,'HP Audio Boost, Bang & Olufsen audio','Card tích hợp - Intel Iris Xe Graphics'),(2428,'Realtek High Definition Audio','Card tích hợp - Intel UHD Graphics (Iris Xe Graphics chỉ hoạt động với RAM kênh đôi)'),(2442,' Realtek Audio','Card tích hợp - Intel Iris Xe Graphics'),(2456,'Realtek Audio','Card rời - NVIDIA Geforce MX570, 2 GB'),(2470,'Realtek Audio','Card tích hợp - Intel Iris Xe Graphics'),(2484,' Hi-Res AudioNahimic Audio','Card rời - AMD Radeon RX 6600M, 8 GB'),(2498,'Realtek High Definition Audio','Card rời - NVIDIA GeForce RTX 3050Ti Max-Q, 4GB'),(2512,' Nahimic Audio','Card tích hợp - Intel Iris Xe Graphics'),(2526,'Dolby Atmos','Card tích hợp - Intel Iris Xe Graphics'),(2540,'High Definition (HD) Audio, Realtek ALC3287 codec','Card tích hợp - Intel Iris Xe Graphics'),(2554,' Nahimic Audio','Card rời - NVIDIA GeForce RTX 3070, 8 GB'),(2568,'Dolby Atmos','Card rời - NVIDIA GeForce RTX 3050Ti, 4 GB'),(2585,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(2594,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU'),(2608,'High Definition (HD) Audio, Realtek ALC3287 codec','Integrated Intel Iris Xe Graphics functions as UHD Graphics'),(2620,'Wide stereo sound  Hệ thống âm thanh 6 loa  3 microphones  Dolby Atmos','Card tích hợp - 16 nhân GPU');
/*!40000 ALTER TABLE `ltdohoavaamthanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magiamgia`
--

DROP TABLE IF EXISTS `magiamgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `magiamgia` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `giatri` float DEFAULT NULL,
  `loaima` varchar(255) DEFAULT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `ngaybd` date DEFAULT NULL,
  `ngaykt` date DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trangthai` bit(1) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `donhangtu` float DEFAULT NULL,
  `giamtoida` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4msg58e6b5cg87pndjtx2nwek` (`category_id`),
  CONSTRAINT `FK4msg58e6b5cg87pndjtx2nwek` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magiamgia`
--

LOCK TABLES `magiamgia` WRITE;
/*!40000 ALTER TABLE `magiamgia` DISABLE KEYS */;
INSERT INTO `magiamgia` VALUES (1198,'NAMMOI',25,'0','Giảm giá toàn bộ sản phẩm samsung','2022-12-07','2022-12-22','Siêu giảm giá 6/6',_binary '',349,4000000,1000000),(1199,'XUAN2023',50,'0','Giảm giá toàn bộ sản phẩm Iphone','2023-01-06','2023-01-22','Giảm giá chào xuân',_binary '',449,6000000,4000000),(2693,'NAMMOI23',20,'0','Giảm giá đơn hàng từ 10.000.000 Đ','2023-01-16','2023-02-01','Chúc mừng năm mới 2023',_binary '',349,10000000,5000000),(2705,'TET2023',20,'0','Giảm giá đơn hàng từ 10.000.000 Đ','2022-12-05','2023-03-17','Khuyeesn mai',_binary '',349,100000000,5000000);
/*!40000 ALTER TABLE `magiamgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manhinh`
--

DROP TABLE IF EXISTS `manhinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manhinh` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `congnghemanhinh` varchar(255) DEFAULT NULL,
  `dophangiai` varchar(255) DEFAULT NULL,
  `dosangtoida` varchar(255) DEFAULT NULL,
  `kichthuoc` varchar(255) DEFAULT NULL,
  `matkinhcamung` varchar(255) DEFAULT NULL,
  `tansoquet` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2656 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manhinh`
--

LOCK TABLES `manhinh` WRITE;
/*!40000 ALTER TABLE `manhinh` DISABLE KEYS */;
INSERT INTO `manhinh` VALUES (382,'Dynamic AMOLED 2X','Full Hd+','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(394,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(464,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(474,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(501,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(510,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(519,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(528,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(537,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(546,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(555,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(563,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(579,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(587,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(595,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(604,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(612,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(620,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(668,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(679,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1162,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1195,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1206,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1214,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1222,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1245,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1253,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1269,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1289,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1297,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1305,'Dynamic AMOLED 2X','4K','1750.0','6.8 inch','Kính cường lực Corning Gorilla Glass Victus+','120.0'),(1321,'OLED','Super Retina XDR (1170 x 2532 Pixels)','1200.0','6.0 inch','Kính cường lực Ceramic Shield','60.0'),(1336,'OLED','Super Retina XDR (1170 x 2532 Pixels)','1200.0','6.0 inch','Kính cường lực Ceramic Shield','60.0'),(1378,'AMOLED','Full HD+ (1080 x 2400 Pixels)','600 nits','6.43 inch','Kính cường lực Corning Gorilla Glass 5','90 Hz'),(1392,'AMOLED',' Full HD+ (1080 x 2400 Pixels)',' 1200 nits','6.67 inch','Kính cường lực Corning Gorilla Glass 5','120 Hz'),(1406,'OLED','Super Retina XDR (1170 x 2532 Pixels)',' 1200 nits','6.1 inch','Kính cường lực Ceramic Shield','60Hz'),(1421,' IPS LCD',' Liquid Retina (828 x 1792 Pixels)','625 nits','6.1 inch',' Kính cường lực Oleophobic (ion cường lực)','60Hz'),(1435,'OLED','Super Retina XDR (1170 x 2532 Pixels)','1200 nits','6.1 inch','Kính cường lực Ceramic Shield','60Hz'),(1448,'OLED',' 2796 x 1290 Pixels','2000 nits','6.7 inch','Kính cường lực Ceramic Shield','120 Hz'),(1462,' IPS LCD',' Liquid Retina (828 x 1792 Pixels)','625 nits','6.1 inch',' Kính cường lực Oleophobic (ion cường lực)','60Hz'),(1470,'OLED','Super Retina XDR (1170 x 2532 Pixels)',' 1200 nits','6.1 inch','Kính cường lực Ceramic Shield','60Hz'),(1477,'Dynamic AMOLED 2X',' 2K+ (1440 x 3088 Pixels)','1750 nits','6.8 inch',' Kính cường lực Corning Gorilla Glass Victus+','120 Hz'),(1490,'Dynamic AMOLED 2X',' Full HD+ (1080 x 2340 Pixels)','1750 nits','6.6 inch','Kính cường lực Corning Gorilla Glass Victus+','120 Hz'),(1503,' Super AMOLED Plus',' Full HD+ (1080 x 2400 Pixels)','800 nits','6.7 inch','Kính cường lực Corning Gorilla Glass 5','120 Hz'),(1516,'Amoled',' Full HD+ (1080 x 2400 Pixels)','800 nits','6.43 inch','Kính cường lực Schott Xensation UP','60Hz'),(1529,'AMOLED',' Full HD+ (1080 x 2400 Pixels)','600 nits','6.43 inch','Kính cường lực Schott Xensation UP','60Hz'),(1542,' IPS LCD',' HD+ (720 x 1612 Pixels)','600 nits','6.56 inch','Kính cường lực Panda','90 Hz'),(1555,' IPS LCD','HD+ (720 x 1612 Pixels)','600 nits','6.56 inch',' Kính cường lực AGC DT-Pro','90 Hz'),(1568,' IPS LCD',' HD+ (720 x 1612 Pixels)','600 nits','6.56 inch',' Kính cường lực Panda','60Hz'),(1581,' IPS LCD',' HD+ (700 x 1600 Pixels)','480 nits','6.5 inch',' Kính cường lực Dinorex™ Glass','60Hz'),(1594,' IPS LCD',' HD+ (720 x 1612 Pixels)','600 nits','6.56 inch','Kính cường lực Panda','60Hz'),(1608,'AMOLED','Full HD+ (1080 x 2412 Pixels)','800 nits','6.7 inch',' Kính cường lực Corning Gorilla Glass 5','120 Hz'),(1620,'AMOLED',' 2K+ (1440 x 3200 Pixels)',' 1500 nits','6.73 inch',' Kính cường lực Corning Gorilla Glass Victus','120 Hz'),(1633,'AMOLED','Full HD+ (1080 x 2412 Pixels)','800 nits','6.7 inch',' Kính cường lực Corning Gorilla Glass 5','120 Hz'),(1641,'AMOLED',' 2K+ (1440 x 3200 Pixels)',' 1500 nits','6.73 inch',' Kính cường lực Corning Gorilla Glass Victus','120 Hz'),(1648,'AMOLED','1.5K (1220 x 2712 Pixels)','500 nits','6.67 inch','Kính cường lực Corning Gorilla Glass 5','120 Hz'),(1660,'AMOLED','Full HD+ (1080 x 2400 Pixels)','800 nits','6.55 inch',' Kính cường lực Corning Gorilla Glass 5','90 Hz'),(1672,'AMOLED',' Full HD+ (1080 x 2400 Pixels)',' 1200 nits','6.67 inch',' Kính cường lực Corning Gorilla Glass 5','120 Hz'),(1684,'IPS LCD','HD+ (720 x 1650 Pixels)',' 400 nits','6.71 inch',' Kính cường lực Corning Gorilla Glass','60Hz'),(1696,' IPS LCD',' HD+ (720 x 1650 Pixels)','500 nits','6.71 inch',' Kính cường lực Corning Gorilla Glass 3','60Hz'),(1708,' Super AMOLED Plus',' Full HD+ (1080 x 2400 Pixels)','1000 nits','6.7 inch',' Kính cường lực Corning Gorilla Glass 5','120 Hz'),(1720,'Super AMOLED',' Full HD+ (1080 x 2400 Pixels)','1000 nits',' 6.5 inch','Mặt kính cong 2.5D','120 Hz'),(1733,' AMOLED',' Full HD+ (1080 x 2400 Pixels)','1500 nits','6.78 ich',' Kính cường lực Schott Xensation UP','120 Hz'),(1745,' AMOLED',' Full HD+ (1080 x 2376 Pixels)','1300 nits','6.5 inch','Kính cường lực Schott Xensation UP','120 hz'),(2631,' IPS LCD',' HD+ (720 x 1612 Pixels)','600 nits','6.56 inch',' Kính cường lực Panda','60Hz'),(2639,'Dynamic AMOLED 2X',' 2K+ (1440 x 3088 Pixels)','1750 nits','6.8 inch',' Kính cường lực Corning Gorilla Glass Victus+','120 Hz'),(2647,'Dynamic AMOLED 2X',' Full HD+ (1080 x 2340 Pixels)','1750 nits','6.6 inch','Kính cường lực Corning Gorilla Glass Victus+','120 Hz'),(2655,' Super AMOLED Plus',' Full HD+ (1080 x 2400 Pixels)','800 nits','6.7 inch','Kính cường lực Corning Gorilla Glass 5','120 Hz');
/*!40000 ALTER TABLE `manhinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manhinhlt`
--

DROP TABLE IF EXISTS `manhinhlt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manhinhlt` (
  `id` bigint NOT NULL,
  `congnghemanhinh` varchar(500) DEFAULT NULL,
  `dophangiai` varchar(255) DEFAULT NULL,
  `kichthuoc` varchar(255) DEFAULT NULL,
  `tansoquet` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manhinhlt`
--

LOCK TABLES `manhinhlt` WRITE;
/*!40000 ALTER TABLE `manhinhlt` DISABLE KEYS */;
INSERT INTO `manhinhlt` VALUES (1172,'-lam lanh nhanh\r\n- tiet kiem dien','2k','13.3 inch','120 Hz'),(1185,'- amoled\r\n- Cảm ứng đa điểm','2k','13.3 inch','120 Hz'),(1816,'ProMotion, Wide color (P3), True Tone Technology, 1 tỷ màu','Liquid Retina XDR display (3456 x 2234)','16.2 inch','120 Hz'),(1829,'ProMotion, Wide color (P3), True Tone Technology, 1 tỷ màu','Liquid Retina XDR display (3456 x 2234)','16.2 inch','120 Hz'),(1923,'ProMotion, Wide color (P3), True Tone Technology, 1 tỷ màu','Liquid Retina XDR display (3456 x 2234)','16.2 inch','120 Hz'),(2050,'ProMotion, Wide color (P3), True Tone Technology, 1 tỷ màu','Liquid Retina XDR display (3456 x 2234)','16.2 inch','120 Hz'),(2113,'assssss','Liquid Retina XDR display (3456 x 2234)','13.3 inch','120 Hz'),(2129,'assssss','Liquid Retina XDR display (3456 x 2234)','13.3 inch','120 Hz'),(2138,'assssss','Liquid Retina XDR display (3456 x 2234)','13.3 inch','120 Hz'),(2150,'ProMotion, Wide color (P3), True Tone Technology, 1 tỷ màu','Liquid Retina XDR display (3456 x 2234)','16.2 inch','120 Hz'),(2159,'ProMotion, Wide color (P3), True Tone Technology, 1 tỷ màu','Liquid Retina XDR display (3456 x 2234)','16.2 inch','120 Hz'),(2171,'G-Sync, Tấm nền IPS, Chống chói Anti Glare, 100% sRGB','Full HD (1920 x 1080)','15.6 inch','165 Hz'),(2185,'Chống chói Anti Glare, Công nghệ IPS, 100% sRGB, Độ sáng 300 nits','Full HD (1920 x 1080)','15.6 inch','165 Hz'),(2198,'Chống chói Anti Glare, Công nghệ IPS, 100% sRGB, Độ sáng 300 nits','Full HD (1920 x 1080)','15.6 inch','165 Hz'),(2208,'TFT, Tấm nền IPS, LED Backlit, Acer ComfyView','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2222,'Công nghệ IPS','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2236,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2250,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2264,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','120 Hz'),(2306,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','120 Hz'),(2320,'Tấm nền IPS, Chống chói Anti Glare','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2334,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2348,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','60 Hz'),(2361,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2370,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2380,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2393,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','60 Hz'),(2403,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2417,'OLED','2.8K (2880 x 1800) - OLED','13.3 inch','60 Hz'),(2431,'Tấm nền IPS','Full HD (1920 x 1080)','13.3 inch','60 Hz'),(2445,'OLED','3.5K (3456 x 2160)','13.4 inch','60 Hz'),(2459,'WVA','Full HD (1920 x 1080)','16 inch','60 Hz'),(2473,'WVA','Full HD (1920 x 1080)','16 inch','60 Hz'),(2487,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2501,'Tấm nền IPS','Full HD (1920 x 1080)','15.6 inch','144 Hz'),(2515,'IPS','Full HD (1920 x 1080)','14 inch','60 Hz'),(2529,'IPS','2880 x 1920','13 inch','120Hz'),(2543,'IPS','WQXGA (2560 x 1600)','17 inch','60 Hz'),(2557,'WVA','QHD (2560 x 1440)','15.6 inch','240 Hz'),(2571,'OLED','2.8K (2880 x 1800) - OLED 16:10','14.5 inch','120Hz'),(2588,'ProMotion, Wide color (P3), True Tone Technology, 1 tỷ màu','Liquid Retina XDR display (3456 x 2234)','16.2 inch','120 Hz'),(2597,'ProMotion, Wide color (P3), True Tone Technology, 1 tỷ màu','Liquid Retina XDR display (3456 x 2234)','16.2 inch','120 Hz'),(2611,'- amoled\r\n- Cảm ứng đa điểm','2k','13.3 inch','120 Hz'),(2623,'ProMotion, Wide color (P3), True Tone Technology, 1 tỷ màu','Liquid Retina XDR display (3456 x 2234)','16.2 inch','120 Hz');
/*!40000 ALTER TABLE `manhinhlt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoi_dung`
--

DROP TABLE IF EXISTS `nguoi_dung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoi_dung` (
  `id` bigint NOT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gioitinh` bit(1) DEFAULT NULL,
  `matkhau` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `sdt` varchar(50) DEFAULT NULL,
  `urlimg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoi_dung`
--

LOCK TABLES `nguoi_dung` WRITE;
/*!40000 ALTER TABLE `nguoi_dung` DISABLE KEYS */;
INSERT INTO `nguoi_dung` VALUES (1,NULL,'aa',NULL,'$10$OhGk3V9QYDg9e0ySvEjYu.bYqijbUVyIogAOxWOgIwpH8N1sdr8zW',NULL,NULL,NULL,NULL),(2,NULL,'admin',_binary '','$2a$10$e59rGaFvpijWXLh03j0aZOzBYQNrIRIjlB8sGwLvBL35fecblsW1m','b','1999-01-01','0',NULL),(3,NULL,NULL,_binary '\0','$2a$10$R5XkGsjm7xCrO5yQskPif.XLGkRyFUnincTm/kRUhtMF0nyXyL6Uq',NULL,NULL,'386115804',NULL),(5,NULL,'nhanvien31',_binary '\0','$2a$2a$10$fuw4Mi04mRcBEadD5blUv.CR2HgdtNNcLYZDLcgNUN13.DmwZmt56',NULL,NULL,'386115804',NULL),(7,NULL,'nhanvien34',_binary '\0','$2a$10$CH1lQ/gDDRD4C9ArVbzBN.ege0dyFfVzScjFZpm9hQTG6K37xz0AO',NULL,NULL,'386115804',NULL),(9,NULL,'nhanvien34',_binary '\0','$2a$10$CH1lQ/gDDRD4C9ArVbzBN.ege0dyFfVzScjFZpm9hQTG6K37xz0AO','Nguyen Thi C',NULL,'386115804',NULL),(10,NULL,'nhanviena',_binary '\0','$2a$10$G31XNOzbUhOfnIq63VOWou6GNJTUgyXUZQlRM9KUCU9hrhtN7QGYy',NULL,NULL,'386115804',NULL),(12,NULL,'nhanvien11',_binary '\0','$2a$10$xePwLqWYsbVLi3I.veUiMO.DC.eWK8E4H7dM2LWibXehUT34swPVe','Dở Huyền',NULL,'386115804',NULL),(14,'b','nhanvien113',_binary '\0','$2a$10$zKd7XTQKuC1GpzDvfs.iBuiXaxtWEqI65L6yLY5ceMYFuo6p10p8G',NULL,NULL,'1',NULL),(16,'s','nhanvien114',_binary '\0','$2a$10$QmzeeKoq8yQZijKLtcg4R.4L/cbXI.1hqilV9BWHOnxmdP2Aj3s0.',NULL,NULL,'2',NULL),(18,'aaaa','nhanvien117',_binary '','$10$ocys58ww/dWWM8wQ8ZhMge9HHBGfYuD8SnXhvwiiUiFt5/c1sW6Wi',NULL,NULL,'386115804',NULL),(20,'ninh buoofn','nhanvien1112',_binary '','$2a$10$Oh/TPCkmgQmogl3EoEeBhugE1kVxsnCv8OhbqcrMmqtYeSufdxuE.','Quách Đại Sự',NULL,'386115804',NULL),(22,'Nho Quan - Ninh Binh','nhanvien11122',_binary '','$2a$10$JBGEvMRiRXa/zbC.uu7XLOHeGe6.RJMCZ50bYILv/Nyi/MeZsLIA.','Đại Sự Quách','1999-12-09','386115804','167542198479715289.jpg'),(24,'Đan Phượng','nhanvien1301',_binary '\0','$2a$10$0748dguARID7bMQYvX9CSebtWxqdgFPsMvzJo.KgVbEErJDZBUU9y','Nguyễn Khánh Huyền','2000-01-13','12222',NULL),(26,'Bình Phú','minhtruong@gmail.com',_binary '\0','$2a$10$fuw4Mi04mRcBEadD5blUv.CR2HgdtNNcLYZDLcgNUN13.DmwZmt56','Phạm Minh Trường','1999-01-13','12345','166841411139410836.jpg'),(28,'Thúy Hội, Đan Phượng, Hà Nội','khanhhuyen@gmail.com',_binary '\0','$2a$10$fuw4Mi04mRcBEadD5blUv.CR2HgdtNNcLYZDLcgNUN13.DmwZmt56','Nguyễn Khánh Huyền','2000-01-13','936434532','166808291209185137.jpg'),(34,'Hà Nôi','nguyenvana@gmail.com',_binary '','$2a$10$BZQZuxuwJifWfjhxKXksXu/JBmNNmSBZmkDtsNmVvnVJetyMqNbne','Nguyễn Văn A','2000-12-21','936434532',NULL),(36,'Thanh Xuân, Hà Nội','anan@gmail.com',_binary '\0','$2a$10$fuw4Mi04mRcBEadD5blUv.CR2HgdtNNcLYZDLcgNUN13.DmwZmt56','Tô An An','2002-01-01','94564543','166806143988645732.jpg'),(133,'40 yết kiêu, Hà Đông, Hà Nội','nhanvien0651@gmail.com',_binary '','$10$BZQZuxuwJifWfjhxKXksXu/JBmNNmSBZmkDtsNmVvnVJetyMqNbne','SamSung','1997-02-16','12345','166833415157315922.jpg'),(171,'Ninh Bình','nhanvien011@gmail.com',_binary '','$2a$10$fkl5evJY4k6BHsy4ZtcesOdg56dN5KI7kQ5ztbwIQYCTPMpmR/iFC','Đạt Smurf','1998-12-12','122222','166842448505170861.jpg'),(2822,'Hà Nội','khachvip12@gmail.com',_binary '\0','$2a$10$NmQxlvLdamve.Nhs/E2YeeEtKFfvXxJhxKoSweaTwH5uiGd7v6wF2','Tạ Văn B','2001-01-01','+84199956789',NULL),(2824,'40 yết kiêu, Hà Đông, Hà Nội','khachvip@gmail.com',_binary '','$2a$10$VpYIdIYek2.SAf7wTqyXtuIF.x.O1ddcB/rB03GFB2M2L0SBfZt6O','Tạ Văn B','2000-10-10','+84199956789',NULL),(2826,'Hà Nội','khachthuong@gmail.com',_binary '','$2a$10$HzhVb8.zdfhOYgxJ9KoR8Oqg5dERUaKB0kZRBuDx1Rj4r7tojU6cC','Đặng Văn Z','1989-11-11','+84123456789',NULL),(2831,'Hà Nội','khachthuong01@gmail.com',_binary '\0','$2a$10$1CArAcM1wV71PJcE0th95.aekB2IQQlF7512ChkLD2/7cLwsNkya2','Đỗ Thị V','1992-12-12','+84199956789',NULL);
/*!40000 ALTER TABLE `nguoi_dung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phukien`
--

DROP TABLE IF EXISTS `phukien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phukien` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKpf0nf2eobuid9kv4h8jcuajvn` FOREIGN KEY (`id`) REFERENCES `sanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phukien`
--

LOCK TABLES `phukien` WRITE;
/*!40000 ALTER TABLE `phukien` DISABLE KEYS */;
INSERT INTO `phukien` VALUES (1229);
/*!40000 ALTER TABLE `phukien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pin`
--

DROP TABLE IF EXISTS `pin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pin` (
  `id` bigint NOT NULL,
  `congnghe` varchar(255) DEFAULT NULL,
  `dungluong` varchar(50) DEFAULT NULL,
  `loaipin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pin`
--

LOCK TABLES `pin` WRITE;
/*!40000 ALTER TABLE `pin` DISABLE KEYS */;
INSERT INTO `pin` VALUES (383,'Sạc nhanh','5000',' Li-Ion'),(395,'assssssssssssssss','5000',' Li-Ion'),(465,'','5000',' Li-Ion'),(475,'dfsdfsds','5000',' Li-Ion'),(502,'dfsdfsds','5000',' Li-Ion'),(511,'dfsdfsds','5000',' Li-Ion'),(520,'dfsdfsds','5000',' Li-Ion'),(529,'dfsdfsds','5000',' Li-Ion'),(538,'dfsdfsds','5000',' Li-Ion'),(547,'dfsdfsds','5000',' Li-Ion'),(556,'dfsdfsds','5000',' Li-Ion'),(564,'dfsdfsds','5000',' Li-Ion'),(580,'dfsdfsds','5000',' Li-Ion'),(588,'dfsdfsds','5000',' Li-Ion'),(596,'assssssssssssssss','5000',' Li-Ion'),(605,'assssssssssssssss','5000',' Li-Ion'),(613,'dfsdfsds','5000',' Li-Ion'),(621,'dfsdfsds','5000',' Li-Ion'),(669,'dfsdfsds','5000',' Li-Ion'),(680,'assssssssssssssss','5000',' Li-Ion'),(788,'dsadsad','5000',' Li-Ion'),(880,'dssddsds','5000',' Li-Ion'),(891,'fadsfdsafsa','5000','Cell'),(900,'Integrated 45Wh','5000','Cell'),(911,'Integrated 45Wh','5000','Cell'),(919,'Integrated 45Wh','5000','Cell'),(926,'Integrated 45Wh','5000','Cell'),(933,'Integrated 45Wh','5000','Cell'),(940,'Integrated 45Wh','5000','Cell'),(947,'Integrated 45Wh','5000','Cell'),(954,'Integrated 45Wh','5000','Cell'),(961,'Integrated 45Wh','5000','Cell'),(968,'Integrated 45Wh','5000','Cell'),(975,'Integrated 45Wh','5000','Cell'),(982,'Integrated 45Wh','5000','Cell'),(991,'Integrated 45Wh','5000','Cell'),(998,'Integrated 45Wh','5000','Cell'),(1005,'Integrated 45Wh','5000','Cell'),(1012,'Integrated 45Wh','5000','Cell'),(1052,'Integrated 45Wh','5000','Cell'),(1060,'Integrated 45Wh','5000','Cell'),(1068,'Integrated 45Wh','5000','Cell'),(1076,'Integrated 45Wh','5000','Cell'),(1083,'Integrated 45Wh','5000','Cell'),(1090,'Integrated 45Wh','5000','Cell'),(1097,'Integrated 45Wh','5000','Cell'),(1105,'Integrated 45Wh','5000','Cell'),(1126,'Integrated 45Wh','5000','Cell'),(1133,'Integrated 45Wh','5000','Cell'),(1140,'Integrated 45Wh','5000','Cell'),(1147,'Integrated 45Wh','5000','Cell'),(1163,'assssssssssssssss','5000',' Li-Ion'),(1173,'afsadadsa','5000','Cell'),(1186,'Integrated 45Wh','5000','Cell'),(1196,'dfsdfsds','5000',' Li-Ion'),(1207,'dfsdfsds','5000',' Li-Ion'),(1215,'dfsdfsds','5000',' Li-Ion'),(1223,'dfsdfsds','5000',' Li-Ion'),(1246,'dfsdfsds','5000',' Li-Ion'),(1254,'dfsdfsds','5000',' Li-Ion'),(1270,'dfsdfsds','5000',' Li-Ion'),(1290,'dfsdfsds','5000',' Li-Ion'),(1298,'dfsdfsds','5000',' Li-Ion'),(1306,'dfsdfsds','5000',' Li-Ion'),(1322,'Sạc không dây, Tiết kiệm pin, Sạc không dây MagSafe','3279mAh','Li-Ion'),(1337,'Sạc không dây, Tiết kiệm pin, Sạc không dây MagSafe','3279mAh','Li-Ion'),(1379,'Sạc siêu nhanh SuperVOOC','4500 mAh','Li-Po'),(1393,'\r\nSạc pin nhanh 67W',' 5000 mAh',' Li-Po'),(1407,'Sạc không dây, Tiết kiệm pin, Sạc không dây MagSafe','3279 mAh',' Li-Ion'),(1422,'Sạc pin nhanh,  Sạc không dây, Tiết kiệm pin','3110 mAh',' Li-Ion'),(1436,'Sạc pin nhanh, Sạc không dây, Tiết kiệm pin, Sạc không dây MagSafe','2815 mAh',' Li-Ion'),(1449,'Sạc pin nhanh, Sạc không dây, Tiết kiệm pin, Sạc không dây MagSafe','4323 mAh',' Li-Ion'),(1463,'Sạc pin nhanh,  Sạc không dây, Tiết kiệm pin','3110 mAh',' Li-Ion'),(1471,'Sạc không dây, Tiết kiệm pin, Sạc không dây MagSafe','3279 mAh',' Li-Ion'),(1478,'Sạc không dây, Sạc pin nhanh, Sạc ngược không dây','5000 mAh',' Li-Ion'),(1491,'Sạc pin nhanh, Sạc không dây, Sạc ngược không dây','4500 mAh',' Li-Ion'),(1504,'Sạc pin nhanh','5000 mAh','Li-Po'),(1517,' Sạc pin nhanh','5000 mAh','Li-Po'),(1530,'Tiết kiệm pin, Siêu tiết kiệm pin, Sạc siêu nhanh SuperVOOC','4500 mAh','Li-Po'),(1543,'Tiết kiệm pin, Siêu tiết kiệm pin, Sạc siêu nhanh SuperVOOC','5000 mAh','Li-Po'),(1556,'Sạc siêu nhanh SuperVOOC','5000 mAh','Li-Po'),(1569,'Sạc siêu nhanh SuperVOOC','5000 mAh','Li-Po'),(1582,'\r\nTiết kiệm pin, Sạc pin nhanh','5000 mAh','Li-Po'),(1595,'Tiết kiệm pin, Siêu tiết kiệm pin','5000 mAh','Li-Po'),(1609,'Sạc siêu nhanh SuperVOOC','4500 mAh','Li-Po'),(1621,'Sạc không dây, Tiết kiệm pin, Sạc pin nhanh, Sạc ngược không dây','4600 mAh',' Li-Ion'),(1634,'Sạc siêu nhanh SuperVOOC','4500 mAh','Li-Po'),(1642,'Sạc không dây, Tiết kiệm pin, Sạc pin nhanh, Sạc ngược không dây','4600 mAh',' Li-Ion'),(1649,'\r\nSiêu tiết kiệm pin, HyperCharge','5000 mAh',' Li-Ion'),(1661,'Sạc pin nhanh','4250 mAh','Li-Po'),(1673,'Sạc pin nhanh','5020 mAh',' Li-Ion'),(1685,'Sạc pin nhanh','6000 mAh','Li-Po'),(1697,'Sạc pin nhanh','5000 mAh',' Li-Ion'),(1709,'Sạc pin nhanh','5000 mAh','Li-Po'),(1721,'Sạc pin nhanh, Sạc không dây, Sạc ngược không dây',' 4500 mAh',' Li-Ion'),(1734,'Sạc pin nhanh 80W','4500 mAh',' Li-Ion'),(1746,'4830 mAhFlashCharge','4830 mAh',' Li-Ion'),(1817,'Sạc MagSafe','Khoảng 10 tiếng',' Li-Ion'),(1830,'Sạc MagSafe','Khoảng 10 tiếng',' Li-Ion'),(1924,'Sạc MagSafe','Khoảng 10 tiếng',' Li-Ion'),(2051,'Sạc MagSafe','Khoảng 10 tiếng',' Li-Ion'),(2114,'ssssssssss','5000 mAh','Li-Po'),(2130,'ssssssssss','5000 mAh','Li-Po'),(2139,'ssssssssss','5000 mAh','Li-Po'),(2151,'Sạc MagSafe','Khoảng 10 tiếng',' Li-Ion'),(2160,'Sạc MagSafe','Khoảng 10 tiếng',' Li-Ion'),(2172,'','80 Wh',' Li-Ion'),(2186,'','60 Wh',' Li-Ion'),(2199,'','60 Wh',' Li-Ion'),(2209,'','57,5 Wh',' Li-Ion'),(2223,'','57,5 Wh',' Li-Ion'),(2237,'','56 Wh',' Li-Ion'),(2251,'','56 Wh',' Li-Ion'),(2265,'','60 Wh',' Li-Ion'),(2307,'aaaaaaaaaaaaaa','60 Wh',' Li-Ion'),(2321,'','76 WH',' Li-Ion'),(2335,'','56 Wh',' Li-Ion'),(2349,'','48 Wh',' Li-Ion'),(2362,'','56 Wh',' Li-Ion'),(2371,'','56 Wh',' Li-Ion'),(2381,'','50 Wh',' Li-Ion'),(2394,'','48 Wh',' Li-Ion'),(2404,'','70 Wh',' Li-Ion'),(2418,'','66 Wh',' Li-Ion'),(2432,'','3 cell 42 Wh',' Li-Ion'),(2446,'','3 cell 55 Wh',' Li-Ion'),(2460,'','4 cell 54 Wh',''),(2474,'','4 cell 54 Wh',' Li-Ion'),(2488,'','4 cell 90 Wh',' Li-Ion'),(2502,'','3 cell 51 Wh',' Li-Ion'),(2516,'','3 cell 39 Wh',' Li-Ion'),(2530,'','51,5 Wh',' Li-Ion'),(2544,'','80 Wh',' Li-Ion'),(2558,'','6 cell 86 Wh',' Li-Ion'),(2572,'','4 cell 76 Wh',' Li-Ion'),(2589,'Sạc MagSafe','Khoảng 10 tiếng',' Li-Ion'),(2598,'Sạc MagSafe','Khoảng 10 tiếng',' Li-Ion'),(2612,'Integrated 45Wh','5000','Cell'),(2624,'Sạc MagSafe','Khoảng 10 tiếng',' Li-Ion'),(2632,'Sạc siêu nhanh SuperVOOC','5000 mAh','Li-Po'),(2640,'Sạc không dây, Sạc pin nhanh, Sạc ngược không dây','5000 mAh',' Li-Ion'),(2648,'Sạc pin nhanh, Sạc không dây, Sạc ngược không dây','4500 mAh',' Li-Ion'),(2656,'Sạc pin nhanh','5000 mAh','Li-Po');
/*!40000 ALTER TABLE `pin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ram_ocung`
--

DROP TABLE IF EXISTS `ram_ocung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ram_ocung` (
  `id` bigint NOT NULL,
  `dungluongram` varchar(50) DEFAULT NULL,
  `hotrotoida` varchar(50) DEFAULT NULL,
  `loairam` varchar(255) DEFAULT NULL,
  `ocung` varchar(50) DEFAULT NULL,
  `tocdobus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ram_ocung`
--

LOCK TABLES `ram_ocung` WRITE;
/*!40000 ALTER TABLE `ram_ocung` DISABLE KEYS */;
INSERT INTO `ram_ocung` VALUES (786,'16 GB','4','DDR4','1 TB','3000MHz'),(878,'16 GB','4','DDR4','1 TB','3000MHz'),(889,'16 GB','4','DDR4','1 TB','3000MHz'),(898,'16 GB','1','DDR4','1 TB','3000MHz'),(909,'16 GB','1','DDR4','1 TB','3000MHz'),(917,'16 GB','1','DDR4','1 TB','3000MHz'),(924,'16 GB','1','DDR4','1 TB','3000MHz'),(931,'16 GB','1','DDR4','1 TB','3000MHz'),(938,'16 GB','1','DDR4','1 TB','3000MHz'),(945,'16 GB','1','DDR4','1 TB','3000MHz'),(952,'16 GB','1','DDR4','1 TB','3000MHz'),(959,'16 GB','1','DDR4','1 TB','3000MHz'),(966,'16 GB','1','DDR4','1 TB','3000MHz'),(973,'16 GB','1','DDR4','1 TB','3000MHz'),(980,'16 GB','1','DDR4','1 TB','3000MHz'),(989,'16 GB','1','DDR4','1 TB','3000MHz'),(996,'16 GB','1','DDR4','1 TB','3000MHz'),(1003,'16 GB','1','DDR4','1 TB','3000MHz'),(1010,'16 GB','1','DDR4','1 TB','3000MHz'),(1050,'16 GB','1','DDR4','1 TB','3000MHz'),(1058,'16 GB','1','DDR4','1 TB','3000MHz'),(1066,'16 GB','1','DDR4','1 TB','3000MHz'),(1074,'16 GB','1','DDR4','1 TB','3000MHz'),(1081,'16 GB','1','DDR4','1 TB','3000MHz'),(1088,'16 GB','1','DDR4','1 TB','3000MHz'),(1095,'16 GB','1','DDR4','1 TB','3000MHz'),(1103,'16 GB','1','DDR4','1 TB','3000MHz'),(1124,'16 GB','1','DDR4','1 TB','3000MHz'),(1131,'16 GB','1','DDR4','1 TB','3000MHz'),(1138,'16 GB','1','DDR4','1 TB','3000MHz'),(1145,'16 GB','1','DDR4','1 TB','3000MHz'),(1170,'16 GB','4','DDR4','1T & SSD 500GB M2','3000MHz'),(1183,'16 GB','1','DDR4','1 TB','3000MHz'),(1814,'16 GB',' Hãng không công bố',' Hãng không công bố','1 TB SSD',' Hãng không công bố'),(1827,'16 GB',' Hãng không công bố',' Hãng không công bố','1 TB SSD',' Hãng không công bố'),(1921,'16 GB',' Hãng không công bố',' Hãng không công bố','1 TB SSD',' Hãng không công bố'),(2048,'16 GB',' Hãng không công bố',' Hãng không công bố','1 TB SSD',' Hãng không công bố'),(2111,'16 GB','4','DDR4','1T & SSD 500GB M2','3000MHz'),(2127,'16 GB','4','DDR4','1T & SSD 500GB M2','3000MHz'),(2136,'16 GB','4','DDR4','1T & SSD 500GB M2','3000MHz'),(2148,'16 GB',' Hãng không công bố',' Hãng không công bố','1 TB SSD',' Hãng không công bố'),(2157,'16 GB',' Hãng không công bố',' Hãng không công bố','1 TB SSD',' Hãng không công bố'),(2169,'16 GB','2','DDR5','512 GB','4800 MHZ'),(2183,'8 GB','2','DDR4','512 GB','3200 MHz'),(2196,'8 GB','2','DDR4','512 GB','3200 MHz'),(2206,'8 GB','2','DDR4','512 GB','3200 MHz'),(2220,'8 GB','2','DDR4','512 GB','3200 MHz'),(2234,'8 GB','2','DDR5','512 GB','4800 MHZ'),(2248,'8 GB','2','DDR4','512 GB','3200 MHz'),(2262,'8 GB','2','DDR4','512 GB','3200 MHz'),(2304,'16 GB','2','DDR4','512 GB','3200 MHz'),(2318,'8 GB','2','DDR5','512 GB','4800 MHZ'),(2332,'8 GB','2','DDR5','512 GB','4800 MHZ'),(2346,'8 GB','2','DDR4','256 GB','3200 MHz'),(2359,'8 GB','2','DDR5','512 GB','4800 MHZ'),(2368,'8 GB','2','DDR4','512 GB','3200 MHz'),(2378,'8 GB','2','DDR4','512 GB','3200 MHz'),(2391,'8 GB','2','DDR4','256 GB','3200 MHz'),(2401,'8 GB','2','DDR4','512 GB','3200 MHz'),(2415,'16 GB','0','DDR4','512 GB','4266 MHz'),(2429,'16 GB','2','DDR4','512 GB','3200 MHz'),(2443,'16 GB','0','DDR5','512 GB','5200 MHz'),(2457,'8 GB','2','DDR4','512 GB','3200 MHz'),(2471,'16 GB','2','DDR4','512 GB','3200 MHz'),(2485,'16 GB','2','DDR4','512 GB','3200 MHz'),(2499,'8 GB','2','DDR4','512 GB','3200 MHz'),(2513,'8 GB','2','DDR4','512 GB','3200 MHz'),(2527,'8 GB','0','DDR4','256 GB','4267 MHz'),(2541,'16 GB','0','DDR5','1 TB','5200 MHz'),(2555,'32 GB','2','DDR4','1 TB','3200 MHz'),(2569,'16 GB',' Không hỗ trợ nâng cấp','DDR5','1 TB','4800 MHZ'),(2586,'16 GB',' Hãng không công bố',' Hãng không công bố','1 TB SSD',' Hãng không công bố'),(2595,'16 GB',' Hãng không công bố',' Hãng không công bố','1 TB SSD',' Hãng không công bố'),(2609,'16 GB','1','DDR4','1 TB','3000MHz'),(2621,'16 GB',' Hãng không công bố',' Hãng không công bố','1 TB SSD',' Hãng không công bố');
/*!40000 ALTER TABLE `ram_ocung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `id` bigint NOT NULL,
  `chatlieu` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `gia` double DEFAULT NULL,
  `hang` varchar(255) DEFAULT NULL,
  `mota` varchar(1000) DEFAULT NULL,
  `ngayramat` varchar(255) DEFAULT NULL,
  `tensp` varchar(255) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `ngay_dangsp` date DEFAULT NULL,
  `masp` varchar(255) NOT NULL,
  `sl` int DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `khuyenmai_id` bigint DEFAULT NULL,
  `clazz_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_b53iqqb8e2jt3pp7vgolvqwjc` (`masp`),
  KEY `FKivl2yf55j3g6xq650s823cgj2` (`category_id`),
  KEY `FK4506ruv3i6jun6hdw7wxsev1f` (`khuyenmai_id`),
  CONSTRAINT `FK4506ruv3i6jun6hdw7wxsev1f` FOREIGN KEY (`khuyenmai_id`) REFERENCES `khuyenmai` (`id`),
  CONSTRAINT `FKivl2yf55j3g6xq650s823cgj2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (894,'Thép','Đen',35000000,'Lenovo','easfadsdssds','2022-11-24','Laptop Lenovo Thinkpad E14 G4 (21E3S03G00) (i7 1255U/16GB RAM/512GB SSD/14.0 FHD/Dos/ Đen)',_binary '','2023-01-05','LAPTOP102',15,794,NULL,NULL),(1229,'Nhựa','Tím',800000,'Top-K','Hàng mới về','2022-12-31','Sạc dự phòng 20000mAh',_binary '',NULL,'SP02',1000,349,NULL,NULL),(1374,'Khung nhựa & Mặt lưng thuỷ tinh hữu cơ','Đen',14000000,'Oppo','Máy sở hữu một thiết kế lạ mắt, khác biệt so với các thế hệ tiền nhiệm. Đi kèm là hiệu năng mạnh mẽ cùng bộ camera chất lượng nhằm đáp ứng tốt cho bạn trên mọi tác vụ.','2022-08-30','OPPO Reno8 5G 8GB/256GB',_binary '','2023-01-01','OPR8256',50,450,1603,NULL),(1388,'Khung nhựa & Mặt lưng kính','Trắng',8990000,'Xiaomi','Redmi Note 11 Pro 5G có camera chính 108 MP, camera góc siêu rộng 8 MP và một camera macro 2 MP, máy chỉ có 3 camera và không có camera xóa phông như Redmi Note 11 Pro 4G. ','2022-10-20','Xiaomi Redmi Note 11 Pro 5G',_binary '','2023-01-01','RM11P5g',100,1387,1603,NULL),(1402,' Khung nhôm & Mặt lưng kính cường lực','Đen',21990000,'Apple','Chiếc điện thoại iPhone mới nhất 2022 này được hoàn thiện với ngoại hình vuông vức khi hai cạnh và các mặt vát phẳng, đây được xem là kiểu thiết kế thời thượng và được cộng đồng người dùng đón nhận rất tích cực kể từ thế hệ iPhone 12 cho đến nay.','2022-09-15','iPhone 14 128GB',_binary '','2023-01-01','ip14128d',100,449,1603,NULL),(1417,' Khung nhôm & Mặt lưng kính cường lực','Đen',10890000,'Apple','Apple đã chính thức trình làng bộ 3 siêu phẩm iPhone 11, trong đó phiên bản iPhone 11 64GB có mức giá rẻ nhất nhưng vẫn được nâng cấp mạnh mẽ như iPhone Xr ra mắt trước đó.','2019-11-01','iPhone 11 64GB Đen',_binary '','2023-01-01','ip1164d',100,449,NULL,NULL),(1431,' Khung nhôm & Mặt lưng kính cường lực','Đen',15490000,'Apple','Trong những tháng cuối năm 2020, Apple đã chính thức giới thiệu đến người dùng cũng như iFan thế hệ iPhone 12 series mới với hàng loạt tính năng bứt phá, thiết kế được lột xác hoàn toàn, hiệu năng đầy mạnh mẽ và một trong số đó chính là iPhone 12 64GB.','2020-10-01','iPhone 12 64GB Đen',_binary '','2023-01-01','ip1264d',100,449,NULL,NULL),(1444,'Khung kim loại & Mặt lưng kính','Đen',42990000,'Apple','Sau bao nhiêu ngày chờ đợi thì Apple đã chính thức tung ra mẫu điện thoại iPhone 14 Pro Max 512GB khi sở hữu một con chip với hiệu năng mạnh mẽ, màn hình đẹp mắt và cụm camera vô cùng chất lượng.','2022-10-01','iPhone 14 Pro Max 512GB Đen',_binary '','2023-01-01','ip14pm512d',100,449,NULL,NULL),(1473,'Khung kim loại & Mặt lưng kính','Đen',25970000,'SamSung','Samsung Galaxy S22 Ultra 256GB - chiếc điện thoại Galaxy S đầu tiên sở hữu bút S Pen trong thân máy, được cung cấp sức mạnh bởi CPU đến từ Qualcomm, sở hữu thiết kế sang trọng, màn hình có nhiều cải tiến cùng cụm camera zoom 100x. ','2022-02-01','Samsung S22 Ultra 256GB Đen',_binary '','2023-01-05','sss22u256d',100,349,684,NULL),(1486,'Khung kim loại & Mặt lưng kính','Đen',20210000,'SamSung','Samsung Galaxy S22+ 5G 128GB được Samsung cho ra mắt với ngoại hình không có quá nhiều thay đổi nhưng được nâng cấp đáng kể về thông số cấu hình bên trong và thời gian sử dụng, chắc hẳn sẽ mang lại những trải nghiệm thú vị dành cho bạn.','2022-02-10','Samsung S22 Plus 128GB Đen',_binary '','2023-01-08','sss22p128d',100,349,684,NULL),(1499,' Khung & Mặt lưng nhựa','Xanh',9690000,'SamSung','Samsung Galaxy A73 5G 128GB được xem là sản phẩm nổi bật nhất dòng Galaxy A 2022 mới ra mắt, máy trang bị bộ thông số kỹ thuật ấn tượng về phần hiệu năng, chất lượng màn hình và nổi bật nhất trong số đó là camera khi nó đem lại bức ảnh có độ phân giải lên đến 108 MP.','2022-04-02','Samsung Galaxy A73 128GB',_binary '','2023-01-08','ssa73128x',100,349,682,NULL),(1512,' Khung & Mặt lưng thủy tinh hữu cơ','Đen',5490000,'Oppo','Phiên bản OPPO A95 4G với giá thành phải chăng tập trung vào thiết kế năng động, sạc nhanh và hiệu năng đa nhiệm ấn tượng sẽ giúp cho cuộc sống của bạn thêm phần hấp dẫn, ngập tràn niềm vui.','2021-11-01','Oppo A95 128GB Đen',_binary '','2023-01-01','opa95128d',100,450,682,NULL),(1525,' Khung nhựa & Mặt lưng thuỷ tinh hữu cơ','Đen',7990000,'Oppo','OPPO đã trình làng mẫu Reno7 Z 5G với thiết kế OPPO Glow độc quyền, camera mang hiệu ứng như máy DSLR chuyên nghiệp cùng viền sáng kép, máy có một cấu hình mạnh mẽ và đạt chứng nhận xếp hạng A về độ mượt.','2022-03-01','OPPO Reno7 Z 5G Đen 128GB',_binary '','2023-01-01','opr7z128d',100,450,NULL,NULL),(1538,' Khung nhựa & Mặt lưng thuỷ tinh hữu cơ','Xanh',5790000,'Oppo','OPPO vừa cho ra mắt mẫu điện thoại tầm trung mới với tên gọi OPPO A77s, máy sở hữu màn hình lớn, thiết kế đẹp mắt, hiệu năng ổn định cùng khả năng mở rộng RAM lên đến 8 GB vô cùng nổi bật trong phân khúc.','2022-10-01','OPPO A77s 128GB Xanh',_binary '','2023-01-02','opa77s128x',100,450,684,NULL),(1551,'Khung nhựa & Mặt lưng thuỷ tinh hữu cơ','Xanh',5290000,'Oppo','OPPO A76 4G ra mắt với thiết kế trẻ trung, hiệu năng ổn định, màn hình 90 Hz mượt mà cùng viên pin trâu cho thời gian sử dụng lâu dài phù hợp cho mọi đối tượng người dùng.','','OPPO A76 128GB Xanh',_binary '','2023-01-02','opa76128x',100,450,684,NULL),(1564,'Khung nhựa & Mặt lưng thuỷ tinh hữu cơ','Đen',3990000,'Oppo','Điện thoại OPPO A57 64GB vừa mới ra mắt đã tạo ấn tượng tích cực với cộng đồng yêu công nghệ. Sở hữu cho mình một thiết kế trẻ trung, hiệu năng mượt mà đáp ứng tốt nhu cầu cơ bản hằng ngày.','2022-07-01','OPPO A57 4GB/64GB Đen',_binary '','2023-01-05','opa5764d',100,450,684,NULL),(1577,'Khung & Mặt lưng nhựa','Đen',3790000,'Oppo','OPPO cho ra mắt OPPO A55 4G chiếc smartphone giá rẻ tầm trung có thiết kế đẹp mắt, cấu hình khá ổn, cụm camera chất lượng và dung lượng pin ấn tượng, mang đến một lựa chọn trải nghiệm thú vị vừa túi tiền cho người tiêu dùng.','2021-10-01','OPPO A55 64GB Đen',_binary '','2023-01-02','opa5564d',100,450,684,NULL),(1590,' Khung nhựa & Mặt lưng thuỷ tinh hữu cơ','Xanh',3690000,'Oppo','Dường như OPPO đang ngày càng quan tâm đến trải nghiệm của người dùng, điều này được minh chứng qua nhiều dòng điện thoại của hãng trong đó có OPPO A17, máy sở hữu màn hình kích thước lớn, camera 50 MP đi cùng viên pin 5000 mAh với thời lượng dùng bền bỉ.','2022-10-01','OPPO A17 4GB/64GB Xanh',_binary '','2023-01-02','opa1764x',100,450,684,NULL),(1604,'Khung kim loại & Mặt lưng kính','Xanh',17690000,'Oppo','OPPO Reno8 Pro 5G là chiếc điện thoại cao cấp được nhà OPPO ra mắt vào thời điểm 09/2022, máy hướng đến sự hoàn thiện cao cấp ở phần thiết kế cùng khả năng quay chụp chuyên nghiệp nhờ trang bị vi xử lý hình ảnh MariSilicon X chuyên dụng.','2022-09-01','OPPO Reno8 Pro',_binary '','2023-01-02','opr8p256x',100,450,NULL,NULL),(1616,'Khung kim loại & Mặt lưng kính','Tím',21490000,'Xiaomi','Xiaomi 12 Pro 5G - chiếc điện thoại đến từ nhà Xiaomi sở hữu một thiết kế thanh lịch và vô cùng đẳng cấp, mang trong mình một hiệu năng \"khủng long\" cùng cụm 3 camera 50 MP mang lại khả năng chụp ảnh, quay phim chất lượng hàng đầu phân khúc.','2022-03-01','Xiaomi 12 Pro',_binary '','2023-01-02','xm12p256t',100,1387,NULL,NULL),(1644,' Khung kim loại, nhựa & Mặt lưng kính','Đen',16490000,'Xiaomi','Cuối cùng Xiaomi 12T Pro 5G cũng đã chính thức lộ diện trên thị trường sau hàng loạt thông tin rò rỉ về thông số, đúng như dự đoán thì độ phân giải trên camera của phiên bản này được nhà sản xuất nâng cấp lên đến 200 MP, giúp máy trở thành thiết bị có khả năng ghi hình sắc nét thuộc top đầu giới smartphone, đi kèm với đó là màn hình chất lượng cùng bộ vi xử lý mạnh mẽ xứng tầm flagship.','2022-10-01','Xiaomi 12T Pro',_binary '','2023-01-02','xm12tp256d',100,1387,NULL,NULL),(1656,'Khung kim loại & Mặt lưng kính cường lực Gorilla Glass 5','Trắng',8590000,'Xiaomi','Xiaomi 11 Lite 5G NE một phiên bản có ngoại hình rất giống với Xiaomi Mi 11 Lite được ra mắt trước đây. Chiếc smartphone này của Xiaomi mang trong mình một hiệu năng ổn định, thiết kế sang trọng và màn hình lớn đáp ứng tốt các tác vụ hằng ngày của bạn một cách dễ dàng.','2021-10-01','Xiaomi 11 Lite 5G NE',_binary '','2023-01-02','xm11l5gne128t',100,1387,NULL,NULL),(1668,'Khung kim loại & Mặt lưng kính','Đen',7090000,'Xiaomi','Kế thừa và nâng cấp từ thế hệ trước, Xiaomi đã cho ra mắt điện thoại Xiaomi Redmi Note 10 Pro (8GB/128GB) sở hữu một thiết kế cao cấp, sang trọng bên cạnh cấu hình vô cùng mạnh mẽ, hứa hẹn mang đến sự cạnh tranh lớn trong phân khúc smartphone tầm trung.','2021-03-01','Xiaomi Redmi Note 10 Pro',_binary '','2023-01-02','xmn10p128d',100,1387,NULL,NULL),(1680,' Khung & Mặt lưng nhựa','Vàng',2990000,'Xiaomi','Tháng 06/2022 điện thoại POCO C40 đã chính thức được cho ra mắt tại thị trường Việt Nam, sở hữu màn hình kích thước lớn, viên pin dung lượng khủng và một con chip JR510 mới lạ trên thị trường công nghệ hiện nay.','2022-06-01','POCO C40',_binary '','2023-01-02','xmpcc4064v',100,1387,NULL,NULL),(1692,' Khung & Mặt lưng nhựa','Xanh',2990000,'Xiaomi','Xiaomi Redmi 10C 64GB ra mắt với một cấu hình mạnh mẽ nhờ trang bị con chip 6 nm đến từ Qualcomm, màn hình hiển thị đẹp mắt, pin đáp ứng nhu cầu sử dụng cả ngày, hứa hẹn mang đến trải nghiệm tuyệt vời so với mức giá mà nó trang bị.','2022-03-01','Xiaomi Redmi 10C',_binary '','2023-01-02','xmrm10c64x',100,1387,NULL,NULL),(1704,' Khung kim loại & Mặt lưng nhựa','Nâu',12490000,'SamSung','Có lẽ 2022 là một năm bùng nổ của nhà Samsung, khi hãng liên tục trình làng nhiều sản phẩm có cấu hình mạnh mẽ cùng một mức giá bán hợp lý trên thị trường smartphone tầm trung và giá rẻ, tiêu biểu trong số đó có Samsung Galaxy M53 được xem là cái tên được cộng đồng người dùng tích cực quan tâm và săn đón kể cả khi chưa ra mắt.','2022-04-01','Samsung Galaxy M53',_binary '','2023-01-02','ssm53256n',100,349,NULL,NULL),(1716,' Khung nhôm & Mặt lưng nhựa','Xanh',9490000,'SamSung','Samsung đã giới thiệu đến người dùng thành viên mới của dòng S20 Series đó chính là điện thoại Samsung Galaxy S20 FE. Đây là mẫu flagship cao cấp quy tụ nhiều tính năng mà Samfan yêu thích, hứa hẹn sẽ mang lại trải nghiệm cao cấp của dòng Galaxy S với mức giá dễ tiếp cận hơn.','2021-05-01','Samsung Galaxy S20 FE',_binary '','2023-01-02','sss20fe256x',100,349,NULL,NULL),(1729,' Khung hợp kim nhôm & Mặt lưng kính','Xanh',17990000,'Vivo','Vivo X80 được xem là thiết bị hướng đến đối tượng người dùng chuyên nhiếp ảnh trên điện thoại, bằng việc hợp tác cùng nhà sản xuất ống kính nổi tiếng mang thương hiệu ZEISS. Với những tính năng mới mẻ hay chế độ quay - chụp độc đáo, X80 hứa hẹn mang đến cho bạn những trải nghiệm đầy mới lạ và chất lượng.','2022-06-01','Vivo X80',_binary '','2023-01-02','vivox80256x',100,1728,NULL,NULL),(1741,'Khung kim loại & Mặt lưng kính','Đen',13490000,'Vivo','Vivo V25 Pro 5G vừa được ra mắt với một mức giá bán cực kỳ hấp dẫn, thế mạnh của máy thuộc về phần hiệu năng nhờ trang bị con chip MediaTek Dimensity 1300 và cụm camera sắc nét 64 MP, hứa hẹn mang lại cho người dùng những trải nghiệm ổn định trong suốt quá trình sử dụng.','2022-11-01','Vivo V25 Pro 5G',_binary '','2023-01-02','vivov25p128d',100,1728,NULL,NULL),(1809,'Vỏ kim loại nguyên khối','Bạc',57490000,'Apple','Không còn quá xa lạ với sự đẳng cấp đến từ các sản phẩm của nhà Apple bởi lối thiết kế dẫn đầu xu hướng sang trọng, thời thượng và sức mạnh cấu hình ngoài mong đợi, nhưng còn đặc biệt hơn khi chiếc laptop MacBook Pro 16 M1 Pro 2021 này sẽ là phiên bản nâng cấp với con chip Apple M1 Pro mạnh mẽ, xử lý ấn tượng các tác vụ chuyên sâu.','2021-12-08','MacBook Pro 16 M1 Pro 2021 10-core CPU/16GB/1TB SSD/16-core GPU',_binary '','2023-01-05','MK1F3SA/A',100,794,NULL,NULL),(2106,'Thép','Bạc',35000000,'Apple','aaaaaaa','2022-12-28','MacBook Air M2 13\" 2022',_binary '','2023-01-03','MB22222',100,794,NULL,NULL),(2164,'Vỏ nhựa - nắp lưng bằng kim loại','Xám',33990000,'Lenovo','Laptop Lenovo Legion 5 15IAH7 i5 12500H (82RC003WVN) gây ấn tượng bởi lối thiết kế đậm chất thể thao, mạnh mẽ với khả năng vận hành mượt mà mọi tựa game từ nhẹ đến nặng, giúp các cao thủ chiến game đầy tự tin và tận hưởng những giây phút đỉnh cao trong chiến trường ảo.','2021-05-03','Lenovo Legion5 i5-12500H/16GB/512GB/RTX306015.6WQHD/Win11/Xám',_binary '','2023-01-03','15IAH7H-82RB0048VN',100,2162,NULL,NULL),(2178,'Vỏ nhựa','Đen',28990000,'Lenovo','Lenovo Legion 5 15ARH7- 82RE0035VN là một Laptop chơi game tầm trung. Nằm dưới Legion 5 Pr và Legion 7 trong dòng sản phẩm của Lenovo. Nó rất giống với IdeaPad Gaming 3 về thiết kế, nhưng Legion 5 trang bị MUX Switch và GPU chạy ở công suất cao hơn, cho phép hiệu suất tốt hơn.','2020-08-11','Lenovo Legion 5 R7 5800H/8GB/512GB/RTX 3050/15.6 inch FHD/ Win 11',_binary '','2023-01-03','15ACH6',100,2162,NULL,NULL),(2201,'Vỏ nhựa','Đen',28490000,'Acer','Đánh bật nhiều đối thủ trong cùng phân khúc laptop gaming với sự xuất hiện của con chip Intel Gen 12 đầy mạnh mẽ, laptop Acer Nitro 5 Tiger AN515 58 773Y i7 (NH.QFKSV.001) hứa hẹn sẽ là cánh tay phải đắc lực cho các game thủ oanh tạc trên mọi chiến trường.','2021-09-23','Acer Nitro 5 Tiger i7-12700H/8GB/512GB PCIE/RTX3050Ti/15.6 IPS 144Hz/WIN11/ĐEN',_binary '','2023-01-03','AN515-58-773Y',100,2162,NULL,NULL),(2215,'Vỏ nhựa','Đen',24990000,'Acer','Một bước tiến cấu hình vượt bật được Acer ưu ái trên chiếc laptop Acer Nitro 5 Tiger AN515 58 52SP i5 (NH.QFHSV.001) khi trang bị bộ vi xử lý Intel Gen 12 đầy mạnh mẽ cùng phong cách thiết kế đậm chất “mãnh hổ”, khơi nguồn sức mạnh tiềm ẩn bên trong mỗi game thủ trên mọi chiến trường ảo.','2021-04-22','Acer Nitro 5 Tiger  i5 12500H/8GB/512GB/4GB RTX3050/144Hz/Win11 Đen',_binary '','2023-01-03','AN515-58-52SP',100,2162,NULL,NULL),(2229,'Vỏ nhựa - nắp lưng bằng kim loại','Xám',24490000,'Asus','Laptop Asus ROG Strix Gaming G513R R7 (HN038W) là một đối thủ đáng gờm trong phân khúc laptop gaming khi trang bị cho mình bộ vi xử lý AMD Ryzen 7 mạnh mẽ cùng card rời RTX 3050 4 GB, luôn sẵn sàng cùng mình đương đầu mọi thử thách.','','Asus Rog Strix G15 R7-6800H/8GB/512GB/4GB RTX3050/15.6 FHD/WIN11/XÁM',_binary '','2023-01-03','G513RC HN038W',100,2162,NULL,NULL),(2243,'Vỏ nhựa - nắp lưng bằng kim loại','Đen',19690000,'Asus','Laptop Asus ROG Strix Gaming G513IH (HN015W) là một trợ thủ đắc lực cho mọi game thủ chuyên nghiệp với phong cách thiết kế vô cùng độc đáo, ấn tượng chuẩn gaming cùng bộ cấu hình đầy mạnh mẽ.','','Asus ROG Strix Gaming G513IH R7 4800H/8GB/512GB/4GB GTX1650/144Hz/Win11',_binary '','2023-01-03','G513IE-HN246W',100,2162,NULL,NULL),(2257,'Vỏ nhựa','Trắng',21990000,'Lenovo','Laptop Lenovo Ideapad Gaming 3 15IAH7 i5 (82S9007TVN) thuộc dòng laptop gaming mang vẻ đẹp ấn tượng, cuốn hút nhưng không kém phần mạnh mẽ nhờ vào CPU Intel Gen 12, sẵn sàng đồng hành cùng bạn trên mọi đấu trường game hiện nay.','2021-04-23','Lenovo Ideapad Gaming 3 i5 12500H/8GB/512GB/4GB RTX3050/120Hz/Win11',_binary '','2023-01-03','15IAH7',100,2162,NULL,NULL),(2299,'Vỏ nhựa','Trắng',31290000,'Lenovo','Laptop Lenovo Ideapad Gaming 3 15IAH7 i7 (82S9007UVN) khơi nguồn mọi cảm hứng game thủ khi sở hữu sức mạnh nổi bật đến từ chip Intel Gen 12 dòng H hiệu năng cao cùng card rời NVIDIA GeForce RTX mạnh mẽ, sẵn sàng cùng bạn đương đầu trên mọi chiến trường ảo.','','Lenovo Ideapad Gaming 3 i7 12700H/16GB/512GB/4GB RTX3050Ti/120Hz/Win11',_binary '','2023-01-03','15IAH8',100,2162,NULL,NULL),(2313,'Vỏ nhựa','Đen',29290000,'Asus','Laptop Asus TUF Gaming FX517ZM i7 (HN480W) sẵn sàng cùng bạn đương đầu trên mọi chiến trường khi sở hữu những thông số kỹ thuật mạnh mẽ đến từ bộ vi xử lý Intel Gen 12, card rời RTX 3060 6 GB, màn hình 144 Hz,... cùng ngoại hình hầm hố chuẩn gaming.  ','2022-05-23','Asus TUF Gaming i7 12650H/8GB/512GB/6GB RTX3060/144Hz/Win11',_binary '','2023-01-03','FX517ZM-HN480W',100,2162,NULL,NULL),(2327,'Vỏ nhựa','Xám',29990000,'Asus','Laptop Asus TUF Gaming FX507ZC i7 (HN124W) cực chất cùng hiệu năng mạnh mẽ từ CPU Intel thế hệ 12, thiết kế thời thượng sẵn sàng thách thức chinh phục ở mọi đấu trường ảo.','2022-07-22','Asus TUF Gaming F15  i7 - 12700H/8GB/512GB/RTX 3050 4GB/15.6-inch FHD/Win 11/Xám',_binary '','2023-01-03','FX507ZE - HN093W',100,2162,NULL,NULL),(2341,'Vỏ nhựa','Đen',16690000,'Acer','Laptop Aspire 7 Gaming A715 42G R4XX R5 (NH.QAYSV.008) sở hữu hiệu năng khoẻ cùng thiết kế mạnh mẽ, là bạn đồng hành lý tưởng trong mọi cuộc hành trình.','2022-04-12','Acer Aspire 7 Gaming R5 5500U/8GB/256GB/4GB GTX1650/Win11',_binary '','2023-01-03','A715-42G-R05G',100,2162,NULL,NULL),(2373,'Vỏ nhựa','Đen',18790000,'Acer','Một chiếc laptop gaming mà mình tin rằng các game thủ có thể dễ dàng bị chinh phục nhờ sở hữu mức giá lý tưởng nhưng lại trang bị những thông số kỹ thuật ấn tượng, em laptop Acer Aspire 7 Gaming A715 43G R8GA R5 (NH.QHDSV.002) hứa hẹn cùng bạn chinh phục mọi chiến trường.','2021-04-23','Acer Aspire 7 Gaming R5 5625U/8GB/512GB/4GB RTX3050/144Hz/Win11',_binary '','2023-01-03',' A715-43G-R8GA',100,2162,NULL,NULL),(2396,'Vỏ nhựa','Đen',21090000,'HP','Laptop HP VICTUS 16 d0292TX i5 (5Z9R3PA) sẽ là một người bạn đồng hành đắc lực trên mọi chiến trường ảo của game thủ nhờ ngoại hình sang trọng, hiện đại cùng những thông số kỹ thuật mạnh mẽ. ','2022-06-23','HP VICTUS 16 i5 11400H/8GB/512GB/4GB RTX3050Ti/144Hz/Win11',_binary '','2023-01-03','d0292TX',100,2162,NULL,NULL),(2410,'Vỏ kim loại','Bạc',28590000,'HP','Nếu bạn đang tìm kiếm một chiếc laptop học tập - văn phòng có thể đáp ứng tất tần tật mọi nhu cầu sử dụng hàng ngày từ học tập, làm việc văn phòng đến thiết kế đồ họa, còn chần chừ gì nữa mà không tham khảo ngay laptop HP Envy X360 13 bf0095TU i5 1230U (76B15PA) với thiết kế 2 trong 1 tiện lợi.','2022-02-01','HP Envy X360 i5 1230U/16GB/512GB/Touch/Pen/Win11',_binary '','2023-01-03','76B15PA',100,2163,NULL,NULL),(2424,'Vỏ kim loại','Bạc',26790000,'HP','Laptop HP EliteBook 630 G9 i7 (6M146PA) là một trong những siêu phẩm đáng cân nhắc khi bạn chọn mua laptop học tập - văn phòng. Máy sở hữu cấu hình mạnh mẽ đến từ con chip Intel Gen 12 cùng vẻ ngoài đẳng cấp, mỏng nhẹ có thể đáp ứng đầy đủ các nhu cầu khác nhau. ','2022-01-01','HP EliteBook 630 G9 i7 1255U/16GB/512GB/Win11',_binary '','2023-01-03','6M146PA',100,2163,NULL,NULL),(2438,' Vỏ kim loại - Nhôm','Bạc',59990000,'Dell','Dell đã gây sốc cho một người dùng trải nghiệm nhiều loại máy tính lâu năm như mình sau khi cầm trên tay mẫu laptop Dell XPS 13 Plus 9320 i7 (5CG56) với thiết kế khác lạ, sự hiện đại áp đảo hoàn toàn những mẫu laptop cao cấp đang có mặt trên thị trường.','2022-04-13','Dell XPS 13 Plus 9320 i7 1260P/16GB/512GB/Touch/Cáp/OfficeHS/Win11',_binary '','2023-01-03','5CG56',100,2163,NULL,NULL),(2452,' Nắp lưng và chiếu nghỉ tay bằng kim loại','Xám',24990000,'Dell','Laptop Dell Vostro 5620 i5 1240P (70296963) là mẫu laptop học tập - văn phòng sở hữu cấu hình mạnh mẽ khi được trang bị Intel Core i5 thế hệ 12, card màn hình NVIDIA GeForce MX570 cùng thiết kế hiện đại, chắc chắn sẽ là chiếc laptop không thể bỏ lỡ.','2022-09-24','Dell Vostro 5620 i5 1240P/8GB/512GB/2GB MX570/OfficeHS/Win11',_binary '','2023-01-03','P117F001AGR',100,2163,NULL,NULL),(2466,' Nắp lưng và chiếu nghỉ tay bằng kim loại','Bạc',24490000,'Dell','Laptop Dell Inspiron 16 5620 (i5P165W11SLU) - một tân binh mới trong phân khúc laptop học tập - văn phòng hứa hẹn sẽ không làm người dùng thất vọng khi sở hữu những thông số mạnh mẽ như chip Intel Gen 12, màn hình lớn cùng thiết kế thanh lịch, sang trọng. ','2022-05-02','Dell Inspiron 16 5620 i5 1240P/16GB/512GB/OfficeHS/Win11',_binary '','2023-01-03','i5P165W11SLU',100,2163,NULL,NULL),(2480,'Vỏ nhựa nắp lưng bằng kim loại','Đen',32490000,'MSI','Một siêu phẩm xứng đáng được các game thủ mong đợi chính là chiếc laptop MSI Gaming Alpha 15 B5EEK R7 (218VN) khi sở hữu nguồn sức mạnh bộc phá đến từ bộ vi xử lý AMD 5800H cùng card đồ họa rời RX 6600M 8 GB, luôn sẵn sàng cùng mình khuấy động mọi chiến trường ảo.','2022-06-03','MSI Gaming Alpha 15 R7 5800H/16GB/512GB/8GB RX6600M/144Hz/Balo/Chuột/Win11',_binary '','2023-01-03','B5EEK',100,2162,NULL,NULL),(2494,'Vỏ kim loại','Đen',24490000,'MSI','Sở hữu một vẻ ngoài độc đáo, mạnh mẽ phù hợp với mọi game thủ, chiếc laptop MSI Gaming GF63 Thin 11UD i7 11800H (648VN) được trang bị dòng chip Intel thế hệ 11 hiệu năng mạnh mẽ vượt trội khi đi cùng card màn hình rời RTX 3050 Ti Max-Q sẵn sàng chiến mượt bất kì tựa game phổ biến hay thiết kế đồ họa chuyên sâu.','2022-02-01','MSI Gaming GF63 Thin 11UD i7 11800H/8GB/512GB/4GB RTX3050Ti Max-Q/Balo/Chuột/Win11',_binary '','2023-01-03','648vn',100,2162,NULL,NULL),(2508,'Vỏ kim loại','Xám',18390000,'MSI','MSI Modern 14 B11MOU (618VN) thu hút mọi ánh nhìn của những người xung quanh với lối thiết kế mỏng nhẹ - thời trang cùng những thông số kỹ thuật mạnh mẽ nhưng lại sở hữu mức giá tầm trung ấn tượng, xứng đáng trở thành sự lựa chọn hoàn hảo đáp ứng mọi nhu cầu học tập và làm việc của khách hàng.','2022-03-01','MSI Modern 14 B11MOU i7 1195G7/8GB/512GB/Túi/Chuột/Win10',_binary '','2023-01-03','618VN',100,2163,NULL,NULL),(2522,'Vỏ kim loại nguyên khối','Đen',24990000,'Microsoft','Đại diện cho sự kết hợp giữa sức mạnh của một chiếc laptop cùng với ngoại hình linh hoạt, cơ động của một chiếc tablet, laptop Surface Pro 8 i5 (DR1-00003) sẵn sàng cùng bạn xử lý các tác vụ văn phòng nhanh chóng.','2022-03-01','Surface Pro 8 i5 1135G7/8GB/256GB/Touch/120Hz/Win11',_binary '','2023-01-03','DR1-00003',100,2163,NULL,NULL),(2536,'Vỏ kim loại','Đen',49790000,'LG','Laptop LG gram 2022 i7 1260P (17Z90Q-G.AX78A5) sẽ là một siêu phẩm laptop cao cấp - sang trọng đáng để bạn sở hữu bởi ngoại hình mỏng nhẹ, thời thượng cùng hiệu năng vượt bậc từ con chip Intel Gen 12, hứa hẹn mang đến những trải nghiệm làm việc và giải trí trọn vẹn nhất cho người dùng là sinh viên, nhân viên hay doanh nhân.','2022-04-05','LG gram 2022 i7 1260P/16GB/1TB/Win11',_binary '','2023-01-03','17Z90Q-G.AH78A5',100,2163,NULL,NULL),(2550,'Vỏ nhựa','Đen',59490000,'Dell','Với phong cách thiết kế độc đáo cùng cấu hình vượt trội, laptop Dell Gaming Alienware m15 R6 i7 11800H (70272633) sẵn sàng đáp ứng hoàn hảo mọi tác vụ của một chiếc laptop đồ họa - kỹ thuật như thiết kế hay chiến game.','','Dell Gaming Alienware m15 R6 i7 11800H/32GB/1TB SSD/8GB RTX3070/240Hz/OfficeHS/Win11',_binary '','2023-01-04','70272633',100,2162,NULL,NULL),(2564,' Vỏ kim loại - Nắp lưng hợp kim Nhôm Magie','Đen',51490000,'Asus','Khám phá những điều mới mẻ đến khó tin trên chiếc laptop Asus Zenbook Pro 14 Duo OLED UX8402ZE i7 (M3044W) khi trang bị thêm chiếc màn hình thứ 2 độc đáo lên đến 12.7 inch, kết hợp với các thông số cấu hình mạnh mẽ giúp người dùng phát huy tối đa sức mạnh cũng như khả năng sáng tạo của mình.','2022-04-02','Asus Zenbook Pro 14 Duo OLED UX8402ZE i7 12700H/16GB/1TB/4GB RTX3050Ti/Touch/Pen/Túi/Win11',_binary '','2023-01-04','M3044W',100,2163,NULL,NULL);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanphamhd`
--

DROP TABLE IF EXISTS `sanphamhd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanphamhd` (
  `id` bigint NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `gia` double DEFAULT NULL,
  `hang` varchar(255) DEFAULT NULL,
  `urlimg` varchar(255) DEFAULT NULL,
  `masp` varchar(255) DEFAULT NULL,
  `sl` int DEFAULT NULL,
  `tensp` varchar(255) DEFAULT NULL,
  `tong` double DEFAULT NULL,
  `hoadon_id` bigint DEFAULT NULL,
  `hoa_don_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9ex75gnrmfn7v428l97wqtsp1` (`hoadon_id`),
  KEY `FK9pj21lx7grd368wu5ueqhh0ck` (`hoa_don_id`),
  CONSTRAINT `FK9ex75gnrmfn7v428l97wqtsp1` FOREIGN KEY (`hoadon_id`) REFERENCES `hoadon` (`id`),
  CONSTRAINT `FK9pj21lx7grd368wu5ueqhh0ck` FOREIGN KEY (`hoa_don_id`) REFERENCES `hoadon` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanphamhd`
--

LOCK TABLES `sanphamhd` WRITE;
/*!40000 ALTER TABLE `sanphamhd` DISABLE KEYS */;
INSERT INTO `sanphamhd` VALUES (2757,'Đen',18178999.690413475,'SamSung','/dtImages/167258934693174882.jpg','sss22u256d',1,'Samsung S22 Ultra 256GB Đen',18179000,2756,NULL),(2759,'Đen',18178999.690413475,'SamSung','/dtImages/167258934693174882.jpg','sss22u256d',1,'Samsung S22 Ultra 256GB Đen',18179000,2758,NULL),(2762,'Đen',10995000,'Apple','/dtImages/167258623713290582.png','ip14128d',1,'iPhone 14 128GB',10995000,2761,NULL),(2766,'Bạc',57490000,'Apple','/ltImages/167290843665215329.png','MK1F3SA/A',1,'MacBook Pro 16 M1 Pro 2021 10-core CPU/16GB/1TB SSD/16-core GPU',57490000,2765,NULL),(2767,'Đen',42990000,'Apple','/dtImages/167258859929681881.png','ip14pm512d',1,'iPhone 14 Pro Max 512GB Đen',42990000,2765,NULL),(2771,'Đen',7000000,'Oppo','/dtImages/167257487065135209.png','OPR8256',2,'OPPO Reno8 5G 8GB/256GB',14000000,2770,NULL),(2774,'Đen',10995000,'Apple','/dtImages/167258623713290582.png','ip14128d',1,'iPhone 14 128GB',10995000,2773,NULL),(2777,'Đen',10890000,'Apple','/dtImages/167258713729460492.png','ip1164d',1,'iPhone 11 64GB Đen',10890000,2776,NULL),(2780,'Trắng',4495000,'Xiaomi','/dtImages/167258489862120116.png','RM11P5g',1,'Xiaomi Redmi Note 11 Pro 5G',4495000,2779,NULL),(2790,'Trắng',4495000,'Xiaomi','/dtImages/167258489862120116.png','RM11P5g',1,'Xiaomi Redmi Note 11 Pro 5G',4495000,2789,NULL),(2794,'Đen',18178999.690413475,'SamSung','/dtImages/167258934693174882.jpg','sss22u256d',1,'Samsung S22 Ultra 256GB Đen',18179000,2793,NULL),(2795,'Đen',14146999.759078026,'SamSung','/dtImages/167259006024089092.jpg','sss22p128d',1,'Samsung S22 Plus 128GB Đen',14147000,2793,NULL),(2800,'Bạc',35000000,'Apple','/ltImages/167268239549798634.png','MB22222',1,'MacBook Air M2 13\" 2022',35000000,2799,NULL),(2801,'Đen',18790000,'Acer','/ltImages/167275960049235405.png',' A715-43G-R8GA',1,'Acer Aspire 7 Gaming R5 5625U/8GB/512GB/4GB RTX3050/144Hz/Win11',18790000,2799,NULL),(2802,'Bạc',28590000,'HP','/ltImages/167276126103218927.png','76B15PA',1,'HP Envy X360 i5 1230U/16GB/512GB/Touch/Pen/Win11',28590000,2799,NULL),(2805,'Bạc',59990000,'Dell','/ltImages/167276207630363309.png','5CG56',3,'Dell XPS 13 Plus 9320 i7 1260P/16GB/512GB/Touch/Cáp/OfficeHS/Win11',179970000,2804,NULL),(2839,'Bạc',35000000,'Apple','/ltImages/167268239549798634.png','MB22222',6,'MacBook Air M2 13\" 2022',210000000,2838,NULL),(2842,'Đen',10995000,'Apple','/dtImages/167258623713290582.png','ip14128d',1,'iPhone 14 128GB',10995000,2841,NULL),(2845,'Đen',35000000,'Lenovo','/ltImages/167290824078484461.png','LAPTOP102',16,'Laptop Lenovo Thinkpad E14 G4 (21E3S03G00) (i7 1255U/16GB RAM/512GB SSD/14.0 FHD/Dos/ Đen)',560000000,2844,NULL),(2848,'Bạc',57490000,'Apple','/ltImages/167290843665215329.png','MK1F3SA/A',1,'MacBook Pro 16 M1 Pro 2021 10-core CPU/16GB/1TB SSD/16-core GPU',57490000,2847,NULL),(2849,'Xám',33990000,'Lenovo','/ltImages/167275404511332896.png','15IAH7H-82RB0048VN',2,'Lenovo Legion5 i5-12500H/16GB/512GB/RTX306015.6WQHD/Win11/Xám',67980000,2847,NULL),(2850,'Xanh',17690000,'Oppo','/dtImages/167267175186462275.png','opr8p256x',4,'OPPO Reno8 Pro',70760000,2847,NULL);
/*!40000 ALTER TABLE `sanphamhd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slider`
--

DROP TABLE IF EXISTS `slider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slider` (
  `id` bigint NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `ngay_tao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slider`
--

LOCK TABLES `slider` WRITE;
/*!40000 ALTER TABLE `slider` DISABLE KEYS */;
INSERT INTO `slider` VALUES (2855,'Galaxy Z Fold','167595111097880484.png','2023-02-09 20:58:31'),(2856,'Oppo Reno 8','167595113337244192.png','2023-02-09 20:58:53'),(2857,'Dell XPS','1675951207647157.png','2023-02-09 21:00:08'),(2858,'Lenovo X1','167595123652327209.png','2023-02-09 21:00:37'),(2859,'HP Victus','167595145423654217.png','2023-02-09 21:04:14'),(2860,'Samsung S23','167595229181898115.png','2023-02-09 21:18:12'),(2861,'Xiaomi mi 13 pro','167595280828419238.png','2023-02-09 21:26:48'),(2863,'pixel 7 pro','167595346116014635.png','2023-02-09 21:37:41');
/*!40000 ALTER TABLE `slider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tienich`
--

DROP TABLE IF EXISTS `tienich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tienich` (
  `id` bigint NOT NULL,
  `baomat` varchar(255) DEFAULT NULL,
  `tinhnangdacbiet` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tienich`
--

LOCK TABLES `tienich` WRITE;
/*!40000 ALTER TABLE `tienich` DISABLE KEYS */;
INSERT INTO `tienich` VALUES (384,'Vân tay','khuôn mặt'),(396,'àdzcxvxc','dzfsafdsadsa'),(466,'',''),(476,'sds','dssds'),(503,'sds','dssds'),(512,'sds','dssds'),(521,'sds','dssds'),(530,'sds','dssds'),(539,'sds','dssds'),(548,'sds','dssds'),(557,'sds','dssds'),(565,'sds','dssds'),(581,'sds','dssds'),(589,'sds','dssds'),(597,'àdzcxvxc','dzfsafdsadsa'),(606,'àdzcxvxc','dzfsafdsadsa'),(614,'sds','dssds'),(622,'sds','dssds'),(670,'sds','dssds'),(681,'àdzcxvxc','dzfsafdsadsa'),(789,'dsada','sadsadsa'),(881,'dsfdss','sdsdsds'),(892,'edsfasdfsa','dsafdsafsafdsa'),(901,'etyr','tryryrytryr'),(912,'etyr','tryryrytryr'),(920,'etyr','tryryrytryr'),(927,'etyr','tryryrytryr'),(934,'etyr','tryryrytryr'),(941,'etyr','tryryrytryr'),(948,'etyr','tryryrytryr'),(955,'etyr','tryryrytryr'),(962,'etyr','tryryrytryr'),(969,'etyr','tryryrytryr'),(976,'etyr','tryryrytryr'),(983,'etyr','tryryrytryr'),(992,'etyr','tryryrytryr'),(999,'etyr','tryryrytryr'),(1006,'etyr','tryryrytryr'),(1013,'etyr','tryryrytryr'),(1053,'etyr','tryryrytryr'),(1061,'etyr','tryryrytryr'),(1069,'etyr','tryryrytryr'),(1077,'etyr','tryryrytryr'),(1084,'etyr','tryryrytryr'),(1091,'etyr','tryryrytryr'),(1098,'etyr','tryryrytryr'),(1106,'etyr','tryryrytryr'),(1127,'etyr','tryryrytryr'),(1134,'etyr','tryryrytryr'),(1141,'etyr','tryryrytryr'),(1148,'etyr','tryryrytryr'),(1164,'àdzcxvxc','dzfsafdsadsa'),(1174,'adsadas','adsada'),(1187,'etyr','tryryrytryr'),(1197,'sds','dssds'),(1208,'sds','dssds'),(1216,'sds','dssds'),(1224,'sds','dssds'),(1247,'sds','dssds'),(1255,'sds','dssds'),(1271,'sds','dssds'),(1291,'sds','dssds'),(1299,'sds','dssds'),(1307,'sds','dssds'),(1323,'Mở khoá khuôn mặt Face ID','Phát hiện va chạm (Crash Detection), Chạm 2 lần sáng màn hình, Apple Pay, Loa kép'),(1338,'Mở khoá khuôn mặt Face ID','Phát hiện va chạm (Crash Detection), Chạm 2 lần sáng màn hình, Apple Pay, Loa kép'),(1380,'Mở khoá vân tay dưới màn hình, Mở khoá khuôn mặt','Mở rộng bộ nhớ RAM, Chạm 2 lần tắt/sáng màn hình, Chặn cuộc gọi, Ứng dụng kép'),(1394,'\r\nMở khoá khuôn mặt, Mở khoá vân tay cạnh viền','Công nghệ tản nhiệt LiquidCool, Loa kép'),(1408,'Mở khoá khuôn mặt Face ID','Phát hiện va chạm (Crash Detection), Chạm 2 lần sáng màn hình, Apple Pay'),(1423,'Mở khoá khuôn mặt Face ID','Âm thanh Dolby Audio, Apple Pay'),(1437,'\r\nMở khoá khuôn mặt Face ID','Kháng nước, bụi:IP68'),(1450,'Mở khoá khuôn mặt Face ID','Màn hình luôn hiển thị AOD, Phát hiện va chạm (Crash Detection), Chạm 2 lần sáng màn hình, Apple Pay'),(1464,'Mở khoá khuôn mặt Face ID','Âm thanh Dolby Audio, Apple Pay'),(1472,'Mở khoá khuôn mặt Face ID','Phát hiện va chạm (Crash Detection), Chạm 2 lần sáng màn hình, Apple Pay'),(1479,'Mở khoá vân tay dưới màn hình, Mở khoá khuôn mặt','Chạm 2 lần sáng màn hình, Trợ lý ảo Samsung Bixby, Chặn cuộc gọi, Chặn tin nhắn'),(1492,'Mở khoá khuôn mặtMở khoá vân tay dưới màn hình','Samsung Pay, Màn hình luôn hiển thị AOD, Chạm 2 lần tắt/sáng màn hình, Thu nhỏ màn hình sử dụng một tay'),(1505,'Mở khoá vân tay dưới màn hình','Trợ lý ảo Samsung Bixby, Chạm 2 lần tắt/sáng màn hình, Samsung Pay, Đa cửa sổ (chia đôi màn hình)'),(1518,'Mở khoá khuôn mặt, Mở khoá vân tay dưới màn hình','Ứng dụng kép, Nhân bản ứng dụng), Mở rộng bộ nhớ RAM'),(1531,'Mở khoá khuôn mặt, Mở khoá vân tay dưới màn hình','Chế độ đơn giản (Giao diện đơn giản), Cử chỉ thông minh, Chạm 2 lần tắt/sáng màn hình, Ứng dụng kép (Nhân bản ứng dụng)'),(1544,'Mở khoá khuôn mặt, Mở khoá vân tay cạnh viền','Cử chỉ thông minh, Chạm 2 lần tắt/sáng màn hình, Ứng dụng kép (Nhân bản ứng dụng), Tối ưu game (Không gian trò chơi)'),(1557,'\r\nMở khoá khuôn mặt, Mở khoá vân tay cạnh viền','Cử chỉ thông minh, Chạm 2 lần sáng màn hình, Ứng dụng kép (Nhân bản ứng dụng), Tối ưu game (Không gian trò chơi)'),(1570,'Mở khoá khuôn mặt, Mở khoá vân tay cạnh viền','Chế độ đơn giản (Giao diện đơn giản), Ứng dụng kép (Nhân bản ứng dụng), Trợ lý ảo Google Assistant, Chế độ trẻ em (Không gian trẻ em)'),(1583,'\r\nMở khoá khuôn mặt, Mở khoá vân tay cạnh viền','Ứng dụng kép (Nhân bản ứng dụng)'),(1596,'Mở khoá khuôn mặt, Mở khoá vân tay cạnh viền','Cử chỉ thông minh, Chạm 2 lần tắt/sáng màn hình, Ứng dụng kép (Nhân bản ứng dụng), Thu nhỏ màn hình sử dụng một tay'),(1610,'\r\nMở khoá vân tay dưới màn hình, Mở khoá khuôn mặt','Chế độ đơn giản (Giao diện đơn giản), Chạm 2 lần tắt/sáng màn hình, Vẽ lên màn hình để mở nhanh ứng dụng, Chặn cuộc gọi'),(1622,'Mở khoá vân tay dưới màn hình, Mở khoá khuôn mặt','Chạm 2 lần tắt/sáng màn hình, Màn hình luôn hiển thị AOD, Âm thanh bởi Harman Kardon, Đa cửa sổ (chia đôi màn hình)'),(1635,'\r\nMở khoá vân tay dưới màn hình, Mở khoá khuôn mặt','Chế độ đơn giản (Giao diện đơn giản), Chạm 2 lần tắt/sáng màn hình, Vẽ lên màn hình để mở nhanh ứng dụng, Chặn cuộc gọi'),(1643,'Mở khoá vân tay dưới màn hình, Mở khoá khuôn mặt','Chạm 2 lần tắt/sáng màn hình, Màn hình luôn hiển thị AOD, Âm thanh bởi Harman Kardon, Đa cửa sổ (chia đôi màn hình)'),(1650,'Mở khoá khuôn mặt, Mở khoá vân tay dưới màn hình','Màn hình luôn hiển thị AOD, Âm thanh Hi-Res Audio, Chạm 2 lần tắt/sáng màn hình, Chặn cuộc gọi'),(1662,'Mở khoá khuôn mặt, Mở khoá vân tay cạnh viền','Ghi âm mặc định, Ghi âm cuộc gọi'),(1674,'\r\nMở khoá khuôn mặt, Mở khoá vân tay cạnh viền','Ứng dụng kép (Nhân bản ứng dụng), Chặn cuộc gọi, Chặn tin nhắn'),(1686,'\r\nMở khóa bằng vân tay','\r\nChạm 2 lần sáng màn hình, Mở rộng bộ nhớ RAM'),(1698,'\r\nMở khoá khuôn mặt, Mở khóa bằng vân tay','Chạm 2 lần tắt/sáng màn hình, Tối ưu game (Game Turbo), Làm sạch loa, Mở rộng bộ nhớ RAM'),(1710,'Mở khoá vân tay cạnh viền','Samsung Pay, Chế độ đơn giản (Giao diện đơn giản), Trợ lý ảo Samsung Bixby, Tối ưu game (Game Booster)'),(1722,'\r\nMở khoá khuôn mặt, Mở khoá vân tay dưới màn hình','Ứng dụng kép (Nhân bản ứng dụng), Tối ưu game (Game Booster), Chế độ trẻ em (Samsung Kids), Không gian thứ hai (Thư mục bảo mật)'),(1735,'Mở khoá vân tay dưới màn hìnhMở khoá khuôn mặt 3D','Cử chỉ thông minh, Trợ lý ảo Jovi, Chạm 2 lần tắt/sáng màn hình, Vẽ lên màn hình để mở nhanh ứng dụng'),(1747,'\r\nMở khoá khuôn mặt, Mở khoá vân tay dưới màn hình','Trợ lý ảo Jovi, Màn hình luôn hiển thị AOD, Chế độ đơn giản (Giao diện đơn giản), Hệ thống làm mát sinh học'),(1818,'Bảo mật vân tay','Sạc MagSafe'),(1831,'Bảo mật vân tay','Sạc MagSafe'),(1925,'Bảo mật vân tay','Sạc MagSafe'),(2052,'Bảo mật vân tay','Sạc MagSafe'),(2115,'sssssssss','sssssssssss'),(2131,'sssssssss','sssssssssss'),(2140,'sssssssss','sssssssssss'),(2152,'Bảo mật vân tay','Sạc MagSafe'),(2161,'Bảo mật vân tay','Sạc MagSafe'),(2173,'TPM 2.0','Bản lề mở 180 độ, Đèn bàn phím chuyển màu RGB, Công tắc khóa camera'),(2187,'TMM 2.0',''),(2200,'TMM 2.0',''),(2210,'TPM 2.0',''),(2224,'TPM 2.0',''),(2238,'TPM 2.0',''),(2252,'TPM 2.0',''),(2266,'TPM 2.0',''),(2308,'TPM 2.0',''),(2322,'TPM 2.0',''),(2336,'TPM 2.0',''),(2350,'TPM 2.0',''),(2363,'TPM 2.0',''),(2372,'TPM 2.0',''),(2382,'TPM 2.0',''),(2395,'TPM 2.0',''),(2405,'TPM 2.0',''),(2419,'TPM 2.0',''),(2433,'TPM 2.0',''),(2447,'TPM 2.0, Bảo mật vân tay, Mở khóa khuôn mặt',''),(2461,'Bảo mật vân tay',''),(2475,'Bảo mật vân tay',''),(2489,'TPM 2.0',''),(2503,'TPM 2.0',''),(2517,'TPM 2.0',''),(2531,'Mở khóa khuôn mặt','Tương thích bút: Microsoft Pen Protocol (MPP), Surface Slim Pen 2, Tương thích bàn phím: Surface Pro Signature Keyboard, Surface Pro X Keyboard'),(2545,'Mở khóa khuôn mặt','Độ bền chuẩn quân đội MIL STD 810G'),(2559,'TPM 2.0',''),(2573,'TPM 2.0','ScreenPad Plus 12.7 inch'),(2590,'Bảo mật vân tay','Sạc MagSafe'),(2599,'Bảo mật vân tay','Sạc MagSafe'),(2613,'etyr','tryryrytryr'),(2625,'Bảo mật vân tay','Sạc MagSafe'),(2633,'Mở khoá khuôn mặt, Mở khoá vân tay cạnh viền','Chế độ đơn giản (Giao diện đơn giản), Ứng dụng kép (Nhân bản ứng dụng), Trợ lý ảo Google Assistant, Chế độ trẻ em (Không gian trẻ em)'),(2641,'Mở khoá vân tay dưới màn hình, Mở khoá khuôn mặt','Chạm 2 lần sáng màn hình, Trợ lý ảo Samsung Bixby, Chặn cuộc gọi, Chặn tin nhắn'),(2649,'Mở khoá khuôn mặtMở khoá vân tay dưới màn hình','Samsung Pay, Màn hình luôn hiển thị AOD, Chạm 2 lần tắt/sáng màn hình, Thu nhỏ màn hình sử dụng một tay'),(2657,'Mở khoá vân tay dưới màn hình','Trợ lý ảo Samsung Bixby, Chạm 2 lần tắt/sáng màn hình, Samsung Pay, Đa cửa sổ (chia đôi màn hình)');
/*!40000 ALTER TABLE `tienich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` bigint NOT NULL,
  `id_role` bigint DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2aam9nt2tv8vcfymi3jo9c314` (`id_role`),
  KEY `FK3yqq634q79g884fo8gr6iwwof` (`id_user`),
  CONSTRAINT `FK2aam9nt2tv8vcfymi3jo9c314` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`),
  CONSTRAINT `FK3yqq634q79g884fo8gr6iwwof` FOREIGN KEY (`id_user`) REFERENCES `nguoi_dung` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,1,2),(4,2,3),(6,2,5),(8,2,7),(13,1,12),(15,1,14),(17,1,16),(19,1,18),(21,1,20),(23,1,22),(25,2,24),(27,1,26),(29,2,36),(31,NULL,NULL),(33,NULL,NULL),(35,1,34),(38,1,28),(39,1,28),(40,1,28),(42,1,34),(43,1,34),(44,1,28),(45,1,28),(46,1,34),(47,1,28),(48,1,28),(49,1,34),(50,1,28),(51,1,28),(52,1,28),(53,1,28),(54,1,28),(55,1,28),(56,1,28),(57,1,28),(58,1,28),(59,1,28),(60,1,28),(61,1,28),(62,1,28),(63,1,28),(64,1,28),(65,1,28),(66,1,28),(67,1,28),(68,1,28),(69,1,28),(70,1,28),(71,1,28),(72,1,28),(73,1,28),(74,1,28),(75,1,28),(76,1,28),(77,1,28),(78,1,28),(79,1,28),(80,1,28),(81,1,28),(82,1,28),(89,1,28),(90,1,28),(91,1,28),(92,1,28),(93,1,28),(94,1,28),(95,1,28),(96,1,28),(97,1,28),(98,1,28),(99,1,28),(100,1,28),(101,1,28),(102,1,28),(103,1,28),(104,1,28),(105,1,28),(106,1,28),(107,1,28),(108,1,28),(109,1,28),(110,1,28),(114,1,28),(115,1,28),(116,1,28),(124,1,28),(125,1,26),(126,1,26),(127,1,26),(128,1,26),(129,1,26),(130,1,26),(131,1,28),(132,1,28),(134,1,133),(135,2,133),(136,1,26),(137,1,26),(138,1,26),(172,1,171),(279,1,28),(280,1,28),(281,1,28),(483,1,28),(484,1,28),(2823,2,2822),(2825,2,2824),(2827,2,2826),(2832,2,2831);
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

-- Dump completed on 2023-02-09 21:49:05
