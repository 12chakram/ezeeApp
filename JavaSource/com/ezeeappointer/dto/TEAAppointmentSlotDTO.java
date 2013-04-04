/**
 * 
 */
package com.ezeeappointer.dto;

import java.util.Map;
import java.io.Serializable;;

/**
 * @author dreddy
 *
 */
public class TEAAppointmentSlotDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2206898320855113968L;
	private String apptDate;
	private String apptDay;
	private String apptFullDate;
	private Map<String, String> apptSlots;
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
	 * @return the apptDay
	 */
	public String getApptDay() {
		return apptDay;
	}
	/**
	 * @param apptDay the apptDay to set
	 */
	public void setApptDay(String apptDay) {
		this.apptDay = apptDay;
	}
	/**
	 * @return the apptFullDate
	 */
	public String getApptFullDate() {
		return apptFullDate;
	}
	/**
	 * @param apptFullDate the apptFullDate to set
	 */
	public void setApptFullDate(String apptFullDate) {
		this.apptFullDate = apptFullDate;
	}
	/**
	 * @return the apptSlots
	 */
	public Map<String, String> getApptSlots() {
		return apptSlots;
	}
	/**
	 * @param apptSlots the apptSlots to set
	 */
	public void setApptSlots(Map<String, String> apptSlots) {
		this.apptSlots = apptSlots;
	}	

}
