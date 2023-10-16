CREATE DATABASE  IF NOT EXISTS `internpro` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `internpro`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: internpro
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `matricula` varchar(11) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `nome_aluno` varchar(100) NOT NULL,
  `email_aluno` varchar(45) NOT NULL,
  `fone_aluno` varchar(11) NOT NULL,
  `curriculo` varchar(45) NOT NULL,
  `cod_coordenador` varchar(11) NOT NULL,
  `cod_prof` varchar(11) NOT NULL,
  `cod_curso` varchar(11) NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `fk_aluno_coordenador_idx` (`cod_coordenador`),
  KEY `fk_aluno_prof_orientador_idx` (`cod_prof`),
  KEY `fk_aluno_curso_idx` (`cod_curso`),
  CONSTRAINT `fk_aluno_coordenador` FOREIGN KEY (`cod_coordenador`) REFERENCES `coordenador` (`cod_coordenador`),
  CONSTRAINT `fk_aluno_curso` FOREIGN KEY (`cod_curso`) REFERENCES `curso` (`cod_curso`),
  CONSTRAINT `fk_aluno_prof_orientador` FOREIGN KEY (`cod_prof`) REFERENCES `prof_orientador` (`cod_prof`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordenador`
--

DROP TABLE IF EXISTS `coordenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coordenador` (
  `cod_coordenador` varchar(11) NOT NULL,
  `nome_coordenador` varchar(100) NOT NULL,
  `email_coordenador` varchar(45) NOT NULL,
  `fone_coordenador` varchar(11) NOT NULL,
  PRIMARY KEY (`cod_coordenador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenador`
--

LOCK TABLES `coordenador` WRITE;
/*!40000 ALTER TABLE `coordenador` DISABLE KEYS */;
/*!40000 ALTER TABLE `coordenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `cod_curso` varchar(11) NOT NULL,
  `sigla` varchar(4) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documento` (
  `cod_doc` varchar(11) NOT NULL,
  `data_doc` datetime NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `cod_emp` int NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(14) NOT NULL,
  `nome_emp` varchar(100) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `fone_emp` varchar(11) NOT NULL,
  PRIMARY KEY (`cod_emp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscricao`
--

DROP TABLE IF EXISTS `inscricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscricao` (
  `num_inscricao` int NOT NULL AUTO_INCREMENT,
  `cod_vaga` varchar(11) NOT NULL,
  `matricula` varchar(11) NOT NULL,
  `cod_doc` varchar(11) NOT NULL,
  PRIMARY KEY (`num_inscricao`),
  KEY `fk_inscricao_vaga_idx` (`cod_vaga`),
  KEY `fk_inscricao_aluno_idx` (`matricula`),
  KEY `fk_inscricao_documento_idx` (`cod_doc`),
  CONSTRAINT `fk_inscricao_aluno` FOREIGN KEY (`matricula`) REFERENCES `aluno` (`matricula`),
  CONSTRAINT `fk_inscricao_documento` FOREIGN KEY (`cod_doc`) REFERENCES `documento` (`cod_doc`),
  CONSTRAINT `fk_inscricao_vaga` FOREIGN KEY (`cod_vaga`) REFERENCES `vaga` (`cod_vaga`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscricao`
--

LOCK TABLES `inscricao` WRITE;
/*!40000 ALTER TABLE `inscricao` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prof_orientador`
--

DROP TABLE IF EXISTS `prof_orientador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prof_orientador` (
  `cod_prof` varchar(11) NOT NULL,
  `nome_prof` varchar(100) NOT NULL,
  `email_prof` varchar(45) NOT NULL,
  `fone_prof` varchar(11) NOT NULL,
  `lattes` varchar(45) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  PRIMARY KEY (`cod_prof`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prof_orientador`
--

LOCK TABLES `prof_orientador` WRITE;
/*!40000 ALTER TABLE `prof_orientador` DISABLE KEYS */;
/*!40000 ALTER TABLE `prof_orientador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaga`
--

DROP TABLE IF EXISTS `vaga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaga` (
  `cod_vaga` varchar(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `gerente` varchar(45) NOT NULL,
  `qtde_vaga` int NOT NULL,
  `nome_vaga` varchar(45) NOT NULL,
  `cod_emp` int NOT NULL,
  PRIMARY KEY (`cod_vaga`),
  KEY `fk_vaga_empresa_idx` (`cod_emp`),
  CONSTRAINT `fk_vaga_empresa` FOREIGN KEY (`cod_emp`) REFERENCES `empresa` (`cod_emp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaga`
--

LOCK TABLES `vaga` WRITE;
/*!40000 ALTER TABLE `vaga` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'internpro'
--

--
-- Dumping routines for database 'internpro'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-02 18:37:38
