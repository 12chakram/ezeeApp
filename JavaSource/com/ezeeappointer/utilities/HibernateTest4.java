package com.ezeeappointer.utilities;

import java.util.ArrayList;
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

public class HibernateTest4 {
	
	
	public static TEAUIStaffDTO retrieveServiceDetailsByStaffId(long staffId){
		Session em = TEAEntityManagerFactory.get();
		 Mapper mapper = new DozerBeanMapper();
		 
	
		em.getTransaction().begin();
				 
		  Staff sf = (Staff)em.get(Staff.class, staffId);
		
		
			TEAUIStaffDTO dto = new TEAUIStaffDTO();
			List<TEADayAndTimeDTO> ldt = new ArrayList<TEADayAndTimeDTO>();
			String[] dayss =null;
			for(DayAndTime dt: sf.getDayTimes()){	
				
				 dayss = dt.getDays().split(",");
				 
				 TEADayAndTimeDTO tad = new TEADayAndTimeDTO(); 
				 tad.setDayss(dayss);
				 tad.setFromTime(dt.getFromTime());
				 tad.setToTime(dt.getToTime());
			
				 ldt.add(mapper.map(tad,  TEADayAndTimeDTO.class));
			}
				
				
				
				//ldt.add(mapper.map(dt,  TEADayAndTimeDTO.class));
				
			dto.setDayTime(ldt);
			dto.setStaffName(sf.getStaffName());
			dto.setStaffId(sf.getId());
			
			List<TEAServiceDTO> sdt = new ArrayList<TEAServiceDTO>();
			for(Service sr: sf.getServices())
				sdt.add(mapper.map(sr,  TEAServiceDTO.class));
			
			dto.setServices(sdt);
			dto.setStaffDescription("No description yet..");
			em.getTransaction().commit();

	   return dto;
	}
	
	
	public static void main(String[] args) {
		
		TEAUIStaffDTO teauiStaffDTO = new TEAUIStaffDTO();
		Long id = (long) 1;
		
		teauiStaffDTO = retrieveServiceDetailsByStaffId(id);
	}
	

}
