/**
 * 
 */
package com.ezeeappointer.serviceimpl;

import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ezeeappointer.dao.TEABusinessUserManagementDAO;
import com.ezeeappointer.data.BusinessUser;
import com.ezeeappointer.dto.TEABusinessUserDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
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
