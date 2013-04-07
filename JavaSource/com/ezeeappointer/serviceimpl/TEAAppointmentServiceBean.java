package com.ezeeappointer.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ezeeappointer.dao.TEAAppointmentDAO;
import com.ezeeappointer.data.AppointeeDashboard;
import com.ezeeappointer.data.Appointment;
import com.ezeeappointer.data.DayAndTime;
import com.ezeeappointer.data.Service;
import com.ezeeappointer.data.Staff;
import com.ezeeappointer.dto.TEAAppointeeDashboardDTO;
import com.ezeeappointer.dto.TEAAppointmentDTO;
import com.ezeeappointer.dto.TEAAppointmentSlotDTO;
import com.ezeeappointer.dto.TEADayAndTimeDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAStaffDTO;
import com.ezeeappointer.dto.TEAUIStaffDTO;
import com.ezeeappointer.service.TEAAppointmentService;
import com.ezeeappointer.utilities.TEADateUtility;
import com.ezeeappointer.utilities.TEATimePeriodUtility;
import com.ezeeappointer.data.DayAndTime;

public class TEAAppointmentServiceBean extends TEABasicAbstractServiceBean implements TEAAppointmentService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6480131191612552716L;
	private Mapper mapper = new DozerBeanMapper();
	
	
	public List<TEAServiceDTO> retrieveAvailableServicesForBusiness(Long busnId){
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		List<Service> srvcs = dao.retrieveServicesByBusinessId(busnId);
		List<TEAServiceDTO> srvcDTOs = new ArrayList<TEAServiceDTO>();
		for(Service srvc:srvcs){
			srvcDTOs.add(mapper.map(srvc, TEAServiceDTO.class));
		}
		return srvcDTOs;
	}
	
	
	public List<TEAStaffDTO> retrieveAvailableStaffForBusiness(Long busnId){
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		List<Staff> srvcs = dao.retrieveStaffByBusinessId(busnId);
		List<TEAStaffDTO> staffDTOs = new ArrayList<TEAStaffDTO>();
		for(Staff srvc:srvcs){
			staffDTOs.add(mapper.map(srvc, TEAStaffDTO.class));
		}
		return staffDTOs;
	}
	
	
	
	
	
	public List<TEAUIStaffDTO> searchForStaffDetailsByServiceId(long busnId, long serviceId, Date appointmentDate){
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		List<Staff> staffs = dao.retrieveStaffDetailsByServiceId(serviceId);
		
		List<TEAUIStaffDTO> uiStaffDTOs = new ArrayList<TEAUIStaffDTO>();
		for(Staff sf: staffs){
			
			
			TEAUIStaffDTO dto = new TEAUIStaffDTO();
			List<TEADayAndTimeDTO> ldt = new ArrayList<TEADayAndTimeDTO>();
			String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
		
			TEADayAndTimeDTO tdt = new TEADayAndTimeDTO();
			for(DayAndTime dt: sf.getDayTimes()){
				
				tdt.setFromTime(dt.getFromTime());
				tdt.setToTime(dt.getToTime());
				tdt.setDayss(days);
				
				ldt.add(tdt);
				
				//  dt.setDays(days);
				//ldt.add(mapper.map(dt,TEADayAndTimeDTO.class));
			}
			dto.setDayTime(ldt);
			dto.setStaffName(sf.getStaffName());
			dto.setStaffId(sf.getId());
			
			List<TEAServiceDTO> sdt = new ArrayList<TEAServiceDTO>();
			for(Service sr: sf.getServices())
			sdt.add(mapper.map(sr,  TEAServiceDTO.class));
			dto.setServices(sdt);
			dto.setStaffDescription("No description yet..");
			uiStaffDTOs.add(dto);
		}
		for(TEAUIStaffDTO staff:uiStaffDTOs){
			populateAppointmentDetailsForStaff(staff, appointmentDate, busnId, 7);
		}
		return uiStaffDTOs;
	}
	
	private List<String> getAllBookedSlotsByDate(List<Appointment> appts, Date date){
		List<String> bookedSlots = new ArrayList<String>();
		for(int i = appts.size()-1; i >= 0; i--){
			if(appts.get(i).getApptDate().equals(date)){
				bookedSlots.add(appts.get(i).getApptTime());
				appts.remove(i);
			}				
		}
		return bookedSlots;
	}
	
	private void populateAppointmentDetailsForStaff(TEAUIStaffDTO staff, Date appointmentDate, long busnId, int noOfDays){		
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		Calendar startDate = Calendar.getInstance();
			startDate.setTime(appointmentDate);
			Calendar endDate = Calendar.getInstance();
			endDate.setTime(appointmentDate);
			endDate.add(Calendar.DATE, noOfDays);
			Calendar today = Calendar.getInstance();
			today.setTime(new Date());
			Calendar tomorrow = Calendar.getInstance();
			tomorrow.setTime(new Date());
			tomorrow.add(Calendar.DATE, 1);
			List<TEAAppointmentSlotDTO> aptSlots = new ArrayList<TEAAppointmentSlotDTO>();
		    staff.setBusnHours( TEATimePeriodUtility.createAllTimePeriods("08:00 am", "05:00 pm"));
		  List<Appointment> appts = dao.retrieveExistingAppointments(busnId, staff.getStaffId(), startDate.getTime(), endDate.getTime());
		    for(;endDate.after(startDate); startDate.add(Calendar.DATE, 1)){
		    	TEAAppointmentSlotDTO slot = new TEAAppointmentSlotDTO();
		    	String dayMonth = new SimpleDateFormat("dd/MM").format(startDate.getTime());
		    	String dayName = new SimpleDateFormat("EEE").format(startDate.getTime());
		    	String fullDayName = new SimpleDateFormat("EEEE").format(startDate.getTime());
		    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    	String fullDate = sdf.format(startDate.getTime());
		    	String startTime = null;
		    	String endTime = null;
		    	boolean isAvailable = false;
		    	for(TEADayAndTimeDTO dt:staff.getDayTime()){
		    		if(Arrays.asList(dt.getDayss()).contains(fullDayName)){
		    			startTime = ("00000000" + dt.getFromTime()).substring(dt.getFromTime().length());
		    			endTime  =  ("00000000" + dt.getToTime()).substring(dt.getToTime().length());
		    			isAvailable = true;
		    		}
		    	}
		    	if(fullDate.equals(sdf.format(today.getTime()))){
		    		slot.setApptDate("");
			    	slot.setApptDay("Today");
		    	}else if(fullDate.equals(sdf.format(tomorrow.getTime()))){
		    		slot.setApptDate("");
			    	slot.setApptDay("Tomorrow");
		    	}else{
			    	slot.setApptDate(dayMonth);
			    	slot.setApptDay(dayName);
		    	}
		    	slot.setApptFullDate(fullDate);
		    	Map<String, String> slots  = new HashMap<String, String>();
		    	if(isAvailable)
		    		slots = TEATimePeriodUtility.createAllPossiblePeriods(startTime, endTime, "AVL");
		    	//slots.putAll(TEATimePeriodUtility.createAllPossiblePeriods("02:00 pm", "04:30 pm", "AVL"));
		    	for(String bslot: getAllBookedSlotsByDate(appts, startDate.getTime()))
		    		slots.put(bslot, "BK");
		    	slot.setApptSlots(slots);
		    	aptSlots.add(slot);
		    }
		    staff.setAptSlots(aptSlots);
		
	}
	
	public void saveAppintmentDetails(TEAAppointmentDTO dto){
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		//dto.setId(getTeaSeqGenService().generateNextSequenceNumber("Appointment"));
		dao.addAppointment(mapper.map(dto, Appointment.class));
	}
	
	public List<TEAAppointeeDashboardDTO> retrieveAppointeeeDashboardDetails(long userId){
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		List<TEAAppointeeDashboardDTO> apptDTOs = new ArrayList<TEAAppointeeDashboardDTO>();
		List<AppointeeDashboard> apptDbs = dao.retrieveAppointmetsByUserId(userId);
		for(AppointeeDashboard apptDb: apptDbs){
			TEAAppointeeDashboardDTO dto = mapper.map(apptDb, TEAAppointeeDashboardDTO.class);
			StringBuffer sb = new StringBuffer();
			sb.append("Your appointment is booked for ").append(apptDb.getApptService()).append(" service with Dr. ").append(apptDb.getApptStaff()).append(" on " ).append(
			TEADateUtility.convertDateObjectToEEEEMMMMyyyyWithCommasAndSpaces(apptDb.getApptDate())).append(" between ").append(apptDb.getApptTime());
			dto.setApptDescr(sb.toString());
			dto.setApptDate(TEADateUtility.convertDateObjectToddMMMyyyyWithCommasAndSpaces(apptDb.getApptDate()));
			dto.setApptTakenDate(TEADateUtility.convertDateObjectToddMMMyyyyWithCommasAndSpaces(apptDb.getApptTakenDate()));
			if(apptDb.getApptSts().equals("p")) dto.setApptSts("Pending");
			else if(apptDb.getApptSts().equals( "a")) dto.setApptSts("Approved");
			else if(apptDb.getApptSts().equals("d")) dto.setApptSts("Denied");
			else if(apptDb.getApptSts().equals("c")) dto.setApptSts("Cancelled");
			apptDTOs.add(dto);
		}
		return apptDTOs;
	}
	
	public void changeAppointmentStatus(long apptNo, String sts){
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		dao.updateAppointmentStatus(apptNo, sts);
	}

	
	
	public TEAUIStaffDTO searchForStaffDetailsByStaffId(long busnId, long staffId,Date appointmentDate){
		TEAAppointmentDAO dao = getTeaDAOFactory().getTEAUserAppointmentDAO();
		TEAUIStaffDTO  staff = dao.retrieveServiceDetailsByStaffId(staffId);		
		populateAppointmentDetailsForStaff(staff, appointmentDate, busnId ,7);
		return staff;
	}
	
	

}
