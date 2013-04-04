package com.ezeeappointer.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ezeeappointer.dao.TEABusinessDetailDAO;
import com.ezeeappointer.data.Business;
import com.ezeeappointer.data.BusinessUser;
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
	public void createBusiness(TEABusinessDetailDTO businessDTO, TEABusinessUserDTO teaBusinessUserDTO){
		Business business = new Business();
        BusinessUser busnuser = new BusinessUser();
        		
        busnuser.setAddress(teaBusinessUserDTO.getAddress());
        busnuser.setBusinessSetupFlag(teaBusinessUserDTO.getBusinessSetupFlag());
        busnuser.setCity(teaBusinessUserDTO.getCity());
        busnuser.setCountry(teaBusinessUserDTO.getCountry());
        busnuser.setEmail(teaBusinessUserDTO.getEmail());
        busnuser.setFirstName(teaBusinessUserDTO.getFirstName());
        busnuser.setLastName(teaBusinessUserDTO.getLastName());
        busnuser.setPassword(teaBusinessUserDTO.getPassword());
        busnuser.setPhoneNumber(teaBusinessUserDTO.getPhoneNumber());
        busnuser.setTypeOfBusiness(teaBusinessUserDTO.getTypeOfBusiness());
        busnuser.setUserId(teaBusinessUserDTO.getUserId());
        busnuser.setId(teaBusinessUserDTO.getId());
		
		business.setBusnUser(busnuser);
		business.setCompanyName(businessDTO.getCompanyName());
		business.setAboutCompany(businessDTO.getAboutCompany());
		business.setTag(businessDTO.getTag());
		business.setCompanyAddress(businessDTO.getCompanyAddress());
		business.setState(businessDTO.getState());
		business.setCity(businessDTO.getCity());
		business.setStartingTime(businessDTO.getStartingTime());
		business.setEndingTime(businessDTO.getEndingTime());
		business.setProfilePicture(businessDTO.getProfilePicture());
		for(TEAServiceDTO srvDTO: businessDTO.getServices()){
			Service s = new Service();
			s.setDescription(srvDTO.getDescription());
			s.setDuration(srvDTO.getDuration());
			s.setPrice(srvDTO.getPrice());
			s.setServiceName(srvDTO.getServiceName());
			s.setBusiness(business);
			//s.setBusinessId(business.getId());
			business.getServices().add(s);
		}
		for(TEAStaffDTO stffDTO: businessDTO.getStaff()){
			Staff st = new Staff();
			st.setPassword(stffDTO.getPassword());
			st.setStaffName(stffDTO.getStaffName());
			st.setStaffProfilePicture(stffDTO.getStaffProfilePicture());
			st.setUserName(stffDTO.getUserName());
			st.getServices().add(business.getServices().get(0));
			st.setBusiness(business);
				

			for(TEADayAndTimeDTO daytime: stffDTO.getDayTimes()){
				DayAndTime dt = new DayAndTime();
				
				dt.setDays(daytime.getDays().toString());
				dt.setFromTime(daytime.getFromTime());
				dt.setToTime(daytime.getToTime());
				dt.setStaff(st);
				st.getDayTimes().add(dt);
				}
			
			//st.setBusinessId(business.getId());
			business.getStaff().add(st);
		}
	
		business.setEnableWithoutlogin(businessDTO.getEnableWithoutlogin());
		business.setEmailNotification(businessDTO.getEmailNotification().toString());
		business.setSmsNotifications(businessDTO.getSmsNotifications().toString());
		business.setHrsBfrApptBooked(businessDTO.getHrsBfrApptBooked());
		business.setHrsBfrApptCancelled(businessDTO.getHrsBfrApptCancelled());
		business.setDaysBfrAdvAppBooked(businessDTO.getDaysBfrAdvAppBooked());
		business.setHrsBfrAppRemainderNotification(businessDTO.getHrsBfrAppRemainderNotification());
		
		TEABusinessDetailDAO dao = getTeaDAOFactory().getTEABusinessDetailDAO();
		dao.addBusiness(business);		
		teaBusinessUserService.updateUserBusinessSetupFlag(busnuser.getId());
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
