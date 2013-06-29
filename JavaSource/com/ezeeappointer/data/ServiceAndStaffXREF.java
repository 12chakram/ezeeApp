/**
 * 
 */
package com.ezeeappointer.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author dreddy
 *
 */
@Entity
@Table(name = "SERVICE_STAFF_XREF")
public class ServiceAndStaffXREF {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_staff_xref_id")
	private long id;
	
	@Column(name="service_detail_id")
	private long serviceId;
	
	@Column(name="staff_detail_id")
	private long staffId;
	
	/*@Column(name="busn_detail_id")
	private long businessId;*/
	
	/*@ManyToOne
	private Staff staff;*/
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the serviceId
	 */
	public long getServiceId() {
		return serviceId;
	}
	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	/**
	 * @return the staffId
	 */
	public long getStaffId() {
		return staffId;
	}
	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	
	/**
	 * @return the key
	 */
	
	/**
	 * @return the staff
	 */
/*	public Staff getStaff() {
		return staff;
	}
	*//**
	 * @param staff the staff to set
	 *//*
	public void setStaff(Staff staff) {
		this.staff = staff;
	}*/

}
