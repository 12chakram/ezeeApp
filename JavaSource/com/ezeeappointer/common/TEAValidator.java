package com.ezeeappointer.common;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.ezeeappointer.service.TEAAppointeeUserManagementService;
import com.ezeeappointer.service.TEABusinessUserManagementService;

public class TEAValidator  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void validateText(FacesContext context,UIComponent toValidate,Object value) throws ValidatorException {
		String fieldStr = (String) value;
		String field = toValidate.getId().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
		validateForEmpty(field, fieldStr);
		String minmax = (String)toValidate.getAttributes().get("minmax");
	      if (minmax != null) {
	    	  String[] values = minmax.split(",");
	    	  validateForLength(field, fieldStr, Integer.parseInt(values[0]), Integer.parseInt(values[1]));
	      }
	}	
	public void validateNumeric(FacesContext context,UIComponent toValidate,Object value) throws ValidatorException {
		String fieldStr = (String) value;
		String field = toValidate.getId().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
		String DIGIT_PATTERN = "^\\d+$";
		validateForEmpty(field, fieldStr);
		Pattern pattern = Pattern.compile(DIGIT_PATTERN);
		Matcher matcher = pattern.matcher(fieldStr);
		if (!matcher.matches()) {
		FacesMessage message = new FacesMessage(field + " is invalid.");
		throw new ValidatorException(message);
		}
		String minmax = (String)toValidate.getAttributes().get("minmax");
	      if (minmax != null) {
	    	  String[] values = minmax.split(",");
	    	  if(Integer.parseInt(fieldStr) < Integer.parseInt(values[0])){
	  			  throw new ValidatorException(new FacesMessage(field + " must not be less than" + values[0]));
	    	  }else if(Integer.parseInt(fieldStr) > Integer.parseInt(values[1])){
	    		  throw new ValidatorException(new FacesMessage(field + " must not be greater than" + values[1]));
	    	  }
	      }
	}	
	
	public void validateSelect(FacesContext context,UIComponent toValidate,Object value) throws ValidatorException {
		String fieldStr = (String) value;
		String field = toValidate.getId().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
		validateForEmpty(field, fieldStr);		
	}
	
	public void validateEmail(FacesContext context,UIComponent toValidate,Object value) throws ValidatorException {
		String emailStr = (String) value;
		String field = toValidate.getId().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
		validateForEmpty(field, emailStr);
		String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
				"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
				"(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(emailStr);
		if (!matcher.matches()) {
		FacesMessage message = new FacesMessage(field + " is invalid.");
		throw new ValidatorException(message);
		}
		}
	
	public void validatePhone(FacesContext context,UIComponent toValidate,Object value) throws ValidatorException {
		String phoneNumber = (String) value;
		String field = toValidate.getId().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
		validateForEmpty(field, phoneNumber);
		String PHONE_PATTERN = "\\d{10}";
		Pattern pattern = Pattern.compile(PHONE_PATTERN);
		Matcher matcher = pattern.matcher(phoneNumber);
		if (!matcher.matches()) {
		FacesMessage message = new FacesMessage(field + " is invalid.");
		throw new ValidatorException(message);
		}
		}
	
	public void validateForEmpty(String field, String value) throws ValidatorException {
		if(value.length() == 0){
			FacesMessage message = new FacesMessage(field + " is required.");
			throw new ValidatorException(message);
		}else if(value.trim().length() == 0){
			FacesMessage message = new FacesMessage(field + " is invalid.");
			throw new ValidatorException(message);
		}
	}
	
	public void validateForLength(String field, String value, int min, int max) throws ValidatorException {
		if(value.length() < min){
			FacesMessage message = new FacesMessage(field + " length must not be less than" + min);
			throw new ValidatorException(message);
		}else if(value.length() > max){
			FacesMessage message = new FacesMessage(field + " length must not be greater than" + max);
			throw new ValidatorException(message);
		}
	}
	
	public void validateTime(FacesContext context,UIComponent toValidate,Object value) throws ValidatorException {
		String frmTime = (String) value;
		String field = toValidate.getId().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
		validateForEmpty(field, frmTime);
		String TIME12HOURS_PATTERN = "(0[1-9]|1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)|(AM|PM)";
		Pattern pattern = Pattern.compile(TIME12HOURS_PATTERN);
		Matcher matcher = pattern.matcher(frmTime);
		if (!matcher.matches()) {
		FacesMessage message = new FacesMessage(field + " is invalid.");
		throw new ValidatorException(message);
		}		
	}
	
	public void checkTimeDifference(FacesContext context,UIComponent toValidate,Object value) throws ValidatorException {
		validateTime(context, toValidate, value);
		String toTime = (String) value;
		String field = toValidate.getId().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
		
		//UIInput otherInput = (UIInput) context.getViewRoot().findComponent("FromTime");
		//UIInput otherInput = (UIInput) context.getViewRoot().findComponent((String) toValidate.getAttributes().get("FromTime"));
	   // String frmTime = (String) otherInput.getValue();
	    
//	    SimpleDateFormat parser = new SimpleDateFormat("HH:mm a");
//		try{
//			Date to = parser.parse(toTime);
//			Date from = parser.parse(frmTime);
//			long diffInMin = (from.getTime() - to.getTime()) / (1000 * 60);
//			if(to.before(from)){
//				FacesMessage message = new FacesMessage(field + " must be after From Time");
//				throw new ValidatorException(message);
//			}
//		}catch(ParseException pe){
//			
//		}
	
	}
	
	public void checkForDuplicateBusinessUser(FacesContext context,UIComponent toValidate,Object value)throws ValidatorException {
		validateText(context, toValidate, value);
		String fieldStr = (String) value;
		String field = toValidate.getId();
		TEABusinessUserManagementService service= (TEABusinessUserManagementService)TEAServiceDelegate.getService("businessUserService");
		if(service.checkForDuplicateBusinessUser(fieldStr))
				throw new ValidatorException(new FacesMessage("This "+ field + " is already exist."));	
	}
	
	public void checkForDuplicateBusinessEmail(FacesContext context,UIComponent toValidate,Object value)throws ValidatorException {
		validateEmail(context, toValidate, value);
		String fieldStr = (String) value;
		String field = toValidate.getId().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
		TEABusinessUserManagementService service= (TEABusinessUserManagementService)TEAServiceDelegate.getService("businessUserService");
		if(service.checkForDuplicateBusinessEmail(fieldStr))
				throw new ValidatorException(new FacesMessage(field + " is already exist."));	
	}
	
	public void checkForDuplicateAppointeeEmail(FacesContext context,UIComponent toValidate,Object value)throws ValidatorException {
		validateEmail(context, toValidate, value);
		String fieldStr = (String) value;
		String field = toValidate.getId().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
		TEAAppointeeUserManagementService service= (TEAAppointeeUserManagementService)TEAServiceDelegate.getService("appointeeUserService");
		if(service.checkForDuplicateAppointeeEmail(fieldStr))
				throw new ValidatorException(new FacesMessage(field + " is already exist."));	
	}
	
}
