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
 * @author Administrator
 *
 */
@Entity
@Table(name = "SERVICE_DETAIL")
public class Service {
	
	private String serviceName;
	private String description;
	private String duration;
	private String price;
	@ManyToOne(fetch = FetchType.LAZY)
	private Business business;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	private long id;
	private long businessId;


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
	
	
	

}
