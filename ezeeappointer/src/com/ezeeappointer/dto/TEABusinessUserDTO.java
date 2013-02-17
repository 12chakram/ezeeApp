/**
 * 
 */
package com.ezeeappointer.dto;

import java.io.Serializable;

/**
 * @author sairam
 *
 */
public class TEABusinessUserDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8966342409249834273L;
	private String userId;
	private String password;
	private String cfrmPassword;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String city;
	private String country;
	private String typeOfBusiness;
	private char businessSetupFlag = 'n';
	private long id;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCfrmPassword() {
		return cfrmPassword;
	}
	public void setCfrmPassword(String cfrmPassword) {
		this.cfrmPassword = cfrmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTypeOfBusiness() {
		return typeOfBusiness;
	}
	public void setTypeOfBusiness(String typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
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
	 * @return the businessSetupFlag
	 */
	public char getBusinessSetupFlag() {
		return businessSetupFlag;
	}
	/**
	 * @param businessSetupFlag the businessSetupFlag to set
	 */
	public void setBusinessSetupFlag(char businessSetupFlag) {
		this.businessSetupFlag = businessSetupFlag;
	}

}
