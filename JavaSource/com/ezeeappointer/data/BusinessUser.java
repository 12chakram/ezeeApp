/**
 * 
 */
package com.ezeeappointer.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "BUSINESS_USER")
public class BusinessUser {	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="business_user_id") 
	private long id;
	
	
	@Column(name="user_name")
	private String userId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	
	@Column(name="country")
	private String country;
	
	@Column(name="type_of_business")
	private String typeOfBusiness;
	
	@Column(name="business_setup_flag")
	private String businessSetupFlag = "n";
	
	@Column(name="business_resetpassword_flag")
	private String passwordResetFlag;
	
	
	@OneToMany(targetEntity=Business.class,mappedBy = "busnUser", cascade = CascadeType.ALL)
	private List<Business> business = new ArrayList<Business>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getBusinessSetupFlag() {
		return businessSetupFlag;
	}
	public void setBusinessSetupFlag(String businessSetupFlag) {
		this.businessSetupFlag = businessSetupFlag;
	}
	public String getPasswordResetFlag() {
		return passwordResetFlag;
	}
	public void setPasswordResetFlag(String passwordResetFlag) {
		this.passwordResetFlag = passwordResetFlag;
	}
	
}
