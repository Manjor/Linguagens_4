-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 19-Out-2018 às 14:20
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gcm`
--
CREATE DATABASE IF NOT EXISTS `gcm` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gcm`;

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `pd_novochamado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pd_novochamado` (IN `idcategoria` INT, IN `assunto` VARCHAR(300), IN `descricao` VARCHAR(500), IN `idusuario` INT, IN `idstatus` INT)  BEGIN
	INSERT INTO chamado(idcategoria_fk,assunto,descricao,idusuario_fk,idstatus_fk) VALUES (idcategoria,assunto,descricao,idusuario,idstatus);
END$$

DROP PROCEDURE IF EXISTS `pd_novocontato`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pd_novocontato` (IN `telefone` VARCHAR(20), IN `telefone2` VARCHAR(20), IN `email` VARCHAR(150))  BEGIN
	INSERT INTO contato (telefone,telefonerecado,email) values (telefone,telefone2,email);
END$$

DROP PROCEDURE IF EXISTS `pd_novologin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pd_novologin` (IN `usuario` VARCHAR(150), IN `senha` VARCHAR(200))  BEGIN

	declare idusuario int;
    set idusuario = last_insert_id();
	INSERT INTO login (usuario,senha,idusuario_fk) values (usuario,senha, idusuario);
END$$

DROP PROCEDURE IF EXISTS `pd_novo_usuario`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pd_novo_usuario` (IN `nome` VARCHAR(200), IN `cpf` VARCHAR(15), IN `idlotacao` INT)  BEGIN
	
    declare idcontato int;
    set idcontato = last_insert_id();

    INSERT INTO usuario (nome,cpf,idcontato_fk,idlotacao_fk) values (nome,cpf,idcontato,lotacao);
    
END$$

DROP PROCEDURE IF EXISTS `pd_verLotacoes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pd_verLotacoes` (IN `idug` INT)  BEGIN
	SELECT *FROM lotacao WHERE idunidadegestora_fk = idug;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL,
  `nomecategoria` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`idcategoria`, `nomecategoria`) VALUES
