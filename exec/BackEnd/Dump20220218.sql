-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: ssafy-db.cu2jigolcza5.ap-northeast-2.rds.amazonaws.com    Database: galmuri
-- ------------------------------------------------------
-- Server version	8.0.27

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `country_code` varchar(3) NOT NULL,
  `continent` varchar(255) NOT NULL,
  `country_name` varchar(255) NOT NULL,
  PRIMARY KEY (`country_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('ABW','North America','Aruba'),('AFG','Asia','Afghanistan'),('AGO','Africa','Angola'),('AIA','North America','Anguilla'),('ALA','Europe','Aland Islands'),('ALB','Europe','Albania'),('AND','Europe','Andorra'),('ANT','North America','Netherlands Antilles'),('ARE','Asia','United Arab Emirates'),('ARG','South America','Argentina'),('ARM','Asia','Armenia'),('ASM','Oceania','American Samoa'),('ATA','Antarctica','Antarctica'),('ATF','Antarctica','French Southern Territories'),('ATG','North America','Antigua and Barbuda'),('AUS','Oceania','Australia'),('AUT','Europe','Austria'),('AZE','Asia','Azerbaijan'),('BDI','Africa','Burundi'),('BEL','Europe','Belgium'),('BEN','Africa','Benin'),('BES','North America','Bonaire, Sint Eustatius and Saba'),('BFA','Africa','Burkina Faso'),('BGD','Asia','Bangladesh'),('BGR','Europe','Bulgaria'),('BHR','Asia','Bahrain'),('BHS','North America','Bahamas'),('BIH','Europe','Bosnia and Herzegovina'),('BLM','North America','Saint Barthelemy'),('BLR','Europe','Belarus'),('BLZ','North America','Belize'),('BMU','North America','Bermuda'),('BOL','South America','Bolivia'),('BRA','South America','Brazil'),('BRB','North America','Barbados'),('BRN','Asia','Brunei Darussalam'),('BTN','Asia','Bhutan'),('BVT','Antarctica','Bouvet Island'),('BWA','Africa','Botswana'),('CAF','Africa','Central African Republic'),('CAN','North America','Canada'),('CCK','Asia','Cocos (Keeling) Islands'),('CHE','Europe','Switzerland'),('CHL','South America','Chile'),('CHN','Asia','China'),('CIV','Africa','Cote D\'Ivoire'),('CMR','Africa','Cameroon'),('COD','Africa','Congo, Democratic Republic of the Congo'),('COG','Africa','Congo'),('COK','Oceania','Cook Islands'),('COL','South America','Colombia'),('COM','Africa','Comoros'),('CPV','Africa','Cape Verde'),('CRI','North America','Costa Rica'),('CUB','North America','Cuba'),('CUW','North America','Curacao'),('CXR','Asia','Christmas Island'),('CYM','North America','Cayman Islands'),('CYP','Asia','Cyprus'),('CZE','Europe','Czech Republic'),('DEU','Europe','Germany'),('DJI','Africa','Djibouti'),('DMA','North America','Dominica'),('DNK','Europe','Denmark'),('DOM','North America','Dominican Republic'),('DZA','Africa','Algeria'),('ECU','South America','Ecuador'),('EGY','Africa','Egypt'),('ERI','Africa','Eritrea'),('ESH','Africa','Western Sahara'),('ESP','Europe','Spain'),('EST','Europe','Estonia'),('ETH','Africa','Ethiopia'),('FIN','Europe','Finland'),('FJI','Oceania','Fiji'),('FLK','South America','Falkland Islands (Malvinas)'),('FRA','Europe','France'),('FRO','Europe','Faroe Islands'),('FSM','Oceania','Micronesia, Federated States of'),('GAB','Africa','Gabon'),('GBR','Europe','United Kingdom'),('GEO','Asia','Georgia'),('GGY','Europe','Guernsey'),('GHA','Africa','Ghana'),('GIB','Europe','Gibraltar'),('GIN','Africa','Guinea'),('GLP','North America','Guadeloupe'),('GMB','Africa','Gambia'),('GNB','Africa','Guinea-Bissau'),('GNQ','Africa','Equatorial Guinea'),('GRC','Europe','Greece'),('GRD','North America','Grenada'),('GRL','North America','Greenland'),('GTM','North America','Guatemala'),('GUF','South America','French Guiana'),('GUM','Oceania','Guam'),('GUY','South America','Guyana'),('HKG','Asia','Hong Kong'),('HMD','Antarctica','Heard Island and McDonald Islands'),('HND','North America','Honduras'),('HRV','Europe','Croatia'),('HTI','North America','Haiti'),('HUN','Europe','Hungary'),('IDN','Asia','Indonesia'),('IMN','Europe','Isle of Man'),('IND','Asia','India'),('IOT','Asia','British Indian Ocean Territory'),('IRL','Europe','Ireland'),('IRN','Asia','Iran, Islamic Republic of'),('IRQ','Asia','Iraq'),('ISL','Europe','Iceland'),('ISR','Asia','Israel'),('ITA','Europe','Italy'),('JAM','North America','Jamaica'),('JEY','Europe','Jersey'),('JOR','Asia','Jordan'),('JPN','Asia','Japan'),('KAZ','Asia','Kazakhstan'),('KEN','Africa','Kenya'),('KGZ','Asia','Kyrgyzstan'),('KHM','Asia','Cambodia'),('KIR','Oceania','Kiribati'),('KNA','North America','Saint Kitts and Nevis'),('KOR','Asia','Korea, Republic of'),('KWT','Asia','Kuwait'),('LAO','Asia','Lao People\'s Democratic Republic'),('LBN','Asia','Lebanon'),('LBR','Africa','Liberia'),('LBY','Africa','Libyan Arab Jamahiriya'),('LCA','North America','Saint Lucia'),('LIE','Europe','Liechtenstein'),('LKA','Asia','Sri Lanka'),('LSO','Africa','Lesotho'),('LTU','Europe','Lithuania'),('LUX','Europe','Luxembourg'),('LVA','Europe','Latvia'),('MAC','Asia','Macao'),('MAF','North America','Saint Martin'),('MAR','Africa','Morocco'),('MCO','Europe','Monaco'),('MDA','Europe','Moldova, Republic of'),('MDG','Africa','Madagascar'),('MDV','Asia','Maldives'),('MEX','North America','Mexico'),('MHL','Oceania','Marshall Islands'),('MKD','Europe','Macedonia, the Former Yugoslav Republic of'),('MLI','Africa','Mali'),('MLT','Europe','Malta'),('MMR','Asia','Myanmar'),('MNE','Europe','Montenegro'),('MNG','Asia','Mongolia'),('MNP','Oceania','Northern Mariana Islands'),('MOZ','Africa','Mozambique'),('MRT','Africa','Mauritania'),('MSR','North America','Montserrat'),('MTQ','North America','Martinique'),('MUS','Africa','Mauritius'),('MWI','Africa','Malawi'),('MYS','Asia','Malaysia'),('MYT','Africa','Mayotte'),('NAM','Africa','Namibia'),('NCL','Oceania','New Caledonia'),('NER','Africa','Niger'),('NFK','Oceania','Norfolk Island'),('NGA','Africa','Nigeria'),('NIC','North America','Nicaragua'),('NIU','Oceania','Niue'),('NLD','Europe','Netherlands'),('NOR','Europe','Norway'),('NPL','Asia','Nepal'),('NRU','Oceania','Nauru'),('NZL','Oceania','New Zealand'),('OMN','Asia','Oman'),('PAK','Asia','Pakistan'),('PAN','North America','Panama'),('PCN','Oceania','Pitcairn'),('PER','South America','Peru'),('PHL','Asia','Philippines'),('PLW','Oceania','Palau'),('PNG','Oceania','Papua New Guinea'),('POL','Europe','Poland'),('PRI','North America','Puerto Rico'),('PRK','Asia','Korea, Democratic People\'s Republic of'),('PRT','Europe','Portugal'),('PRY','South America','Paraguay'),('PSE','Asia','Palestinian Territory, Occupied'),('PYF','Oceania','French Polynesia'),('QAT','Asia','Qatar'),('REU','Africa','Reunion'),('ROM','Europe','Romania'),('RUS','Asia','Russian Federation'),('RWA','Africa','Rwanda'),('SAU','Asia','Saudi Arabia'),('SCG','Europe','Serbia and Montenegro'),('SDN','Africa','Sudan'),('SEN','Africa','Senegal'),('SGP','Asia','Singapore'),('SGS','Antarctica','South Georgia and the South Sandwich Islands'),('SHN','Africa','Saint Helena'),('SJM','Europe','Svalbard and Jan Mayen'),('SLB','Oceania','Solomon Islands'),('SLE','Africa','Sierra Leone'),('SLV','North America','El Salvador'),('SMR','Europe','San Marino'),('SOM','Africa','Somalia'),('SPM','North America','Saint Pierre and Miquelon'),('SRB','Europe','Serbia'),('SSD','Africa','South Sudan'),('STP','Africa','Sao Tome and Principe'),('SUR','South America','Suriname'),('SVK','Europe','Slovakia'),('SVN','Europe','Slovenia'),('SWE','Europe','Sweden'),('SWZ','Africa','Swaziland'),('SXM','North America','St Martin'),('SYC','Africa','Seychelles'),('SYR','Asia','Syrian Arab Republic'),('TCA','North America','Turks and Caicos Islands'),('TCD','Africa','Chad'),('TGO','Africa','Togo'),('THA','Asia','Thailand'),('TJK','Asia','Tajikistan'),('TKL','Oceania','Tokelau'),('TKM','Asia','Turkmenistan'),('TLS','Asia','Timor-Leste'),('TON','Oceania','Tonga'),('TTO','North America','Trinidad and Tobago'),('TUN','Africa','Tunisia'),('TUR','Asia','Turkey'),('TUV','Oceania','Tuvalu'),('TWN','Asia','Taiwan, Province of China'),('TZA','Africa','Tanzania, United Republic of'),('UGA','Africa','Uganda'),('UKR','Europe','Ukraine'),('UMI','North America','United States Minor Outlying Islands'),('URY','South America','Uruguay'),('USA','North America','United States'),('UZB','Asia','Uzbekistan'),('VAT','Europe','Holy See (Vatican City State)'),('VCT','North America','Saint Vincent and the Grenadines'),('VEN','South America','Venezuela'),('VGB','North America','Virgin Islands, British'),('VIR','North America','Virgin Islands, U.s.'),('VNM','Asia','Viet Nam'),('VUT','Oceania','Vanuatu'),('WLF','Oceania','Wallis and Futuna'),('WSM','Oceania','Samoa'),('XKX','Europe','Kosovo'),('YEM','Asia','Yemen'),('ZAF','Africa','South Africa'),('ZMB','Africa','Zambia'),('ZWE','Africa','Zimbabwe');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flag`
--

DROP TABLE IF EXISTS `flag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flag` (
  `url` varchar(1000) NOT NULL,
  `country_code` varchar(3) NOT NULL,
  PRIMARY KEY (`country_code`),
  CONSTRAINT `FK38ryjj6bvp9ncdf2y66x50mch` FOREIGN KEY (`country_code`) REFERENCES `country` (`country_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flag`
--

LOCK TABLES `flag` WRITE;
/*!40000 ALTER TABLE `flag` DISABLE KEYS */;
INSERT INTO `flag` VALUES ('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074942730_file','AGO'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075393823_file','ARG'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075523277_file','ASM'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075528101_file','AUS'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074949410_file','BDI'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074428298_file','BGR'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075399316_file','BOL'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075403273_file','BRA'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074954229_file','BWA'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075212202_file','CAN'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074436418_file','CHE'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075409323_file','CHL'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989642656_file','CHN'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074959492_file','CIV'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074965354_file','CMR'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074971632_file','COD'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074978506_file','COG'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075416042_file','COL'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075217590_file','CUB'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074443375_file','CZE'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074449206_file','DEU'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074984033_file','DZA'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075420604_file','ECU'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074989104_file','EGY'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074456026_file','ESP'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074994302_file','ETH'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074465635_file','FIN'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074470634_file','FRA'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074476060_file','GBR'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074999712_file','GHA'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074480627_file','GRC'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074486574_file','HRV'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989673000_file','IND'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074493845_file','ISL'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074499298_file','ITA'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989678908_file','JPN'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075005807_file','KEN'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989715181_file','KHM'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989725873_file','KOR'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989739139_file','LAO'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075011186_file','MAR'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075017291_file','MDG'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075224289_file','MEX'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989745300_file','MMR'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989751369_file','MNG'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989757290_file','MYS'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074506824_file','NLD'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074512432_file','NOR'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075533263_file','NZL'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075228995_file','PAN'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075425233_file','PER'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989768244_file','PHL'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074518397_file','PRT'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074524618_file','ROM'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989775419_file','RUS'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989781376_file','SGP'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074529608_file','SWE'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989786591_file','THA'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989791856_file','TWN'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075022786_file','UGA'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645074535842_file','UKR'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075234172_file','USA'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1644989797399_file','VNM'),('https://galmuri.s3.ap-northeast-2.amazonaws.com/image/1645075027695_file','ZAF');
/*!40000 ALTER TABLE `flag` ENABLE KEYS */;
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
INSERT INTO `hibernate_sequence` VALUES (21);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `trip_id` bigint NOT NULL,
  `trip_order` int NOT NULL,
  `latitude` float DEFAULT NULL,
  `location` varchar(255) NOT NULL,
  `longitude` float DEFAULT NULL,
  `time` datetime NOT NULL,
  `country_code` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`trip_id`,`trip_order`),
  KEY `FKtktjs5o8pksdfm3o742uc1fy2` (`country_code`),
  CONSTRAINT `FKhk20mlu1gcwrnrxxkj23qhr0n` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`),
  CONSTRAINT `FKtktjs5o8pksdfm3o742uc1fy2` FOREIGN KEY (`country_code`) REFERENCES `country` (`country_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (14,1,0,'뮌헨 대학',0,'2022-02-17 14:42:51','DEU'),(14,2,0,'하이델베르크',0,'2022-02-18 14:42:51','DEU'),(14,3,0,'프랑크푸르트',0,'2022-02-19 14:42:51','DEU'),(14,4,0,'에펠탑',0,'2022-02-20 14:42:51','FRA'),(15,1,0,'올림픽 공원',0,'2022-02-18 14:42:51','JPN'),(15,2,0,'나라 사슴공원',0,'2022-02-19 14:42:51','JPN'),(15,3,0,'도쿄 디즈니랜드',0,'2022-02-19 14:42:51','JPN'),(16,1,0,'피라미드',0,'2022-02-18 15:32:33','EGY'),(16,2,0,'알제리 까라민 시장',0,'2022-02-19 15:32:33','DZA'),(16,3,0,'모로코 국제 공항',0,'2022-02-20 15:32:33','MAR'),(17,1,0,'캘리포니아 롤 본점',0,'2022-02-18 14:42:51','USA'),(17,2,0,'애플 본사',0,'2022-02-19 14:42:51','USA'),(17,3,0,'나이아가라 폭포',0,'2022-02-20 14:42:51','CAN'),(18,1,0,'마다가스카 동물원',0,'2022-02-18 14:42:51','MDG'),(19,1,0,'하랑밸리',0,'2022-02-21 14:42:51','CHL'),(19,2,0,'호주 할매 원조 가리비구이',0,'2022-02-21 14:42:51','AUS'),(20,1,0,'호주 할매 원조 가리비구이',0,'2022-02-21 14:42:51','AUS');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `trip_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `done` bit(1) NOT NULL,
  `end_date` bigint NOT NULL,
  `max_member` int NOT NULL,
  `now_member` int NOT NULL,
  `start_date` bigint NOT NULL,
  `theme` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`trip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (14,'2022-02-17 14:42:42','2022-02-17 14:42:42','술 먹방 둘이서',_binary '',1645681154323,2,1,1645076354323,'맥주','맥주 여행'),(15,'2022-02-17 14:46:34','2022-02-17 14:46:34','먹으러 여행함',_binary '',1645681154323,3,1,1645076354323,'먹방','첫 일본여행 같이가자'),(16,'2022-02-17 14:49:04','2022-02-17 14:49:04','오프로드',_binary '\0',1645681154323,6,1,1645076354323,'오프로드','북아프리카 탐방'),(17,'2022-02-17 14:51:38','2022-02-17 14:51:38','뉴욝, 낫 런던',_binary '\0',1645681154323,2,1,1645076354323,'뉴욕','뉴요커가 되보자'),(18,'2022-02-17 14:55:10','2022-02-17 14:55:10','자연인 환영',_binary '\0',1645681154323,2,1,1645076354323,'자연','낯선 환경, 야생동물'),(19,'2022-02-17 14:57:31','2022-02-17 14:57:31','내가 한국의 메시다',_binary '\0',1645681154323,11,1,1645076354323,'축구','고산에서 축구하기'),(20,'2022-02-17 14:59:38','2022-02-17 14:59:38','',_binary '\0',1645681154323,2,1,1645076354323,'바다','남반구식 여름 즐기기');
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_age_range`
--

DROP TABLE IF EXISTS `trip_age_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip_age_range` (
  `age_range` int NOT NULL,
  `trip_id` bigint NOT NULL,
  PRIMARY KEY (`age_range`,`trip_id`),
  KEY `FKplxtagq6gdux7c1wf4cd9osu6` (`trip_id`),
  CONSTRAINT `FKplxtagq6gdux7c1wf4cd9osu6` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_age_range`
--

LOCK TABLES `trip_age_range` WRITE;
/*!40000 ALTER TABLE `trip_age_range` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip_age_range` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `domain` char(1) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `age` int NOT NULL,
  `facebook` varchar(255) DEFAULT NULL,
  `gender` bit(1) NOT NULL,
  `instagram` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) NOT NULL,
  `total_score` float DEFAULT NULL,
  `total_vote` int DEFAULT NULL,
  `twitter` varchar(255) DEFAULT NULL,
  `country_code` varchar(3) DEFAULT NULL,
  `birth` bigint DEFAULT NULL,
  `comment` text,
  `photo_url` text,
  PRIMARY KEY (`domain`,`user_id`),
  KEY `FKhqr6xcgj31dox7wdv57h7x0ha` (`country_code`),
  CONSTRAINT `FKhqr6xcgj31dox7wdv57h7x0ha` FOREIGN KEY (`country_code`) REFERENCES `country` (`country_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('D','dummy',NULL,'2022-02-17 14:39:23',0,'fb',_binary '\0','insta','nick',0,0,'twit','KOR',NULL,NULL,NULL),('D','kxv1031','2022-02-17 23:30:26','2022-02-17 23:30:26',0,'fb',_binary '\0','insta','nick',0,0,'twit','KOR',NULL,NULL,NULL),('K','kxv1031','2022-02-17 23:30:53','2022-02-17 23:30:53',25,'fb',_binary '','insta','InSeok (CPU는 AMD)',0,0,'twit','KOR',NULL,NULL,'https://k.kakaocdn.net/dn/joiyp/btrsrRuJxid/VbxMvf3NRjA4S24e8MNfP0/img_640x640.jpg'),('K','liqurt','2022-02-17 14:40:25','2022-02-17 14:40:25',29,'string',_binary '','string','string',0,0,'string','KOR',0,'반갑습니다 윤승일입니다','string'),('S','Swagger','2022-02-17 14:41:17','2022-02-17 14:41:17',0,'string',_binary '','string','string',0,0,'string','KOR',0,'','string');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_trip`
--

DROP TABLE IF EXISTS `user_trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_trip` (
  `trip_id` bigint NOT NULL,
  `confirmed` bit(1) NOT NULL,
  `own` bit(1) NOT NULL,
  `domain` char(1) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`trip_id`,`domain`,`user_id`),
  KEY `FKc8qk31ghx9uhjhquuitavm3c6` (`domain`,`user_id`),
  CONSTRAINT `FKc8qk31ghx9uhjhquuitavm3c6` FOREIGN KEY (`domain`, `user_id`) REFERENCES `user` (`domain`, `user_id`),
  CONSTRAINT `FKh2rnctmi0t9t8clnbi64x68yo` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_trip`
--

LOCK TABLES `user_trip` WRITE;
/*!40000 ALTER TABLE `user_trip` DISABLE KEYS */;
INSERT INTO `user_trip` VALUES (14,_binary '',_binary '','S','Swagger'),(15,_binary '',_binary '','S','Swagger'),(16,_binary '',_binary '\0','K','liqurt'),(16,_binary '',_binary '','S','Swagger'),(17,_binary '\0',_binary '\0','K','liqurt'),(19,_binary '',_binary '','K','liqurt');
/*!40000 ALTER TABLE `user_trip` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-18 11:10:04
