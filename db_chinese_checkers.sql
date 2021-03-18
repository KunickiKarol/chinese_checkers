-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Wersja serwera:               10.5.5-MariaDB - mariadb.org binary distribution
-- Serwer OS:                    Win64
-- HeidiSQL Wersja:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Zrzut struktury bazy danych china
CREATE DATABASE IF NOT EXISTS `china` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `china`;

-- Zrzut struktury tabela china.gra
CREATE TABLE IF NOT EXISTS `gra` (
  `NrGry` int(11) NOT NULL AUTO_INCREMENT,
  `Plansza` varchar(90) NOT NULL,
  `Gracze` int(11) NOT NULL,
  `Ksztalt` varchar(90) NOT NULL,
  PRIMARY KEY (`NrGry`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Zrzucanie danych dla tabeli china.gra: ~8 rows (około)
/*!40000 ALTER TABLE `gra` DISABLE KEYS */;
INSERT INTO `gra` (`NrGry`, `Plansza`, `Gracze`, `Ksztalt`) VALUES
	(1, 'LogicBoardClassical2P', 2, 'Circle'),
	(2, 'LogicBoardClassical2P', 2, 'Circle');
/*!40000 ALTER TABLE `gra` ENABLE KEYS */;

-- Zrzut struktury tabela china.grainfo
CREATE TABLE IF NOT EXISTS `grainfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NrGry` int(11) NOT NULL,
  `NrRuchu` int(11) NOT NULL,
  `Info` varchar(90) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `NrGry` (`NrGry`),
  CONSTRAINT `grainfo_ibfk_1` FOREIGN KEY (`NrGry`) REFERENCES `gra` (`NrGry`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- Zrzucanie danych dla tabeli china.grainfo: ~44 rows (około)
/*!40000 ALTER TABLE `grainfo` DISABLE KEYS */;
INSERT INTO `grainfo` (`ID`, `NrGry`, `NrRuchu`, `Info`) VALUES
	(1, 1, 0, 'CHANGE 4;7;red|CHANGE 2;6;white'),
	(2, 1, 1, 'CHANGE 5;7;red|CHANGE 4;7;white'),
	(3, 1, 2, 'CHANGE 12;7;yellow|CHANGE 14;6;white'),
	(4, 1, 3, 'CHANGE 11;7;yellow|CHANGE 12;7;white'),
	(5, 1, 4, 'CHANGE 4;6;red|CHANGE 2;7;white'),
	(6, 1, 5, 'CHANGE 6;7;red|CHANGE 4;6;white'),
	(7, 1, 6, 'CHANGE 7;7;red|CHANGE 6;7;white'),
	(8, 1, 7, 'CHANGE 12;6;yellow|CHANGE 14;7;white'),
	(9, 1, 8, 'CHANGE 10;7;yellow|CHANGE 12;6;white'),
	(10, 1, 9, 'CHANGE 9;7;yellow|CHANGE 10;7;white'),
	(11, 1, 10, 'CHANGE 4;6;red|CHANGE 2;5;white'),
	(12, 1, 11, 'CHANGE 6;7;red|CHANGE 4;6;white'),
	(13, 1, 12, 'CHANGE 8;6;red|CHANGE 6;7;white'),
	(14, 1, 13, 'CHANGE 10;7;red|CHANGE 8;6;white'),
	(15, 1, 14, 'CHANGE 12;6;red|CHANGE 10;7;white'),
	(16, 1, 15, 'CHANGE 14;7;red|CHANGE 12;6;white'),
	(17, 1, 16, 'CHANGE 15;7;red|CHANGE 14;7;yellow'),
	(18, 2, 0, 'CHANGE 4;7;red|CHANGE 2;6;white'),
	(19, 2, 1, 'CHANGE 5;7;red|CHANGE 4;7;white'),
	(20, 2, 2, 'CHANGE 12;4;yellow|CHANGE 13;5;white'),
	(21, 2, 3, 'CHANGE 4;8;red|CHANGE 2;7;white'),
	(22, 2, 4, 'CHANGE 5;9;red|CHANGE 4;8;white'),
	(23, 2, 5, 'CHANGE 13;5;yellow|CHANGE 15;6;white'),
	(24, 2, 6, 'CHANGE 11;4;yellow|CHANGE 13;5;white'),
	(25, 2, 7, 'CHANGE 10;3;yellow|CHANGE 11;4;white'),
	(26, 2, 8, 'CHANGE 2;7;red|CHANGE 0;6;white'),
	(27, 2, 9, 'CHANGE 4;8;red|CHANGE 2;7;white'),
	(28, 2, 10, 'CHANGE 6;9;red|CHANGE 4;8;white'),
	(29, 2, 11, 'CHANGE 5;10;red|CHANGE 6;9;white'),
	(30, 2, 12, 'CHANGE 12;5;yellow|CHANGE 13;6;white');
/*!40000 ALTER TABLE `grainfo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
