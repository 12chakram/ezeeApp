/**
 * 
 */
package com.ezeeappointer.dto;

import java.io.Serializable;

/**
 * @author dreddy
 *
 */
public class TEADayAndTimeDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 964678886999033996L;
	private String[] dayss;
	private String fromTime;
	private String toTime;
	
	
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
	public String[] getDayss() {
		return dayss;
	}
	public void setDayss(String[] dayss) {
		this.dayss = dayss;
	}

}
