delimiter $$

CREATE TABLE `staff_detail` (
  `staff_detail_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `business_detail_id` bigint(20) NOT NULL,
  `staff_user_name` varchar(45) DEFAULT NULL,
  `staff_user_password` varchar(45) DEFAULT NULL,
  `staff_profile_picture` varchar(45) DEFAULT NULL,
  `staff_designation` varchar(45) DEFAULT NULL,
  `staff_description` varchar(45) DEFAULT NULL,
  `staff_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`staff_detail_id`),
  KEY `busn_detail_satff_fk_idx` (`business_detail_id`),
  CONSTRAINT `busn_detail_satff_fk` FOREIGN KEY (`business_detail_id`) REFERENCES `business_detail` (`business_detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

