delimiter $$

CREATE TABLE `business_user` (
  `business_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `phone_number` bigint(20) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `type_of_business` varchar(45) DEFAULT NULL,
  `business_setup_flag` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`business_user_id`)
);

