delimiter $$

CREATE TABLE `staff_daytime_detail` (
  `staff_daytime_detail_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staff_detail_id` bigint(20) NOT NULL,
  `staff_week_days` varchar(90) DEFAULT NULL,
  `staff_from_time` varchar(45) DEFAULT NULL,
  `staff_to_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`staff_daytime_detail_id`),
  KEY `staff_detail_daytime_fk_idx` (`staff_detail_id`),
  CONSTRAINT `staff_detail_daytime_fk` FOREIGN KEY (`staff_detail_id`) REFERENCES `staff_detail` (`staff_detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

