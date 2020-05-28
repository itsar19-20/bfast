-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 28, 2020 alle 10:23
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
-- Database: `b_fast`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `bar`
--

CREATE TABLE `bar` (
  `ID` int(8) NOT NULL,
  `IDinFK` int(8) DEFAULT NULL,
  `Nome` varchar(20) NOT NULL,
  `OrarioApertura` varchar(20) DEFAULT NULL,
  `OrarioChiusura` varchar(20) DEFAULT NULL,
  `Valutazione` float DEFAULT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `Fascia` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `bar`
--

INSERT INTO `bar` (`ID`, `IDinFK`, `Nome`, `OrarioApertura`, `OrarioChiusura`, `Valutazione`, `email`, `password`, `Fascia`) VALUES
(1, 1, 'Bar pippo', '5', '13', 3, 'prova@gmail.com', '333', 0),
(2, 10, 'Bar rum', '', '', 1, 'ciao@yt.it', '123', 0),
(3, 2, 'Bar ciko', '', '', 0, 'dfagdfg@ssad.com', '333', 0),
(4, 9, 'Bar Uno', '', '', 5, 'baruno@gmail.com', '123', 0),
(5, 8, 'Bar Due', '', '', 2.5, 'bardue@blabla.it', '456', 0),
(6, 4, 'Bar Tre', '', '', 3.6, 'bartre@sdfgh.it', '789', 0),
(7, 6, 'Bar Quattro', '', '', 4, 'barquattro@opop.it', '852', 0),
(8, 7, 'Bar Cinque', '', '', 4.5, 'barcinque@asd.com', '147', 0),
(9, 3, 'Bar Sei', '', '', 5, 'barsei@fgh.com', '654', 0),
(10, 1, 'Bar Sette', '', '', 3.7, 'barsette@yh.com', '321', 0),
(31, 17, 'Bar prova', NULL, NULL, 0, 'prova@gmail.com', '333', 0),
(32, 20, 'Bar prova', NULL, NULL, 0, 'prova@gmail.com', '333', 0),
(33, 18, 'Bar ciko', NULL, NULL, 0, 'dfagdfg@ssad.com', '232', 0),
(34, 21, 'prova', NULL, NULL, 0, 'nonna@diaz.com', '333', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `chiedef`
--

CREATE TABLE `chiedef` (
  `ID` int(8) NOT NULL,
  `IDfatFK` int(8) NOT NULL DEFAULT '0',
  `IDdoFK` int(8) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `chiedef`
--

INSERT INTO `chiedef` (`ID`, `IDfatFK`, `IDdoFK`) VALUES
(1, 1, 2),
(2, 7, 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `chiedeu`
--

CREATE TABLE `chiedeu` (
  `ID` int(8) NOT NULL,
  `IDdoFK` int(8) NOT NULL DEFAULT '0',
  `IDutFK` varchar(20) CHARACTER SET latin1 NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `chiedeu`
--

INSERT INTO `chiedeu` (`ID`, `IDdoFK`, `IDutFK`) VALUES
(1, 1, 'cri@gmai.com');

-- --------------------------------------------------------

--
-- Struttura della tabella `classificato`
--

CREATE TABLE `classificato` (
  `ID` int(8) NOT NULL,
  `IDbaFK` int(8) DEFAULT NULL,
  `IDfiFK` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `classificato`
--

INSERT INTO `classificato` (`ID`, `IDbaFK`, `IDfiFK`) VALUES
(1, 8, 2),
(2, 1, 3),
(3, 8, 1);

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

--
-- Dump dei dati per la tabella `contiene`
--

INSERT INTO `contiene` (`ID`, `IDprFK`, `IDorFK`, `Quantita`) VALUES
(1, 'caffe', 1, 1),
(2, 'brioche', 1, 1),
(3, 'cheesecake', 2, 4),
(4, 'pancetta', 2, 2),
(5, 'succo di arancia', 2, 2),
(6, 'croissant', 30, 2),
(22, 'caffe', 30, 2),
(24, 'croissant', 31, 3),
(25, 'torta al cioccolato', 34, 2),
(26, 'cheesecake', 34, 1),
(27, 'croissant', 36, 2),
(28, 'succo di arancia', 36, 2),
(31, 'croissant', 56, 2),
(32, 'torta al cioccolato', 57, 2),
(33, 'cheesecake', 58, 2),
(34, 'torta al cioccolato', 59, 2),
(35, 'cheesecake', 59, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `domanda`
--

CREATE TABLE `domanda` (
  `ID` int(8) NOT NULL,
  `domanda` varchar(50) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `domanda`
--

INSERT INTO `domanda` (`ID`, `domanda`) VALUES
(1, 'Come effettuare l\'ordine?'),
(2, 'Come effettuare il pagamento?'),
(3, 'Come contattare il fattorino?');

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
  `Mail` varchar(20) NOT NULL DEFAULT '',
  `Valutazione` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `fattorino`
--

INSERT INTO `fattorino` (`ID`, `Nome`, `Cognome`, `Nascità`, `Password`, `Mail`, `Valutazione`) VALUES
(1, 'Giorgio', 'Nesci', '1998-03-13', '111', 'gio@gmail.com', NULL),
(2, 'Ither', 'Khaza', '2000-02-04', '333', 'eater@gnam.it', NULL),
(3, 'Paolo', 'Rossi', '1989-05-30', '656', 'cicciogamer@panino.i', NULL),
(4, 'Samuele', 'Sabatini', '2000-08-21', '121', 'rossosaba@alice.it', NULL),
(5, 'Alberto', 'Sormani', '1995-08-01', '888', 'albi@calcetto.it', NULL),
(6, 'Mirko ', 'Rondi', '1997-02-03', 'ferrari16', 'leclerc@gmail.it', NULL),
(7, 'Alessandro', 'Gasparini', '1999-09-06', '420', 'kilog@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `filtro`
--

CREATE TABLE `filtro` (
  `ID` int(8) NOT NULL,
  `Tipo` varchar(50) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `filtro`
--

INSERT INTO `filtro` (`ID`, `Tipo`) VALUES
(1, 'Salato'),
(2, 'Dolce'),
(3, 'Cocktail'),
(4, 'Tabacchino');

-- --------------------------------------------------------

--
-- Struttura della tabella `indirizzo`
--

CREATE TABLE `indirizzo` (
  `ID` int(8) NOT NULL,
  `x` double NOT NULL DEFAULT '0',
  `y` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `indirizzo`
--

INSERT INTO `indirizzo` (`ID`, `x`, `y`) VALUES
(1, 45.784, 9),
(2, 45.4773, 9.1815),
(3, 46, 8.1815),
(4, 42, 12.453),
(5, 45, 9),
(6, 40, 8.7),
(7, 44, 11),
(8, 45, 9.3),
(9, 46, 8),
(10, 45.5, 9.5),
(17, 45.23, 9),
(18, 43, 11.53),
(20, 45, 8.97),
(21, 45, 9.38),
(22, 45.8, 9.055);

-- --------------------------------------------------------

--
-- Struttura della tabella `menu`
--

CREATE TABLE `menu` (
  `ID` int(8) NOT NULL,
  `IDbaFK` int(8) NOT NULL,
  `IDprFK` varchar(50) NOT NULL DEFAULT '',
  `Disponibilita` int(2) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `menu`
--

INSERT INTO `menu` (`ID`, `IDbaFK`, `IDprFK`, `Disponibilita`) VALUES
(1, 1, 'succo di arancia', 1),
(2, 1, 'cheesecake', 1),
(3, 1, 'croissant', 1),
(5, 1, 'torta al cioccolato', 1);

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
  `Confermato` int(1) DEFAULT '0',
  `ValutazioneFatt` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `ordine`
--

INSERT INTO `ordine` (`ID`, `IDutFK`, `IDfatFK`, `IDbarFK`, `IDtiFK`, `IDinFK`, `Orario`, `Note`, `Data`, `Confermato`, `ValutazioneFatt`) VALUES
(1, 'da@gmail.com', 1, 1, 2, 22, '9', '', '2020-05-05', 1, 0),
(2, 'alex@ffff.it', NULL, 1, 1, 22, '10:00', 'Non va il citofono', '2020-05-07', 1, 4),
(30, 'bubu@gmail.com', NULL, 1, 1, 22, '9', '', '2020-05-20', 1, 0),
(31, 'bubu@gmail.com', 1, 1, 1, 22, '9', '', '2020-05-20', 1, 0),
(34, 'bubu@gmail.com', 1, 1, 3, 22, '11', 'Per favore con molto cioccolato', '2020-05-20', 1, 0),
(36, 'bubu@gmail.com', NULL, 1, 2, 22, '3', 'Per favore croissont alla crema', '2020-05-20', 0, 0),
(56, 'bubu@gmail.com', NULL, 1, 2, 22, '9', '', '2020-05-26', 0, 0),
(57, 'bubu@gmail.com', NULL, 1, 3, 22, '9', 'Questa. una prova', '2020-05-27', 0, 0),
(58, 'bubu@gmail.com', NULL, 1, 2, 22, '7', '', '2020-05-27', 0, 0),
(59, 'bubu@gmail.com', NULL, 1, 1, 22, '10', '', '2020-05-27', 0, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `possiede`
--

CREATE TABLE `possiede` (
  `ID` int(8) NOT NULL,
  `IDdoFK` int(8) NOT NULL,
  `IDriFK` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `possiede`
--

INSERT INTO `possiede` (`ID`, `IDdoFK`, `IDriFK`) VALUES
(1, 1, 1);

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

--
-- Dump dei dati per la tabella `prodotto`
--

INSERT INTO `prodotto` (`Nome`, `Ingredienti`, `Prezzo`, `Tipo`) VALUES
('avocado toast', 'pane,avocado', 3.5, 'bevande'),
('brioche', 'farina,uova,latte,lievito,burro', 2.5, 'dolce'),
('caffe', 'caffe', 0.6, 'bevande'),
('cappuccino', 'caffe,latte', 0.8, 'bevande'),
('cheesecake', 'burro,mascarpone', 2.6, 'dolce'),
('croissant', 'farina,uova,lievito,latte', 2, 'dolce'),
('crostata alla frutta', 'farina,uova,zucchero', 1.2, 'dolce'),
('frenchtoast', 'pane,uova,latte,cannella', 3.5, 'dolce'),
('muffin', 'farina,uova,latte,lievito,burro', 2, 'dolce'),
('pancake', 'farina,latte,uova,lievito', 3.5, 'dolce'),
('pancetta', 'pancetta', 1, 'salato'),
('pasticciotto', 'farina,uova,strutto,burro', 1, 'dolce'),
('succo di arancia', 'arancia', 0.8, 'bevande'),
('tiramisù', 'savoiardi,mascarpone,uova,cacao,zucchero', 2, 'dolce'),
('torta al cioccolato', 'cacao,farina,uova,latte,lievito,burro', 2, 'dolce'),
('torta alle mele', 'mele,farina,uova,latte,lievito,olio,limone', 1, 'dolce'),
('uova', 'uova', 1, 'salato');

-- --------------------------------------------------------

--
-- Struttura della tabella `risposta`
--

CREATE TABLE `risposta` (
  `ID` int(8) NOT NULL,
  `Risposta` varchar(50) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `risposta`
--

INSERT INTO `risposta` (`ID`, `Risposta`) VALUES
(1, 'Contatta il nostro numero verde 800.800.157');

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
('alex@ffff.it', 'Alex', 'Rusei', '2000-05-25', '5625', 12054256),
('bubu@gmail.com', 'Guglielmo', 'Strambini', '1999-12-19', '333', 34252432),
('cri@gmai.com', 'Cristiano', 'Ronaldo', '1985-02-05', 'cri00', 56423158),
('da@gmail.com', 'Daniela', 'De Pascali', '2001-07-03', '2442', 35663535),
('eater@gnam.com', 'Ither', 'Khaza', '2000-02-04', '45678', 35489259),
('leo@gmail.com', 'Leonardo', 'DiCaprio', '1974-11-11', 't1t4n1c', 33302526),
('nico@asd.it', 'Nicolò', 'Zaniolo', '1999-07-02', 'r0m4', 12345985),
('sabba@ilrosso.it', 'Samuele', 'Sabbatini', '2000-11-22', '98722', 20338228),
('simo@asd.it', 'Simone', 'Barzaghi', '1997-08-24', '666', 21474836),
('sofia@g.it', 'Sofia', 'Goggia', '1992-11-05', 'kkk555', 66823749),
('zio@zio.com', 'prova', 'pippo', '1999-12-11', '333', 4543536);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `bar`
--
ALTER TABLE `bar`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDindiFK` (`IDinFK`);

--
-- Indici per le tabelle `chiedef`
--
ALTER TABLE `chiedef`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDfattFK` (`IDfatFK`),
  ADD KEY `IDdomFK` (`IDdoFK`);

--
-- Indici per le tabelle `chiedeu`
--
ALTER TABLE `chiedeu`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDdoFK` (`IDdoFK`),
  ADD KEY `IDuttFK` (`IDutFK`);

--
-- Indici per le tabelle `classificato`
--
ALTER TABLE `classificato`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDfiFK` (`IDfiFK`),
  ADD KEY `IDbFK` (`IDbaFK`);

--
-- Indici per le tabelle `contiene`
--
ALTER TABLE `contiene`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDorFK` (`IDorFK`),
  ADD KEY `IDprfk` (`IDprFK`);

--
-- Indici per le tabelle `domanda`
--
ALTER TABLE `domanda`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `fattorino`
--
ALTER TABLE `fattorino`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `filtro`
--
ALTER TABLE `filtro`
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
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDmFK` (`IDbaFK`),
  ADD KEY `IDpr2FK` (`IDprFK`);

--
-- Indici per le tabelle `ordine`
--
ALTER TABLE `ordine`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDutFK` (`IDutFK`),
  ADD KEY `IDfatFK` (`IDfatFK`),
  ADD KEY `IDbarFK` (`IDbarFK`),
  ADD KEY `IDtiFK` (`IDtiFK`),
  ADD KEY `FK_ordine_indirizzo` (`IDinFK`);

--
-- Indici per le tabelle `possiede`
--
ALTER TABLE `possiede`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDdomaFK` (`IDdoFK`),
  ADD KEY `IDrisFK` (`IDriFK`);

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`Nome`);

--
-- Indici per le tabelle `risposta`
--
ALTER TABLE `risposta`
  ADD PRIMARY KEY (`ID`);

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
-- AUTO_INCREMENT per la tabella `bar`
--
ALTER TABLE `bar`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT per la tabella `chiedef`
--
ALTER TABLE `chiedef`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `chiedeu`
--
ALTER TABLE `chiedeu`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `classificato`
--
ALTER TABLE `classificato`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `contiene`
--
ALTER TABLE `contiene`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT per la tabella `domanda`
--
ALTER TABLE `domanda`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `fattorino`
--
ALTER TABLE `fattorino`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT per la tabella `filtro`
--
ALTER TABLE `filtro`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `indirizzo`
--
ALTER TABLE `indirizzo`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT per la tabella `menu`
--
ALTER TABLE `menu`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT per la tabella `possiede`
--
ALTER TABLE `possiede`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `risposta`
--
ALTER TABLE `risposta`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
-- Limiti per la tabella `bar`
--
ALTER TABLE `bar`
  ADD CONSTRAINT `IDindiFK` FOREIGN KEY (`IDinFK`) REFERENCES `indirizzo` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `chiedef`
--
ALTER TABLE `chiedef`
  ADD CONSTRAINT `IDdomFK` FOREIGN KEY (`IDdoFK`) REFERENCES `domanda` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDfattFK` FOREIGN KEY (`IDfatFK`) REFERENCES `fattorino` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `chiedeu`
--
ALTER TABLE `chiedeu`
  ADD CONSTRAINT `IDdoFK` FOREIGN KEY (`IDdoFK`) REFERENCES `domanda` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDuttFK` FOREIGN KEY (`IDutFK`) REFERENCES `utente` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `classificato`
--
ALTER TABLE `classificato`
  ADD CONSTRAINT `IDbFK` FOREIGN KEY (`IDbaFK`) REFERENCES `bar` (`ID`),
  ADD CONSTRAINT `IDfiFK` FOREIGN KEY (`IDfiFK`) REFERENCES `filtro` (`ID`);

--
-- Limiti per la tabella `contiene`
--
ALTER TABLE `contiene`
  ADD CONSTRAINT `IDorFK` FOREIGN KEY (`IDorFK`) REFERENCES `ordine` (`ID`),
  ADD CONSTRAINT `IDprfk` FOREIGN KEY (`IDprFK`) REFERENCES `prodotto` (`Nome`);

--
-- Limiti per la tabella `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `IDbar` FOREIGN KEY (`IDbaFK`) REFERENCES `bar` (`ID`),
  ADD CONSTRAINT `IDpr2FK` FOREIGN KEY (`IDprFK`) REFERENCES `prodotto` (`Nome`);

--
-- Limiti per la tabella `ordine`
--
ALTER TABLE `ordine`
  ADD CONSTRAINT `FK_ordine_indirizzo` FOREIGN KEY (`IDinFK`) REFERENCES `indirizzo` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDbarFK` FOREIGN KEY (`IDbarFK`) REFERENCES `bar` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDfatFK` FOREIGN KEY (`IDfatFK`) REFERENCES `fattorino` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDtiFK` FOREIGN KEY (`IDtiFK`) REFERENCES `tipopagamento` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDutFK` FOREIGN KEY (`IDutFK`) REFERENCES `utente` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `possiede`
--
ALTER TABLE `possiede`
  ADD CONSTRAINT `IDdomaFK` FOREIGN KEY (`IDdoFK`) REFERENCES `domanda` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IDrisFK` FOREIGN KEY (`IDriFK`) REFERENCES `risposta` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `sceglie`
--
ALTER TABLE `sceglie`
  ADD CONSTRAINT `IDUtente` FOREIGN KEY (`IDutFK`) REFERENCES `utente` (`Email`),
  ADD CONSTRAINT `IDprefeFK` FOREIGN KEY (`IDprFK`) REFERENCES `indirizzo` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
