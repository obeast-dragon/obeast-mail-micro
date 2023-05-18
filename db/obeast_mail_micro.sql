-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: obeast_mail_micro
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dept` (
  `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门名称',
  `sort_order` int NOT NULL DEFAULT '0' COMMENT '排序值',
  `del_flag` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '0' COMMENT '删除标记  -1：已删除  0：正常',
  `parent_id` bigint DEFAULT NULL COMMENT '父部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='部门管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (1,'总经办',0,'0',0,'2020-03-13 13:13:16',' ','2020-03-13 13:14:31',' '),(2,'行政中心',0,'0',1,'2020-03-13 13:13:30',' ','2021-12-31 06:59:56',' '),(3,'技术中心',0,'0',1,'2020-03-13 13:14:55',' ','2021-12-31 06:59:56',' '),(4,'运营中心',0,'0',1,'2020-03-13 13:15:15',' ','2021-12-31 06:59:56',' '),(5,'研发中心',0,'0',3,'2020-03-13 13:15:34',' ','2021-12-31 06:59:56',' '),(6,'产品中心',0,'0',3,'2020-03-13 13:15:49',' ','2021-12-31 06:59:56',' '),(7,'测试中心',0,'0',3,'2020-03-13 13:16:02',' ','2021-12-31 06:59:56',' '),(8,'测试部门',0,'1',0,'2023-05-15 00:49:31','admin','2023-05-15 01:00:51','admin');
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept_relation`
--

DROP TABLE IF EXISTS `sys_dept_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dept_relation` (
  `ancestor` bigint NOT NULL COMMENT '祖先节点',
  `descendant` bigint NOT NULL COMMENT '后代节点',
  PRIMARY KEY (`ancestor`,`descendant`),
  KEY `idx1` (`ancestor`),
  KEY `idx2` (`descendant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='部门关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept_relation`
--

