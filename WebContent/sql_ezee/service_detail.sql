delimiter $$

CREATE TABLE `service_detail` (
  `service_detail_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `business_detail_id` bigint(20) NOT NULL,
  `service_name` varchar(45) DEFAULT NULL,
  `service_desr` varchar(45) DEFAULT NULL,
  `service_duration` varchar(45) DEFAULT NULL,
  `service_price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`service_detail_id`),
  KEY `busn_details_service_fk_idx` (`business_detail_id`),
  CONSTRAINT `busn_details_service_fk` FOREIGN KEY (`business_detail_id`) REFERENCES `business_detail` (`business_detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

