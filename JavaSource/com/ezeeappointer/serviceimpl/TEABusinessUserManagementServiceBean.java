/**
 * 
 */
package com.ezeeappointer.serviceimpl;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ezeeappointer.dao.TEABusinessUserManagementDAO;
import com.ezeeappointer.data.BusinessUser;
import com.ezeeappointer.dto.TEABusinessUserDTO;
import com.ezeeappointer.dto.TEAUIBussinessDashboardDTO;
import com.ezeeappointer.service.TEABusinessUserManagementService;


/**
 * @author sairam
 *
 */
public class TEABusinessUserManagementServiceBean extends TEABasicAbstractServiceBean implements TEABusinessUserManagementService {

	private Mapper mapper = new DozerBeanMapper();
	/* (non-Javadoc)
	 * @see com.ezeeappointer.service.TEABusinessUserManagementService#register(com.ezeeappointer.dto.TEABusinessUserDTO)
	 */
	public boolean register(TEABusinessUserDTO userDTO) {
		//userDTO.setId(getTeaSeqGenService().generateNextSequenceNumber("BusinessUser"));		
		TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();		
		return dao.addBusinessUser(mapper.map(userDTO, BusinessUser.class));
	}
	
	public boolean updateBusinessUser(TEABusinessUserDTO userDTO){
		TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();		
		return dao.updateBusinessUser(mapper.map(userDTO, BusinessUser.class));
	}

	/* (non-Javadoc)
	 * @see com.ezeeappointer.service.TEABusinessUserManagementService#checkBusinessUserById(java.lang.String)
	 */
	@Override
	public boolean checkForDuplicateBusinessUser(String userId) {
		
		TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();		
		BusinessUser user = dao.findBusinessUser(userId, null);
		if(user != null)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean checkForDuplicateBusinessEmail(String email) {
		
		TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();		
		BusinessUser user = dao.findBusinessUserByEmail(email);
		if(user != null)
			return true;
		else
			return false;
	}

	/* (non-Javadoc)
	 * @see com.ezeeappointer.service.TEABusinessUserManagementService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public TEABusinessUserDTO login(String userId, String password) {
		
		TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();
		BusinessUser user = dao.findBusinessUser(userId, password);	
		if(user != null)
			return mapper.map(user, TEABusinessUserDTO.class);
		else
			return null;
	}
	
	@Override
	public TEABusinessUserDTO generateNewPassword(String userId) {
		
		TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();
		BusinessUser user = dao.findBusinessUser(userId);
		StringBuffer generatedpassword = null;
		if(user != null){
		   generatedpassword = new StringBuffer();
		   generatedpassword.append(user.getTypeOfBusiness().substring(2, 5));
		   generatedpassword.append(user.getBusinessSetupFlag().toUpperCase());
		   generatedpassword.append(user.hashCode());
		   generatedpassword.append(user.getCountry().charAt(1));
		   generatedpassword.append(user.getPhoneNumber().charAt(5));
		   generatedpassword.append(user.getId());
		   Random randomGenerator = new Random();
		   generatedpassword.append(randomGenerator.nextInt(100));
		   generatedpassword.append(user.getEmail().indexOf(4));
		   generatedpassword.append(user.getId()*user.getId());
		   user.setPassword(generatedpassword.substring(1, 8));
		   user.setPasswordResetFlag("y");
		  if(updateBusinessUser( mapper.map(user, TEABusinessUserDTO.class))){
			return mapper.map(user, TEABusinessUserDTO.class);
		  }
		}
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see com.ezeeappointer.service.TEABusinessUserManagementService#updateUserBusinessSetupFlag(java.lang.String)
	 */
	public void updateUserBusinessSetupFlag(long userId){
		TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();
		dao.updateBusinessSetupFlag(userId);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ezeeappointer.service.TEABusinessUserManagementService#getDashboardApptDetails(long)
	 */
	
	public TEAUIBussinessDashboardDTO getDashboardApptDetails(long bid)
	{
		TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();
		return dao.getDashboardApptDetails(bid);
	}
	
	public boolean updateDashboardPendingApnt(long k,String whichbuttonclicked)
	{
		TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();
		return dao.updateDashboardPendingApnt(k,whichbuttonclicked);
	}
	public int getPendingAptcount(long id)
		{
				TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();
					return dao.getPendingAptcount(id);
		}

	
	
}
