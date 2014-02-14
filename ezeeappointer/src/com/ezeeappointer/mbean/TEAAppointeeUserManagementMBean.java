package com.ezeeappointer.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ezeeappointer.common.TEAServiceDelegate;
import com.ezeeappointer.data.AppointeeUser;
import com.ezeeappointer.dto.TEAAppointeeUserDTO;
import com.ezeeappointer.service.TEAAppointeeUserManagementService;

@ManagedBean(name="apptUserMngmntBean")
@RequestScoped

public class TEAAppointeeUserManagementMBean extends BaseMBean {
	private String email;
	private String password;
	private String cfrmPassword;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String address;
	private String city;
	private String country;
	
public String registerAppointeeUser(){
		
		TEAAppointeeUserDTO userDTO= new TEAAppointeeUserDTO();
		userDTO.setEmail(email);
		userDTO.setPassword(password);
		userDTO.setCfrmPassword(cfrmPassword);
		userDTO.setFirstName(firstName);
		userDTO.setLastName(lastName);
		userDTO.setPhoneNo(phoneNo);
		userDTO.setAddress(address);
		userDTO.setCity(city);
		userDTO.setCountry(country);
		
		
		
		TEAAppointeeUserManagementService service= (TEAAppointeeUserManagementService) getBackendService("appointeeUserService");
		boolean isSuccess = service.register(userDTO);
		if(isSuccess)
			return "userlogin";
		else
			return "userregister";
	}

	public String doLogin(){
		AppointeeUser u = null;		
		if(email != null && password != null){
			TEAAppointeeUserManagementService service = (TEAAppointeeUserManagementService)TEAServiceDelegate.getService("appointeeUserService");			
			u = service.login(email, password);
			if(u != null){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
				        "AUTH_KEY", u);
				return "userappointment";
			}
		}
		return "userlogin";
	}
	
	

/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
/**
 * @return the cfrmPassword
 */
public String getCfrmPassword() {
	return cfrmPassword;
}
/**
 * @param cfrmPassword the cfrmPassword to set
 */
public void setCfrmPassword(String cfrmPassword) {
	this.cfrmPassword = cfrmPassword;
}
/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}
/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}
/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}
/**
 * @return the phoneNo
 */
public String getPhoneNo() {
	return phoneNo;
}
/**
 * @param phoneNo the phoneNo to set
 */
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
/**
 * @return the address
 */
public String getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}
/**
 * @return the city
 */
public String getCity() {
	return city;
}
/**
 * @param city the city to set
 */
public void setCity(String city) {
	this.city = city;
}
/**
 * @return the country
 */
public String getCountry() {
	return country;
}
/**
 * @param country the country to set
 */
public void setCountry(String country) {
	this.country = country;
}

// checking svn....

//checkin 2
}
