/**
 * 
 */
package com.ezeeappointer.serviceimpl;

import com.ezeeappointer.dao.TEABusinessUserManagementDAO;
import com.ezeeappointer.data.BusinessUser;
import com.ezeeappointer.dto.TEABusinessUserDTO;
import com.ezeeappointer.service.TEABusinessUserManagementService;

/**
 * @author sairam
 *
 */
public class TEABusinessUserManagementServiceBean extends TEABasicAbstractServiceBean implements TEABusinessUserManagementService {

	/* (non-Javadoc)
	 * @see com.ezeeappointer.service.TEABusinessUserManagementService#register(com.ezeeappointer.dto.TEABusinessUserDTO)
	 */
	public boolean register(TEABusinessUserDTO userDTO) {
		
		BusinessUser user = new BusinessUser();
		user.setId(getTeaSeqGenService().generateNextSequenceNumber("BusinessUser"));
		user.setUserId(userDTO.getUserId());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setAddress(userDTO.getAddress());
		user.setCity(userDTO.getCity());
		user.setCountry(userDTO.getCountry());
		user.setTypeOfBusiness(userDTO.getTypeOfBusiness());
		
		TEABusinessUserManagementDAO dao = getTeaDAOFactory().getTEABusinessUserManagementDAO();		
		return dao.addBusinessUser(user);
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
		TEABusinessUserDTO userDTO = new TEABusinessUserDTO();
		userDTO.setId(user.getId());
		userDTO.setUserId(user.getUserId());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setPhoneNumber(user.getPhoneNumber());
		userDTO.setAddress(user.getAddress());
		userDTO.setCity(user.getCity());
		userDTO.setCountry(user.getCountry());
		userDTO.setTypeOfBusiness(user.getTypeOfBusiness());
		return userDTO;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.ezeeappointer.service.TEABusinessUserManagementService#updateUserBusinessSetupFlag(java.lang.String)
	 */
	public void updateUserBusinessSetupFlag(String userId){
		
	}
}
