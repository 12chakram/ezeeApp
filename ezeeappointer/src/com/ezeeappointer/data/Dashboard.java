/**
 * 
 */
package com.ezeeappointer.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "DASHBOARD")
public class Dashboard {
	private String apptDate;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Key key;

	/**
	 * @return the apptDate
	 */
	public String getApptDate() {
		return apptDate;
	}

	/**
	 * @param apptDate the apptDate to set
	 */
	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
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
	
	

}
