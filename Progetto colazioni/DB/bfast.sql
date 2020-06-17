-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Giu 17, 2020 alle 15:54
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
(3, 2, 'Bar ciko', '', '', 3.2, 'dfagdfg@ssad.com', '333', 0),
(4, 9, 'Bar Uno', '', '', 5, 'baruno@gmail.com', '123', 0),
(5, 8, 'Bar Due', '', '', 2.5, 'bardue@blabla.it', '456', 0),
(6, 4, 'Bar Tre', '', '', 3.6, 'bartre@sdfgh.it', '789', 0),
(7, 6, 'Bar Quattro', '', '', 4, 'barquattro@opop.it', '852', 0),
(8, 7, 'Bar Cinque', '', '', 4.5, 'barcinque@asd.com', '147', 0),
(9, 3, 'Bar Sei', '', '', 5, 'barsei@fgh.com', '654', 0),
(10, 5, 'Bar Sette', '', '', 3.7, 'barsette@yh.com', '321', 0),
(31, 17, 'Bar prova', '4', '19', 1, 'prova@gmail.com', '333', 0),
(32, 20, 'Bar prova', '4', '21', 0.5, 'prova@gmail.com', '333', 0),
(33, 18, 'Bar ciko', '8', '13', 5, 'dfagdfg@ssad.com', '232', 0),
(34, 21, 'prova', '5', '12', 4, 'nonna@diaz.com', '333', 0),
(35, 34, 'Bar la piazza', '6', '21', 4, 'piazza@gmail.com', '343', 0),
(36, 35, 'Bar felice', '6', '12', 4.75, 'felice@bar.com', '1234', 0);

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
(36, 'torta al cioccolato', 60, 2),
(37, 'succo di arancia', 60, 1),
(38, 'cheesecake', 61, 1),
(39, 'succo di arancia', 61, 1),
(40, 'torta al cioccolato', 65, 1),
(41, 'torta al cioccolato', 66, 2),
(42, 'succo di arancia', 66, 2),
(43, 'muffin', 67, 1),
(44, 'tiramisù', 67, 1),
(45, 'succo di arancia', 67, 2),
(47, 'tiramisù', 85, 3),
(48, 'succo di arancia', 85, 1),
(53, 'torta al cioccolato', 91, 2),
(55, 'torta al cioccolato', 93, 2),
(56, 'torta al cioccolato', 95, 2),
(73, 'tiramisù', 104, 1),
(80, 'tiramisù', 109, 1),
(81, 'caffe', 109, 1),
(90, 'caffe', 122, 2),
(91, 'torta al cioccolato', 122, 1),
(93, 'brioche', 124, 1),
(94, 'caffe', 124, 1),
(102, 'brioche', 132, 1),
(107, 'muffin', 135, 1),
(108, 'caffe', 135, 1),
(111, 'brioche', 138, 1),
(112, 'cheesecake', 139, 1),
(114, 'succo di arancia', 141, 1),
(116, 'muffin', 141, 1),
(117, 'brioche', 142, 1),
(118, 'muffin', 149, 1),
(119, 'torta al cioccolato', 150, 1),
(120, 'muffin', 151, 1),
(121, 'tiramisù', 152, 1),
(122, 'cappuccino', 153, 1),
(123, 'brioche', 153, 1),
(124, 'cheesecake', 155, 1);

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
(22, 45.8, 9.055),
(23, 45, 9.4),
(24, 45, 9.6),
(25, 45, 9.8),
(26, 45, 9.9),
(27, 45.81551205221679, 8.836646229028702),
(28, 45.707900393244294, 8.898358158767223),
(30, 45.7356686702116, 9.002336673438549),
(31, 45.7892563785621, 9.019411280751228),
(32, 45.8021494576964, 8.998388126492499),
(33, 45.81228580399955, 9.12068646401167),
(34, 45.738578306404385, 9.007043950259686),
(35, 45.77093749137485, 9.017743952572346),
(36, 45.76329169627214, 9.00897916406393);

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
(5, 1, 'torta al cioccolato', 1),
(6, 2, 'caffe', 1),
(7, 3, 'crostata alla frutta', 1),
(8, 4, 'avocado toast', 1),
(9, 3, 'uova', 1),
(10, 3, 'muffin', 1),
(11, 2, 'torta al cioccolato', 1),
(13, 6, 'pasticciotto', 1),
(14, 5, 'torta alle mele', 1),
(15, 7, 'pancake', 1),
(16, 5, 'cappuccino', 1),
(17, 1, 'caffe', 1),
(18, 6, 'caffe', 1),
(20, 7, 'tiramisù', 1),
(21, 1, 'tiramisù', 1),
(22, 1, 'brioche', 1),
(23, 1, 'cappuccino', 1),
(24, 1, 'muffin', 1),
(25, 1, 'avocado toast', 1),
(28, 1, 'cheesecake', 1),
(29, 35, 'avocado toast', 1),
(30, 35, 'brioche', 1),
(31, 35, 'caffe', 1),
(32, 35, 'cappuccino', 1),
(33, 35, 'pasticciotto', 1),
(34, 35, 'succo di arancia', 1),
(35, 35, 'pancake', 1),
(36, 35, 'frenchtoast', 1),
(37, 36, 'cheesecake', 1),
(38, 36, 'brioche', 1),
(39, 36, 'caffe', 1),
(40, 36, 'muffin', 1);

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
(1, 'da@gmail.com', 1, 1, 2, 23, '9', '', '2020-05-05', 1, 3),
(2, 'alex@ffff.it', NULL, 1, 1, 22, '10:00', 'Non va il citofono', '2020-05-07', 1, 0),
(30, 'bubu@gmail.com', NULL, 1, 1, 22, '9', '', '2020-05-20', 1, 0),
(31, 'bubu@gmail.com', 1, 1, 1, 22, '9', '', '2020-05-20', 1, 5),
(34, 'bubu@gmail.com', 1, 1, 3, 22, '11', 'Per favore con molto cioccolato', '2020-05-20', 1, 2),
(36, 'bubu@gmail.com', NULL, 1, 2, 22, '3', 'Per favore croissont alla crema', '2020-05-20', 1, 0),
(56, 'bubu@gmail.com', NULL, 1, 2, 22, '9', '', '2020-05-26', 1, 0),
(60, 'bubu@gmail.com', 1, 1, 1, 22, '10', '', '2020-05-27', 1, 4),
(61, 'bubu@gmail.com', 1, 1, 3, 22, '10:30', '2 bustine di zucchero', '2020-05-27', 1, 3.5),
(65, 'bubu@gmail.com', 1, 1, 2, 22, '9', '', '2020-05-28', 1, 5),
(66, 'bubu@gmail.com', NULL, 1, 1, 22, '10', '', '2020-05-28', 1, 0),
(67, 'bubu@gmail.com', NULL, 1, 2, 22, '10', 'Ottimo upgrade del menu', '2020-05-28', 1, 0),
(85, 'bubu@gmail.com', 1, 1, 1, 22, '9', '', '2020-06-02', 1, 4.5),
(91, 'bubu@gmail.com', NULL, 1, 1, 22, '10', 'Ottimo update dell\'app', '2020-06-02', 1, 0),
(93, 'bubu@gmail.com', NULL, 1, 1, 22, '9', '', '2020-06-02', 1, 0),
(95, 'bubu@gmail.com', NULL, 1, 1, 22, '10', '', '2020-06-02', 0, 0),
(104, 'bubu@gmail.com', NULL, 1, 1, 22, '9', 'Servizio migliorato', '2020-06-03', 1, 0),
(109, 'bubu@gmail.com', 1, 1, 1, 22, '10', '', '2020-06-03', 1, 5),
(122, 'bubu@gmail.com', NULL, 1, 1, 22, '10', 'Ottimizazione app', '2020-06-04', 1, 0),
(124, 'bubu@gmail.com', NULL, 1, 1, 22, '9', '', '2020-06-04', 0, 0),
(132, 'bubu@gmail.com', 1, 1, 1, 22, '11', '', '2020-06-04', 1, 4),
(135, 'bubu@gmail.com', 1, 1, 1, 22, '11', '', '2020-06-04', 1, 5),
(138, 'bubu@gmail.com', NULL, 1, 2, 22, '10', '', '2020-06-08', 0, 0),
(139, 'bubu@gmail.com', 1, 1, 2, 22, '10', '', '2020-06-08', 1, 4.5),
(141, 'bubu@gmail.com', 1, 1, 1, 22, '10', '', '2020-06-08', 1, 5),
(142, 'bubu@gmail.com', NULL, 1, 2, 22, '10', '', '2020-06-09', 1, 0),
(149, 'bubu@gmail.com', 1, 1, 2, 30, '10', '', '2020-06-09', 1, 3.5),
(150, 'bubu@gmail.com', 1, 1, 2, 31, '10', '', '2020-06-09', 1, 4.5),
(151, 'bubu@gmail.com', 1, 1, 2, 32, '10', '', '2020-06-09', 1, 3.5),
(152, 'bubu@gmail.com', 1, 1, 2, 33, '10', '', '2020-06-09', 1, 5),
(153, 'bubu@gmail.com', 1, 1, 3, 34, '9', 'Posizione aggiornata', '2020-06-09', 1, 4.5),
(155, 'bubu@gmail.com', 1, 36, 2, 36, '10', '', '2020-06-10', 1, 5);

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
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

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
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

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
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT per la tabella `menu`
--
ALTER TABLE `menu`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=156;

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
