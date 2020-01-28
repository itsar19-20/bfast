-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 28, 2020 alle 17:51
-- Versione del server: 10.1.37-MariaDB
-- Versione PHP: 7.2.12

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
  `IDmeFK` int(8) NOT NULL,
  `IDprFK` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `bar`
--

CREATE TABLE `bar` (
  `ID` int(8) NOT NULL,
  `IDmeFK` int(8) DEFAULT NULL,
  `Nome` varchar(20) NOT NULL,
  `indirizzo` varchar(20) NOT NULL,
  `OrarioApertura` varchar(20) NOT NULL,
  `OrarioChiusura` varchar(20) NOT NULL,
  `Valutazione` float DEFAULT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `Immagine` longblob,
  `Fascia` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `bar`
--

INSERT INTO `bar` (`ID`, `IDmeFK`, `Nome`, `indirizzo`, `OrarioApertura`, `OrarioChiusura`, `Valutazione`, `email`, `password`, `Immagine`, `Fascia`) VALUES
(1, 1, 'Bar pippo', 'via 3', '9:00', '12:00', 3, 'coca@gmail.com', '321', '', 0),
(2, 2, 'Bar rum', 'via 9', '8:00', '20:00', 1, 'cola@gmail.com', '421', '', 0),
(3, 1, 'Bar ciko', 'via cazzate 33', '4:20', '10:00', 0, 'dfagdfg@ssad.com', '333', NULL, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `contiene`
--

CREATE TABLE `contiene` (
  `ID` int(8) NOT NULL,
  `IDprFK` varchar(50) NOT NULL DEFAULT '0',
  `IDorFK` int(8) NOT NULL DEFAULT '0',
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
  `Domanda` varchar(20) DEFAULT '',
  `Mail` varchar(20) NOT NULL DEFAULT '',
  `Valutazione` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `fattorino`
--

INSERT INTO `fattorino` (`ID`, `Nome`, `Cognome`, `Nascità`, `Password`, `Domanda`, `Mail`, `Valutazione`) VALUES
(1, 'Giorgio', 'Nesci', '1998-03-13', '111', '', 'gio@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `indirizzo`
--

CREATE TABLE `indirizzo` (
  `ID` int(8) NOT NULL,
  `PosXUT` double NOT NULL DEFAULT '0',
  `PosYUT` double NOT NULL DEFAULT '0',
  `PosXFA` double NOT NULL DEFAULT '0',
  `PosYFA` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `indirizzo`
--

INSERT INTO `indirizzo` (`ID`, `PosXUT`, `PosYUT`, `PosXFA`, `PosYFA`) VALUES
(1, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `menu`
--

CREATE TABLE `menu` (
  `ID` int(11) NOT NULL,
  `disponibilità` int(11) NOT NULL,
  `Filtro` varchar(50) DEFAULT 'dolce e salato'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `menu`
--

INSERT INTO `menu` (`ID`, `disponibilità`, `Filtro`) VALUES
(1, 7, 'dolce e salato'),
(2, 8, 'dolce e salato');

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

CREATE TABLE `ordine` (
  `ID` int(11) NOT NULL,
  `IDutFK` varchar(20) NOT NULL DEFAULT '',
  `IDfatFK` int(11) DEFAULT NULL,
  `IDbarFK` int(11) DEFAULT NULL,
  `IDtiFK` int(11) DEFAULT NULL,
  `IDinFK` int(11) DEFAULT NULL,
  `Orario` varchar(50) DEFAULT NULL,
  `Note` varchar(200) DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `Confermato` bit(1) DEFAULT b'0',
  `ValutazioneFatt` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `preferiti`
--

CREATE TABLE `preferiti` (
  `ID` int(8) NOT NULL,
  `via` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `civico` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `citta` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `CAP` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotto`
--

CREATE TABLE `prodotto` (
  `Nome` varchar(50) NOT NULL,
  `Ingredienti` varchar(100) NOT NULL DEFAULT '0',
  `Prezzo` float NOT NULL DEFAULT '0',
  `Tipo` varchar(50) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `sceglie`
--

CREATE TABLE `sceglie` (
  `ID` int(8) NOT NULL,
  `IDprFK` int(8) NOT NULL DEFAULT '0',
  `IDutFK` varchar(20) CHARACTER SET latin1 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `tipopagamento`
--

CREATE TABLE `tipopagamento` (
  `ID` int(8) NOT NULL,
  `Tipo` varchar(50) COLLATE latin1_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `tipopagamento`
--

INSERT INTO `tipopagamento` (`ID`, `Tipo`) VALUES
(1, 'Carta di credito'),
(2, 'PayPal'),
(3, 'Contanti');

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `Email` varchar(20) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Nascità` date NOT NULL,
  `Password` varchar(16) NOT NULL,
  `Telefono` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`Email`, `Nome`, `Cognome`, `Nascità`, `Password`, `Telefono`) VALUES
('bubu@gmail.com', 'Guglielmo', 'Strambini', '1999-12-19', '333', 34252432),
('da@gmail.com', 'Daniela', 'De Pascali', '2001-07-03', '464748', 35663535);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `appartiene`
--
ALTER TABLE `appartiene`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDmFK` (`IDmeFK`),
  ADD KEY `IDpr2FK` (`IDprFK`);

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
  ADD KEY `IDprfk` (`IDprFK`);

--
-- Indici per le tabelle `fattorino`
--
ALTER TABLE `fattorino`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `indirizzo`
--
ALTER TABLE `indirizzo`
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
  ADD KEY `IDbarFK` (`IDbarFK`),
  ADD KEY `IDtiFK` (`IDtiFK`),
  ADD KEY `IDinFK` (`IDinFK`);

--
-- Indici per le tabelle `preferiti`
--
ALTER TABLE `preferiti`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`Nome`);

--
-- Indici per le tabelle `sceglie`
--
ALTER TABLE `sceglie`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDprefeFK` (`IDprFK`),
  ADD KEY `IDUtente` (`IDutFK`);

--
-- Indici per le tabelle `tipopagamento`
--
ALTER TABLE `tipopagamento`
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
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `contiene`
--
ALTER TABLE `contiene`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `fattorino`
--
ALTER TABLE `fattorino`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `indirizzo`
--
ALTER TABLE `indirizzo`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `menu`
--
ALTER TABLE `menu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `preferiti`
--
ALTER TABLE `preferiti`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `sceglie`
--
ALTER TABLE `sceglie`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `tipopagamento`
--
ALTER TABLE `tipopagamento`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `appartiene`
--
ALTER TABLE `appartiene`
  ADD CONSTRAINT `IDmFK` FOREIGN KEY (`IDmeFK`) REFERENCES `menu` (`ID`),
  ADD CONSTRAINT `IDpr2FK` FOREIGN KEY (`IDprFK`) REFERENCES `prodotto` (`Nome`);

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
  ADD CONSTRAINT `IDprfk` FOREIGN KEY (`IDprFK`) REFERENCES `prodotto` (`Nome`);

--
-- Limiti per la tabella `ordine`
--
ALTER TABLE `ordine`
  ADD CONSTRAINT `IDbarFK` FOREIGN KEY (`IDbarFK`) REFERENCES `bar` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDfatFK` FOREIGN KEY (`IDfatFK`) REFERENCES `fattorino` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDinFK` FOREIGN KEY (`IDinFK`) REFERENCES `indirizzo` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDtiFK` FOREIGN KEY (`IDtiFK`) REFERENCES `tipopagamento` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDutFK` FOREIGN KEY (`IDutFK`) REFERENCES `utente` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `sceglie`
--
ALTER TABLE `sceglie`
  ADD CONSTRAINT `IDUtente` FOREIGN KEY (`IDutFK`) REFERENCES `utente` (`Email`),
  ADD CONSTRAINT `IDprefeFK` FOREIGN KEY (`IDprFK`) REFERENCES `preferiti` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
