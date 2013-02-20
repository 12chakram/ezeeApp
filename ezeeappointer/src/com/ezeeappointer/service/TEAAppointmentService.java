package com.ezeeappointer.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ezeeappointer.dto.TEAAppointeeDashboardDTO;
import com.ezeeappointer.dto.TEAAppointmentDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAStaffDTO;
import com.ezeeappointer.dto.TEAUIStaffDTO;

public interface TEAAppointmentService extends Serializable {
	
	public List<TEAServiceDTO> retrieveAvailableServicesForBusiness(long businessId);
	public List<TEAUIStaffDTO> searchForStaffDetailsByServiceId(long busnId, long serviceId, Date appointmentDate);
	public void saveAppintmentDetails(TEAAppointmentDTO dto);
	public List<TEAAppointeeDashboardDTO> retrieveAppointeeeDashboardDetails(long userId);
	public void changeAppointmentStatus(long apptNo, String sts);

}
