package com.ezeeappointer.service;

import com.ezeeappointer.dto.TEABusinessDetailDTO;

public interface TEABusinessDetailService {
	
	/**
	 * @param businessDTO
	 */
	public void createBusiness(TEABusinessDetailDTO businessDTO, long userId);

}
