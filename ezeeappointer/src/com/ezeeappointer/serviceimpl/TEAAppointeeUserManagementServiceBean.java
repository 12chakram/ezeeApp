package com.ezeeappointer.serviceimpl;

import com.ezeeappointer.dao.TEAAppointeeUserManagementDAO;
import com.ezeeappointer.data.AppointeeUser;
import com.ezeeappointer.dto.TEAAppointeeUserDTO;
import com.ezeeappointer.service.TEAAppointeeUserManagementService;

public class TEAAppointeeUserManagementServiceBean extends TEABasicAbstractServiceBean implements TEAAppointeeUserManagementService{
	
	
	
	public boolean register(TEAAppointeeUserDTO userDTO) {
			
			AppointeeUser user = new AppointeeUser();
			user.setEmail(userDTO.getEmail());
			user.setPassword(userDTO.getPassword());
			user.setFirstName(userDTO.getFirstName());
			user.setLastName(userDTO.getLastName());
			user.setPhoneNo(userDTO.getPhoneNo());
			user.setAddress(userDTO.getAddress());
			user.setCity(userDTO.getCity());
			user.setCountry(userDTO.getCountry());
			
			TEAAppointeeUserManagementDAO dao = getTeaDAOFactory().getTEAAppointeeUserManagementDAO();		
			return dao.addAppointeeUser(user);

}
	/* (non-Javadoc)
	 * @see com.ezeeappointer.service.TEAAppointeeUserManagementService#checkAppointeeUserById(java.lang.String)
	 */
	public boolean checkForDuplicateAppointeeEmail(String email) {
		
		TEAAppointeeUserManagementDAO dao = getTeaDAOFactory().getTEAAppointeeUserManagementDAO();		

		AppointeeUser user = dao.findAppointeeUser(email, null);
		if(user != null)
			return true;
		else
			return false;
	}	

	/* (non-Javadoc)
	 * @see com.ezeeappointer.service.TEABusinessUserManagementService#login(java.lang.String, java.lang.String)
	 */
	public AppointeeUser login(String email, String password) {
		
		TEAAppointeeUserManagementDAO dao = getTeaDAOFactory().getTEAAppointeeUserManagementDAO();
		AppointeeUser user = dao.findAppointeeUser(email, password);		
		return user;
	}
}
