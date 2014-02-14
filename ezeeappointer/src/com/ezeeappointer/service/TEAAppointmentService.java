package com.ezeeappointer.service;

import java.util.List;

import com.ezeeappointer.dto.TEAAppointmentDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAStaffDTO;

public interface TEAAppointmentService {
	
	public void userAppointent(TEAAppointmentDTO apptDTO);
	public List<TEAServiceDTO> retrieveAvailableServicesForBusiness(long businessId);
	public List<TEAStaffDTO> searchForStaffDetailsByServiceId(long serviceId);

}
