-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 23, 2014 at 11:02 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `onlinefoodbooking`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `roll` varchar(9) NOT NULL,
  `amount` int(3) NOT NULL DEFAULT '0',
  UNIQUE KEY `roll` (`roll`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`roll`, `amount`) VALUES
('123', 501),
('123456', 11682),
('m120353ca', 0),
('m120357ca', 500),
('m120403ca', 916);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `roll` varchar(9) NOT NULL DEFAULT '',
  `name` varchar(15) NOT NULL,
  `contact` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `hostelName` varchar(6) NOT NULL,
  PRIMARY KEY (`roll`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`roll`, `name`, `contact`, `email`, `hostelName`) VALUES
('123', 'rajendra', '963258741', 'raja@gmail.com', 'G'),
('123456', 'Ajay', '8564213897', 'ajay@gmail.com', 'B'),
('m120353ca', 'Manu', 'g hostel', 'me.manugk@gmail.com', 'G'),
('m120357ca', 'suresh Patidar', '8714250851', 'sureshpatidar32@gmai', 'A'),
('m120403ca', 'Bittu', '86542318', 'bittusingh0348@gmail', 'A'),
('manager', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `itemId` varchar(3) NOT NULL,
  `itemName` varchar(20) NOT NULL,
  `price` int(3) NOT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`itemId`, `itemName`, `price`) VALUES
('I01', 'Atta Porotta', 6),
('I02', 'Alu Porotta', 8),
('I03', 'Kerala Porotta', 6),
('I05', 'Egg Roast', 15),
('I06', 'Peas Masala', 16),
('I07', 'Alu Gobi', 17),
('I08', 'Alu Mutter', 23),
('I09', 'Kabooli Chana', 23),
('I10', 'Palak Paneer', 23),
('I11', 'Ginger Chicken', 35),
('I12', 'Chilly Chicken', 36),
('I13', 'Butter Chicken', 35),
('I14', 'Pepper Chicken', 36),
('I15', 'Chicken Biriyani', 90),
('I17', 'Egg Noodles', 35),
('I18', 'Ghee Rice', 32),
('I19', 'Fish Fry', 20),
('I20', 'Fish Curry', 25),
('I21', 'Egg Porotta', 18);

-- --------------------------------------------------------

--
-- Table structure for table `maintransaction`
--