LOCK TABLES `sys_dept_relation` WRITE;
/*!40000 ALTER TABLE `sys_dept_relation` DISABLE KEYS */;
INSERT INTO `sys_dept_relation` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(2,2),(3,3),(3,5),(3,6),(3,7),(4,4),(5,5),(6,6),(7,7);
/*!40000 ALTER TABLE `sys_dept_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dict_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标识',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `system_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '是否是系统内置',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `sys_dict_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES (1,'dict_type','字典类型',NULL,'0','0','2019-05-16 14:16:20','','admin','2021-12-29 12:29:18'),(2,'log_type','日志类型',NULL,'0','0','2020-03-13 14:21:01','','admin','2021-12-29 12:30:14'),(3,'ds_type','驱动类型',NULL,'0','0','2021-10-15 16:24:35','','admin','2021-12-29 12:30:18'),(4,'param_type','参数配置','检索、原文、报表、安全、文档、消息、其他','1','0','2022-03-25 20:51:26','admin','admin','2022-03-25 20:51:26'),(5,'status_type','租户状态','租户状态','1','0','2022-03-25 20:56:51','admin','admin','2022-03-25 20:56:51'),(6,'menu_type_status','菜单类型',NULL,'1','0','2022-09-18 17:12:05','admin','admin','2022-09-18 17:12:05'),(7,'dict_css_type','字典项展示样式',NULL,'1','0','2022-09-28 21:37:23','admin','admin','2022-09-28 21:37:23'),(8,'keepalive_status','菜单是否开启缓冲',NULL,'1','0','2022-09-28 21:46:12','admin','admin','2022-09-28 21:46:12'),(9,'user_lock_flag','用户锁定标记',NULL,'1','0','2022-09-28 21:51:39','admin','admin','2022-09-28 21:51:39');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_item`
--

DROP TABLE IF EXISTS `sys_dict_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dict_id` bigint NOT NULL COMMENT '字典ID',
  `dict_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典标识',
  `value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '值',
  `label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签',
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典类型',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `sort_order` int NOT NULL DEFAULT '0' COMMENT '排序（升序）',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ' ' COMMENT '备注',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `sys_dict_value` (`value`) USING BTREE,
  KEY `sys_dict_label` (`label`) USING BTREE,
  KEY `sys_dict_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_item`
--

LOCK TABLES `sys_dict_item` WRITE;
/*!40000 ALTER TABLE `sys_dict_item` DISABLE KEYS */;
INSERT INTO `sys_dict_item` VALUES (1,1,'dict_type','1','系统类',NULL,'系统类字典',0,' ','0','2019-05-16 14:20:40',NULL,NULL,'2019-05-16 14:20:40'),(2,1,'dict_type','0','业务类',NULL,'业务类字典',0,' ','0','2019-05-16 14:20:59',NULL,NULL,'2019-05-16 14:20:59'),(3,2,'log_type','0','正常',NULL,'正常',0,' ','0','2020-03-13 14:23:22',NULL,NULL,'2020-03-13 14:23:22'),(4,2,'log_type','9','异常',NULL,'异常',0,' ','0','2020-03-13 14:23:35',NULL,NULL,'2020-03-13 14:23:35'),(5,3,'ds_type','com.mysql.cj.jdbc.Driver','MYSQL8',NULL,'MYSQL8',0,' ','0',NULL,NULL,NULL,NULL),(6,3,'ds_type','com.mysql.jdbc.Driver','MYSQL5',NULL,'MYSQL5',0,' ','0',NULL,NULL,NULL,NULL),(7,3,'ds_type','oracle.jdbc.OracleDriver','Oracle',NULL,'Oracle',0,' ','0',NULL,NULL,NULL,NULL),(8,3,'ds_type','org.mariadb.jdbc.Driver','mariadb',NULL,'mariadb',0,' ','0',NULL,NULL,NULL,NULL),(9,3,'ds_type','com.microsoft.sqlserver.jdbc.SQLServerDriver','sqlserver2005+',NULL,'sqlserver2005+',0,' ','0',NULL,NULL,NULL,NULL),(10,3,'ds_type','com.microsoft.jdbc.sqlserver.SQLServerDriver','sqlserver2000',NULL,'sqlserver2000',0,' ','0',NULL,NULL,NULL,NULL),(11,3,'ds_type','com.ibm.db2.jcc.DB2Driver','db2',NULL,'db2',0,' ','0',NULL,NULL,NULL,NULL),(12,3,'ds_type','org.postgresql.Driver','postgresql',NULL,'postgresql',0,' ','0',NULL,NULL,NULL,NULL),(13,4,'param_type','1','检索',NULL,'检索',0,'检索','0','2022-03-25 20:51:51','admin','admin','2022-03-25 20:51:51'),(14,4,'param_type','2','原文',NULL,'原文',1,'原文','0','2022-03-25 20:52:06','admin','admin','2022-03-25 20:52:06'),(15,4,'param_type','3','报表',NULL,'报表',2,'报表','0','2022-03-25 20:52:16','admin','admin','2022-03-25 20:52:16'),(16,4,'param_type','4','安全',NULL,'安全',3,'安全','0','2022-03-25 20:52:32','admin','admin','2022-03-25 20:52:32'),(17,4,'param_type','5','文档',NULL,'文档',4,'文档','0','2022-03-25 20:52:52','admin','admin','2022-03-25 20:52:52'),(18,4,'param_type','6','消息',NULL,'消息',5,'消息','0','2022-03-25 20:53:07','admin','admin','2022-03-25 20:53:07'),(19,4,'param_type','9','其他',NULL,'其他',6,'其他','0','2022-03-25 20:54:50','admin','admin','2022-03-25 20:54:50'),(20,4,'param_type','0','默认',NULL,'默认',7,'默认','0','2022-03-25 20:55:23','admin','admin','2022-03-25 20:55:23'),(21,5,'status_type','0','正常',NULL,'状态正常',0,'状态正常','0','2022-03-25 20:57:12','admin','admin','2022-03-25 20:57:12'),(22,5,'status_type','9','冻结',NULL,'状态冻结',1,'状态冻结','0','2022-03-25 20:57:34','admin','admin','2022-03-25 20:57:34'),(23,6,'menu_type_status','0','菜单',NULL,'菜单',0,' ','0','2022-09-18 17:15:52','admin','admin','2022-09-18 17:15:52'),(24,6,'menu_type_status','1','按钮','success','按钮',1,' ','0','2022-09-18 17:16:06','admin','admin','2022-09-18 17:16:06'),(25,7,'dict_css_type','success','success','success','success',2,' ','0','2022-09-28 21:41:49','admin','admin','2022-09-28 21:41:49'),(26,7,'dict_css_type','info','info','info','info',3,' ','0','2022-09-28 21:41:59','admin','admin','2022-09-28 21:41:59'),(27,7,'dict_css_type','warning','warning','warning','warning',4,' ','0','2022-09-28 21:42:09','admin','admin','2022-09-28 21:42:09'),(28,7,'dict_css_type','danger','danger','danger','danger',5,' ','0','2022-09-28 21:42:19','admin','admin','2022-09-28 21:42:19'),(29,8,'keepalive_status','0','否','info','不开启缓冲',0,' ','0','2022-09-28 21:46:32','admin','admin','2022-09-28 21:46:32'),(30,8,'keepalive_status','1','是',NULL,'开启缓冲',1,' ','0','2022-09-28 21:46:54','admin','admin','2022-09-28 21:46:54'),(31,9,'user_lock_flag','0','正常',NULL,'正常状态',0,' ','0','2022-09-28 21:51:55','admin','admin','2022-09-28 21:51:55'),(32,9,'user_lock_flag','9','锁定','info','已锁定',9,' ','0','2022-09-28 21:52:13','admin','admin','2022-09-28 21:52:13');
/*!40000 ALTER TABLE `sys_dict_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_file`
--

DROP TABLE IF EXISTS `sys_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_file` (
  `id` bigint NOT NULL COMMENT '文件ID',
  `file_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件名称',
  `bucket_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件存储桶名称',
  `original` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '原始文件名',
  `type` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件类型',
  `file_size` bigint DEFAULT NULL COMMENT '文件大小',
  `del_flag` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '0' COMMENT '删除标志：0-正常，1-删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='文件管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_file`
--

LOCK TABLES `sys_file` WRITE;
/*!40000 ALTER TABLE `sys_file` DISABLE KEYS */;
INSERT INTO `sys_file` VALUES (1657993945164140545,'472c9994b9d34f5c8ebd98ee631105e5.jpg','obeast-admin','3f878fc75ad84405bffa29a309238655.jpg','jpg',799811,'0','2023-05-15 14:18:55','2023-05-15 14:18:55','admin','admin'),(1658147402256859138,'d4c3642575ba4f21ae89863bfc43951b.png','obeast-admin','星空ikun.png','png',2010753,'0','2023-05-16 00:28:42','2023-05-16 00:28:42','admin','admin'),(1658152087365730305,'f4ad24eacb6d485ba6dd3cfdab874429.jpg','obeast-admin','02.jpg','jpg',41409,'1','2023-05-16 00:47:19','2023-05-16 01:04:24','admin','admin'),(1659081926553702401,'93e6acce0ccb4d3bbf53533e0bd98bc3.jpg','obeast-mail','02.jpg','jpg',41409,'0','2023-05-18 14:22:10','2023-05-18 14:22:10','admin','admin');
/*!40000 ALTER TABLE `sys_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '' COMMENT '日志标题',
  `service_id` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务ID',
  `remote_addr` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求URI',
  `method` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作方式',
  `params` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci COMMENT '操作提交的数据',
  `time` bigint DEFAULT NULL COMMENT '执行时间',
  `del_flag` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '0' COMMENT '删除标记',
  `exception` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`request_uri`),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1659140439380332546 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES (1657789242567880705,'0','删除用户信息','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/user/3','DELETE','',123,'0',NULL,'2023-05-15 00:45:30','2023-05-15 00:45:30','admin','admin'),(1657790252052967426,'0','添加部门','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/dept/add','POST','',227,'0',NULL,'2023-05-15 00:49:31','2023-05-15 00:49:31','admin','admin'),(1657791203597938690,'0','编辑部门','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/dept/update','PUT','',22,'0',NULL,'2023-05-15 00:53:18','2023-05-15 00:53:18','admin','admin'),(1657791295277035521,'0','编辑部门','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/dept/update','PUT','',17,'0',NULL,'2023-05-15 00:53:40','2023-05-15 00:53:40','admin','admin'),(1657792612863111170,'0','编辑部门','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/dept/update','PUT','',107,'0',NULL,'2023-05-15 00:58:54','2023-05-15 00:58:54','admin','admin'),(1657792635210362881,'0','编辑部门','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/dept/update','PUT','',159,'0',NULL,'2023-05-15 00:58:59','2023-05-15 00:58:59','admin','admin'),(1657792666860580865,'0','删除部门','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/dept/8','DELETE','',17,'0',NULL,'2023-05-15 00:59:07','2023-05-15 00:59:07','admin','admin'),(1657792706878435329,'0','删除部门','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/dept/8','DELETE','',13,'0',NULL,'2023-05-15 00:59:16','2023-05-15 00:59:16','admin','admin'),(1657792725723443202,'0','删除部门','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/dept/8','DELETE','',12,'0',NULL,'2023-05-15 00:59:21','2023-05-15 00:59:21','admin','admin'),(1657792836629229569,'0','删除部门','test','127.0.0.1','Apifox/1.0.0 (https://www.apifox.cn)','/dept/8','DELETE','',14,'1',NULL,'2023-05-15 00:59:47','2023-05-16 22:59:25','admin','admin'),(1657793103647010818,'0','删除部门','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/dept/8','DELETE','',94,'0',NULL,'2023-05-15 01:00:51','2023-05-15 01:00:51','admin','admin'),(1657794864520687618,'0','新增岗位信息表','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/post/add','POST','',103,'0',NULL,'2023-05-15 01:07:51','2023-05-15 01:07:51','admin','admin'),(1657795522120445954,'0','通过id删除岗位信息表','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/post/4','DELETE','id%5B%5D=%5B4%5D',95,'0',NULL,'2023-05-15 01:10:27','2023-05-15 01:10:27','admin','admin'),(1657795945279582209,'0','新增岗位信息表','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/post/add','POST','',72,'0',NULL,'2023-05-15 01:12:08','2023-05-15 01:12:08','admin','admin'),(1657795982147514369,'0','修改岗位信息表','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/post/update','PUT','',82,'0',NULL,'2023-05-15 01:12:17','2023-05-15 01:12:17','admin','admin'),(1657989557301362689,'0','登录成功','test','127.0.0.1','Apifox/1.0.0 (https://www.apifox.cn)','/oauth2/token','POST','password=%5B1234qwer%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',2068,'0',NULL,'2023-05-15 14:01:29','2023-05-15 14:01:29','admin','admin'),(1658016696105029633,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B95001684136956248%5D&password=%5B1234qwer%5D&code=%5B0%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',174,'0',NULL,'2023-05-15 15:49:19','2023-05-15 15:49:19','admin','admin'),(1658098144513658881,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B33761684156320208%5D&password=%5B1234qwer%5D&code=%5B36%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',1054,'0',NULL,'2023-05-15 21:12:58','2023-05-15 21:12:58','admin','admin'),(1658156388297326593,'0','删除文件管理','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/sysFile/1658152087365730305','DELETE','',141,'0',NULL,'2023-05-16 01:04:25','2023-05-16 01:04:25','admin','admin'),(1658297284007411713,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B87891684203848603%5D&password=%5B1234qwer%5D&code=%5B0%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',211,'0',NULL,'2023-05-16 10:24:17','2023-05-16 10:24:17','admin','admin'),(1658299597304479746,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B27521684204404556%5D&password=%5B1234qwer%5D&code=%5B1%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',612,'0',NULL,'2023-05-16 10:33:28','2023-05-16 10:33:28','admin','admin'),(1658300556042682370,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B47461684204630297%5D&password=%5B1234qwer%5D&code=%5B-3%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',159,'0',NULL,'2023-05-16 10:37:17','2023-05-16 10:37:17','admin','admin'),(1658301261046464514,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B13241684204799191%5D&password=%5B1234qwer%5D&code=%5B21%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',152,'0',NULL,'2023-05-16 10:40:05','2023-05-16 10:40:05','admin','admin'),(1658303879403651073,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B10801684205426013%5D&password=%5B1234qwer%5D&code=%5B8%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',156,'0',NULL,'2023-05-16 10:50:29','2023-05-16 10:50:29','admin','admin'),(1658304325291720705,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B73721684205533253%5D&password=%5B1234qwer%5D&code=%5B6%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',148,'0',NULL,'2023-05-16 10:52:16','2023-05-16 10:52:16','admin','admin'),(1658304456502132738,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B34901684205563198%5D&password=%5B1234qwer%5D&code=%5B27%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',141,'0',NULL,'2023-05-16 10:52:47','2023-05-16 10:52:47','admin','admin'),(1658304521664839682,'0','退出成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/token/logout','DELETE','Bearer 9fc9e913-5fc8-4212-ac6b-ad69853333ee',0,'0',NULL,'2023-05-16 10:53:02','2023-05-16 10:53:02','admin','admin'),(1658306337936883714,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B91821684206012413%5D&password=%5B1234qwer%5D&code=%5B0%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',127,'0',NULL,'2023-05-16 11:00:15','2023-05-16 11:00:15','admin','admin'),(1658306519076290561,'0','退出成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/token/logout','DELETE','Bearer 471daf60-0557-4476-979b-8838054ea723',0,'0',NULL,'2023-05-16 11:00:59','2023-05-16 11:00:59','admin','admin'),(1658306582880043010,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B53121684206070246%5D&password=%5B1234qwer%5D&code=%5B9%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',117,'0',NULL,'2023-05-16 11:01:14','2023-05-16 11:01:14','admin','admin'),(1658317262039400449,'0','登录成功','test','127.0.0.1','Apifox/1.0.0 (https://www.apifox.cn)','/oauth2/token','POST','password=%5B1234qwer%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',161,'0',NULL,'2023-05-16 11:43:40','2023-05-16 11:43:40','admin','admin'),(1658378665404174338,'0','编辑终端','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/client/update','PUT','',93,'0',NULL,'2023-05-16 15:47:40','2023-05-16 15:47:40','admin','admin'),(1658382640048279553,'0','添加终端','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/client/add','POST','',78,'0',NULL,'2023-05-16 16:03:27','2023-05-16 16:03:27','admin','admin'),(1658391489899696130,'0','编辑终端','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/client/update','PUT','',193,'0',NULL,'2023-05-16 16:38:37','2023-05-16 16:38:37','admin','admin'),(1658391973318397953,'0','添加终端','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/client/add','POST','',162,'0',NULL,'2023-05-16 16:40:33','2023-05-16 16:40:33','admin','admin'),(1658392032281923585,'0','删除终端','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/client/test3','DELETE','id%5B%5D=%5Btest3%5D',180,'0',NULL,'2023-05-16 16:40:47','2023-05-16 16:40:47','admin','admin'),(1658392047746322433,'0','删除终端','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/client/test2','DELETE','id%5B%5D=%5Btest2%5D',71,'0',NULL,'2023-05-16 16:40:50','2023-05-16 16:40:50','admin','admin'),(1658487697729163265,'0','更新角色菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/role/rels/update','PUT','',264,'0',NULL,'2023-05-16 23:00:55','2023-05-16 23:00:55','admin','admin'),(1658489271696265217,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B21731684249626767%5D&password=%5B1234qwer%5D&code=%5B3%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',121,'0',NULL,'2023-05-16 23:07:10','2023-05-16 23:07:10','admin','admin'),(1658502080224051201,'0','登录成功','test','127.0.0.1','Apifox/1.0.0 (https://www.apifox.cn)','/oauth2/token','POST','password=%5B1234qwer%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',129,'0',NULL,'2023-05-16 23:58:04','2023-05-16 23:58:04','admin','admin'),(1658672930617311233,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B97011684293413724%5D&password=%5B1234qwer%5D&code=%5B0%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',172,'0',NULL,'2023-05-17 11:16:58','2023-05-17 11:16:58','admin','admin'),(1658706504586379266,'0','登录成功','test','127.0.0.1','Apifox/1.0.0 (https://www.apifox.cn)','/oauth2/token','POST','password=%5B1234qwer%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',135,'0',NULL,'2023-05-17 13:30:23','2023-05-17 13:30:23','admin','admin'),(1658859714672443393,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B26311684337903709%5D&password=%5B1234qwer%5D&code=%5B49%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',133,'0',NULL,'2023-05-17 23:39:11','2023-05-17 23:39:11','admin','admin'),(1658860044621561857,'0','登录成功','test','127.0.0.1','Apifox/1.0.0 (https://www.apifox.cn)','/oauth2/token','POST','password=%5B1234qwer%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',118,'0',NULL,'2023-05-17 23:40:29','2023-05-17 23:40:29','admin','admin'),(1658861850256863233,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B16731684338451742%5D&password=%5B1234qwer%5D&code=%5B15%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',2325,'0',NULL,'2023-05-17 23:47:40','2023-05-17 23:47:40','admin','admin'),(1659073231086227458,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B82151684388849136%5D&password=%5B1234qwer%5D&code=%5B0%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',1017,'0',NULL,'2023-05-18 13:47:37','2023-05-18 13:47:37','admin','admin'),(1659079858292068354,'0','删除菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/10000','DELETE','headers%5BnoLoading%5D=%5Btrue%5D',239,'0',NULL,'2023-05-18 14:13:57','2023-05-18 14:13:57','admin','admin'),(1659081238746566658,'0','新增菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/add','POST','',126,'0',NULL,'2023-05-18 14:19:26','2023-05-18 14:19:26','admin','admin'),(1659081304945266689,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',73,'0',NULL,'2023-05-18 14:19:42','2023-05-18 14:19:42','admin','admin'),(1659081432686989313,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',78,'0',NULL,'2023-05-18 14:20:12','2023-05-18 14:20:12','admin','admin'),(1659081471786291202,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',67,'0',NULL,'2023-05-18 14:20:22','2023-05-18 14:20:22','admin','admin'),(1659081523648860162,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',80,'0',NULL,'2023-05-18 14:20:34','2023-05-18 14:20:34','admin','admin'),(1659081561624088578,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',72,'0',NULL,'2023-05-18 14:20:43','2023-05-18 14:20:43','admin','admin'),(1659081663042359298,'0','更新角色菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/role/rels/update','PUT','',135,'0',NULL,'2023-05-18 14:21:07','2023-05-18 14:21:07','admin','admin'),(1659081794886111233,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B52771684390896415%5D&password=%5B1234qwer%5D&code=%5B14%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',124,'0',NULL,'2023-05-18 14:21:39','2023-05-18 14:21:39','admin','admin'),(1659088895133945857,'0','新增菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/add','POST','',121,'0',NULL,'2023-05-18 14:49:52','2023-05-18 14:49:52','admin','admin'),(1659088976637661185,'0','更新角色菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/role/rels/update','PUT','',159,'0',NULL,'2023-05-18 14:50:11','2023-05-18 14:50:11','admin','admin'),(1659107701373865986,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',95,'0',NULL,'2023-05-18 16:04:35','2023-05-18 16:04:35','admin','admin'),(1659107751927812097,'0','删除菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/4000','DELETE','headers%5BnoLoading%5D=%5Btrue%5D',93,'0',NULL,'2023-05-18 16:04:47','2023-05-18 16:04:47','admin','admin'),(1659107759993458689,'0','删除菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/9999','DELETE','headers%5BnoLoading%5D=%5Btrue%5D',86,'0',NULL,'2023-05-18 16:04:49','2023-05-18 16:04:49','admin','admin'),(1659107975014453250,'0','更新角色菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/role/rels/update','PUT','',137,'0',NULL,'2023-05-18 16:05:41','2023-05-18 16:05:41','admin','admin'),(1659108689447030786,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B14151684397307649%5D&password=%5B1234qwer%5D&code=%5B21%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',266,'0',NULL,'2023-05-18 16:08:31','2023-05-18 16:08:31','admin','admin'),(1659109503142006785,'0','登录成功','test','127.0.0.1','Apifox/1.0.0 (https://www.apifox.cn)','/oauth2/token','POST','password=%5B1234qwer%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',131,'0',NULL,'2023-05-18 16:11:45','2023-05-18 16:11:45','admin','admin'),(1659113336521887746,'0','退出成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/token/logout','DELETE','Bearer ff276c50-2959-42e8-87f3-7d049d816092',0,'0',NULL,'2023-05-18 16:26:59','2023-05-18 16:26:59','admin','admin'),(1659113354326708226,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B28091684398417260%5D&password=%5B1234qwer%5D&code=%5B3%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',1341,'0',NULL,'2023-05-18 16:27:03','2023-05-18 16:27:03','admin','admin'),(1659114695686098945,'0','新增菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/add','POST','',79,'0',NULL,'2023-05-18 16:32:23','2023-05-18 16:32:23','admin','admin'),(1659129639055921153,'0','新增菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/add','POST','',80,'0',NULL,'2023-05-18 17:31:46','2023-05-18 17:31:46','admin','admin'),(1659129809902505985,'0','新增菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/add','POST','',70,'0',NULL,'2023-05-18 17:32:26','2023-05-18 17:32:26','admin','admin'),(1659129880102572034,'0','更新角色菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/role/rels/update','PUT','',169,'0',NULL,'2023-05-18 17:32:43','2023-05-18 17:32:43','admin','admin'),(1659130164157616129,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',76,'0',NULL,'2023-05-18 17:33:51','2023-05-18 17:33:51','admin','admin'),(1659130325713817601,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',84,'0',NULL,'2023-05-18 17:34:29','2023-05-18 17:34:29','admin','admin'),(1659130386271178754,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',100,'0',NULL,'2023-05-18 17:34:44','2023-05-18 17:34:44','admin','admin'),(1659130528990760962,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B62651684402515340%5D&password=%5B1234qwer%5D&code=%5B-2%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',112,'0',NULL,'2023-05-18 17:35:18','2023-05-18 17:35:18','admin','admin'),(1659130773602570241,'0','登录成功','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/oauth2/token','POST','randomStr=%5B48111684402573644%5D&password=%5B1234qwer%5D&code=%5B10%5D&grant_type=%5Bpassword%5D&scope=%5Bserver%5D&username=%5Badmin%5D',213,'0',NULL,'2023-05-18 17:36:16','2023-05-18 17:36:16','admin','admin'),(1659132512791695361,'0','新增菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/add','POST','',73,'0',NULL,'2023-05-18 17:43:11','2023-05-18 17:43:11','admin','admin'),(1659132622464356354,'0','更新角色菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/role/rels/update','PUT','',158,'0',NULL,'2023-05-18 17:43:37','2023-05-18 17:43:37','admin','admin'),(1659132663371403265,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',91,'0',NULL,'2023-05-18 17:43:47','2023-05-18 17:43:47','admin','admin'),(1659139794006970370,'9','删除菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/2700','DELETE','headers%5BnoLoading%5D=%5Btrue%5D',19,'0','菜单含有下级不能删除','2023-05-18 18:12:07','2023-05-18 18:12:07','admin','admin'),(1659140336003321858,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',72,'0',NULL,'2023-05-18 18:14:16','2023-05-18 18:14:16','admin','admin'),(1659140391359746049,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',80,'0',NULL,'2023-05-18 18:14:29','2023-05-18 18:14:29','admin','admin'),(1659140416873697281,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',66,'0',NULL,'2023-05-18 18:14:35','2023-05-18 18:14:35','admin','admin'),(1659140439380332545,'0','更新菜单','obeast','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42','/menu/update','PUT','',86,'0',NULL,'2023-05-18 18:14:41','2023-05-18 18:14:41','admin','admin');
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '前端URL',
  `parent_id` bigint DEFAULT NULL COMMENT '父菜单ID',
  `icon` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  `sort_order` int NOT NULL DEFAULT '0' COMMENT '排序值',
  `keep_alive` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '0' COMMENT '0-开启，1- 关闭',
  `type` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  `del_flag` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '0' COMMENT '逻辑删除标记(0--正常 1--删除)',
  `is_full` char(1) DEFAULT '1' COMMENT '是否全屏(示例：数据大屏页面) 0-是，1-不是',
  `is_affix` char(1) DEFAULT '1' COMMENT '是否固定在 tabs nav 0-是，1-不是',
  `create_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1659132512263213059 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (100,'首页',NULL,'/home',-1,'HomeFilled',1,'0','0','0','1','0','admin','2018-09-28 08:29:53','admin','2020-03-11 23:58:18'),(1000,'权限管理',NULL,'/admin',-1,'Lock',10,'0','0','0','1','1',' ','2018-09-28 08:29:53',' ','2020-03-11 23:58:18'),(1100,'用户管理',NULL,'/admin/user',1000,'Menu',0,'0','0','0','1','1',' ','2017-11-02 22:24:37',' ','2020-03-12 00:12:57'),(1101,'用户新增','sys_user_add',NULL,1100,NULL,0,'0','1','0','1','1',' ','2017-11-08 09:52:09',' ','2021-05-25 06:48:34'),(1102,'用户修改','sys_user_edit',NULL,1100,NULL,0,'0','1','0','1','1',' ','2017-11-08 09:52:48',' ','2021-05-25 06:48:34'),(1103,'用户删除','sys_user_del',NULL,1100,NULL,0,'0','1','0','1','1',' ','2017-11-08 09:54:01',' ','2021-05-25 06:48:34'),(1104,'导入导出','sys_user_import_export',NULL,1100,NULL,0,'0','1','0','1','1',' ','2017-11-08 09:54:01',' ','2021-05-25 06:48:34'),(1200,'菜单管理',NULL,'/admin/menu',1000,'Menu',1,'0','0','0','1','1',' ','2017-11-08 09:57:27',' ','2020-03-12 00:13:52'),(1201,'菜单新增','sys_menu_add',NULL,1200,NULL,0,'0','1','0','1','1',' ','2017-11-08 10:15:53',' ','2021-05-25 06:48:34'),(1202,'菜单修改','sys_menu_edit',NULL,1200,NULL,0,'0','1','0','1','1',' ','2017-11-08 10:16:23',' ','2021-05-25 06:48:34'),(1203,'菜单删除','sys_menu_del',NULL,1200,NULL,0,'0','1','0','1','1',' ','2017-11-08 10:16:43',' ','2021-05-25 06:48:34'),(1300,'角色管理',NULL,'/admin/role',1000,'Menu',20,'0','0','0','1','1',' ','2017-11-08 10:13:37',' ','2020-03-12 00:15:40'),(1301,'角色新增','sys_role_add',NULL,1300,NULL,0,'0','1','0','1','1',' ','2017-11-08 10:14:18',' ','2021-05-25 06:48:34'),(1302,'角色修改','sys_role_edit',NULL,1300,NULL,0,'0','1','0','1','1',' ','2017-11-08 10:14:41',' ','2021-05-25 06:48:34'),(1303,'角色删除','sys_role_del',NULL,1300,NULL,0,'0','1','0','1','1',' ','2017-11-08 10:14:59',' ','2021-05-25 06:48:34'),(1304,'分配权限','sys_role_perm',NULL,1300,NULL,0,'0','1','0','1','1',' ','2018-04-20 07:22:55',' ','2021-05-25 06:48:34'),(1305,'导入导出','sys_role_import_export',NULL,1300,NULL,0,'0','1','0','1','1','admin','2022-03-21 11:14:52','admin','2022-03-21 11:15:07'),(1400,'部门管理',NULL,'/admin/dept',1000,'Menu',30,'0','0','0','1','1',' ','2018-01-20 13:17:19',' ','2020-03-12 00:15:44'),(1401,'部门新增','sys_dept_add',NULL,1400,NULL,0,'0','1','0','1','1',' ','2018-01-20 14:56:16',' ','2021-05-25 06:48:34'),(1402,'部门修改','sys_dept_edit',NULL,1400,NULL,0,'0','1','0','1','1',' ','2018-01-20 14:56:59',' ','2021-05-25 06:48:34'),(1403,'部门删除','sys_dept_del',NULL,1400,NULL,0,'0','1','0','1','1',' ','2018-01-20 14:57:28',' ','2021-05-25 06:48:34'),(1500,'岗位管理','','/admin/post',1000,'Menu',40,'0','0','0','1','1',NULL,'2018-01-20 13:17:19','admin','2022-11-10 21:35:55'),(1501,'岗位查看','sys_post_get',NULL,1500,NULL,0,'0','1','0','1','1',NULL,'2018-05-15 21:35:18','admin','2022-03-15 17:32:54'),(1502,'岗位新增','sys_post_add',NULL,1500,NULL,1,'0','1','0','1','1',NULL,'2018-05-15 21:35:18','admin','2022-03-15 17:32:48'),(1503,'岗位修改','sys_post_edit',NULL,1500,NULL,2,'0','1','0','1','1',NULL,'2018-05-15 21:35:18','admin','2022-03-15 17:33:10'),(1504,'岗位删除','sys_post_del',NULL,1500,NULL,3,'0','1','0','1','1',NULL,'2018-05-15 21:35:18','admin','2022-03-15 17:33:27'),(1505,'导入导出','sys_post_import_export',NULL,1500,NULL,4,'0','1','0','1','1','admin','2022-03-21 12:53:05','admin','2022-03-21 12:53:05'),(2000,'系统管理',NULL,'/setting',-1,'Tools',20,'0','0','0','1','1','','2017-11-07 20:56:00','admin','2022-11-10 21:42:39'),(2100,'日志管理',NULL,'/admin/log',2000,'Menu',3,'0','0','0','1','1',' ','2017-11-20 14:06:22',' ','2020-03-12 00:15:49'),(2101,'日志删除','sys_log_del',NULL,2100,NULL,0,'0','1','0','1','1',' ','2017-11-20 20:37:37',' ','2021-05-25 06:48:34'),(2102,'导入导出','sys_log_import_export',NULL,2100,NULL,0,'0','1','0','1','1',' ','2017-11-08 09:54:01',' ','2021-05-25 06:48:34'),(2200,'字典管理',NULL,'/admin/dict',2000,'Menu',2,'0','0','0','1','1','','2017-11-29 11:30:52','admin','2022-11-10 21:38:09'),(2201,'字典删除','sys_dict_del',NULL,2200,NULL,0,'0','1','0','1','1',' ','2017-11-29 11:30:11',' ','2021-05-25 06:48:34'),(2202,'字典新增','sys_dict_add',NULL,2200,NULL,0,'0','1','0','1','1',' ','2018-05-11 22:34:55',' ','2021-05-25 06:48:34'),(2203,'字典修改','sys_dict_edit',NULL,2200,NULL,0,'0','1','0','1','1',' ','2018-05-11 22:36:03',' ','2021-05-25 06:48:34'),(2300,'令牌管理',NULL,'/admin/token',2000,'Menu',4,'0','0','0','1','1','','2018-09-04 05:58:41','admin','2022-11-10 21:38:33'),(2301,'令牌删除','sys_token_del',NULL,2300,NULL,0,'0','1','0','1','1',' ','2018-09-04 05:59:50',' ','2020-03-13 12:57:34'),(2400,'终端管理','','/admin/client',2000,'Menu',0,'0','0','0','1','1',' ','2018-01-20 13:17:19',' ','2020-03-12 00:15:54'),(2401,'客户端新增','sys_client_add',NULL,2400,NULL,0,'0','1','0','1','1',' ','2018-05-15 21:35:18',' ','2021-05-25 06:48:34'),(2402,'客户端修改','sys_client_edit',NULL,2400,NULL,0,'0','1','0','1','1',' ','2018-05-15 21:37:06',' ','2021-05-25 06:48:34'),(2403,'客户端删除','sys_client_del',NULL,2400,NULL,0,'0','1','0','1','1',' ','2018-05-15 21:39:16',' ','2021-05-25 06:48:34'),(2600,'文件管理',NULL,'/admin/file',2000,'Menu',1,'0','0','0','1','1','','2018-06-26 10:50:32','admin','2022-11-10 21:35:40'),(2601,'文件删除','sys_file_del',NULL,2600,NULL,0,'0','1','0','1','1',' ','2017-11-29 11:30:11',' ','2021-05-25 06:48:34'),(2602,'文件新增','sys_file_add',NULL,2600,NULL,0,'0','1','0','1','1',' ','2018-05-11 22:34:55',' ','2021-05-25 06:48:34'),(2603,'文件修改','sys_file_edit',NULL,2600,NULL,0,'0','1','0','1','1',' ','2018-05-11 22:36:03',' ','2021-05-25 06:48:34'),(2700,'参数管理',NULL,'/admin/param',2000,'Menu',5,'0','0','0','1','1','admin','2022-03-25 20:40:27','admin','2022-11-10 21:38:50'),(2701,'参数新增','sys_publicparam_add',NULL,2700,NULL,0,'0','1','0','1','1','admin','2022-03-25 20:45:05','admin','2022-03-25 20:45:05'),(2702,'参数删除','sys_publicparam_del',NULL,2700,NULL,1,'0','1','0','1','1','admin','2022-03-25 20:45:43','admin','2022-03-25 20:45:43'),(2703,'参数修改','sys_publicparam_edit',NULL,2700,NULL,3,'0','1','0','1','1','admin','2022-03-25 20:46:04','admin','2022-03-25 20:46:04'),(3000,'开发平台',NULL,'/gen',-1,'MessageBox',100,'1','0','0','1','1','','2020-03-11 22:15:40','admin','2023-05-18 14:20:22'),(3100,'数据源管理',NULL,'/gen/datasource',3000,'Menu',3,'1','0','0','1','1','','2020-03-11 22:17:05','admin','2022-11-10 21:40:27'),(3200,'代码生成',NULL,'/gen/code',3000,'Menu',0,'0','0','0','1','1','','2020-03-11 22:23:42','admin','2022-11-10 21:39:54'),(3300,'表单管理',NULL,'/gen/form',3000,'Menu',1,'1','0','0','1','1','','2020-03-11 22:19:32','admin','2022-11-10 21:40:06'),(3301,'表单新增','gen_form_add',NULL,3300,NULL,0,'0','1','0','1','1',' ','2018-05-15 21:35:18',' ','2020-03-11 22:39:08'),(3302,'表单修改','gen_form_edit',NULL,3300,NULL,0,'0','1','0','1','1',' ','2018-05-15 21:35:18',' ','2020-03-11 22:39:09'),(3303,'表单删除','gen_form_del',NULL,3300,NULL,0,'0','1','0','1','1',' ','2018-05-15 21:35:18',' ','2020-03-11 22:39:11'),(3400,'表单设计',NULL,'/gen/design',3000,'Menu',2,'1','0','0','1','1','','2020-03-11 22:18:05','admin','2022-11-10 21:40:16'),(4000,'服务监控',NULL,'http://localhost:5001/login',-1,'Histogram',200,'0','0','1','1','1','admin','2022-03-21 09:44:50','admin','2023-05-18 16:04:47'),(9999,'系统官网',NULL,'https://www.blog-obeast.top/',-1,'Film',999,'0','0','1','1','1','','2019-01-17 17:05:19','admin','2023-05-18 16:04:49'),(1659081238096449537,'商品管理',NULL,'/mail',-1,'Shop',50,'0','0','0','1','1','admin','2023-05-18 14:19:26','admin','2023-05-18 14:20:34'),(1659088894357999618,'商品分类',NULL,'/mail/category',1659081238096449537,'Menu',0,'0','0','0','1','1','admin','2023-05-18 14:49:51','admin','2023-05-18 14:49:51'),(1659114693672833026,'订单管理',NULL,'/order',-1,'Goods',60,'0','0','0','1','1','admin','2023-05-18 16:32:23','admin','2023-05-18 18:14:16'),(1659129638602936321,'营销管理',NULL,'/market',-1,'Ticket',70,'0','0','0','1','1','admin','2023-05-18 17:31:46','admin','2023-05-18 18:14:29'),(1659129809504047106,'库存管理',NULL,'/stock',-1,'SuitcaseLine',80,'0','0','0','1','1','admin','2023-05-18 17:32:26','admin','2023-05-18 18:14:35'),(1659132512263213058,'会员管理',NULL,'/member',-1,'UserFilled',90,'0','0','0','1','1','admin','2023-05-18 17:43:11','admin','2023-05-18 18:14:41');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oauth_client_details`
--

DROP TABLE IF EXISTS `sys_oauth_client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_oauth_client_details` (
  `client_id` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '客户端ID',
  `resource_ids` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源列表',
  `client_secret` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户端密钥',
  `scope` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '域',
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '认证类型',
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '重定向地址',
  `authorities` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色列表',
  `access_token_validity` int DEFAULT NULL COMMENT 'token 有效期',
  `refresh_token_validity` int DEFAULT NULL COMMENT '刷新令牌有效期',
  `additional_information` varchar(4096) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '令牌扩展字段JSON',
  `autoapprove` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否自动放行',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='终端信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oauth_client_details`
--

LOCK TABLES `sys_oauth_client_details` WRITE;
/*!40000 ALTER TABLE `sys_oauth_client_details` DISABLE KEYS */;
INSERT INTO `sys_oauth_client_details` VALUES ('app',NULL,'app','server','app,refresh_token',NULL,NULL,NULL,NULL,NULL,'true',NULL,'2023-05-16 15:47:39',NULL,'admin'),('client',NULL,'client','server','client_credentials',NULL,NULL,NULL,NULL,NULL,'true',NULL,NULL,NULL,NULL),('daemon',NULL,'daemon','server','password,refresh_token',NULL,NULL,NULL,NULL,NULL,'true',NULL,NULL,NULL,NULL),('gen',NULL,'gen','server','password,refresh_token',NULL,NULL,NULL,NULL,NULL,'true',NULL,NULL,NULL,NULL),('obeast',NULL,'obeast','server','password,app,refresh_token,authorization_code,client_credentials','https://pigx.vip',NULL,NULL,NULL,NULL,'true',NULL,NULL,NULL,NULL),('pig',NULL,'pig','server','password,app,refresh_token,authorization_code,client_credentials','https://pigx.vip',NULL,NULL,NULL,NULL,'true',NULL,NULL,NULL,NULL),('test',NULL,'test','server','password,app,refresh_token',NULL,NULL,NULL,NULL,NULL,'true',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_post`
--

DROP TABLE IF EXISTS `sys_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_post` (
  `post_id` bigint NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int NOT NULL COMMENT '岗位排序',
  `del_flag` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '' COMMENT '更新人',
  `remark` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1657795944113565698 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='岗位信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_post`
--

LOCK TABLES `sys_post` WRITE;
/*!40000 ALTER TABLE `sys_post` DISABLE KEYS */;
INSERT INTO `sys_post` VALUES (1,'user','员工',2,'0','2022-03-19 10:05:15','admin','2022-03-19 10:42:28','admin','打工人'),(2,'cto','cto',0,'0','2022-03-19 10:06:20','admin','2022-03-19 10:06:20','admin','cto666'),(3,'boss','董事长',-1,'0','2022-03-19 10:06:35','admin','2022-03-19 10:42:44','admin','大boss'),(1657795944113565697,'laoliu','老六2',0,'0','2023-05-15 01:12:08','admin','2023-05-15 01:12:17','admin','一个老六');
/*!40000 ALTER TABLE `sys_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_public_param`
--

DROP TABLE IF EXISTS `sys_public_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_public_param` (
  `public_id` bigint NOT NULL COMMENT '编号',
  `public_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数名称',
  `public_key` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数键名',
  `public_value` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数键值',
  `status` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '0' COMMENT '状态，1-启用，0-禁用',
  `validate_code` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '校验码',
  `create_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL DEFAULT ' ' COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL DEFAULT ' ' COMMENT '修改人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `public_type` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '0' COMMENT '参数类型，1-系统参数，2-业务参数',
  `system_flag` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否为系统内置参数，1-是，0-否',
  PRIMARY KEY (`public_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='公共参数配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_public_param`
--

LOCK TABLES `sys_public_param` WRITE;
/*!40000 ALTER TABLE `sys_public_param` DISABLE KEYS */;
INSERT INTO `sys_public_param` VALUES (1,'接口文档不显示的字段','GEN_HIDDEN_COLUMNS','tenant_id','0','',' ',' ','2020-05-12 04:25:19',NULL,'9','1'),(2,'注册用户默认角色','USER_DEFAULT_ROLE','GENERAL_USER','0','','admin','admin','2022-03-30 10:00:57','2022-03-30 02:05:59','2','1');
/*!40000 ALTER TABLE `sys_public_param` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_code` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '角色代码',
  `role_desc` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  `del_flag` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '0' COMMENT '删除标识：0-正常，1-删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `create_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_idx1_role_code` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1657752355736186882 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='系统角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'管理员','ROLE_ADMIN','管理员','0','2017-10-29 15:45:51','2018-12-26 14:09:11',NULL,NULL),(2,'普通用户','GENERAL_USER','普通用户','0','2022-03-30 09:59:24','2022-03-30 09:59:24','admin','admin'),(3,'超级管理员','SUPER_ADMIN','超级管理员','0','2023-05-14 22:18:39','2023-05-14 22:18:39','admin','admin'),(4,'test2','test1_admin','test2','0','2023-05-14 22:18:56','2023-05-14 22:34:08','admin','admin');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='角色菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (1,100),(1,1000),(1,1100),(1,1101),(1,1102),(1,1103),(1,1104),(1,1200),(1,1201),(1,1202),(1,1203),(1,1300),(1,1301),(1,1302),(1,1303),(1,1304),(1,1305),(1,1400),(1,1401),(1,1402),(1,1403),(1,1500),(1,1501),(1,1502),(1,1503),(1,1504),(1,1505),(1,2000),(1,2100),(1,2101),(1,2102),(1,2200),(1,2201),(1,2202),(1,2203),(1,2300),(1,2301),(1,2400),(1,2401),(1,2402),(1,2403),(1,2600),(1,2601),(1,2602),(1,2603),(1,2700),(1,2701),(1,2702),(1,2703),(1,1659081238096449537),(1,1659088894357999618),(1,1659114693672833026),(1,1659129638602936321),(1,1659129809504047106),(1,1659132512263213058),(2,2000),(2,2200),(2,2203),(2,2400),(2,2403),(2,3000),(2,3200);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '随机盐',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '简介',
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `del_flag` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT '0' COMMENT '0-正常，1-删除',
  `lock_flag` char(1) DEFAULT '0' COMMENT '0-正常，9-锁定',
  `name` varchar(48) DEFAULT NULL COMMENT '姓名',
  `nick_name` varchar(48) DEFAULT NULL COMMENT '昵称',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`),
  KEY `user_idx1_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin','$2a$10$V0RX3J6KJukvxVlDgRrUveZsX7eky.bk/j9WqSRMlFqT0Z9SCd8Tm',NULL,'17034642999','https://i.imgtg.com/2023/01/16/QR57a.jpg',1,'1468258057@qq.com','0','0','小明','obeast-dragon',NULL,'admin','2018-04-20 07:15:18','2023-04-10 22:53:45'),(2,'user','$2a$10$V0RX3J6KJukvxVlDgRrUveZsX7eky.bk/j9WqSRMlFqT0Z9SCd8Tm',NULL,'17034642999','https://i.imgtg.com/2023/01/16/QR57a.jpg',7,'1468258057@qq.com','0','0','小张','obeast-test',NULL,'admin','2018-04-20 07:15:18','2023-05-13 21:24:12'),(3,'ikun','$2a$10$8oCGc/DVNbp42Jn2kutd/.cM1tnMzIeGhJLCLvNTnohs4Odc0zu9S',NULL,'1008611',NULL,4,'1008611@qq.com','0','0','坤',NULL,'admin','admin','2023-05-13 19:51:47','2023-05-15 00:45:30');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_post`
--

DROP TABLE IF EXISTS `sys_user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_post` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `post_id` bigint NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='用户与岗位关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_post`
--

LOCK TABLES `sys_user_post` WRITE;
/*!40000 ALTER TABLE `sys_user_post` DISABLE KEYS */;
INSERT INTO `sys_user_post` VALUES (1,1),(2,1),(1657352936851795970,1);
/*!40000 ALTER TABLE `sys_user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1),(2,2),(1657352936851795970,2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-18 21:56:03
