delimiter $$

CREATE TABLE `business_detail` (
  `business_detail_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) DEFAULT NULL,
  `about_company` varchar(45) DEFAULT NULL,
  `tag` varchar(45) DEFAULT NULL,
  `company_address` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `open_time` varchar(45) DEFAULT NULL,
  `close_time` varchar(45) DEFAULT NULL,
  `profile_picture` varchar(45) DEFAULT NULL,
  `enable_without_login` varchar(45) DEFAULT NULL,
  `email_notifications` varchar(50) DEFAULT NULL,
  `sms_notifications` varchar(50) DEFAULT NULL,
  `hrs_bfr_appt_booked` varchar(45) DEFAULT NULL,
  `hrs_bfr_appt_cancelled` varchar(45) DEFAULT NULL,
  `days_bfr_adv_appt_booked` varchar(45) DEFAULT NULL,
  `hrs_bfr_appt_remainder_notification` varchar(45) DEFAULT NULL,
  `business_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`business_detail_id`),
  KEY `user_detail_fk_idx` (`business_user_id`),
  CONSTRAINT `user_detail_fk` FOREIGN KEY (`business_user_id`) REFERENCES `business_user` (`business_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

