CREATE DATABASE  IF NOT EXISTS `db_modoaviao_a3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_modoaviao_a3`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: db_modoaviao_a3
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamento` (
  `idPagamento` int NOT NULL AUTO_INCREMENT,
  `metodoPagamento` varchar(50) DEFAULT NULL,
  `valorPagamento` decimal(10,2) DEFAULT NULL,
  `dataPagamento` date DEFAULT NULL,
  `statusPagamento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idPagamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (1,'Cartão de Crédito',350.00,'2024-11-20','Aprovado'),(2,'Cartão de Crédito',450.00,'2024-11-21','Aprovado'),(3,'Cartão de Crédito',350.00,'2024-11-20','Aprovado'),(4,'Cartão de Crédito',450.00,'2024-11-21','Aprovado');
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `idReserva` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `idVoo` int NOT NULL,
  `idPagamento` int DEFAULT NULL,
  `statusReserva` varchar(50) DEFAULT NULL,
  `dataReserva` date NOT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `idUsuario` (`idUsuario`),
  KEY `idVoo` (`idVoo`),
  KEY `idPagamento` (`idPagamento`),
  CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`idVoo`) REFERENCES `voo` (`idVoo`),
  CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`idPagamento`) REFERENCES `pagamento` (`idPagamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,1,1,1,'Confirmada','2024-11-20'),(2,2,2,2,'Pendente','2024-11-21'),(3,1,1,1,'Confirmada','2024-11-20'),(4,2,2,2,'Pendente','2024-11-21');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nomeUsuario` varchar(255) NOT NULL,
  `emailUsuario` varchar(255) NOT NULL,
  `senhaUsuario` varchar(255) NOT NULL,
  `enderecoUsuario` varchar(255) DEFAULT NULL,
  `cpfUsuario` varchar(14) NOT NULL,
  `telefoneUsuario` varchar(15) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'João Silva','joao.silva@email.com','senha123','Rua das Flores, 123','123.456.789-00','(11) 98765-4321','1990-05-10'),(2,'Maria Oliveira','maria.oliveira@email.com','senha456','Av. Brasil, 456','987.654.321-00','(21) 91234-5678','1985-07-15'),(3,'João Silva','joao.silva@email.com','senha123','Rua das Flores, 123','123.456.789-00','(11) 98765-4321','1990-05-10'),(4,'Maria Oliveira','maria.oliveira@email.com','senha456','Av. Brasil, 456','987.654.321-00','(21) 91234-5678','1985-07-15'),(5,'Carlos Andrade','carlos.andrade@email.com','senha123',NULL,'456.789.123-00','31 99876-5432','1992-03-20'),(6,'Carlos Souza','carlos@email.com','123',NULL,'99995664564','34999990564','2003-09-28'),(7,'Carlos','carlos1@email.com','12345',NULL,'123354646','123135423','2003-09-28'),(8,'Carlos','carlos2','123',NULL,'1111111111','3144444444','2003-09-28');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voo`
--

DROP TABLE IF EXISTS `voo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voo` (
  `idVoo` int NOT NULL AUTO_INCREMENT,
  `dataVoo` date NOT NULL,
  `horarioVoo` varchar(10) NOT NULL,
  `origem` varchar(100) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `companhiaAerea` varchar(100) DEFAULT NULL,
  `assento` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idVoo`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voo`
--

LOCK TABLES `voo` WRITE;
/*!40000 ALTER TABLE `voo` DISABLE KEYS */;
INSERT INTO `voo` VALUES (1,'2024-12-01','08:30','São Paulo','Rio de Janeiro','Gol Linhas Aéreas','12A'),(2,'2024-12-02','14:45','Belo Horizonte','Salvador','Latam Airlines','15C'),(3,'2024-12-01','08:30','São Paulo','Rio de Janeiro','Gol Linhas Aéreas','12A'),(4,'2024-12-02','14:45','Belo Horizonte','Salvador','Latam Airlines','15C'),(5,'2024-12-19','08:00','São Paulo','Rio de Janeiro',NULL,NULL),(6,'2024-12-19','12:30','São Paulo','Salvador',NULL,NULL),(7,'2024-12-20','09:15','Rio de Janeiro','Brasília',NULL,NULL),(8,'2024-12-20','15:45','Salvador','Recife',NULL,NULL),(9,'2024-12-21','10:00','Recife','Fortaleza',NULL,NULL),(10,'2024-12-21','17:30','Fortaleza','Manaus',NULL,NULL),(11,'2024-12-22','11:45','Brasília','Porto Alegre',NULL,NULL),(12,'2024-12-22','14:00','Porto Alegre','Curitiba',NULL,NULL),(13,'2024-12-23','07:30','Curitiba','São Paulo',NULL,NULL),(14,'2024-12-23','13:45','Manaus','Belém',NULL,NULL),(15,'2024-12-24','09:00','Belém','São Luís',NULL,NULL),(16,'2024-12-24','11:30','São Luís','Teresina',NULL,NULL),(17,'2024-12-25','14:15','Teresina','Natal',NULL,NULL),(18,'2024-12-25','16:45','Natal','João Pessoa',NULL,NULL),(19,'2024-12-26','18:00','João Pessoa','Recife',NULL,NULL),(20,'2024-12-26','08:30','Recife','Maceió',NULL,NULL),(21,'2024-12-27','12:00','Maceió','Aracaju',NULL,NULL),(22,'2024-12-27','16:30','Aracaju','Salvador',NULL,NULL),(23,'2024-12-28','07:00','Salvador','São Paulo',NULL,NULL),(24,'2024-12-28','09:15','São Paulo','Porto Alegre',NULL,NULL),(25,'2024-12-29','13:45','Porto Alegre','Rio de Janeiro',NULL,NULL),(26,'2024-12-29','17:30','Rio de Janeiro','Brasília',NULL,NULL),(27,'2024-12-30','06:00','Brasília','Fortaleza',NULL,NULL),(28,'2024-12-30','10:45','Fortaleza','São Paulo',NULL,NULL),(29,'2024-12-31','08:30','São Paulo','Rio de Janeiro',NULL,NULL),(30,'2024-12-31','12:00','Rio de Janeiro','Salvador',NULL,NULL),(31,'2024-12-31','15:00','Salvador','Recife',NULL,NULL),(32,'2025-01-01','09:45','Recife','Fortaleza',NULL,NULL),(33,'2025-01-01','14:15','Fortaleza','Manaus',NULL,NULL);
/*!40000 ALTER TABLE `voo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-29 18:17:16
