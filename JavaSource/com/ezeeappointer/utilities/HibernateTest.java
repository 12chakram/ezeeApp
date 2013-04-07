package com.ezeeappointer.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.dao.TEABusinessDetailDAO;
import com.ezeeappointer.data.Business;
import com.ezeeappointer.data.DayAndTime;
import com.ezeeappointer.data.Service;
import com.ezeeappointer.data.ServiceAndStaffXREF;
import com.ezeeappointer.data.Staff;
import com.ezeeappointer.dto.TEABusinessDetailDTO;
import com.ezeeappointer.dto.TEADayAndTimeDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAStaffDTO;

public class HibernateTest {

	static TEABusinessDetailDTO businessDTO;
	static long userId =1;
	static String[] emailn = {"admin","customer"};	
	static String[] smsn = {"admin","customer"};
	static String [] service = {"dental", "ITservices"};
	static String[] days = {"sun","MON","sat"};
	
	static List<TEAServiceDTO> services;
	static List<TEAStaffDTO> staff;
	static List<TEADayAndTimeDTO>dayTimes;
	
	static TEADayAndTimeDTO daytimedao;
	static TEAServiceDTO servicedto;
	static TEAStaffDTO staffdto;
	
	static Long  sid = (long) 1234;
	
	
	
	
	public static void main(String[] args) {
		
		 businessDTO = setbusinessDTO();
		
		createBusiness(businessDTO,userId);

	}

	
	public static TEABusinessDetailDTO setbusinessDTO(){
		
		businessDTO = new TEABusinessDetailDTO();
		servicedto = new TEAServiceDTO();
		staffdto = new TEAStaffDTO();
		
		daytimedao = new TEADayAndTimeDTO();
		
		services =  new ArrayList<TEAServiceDTO>();
		staff = new ArrayList<TEAStaffDTO>();
		dayTimes = new ArrayList<TEADayAndTimeDTO>();
	 
		
		servicedto.setDescription("some description");
		servicedto.setDuration("5");
		servicedto.setPrice("1000");
		servicedto.setServiceName("kumars service");
		
		staffdto.setcPassword("somepassword");
		staffdto.setPassword("somepassword");
		staffdto.setServices(service);
		staffdto.setStaffName("deva");
		staffdto.setStaffProfilePicture("staffProfile");
		staffdto.setUserName("devauser");
		staffdto.setDayTimes(dayTimes);
		
		daytimedao.setDays(days);
		daytimedao.setFromTime("8:00am");
		daytimedao.setToTime("6:00pm");
		
		services.add(servicedto);
		staff.add(staffdto);
		dayTimes.add(daytimedao);
		
	
		businessDTO.setAboutCompany("Developing compqny");
		businessDTO.setCity("hyderabad");
		businessDTO.setCompanyAddress("KPHB HYDERABAD");
		businessDTO.setCompanyName("CompuGain");
		businessDTO.setEmailNotification(emailn);
		businessDTO.setSmsNotifications(smsn);
		businessDTO.setEnableWithoutlogin(true);
		businessDTO.setEndingTime("6:00pm");
		businessDTO.setTag("something");
		businessDTO.setProfilePicture("myprofile");
		businessDTO.setStartingTime("8:00am");
		businessDTO.setDaysBfrAdvAppBooked("5");
		businessDTO.setHrsBfrApptCancelled("4");
		businessDTO.setHrsBfrAppRemainderNotification("4");
		businessDTO.setHrsBfrApptBooked("4");
		businessDTO.setState("AP");
		businessDTO.setServices(services);
		businessDTO.setStaff(staff);
		

	     return businessDTO;
		
	}
	
	public static void createBusiness(TEABusinessDetailDTO businessDTO, long userId){
	
		Business business = new Business();
		
		//business.setUserId(userId);
		business.setCompanyName(businessDTO.getCompanyName());
		business.setAboutCompany(businessDTO.getAboutCompany());
		business.setTag(businessDTO.getTag());
		business.setCompanyAddress(businessDTO.getCompanyAddress());
		business.setState(businessDTO.getState());
		business.setCity(businessDTO.getCity());
		business.setStartingTime(businessDTO.getStartingTime());
		business.setEndingTime(businessDTO.getEndingTime());
		business.setProfilePicture(businessDTO.getProfilePicture());
	//	List<Service> services = new ArrayList<Service>();
		
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

		
//		Map<String, Long> serviceMap = new HashMap<String, Long>();
//		for(Service s: business.getServices()){
//			serviceMap.put(s.getServiceName(), sid);
//		}
		for(TEAStaffDTO stffDTO: businessDTO.getStaff()){
			Staff st = new Staff();
			//st.setId(staffSeq);
			st.setPassword(stffDTO.getPassword());
			st.setStaffName(stffDTO.getStaffName());
			st.setStaffProfilePicture(stffDTO.getStaffProfilePicture());
			st.setUserName(stffDTO.getUserName());
			st.getServices().add(business.getServices().get(0));
			st.setBusiness(business);
			
			
//			for(String service: stffDTO.getServices()){
//				ServiceAndStaffXREF xref = new ServiceAndStaffXREF();
//				
//				
//				xref.setBusinessId(business.getId());
//				xref.setStaffId(st.getId());
//				xref.setServiceId(sid++);
//				//st.getSrvcStaffXref().add(xref);
//			}
			
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
		
		
		if(business!=null){
			addBusiness(business);
			}
		
	}
	
	public static void addBusiness(Business business){
		
		SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
		try{
			
			Session em = sessionfactory.openSession();
			
		em.getTransaction().begin();
		em.save(business);
		em.getTransaction().commit();
		em.close();	}catch(Exception e){e.printStackTrace();}
		
	}
	
	

}
