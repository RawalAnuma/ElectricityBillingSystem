-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2025 at 09:19 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `billingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `billrecords`
--

CREATE TABLE `billrecords` (
  `billid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `billdate` timestamp NOT NULL DEFAULT current_timestamp(),
  `billamount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL,
  `customername` varchar(255) NOT NULL,
  `housenumber` int(11) NOT NULL,
  `unitsconsumed` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `customername`, `housenumber`, `unitsconsumed`) VALUES
(1, 'Anuma', 7, 20),
(2, 'Aayush', 2, 30),
(3, 'Coco', 5, 45),
(4, 'aayu', 1, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billrecords`
--
ALTER TABLE `billrecords`
  ADD PRIMARY KEY (`billid`),
  ADD KEY `customerid` (`customerid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billrecords`
--
ALTER TABLE `billrecords`
  MODIFY `billid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `billrecords`
--
ALTER TABLE `billrecords`
  ADD CONSTRAINT `customerid` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
