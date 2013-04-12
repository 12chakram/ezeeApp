package com.ezeeappointer.mbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.ezeeappointer.common.TEAServiceDelegate;
import com.ezeeappointer.dto.TEABusinessUserDTO;
import com.ezeeappointer.service.TEABusinessUserManagementService;



@ManagedBean(name="busnUserMngmntBean")
@SessionScoped
public class TEABusinessUserManagementMBean extends TEASecureMbean {
	
	

	
	private static final long serialVersionUID = -4850861653651843128L;
	private String userId;
	private String password;
	private String cfrmPassword;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String city;
	private String country = "IN";
	private String typeOfBusiness;
	private String userExistMsg;	
	private List<SelectItem> countrySelectItems;
	private List<SelectItem> typeOfBusinessSelectItems;
	private String loginErrorMsg;
	private boolean thispage;
	
	 private TEABusinessUserDTO busnUser;



public TEABusinessUserDTO getBusnUser() {
		return busnUser;
	}


	public void setBusnUser(TEABusinessUserDTO busnUser) {
		this.busnUser = busnUser;
	}

	private Map<String,String> countries= new HashMap<String,String>();
	
	
	
	public String registerBusinessUser(){
		
		TEABusinessUserDTO userDTO= new TEABusinessUserDTO();
		userDTO.setUserId(userId);
		userDTO.setPassword(password);
		userDTO.setCfrmPassword(cfrmPassword);
		userDTO.setEmail(email);
		userDTO.setFirstName(firstName);
		userDTO.setLastName(lastName);
		userDTO.setPhoneNumber(phoneNumber);
		userDTO.setAddress(address);
		userDTO.setCity(city);
		userDTO.setCountry(country);
		userDTO.setTypeOfBusiness(typeOfBusiness);
		
		TEABusinessUserManagementService service= (TEABusinessUserManagementService) getBackendService("businessUserService");
		boolean isSuccess = service.register(userDTO);
		if(isSuccess)
			return "signupsuccess";
		else
			return "signup";
		
	}	
	
	public String doLogin(){
		TEABusinessUserDTO u = null;		
		if(userId != null && password != null){
			TEABusinessUserManagementService service = (TEABusinessUserManagementService)TEAServiceDelegate.getService("businessUserService");			
			u = service.login(userId, password);
			if(u != null){
				getActiveUser().setBusnUser(u);
			
				if(u.getBusinessSetupFlag().equals("y")) 
					 return "ezeedashboardn";
					 
					return "businesssetup1";
			}
			
		}
		loginErrorMsg = "Invalid credentials.";
		return "index";
	}
	
  
	
	
	public List<SelectItem> getCountrySelectItems() {
		countrySelectItems = new ArrayList<SelectItem>();
		countrySelectItems.add(new SelectItem("", "Choose a Country"));
		countrySelectItems.add(new SelectItem("AF", "Afghanistan"));
		countrySelectItems.add(new SelectItem("AG", "Algeria"));
		countrySelectItems.add(new SelectItem("AT", "Argentina"));
		countrySelectItems.add(new SelectItem("AB", "Aruba"));
		countrySelectItems.add(new SelectItem("AL", "Australia"));
		countrySelectItems.add(new SelectItem("BD", "Bangladesh"));
	    countrySelectItems.add(new SelectItem("BL", "Belgium"));
		countrySelectItems.add(new SelectItem("BZ", "Brazil"));
		countrySelectItems.add(new SelectItem("CH", "China"));
		countrySelectItems.add(new SelectItem("CA", "Canada"));
		countrySelectItems.add(new SelectItem("FR", "France"));
		countrySelectItems.add(new SelectItem("GR", "Germany"));
		countrySelectItems.add(new SelectItem("JA", "Japan"));
		countrySelectItems.add(new SelectItem("IN", "India"));
		countrySelectItems.add(new SelectItem("SF", "SouthAfrica"));
		countrySelectItems.add(new SelectItem("US", "United States"));
		countrySelectItems.add(new SelectItem("UK", "United Kingdom"));
		return countrySelectItems;
	}

	public List<SelectItem> getTypeOfBusinessSelectItems() {
		typeOfBusinessSelectItems = new ArrayList<SelectItem>();
		typeOfBusinessSelectItems.add(new SelectItem("", "select Type of Business"));
		typeOfBusinessSelectItems.add(new SelectItem("Accountant", "Accountant"));
		typeOfBusinessSelectItems.add(new SelectItem("Administrative Professional", "Administrative Professional"));
		typeOfBusinessSelectItems.add(new SelectItem("Beauty Salon", "Beauty Salon"));
		typeOfBusinessSelectItems.add(new SelectItem("Business Consultant", "Business Consultant"));
		typeOfBusinessSelectItems.add(new SelectItem("Car Service", "Car Service"));
		typeOfBusinessSelectItems.add(new SelectItem("Dentist", "Dentist"));
		typeOfBusinessSelectItems.add(new SelectItem("Education &amp; Tutor", "Education &amp; Tutor"));
		typeOfBusinessSelectItems.add(new SelectItem("Financial Services", "Financial Services"));
		typeOfBusinessSelectItems.add(new SelectItem("Fitness", "Fitness"));
		typeOfBusinessSelectItems.add(new SelectItem("Health Clinic", "Health Clinic"));
		typeOfBusinessSelectItems.add(new SelectItem("IT Services", "IT Services"));
		typeOfBusinessSelectItems.add(new SelectItem("Music school", "Music school"));
		typeOfBusinessSelectItems.add(new SelectItem("Personal Trainer", "Personal Trainer"));
		typeOfBusinessSelectItems.add(new SelectItem("Spa &amp; Salon", "Spa &amp; Salon"));
		typeOfBusinessSelectItems.add(new SelectItem("Yoga &amp; Spirtual", "Yoga &amp; Spirtual"));
		typeOfBusinessSelectItems.add(new SelectItem("Other", "Other"));
	  return typeOfBusinessSelectItems;
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


	public String getUserExistMsg() {
		return userExistMsg;
	}


	public void setUserExistMsg(String userExistMsg) {
		this.userExistMsg = userExistMsg;
	}


	public String getLoginErrorMsg() {
		return loginErrorMsg;
	}


	public void setLoginErrorMsg(String loginErrorMsg) {
		this.loginErrorMsg = loginErrorMsg;
	}


	public boolean isThispage() {
		return thispage;
	}


	public void setThispage(boolean thispage) {
		this.thispage = thispage;
	}


	public Map<String, String> getCountries() {
		return countries;
	}


	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}


	public void setCountrySelectItems(List<SelectItem> countrySelectItems) {
		this.countrySelectItems = countrySelectItems;
	}


	public void setTypeOfBusinessSelectItems(
			List<SelectItem> typeOfBusinessSelectItems) {
		this.typeOfBusinessSelectItems = typeOfBusinessSelectItems;
	}

	
	
	
}
