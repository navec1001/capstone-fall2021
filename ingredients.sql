-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2021 at 05:34 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `capstone`
--

-- --------------------------------------------------------

--
-- Table structure for table `ingredients`
--

CREATE TABLE `ingredients` (
  `Name` tinytext NOT NULL,
  `Description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ingredients`
--

INSERT INTO `ingredients` (`Name`, `Description`) VALUES
('Glycerin', 'A humectant that mimics the skin\'s Natural Moisturizing Factor, making it suitable for all ages and skin types'),
('Hyaluronic Acid', 'An incredibly strong humectant that can hold 1000x its molecular weight in water'),
('Hydrolyzed Hyaluronic Acid', 'A form of Hyaluronic Acid, which is an incredibly strong humectant that can hold 1000x its molecular weight in water'),
('Sodium Acetylated Hyaluronate', 'A form of Hyaluronic Acid, which is an incredibly strong humectant that can hold 1000x its molecular weight in water'),
('Sodium Hyaluronate', 'A form of Hyaluronic Acid, which is an incredibly strong humectant that can hold 1000x its molecular weight in water'),
('Glycerine', 'A form of Glycerin, a humectant that mimics the skin\'s Natural Moisturizing Factor, making it suitable for all ages and skin types'),
('Glycerol', 'A form of Glycerin, a humectant that mimics the skin\'s Natural Moisturizing Factor, making it suitable for all ages and skin types');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
