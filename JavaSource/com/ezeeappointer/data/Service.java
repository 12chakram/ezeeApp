package com.ezeeappointer.data;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "SERVICE_DETAIL")
public class Service {
	
	@Column(name="service_name")
	private String serviceName;
	
	@Column(name="service_desr")
	private String description;
	
	@Column(name="service_duration")
	private String duration;
	
	@Column(name="service_price")
	private String price;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="business_detail_id")
	private Business business;
	
	

	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_detail_id")
	private long id;
	
	

	@ManyToMany
	@JoinTable(name="SERVICE_STAFF_XREF",
	 joinColumns={@JoinColumn(name="service_detail_id")},
	 inverseJoinColumns={@JoinColumn(name="staff_detail_id")})
	private List<Staff> staffs = new ArrayList<Staff>();
	

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}


	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}


	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}


	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}


	/**
	 * @return the key
	 */
	


	/**
	 * @return the business
	 */
	public Business getBusiness() {
		return business;
	}


	/**
	 * @param business the business to set
	 */
	public void setBusiness(Business business) {
		this.business = business;
	}

	/**
	 * @return the businessId
	 */


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


	public List<Staff> getStaffs() {
		return staffs;
	}


	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}
	
	
	

}