(1, 'requisicao'),
(2, 'incidente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `chamado`
--

DROP TABLE IF EXISTS `chamado`;
CREATE TABLE `chamado` (
  `idchamado` int(11) NOT NULL,
  `idcategoria_fk` int(11) DEFAULT NULL,
  `assunto` varchar(200) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `idusuario_fk` int(11) DEFAULT NULL,
  `idstatus_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `chamado`
--

INSERT INTO `chamado` (`idchamado`, `idcategoria_fk`, `assunto`, `descricao`, `idusuario_fk`, `idstatus_fk`) VALUES
(1, 1, 'Teste', 'Test desc', 2, 1),
(2, 2, 'Teste', 'test desc', 2, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

DROP TABLE IF EXISTS `cidade`;
CREATE TABLE `cidade` (
  `idcidade` int(11) NOT NULL,
  `nomecidade` varchar(150) DEFAULT NULL,
  `idestado_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`idcidade`, `nomecidade`, `idestado_fk`) VALUES
(1, 'PALMAS', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

DROP TABLE IF EXISTS `contato`;
CREATE TABLE `contato` (
  `idcontato` int(11) NOT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `telefonerecado` varchar(30) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `contato`
--

INSERT INTO `contato` (`idcontato`, `telefone`, `telefonerecado`, `email`) VALUES
(1, '6399217', '6398431', 'MANOEL@MANOEL.COM');

-- --------------------------------------------------------

--
-- Estrutura da tabela `enderecounidade`
--

DROP TABLE IF EXISTS `enderecounidade`;
CREATE TABLE `enderecounidade` (
  `idenderecounidade` int(11) NOT NULL,
  `logradouro` varchar(150) DEFAULT NULL,
  `bairro` varchar(150) DEFAULT NULL,
  `cep` varchar(20) DEFAULT NULL,
  `idcidade_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `enderecounidade`
--

INSERT INTO `enderecounidade` (`idenderecounidade`, `logradouro`, `bairro`, `cep`, `idcidade_fk`) VALUES
(1, 'QUADRA 303', 'NORTE', '77000000', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE `estado` (
  `idestado` int(11) NOT NULL,
  `nomeestado` varchar(150) DEFAULT NULL,
  `sigla` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`idestado`, `nomeestado`, `sigla`) VALUES
(1, 'TOCANTINS', 'TO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `idlogin` int(11) NOT NULL,
  `usuario` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `nivelacesso` int(11) DEFAULT '0',
  `ativo` int(11) DEFAULT '0',
  `idusuario_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`idlogin`, `usuario`, `senha`, `nivelacesso`, `ativo`, `idusuario_fk`) VALUES
(2, 'manoel', 'junior', 0, 0, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `lotacao`
--

DROP TABLE IF EXISTS `lotacao`;
CREATE TABLE `lotacao` (
  `idlotacao` int(11) NOT NULL,
  `nomedepartamento` varchar(100) DEFAULT NULL,
  `sigla` varchar(30) DEFAULT NULL,
  `lotacaocol` varchar(45) DEFAULT NULL,
  `idunidadegestora_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `lotacao`
--

INSERT INTO `lotacao` (`idlotacao`, `nomedepartamento`, `sigla`, `lotacaocol`, `idunidadegestora_fk`) VALUES
(1, 'ADMINISTRATIVO', 'ADM', NULL, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `idstatus` int(11) NOT NULL,
  `nomestatus` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `status`
--

INSERT INTO `status` (`idstatus`, `nomestatus`) VALUES
(1, 'aberto'),
(2, 'em atendimento'),
(3, 'encerrado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `unidadegestora`
--

DROP TABLE IF EXISTS `unidadegestora`;
CREATE TABLE `unidadegestora` (
  `idunidadegestora` int(11) NOT NULL,
  `nomeunidade` varchar(100) DEFAULT NULL,
  `siglaunidade` varchar(45) DEFAULT NULL,
  `idenderecounidade_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `unidadegestora`
--

INSERT INTO `unidadegestora` (`idunidadegestora`, `nomeunidade`, `siglaunidade`, `idenderecounidade_fk`) VALUES
(1, 'CATOLICA', 'CA', 1),
(2, 'ULBRA', 'UB', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nome` varchar(250) DEFAULT NULL,
  `cpf` int(11) NOT NULL,
  `idcontato_fk` int(11) DEFAULT NULL,
  `idlotacao_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nome`, `cpf`, `idcontato_fk`, `idlotacao_fk`) VALUES
(2, 'MANOEL', 122411, 1, 1),
(3, NULL, 0, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idcategoria`);

--
-- Indexes for table `chamado`
--
ALTER TABLE `chamado`
  ADD PRIMARY KEY (`idchamado`),
  ADD KEY `categoria_fk_idx` (`idcategoria_fk`),
  ADD KEY `usuario_fk_idx` (`idusuario_fk`),
  ADD KEY `status_fk` (`idstatus_fk`);

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`idcidade`),
  ADD KEY `estado_fk_idx` (`idestado_fk`);

--
-- Indexes for table `contato`
--
ALTER TABLE `contato`
  ADD PRIMARY KEY (`idcontato`);

--
-- Indexes for table `enderecounidade`
--
ALTER TABLE `enderecounidade`
  ADD PRIMARY KEY (`idenderecounidade`),
  ADD KEY `cidade_fk_idx` (`idcidade_fk`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idestado`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idlogin`),
  ADD KEY `user_fk` (`idusuario_fk`);

--
-- Indexes for table `lotacao`
--
ALTER TABLE `lotacao`
  ADD PRIMARY KEY (`idlotacao`),
  ADD KEY `unidadegestora_fk_idx` (`idunidadegestora_fk`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`idstatus`);

--
-- Indexes for table `unidadegestora`
--
ALTER TABLE `unidadegestora`
  ADD PRIMARY KEY (`idunidadegestora`),
  ADD KEY `endereco_fk_idx` (`idenderecounidade_fk`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  ADD KEY `idcontato_fk_idx` (`idcontato_fk`),
  ADD KEY `idlotacao_fk_idx` (`idusuario`,`idlotacao_fk`),
  ADD KEY `contato_fk_idx` (`idcontato_fk`),
  ADD KEY `lotacao_fk_idx` (`idlotacao_fk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idcategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `chamado`
--
ALTER TABLE `chamado`
  MODIFY `idchamado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `idcidade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `contato`
--
ALTER TABLE `contato`
  MODIFY `idcontato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `enderecounidade`
--
ALTER TABLE `enderecounidade`
  MODIFY `idenderecounidade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `estado`
--
ALTER TABLE `estado`
  MODIFY `idestado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `idlogin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `lotacao`
--
ALTER TABLE `lotacao`
  MODIFY `idlotacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `idstatus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `unidadegestora`
--
ALTER TABLE `unidadegestora`
  MODIFY `idunidadegestora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `chamado`
--
ALTER TABLE `chamado`
  ADD CONSTRAINT `categoria_fk` FOREIGN KEY (`idcategoria_fk`) REFERENCES `categoria` (`idcategoria`),
  ADD CONSTRAINT `status_fk` FOREIGN KEY (`idstatus_fk`) REFERENCES `status` (`idstatus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuario_fk` FOREIGN KEY (`idusuario_fk`) REFERENCES `usuario` (`idusuario`);

--
-- Limitadores para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `estado_fk` FOREIGN KEY (`idestado_fk`) REFERENCES `estado` (`idestado`);

--
-- Limitadores para a tabela `enderecounidade`
--
ALTER TABLE `enderecounidade`
  ADD CONSTRAINT `cidade_fk` FOREIGN KEY (`idcidade_fk`) REFERENCES `cidade` (`idcidade`);

--
-- Limitadores para a tabela `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `user_fk` FOREIGN KEY (`idusuario_fk`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `lotacao`
--
ALTER TABLE `lotacao`
  ADD CONSTRAINT `unidadegestora_fk` FOREIGN KEY (`idunidadegestora_fk`) REFERENCES `unidadegestora` (`idunidadegestora`);

--
-- Limitadores para a tabela `unidadegestora`
--
ALTER TABLE `unidadegestora`
  ADD CONSTRAINT `endereco_fk` FOREIGN KEY (`idenderecounidade_fk`) REFERENCES `enderecounidade` (`idenderecounidade`);

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `contato_fk` FOREIGN KEY (`idcontato_fk`) REFERENCES `contato` (`idcontato`),
  ADD CONSTRAINT `lotacao_fk` FOREIGN KEY (`idlotacao_fk`) REFERENCES `lotacao` (`idlotacao`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
