package com.ezeeappointer.utilities;

import java.util.ArrayList;
import java.util.StringTokenizer;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.Session;

import com.ezeeappointer.common.TEAEntityManagerFactory;

import com.ezeeappointer.data.DayAndTime;
import com.ezeeappointer.data.Service;
import com.ezeeappointer.data.Staff;
import com.ezeeappointer.dto.TEADayAndTimeDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAUIStaffDTO;



public class HibernateTest2 {
	
	private static List<Staff> staff;
	private static Mapper mapper = new DozerBeanMapper();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Staff> Staffs = retrieveStaffDetailsByServiceId(11);
		searchForStaffDetailsByServiceId(Staffs);

	}

	
	
	public static List<Staff> retrieveStaffDetailsByServiceId(long serviceId){
		Session em = TEAEntityManagerFactory.get();
		 Mapper mapper = new DozerBeanMapper();
		em.getTransaction().begin();
		
		/*org.hibernate.Query q1 = em.createQuery("select s from Staff s JOIN ServiceAndStaffXREF ssx on s.staff_detail_id = ssx.staff_detail_id where serviceId="+serviceId);		 
		List<Staff> staff = ((Query) q1).getResultList();*/
		
		
		Service service = (Service) em.get(Service.class, serviceId);
		    List<Staff> staff = service.getStaffs();
		    
		   for(Staff sf: staff){
		       List<Service> sr =	sf.getServices();
		    	List<DayAndTime>dt = sf.getDayTimes();
		       System.out.println("kkkk");
		 }
		    
		    em.getTransaction().commit();
		    em.close();
		    System.out.println("kkkk");
		   return staff;
		}
	
	
	
	public static List<TEAUIStaffDTO> searchForStaffDetailsByServiceId(List<Staff> staffs){
		
		List<TEAUIStaffDTO> uiStaffDTOs = new ArrayList<TEAUIStaffDTO>();
		for(Staff sf: staffs){
			
			
			TEAUIStaffDTO dto = new TEAUIStaffDTO();
			List<TEADayAndTimeDTO> ldt = new ArrayList<TEADayAndTimeDTO>();
			//String[] dayss = {"Sun","Mon","Tue","Wed","Thu","Fri"};
		
			for(DayAndTime dt: sf.getDayTimes()){
				String dtt = dt.getDays();
				StringTokenizer st = new StringTokenizer(dtt,",");
				
				ldt.add(mapper.map(dt,TEADayAndTimeDTO.class));
			}
			dto.setDayTime(ldt);
			dto.setStaffName(sf.getStaffName());
			dto.setStaffId(sf.getId());
			
			List<TEAServiceDTO> sdt = new ArrayList<TEAServiceDTO>();
			for(Service sr: sf.getServices())
			sdt.add(mapper.map(sr,  TEAServiceDTO.class));
			dto.setServices(sdt);
			dto.setStaffDescription("No description yet.");
			uiStaffDTOs.add(dto);
		}
		/*for(TEAUIStaffDTO staff:uiStaffDTOs){
			populateAppointmentDetailsForStaff(staff, appointmentDate, busnId, 7);
		}*/
		return uiStaffDTOs;
	}
	
	
	
	
	
	
	
	
	
}
