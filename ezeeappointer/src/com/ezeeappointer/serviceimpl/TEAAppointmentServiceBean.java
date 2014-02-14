package com.ezeeappointer.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ezeeappointer.dao.TEAAppointmentDAO;
import com.ezeeappointer.data.Appointment;
import com.ezeeappointer.data.Service;
import com.ezeeappointer.data.Staff;
import com.ezeeappointer.dto.TEAAppointmentDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAStaffDTO;
import com.ezeeappointer.service.TEAAppointmentService;

public class TEAAppointmentServiceBean extends TEABasicAbstractServiceBean implements TEAAppointmentService{
	private Mapper mapper = new DozerBeanMapper();
	public void userAppointent(TEAAppointmentDTO appDTO){
		Appointment app = new Appointment();	
		app.setChooseService(appDTO.getChooseService());
		app.setAppointmentDate(appDTO.getAppointmentDate());
		app.setAvailableSlots(appDTO.getAvailableSlots());
		app.setStaffDescription(appDTO.getStaffDescription());
		app.setChooseDoctor(appDTO.getChooseDoctor());
		app.setSelectDOAppointment(appDTO.getSelectDOAppointment());
		app.setListofAvailableSlots(appDTO.getListofAvailableSlots());
		app.setSelectServices(appDTO.getSelectServices());
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		dao.addAppointment(app);		
		
	}
	
	public List<TEAServiceDTO> retrieveAvailableServicesForBusiness(long businessId){
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		List<Service> srvcs = dao.retrieveServicesByBusinessId(businessId);
		List<TEAServiceDTO> srvcDTOs = new ArrayList<TEAServiceDTO>();
		for(Service srvc:srvcs){
			srvcDTOs.add(mapper.map(srvc, TEAServiceDTO.class));
		}
		return srvcDTOs;
	}
	
	public List<TEAStaffDTO> searchForStaffDetailsByServiceId(long serviceId){
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		List<Staff> staff = dao.retrieveStaffDetailsByServiceId(serviceId);
		List<TEAStaffDTO> stfDTOs = new ArrayList<TEAStaffDTO>();
		for(Staff stf:staff){
			stfDTOs.add(mapper.map(stf, TEAStaffDTO.class));
		}
		return stfDTOs;
	}

}
