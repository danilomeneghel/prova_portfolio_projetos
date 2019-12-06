-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 06-Dez-2019 às 04:04
-- Versão do servidor: 5.7.24
-- versão do PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prova_portfolio_projetos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `membros`
--

DROP TABLE IF EXISTS `membros`;
CREATE TABLE IF NOT EXISTS `membros` (
  `idprojeto` int(20) NOT NULL,
  `idpessoa` int(20) NOT NULL,
  PRIMARY KEY (`idprojeto`),
  KEY `fk_pessoa` (`idpessoa`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE latin1_bin NOT NULL,
  `datanascimento` date DEFAULT NULL,
  `cpf` varchar(14) COLLATE latin1_bin DEFAULT NULL,
  `funcionario` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `nome`, `datanascimento`, `cpf`, `funcionario`) VALUES
(1, 'Joao', '1981-01-01', '234234234234', 1),
(2, 'Pedro', '1985-02-02', '123123123', 0),
(3, 'Bruna', '1985-03-05', '12312312312', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto`
--

DROP TABLE IF EXISTS `projeto`;
CREATE TABLE IF NOT EXISTS `projeto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) COLLATE latin1_bin NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_previsao_fim` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `descricao` varchar(500) COLLATE latin1_bin DEFAULT NULL,
  `status` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `orcamento` float DEFAULT NULL,
  `risco` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `idgerente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_gerente` (`idgerente`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Extraindo dados da tabela `projeto`
--

INSERT INTO `projeto` (`id`, `nome`, `data_inicio`, `data_previsao_fim`, `data_fim`, `descricao`, `status`, `orcamento`, `risco`, `idgerente`) VALUES
(3, 'Projeto A', '2019-12-01', '2020-01-31', '2020-02-01', 'qweadadasd', 'Em Análise', 50000, 'Baixo Risco', NULL),
(4, 'Projeto B', '2019-11-20', '2020-03-01', '2020-03-15', 'qweqwewe', 'Em Andamento', 60000, 'Médio Risco', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `address`, `username`, `password`) VALUES
(1, 'Administrador', 'admin@admin.com', '', 'admin', '$2a$10$Bwj6eF82hchzbOnLBg7DSeDaZCwAGTSrhBSZHSYFxPKxxvWo41pOa'),
(14, 'User', 'user@user.com', '', 'user', '$2a$10$5jW1osLYOU.Dlhjh9n.JBOEXBKZFKk3t9yB0eUTuBas9OL/LkRsdm'),
(15, 'Sandra', 'sandra@aaa.com', 'asdasdasd', 'sandra', '$2a$10$Joa0QZO.U1R6h.gbtd9rZOIfA27v5GOBhLJV46N/CKoHiU0yeDwDa'),
(16, 'Helena', 'helena@aaaaaa.com', 'asdasasd', 'helena', '$2a$10$OvBY/HcfMmvMdk68F/TH0evD8llh5rigDMKUqZcvVOw.fTXXrJrZu'),
(17, 'José da Silva', 'jose@silva.com', 'wwwwwwwww', 'jose', '$2a$10$FZLF.BcsKfMdWRvHl2ZHLObToWj8vOZ.4v9X8u9LocmC3H7jCN3Xy'),
(18, 'Mariana', 'mariana@mmmmm.com', 'asdasdasdasd', 'mariana', '$2a$10$CWn4Zo/J2AXfQ2TsBK4Lm.OTm0Q7TAE4McZn/mEsE91gY17qWyQCG'),
(19, 'Larissa', 'larissa@aaaaa.com', 'asdasdasd', 'larissa', '$2a$10$rBc1FbGtHyWuq7n7y2o20euyCkaoQyrXWIEvle8Qxgg3Eb0DqYN8u'),
(20, 'teste2', 'teste@teste.com', 'eeeeeeeeeeeee', 'teste', '$2a$10$oDEY3DA9KRmw4en3qL0l5eGomhCRygAIj997gf7P3OliRInyAtNtS');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT '',
  `role` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `user_roles`
--

INSERT INTO `user_roles` (`id`, `username`, `role`) VALUES
(1, 'admin', 'ROLE_ADMIN'),
(4, 'user', 'ROLE_USER'),
(5, 'sandra', 'ROLE_USER'),
(6, 'helena', 'ROLE_USER'),
(7, 'jose', 'ROLE_USER'),
(8, 'mariana', 'ROLE_USER'),
(9, 'larissa', 'ROLE_USER'),
(10, 'andresaa', 'ROLE_USER'),
(11, 'teste', 'ROLE_USER');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
