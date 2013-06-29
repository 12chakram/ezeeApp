
package com.ezeeappointer.mbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.ezeeappointer.dto.TEABusinessDetailDTO;
import com.ezeeappointer.dto.TEADayAndTimeDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAStaffDTO;
import com.ezeeappointer.service.TEABusinessDetailService;


@ManagedBean(name="businessSetup")
@RequestScoped
	public class TEABusinessSetupMBean extends TEASecureMbean {
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 4450582646450241502L;
		@ManagedProperty(value="#{teaBusinessDetail}")
		private TEABusinessDetailMBean businessDetail;	
		@ManagedProperty(value="#{teaServiceMBean}")
		private TEAServiceMBean service;
		@ManagedProperty(value="#{teaStaffMBean}")
		private TEAStaffMBean staff;	
		@ManagedProperty(value="#{teaDayAndTimeMBean}")
		private TEADayAndTimeMBean dayTime;	
		private List<SelectItem> stateSelectItems;
		private List<SelectItem> durationSelectItems;
		private List<SelectItem> citySelectItems;
		private List<SelectItem> servicesSelectItems;
		private List<SelectItem> weekDaysSelectItems;
		private Map<String, String> businessWorkflow = new HashMap<String ,String>();
		
		public TEABusinessSetupMBean() throws Exception{
//			HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//			HttpServletResponse resp = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
//			if(businessWorkflow.isEmpty()){
//				String url = req.getRequestURL().toString();
//				String uri = req.getRequestURI();
//				String root = url.substring( 0, url.indexOf(uri) );
//				businessWorkflow.put(root + "/", root + "/businesssetup1.xhtml");
//				businessWorkflow.put(root + "/businesssetup1.xhtml", root + "/businesssetup2.xhtml");
//				businessWorkflow.put(root + "/businesssetup2.xhtml", root + "/businesssetup1.xhtml,"+ root + "/businesssetup3.xhtml");
//				businessWorkflow.put(root + "/businesssetup3.xhtml", root + "/businesssetup2.xhtml," + root + "/businesssetup4.xhtml");
//				businessWorkflow.put(root + "/businesssetup4.xhtml", root + "/businesssetup3.xhtml");
//			}			
//			String referer = FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap().get("referer");//.split("/")[3];
//			String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();//.split("/")[1];
//			try{
//				if (req.getSession().getAttribute("AUTH_KEY") == null ||
//						referer == null || !businessWorkflow.get(referer).contains(viewId)) {
//			      req.getSession().invalidate();
//			      resp.sendRedirect("index.jspx");
//			    }
//				//this.message = (String) ((HttpServletRequest) req).getSession().getAttribute("USER_NAME");
//			}catch(Exception e){
//				req.getSession().invalidate();
//				throw new Exception("Unauthorized access - " + e.getMessage());
//			}
		}
		
		/**
		 * 
		 */
		public void addService(){
			//businessDetail.getServices().add(service);
			TEAServiceMBean newService = new TEAServiceMBean();
			newService.setDescription(service.getDescription());
			newService.setDuration(service.getDuration());
			newService.setPrice(service.getPrice());
			newService.setServiceName(service.getServiceName());
			businessDetail.getServices().add(newService);
			service = null;
			businessDetail.setServiceFlag(true);
		}
		
		/**
		 * 
		 */
		public void addStaff(){
			TEAStaffMBean newStaff = new TEAStaffMBean();
			newStaff.setPassword(staff.getcPassword());
			newStaff.setProfileName(staff.getProfileName());
			newStaff.setServices(staff.getServices());
			newStaff.setStaffName(staff.getStaffName());
			newStaff.setStaffProfilePicture(staff.getStaffProfilePicture());
			newStaff.setUserName(staff.getUserName());
			for(TEADayAndTimeMBean dayTime: businessDetail.getDayTimes()){
				TEADayAndTimeMBean newDayTime = new TEADayAndTimeMBean();
				newDayTime.setDays(dayTime.getDays());
				newDayTime.setFromTime(dayTime.getFromTime());
				newDayTime.setToTime(dayTime.getToTime());
				newStaff.getDayTimes().add(newDayTime);
			}
			staff = null;
			businessDetail.getDayTimes().clear();
			businessDetail.getStaff().add(newStaff);
		}
		
		/**
		 * 
		 */
		public void addDayTime(){
			TEADayAndTimeMBean newDayTime = new TEADayAndTimeMBean();
			newDayTime.setDays(dayTime.getDays());
			newDayTime.setFromTime(dayTime.getFromTime());
			newDayTime.setToTime(dayTime.getToTime());
			dayTime = null;
			businessDetail.getDayTimes().add(newDayTime);
		}
		
		/**
		 * @return
		 */
		public String finishBusinessSetup(){
			TEABusinessDetailDTO businessDTO=new TEABusinessDetailDTO();
			businessDTO.setCompanyName(businessDetail.getCompanyName());
			businessDTO.setAboutCompany(businessDetail.getAboutCompany());
			businessDTO.setTag(businessDetail.getTag());
			businessDTO.setCompanyAddress(businessDetail.getCompanyAddress());
			businessDTO.setState(businessDetail.getState());
			businessDTO.setCity(businessDetail.getCity());
			businessDTO.setStartingTime(businessDetail.getStartingTime());
			businessDTO.setEndingTime(businessDetail.getEndingTime());
			businessDTO.setProfilePicture(businessDetail.getProfilePicture());
			for(TEAServiceMBean srvMBean: businessDetail.getServices()){
				TEAServiceDTO s = new TEAServiceDTO();
				s.setDescription(srvMBean.getDescription());
				s.setDuration(srvMBean.getDuration());
				s.setPrice(srvMBean.getPrice());
				s.setServiceName(srvMBean.getServiceName());				
				businessDTO.getServices().add(s);
			}
			for(TEAStaffMBean stffMBean: businessDetail.getStaff()){
				TEAStaffDTO st = new TEAStaffDTO();
				st.setcPassword(stffMBean.getcPassword());
				st.setPassword(stffMBean.getPassword());
				st.setServices(stffMBean.getServices());
				st.setStaffName(stffMBean.getStaffName());
				st.setStaffProfilePicture(stffMBean.getStaffProfilePicture());
				st.setUserName(stffMBean.getUserName());
				for(TEADayAndTimeMBean daytime: stffMBean.getDayTimes()){
					TEADayAndTimeDTO dt = new TEADayAndTimeDTO();
					dt.setDayss(daytime.getDays());
					dt.setFromTime(daytime.getFromTime());
					dt.setToTime(daytime.getToTime());
					st.getDayTimes().add(dt);
				}
				businessDTO.getStaff().add(st);				
			}
			businessDTO.setEnableWithoutlogin(businessDetail.getEnableWithoutlogin());
			businessDTO.setEmailNotification(businessDetail.getEmailNotification());
			businessDTO.setSmsNotifications(businessDetail.getSmsNotifications());
			businessDTO.setHrsBfrApptBooked(businessDetail.getHrsBfrApptBooked());
			businessDTO.setHrsBfrApptCancelled(businessDetail.getHrsBfrApptCancelled());
			businessDTO.setDaysBfrAdvAppBooked(businessDetail.getDaysBfrAdvAppBooked());
			businessDTO.setHrsBfrAppRemainderNotification(businessDetail.getHrsBfrAppRemainderNotification());
			
			TEABusinessDetailService service= (TEABusinessDetailService) getBackendService("businessService");
			service.createBusiness(businessDTO,getActiveUser().getBusnUser());
			return "ezeedashboardn";
		}
		
		/**
		 * @return
		 */
		public String continueToBusinessSetupStep2(){
			return "businesssetup2";
		}
		
		/**
		 * @return
		 */
		public String continueToBusinessSetupStep3(){
			return "businesssetup3";
		}
		
		/**
		 * @return
		 */
		public String continueToBusinessSetupStep4(){
			return "businesssetup4";
		}
		
		/**
		 * @return the service
		 */
		
		public TEAServiceMBean getService() {
			return service;
		}
		/**
		 * @param service the service to set
		 */
		public void setService(TEAServiceMBean service) {
			this.service = service;
		}
	
		/**
		 * @return the businessDetail
		 */
		public TEABusinessDetailMBean getBusinessDetail() {
			return businessDetail;
		}
	
		/**
		 * @param businessDetail the businessDetail to set
		 */
		public void setBusinessDetail(TEABusinessDetailMBean businessDetail) {
			this.businessDetail = businessDetail;
		}
	
		/**
		 * @return the staff
		 */
		public TEAStaffMBean getStaff() {
			return staff;
		}
	
		/**
		 * @param staff the staff to set
		 */
		public void setStaff(TEAStaffMBean staff) {
			this.staff = staff;
		}
	
		/**
		 * @return the dayAndTime
		 */
		public TEADayAndTimeMBean getDayTime() {
			return dayTime;
		}
	
		/**
		 * @param dayAndTime the dayAndTime to set
		 */
		public void setDayTime(TEADayAndTimeMBean dayTime) {
			this.dayTime = dayTime;
		}
	
		/**
		 * @return the stateSelectItems
		 */
		public List<SelectItem> getStateSelectItems() {
			stateSelectItems = new ArrayList<SelectItem>();
			stateSelectItems.add(new SelectItem(null, "Choose a State"));
			stateSelectItems.add(new SelectItem("AP", "Andhra Pradesh"));
			stateSelectItems.add(new SelectItem("AR", "Arunachal Pradesh"));
			stateSelectItems.add(new SelectItem("AS", "Assam"));
			stateSelectItems.add(new SelectItem("BH", "Bihar"));
			stateSelectItems.add(new SelectItem("CG", "Chhattisgarh"));
			stateSelectItems.add(new SelectItem("DL", "Delhi"));
			stateSelectItems.add(new SelectItem("GA", "Goa"));
			stateSelectItems.add(new SelectItem("GJ", "Gujarat"));
			stateSelectItems.add(new SelectItem("HP", "Himachal Pradesh"));
			stateSelectItems.add(new SelectItem("JK", "Jammu & Kashmir"));
			stateSelectItems.add(new SelectItem("KA", "Karnataka"));
			stateSelectItems.add(new SelectItem("KL", "Kerala"));
			stateSelectItems.add(new SelectItem("MP", "Madhya Pradesh"));
			stateSelectItems.add(new SelectItem("MH", "Maharashtra"));
			stateSelectItems.add(new SelectItem("MN", "Manipur"));
			stateSelectItems.add(new SelectItem("ML", "Meghalaya"));
			stateSelectItems.add(new SelectItem("MZ", "Mizoram"));
			stateSelectItems.add(new SelectItem("NL", "Nagaland"));
			stateSelectItems.add(new SelectItem("OR", "Orissa"));
			stateSelectItems.add(new SelectItem("PB", "Punjab"));
			stateSelectItems.add(new SelectItem("RJ", "Rajasthan"));
			stateSelectItems.add(new SelectItem("SK", "Sikkim"));
			stateSelectItems.add(new SelectItem("TN", "TamilNadu"));
			stateSelectItems.add(new SelectItem("TR", "Tripura"));
			stateSelectItems.add(new SelectItem("UK", "Uttarakhand"));
			stateSelectItems.add(new SelectItem("UP", "Uttar Pradesh"));
			stateSelectItems.add(new SelectItem("WB", "West Bengal"));
			return stateSelectItems;
		}
		
		public List<SelectItem> getCitySelectItems() {
			citySelectItems = new ArrayList<SelectItem>();
			
			if(businessDetail.getState()==null){
				citySelectItems.add(new SelectItem("", "Choose a State"));
			}
			else if(businessDetail.getState().equalsIgnoreCase("AP")){
				citySelectItems.add(new SelectItem("HYD", "Hyderabad"));
				citySelectItems.add(new SelectItem("TPT", "Tirupathi"));
			}else if (businessDetail.getState().equalsIgnoreCase("AR")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("AS")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("BH")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("CG")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("DL")) {
				citySelectItems.add(new SelectItem("DL", "Delhi"));
				
			}else if (businessDetail.getState().equalsIgnoreCase("GA")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("GJ")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("HP")) {
				citySelectItems.add(new SelectItem("SM", "Simla"));
				
			}else if (businessDetail.getState().equalsIgnoreCase("JK")) {
				citySelectItems.add(new SelectItem("SRN", "Srinagar"));
				
			}else if (businessDetail.getState().equalsIgnoreCase("KA")) {
				citySelectItems.add(new SelectItem("BNG", "Banglore"));
				
			}else if (businessDetail.getState().equalsIgnoreCase("KL")) {
				citySelectItems.add(new SelectItem("TRD", "Trivendram"));
				
			}else if (businessDetail.getState().equalsIgnoreCase("MP")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("MH")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("MN")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("ML")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("MZ")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("NL")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("OR")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("PB")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("RJ")) {
				citySelectItems.add(new SelectItem("JP", "Jaipurd"));
				
			}else if (businessDetail.getState().equalsIgnoreCase("SK")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("TN")) {
				citySelectItems.add(new SelectItem("CHN", "Chennai"));
				
			}else if (businessDetail.getState().equalsIgnoreCase("TR")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("UK")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("UP")) {
				
			}else if (businessDetail.getState().equalsIgnoreCase("WB")) {
				citySelectItems.add(new SelectItem("CLT", "Colcutta"));
			}
			
			/*citySelectItems.add(new SelectItem(null, "Choose a city"));
			citySelectItems.add(new SelectItem("DL", "Delhi"));
			citySelectItems.add(new SelectItem("BNG", "Banglore"));
			citySelectItems.add(new SelectItem("CHN", "Chennai"));
			
			citySelectItems.add(new SelectItem("TRD", "Trivendram"));
			
			citySelectItems.add(new SelectItem("BNS", "Bhuvaneswar"));
			citySelectItems.add(new SelectItem("CLT", "Colcutta"));
			citySelectItems.add(new SelectItem("JP", "Jaipurd"));
			citySelectItems.add(new SelectItem("PT", "Patna"));
			citySelectItems.add(new SelectItem("SM", "Simla"));
			citySelectItems.add(new SelectItem("IPL", "Impal"));
			citySelectItems.add(new SelectItem("DSR", "Dispur"));
			citySelectItems.add(new SelectItem("SLG", "Shillang"));
			citySelectItems.add(new SelectItem("SRN", "Srinagar"));*/
			
			return citySelectItems;
			}
	//SECONDFORM
		public List<SelectItem> getDurationSelectItems() {
			durationSelectItems = new ArrayList<SelectItem>();
			durationSelectItems.add(new SelectItem(null, "Choose duration"));
			durationSelectItems.add(new SelectItem("15", "15 minutes"));
			durationSelectItems.add(new SelectItem("30", "30 minutes"));
			durationSelectItems.add(new SelectItem("45", "45 minutes"));
			durationSelectItems.add(new SelectItem("60", "1 hour"));
			durationSelectItems.add(new SelectItem("90", "1 hour 30 minutes"));
			durationSelectItems.add(new SelectItem("120", "2 hours"));
			durationSelectItems.add(new SelectItem("150", "2 hours 30 minutes"));
			durationSelectItems.add(new SelectItem("180", "3 hours"));
			durationSelectItems.add(new SelectItem("210", "3 hours 30 minutes"));
			durationSelectItems.add(new SelectItem("240", "4 hours"));
			durationSelectItems.add(new SelectItem("270", "4 hours 30 minutes"));
			durationSelectItems.add(new SelectItem("300", "5 hours"));
			durationSelectItems.add(new SelectItem("330", "5 hours 30 minutes"));
			durationSelectItems.add(new SelectItem("360", "6 hours"));
			durationSelectItems.add(new SelectItem("390", "6 hours 30 minutes"));
			durationSelectItems.add(new SelectItem("420", "7 hours"));
			durationSelectItems.add(new SelectItem("450", "7 hours 30 minutes"));
			durationSelectItems.add(new SelectItem("480", "8 hourss"));
			return durationSelectItems;
		}
		//Thirdform
		public List<SelectItem> getServicesSelectItems() {
			servicesSelectItems = new ArrayList<SelectItem>();
			servicesSelectItems.add(new SelectItem(null, "Choose a Service"));
			for(TEAServiceMBean service:businessDetail.getServices()){
				servicesSelectItems.add(new SelectItem(service.getServiceName(), service.getServiceName()));
			}	
			return servicesSelectItems;
		}
		
		public List<SelectItem> getWeekDaysSelectItems() {
			weekDaysSelectItems = new ArrayList<SelectItem>();
			weekDaysSelectItems.add(new SelectItem("Monday", "Monday"));
			weekDaysSelectItems.add(new SelectItem("Tuesday", "Tuesday"));
			weekDaysSelectItems.add(new SelectItem("Wednesday", "Wednesday"));
			weekDaysSelectItems.add(new SelectItem("Thursday", "Thursday"));
			weekDaysSelectItems.add(new SelectItem("Friday", "Friday"));
			weekDaysSelectItems.add(new SelectItem("Saturday", "Saturday"));
			for(TEADayAndTimeMBean dayTime: businessDetail.getDayTimes())
				for(String day: dayTime.getDays())
					for(SelectItem item:weekDaysSelectItems)
						if(day.equals(item.getLabel())){
								weekDaysSelectItems.remove(item);
								break;
						}
			return weekDaysSelectItems;
		}
		
		public String deleteAction() {	
			if(service!=null){
		   businessDetail.getServices().remove(service);
			}
			return null;
		}
		
		
		public String deleteStaff() {
				businessDetail.getStaff().remove(staff);
			return null;
		}
}