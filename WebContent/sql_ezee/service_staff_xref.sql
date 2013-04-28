delimiter $$

CREATE TABLE `service_staff_xref` (
  `service_staff_xref_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `service_detail_id` bigint(20) NOT NULL,
  `staff_detail_id` bigint(20) NOT NULL,
  PRIMARY KEY (`service_staff_xref_id`),
  KEY `service_detail_ssxref_idx` (`service_detail_id`),
  KEY `staff_detail_ssxref_idx` (`staff_detail_id`),
  CONSTRAINT `service_detail_ssxref` FOREIGN KEY (`service_detail_id`) REFERENCES `service_detail` (`service_detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staff_detail_ssxref` FOREIGN KEY (`staff_detail_id`) REFERENCES `staff_detail` (`staff_detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
