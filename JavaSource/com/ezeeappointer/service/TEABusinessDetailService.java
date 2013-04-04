package com.ezeeappointer.service;


import com.ezeeappointer.dto.TEABusinessDetailDTO;
import com.ezeeappointer.dto.TEABusinessUserDTO;

public interface TEABusinessDetailService {
	
	/**
	 * @param businessDTO
	 */
	public void createBusiness(TEABusinessDetailDTO businessDTO,TEABusinessUserDTO busnUser);
	
	/**
	 *  this method to get business user profile Data
	 *
	 * @param userId
	 * @return
	 */
	
	public TEABusinessDetailDTO getBusinessDetailsbyUserId(long userId);

	

}
