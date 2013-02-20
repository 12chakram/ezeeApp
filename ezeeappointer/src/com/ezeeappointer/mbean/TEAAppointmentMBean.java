package com.ezeeappointer.mbean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


import com.ezeeappointer.common.TEAServiceDelegate;
import com.ezeeappointer.dto.TEAAppointeeUserDTO;
import com.ezeeappointer.dto.TEAAppointmentDTO;
import com.ezeeappointer.dto.TEAAppointmentSlotDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAUIStaffDTO;
import com.ezeeappointer.service.TEAAppointeeUserManagementService;
import com.ezeeappointer.service.TEAAppointmentService;
import com.ezeeappointer.utilities.TEADateUtility;

@ManagedBean(name="appointmentbean")
@RequestScoped
public class TEAAppointmentMBean extends TEASecureMbean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7965565902076459195L;
	private String selectedStaffIndex;
	private List<SelectItem> serviceSelectItems;
	@ManagedProperty(value="#{appointmentDtlBean}")
	private TEAApointmentDetailsMBean aptDtlsMbean;
	private List<TEAAppointmentSlotDTO> aptSlots;
	private List<String> busnHours;
	private TEAAppointmentService aptService;
	private boolean loginRequired;
	private boolean basicInfoRequired;
	private TEAAppointeeUserDTO appointee;
	private String slotNotSelectedMsg;
	
	public TEAAppointmentMBean(){
		
		aptService = (TEAAppointmentService) getBackendService("appointmentService");
		appointee = new TEAAppointeeUserDTO();
	}
	
	public String searchForStaff() throws ParseException{
		
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd-MM-yyyy");
		aptDtlsMbean.setUiStaffDTOs(aptService.searchForStaffDetailsByServiceId(10001, Long.parseLong(aptDtlsMbean.getSelectedService()), dateFormate.parse(aptDtlsMbean.getSearchDate())));
		TEAUIStaffDTO uiStaffDTO = aptDtlsMbean.getUiStaffDTOs().get(0);
		selectedStaffIndex = Long.toString(uiStaffDTO.getStaffId());
		aptSlots = uiStaffDTO.getAptSlots();
		busnHours = uiStaffDTO.getBusnHours();
		aptDtlsMbean.setDisplayApptDtls( true);
		aptDtlsMbean.setSelectedTime(null);
		aptDtlsMbean.setSelectedUIStaffDTO(uiStaffDTO);
		return null;
	}
	
	public void changeSelectedStaff(){
		
		TEAUIStaffDTO uiStaffDTO = null;
		for(TEAUIStaffDTO dto:aptDtlsMbean.getUiStaffDTOs()){
			if(Long.parseLong(selectedStaffIndex) == dto.getStaffId())
				uiStaffDTO = dto;
		}
		aptSlots = uiStaffDTO.getAptSlots();
		busnHours = uiStaffDTO.getBusnHours();
		aptDtlsMbean.setSelectedTime(null); 
		aptDtlsMbean.setSelectedUIStaffDTO(uiStaffDTO);
	}
	
	
	
	public String bookAppointment(){
		
			aptDtlsMbean.setSelectedTime(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedtime"));
			//TEAAppointeeUserDTO user = (TEAAppointeeUserDTO)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get( "APPT_USER") ;
			if(aptDtlsMbean.getSelectedTime() == null || aptDtlsMbean.getSelectedTime().equals("")){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"", "Please select a time slot to book appointment."));
				return null;
			}else if(getActiveUser().getApptUser()== null){
				loginRequired = true;
				return null;
			}else{
				saveAppintmentDetails(getActiveUser().getApptUser().getId());
				return "appointmentbooked";
			}
	}
	
	public String login(){
		
		TEAAppointeeUserDTO u = null;		
		if(appointee.getEmail() != null && appointee.getPassword() != null){
			TEAAppointeeUserManagementService service = (TEAAppointeeUserManagementService)TEAServiceDelegate.getService("appointeeUserService");			
			u = service.login(appointee.getEmail(), appointee.getPassword());
			if(u != null){
				saveAppintmentDetails(u.getId());
				getActiveUser().setApptUser(u);//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("APPT_USER", u);
				return "appointmentbooked";
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"", "Invalid credentials."));
		return null;
	}
	
	public String register(){
		
		TEAAppointeeUserManagementService service = (TEAAppointeeUserManagementService) getBackendService("appointeeUserService");
		boolean isSuccess = service.register(appointee);
		if(!isSuccess) return null;
		saveAppintmentDetails(appointee.getId());
		getActiveUser().setApptUser(appointee);//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("APPT_USER", appointee);		
		return "appointmentbooked";
	}
	
	private void saveAppintmentDetails(long id){
		
		TEAAppointmentDTO apptDTO = new TEAAppointmentDTO();
		String[] apptSlot = aptDtlsMbean.getSelectedTime().split("\\|");
		apptDTO.setApptDate(TEADateUtility.convertStringddMMyyyyHiphnedToDate(apptSlot[0]));
		apptDTO.setApptTime(apptSlot[1]);
		apptDTO.setApptTakenDate(new Date());
		apptDTO.setSearchDate(TEADateUtility.convertStringddMMyyyyHiphnedToDate(aptDtlsMbean.getSearchDate()));
		apptDTO.setStaffId(aptDtlsMbean.getSelectedUIStaffDTO().getStaffId());
		apptDTO.setServiceId(Long.parseLong(aptDtlsMbean.getSelectedService()));
		apptDTO.setBusnId(10001);
		apptDTO.setApptSts("p");
		apptDTO.setUserId(id);
		aptService.saveAppintmentDetails(apptDTO);
		
	}

	/**
	 * @return the serviceSelectItems
	 */
	public List<SelectItem> getServiceSelectItems() {
		TEAAppointmentService service= (TEAAppointmentService) getBackendService("appointmentService");
		List<TEAServiceDTO> dtos = service.retrieveAvailableServicesForBusiness(10001);
		serviceSelectItems = new ArrayList<SelectItem>();
		serviceSelectItems.add(new SelectItem(null, "Choose a Service"));
		for(TEAServiceDTO dto: dtos){
			serviceSelectItems.add(new SelectItem(dto.getId(), dto.getServiceName()));
		}
		return serviceSelectItems;
	}


	/**
	 * @return the aptSlots
	 */
	public List<TEAAppointmentSlotDTO> getAptSlots() {
		return aptSlots;
	}

	/**
	 * @return the loginRequired
	 */
	public boolean isLoginRequired() {
		return loginRequired;
	}

	/**
	 * @return the basicInfoRequired
	 */
	public boolean isBasicInfoRequired() {
		return basicInfoRequired;
	}

	/**
	 * @return the selectedStaffIndex
	 */
	public String getSelectedStaffIndex() {
		return selectedStaffIndex;
	}

	/**
	 * @param selectedStaffIndex the selectedStaffIndex to set
	 */
	public void setSelectedStaffIndex(String selectedStaffIndex) {
		this.selectedStaffIndex = selectedStaffIndex;
	}

	/**
	 * @return the aptDtlsMbean
	 */
	public TEAApointmentDetailsMBean getAptDtlsMbean() {
		return aptDtlsMbean;
	}

	/**
	 * @param aptDtlsMbean the aptDtlsMbean to set
	 */
	public void setAptDtlsMbean(TEAApointmentDetailsMBean aptDtlsMbean) {
		this.aptDtlsMbean = aptDtlsMbean;
	}

	/**
	 * @return the busnHours
	 */
	public List<String> getBusnHours() {
		return busnHours;
	}

	/**
	 * @return the appointee
	 */
	public TEAAppointeeUserDTO getAppointee() {
		return appointee;
	}

	/**
	 * @param appointee the appointee to set
	 */
	public void setAppointee(TEAAppointeeUserDTO appointee) {
		this.appointee = appointee;
	}

	/**
	 * @return the slotNotSelectedMsg
	 */
	public String getSlotNotSelectedMsg() {
		return slotNotSelectedMsg;
	}

	/**
	 * @param slotNotSelectedMsg the slotNotSelectedMsg to set
	 */
	public void setSlotNotSelectedMsg(String slotNotSelectedMsg) {
		this.slotNotSelectedMsg = slotNotSelectedMsg;
	}

}
