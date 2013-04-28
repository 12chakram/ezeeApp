delimiter $$

CREATE TABLE `appointment_detail` (
  `appointment_detail_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appt_date` datetime DEFAULT NULL,
  `appt_taken_date` datetime DEFAULT NULL,
  `search_date` datetime DEFAULT NULL,
  `staff_detail_id` bigint(20) DEFAULT NULL,
  `appt_time` varchar(45) DEFAULT NULL,
  `business_detail_id` bigint(20) DEFAULT NULL,
  `appt_sts` varchar(45) DEFAULT NULL,
  `service_detail_id` bigint(20) DEFAULT NULL,
  `appointment_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`appointment_detail_id`),
  KEY `busn_detail_appt_fk_idx` (`business_detail_id`),
  KEY `staff_detail_appt_fk_idx` (`staff_detail_id`),
  KEY `service_detail_appt_fk_idx` (`service_detail_id`),
  KEY `appt_user_appt_fk_idx` (`appointment_user_id`),
  CONSTRAINT `appt_user_appt_fk` FOREIGN KEY (`appointment_user_id`) REFERENCES `appointment_user` (`appointment_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `busn_detail_appt_fk` FOREIGN KEY (`business_detail_id`) REFERENCES `business_detail` (`business_detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `service_detail_appt_fk` FOREIGN KEY (`service_detail_id`) REFERENCES `service_detail` (`service_detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staff_detail_appt_fk` FOREIGN KEY (`staff_detail_id`) REFERENCES `staff_detail` (`staff_detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

