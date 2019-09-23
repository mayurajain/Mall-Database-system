-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 03, 2017 at 02:25 PM
-- Server version: 5.1.53
-- PHP Version: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `malldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE IF NOT EXISTS `complaint` (
  `custname` varchar(30) NOT NULL,
  `phoneno` varchar(10) NOT NULL,
  `shopname` varchar(30) NOT NULL,
  `complaint` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complaint`
--

INSERT INTO `complaint` (`custname`, `phoneno`, `shopname`, `complaint`) VALUES
('mayur', '9901897383', 'central', 'quality issue');

-- --------------------------------------------------------

--
-- Table structure for table `shoprequest`
--

CREATE TABLE IF NOT EXISTS `shoprequest` (
  `Name` varchar(30) NOT NULL,
  `category` varchar(30) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `mail` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shoprequest`
--

INSERT INTO `shoprequest` (`Name`, `category`, `phone`, `mail`) VALUES
('raj', 'clothing', '7899256911', 'raj@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `shops`
--

CREATE TABLE IF NOT EXISTS `shops` (
  `shopid` int(10) NOT NULL,
  `shopname` varchar(30) NOT NULL,
  `category` varchar(30) NOT NULL,
  `phonenumber` varchar(10) NOT NULL,
  `floor` varchar(10) NOT NULL,
  `sales` varchar(30) NOT NULL,
  `timings` varchar(30) NOT NULL,
  PRIMARY KEY (`shopid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shops`
--

INSERT INTO `shops` (`shopid`, `shopname`, `category`, `phonenumber`, `floor`, `sales`, `timings`) VALUES
(1, 'imagine', 'Electronics', '80315342', '1', 'Exchange offer', '11am-11pm'),
(2, '@home', 'Homedecors', '12356', '2', 'Stock clearance sale', '11am-11pm'),
(6, 'dominos', 'Eating', '342', '1', 'Winter sale', '11am-11pm'),
(3, 'central', 'Clothing', '122', '2', 'Upto 50% off', '9am-10pm'),
(4, 'zara', 'Clothing', '1234', '1', 'Upto 75% off', '9am-11pm'),
(5, 'saute and serve', 'Eating', '123', '0', 'Winter sale', '10am-10pm'),
(7, 'paapa johns', 'Eating', '343', '3', 'Upto 50% off', '9am-10pm'),
(8, 'life style', 'Lifestyle', '345', '1', 'Stock clearance sale', '9am-10pm'),
(9, 'nike', 'Clothing', '346', '0', 'Upto 75% off', '9am-10pm'),
(10, 'nautica', 'Clothing', '347', '3', 'Winter sale', '9am-10pm'),
(11, 'digital', 'Electronics', '348', '2', 'Exchange offer', '10am-11pm'),
(12, 'cafe noir', 'Eating', '349', '3', 'Upto 50% off', '11am-10pm'),
(13, 'up south', 'Eating', '350', '2', 'Upto 50% off', '11am-10pm'),
(14, 'Mi', 'Electronics', '351', '0', 'Exchange offer', '11am-10pm'),
(15, 'Dell', 'Electronics', '355', '3', 'Exchange offer', '10am-10pm'),
(16, 'Rayban', 'Lifestyle', '356', '0', 'Upto 75% off', '11am-11pm'),
(17, 'bagIt', 'Lifestyle', '357', '2', 'Upto 50% off', '11am-11pm'),
(18, 'Lord loffers', 'Lifestyle', '358', '3', 'Stock clearance sale', '11am-11pm'),
(19, 'coverItUp', 'HomeDecors', '3609', '2', 'Stock clearance sale', '9am-10pm'),
(20, 'homecenter', 'HomeDecors', '7892', '3', 'Upto 75% off', '10am-10pm');

-- --------------------------------------------------------

--
-- Table structure for table `subscription`
--

CREATE TABLE IF NOT EXISTS `subscription` (
  `Name` varchar(30) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Mail` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subscription`
--

INSERT INTO `subscription` (`Name`, `Phone`, `Mail`) VALUES
('mayur', '7353989392', 'mayurjainkm@gmail.com'),
('asha', '9901897383', 'ashalathahs@gmail.com'),
('sheetal', '7019411942', 'sheetalpatil@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE IF NOT EXISTS `userdetails` (
  `userid` int(10) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`userid`, `username`, `password`) VALUES
(1, 'Mayur', '12345'),
(2, 'asha', '67890');
