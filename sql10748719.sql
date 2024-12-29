-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql10.freemysqlhosting.net
-- Tempo de geração: 07/12/2024 às 16:12
-- Versão do servidor: 5.5.62-0ubuntu0.14.04.1
-- Versão do PHP: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sql10748719`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `idPagamento` int(11) NOT NULL,
  `metodoPagamento` varchar(50) DEFAULT NULL,
  `valorPagamento` decimal(10,2) DEFAULT NULL,
  `dataPagamento` date DEFAULT NULL,
  `statusPagamento` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Fazendo dump de dados para tabela `pagamento`
--

INSERT INTO `pagamento` (`idPagamento`, `metodoPagamento`, `valorPagamento`, `dataPagamento`, `statusPagamento`) VALUES
(1, 'Cartão de Crédito', '350.00', '2024-11-20', 'Aprovado'),
(2, 'Cartão de Crédito', '450.00', '2024-11-21', 'Aprovado'),
(3, 'Cartão de Crédito', '350.00', '2024-11-20', 'Aprovado'),
(4, 'Cartão de Crédito', '450.00', '2024-11-21', 'Aprovado');

-- --------------------------------------------------------

--
-- Estrutura para tabela `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idVoo` int(11) NOT NULL,
  `idPagamento` int(11) DEFAULT NULL,
  `dataReserva` date NOT NULL,
  `assento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Fazendo dump de dados para tabela `reserva`
--

INSERT INTO `reserva` (`idReserva`, `idUsuario`, `idVoo`, `idPagamento`, `dataReserva`, `assento`) VALUES
(19, 9, 1, NULL, '2024-12-07', '10A');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nomeUsuario` varchar(255) NOT NULL,
  `emailUsuario` varchar(255) NOT NULL,
  `senhaUsuario` varchar(255) NOT NULL,
  `cpfUsuario` varchar(14) NOT NULL,
  `telefoneUsuario` varchar(15) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Fazendo dump de dados para tabela `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nomeUsuario`, `emailUsuario`, `senhaUsuario`, `cpfUsuario`, `telefoneUsuario`, `dataNascimento`) VALUES
(2, 'Maria Oliveira', 'maria.oliveira@email.com', 'senha456', '987.654.321-00', '(21) 91234-5678', '1985-07-15'),
(3, 'João Silva', 'joao.silva@email.com', 'senha123', '123.456.789-00', '(11) 98765-4321', '1990-05-10'),
(4, 'Maria Oliveira', 'maria.oliveira@email.com', 'senha456', '987.654.321-00', '(21) 91234-5678', '1985-07-15'),
(5, 'Carlos Andrade', 'carlos.andrade@email.com', 'senha123', '456.789.123-00', '31 99876-5432', '1992-03-20'),
(6, 'Carlos Souza', 'carlos@email.com', '123', '99995664564', '34999990564', '2003-09-28'),
(7, 'Carlos', 'carlos1@email.com', '12345', '123354646', '123135423', '2003-09-28'),
(8, 'Carlos', 'carlos2', '123', '1111111111', '3144444444', '2003-09-28'),
(9, 'Teste', 'teste@email.com', '123', '12109438134', '3199999', '2003-09-28'),
(12, 'Larinha', 'larinha@email.com', 'Larinha123', '1222222222', '31999999999', '2003-12-01'),
(13, 'TesteFinal', 'testefinal@email.com', '123', '12345678955', '91999999925', '2001-12-28');

-- --------------------------------------------------------

--
-- Estrutura para tabela `voo`
--

CREATE TABLE `voo` (
  `idVoo` int(11) NOT NULL,
  `dataVoo` date NOT NULL,
  `horarioVoo` varchar(10) NOT NULL,
  `origem` varchar(100) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `valor` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Fazendo dump de dados para tabela `voo`
--

INSERT INTO `voo` (`idVoo`, `dataVoo`, `horarioVoo`, `origem`, `destino`, `valor`) VALUES
(1, '2024-12-01', '08:30', 'São Paulo', 'Rio de Janeiro', '608.00'),
(2, '2024-12-02', '14:45', 'Belo Horizonte', 'Salvador', '545.04'),
(5, '2024-12-19', '08:00', 'São Paulo', 'Rio de Janeiro', '901.21'),
(6, '2024-12-19', '12:30', 'São Paulo', 'Salvador', '870.94'),
(7, '2024-12-20', '09:15', 'Rio de Janeiro', 'Brasília', '651.07'),
(8, '2024-12-20', '15:45', 'Salvador', 'Recife', '642.53'),
(9, '2024-12-21', '10:00', 'Recife', 'Fortaleza', '759.45'),
(10, '2024-12-21', '17:30', 'Fortaleza', 'Manaus', '869.65'),
(11, '2024-12-22', '11:45', 'Brasília', 'Porto Alegre', '569.88'),
(12, '2024-12-22', '14:00', 'Porto Alegre', 'Curitiba', '740.46'),
(13, '2024-12-23', '07:30', 'Curitiba', 'São Paulo', '992.68'),
(14, '2024-12-23', '13:45', 'Manaus', 'Belém', '742.02'),
(15, '2024-12-24', '09:00', 'Belém', 'São Luís', '732.07'),
(16, '2024-12-24', '11:30', 'São Luís', 'Teresina', '934.28'),
(17, '2024-12-25', '14:15', 'Teresina', 'Natal', '975.17'),
(18, '2024-12-25', '16:45', 'Natal', 'João Pessoa', '573.03'),
(19, '2024-12-26', '18:00', 'João Pessoa', 'Recife', '939.65'),
(20, '2024-12-26', '08:30', 'Recife', 'Maceió', '979.13'),
(21, '2024-12-27', '12:00', 'Maceió', 'Aracaju', '576.71'),
(22, '2024-12-27', '16:30', 'Aracaju', 'Salvador', '946.15'),
(23, '2024-12-28', '07:00', 'Salvador', 'São Paulo', '500.62'),
(24, '2024-12-28', '09:15', 'São Paulo', 'Porto Alegre', '664.64'),
(25, '2024-12-29', '13:45', 'Porto Alegre', 'Rio de Janeiro', '821.35'),
(26, '2024-12-29', '17:30', 'Rio de Janeiro', 'Brasília', '612.84'),
(27, '2024-12-30', '06:00', 'Brasília', 'Fortaleza', '600.14'),
(28, '2024-12-30', '10:45', 'Fortaleza', 'São Paulo', '662.17'),
(29, '2024-12-31', '08:30', 'São Paulo', 'Rio de Janeiro', '510.42'),
(30, '2024-12-31', '12:00', 'Rio de Janeiro', 'Salvador', '565.60'),
(31, '2024-12-31', '15:00', 'Salvador', 'Recife', '796.73'),
(32, '2025-01-01', '09:45', 'Recife', 'Fortaleza', '786.86'),
(33, '2025-01-01', '14:15', 'Fortaleza', 'Manaus', '544.11');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD PRIMARY KEY (`idPagamento`);

--
-- Índices de tabela `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idVoo` (`idVoo`),
  ADD KEY `idPagamento` (`idPagamento`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Índices de tabela `voo`
--
ALTER TABLE `voo`
  ADD PRIMARY KEY (`idVoo`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `pagamento`
--
ALTER TABLE `pagamento`
  MODIFY `idPagamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de tabela `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de tabela `voo`
--
ALTER TABLE `voo`
  MODIFY `idVoo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`idVoo`) REFERENCES `voo` (`idVoo`),
  ADD CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`idPagamento`) REFERENCES `pagamento` (`idPagamento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
