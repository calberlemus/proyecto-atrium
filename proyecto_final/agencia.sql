CREATE DATABASE  IF NOT EXISTS `agencia` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `agencia`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: agencia
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `admincompannia`
--

DROP TABLE IF EXISTS `admincompannia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admincompannia` (
  `ID_ADMIN_COMP` bigint(20) NOT NULL,
  `NUMREGISTRO` bigint(20) DEFAULT NULL,
  `ID_COMPANNIA` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_ADMIN_COMP`),
  KEY `FK3A061E9BD8FF275` (`ID_COMPANNIA`),
  KEY `FK3A061E9B8E1BEE96` (`ID_ADMIN_COMP`),
  CONSTRAINT `FK3A061E9B8E1BEE96` FOREIGN KEY (`ID_ADMIN_COMP`) REFERENCES `usuario` (`ID_USUARIO`),
  CONSTRAINT `FK3A061E9BD8FF275` FOREIGN KEY (`ID_COMPANNIA`) REFERENCES `compannia` (`ID_COMPANNIA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admincompannia`
--

LOCK TABLES `admincompannia` WRITE;
/*!40000 ALTER TABLE `admincompannia` DISABLE KEYS */;
/*!40000 ALTER TABLE `admincompannia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aeropuerto`
--

DROP TABLE IF EXISTS `aeropuerto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aeropuerto` (
  `ID_AEROPUERTO` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODIGO` varchar(255) DEFAULT NULL,
  `CIUDAD` varchar(255) DEFAULT NULL,
  `PAIS` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_AEROPUERTO`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeropuerto`
--

LOCK TABLES `aeropuerto` WRITE;
/*!40000 ALTER TABLE `aeropuerto` DISABLE KEYS */;
INSERT INTO `aeropuerto` VALUES (1,'LCG','A Coruña','España','A Coruña'),(2,'MAD','Madrid','España','Adolfo Suárez'),(3,'ABC','Albacete','España','Albacete'),(4,'AEI','Algeciras','España','Algeciras'),(5,'ALC','Alicante','España','Alicante-Elche'),(6,'LEI','Almería','España','Almería'),(7,'OVD','Asturias','España','Asturias'),(8,'BJZ','Badajoz','España','Badajoz'),(9,'BCN','Barcelona','España','El Prat'),(10,'BIO','Bilbao','España','Bilbao'),(11,'RGS','Burgos','España','Burgos'),(12,'JCU','Ceuta','España','Ceuta'),(13,'ODB','Córdoba','España','Córdoba'),(14,'VDE','El Hierro','España','El Hierro'),(15,'FUE','Fuerteventura','España','Fuerteventura'),(16,'GRO','Girona','España','Costa Brava'),(17,'LPA','Gran Canaria','España','Gran Canaria'),(18,'GRX','Granada','España','Jaén F.G.L.'),(19,'HSK','Huesca','España','Pirineos'),(20,'IBZ','Ibiza','España','Ibiza'),(21,'XRY','Jerez','España','Jerez'),(22,'QGZ','La Gomera','España','La Gomera'),(23,'SPC','La Palma','España','La Palma'),(24,'ACE','Lanzarote','España','Lanzarote'),(25,'LEN','León','España','León'),(26,'RJL','Logroño','España','Agoncillo'),(27,'MCV','Madrid','España','Cuatro Vientos'),(28,'AGP','Málaga','España','Costa del Sol'),(29,'MLN','Melilla','España','Melilla'),(30,'MAH','Menorca','España','Menorca'),(31,'MJV','Murcia','España','San Javier'),(32,'PMI','Palma de Mallorca','España','Palma de Mallorca'),(33,'PNA','Pamplona','España','Pamplona'),(34,'REU','Reus','España','Reus'),(35,'QSA','Sabadell','España','Sabadell'),(36,'SLM','Salamanca','España','Salamanca'),(37,'EAS','San Sebastián','España','San Sebastián'),(38,'SCQ','Santiago','España','Santiago'),(39,'SDR','Santander','España','Seve Ballesteros'),(40,'SVQ','Sevilla','España','Sevilla'),(41,'SBO','Son Bonet','España','Son Bonet'),(42,'TFN','Tenerife','España','Tenerife Norte'),(43,'TFS','Tenerife','España','Tenerife Sur'),(44,'VLC','Valencia','España','Valencia'),(45,'VLL','Valladolid','España','Valladolid'),(46,'VGO','Vigo','España','Vigo'),(47,'VIT','Vitoria','España','Vitoria'),(48,'ZAZ','Zaragoza','España','Zaragoza');
/*!40000 ALTER TABLE `aeropuerto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asiento`
--

DROP TABLE IF EXISTS `asiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asiento` (
  `ID_ASIENTO` bigint(20) NOT NULL AUTO_INCREMENT,
  `NUMERO` int(11) DEFAULT NULL,
  `DISPONIBLE` bit(1) DEFAULT NULL,
  `CLASE` varchar(255) DEFAULT NULL,
  `ID_VUELO` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_ASIENTO`),
  KEY `FK3C87BB3AB47BF3` (`ID_VUELO`),
  CONSTRAINT `FK3C87BB3AB47BF3` FOREIGN KEY (`ID_VUELO`) REFERENCES `vuelo` (`ID_VUELO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asiento`
--

LOCK TABLES `asiento` WRITE;
/*!40000 ALTER TABLE `asiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `asiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `ID_CLIENTE` bigint(20) NOT NULL,
  `NUMCLIENTE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENTE`),
  KEY `FK5E1711DA2BD525C9` (`ID_CLIENTE`),
  CONSTRAINT `FK5E1711DA2BD525C9` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `usuario` (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compannia`
--

DROP TABLE IF EXISTS `compannia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compannia` (
  `ID_COMPANNIA` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODIGO` varchar(255) DEFAULT NULL,
  `PAIS` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_COMPANNIA`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compannia`
--

LOCK TABLES `compannia` WRITE;
/*!40000 ALTER TABLE `compannia` DISABLE KEYS */;
INSERT INTO `compannia` VALUES (1,'AR','Argentina','Aerolíneas Argentinas'),(2,'AU','Argentina','Austral'),(3,'WK','Argentina','American Falcon'),(4,'A4','Argentina','Southern Winds'),(5,'4M','Argentina ','LAN Argentina'),(6,'PU','Uruguay','Pluna'),(7,'LA','Chile','LAN'),(8,'RG','Brasil','Varig'),(9,'JJ','Brasil','TAM'),(10,'G3','Brasil','GOL'),(11,'PZ','Brasil','TAM Mercosur'),(12,'LB','Bolivia','LAB'),(13,'LP','Perú','LAN Perú'),(14,'TA','Perú, Honduras, El Salvador','TACA'),(15,'XL','Ecuador','LAN Ecuador'),(16,'EQ','Ecuador','TAME'),(17,'AV','Colombia','Avianca'),(18,'S3','Venezuela','Santa Bárbara Airlines'),(19,'CM','Panamá','Copa'),(20,'LR','Costa Rica','LACSA'),(21,'AM','México','Aeroméxico'),(22,'MX','México','Mexicana'),(23,'AA','EE.UU','American Airlines'),(24,'UA','EE.UU','United Airlines'),(25,'NW','EE.UU','Northwest Airlines'),(26,'DL','EE.UU','Delta Airlines'),(27,'US','EE.UU','US Airways'),(28,'AC','Canada','Air Canada'),(29,'IB','España','Iberia'),(30,'A7','España','Air Plus Comet'),(31,'UX','España','Air Europa'),(32,'NM','España','Air Madrid'),(33,'AF','Francia','Air France'),(34,'EI','Irlanda','Aer Lingus'),(35,'FR','Irlanda','Ryanair'),(36,'VS','Inglaterra','Virgin Atlantic'),(37,'BA','Inglaterra','British Airways'),(38,'LH','Alemania','Lufthansa'),(39,'LT','Alemania','LTU'),(40,'KL','Holanda','KLM'),(41,'MP','Holanda','Martinair'),(42,'AZ','Italia','Alitalia'),(43,'SN','Bélgica','SN'),(44,'OZ','Austria','Austrian Airlines'),(45,'LX','Suiza','Swiss International Airlines'),(46,'OA','Grecia','Olympic Airways'),(47,'TK','Turquía','Turkish Airlines'),(48,'SK','Suecia, Noruega, Dinamarca','SAS'),(49,'AY','Finlandia','Finnair'),(50,'LO','Polonia','LOT Polish Airlines'),(51,'CZ','República Checa','CSA Czech Airlines'),(52,'SU','Rusia','Aeroflot'),(53,'EK','Emiratos Arábes Unidos','Emirates Airlines'),(54,'AI','India','Air India'),(55,'9W','India','Jet Airways'),(56,'CX','Hong Kong','Cathay Pacific'),(57,'CI','China','China Airlines'),(58,'CZ','China','China Southern'),(59,'SQ','Singapúr','Singapore Airlines'),(60,'MH','Malasia','Malaysia Airlines'),(61,'JL','Japón','JAL'),(62,'QF','Australia','QANTAS'),(63,'NZ','Nueva Zelanda','Air New Zealand'),(64,'SA','Sudáfrica','South African Airways'),(65,'AU','Argentina','Austral'),(66,'WK','Argentina','American Falcon'),(67,'A4','Argentina','Southern Winds'),(68,'4M','Argentina ','LAN Argentina'),(69,'PU','Uruguay','Pluna'),(70,'LA','Chile','LAN'),(71,'RG','Brasil','Varig'),(72,'JJ','Brasil','TAM'),(73,'G3','Brasil','GOL'),(74,'PZ','Brasil','TAM Mercosur'),(75,'LB','Bolivia','LAB'),(76,'LP','Perú','LAN Perú'),(77,'TA','Perú, Honduras, El Salvador','TACA'),(78,'XL','Ecuador','LAN Ecuador'),(79,'EQ','Ecuador','TAME'),(80,'AV','Colombia','Avianca'),(81,'S3','Venezuela','Santa Bárbara Airlines'),(82,'CM','Panamá','Copa'),(83,'LR','Costa Rica','LACSA'),(84,'AM','México','Aeroméxico'),(85,'MX','México','Mexicana'),(86,'AA','EE.UU','American Airlines'),(87,'UA','EE.UU','United Airlines'),(88,'NW','EE.UU','Northwest Airlines'),(89,'DL','EE.UU','Delta Airlines'),(90,'US','EE.UU','US Airways'),(91,'AC','Canada','Air Canada'),(92,'IB','España','Iberia'),(93,'A7','España','Air Plus Comet'),(94,'UX','España','Air Europa'),(95,'NM','España','Air Madrid'),(96,'AF','Francia','Air France'),(97,'EI','Irlanda','Aer Lingus'),(98,'FR','Irlanda','Ryanair'),(99,'VS','Inglaterra','Virgin Atlantic'),(100,'BA','Inglaterra','British Airways'),(101,'LH','Alemania','Lufthansa'),(102,'LT','Alemania','LTU'),(103,'KL','Holanda','KLM'),(104,'MP','Holanda','Martinair'),(105,'AZ','Italia','Alitalia'),(106,'SN','Bélgica','SN'),(107,'OZ','Austria','Austrian Airlines'),(108,'LX','Suiza','Swiss International Airlines'),(109,'OA','Grecia','Olympic Airways'),(110,'TK','Turquía','Turkish Airlines'),(111,'SK','Suecia, Noruega, Dinamarca','SAS'),(112,'AY','Finlandia','Finnair'),(113,'LO','Polonia','LOT Polish Airlines'),(114,'CZ','República Checa','CSA Czech Airlines'),(115,'SU','Rusia','Aeroflot'),(116,'EK','Emiratos Arábes Unidos','Emirates Airlines'),(117,'AI','India','Air India'),(118,'9W','India','Jet Airways'),(119,'CX','Hong Kong','Cathay Pacific'),(120,'CI','China','China Airlines'),(121,'CZ','China','China Southern'),(122,'SQ','Singapúr','Singapore Airlines'),(123,'MH','Malasia','Malaysia Airlines'),(124,'JL','Japón','JAL'),(125,'QF','Australia','QANTAS'),(126,'NZ','Nueva Zelanda','Air New Zealand'),(127,'SA','Sudáfrica','South African Airways');
/*!40000 ALTER TABLE `compannia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta`
--

DROP TABLE IF EXISTS `oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oferta` (
  `ID_OFERTA` bigint(20) NOT NULL AUTO_INCREMENT,
  `PATH` varchar(255) DEFAULT NULL,
  `DESTINO` bigint(20) DEFAULT NULL,
  `CIUDAD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_OFERTA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta`
--

LOCK TABLES `oferta` WRITE;
/*!40000 ALTER TABLE `oferta` DISABLE KEYS */;
/*!40000 ALTER TABLE `oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasajero`
--

DROP TABLE IF EXISTS `pasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasajero` (
  `ID_PASAJERO` bigint(20) NOT NULL,
  `FECHACADDNI` date DEFAULT NULL,
  `ASIENTOIDA` bigint(20) DEFAULT NULL,
  `ASIENTOVUELTA` bigint(20) DEFAULT NULL,
  `TIPO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_PASAJERO`),
  KEY `FK762BF537FA02CB4C` (`ID_PASAJERO`),
  KEY `FK762BF537FAF4CFCE` (`ASIENTOVUELTA`),
  KEY `FK762BF5379389888B` (`ASIENTOIDA`),
  CONSTRAINT `FK762BF5379389888B` FOREIGN KEY (`ASIENTOIDA`) REFERENCES `asiento` (`ID_ASIENTO`),
  CONSTRAINT `FK762BF537FA02CB4C` FOREIGN KEY (`ID_PASAJERO`) REFERENCES `persona` (`ID_PERSONA`),
  CONSTRAINT `FK762BF537FAF4CFCE` FOREIGN KEY (`ASIENTOVUELTA`) REFERENCES `asiento` (`ID_ASIENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasajero`
--

LOCK TABLES `pasajero` WRITE;
/*!40000 ALTER TABLE `pasajero` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `ID_PERSONA` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `APELLIDOS` varchar(255) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `FECHANACIMIENTO` date DEFAULT NULL,
  `CALLE` varchar(255) DEFAULT NULL,
  `NUMERO` varchar(255) DEFAULT NULL,
  `POBLACION` varchar(255) DEFAULT NULL,
  `PROVINCIA` varchar(255) DEFAULT NULL,
  `CP` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_PERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `ID_RESERVA` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_VUELO_IDA` bigint(20) DEFAULT NULL,
  `ID_VUELO_VUELTA` bigint(20) DEFAULT NULL,
  `ID_CLIENTE` bigint(20) DEFAULT NULL,
  `CLASEIDA` varchar(255) DEFAULT NULL,
  `CLASEVUELTA` varchar(255) DEFAULT NULL,
  `PRECIOPERSONA` double DEFAULT NULL,
  `CANCELADA` bit(1) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_RESERVA`),
  KEY `FK6C2F9898E727B73B` (`ID_VUELO_VUELTA`),
  KEY `FK6C2F9898670BB895` (`ID_CLIENTE`),
  KEY `FK6C2F9898B3EA075A` (`ID_VUELO_IDA`),
  CONSTRAINT `FK6C2F9898670BB895` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`),
  CONSTRAINT `FK6C2F9898B3EA075A` FOREIGN KEY (`ID_VUELO_IDA`) REFERENCES `vuelo` (`ID_VUELO`),
  CONSTRAINT `FK6C2F9898E727B73B` FOREIGN KEY (`ID_VUELO_VUELTA`) REFERENCES `vuelo` (`ID_VUELO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva_pasajero`
--

DROP TABLE IF EXISTS `reserva_pasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva_pasajero` (
  `ID_RESERVA` bigint(20) NOT NULL,
  `ID_PASAJERO` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_PASAJERO`,`ID_RESERVA`),
  KEY `FKFB07B8FE9D2CF1ED` (`ID_PASAJERO`),
  KEY `FKFB07B8FE833CC611` (`ID_RESERVA`),
  CONSTRAINT `FKFB07B8FE833CC611` FOREIGN KEY (`ID_RESERVA`) REFERENCES `reserva` (`ID_RESERVA`),
  CONSTRAINT `FKFB07B8FE9D2CF1ED` FOREIGN KEY (`ID_PASAJERO`) REFERENCES `pasajero` (`ID_PASAJERO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva_pasajero`
--

LOCK TABLES `reserva_pasajero` WRITE;
/*!40000 ALTER TABLE `reserva_pasajero` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva_pasajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID_USUARIO` bigint(20) NOT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL,
  `NICK` varchar(255) DEFAULT NULL,
  `PASS` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `ROL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  KEY `FK22E07F0ED0196F7B` (`ID_USUARIO`),
  CONSTRAINT `FK22E07F0ED0196F7B` FOREIGN KEY (`ID_USUARIO`) REFERENCES `persona` (`ID_PERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelo`
--

DROP TABLE IF EXISTS `vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vuelo` (
  `ID_VUELO` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORIGEN_ID` bigint(20) DEFAULT NULL,
  `DESTINO_ID` bigint(20) DEFAULT NULL,
  `DIASALIDA` date DEFAULT NULL,
  `DIALLEGADA` date DEFAULT NULL,
  `HORASALIDA` time DEFAULT NULL,
  `HORALLEGADA` time DEFAULT NULL,
  `CANCELADO` bit(1) DEFAULT NULL,
  `ID_COMPANNIA` bigint(20) DEFAULT NULL,
  `PRECIOOFERTA` double DEFAULT NULL,
  `PRECIOTURISTA` double DEFAULT NULL,
  `PRECIOBUSSINES` double DEFAULT NULL,
  `NUMASIENTOSOFERTA` int(11) DEFAULT NULL,
  `NUMASIENTOSTURISTA` int(11) DEFAULT NULL,
  `NUMASIENTOSBUSSINES` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_VUELO`),
  KEY `FK4E3956941C9BCDB` (`DESTINO_ID`),
  KEY `FK4E39569EE1730F9` (`ORIGEN_ID`),
  KEY `FK4E39569D8FF275` (`ID_COMPANNIA`),
  CONSTRAINT `FK4E3956941C9BCDB` FOREIGN KEY (`DESTINO_ID`) REFERENCES `aeropuerto` (`ID_AEROPUERTO`),
  CONSTRAINT `FK4E39569D8FF275` FOREIGN KEY (`ID_COMPANNIA`) REFERENCES `compannia` (`ID_COMPANNIA`),
  CONSTRAINT `FK4E39569EE1730F9` FOREIGN KEY (`ORIGEN_ID`) REFERENCES `aeropuerto` (`ID_AEROPUERTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelo`
--

LOCK TABLES `vuelo` WRITE;
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-26 21:31:33
