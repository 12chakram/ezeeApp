package com.ezeeappointer.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ezeeappointer.dao.TEABusinessDetailDAO;
import com.ezeeappointer.data.Business;
import com.ezeeappointer.data.DayAndTime;
import com.ezeeappointer.data.Service;
import com.ezeeappointer.data.ServiceAndStaffXREF;
import com.ezeeappointer.data.Staff;
import com.ezeeappointer.dto.TEABusinessDetailDTO;
import com.ezeeappointer.dto.TEABusinessUserDTO;
import com.ezeeappointer.dto.TEADayAndTimeDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAStaffDTO;
import com.ezeeappointer.service.TEABusinessDetailService;
import com.ezeeappointer.service.TEABusinessUserManagementService;

public class TEABusinessDetailServiceBean extends TEABasicAbstractServiceBean implements TEABusinessDetailService {
	
	private TEABusinessUserManagementService teaBusinessUserService;
	private Mapper mapper = new DozerBeanMapper();
	
	/* (non-Javadoc)
	 * @see com.ezeeappointer.service.TEABusinessDetailService#createBusiness(com.ezeeappointer.dto.TEABusinessDetailDTO)
	 */
	public void createBusiness(TEABusinessDetailDTO businessDTO, long userId){
		Business business = new Business();
		business.setId(getTeaSeqGenService().generateNextSequenceNumber("Business"));
		business.setUserId(userId);
		business.setCompanyName(businessDTO.getCompanyName());
		business.setAboutCompany(businessDTO.getAboutCompany());
		business.setTag(businessDTO.getTag());
		business.setCompanyAddress(businessDTO.getCompanyAddress());
		business.setState(businessDTO.getState());
		business.setCity(businessDTO.getCity());
		business.setStartingTime(businessDTO.getStartingTime());
		business.setEndingTime(businessDTO.getEndingTime());
		business.setProfilePicture(businessDTO.getProfilePicture());
		//List<Service> services = new ArrayList<Service>();
		long serviceSeq = getTeaSeqGenService().generateNextSequenceNumber("Service");
		for(TEAServiceDTO srvDTO: businessDTO.getServices()){
			Service s = new Service();
			s.setId(serviceSeq);
			s.setDescription(srvDTO.getDescription());
			s.setDuration(srvDTO.getDuration());
			s.setPrice(srvDTO.getPrice());
			s.setServiceName(srvDTO.getServiceName());
			s.setBusinessId(business.getId());
			business.getServices().add(s);
			serviceSeq++;
			//services.add(s);
		}

		//business.setServices(services);
		
		//List<Staff> staff = new ArrayList<Staff>();
		long staffSeq = getTeaSeqGenService().generateNextSequenceNumber("Staff");
		long dayTimeSeq = getTeaSeqGenService().generateNextSequenceNumber("DayAndTime");
		Map<String, Long> serviceMap = new HashMap<String, Long>();
		for(Service s: business.getServices()) serviceMap.put(s.getServiceName(), s.getId());
		for(TEAStaffDTO stffDTO: businessDTO.getStaff()){
			Staff st = new Staff();
			st.setId(staffSeq);
			st.setPassword(stffDTO.getPassword());
			st.setStaffName(stffDTO.getStaffName());
			st.setStaffProfilePicture(stffDTO.getStaffProfilePicture());
			st.setUserName(stffDTO.getUserName());
			for(String service: stffDTO.getServices()){
				ServiceAndStaffXREF xref = new ServiceAndStaffXREF();
				xref.setBusinessId(business.getId());
				xref.setStaffId(st.getId());
				xref.setServiceId(serviceMap.get(service));
				st.getSrvcStaffXref().add(xref);
			}
			//List<DayAndTime> dtList = new ArrayList<DayAndTime>();
			for(TEADayAndTimeDTO daytime: stffDTO.getDayTimes()){
				DayAndTime dt = new DayAndTime();
				dt.setId(dayTimeSeq);
				dt.setDays(daytime.getDays());
				dt.setFromTime(daytime.getFromTime());
				dt.setToTime(daytime.getToTime());
				dt.setStaffId(staffSeq);
				st.getDayTimes().add(dt);
				//dtList.add(dt);
				dayTimeSeq++;
			}
			//st.setDayTime(dtList);
			//staff.add(st);
			st.setBusinessId(business.getId());
			business.getStaff().add(st);
			staffSeq++;
			
		}
		//business.setStaff(staff);
		business.setEnableWithoutlogin(businessDTO.getEnableWithoutlogin());
		business.setEmailNotification(businessDTO.getEmailNotification());
		business.setSmsNotifications(businessDTO.getSmsNotifications());
		business.setHrsBfrApptBooked(businessDTO.getHrsBfrApptBooked());
		business.setHrsBfrApptCancelled(businessDTO.getHrsBfrApptCancelled());
		business.setDaysBfrAdvAppBooked(businessDTO.getDaysBfrAdvAppBooked());
		business.setHrsBfrAppRemainderNotification(businessDTO.getHrsBfrAppRemainderNotification());
		
		TEABusinessDetailDAO dao = getTeaDAOFactory().getTEABusinessDetailDAO();
		dao.addBusiness(business);		
		teaBusinessUserService.updateUserBusinessSetupFlag(userId);
	}

	/**
	 * @return the teaBusinessUserService
	 */
	public TEABusinessUserManagementService getTeaBusinessUserService() {
		return teaBusinessUserService;
	}

	/**
	 * @param teaBusinessUserService the teaBusinessUserService to set
	 */
	public void setTeaBusinessUserService(
			TEABusinessUserManagementService teaBusinessUserService) {
		this.teaBusinessUserService = teaBusinessUserService;
	}
	
	
	//========================================================================================================
	// this section for Edit/Update Existing details
	
	
	
	public TEABusinessDetailDTO getBusinessDetailsbyUserId(long userId){
		
		TEABusinessDetailDAO dao = getTeaDAOFactory().getTEABusinessDetailDAO();
	
		TEABusinessDetailDTO teaBusinessDetailDTO = new TEABusinessDetailDTO();
		Business business = dao.getBusinessDetailsbyUserId(userId);
		
		teaBusinessDetailDTO.setCompanyName(business.getCompanyName());
		teaBusinessDetailDTO.setAboutCompany(business.getAboutCompany());
		teaBusinessDetailDTO.setTag(business.getTag());
		teaBusinessDetailDTO.setCompanyAddress(business.getCompanyAddress());
		teaBusinessDetailDTO.setState(business.getState());
		teaBusinessDetailDTO.setCity(business.getCity());
		return teaBusinessDetailDTO;

}


}
