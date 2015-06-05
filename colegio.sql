-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: viti-raspbian.ddns.net    Database: colegio
-- ------------------------------------------------------
-- Server version	5.5.43-0+deb7u1

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnos` (
  `DNI` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Domicilio` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` int(9) NOT NULL,
  `Fecha_nacimiento` date NOT NULL,
  `Faltas` int(2) DEFAULT NULL,
  `Curso` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Observaciones` text COLLATE utf8_unicode_ci,
  `Partes_expulsion` int(2) DEFAULT NULL,
  `Asignaturas` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES ('45688351R','Victor','Gallego Aparicio','C/ Vazquez de mella 10, 3C, 24007 León',652110783,'2006-06-09',3,'4º','Adios',0,'Matemáticas, Lengua, Conocimiento del medio, Inglés, Educación física, Música, Plástica, Lectura/estudio'),('47862530L','Jorge','Frade Martinez','C/ Sancho Ordoñez 12, 5D, 24007 León',658423012,'2003-03-20',15,'6º','Se porta mal',1,'Matemáticas, Lengua, Conocimiento del medio, Inglés, Educación física, Música, Plástica, Lectura/estudio'),('12345678T','Laura','Jiménez García','Avda. Lancia 35, 4A, 24004 León',987168534,'2004-07-30',2,'5º','Acaba de venir de Canadá',NULL,NULL),('12345678A','Juan','Sanchez SQL','Calle numero 8, 1A Leon',987123456,'1994-12-25',0,'2º',NULL,0,'Matemáticas, Lengua, Conocimiento del medio, Inglés, Educación física, Música, Plástica, Lectura/estudio'),('98765432Z','Java','Prueba SQL','Calle Java',987562314,'1994-12-20',0,'1º',NULL,0,'Matemáticas, Lengua, Conocimiento del medio, Inglés, Educación física, Música, Plástica, Lectura/estudio'),('5555555Q','prueba','prueba 2','hola',856321795,'0000-00-00',0,'6º','prueba insercion',NULL,NULL),('55555555Q','prueba','prueba 2','hola',856321795,'1999-12-28',0,'6º','prueba insercion',NULL,NULL),('00000000A','PRUEBA ','SQL REMOTO','prueba 192.168.1.180:3306',987123456,'2003-09-02',4,'1º','Prueba de campo introducido en la bd remota',0,'ninguna'),('99999999A','Pablo','sql','PERRO',111111111,'1992-05-21',3,'3º','Se porta bien',0,'Matemáticas, Lengua, Conocimiento del medio, Inglés, Educación física, Música, Plástica, Lectura/estudio');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hbiblioteca`
--

DROP TABLE IF EXISTS `hbiblioteca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hbiblioteca` (
  `Id` varchar(24) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha` date NOT NULL,
  `Semana` int(1) NOT NULL,
  `Profesor` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hbiblioteca`
--

LOCK TABLES `hbiblioteca` WRITE;
/*!40000 ALTER TABLE `hbiblioteca` DISABLE KEYS */;
INSERT INTO `hbiblioteca` VALUES ('203','2015-02-25',5,'1');
/*!40000 ALTER TABLE `hbiblioteca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notas` (
  `Id` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `Matematicas` int(2) DEFAULT NULL,
  `Lengua` int(2) DEFAULT NULL,
  `Conocimiento_del_medio` int(2) DEFAULT NULL,
  `Ingles` int(2) DEFAULT NULL,
  `Educacion_fisica` int(2) DEFAULT NULL,
  `Musica` int(2) DEFAULT NULL,
  `Plastica` int(2) DEFAULT NULL,
  `Lectura/estudio` int(2) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` VALUES ('45688351R',7,6,10,1,5,7,9,8),('47862530L',4,5,6,1,9,8,7,6);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pexpulsion`
--

DROP TABLE IF EXISTS `pexpulsion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pexpulsion` (
  `Id` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha` date NOT NULL,
  `Motivo` text COLLATE utf8_unicode_ci NOT NULL,
  `Dias_expulsado` int(2) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pexpulsion`
--

LOCK TABLES `pexpulsion` WRITE;
/*!40000 ALTER TABLE `pexpulsion` DISABLE KEYS */;
INSERT INTO `pexpulsion` VALUES ('47862530L','Jorge','Frade Martínez','2015-04-16','Se ha pegado con otro compañero en clase',1),('45688351R','Víctor','Gallego Aparicio','2015-04-16','Se ha pegado con un compañero en clase',1);
/*!40000 ALTER TABLE `pexpulsion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `Usuario` varchar(24) COLLATE utf8_unicode_ci NOT NULL,
  `Contraseña` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `Rol` char(1) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('Jefatura','jefcol','2'),('Secretaria','secrecol','1'),('Profesor01','profe01','3'),('profesor35','hola','3'),('','','3');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-05 18:46:43
