-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 17. Feb 2022 um 18:23
-- Server-Version: 10.4.20-MariaDB
-- PHP-Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `java3`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `erwartung`
--

CREATE TABLE `erwartung` (
  `id` int(11) NOT NULL,
  `id_game` int(11) NOT NULL,
  `id_player` int(11) NOT NULL,
  `goals_home_team` int(3) NOT NULL,
  `goals_gast_team` int(3) NOT NULL,
  `punkte` int(4) NOT NULL DEFAULT -1,
  `powerofgame` int(1) NOT NULL,
  `home_team` varchar(100) NOT NULL,
  `gast_team` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `erwartung`
--

INSERT INTO `erwartung` (`id`, `id_game`, `id_player`, `goals_home_team`, `goals_gast_team`, `punkte`, `powerofgame`, `home_team`, `gast_team`) VALUES
(1, 3, 1, 3, 1, 4, 7, 'RB Leipzig', 'Eintracht Frankfurt'),
(2, 3, 2, 3, 2, 4, 7, 'RB Leipzig', 'Eintracht Frankfurt'),
(3, 3, 3, 1, 1, 0, 7, 'RB Leipzig', 'Eintracht Frankfurt'),
(4, 2, 3, 0, 1, 0, 5, 'Borussia Dortmund', 'VfB Stuttgart'),
(5, 2, 3, 0, 5, 0, 5, 'Borussia Dortmund', 'VfB Stuttgart'),
(6, 2, 1, 5, 0, 0, 5, 'Borussia Dortmund', 'VfB Stuttgart'),
(7, 1, 1, 1, 5, 0, 7, 'FC Bayern München', 'FC Köln'),
(8, 1, 2, 2, 2, 0, 7, 'FC Bayern München', 'FC Köln'),
(9, 2, 3, 0, 2, 0, 5, 'Borussia Dortmund', 'VfB Stuttgart'),
(10, 4, 1, 1, 1, 4, 4, 'BM gladbach', 'Hoffenheim'),
(11, 4, 2, 0, 0, 3, 4, 'BM gladbach', 'Hoffenheim'),
(12, 4, 3, 1, 0, 0, 4, 'BM gladbach', 'Hoffenheim'),
(13, 9, 1, 3, 1, 5, 10, 'FC Bayern München', 'Borussia Dortmund'),
(14, 9, 2, 3, 3, 0, 10, 'FC Bayern München', 'Borussia Dortmund'),
(15, 9, 4, 2, 3, 0, 10, 'FC Bayern München', 'Borussia Dortmund'),
(16, 8, 4, 0, 0, -1, 7, 'Borussia Dortmund', 'Eintracht Frankfurt'),
(17, 8, 4, 0, 0, -1, 7, 'Borussia Dortmund', 'Eintracht Frankfurt'),
(18, 10, 2, 1, 0, -5, 10, 'FC Bayern München', 'Borussia Dortmund'),
(19, 10, 3, 3, 2, 10, 10, 'FC Bayern München', 'Borussia Dortmund'),
(20, 13, 5, 2, 1, -1, 10, 'FC Bayern München', 'SC Freiburg');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `game`
--

CREATE TABLE `game` (
  `id` int(6) NOT NULL,
  `home_team` varchar(100) NOT NULL DEFAULT '""',
  `gast_team` varchar(100) NOT NULL DEFAULT '""',
  `goals_home_team` int(11) NOT NULL DEFAULT -9,
  `goals_gast_team` int(11) NOT NULL DEFAULT -9,
  `flag` int(11) NOT NULL DEFAULT 100,
  `gameover` int(1) NOT NULL DEFAULT 0,
  `tag` int(11) NOT NULL DEFAULT 0,
  `powerofgame` int(11) NOT NULL DEFAULT -1,
  `maxP` int(11) NOT NULL DEFAULT 0,
  `mittelP` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `game`
--

INSERT INTO `game` (`id`, `home_team`, `gast_team`, `goals_home_team`, `goals_gast_team`, `flag`, `gameover`, `tag`, `powerofgame`, `maxP`, `mittelP`) VALUES
(1, 'FC Bayern München', 'FC Köln', 3, 0, 3, 5, 0, 7, 7, 4),
(2, 'Borussia Dortmund', 'VfB Stuttgart', 2, 1, 1, 5, 0, 5, 0, 0),
(3, 'RB Leipzig', 'Eintracht Frankfurt', 2, 1, 1, 5, 0, 7, 7, 4),
(4, 'BM gladbach', 'Hoffenheim', 1, 1, 0, 5, 0, 4, 4, 3),
(5, 'RB Leipzig', 'Arminia Bielefeld', -9, -9, 100, 0, 0, 5, 0, 0),
(6, 'Mainz 05', 'FC Bayern München', -9, -9, 100, 0, 0, 7, 7, 4),
(7, '1. FC Union Berlin', 'FC Köln', -9, -9, 100, 0, 0, 4, 4, 3),
(8, 'Borussia Dortmund', 'Eintracht Frankfurt', -9, -9, 100, 0, 0, 7, 7, 4),
(9, 'FC Bayern München', 'Borussia Dortmund', 2, 1, 1, 5, 0, 10, 10, 5),
(10, 'FC Bayern München', 'Borussia Dortmund', 3, 2, 1, 5, 0, 10, 10, 5),
(11, 'VfL Wolfsburg', 'FC Köln', -9, -9, 100, 0, 0, 7, 7, 4),
(12, 'Arminia Bielefeld', 'Hoffenheim', -9, -9, 100, 0, 1, 2, 2, 2),
(13, 'FC Bayern München', 'SC Freiburg', -9, -9, 100, 0, 1, 10, 10, 5);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `player`
--

CREATE TABLE `player` (
  `id` int(3) NOT NULL,
  `player_name` varchar(255) NOT NULL,
  `points` int(3) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `player`
--

INSERT INTO `player` (`id`, `player_name`, `points`) VALUES
(1, 'Hani', 13),
(2, 'Silina', 7),
(3, 'Karam', 10),
(4, 'Misha', 0),
(5, 'Linda', 0),
(6, 'Basel', 0),
(7, 'Stefani', 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `todo`
--

CREATE TABLE `todo` (
  `id` int(11) NOT NULL,
  `deadline` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `todo`
--

INSERT INTO `todo` (`id`, `deadline`, `state`, `description`, `title`) VALUES
(1, '2021-07-01', 'OPEN', 'Nudeln', 'einkauf'),
(2, '2021-07-07', 'IN_PROGRESS', 'Eier', 'einkaufen'),
(3, '2021-07-01', 'OPEN', 'laufen', 'sport'),
(4, '2021-07-09', 'OPEN', 'an den See fahren', 'baden');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`id`, `e_mail`, `username`) VALUES
(1, 'new@mail.de', 'ina'),
(2, 'max@test.de', 'max');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `erwartung`
--
ALTER TABLE `erwartung`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `todo`
--
ALTER TABLE `todo`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_5awx5dcb9xdv5m1bl38bmoke0` (`e_mail`) USING HASH;

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `erwartung`
--
ALTER TABLE `erwartung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT für Tabelle `game`
--
ALTER TABLE `game`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT für Tabelle `player`
--
ALTER TABLE `player`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT für Tabelle `todo`
--
ALTER TABLE `todo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
