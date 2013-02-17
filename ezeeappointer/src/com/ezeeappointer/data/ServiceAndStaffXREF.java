/**
 * 
 */
package com.ezeeappointer.data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;

/**
 * @author dreddy
 *
 */
@Entity
@Table(name = "SERVICE_STAFF_XREF")
public class ServiceAndStaffXREF {
	
	private long id;
	private long serviceId;
	private long staffId;
	private long businessId;
	@ManyToOne(fetch = FetchType.LAZY)
	private Staff staff;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
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
	 * @return the businessId
	 */
	public long getBusinessId() {
		return businessId;
	}
	/**
	 * @param businessId the businessId to set
	 */
	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}
	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(Key key) {
		this.key = key;
	}
	/**
	 * @return the staff
	 */
	public Staff getStaff() {
		return staff;
	}
	/**
	 * @param staff the staff to set
	 */
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
