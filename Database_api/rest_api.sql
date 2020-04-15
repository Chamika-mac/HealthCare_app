-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2020 at 07:28 PM
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
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `appointmentId` int(10) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `doctor_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contactNum` varchar(45) DEFAULT NULL,
  `Hospital_Name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`appointmentId`, `Name`, `date`, `time`, `doctor_name`, `email`, `contactNum`, `Hospital_Name`) VALUES
(2, 'Sudaraka', '2020-05-09', '0700', 'Dr Ushan', 'ushan@rstmaintenance.lk', '0722000999', 'kjkjkj'),
(3, 'Udaraka', '2020-05-09', '0700', 'Dr Oshan', 'oshan@rstmaintenance.lk', '0752000999', 'ugdx'),
(4, 'Udara', '2020-05-09', '0700', 'Dr heshan', 'heshan@rstmaintenance.lk', '0723000999', 'ddss'),
(5, 'Nirmala', '2020-05-09', '0700', 'Dr pasan', 'pasan@rstmaintenance.lk', '01123000999', 'asssda'),
(8, 'Sudaraka', '2020-05-10', '0630', 'Dr Gamage', 'sudaraka@rstmaintenance.lk', '076877950', 'Leason Hospital');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctorId` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `UserName` varchar(45) DEFAULT NULL,
  `ContactNum` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Sex` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctorId`, `Name`, `UserName`, `ContactNum`, `Email`, `Sex`, `Address`, `Password`) VALUES
(1, 'Udara', 'null', '0700', 'Dr heshan', 'null', 'heshan@rstmaintenance.lk', '0723000999'),
(2, 'Udara', 'null', '0700', 'Dr heshan', 'male', 'heshan@rstmaintenance.lk', '0723000999'),
(5, 'Niamla', 'null', '01231234', 'haswj@gmail.com', 'male', '11,kaduwela', '1234'),
(6, 'Udara', 'udara92', '034555500', 'dr@gmail.com', 'male', '11,colombo', '0999'),
(7, 'Niamla', 'null', '01231234', 'haswj@gmail.com', 'male', '11,kaduwela', '1234'),
(8, 'Niamla', 'null', '01231234', 'haswj@gmail.com', 'male', '11,kaduwela', '1234'),
(9, 'sudaraka', 'null', '0768773425', 'suda@gmail.com', 'male', '12,kadawatha', '0000'),
(10, 'Udara', '2222', '0700', 'Dr heshan', 'male', 'heshan@rstmaintenance.lk', '0723000999');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`appointmentId`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctorId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `appointmentId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `doctorId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
