-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2020 at 05:07 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcare_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `RECORD_ID` int(10) NOT NULL,
  `ROLE_CODE` int(10) DEFAULT NULL,
  `FIRST_NAME` varchar(100) DEFAULT NULL,
  `LAST_NAME` varchar(100) DEFAULT NULL,
  `ID_NUMBER` varchar(100) DEFAULT NULL,
  `ADMIN_ROLE` varchar(100) DEFAULT NULL,
  `ADMIN_USERNAME` varchar(100) DEFAULT NULL,
  `ADMIN_PASSWORD` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`RECORD_ID`, `ROLE_CODE`, `FIRST_NAME`, `LAST_NAME`, `ID_NUMBER`, `ADMIN_ROLE`, `ADMIN_USERNAME`, `ADMIN_PASSWORD`) VALUES
(21, 1, 'Chamika', 'Dimantha', '961153301v', 'Administrator', 'chamikamac', 'chamika123');

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
  `RECORD_ID` int(11) NOT NULL,
  `ROLE_CODE` int(10) DEFAULT NULL,
  `FIRST_NAME` varchar(100) NOT NULL,
  `LAST_NAME` varchar(100) NOT NULL,
  `ID_NUMBER` varchar(100) NOT NULL,
  `REGISTRATION_ID` varchar(100) NOT NULL,
  `NUMBER_OF_APPOINTMENTS` int(10) DEFAULT NULL,
  `DOCTOR_USERNAME` varchar(100) NOT NULL,
  `DOCTOR_PASSWORD` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`RECORD_ID`, `ROLE_CODE`, `FIRST_NAME`, `LAST_NAME`, `ID_NUMBER`, `REGISTRATION_ID`, `NUMBER_OF_APPOINTMENTS`, `DOCTOR_USERNAME`, `DOCTOR_PASSWORD`) VALUES
(2, 3, 'Eric', 'Perera', '8875462v', 'DOC_0125', 10, 'ericeric', 'eric123');

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `RECORD_ID` int(11) NOT NULL,
  `ROLE_CODE` int(10) DEFAULT NULL,
  `HOSPITAL_NAME` varchar(100) DEFAULT NULL,
  `HOSPITAL_ID` varchar(100) DEFAULT NULL,
  `HOSPITAL_ADDRESS` varchar(100) DEFAULT NULL,
  `HOSPITAL_TELEPHONE` varchar(100) DEFAULT NULL,
  `NUMBER_OF_APPOINTMENTS` varchar(100) DEFAULT NULL,
  `NUMBER_OF_DOCTORS` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`RECORD_ID`, `ROLE_CODE`, `HOSPITAL_NAME`, `HOSPITAL_ID`, `HOSPITAL_ADDRESS`, `HOSPITAL_TELEPHONE`, `NUMBER_OF_APPOINTMENTS`, `NUMBER_OF_DOCTORS`) VALUES
(1, 2, 'Lanka Hospitals', 'H-001', 'Baseline Rd, Colombo', '964578222', '10', '14'),
(2, 2, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `RECORD_ID` int(11) NOT NULL,
  `TRANSACTION_ID` varchar(100) DEFAULT NULL,
  `PAYMENT_METHOD` varchar(100) DEFAULT NULL,
  `USER_ID` varchar(100) DEFAULT NULL,
  `TOTAL_AMOUNT` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`RECORD_ID`, `TRANSACTION_ID`, `PAYMENT_METHOD`, `USER_ID`, `TOTAL_AMOUNT`) VALUES
(2, 'PAY_002', 'Credit Card', 'USR_085', '2750'),
(3, 'PAY_003', 'Cheque', 'USR_212', '1300');

-- --------------------------------------------------------

--
-- Table structure for table `pharmacy`
--

CREATE TABLE `pharmacy` (
  `RECORD_ID` int(11) NOT NULL,
  `ROLE_CODE` int(10) DEFAULT NULL,
  `PHARMACY_ID` varchar(100) DEFAULT NULL,
  `PHARMACY_NAME` varchar(100) DEFAULT NULL,
  `PHARMACY_ADDRESS` varchar(100) DEFAULT NULL,
  `PHARMACY_TELEPHONE` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pharmacy`
--

INSERT INTO `pharmacy` (`RECORD_ID`, `ROLE_CODE`, `PHARMACY_ID`, `PHARMACY_NAME`, `PHARMACY_ADDRESS`, `PHARMACY_TELEPHONE`) VALUES
(1, 1, 'PHA_001', 'Central Pharmacy', '38/Main Road, Colombo', '0112533274'),
(2, 1, 'PHA_002', 'Epic Pharmacy', '50/Main Road, Jaffna', '011369874'),
(3, 1, 'PHA_003', 'Uni Pharma', '50/Main Road, galle', '0118965472');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `RECORD_ID` int(11) NOT NULL,
  `ROLE_CODE` int(10) DEFAULT NULL,
  `FIRST_NAME` varchar(100) NOT NULL,
  `LAST_NAME` varchar(100) NOT NULL,
  `USER_EMAIL` varchar(100) DEFAULT NULL,
  `USER_ADDRESS` varchar(100) NOT NULL,
  `ID_NUMBER` varchar(100) NOT NULL,
  `TELEPHONE_NUMBER` varchar(100) NOT NULL,
  `USER_USERNAME` varchar(100) NOT NULL,
  `USER_PASSWORD` varchar(100) NOT NULL,
  `USER_APPOINTMENT` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`RECORD_ID`, `ROLE_CODE`, `FIRST_NAME`, `LAST_NAME`, `USER_EMAIL`, `USER_ADDRESS`, `ID_NUMBER`, `TELEPHONE_NUMBER`, `USER_USERNAME`, `USER_PASSWORD`, `USER_APPOINTMENT`) VALUES
(2, 4, 'Chamika', 'Dimantha', NULL, '40, Baseline Rd, Colombo', '961155vfgh', '0757730223', 'chamikamac', 'chamika123', 2),
(5, 4, 'John', 'Doe', 'Doe@gmail.com', 'Colombo', '456456v', '078456325', 'johndoe', 'john123', 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`RECORD_ID`);

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`appointmentId`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`RECORD_ID`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`RECORD_ID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`RECORD_ID`);

--
-- Indexes for table `pharmacy`
--
ALTER TABLE `pharmacy`
  ADD PRIMARY KEY (`RECORD_ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`RECORD_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `RECORD_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `appointmentId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pharmacy`
--
ALTER TABLE `pharmacy`
  MODIFY `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