CREATE TABLE IF NOT EXISTS `maintransaction` (
  `orderNo` varchar(4) NOT NULL,
  `roll` varchar(9) NOT NULL,
  PRIMARY KEY (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maintransaction`
--

INSERT INTO `maintransaction` (`orderNo`, `roll`) VALUES
('1001', '123456'),
('1002', '123456'),
('1003', '123'),
('1004', '123'),
('1005', '123'),
('1006', '123'),
('1007', '123'),
('1008', '123'),
('1009', '123'),
('1010', '123'),
('1011', '123'),
('1012', '123456'),
('1013', '123456'),
('1014', '123456'),
('1015', '123456'),
('1016', '123456'),
('1017', '123456'),
('1018', '123'),
('1019', '123'),
('1020', 'm120403ca'),
('1021', 'm120403ca'),
('1022', 'm120403ca'),
('1023', '123');

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE IF NOT EXISTS `manager` (
  `mname` varchar(15) NOT NULL,
  `contact` varchar(10) NOT NULL,
  UNIQUE KEY `mname` (`mname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`mname`, `contact`) VALUES
('manager', '1234567890');

-- --------------------------------------------------------

--
-- Table structure for table `tem_table`
--

CREATE TABLE IF NOT EXISTS `tem_table` (
  `itemId` varchar(3) NOT NULL,
  `item_name` varchar(20) NOT NULL,
  `price` int(3) NOT NULL,
  `quan` int(2) NOT NULL,
  `total` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
  `orderNo` varchar(4) NOT NULL,
  `roll` varchar(9) NOT NULL,
  `itemName` varchar(20) NOT NULL,
  `quantity` int(2) NOT NULL,
  `totalPrice` int(3) NOT NULL,
  `time` time NOT NULL,
  `date` date NOT NULL,
  KEY `orderNo` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`orderNo`, `roll`, `itemName`, `quantity`, `totalPrice`, `time`, `date`) VALUES
('1001', '123456', 'keralaParotha', 6, 36, '20:02:11', '2021-04-14'),
('1001', '123456', 'aaluparatha', 2, 16, '20:02:11', '2021-04-14'),
('1001', '123456', 'aataParotha', 2, 10, '20:02:11', '2021-04-14'),
('1002', '123456', 'aaluparatha', 5, 40, '20:03:59', '2021-04-14'),
('1002', '123456', 'aataParotha', 3, 15, '20:03:59', '2021-04-14'),
('1002', '123456', 'noodles', 1, 30, '20:03:59', '2021-04-14'),
('1003', '123', 'Atta Porotta', 3, 18, '11:24:21', '2022-04-14'),
('1003', '123', 'Kabooli Chana', 2, 46, '11:24:21', '2022-04-14'),
('1003', '123', 'Pepper Chicken', 2, 72, '11:24:21', '2022-04-14'),
('1004', '123', 'Kerala Porotta', 2, 12, '11:26:09', '2022-04-14'),
('1004', '123', 'Egg Roast', 1, 15, '11:26:09', '2022-04-14'),
('1005', '123', 'Atta Porotta', 1, 6, '11:27:35', '2022-04-14'),
('1006', '123', 'Alu Porotta', 2, 16, '11:28:43', '2022-04-14'),
('1007', '123', 'Atta Porotta', 1, 6, '11:29:03', '2022-04-14'),
('1008', '123', 'Kerala Porotta', 2, 12, '11:29:45', '2022-04-14'),
('1009', '123', 'Atta Porotta', 1, 6, '11:30:28', '2022-04-14'),
('1010', '123', 'Peas Masala', 2, 32, '11:32:48', '2022-04-14'),
('1011', '123', 'Kerala Porotta', 3, 18, '11:33:46', '2022-04-14'),
('1012', '123456', 'Atta Porotta', 3, 18, '11:54:35', '2022-04-14'),
('1012', '123456', 'Peas Masala', 1, 16, '11:54:35', '2022-04-14'),
('1012', '123456', 'Palak Paneer', 1, 23, '11:54:35', '2022-04-14'),
('1012', '123456', 'Ghee Rice', 1, 32, '11:54:35', '2022-04-14'),
('1013', '123456', 'Chicken Noodles', 1, 50, '11:55:12', '2022-04-14'),
('1013', '123456', 'Fish Fry', 2, 40, '11:55:12', '2022-04-14'),
('1013', '123456', 'Kabooli Chana', 1, 23, '11:55:12', '2022-04-14'),
('1016', '123456', 'Alu Porotta', 2, 16, '11:57:44', '2022-04-14'),
('1016', '123456', 'Peas Masala', 1, 16, '11:57:44', '2022-04-14'),
('1016', '123456', 'Kerala Porotta', 2, 12, '11:57:45', '2022-04-14'),
('1018', '123', 'Atta Porotta', 3, 18, '06:14:15', '2023-04-14'),
('1018', '123', 'Kerala Porotta', 2, 12, '06:14:15', '2023-04-14'),
('1018', '123', 'Chilly Chicken', 1, 36, '06:14:15', '2023-04-14'),
('1019', '123', 'Atta Porotta', 3, 18, '06:37:18', '0000-00-00'),
('1020', 'm120403ca', 'Atta Porotta', 3, 18, '00:00:00', '0000-00-00'),
('1020', 'm120403ca', 'Kerala Porotta', 2, 12, '00:00:00', '0000-00-00'),
('1021', 'm120403ca', 'Egg Roast', 2, 30, '13:12:14', '2023-04-14'),
('1022', 'm120403ca', 'Alu Porotta', 3, 24, '13:13:12', '2014-04-23'),
('1023', '123', 'Kerala Porotta', 3, 18, '15:00:51', '2014-04-23');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userId` varchar(10) DEFAULT NULL,
  `password` varchar(15) NOT NULL,
  `securityQues` varchar(30) NOT NULL,
  `securityAns` varchar(20) NOT NULL,
  UNIQUE KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `password`, `securityQues`, `securityAns`) VALUES
('manager', '1234567890', 'DOB Place', 'America'),
('123', '123', '', ''),
('m120357ca', '12345', 'Best friend name', 'nandani'),
('m120403ca', '12345', 'Best friend name', 'vandi'),
('m120353ca', '1234', 'Best friend name', 'amit');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`roll`) REFERENCES `customer` (`roll`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`orderNo`) REFERENCES `maintransaction` (`orderNo`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `customer` (`roll`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
