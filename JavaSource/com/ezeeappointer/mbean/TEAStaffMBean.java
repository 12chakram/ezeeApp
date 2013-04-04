/**
 * 
 */
package com.ezeeappointer.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

/**
 * @author dreddy
 *
 */
@ManagedBean(name="teaStaffMBean")
@RequestScoped
public class TEAStaffMBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8796643989564824914L;
	private String staffName;
	private String userName;
	private String password;
	private String cPassword;
	private String staffProfilePicture;
	// to display profile picture name	
	private String profileName = "Choose File";
	private String[] services;
	private List<TEADayAndTimeMBean> dayTimes = new ArrayList<TEADayAndTimeMBean>();
	
	
	/**
	 * @return the staffName
	 */
	public String getStaffName() {
		return staffName;
	}
	/**
	 * @param staffName the staffName to set
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the cPassword
	 */	
	public String getcPassword() {
		return cPassword;
	}
	/**
	 * @param cPassword the cPassword to set
	 */
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	/**
	 * @return the staffProfilePicture
	 */
	public String getStaffProfilePicture() {
		return staffProfilePicture;
	}
	/**
	 * @param staffProfilePicture the staffProfilePicture to set
	 */
	public void setStaffProfilePicture(String staffProfilePicture) {
		this.staffProfilePicture = staffProfilePicture;
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
	public void setDayTimes(List<TEADayAndTimeMBean> dayTimes) {
		this.dayTimes = dayTimes;
	}
	 // method for fileupload
	
	 public void listener(FileUploadEvent event) throws Exception {
	     UploadedFile item = event.getUploadedFile();
	        UploadedImage file = new UploadedImage();
	        file.setLength(item.getData().length);
	        file.setName(item.getName());
	        file.setData(item.getData());
	        staffProfilePicture = item.getData().toString();	
	        profileName =item.getName();
	    
	 //refer this below link     
	//http://stackoverflow.com/questions/1513603/how-to-upload-and-store-an-image-with-google-app-engine-java        
	 // from here image will goto the database   
	        
	        System.out.println("fileuploadsucess");
	}
	/**
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}
	/**
	 * @param profileName the profileName to set
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	/**
	 * @return the services
	 */
	public String[] getServices() {
		return services;
	}
	/**
	 * @param services the services to set
	 */
	public void setServices(String[] services) {
		this.services = services;
	}
	
	 
		
}
	
	