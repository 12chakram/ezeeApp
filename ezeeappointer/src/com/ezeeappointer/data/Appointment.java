package com.ezeeappointer.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;


@Entity
@Table(name = "APPOINTMENT_DETAIL")
public class Appointment {
	
	private String chooseService;
	private String appointmentDate;
	private String availableSlots;
	private String staffDescription;
	private String chooseDoctor;
	private String selectDOAppointment;
	private String listofAvailableSlots;
	private String selectServices;
	private long id;
	private long userId;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	/**
	 * @return the chooseService
	 */
	public String getChooseService() {
		return chooseService;
	}
	/**
	 * @param chooseService the chooseService to set
	 */
	public void setChooseService(String chooseService) {
		this.chooseService = chooseService;
	}
	/**
	 * @return the appointmentDate
	 */
	public String getAppointmentDate() {
		return appointmentDate;
	}
	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	/**
	 * @return the availableSlots
	 */
	public String getAvailableSlots() {
		return availableSlots;
	}
	/**
	 * @param availableSlots the availableSlots to set
	 */
	public void setAvailableSlots(String availableSlots) {
		this.availableSlots = availableSlots;
	}
	/**
	 * @return the staffDescription
	 */
	public String getStaffDescription() {
		return staffDescription;
	}
	/**
	 * @param staffDescription the staffDescription to set
	 */
	public void setStaffDescription(String staffDescription) {
		this.staffDescription = staffDescription;
	}
	/**
	 * @return the chooseDoctor
	 */
	public String getChooseDoctor() {
		return chooseDoctor;
	}
	/**
	 * @param chooseDoctor the chooseDoctor to set
	 */
	public void setChooseDoctor(String chooseDoctor) {
		this.chooseDoctor = chooseDoctor;
	}
	/**
	 * @return the selectDOAppointment
	 */
	public String getSelectDOAppointment() {
		return selectDOAppointment;
	}
	/**
	 * @param selectDOAppointment the selectDOAppointment to set
	 */
	public void setSelectDOAppointment(String selectDOAppointment) {
		this.selectDOAppointment = selectDOAppointment;
	}
	/**
	 * @return the listofAvailableSlots
	 */
	public String getListofAvailableSlots() {
		return listofAvailableSlots;
	}
	/**
	 * @param listofAvailableSlots the listofAvailableSlots to set
	 */
	public void setListofAvailableSlots(String listofAvailableSlots) {
		this.listofAvailableSlots = listofAvailableSlots;
	}
	/**
	 * @return the selectServices
	 */
	public String getSelectServices() {
		return selectServices;
	}
	/**
	 * @param selectServices the selectServices to set
	 */
	public void setSelectServices(String selectServices) {
		this.selectServices = selectServices;
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
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
	

}
