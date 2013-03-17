/**
 * 
 */
package com.ezeeappointer.mbean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

import com.ezeeappointer.common.TEAServiceDelegate;
import com.ezeeappointer.dto.TEABusinessDetailDTO;
import com.ezeeappointer.service.TEABusinessDetailService;

/**
 * @author dreddy
 *
 */
@ManagedBean(name="teaBusinessDetail")
@SessionScoped
public class TEABusinessDetailMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3911083464901222573L;
	private String companyName;
	private String aboutCompany;
	private String tag;
	private String companyAddress;
	private String state;
	private String city;
	private String startingTime;
	private String endingTime;
	private String profilePicture;
	// to display profile picture name	
	private String profilename = "Choose File";
	//Business setup form2 fields
	private List<TEAServiceMBean> services = new ArrayList<TEAServiceMBean>();	
	//Business setup form3 fields
	private List<TEAStaffMBean> staff = new ArrayList<TEAStaffMBean>();
	private List<TEADayAndTimeMBean> dayTimes = new ArrayList<TEADayAndTimeMBean>();

	//business setup4 form fields	
	private Boolean enableWithoutlogin;
	private String emailNotification[];
	private String smsNotifications[];
	private String hrsBfrApptBooked;	
	private String hrsBfrApptCancelled;
	private String daysBfrAdvAppBooked;
	private String hrsBfrAppRemainderNotification;
	
	private boolean serviceFlag;
	
	
	public String getProfilename() {
		return profilename;
	}
	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}
	/**
	 * @return the companyName
	 */
   
	

	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the aboutCompany
	 */
	public String getAboutCompany() {
		return aboutCompany;
	}
	/**
	 * @param aboutCompany the aboutCompany to set
	 */
	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the companyAddress
	 */
	

	public String getCompanyAddress() {
		return companyAddress;
	}
	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
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
	public String getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}
	public String getEndingTime() {
		return endingTime;
	}
	public void setEndingTime(String endingTime) {
		this.endingTime = endingTime;
	}
	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}
	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	
	/**
	 * @return the enableWithoutlogin
	 */
	
	public Boolean getEnableWithoutlogin() {
		return enableWithoutlogin;
	}
	/**
	 * @param enableWithoutlogin the enableWithoutlogin to set
	 */
	public void setEnableWithoutlogin(Boolean enableWithoutlogin) {
		this.enableWithoutlogin = enableWithoutlogin;
	}
	/**
	 * @return the emailNotification
	 */
	public String[] getEmailNotification() {
		return emailNotification;
	}
	/**
	 * @param emailNotification the emailNotification to set
	 */
	public void setEmailNotification(String[] emailNotification) {
		this.emailNotification = emailNotification;
	}
	/**
	 * @return the smsNotifications
	 */
	public String[] getSmsNotifications() {
		return smsNotifications;
	}
	/**
	 * @param smsNotifications the smsNotifications to set
	 */
	public void setSmsNotifications(String[] smsNotifications) {
		this.smsNotifications = smsNotifications;
	}
	/**
	 * @return the hrsBfrApptBooked
	 */
	public String getHrsBfrApptBooked() {
		return hrsBfrApptBooked;
	}
	/**
	 * @param hrsBfrApptBooked the hrsBfrApptBooked to set
	 */
	public void setHrsBfrApptBooked(String hrsBfrApptBooked) {
		this.hrsBfrApptBooked = hrsBfrApptBooked;
	}
	/**
	 * @return the hrsBfrApptCancelled
	 */
	public String getHrsBfrApptCancelled() {
		return hrsBfrApptCancelled;
	}
	/**
	 * @param hrsBfrApptCancelled the hrsBfrApptCancelled to set
	 */
	public void setHrsBfrApptCancelled(String hrsBfrApptCancelled) {
		this.hrsBfrApptCancelled = hrsBfrApptCancelled;
	}
	/**
	 * @return the daysBfrAdvAppBooked
	 */
	
	public String getDaysBfrAdvAppBooked() {
		return daysBfrAdvAppBooked;
	}
	/**
	 * @param daysBfrAdvAppBooked the daysBfrAdvAppBooked to set
	 */
	public void setDaysBfrAdvAppBooked(String daysBfrAdvAppBooked) {
		this.daysBfrAdvAppBooked = daysBfrAdvAppBooked;
	}
	
	/**
	 * @return the hrsBfrAppRemainderNotification
	 */

	public String getHrsBfrAppRemainderNotification() {
		return hrsBfrAppRemainderNotification;
	}
	/**
	 * @param hrsBfrAppRemainderNotification the hrsBfrAppRemainderNotification to set
	 */
	public void setHrsBfrAppRemainderNotification(
			String hrsBfrAppRemainderNotification) {
		this.hrsBfrAppRemainderNotification = hrsBfrAppRemainderNotification;
	}
	

	public List<TEAStaffMBean> getStaff() {
		return staff;
	}
	/**
	 * @param staff the staff to set
	 */
	public void setStaff(List<TEAStaffMBean> staff) {
		this.staff = staff;
	}
	/**
	 * @return the services
	 */
	public List<TEAServiceMBean> getServices() {
		return services;
	}
	/**
	 * @param services the services to set
	 */
	public void setServices(List<TEAServiceMBean> services) {
		this.services = services;
	}
	
	/**
	 * @param event
	 * @throws Exception
	 */
	public void listener(FileUploadEvent event) throws Exception {
		
	    UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        file.setData(item.getData());
        profilePicture = item.getData().toString();	
        profilename =item.getName();    
        //refer this below link     
        //http://stackoverflow.com/questions/1513603/how-to-upload-and-store-an-image-with-google-app-engine-java        
        // from here image will goto the database  
        System.out.println("fileuploadsucess");
	}
	 
	/**
	 * @return the dayTimes
	 */
	public List<TEADayAndTimeMBean> getDayTimes() {
		return dayTimes;
	}
	/**
	 * @param dayTimes the dayTimes to set
	 */
	public void setDayTime(List<TEADayAndTimeMBean> dayTimes) {
		this.dayTimes = dayTimes;
	}
	/**
	 * @return the serviceFlag
	 */
	public boolean isServiceFlag() {
		return serviceFlag;
	}
	/**
	 * @param serviceFlag the serviceFlag to set
	 */
	public void setServiceFlag(boolean serviceFlag) {
		this.serviceFlag = serviceFlag;
	}
	 
	
	public String getBusinessProfileData(){
		
		TEABusinessDetailService service = (TEABusinessDetailService)TEAServiceDelegate.getService("businessService");
		
		  TEABusinessDetailDTO teaBusinessDetailDTO  = service.getBusinessDetailsbyUserId(10001);
		
		  if(teaBusinessDetailDTO!=null){
		    this.companyName =teaBusinessDetailDTO.getCompanyName();
		    this.aboutCompany = teaBusinessDetailDTO.getAboutCompany();
		    this.tag = teaBusinessDetailDTO.getTag();
		    this.companyAddress = teaBusinessDetailDTO.getCompanyAddress();
		    this.state = teaBusinessDetailDTO.getState();
		    this.city = teaBusinessDetailDTO.getCity();
		    this.profilePicture = teaBusinessDetailDTO.getProfilePicture();
		}
		  
		
		return "buserProfile";
	}
	
	
}//class
