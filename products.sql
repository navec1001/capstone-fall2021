-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2021 at 07:21 PM
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
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `Name` tinytext NOT NULL,
  `IngList` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`Name`, `IngList`) VALUES
('The Ordinary Hyaluronic Acid 2% + B5', 'Aqua (Water), Sodium Hyaluronate, Pentylene Glycol, Propanediol, Sodium Hyaluronate Crosspolymer, Panthenol, Ahnfeltia Concinna Extract, Glycerin, Trisodium Ethylenediamine Disuccinate, Citric Acid, Isoceteth-20, Ethoxydiglycol, Ethylhexylglycerin, Hexylene Glycol, 1,2-Hexanediol, Phenoxyethanol, Caprylyl Glycol.'),
('Peach & Lily Glass Skin Refining Serum', 'Water (Aqua), Propanediol, Butylene Glycol, Niacinamide, 1,2-Hexanediol, Prunus Persica (Peach) Fruit Extract, Dioscorea Japonica Root Extract, Sodium Hyaluronate, Adenosine, Hydrolyzed Sodium Hyaluronate, Madecassoside, Hydrolyzed Hyaluronic Acid, Sodium Acetylated Hyaluronate, Acetyl Octapeptide-3, Ethylhexylglycerin, Hydrolyzed Corn Starch, Sodium Carbomer, Beta-Glucan, Saccharide Isomerate, Phytic Acid, Sucrose, Asiaticoside, Caprylyl Glycol.'),
('Cetaphil Moisturizing Cream', 'Water, Glycerin, Petrolatum, Dicaprylyl Ether, Dimethicone, Glyceryl Stearate, Cetyl Alcohol, Helianthus Annuus (Sunflower) Seed Oil, Peg-30 Stearate, Panthenol, Niacinamide, Prunus Amygdalus Dulcis (Sweet Almond) Oil, Tocopheryl Acetate, Pantolactone, Dimethiconol, Acrylates/C10-30 Alkyl Acrylate Crosspolymer, Carbomer, Propylene Glycol, Disodium Edta, Benzyl Alcohol, Phenoxyethanol, Sodium Hydroxide, Citric Acid.'),
('CeraVe Hydrating Hyaluronic Acid Serum', 'Aqua/Water/Eau, Glycerin, Cetearyl Ethylhexanoate, Dimethicone, Alcohol Denat., Ammonium Polyacryloyldimethyl Taurate, Sodium Hyaluronate, Panthenol, Ceramide Np, Ceramide Ap, Ceramide Eop, Carbomer, Cetearyl Alcohol, Behentrimonium Methosulfate, Sodium Hydroxide, Sodium Lauroyl Lactylate, Cholesterol, Phenoxyethanol, Disodium Edta, Isopropyl Myristate, Caprylyl Glycol, Citric Acid, Xanthan Gum, Phytosphingosine, Ethylhexylglycerin.');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
