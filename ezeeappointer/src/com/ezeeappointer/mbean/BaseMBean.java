package com.ezeeappointer.mbean;

import java.io.Serializable;

import com.ezeeappointer.common.TEAServiceDelegate;
import com.ezeeappointer.common.TEAValidator;

public class BaseMBean implements Serializable{
	
	private TEAValidator validator = new TEAValidator();
	
	/**
	 * @param serviceName
	 * @return
	 */
	public Object getBackendService(String serviceName){		
		return TEAServiceDelegate.getService(serviceName);
	}

	/**
	 * @return the validator
	 */
	public TEAValidator getValidator() {
		return validator;
	}

	/**
	 * @param validator the validator to set
	 */
	public void setValidator(TEAValidator validator) {
		this.validator = validator;
	}
	
	
	
	
}
