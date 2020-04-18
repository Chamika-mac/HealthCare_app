-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2020 at 08:34 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rest_api`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `hospitalId` int(11) NOT NULL,
  `hospitalName` varchar(50) DEFAULT NULL,
  `hospitalRegId` varchar(50) DEFAULT NULL,
  `hospitalAddress` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contactNum` varchar(10) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`hospitalId`, `hospitalName`, `hospitalRegId`, `hospitalAddress`, `email`, `contactNum`, `userName`, `password`) VALUES
(1, 'null', 'null', 'null', 'nawaloka@gmail.com', '0767224713', 'null', 'nawaloka123'),
(2, 'null', 'null', 'null', 'nawaloka@gmail.com', '0767224713', 'null', 'nawaloka123'),
(3, 'null', 'null', 'null', 'nawaloka@gmail.com', '0767224713', 'null', 'nawaloka123'),
(4, 'null', 'null', 'null', 'nawaloka@gmail.com', '0213545513', 'null', 'central123'),
(5, 'null', 'null', 'null', 'arogya@gmail.com', '0000000', 'null', 'arogya634l123'),
(7, 'pasindu', 'pasindu', 'pasindu', 'arogya@gmail.com', '0112402037', 'pasindu', 'arogya634l123'),
(8, 'pasinduhgfdfxxd', 'pasindujhjhfffxxxx', 'pasinduuuu', 'aaaaaa@gmail.com', '01254863', 'hashara', 'hashara634l123'),
(9, 'hasha44444444', 'hasha44444444', 'hasha44444444', 'a2222@gmail.com', '01222222', 'hash4444444', 'hasha44444444');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`hospitalId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `hospitalId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
