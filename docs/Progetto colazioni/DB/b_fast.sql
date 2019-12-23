-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 23, 2019 alle 16:57
-- Versione del server: 10.1.36-MariaDB
-- Versione PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `b.fast`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `appartiene`
--

CREATE TABLE `appartiene` (
  `ID` int(8) NOT NULL,
  `IDprFK` int(8) NOT NULL,
  `IDmeFK` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `bar`
--

CREATE TABLE `bar` (
  `ID` int(8) NOT NULL,
  `IDmeFK` int(8) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `OrarioApertura` varchar(20) NOT NULL,
  `OrarioChiusura` varchar(20) NOT NULL,
  `Valutazione` float NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `Immagine` longblob NOT NULL,
  `Fascia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `contiene`
--

CREATE TABLE `contiene` (
  `ID` int(8) NOT NULL,
  `IDorFK` int(8) NOT NULL DEFAULT '0',
  `IDprFK` int(8) NOT NULL DEFAULT '0',
  `Quantita` int(5) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `fattorino`
--

CREATE TABLE `fattorino` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Nascità` date NOT NULL,
  `Password` varchar(20) NOT NULL DEFAULT '',
  `Domanda` varchar(20) NOT NULL DEFAULT '',
  `Mail` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `menu`
--

CREATE TABLE `menu` (
  `ID` int(11) NOT NULL,
  `disponibilità` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

CREATE TABLE `ordine` (
  `ID` int(11) NOT NULL,
  `IDutFK` varchar(20) NOT NULL DEFAULT '',
  `IDfatFK` int(11) NOT NULL,
  `IDbarFK` int(11) NOT NULL,
  `Orario` date NOT NULL,
  `Note` varchar(200) NOT NULL,
  `Data` date NOT NULL,
  `TipoPagamento` enum('Carta di credito','PayPal','A domicilio') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotto`
--

CREATE TABLE `prodotto` (
  `ID` int(11) NOT NULL,
  `Ingredienti` varchar(100) NOT NULL DEFAULT '0',
  `Prezzo` float NOT NULL DEFAULT '0',
  `Tipo` varchar(50) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `Email` varchar(20) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Nascità` date NOT NULL,
  `Password` varchar(50) NOT NULL DEFAULT '',
  `Telefono` int(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `appartiene`
--
ALTER TABLE `appartiene`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDprFK` (`IDprFK`),
  ADD KEY `IDmFK` (`IDmeFK`);

--
-- Indici per le tabelle `bar`
--
ALTER TABLE `bar`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDmeFK` (`IDmeFK`);

--
-- Indici per le tabelle `contiene`
--
ALTER TABLE `contiene`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDorFK` (`IDorFK`),
  ADD KEY `IDpFK` (`IDprFK`);

--
-- Indici per le tabelle `fattorino`
--
ALTER TABLE `fattorino`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `ordine`
--
ALTER TABLE `ordine`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDutFK` (`IDutFK`),
  ADD KEY `IDfatFK` (`IDfatFK`),
  ADD KEY `IDbarFK` (`IDbarFK`);

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`Email`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `appartiene`
--
ALTER TABLE `appartiene`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `bar`
--
ALTER TABLE `bar`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `contiene`
--
ALTER TABLE `contiene`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `fattorino`
--
ALTER TABLE `fattorino`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `menu`
--
ALTER TABLE `menu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `prodotto`
--
ALTER TABLE `prodotto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `appartiene`
--
ALTER TABLE `appartiene`
  ADD CONSTRAINT `IDmFK` FOREIGN KEY (`IDmeFK`) REFERENCES `menu` (`ID`),
  ADD CONSTRAINT `IDprFK` FOREIGN KEY (`IDprFK`) REFERENCES `prodotto` (`ID`);

--
-- Limiti per la tabella `bar`
--
ALTER TABLE `bar`
  ADD CONSTRAINT `IDmeFK` FOREIGN KEY (`IDmeFK`) REFERENCES `menu` (`ID`);

--
-- Limiti per la tabella `contiene`
--
ALTER TABLE `contiene`
  ADD CONSTRAINT `IDorFK` FOREIGN KEY (`IDorFK`) REFERENCES `ordine` (`ID`),
  ADD CONSTRAINT `IDpFK` FOREIGN KEY (`IDprFK`) REFERENCES `prodotto` (`ID`);

--
-- Limiti per la tabella `ordine`
--
ALTER TABLE `ordine`
  ADD CONSTRAINT `IDbarFK` FOREIGN KEY (`IDbarFK`) REFERENCES `bar` (`ID`),
  ADD CONSTRAINT `IDfatFK` FOREIGN KEY (`IDfatFK`) REFERENCES `fattorino` (`ID`),
  ADD CONSTRAINT `IDutFK` FOREIGN KEY (`IDutFK`) REFERENCES `utente` (`Email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
