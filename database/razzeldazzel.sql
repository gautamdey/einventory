CREATE DATABASE  IF NOT EXISTS `razzeldazzel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `razzeldazzel`;
-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: razzeldazzel
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.9-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_catagory`
--

DROP TABLE IF EXISTS `tbl_catagory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_catagory` (
  `catagoryid` mediumint(9) NOT NULL AUTO_INCREMENT,
  `catagoryname` varchar(100) NOT NULL,
  `catdesc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`catagoryid`),
  UNIQUE KEY `catagoryid_UNIQUE` (`catagoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_catagory`
--

LOCK TABLES `tbl_catagory` WRITE;
/*!40000 ALTER TABLE `tbl_catagory` DISABLE KEYS */;
INSERT INTO `tbl_catagory` VALUES (1,'abc','abc'),(2,'xyz','xyz'),(3,'aaa','aaa'),(4,'test2','test2'),(5,'aa','aa'),(6,'rrrr','rrrr');
/*!40000 ALTER TABLE `tbl_catagory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_catalog`
--

DROP TABLE IF EXISTS `tbl_catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_catalog` (
  `catalogid` mediumint(9) NOT NULL AUTO_INCREMENT,
  `catagoryid` mediumint(9) DEFAULT NULL,
  `catalogname` varchar(50) NOT NULL,
  `catalogdesc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`catalogid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_catalog`
--

LOCK TABLES `tbl_catalog` WRITE;
/*!40000 ALTER TABLE `tbl_catalog` DISABLE KEYS */;
INSERT INTO `tbl_catalog` VALUES (2,1,'abc','abc'),(4,1,'aaaa','aaaa');
/*!40000 ALTER TABLE `tbl_catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer`
--

DROP TABLE IF EXISTS `tbl_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customer` (
  `custid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `mname` varchar(20) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `houseno` varchar(10) DEFAULT NULL,
  `apt` varchar(10) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `mphone` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`custid`),
  UNIQUE KEY `custid_UNIQUE` (`custid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer`
--

LOCK TABLES `tbl_customer` WRITE;
/*!40000 ALTER TABLE `tbl_customer` DISABLE KEYS */;
INSERT INTO `tbl_customer` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'c1','c1','','asas','22','','askjasj','alskjasjf','aslkfjasfkj','','asdasd','asdasd'),(4,'c3','c1','','asas','22','','askjasj','alskjasjf','aslkfjasfkj','','asdasd','asdasd');
/*!40000 ALTER TABLE `tbl_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_invoice`
--

DROP TABLE IF EXISTS `tbl_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_invoice` (
  `invoiceid` int(11) NOT NULL AUTO_INCREMENT,
  `invoicenum` varchar(100) NOT NULL,
  `invoicedate` date DEFAULT NULL,
  `supplierid` int(11) NOT NULL,
  `importduty` decimal(5,2) DEFAULT NULL,
  `shippingcost` decimal(7,2) DEFAULT NULL,
  `itemcount` int(11) DEFAULT NULL,
  `netamount` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`invoiceid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_invoice`
--

LOCK TABLES `tbl_invoice` WRITE;
/*!40000 ALTER TABLE `tbl_invoice` DISABLE KEYS */;
INSERT INTO `tbl_invoice` VALUES (1,'100',NULL,100,NULL,200.00,17,NULL),(2,'2','2015-01-01',1,NULL,100.00,12,NULL),(3,'4','2015-01-01',200,NULL,NULL,13,NULL),(5,'112','2015-01-01',101,NULL,400.00,4,NULL),(6,'113','2015-01-01',101,NULL,560.00,12,NULL),(7,'114','2015-01-01',101,NULL,240.00,56,NULL),(8,'115','2015-01-01',101,NULL,350.00,35,NULL),(9,'116','2015-01-01',101,NULL,500.00,10,NULL),(10,'117','2015-01-01',100,NULL,400.00,20,NULL),(11,'119','2015-01-01',12,NULL,300.90,14,NULL),(12,'200','2014-02-02',100,NULL,10.30,12,NULL),(13,'test1','2014-02-02',1,NULL,100.20,19,NULL),(14,'10000','2014-02-02',1,10.20,100.20,10,1000.28);
/*!40000 ALTER TABLE `tbl_invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_invoice_items`
--

DROP TABLE IF EXISTS `tbl_invoice_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_invoice_items` (
  `itemcode` varchar(50) NOT NULL,
  `itemname` varchar(50) DEFAULT NULL,
  `itemdesc` varchar(45) DEFAULT NULL,
  `catagoryid` varchar(50) DEFAULT NULL,
  `catalogid` varchar(50) DEFAULT NULL,
  `shippingcost` decimal(5,2) unsigned zerofill DEFAULT NULL,
  `additionalcost` decimal(7,2) DEFAULT NULL,
  `costprice` decimal(11,2) unsigned zerofill DEFAULT NULL,
  `invoiceid` varchar(100) NOT NULL,
  `color` varchar(20) DEFAULT NULL,
  `embroidery` varchar(45) DEFAULT NULL,
  `stitching` decimal(7,2) unsigned zerofill DEFAULT NULL,
  `stitchingdetail` varchar(20) DEFAULT NULL,
  `discount` decimal(4,2) unsigned zerofill DEFAULT NULL,
  `netcostprice` decimal(11,2) unsigned zerofill DEFAULT NULL,
  `received` varchar(1) NOT NULL DEFAULT 'N',
  `invoiceitemid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`invoiceitemid`),
  KEY `invoiceid_idx` (`invoiceid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_invoice_items`
--

LOCK TABLES `tbl_invoice_items` WRITE;
/*!40000 ALTER TABLE `tbl_invoice_items` DISABLE KEYS */;
INSERT INTO `tbl_invoice_items` VALUES ('12','abc','abc','1','2',010.00,0.00,000000010.00,'1',NULL,NULL,NULL,NULL,NULL,000000100.00,'N',1),('123','abc','something','4','4',012.00,21.00,000001200.00,'1','black','excelent',00001.00,'something',NULL,000000111.00,'N',2),('abc','aaa','aaa','2','1',010.00,10.00,000000010.00,'12',NULL,NULL,NULL,NULL,NULL,000000789.76,'N',3),('abc1','aaa','aaa','2','1',010.00,10.00,000000010.00,'12',NULL,NULL,NULL,NULL,NULL,000006789.54,'N',4),('abcdef','abcd','something','1','2',012.00,1.00,000001200.00,'3','red','some work',00010.00,'some',02.00,000001189.00,'Y',5),('test1','test1','asas','1','2',012.00,10.00,000000100.00,'6','black','black',00000.00,'asas',00.00,000000122.00,'N',6),('www','www','www','1','2',012.00,12.00,000000100.00,'1',NULL,NULL,NULL,NULL,NULL,000003000.00,'N',7),('www','www','amasm','1','2',012.00,0.00,000000000.00,'3','black','amadd',00010.00,'asfas',00.00,000000012.00,'Y',8),('xyz','xyz','xyz','1','abc',NULL,NULL,NULL,'12',NULL,NULL,NULL,NULL,NULL,000005460.00,'N',9),('xyz1','xyz1','asdasd','2','2',100.00,10.00,000001000.00,'2',NULL,NULL,NULL,NULL,NULL,000001230.00,'Y',10),('xyz1','xyz1','ashashd','1','2',012.00,10.00,000007000.00,'2','asasdmn','asdmnasdn',00010.00,'asdadsh',02.00,000006882.00,'Y',11),('100','100','asfasf','1','2',012.00,100.00,000002390.00,'5','ass','asad',00010.00,'asad',00.00,000002502.00,'N',12),('33','33','sdfsdf','1','2',012.00,3456.00,000012345.00,'5','sdfsf','sdfsdf',00034.00,'sdfsdf',10.00,000014578.50,'N',13);
/*!40000 ALTER TABLE `tbl_invoice_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_item_master`
--

DROP TABLE IF EXISTS `tbl_item_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_item_master` (
  `itemid` bigint(20) NOT NULL,
  `itemcode` varchar(50) NOT NULL,
  `itemname` varchar(50) DEFAULT NULL,
  `itemdesc` varchar(45) DEFAULT NULL,
  `categoryid` varchar(50) DEFAULT NULL,
  `catalogid` varchar(50) DEFAULT NULL,
  `costprice` decimal(7,2) DEFAULT NULL,
  `supplierid` mediumint(15) NOT NULL,
  PRIMARY KEY (`itemid`),
  KEY `FK_SUPPLIERID` (`supplierid`),
  CONSTRAINT `fk_supplierid` FOREIGN KEY (`supplierid`) REFERENCES `tbl_supplier` (`supplierid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_item_master`
--

LOCK TABLES `tbl_item_master` WRITE;
/*!40000 ALTER TABLE `tbl_item_master` DISABLE KEYS */;
INSERT INTO `tbl_item_master` VALUES (0,'test1','test1','test1','1','11',100.00,1);
/*!40000 ALTER TABLE `tbl_item_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_item_price`
--

DROP TABLE IF EXISTS `tbl_item_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_item_price` (
  `priceid` int(11) NOT NULL AUTO_INCREMENT,
  `stockid` int(11) NOT NULL,
  `itemid` int(11) DEFAULT NULL,
  `itemcode` varchar(45) NOT NULL,
  `netcost` decimal(11,2) DEFAULT NULL,
  `sellprice` decimal(11,2) DEFAULT NULL,
  `margin` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`priceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_item_price`
--

LOCK TABLES `tbl_item_price` WRITE;
/*!40000 ALTER TABLE `tbl_item_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_item_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_poitems`
--

DROP TABLE IF EXISTS `tbl_poitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_poitems` (
  `itemid` bigint(20) NOT NULL AUTO_INCREMENT,
  `itemcode` varchar(50) NOT NULL,
  `itemname` varchar(50) NOT NULL,
  `itemdesc` varchar(45) DEFAULT NULL,
  `catagoryid` varchar(50) NOT NULL,
  `catalogid` varchar(50) DEFAULT NULL,
  `unitcost` decimal(11,2) unsigned zerofill NOT NULL DEFAULT '000000000.00',
  `stitchingcost` decimal(11,2) unsigned zerofill NOT NULL DEFAULT '000000000.00',
  `quantity` int(11) unsigned zerofill DEFAULT '00000000000',
  `costprice` decimal(11,2) unsigned zerofill DEFAULT '000000000.00',
  `poid` int(11) NOT NULL,
  `embroidery` varchar(45) DEFAULT NULL,
  `stitchingdetail` varchar(200) DEFAULT NULL,
  `discount` decimal(4,2) unsigned zerofill DEFAULT '00.00',
  `netcostprice` decimal(11,2) unsigned zerofill DEFAULT '000000000.00',
  `received` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`itemid`),
  UNIQUE KEY `itemcode_UNIQUE` (`itemcode`),
  KEY `poid_idx` (`poid`),
  CONSTRAINT `fk_poid` FOREIGN KEY (`poid`) REFERENCES `tbl_purchaseorder` (`poid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_poitems`
--

LOCK TABLES `tbl_poitems` WRITE;
/*!40000 ALTER TABLE `tbl_poitems` DISABLE KEYS */;
INSERT INTO `tbl_poitems` VALUES (2,'0','test1','test1','1','1',000000100.00,000000010.00,00000000002,000000210.00,2,'abc','abc',00.00,000000210.00,'N');
/*!40000 ALTER TABLE `tbl_poitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_purchaseorder`
--

DROP TABLE IF EXISTS `tbl_purchaseorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_purchaseorder` (
  `poid` int(11) NOT NULL AUTO_INCREMENT,
  `ponum` varchar(100) NOT NULL,
  `podate` date NOT NULL,
  `supplierid` int(11) NOT NULL,
  `importduty` decimal(10,2) DEFAULT '0.00',
  `shippingcost` decimal(10,2) NOT NULL DEFAULT '0.00',
  `itemcount` int(11) NOT NULL DEFAULT '0',
  `netamount` decimal(12,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`poid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_purchaseorder`
--

LOCK TABLES `tbl_purchaseorder` WRITE;
/*!40000 ALTER TABLE `tbl_purchaseorder` DISABLE KEYS */;
INSERT INTO `tbl_purchaseorder` VALUES (1,'123','2015-12-12',2,10.00,10.00,2,10.00),(2,'10','2015-12-12',1,10.00,10.00,10,0.00),(3,'100','2016-02-11',2,100.00,100.00,10,1000.00),(4,'100','2016-02-11',1,100.00,100.00,20,1000.00);
/*!40000 ALTER TABLE `tbl_purchaseorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_stock_master`
--

DROP TABLE IF EXISTS `tbl_stock_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_stock_master` (
  `itemid` bigint(20) NOT NULL,
  `itemcode` varchar(50) NOT NULL,
  `itemname` varchar(50) DEFAULT NULL,
  `itemdesc` varchar(45) DEFAULT NULL,
  `catagoryid` varchar(50) DEFAULT NULL,
  `catalogid` varchar(50) DEFAULT NULL,
  `shippingcost` decimal(5,2) DEFAULT NULL,
  `additionalcost` decimal(5,2) DEFAULT NULL,
  `costprice` decimal(7,2) DEFAULT NULL,
  `totalcost` decimal(9,2) DEFAULT NULL,
  `suppliername` varchar(50) NOT NULL,
  `invoiceid` varchar(100) NOT NULL,
  `stockdate` datetime DEFAULT NULL,
  `stockid` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(45) DEFAULT NULL,
  `embroidery` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`stockid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_stock_master`
--

LOCK TABLES `tbl_stock_master` WRITE;
/*!40000 ALTER TABLE `tbl_stock_master` DISABLE KEYS */;
INSERT INTO `tbl_stock_master` VALUES (0,'test1','test1','asas','1','2',1.00,10.00,2.00,3.00,'0','6','2015-04-16 11:36:50',8,'black','black'),(0,'xyz1','xyz1','asdasd','2','2',1.67,0.17,16.67,20.50,'0','2','2015-04-22 23:10:27',13,NULL,NULL),(0,'xyz1','xyz1','ashashd','1','2',0.20,0.17,116.67,114.70,'0','2','2015-04-22 23:10:27',14,'asasdmn','asdmnasdn'),(0,'abcdef','abcd','something','1','2',0.20,0.02,20.00,19.82,'0','3','2015-04-29 16:02:26',15,'red','some work'),(0,'www','www','amasm','1','2',0.20,0.00,0.00,0.20,'0','3','2015-04-29 16:02:26',16,'black','amadd'),(0,'001','abc','abc',NULL,'abc',NULL,NULL,1.84,1.80,'0','0','2016-02-08 12:00:41',17,NULL,'abc'),(0,'001','abc','abc',NULL,'abc',NULL,NULL,1.84,1.80,'0','0','2016-02-08 12:00:51',18,NULL,'abc'),(0,'001','abc','abc',NULL,'abc',NULL,NULL,1.84,1.80,'0','0','2016-02-08 12:11:46',19,NULL,'abc');
/*!40000 ALTER TABLE `tbl_stock_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_supplier`
--

DROP TABLE IF EXISTS `tbl_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_supplier` (
  `supplierid` mediumint(9) NOT NULL AUTO_INCREMENT,
  `suppliername` varchar(100) DEFAULT NULL,
  `accountnumber` varchar(45) DEFAULT NULL,
  `accountname` varchar(45) DEFAULT NULL,
  `ifcscode` varchar(45) DEFAULT NULL,
  `bankname` varchar(45) DEFAULT NULL,
  `bankbranch` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contactperson` varchar(45) DEFAULT NULL,
  `phone1` varchar(45) DEFAULT NULL,
  `phone2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`supplierid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_supplier`
--

LOCK TABLES `tbl_supplier` WRITE;
/*!40000 ALTER TABLE `tbl_supplier` DISABLE KEYS */;
INSERT INTO `tbl_supplier` VALUES (1,'abc','abcdmdkek','anacdefk','ajsdasd','aslasfja','lsfafljas','abc@gmail.com','abc','100289','10029746'),(2,'Test1','12345','abcdefg','134','abc','abc','test1@gmail.com','Test1','1200','1200');
/*!40000 ALTER TABLE `tbl_supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-16 10:12:37
