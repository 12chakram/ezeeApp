/**
 * 
 */
package com.ezeeappointer.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.google.appengine.api.datastore.Key;

/**
 * @author dreddy
 *
 */
@Entity
@Table(name = "STAFF_DAYTIME_DETAIL")
public class DayAndTime {
	
	@Column(name="staff_week_days")
	private String days;
	
	
	
	
	@Column(name="staff_from_time")
	private String fromTime;
	
	@Column(name="staff_to_time")
	private String toTime;
	
	@ManyToOne
	@JoinColumn(name="staff_detail_id")
	private Staff staff;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="staff_daytime_detail_id")
	private long id;
	
	
	/**
	 * @return the days
	 */
	
	/**
	 * @return the fromTime
	 */
	public String getFromTime() {
		return fromTime;
	}
	/**
	 * @param fromTime the fromTime to set
	 */
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	/**
	 * @return the toTime
	 */
	public String getToTime() {
		return toTime;
	}
	/**
	 * @param toTime the toTime to set
	 */
	public void setToTime(String toTime) {
		this.toTime = toTime;
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
	/**
	 * @return the key
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
	/**
	 * @return the staffId
	 */
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	
	
	

}
