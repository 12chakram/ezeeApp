package com.ezeeappointer.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.ezeeappointer.dto.TEAAppointmentDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.service.TEAAppointmentService;
import com.ezeeappointer.service.TEABusinessDetailService;

@ManagedBean(name="appointmentbean")
@RequestScoped

public class TEAAppointmentMBean extends BaseMBean {
	private String service;
	private String appointmentDate;
	private String availableSlots;
	private String staffDescription;
	private String chooseDoctor;
	private String selectDOAppointment;
	private String listofAvailableSlots;
	private String selectServices;
	private List<SelectItem> serviceSelectItems;
	private boolean displayApptDtls;
	
	/**
	 * @return the chooseService
	 * 
	 * 
	 */
	public String userAppontment(){
		
		TEAAppointmentDTO appDTO= new TEAAppointmentDTO();
		appDTO.setChooseService(service);
		appDTO.setAppointmentDate(appointmentDate);
		appDTO.setAvailableSlots(availableSlots);
		appDTO.setStaffDescription(staffDescription);
		appDTO.setChooseDoctor(chooseDoctor);
		appDTO.setSelectDOAppointment(selectDOAppointment);
		appDTO.setListofAvailableSlots(listofAvailableSlots);
		appDTO.setSelectServices(selectServices);
		
		

		TEAAppointmentService service= (TEAAppointmentService) getBackendService("appointmentService");
		service.userAppointent(appDTO);
		return "ezeedashboard";
	}
	
	public String searchForStaff(){
		TEAAppointmentService srvc= (TEAAppointmentService) getBackendService("appointmentService");
		srvc.searchForStaffDetailsByServiceId(Long.parseLong(service));
		displayApptDtls = true;
		return null;
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
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
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
	 * @return the displayApptDtls
	 */
	public boolean isDisplayApptDtls() {
		return displayApptDtls;
	}

	/**
	 * @param displayApptDtls the displayApptDtls to set
	 */
	public void setDisplayApptDtls(boolean displayApptDtls) {
		this.displayApptDtls = displayApptDtls;
	}
	
	
	
	
	
	

}
