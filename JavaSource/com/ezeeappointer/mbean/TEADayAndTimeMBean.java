/**
 * 
 */
package com.ezeeappointer.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author dreddy
 *
 */
@ManagedBean(name="teaDayAndTimeMBean")
@RequestScoped
public class TEADayAndTimeMBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1139559032603698272L;
	private String[] days;
	private String fromTime;
	private String toTime;
	private String daysStr;
	
	/**
	 * @return the days
	 */
	public String[] getDays() {
		return days;
	}
	/**
	 * @param days the days to set
	 */
	public void setDays(String[] days) {
		this.days = days;
	}
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
	 * @return the daysStr
	 */
	public String getDaysStr() {
		StringBuffer ldaysStr = new StringBuffer();
		if(days != null){
			for(String day: days){
				if(ldaysStr.length() > 0)
					ldaysStr.append(",");
				ldaysStr.append(day);
			}
		}
		return ldaysStr.toString();
	}	

}
