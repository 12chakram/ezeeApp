package com.ezeeappointer.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.AppointeeDashboard;
import com.ezeeappointer.data.Appointment;
import com.ezeeappointer.data.Business;
import com.ezeeappointer.data.BusinessUser;
import com.ezeeappointer.data.DayAndTime;
import com.ezeeappointer.data.Service;
import com.ezeeappointer.data.Staff;
import com.ezeeappointer.dto.TEADayAndTimeDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAUIStaffDTO;

public class TEAAppointmentDAO {
		
		public void addAppointment(Appointment app){
			Session em = TEAEntityManagerFactory.get();
			
			Transaction transaction = em.beginTransaction();
			
			em.persist(app);
			transaction.commit();
		
			
		}
		
		public List<Service> retrieveServicesByBusinessId(long busnId){
			Session em = TEAEntityManagerFactory.get();
			em.getTransaction().begin();
			
			String queryString2 = "select s from Service s where s.business="+busnId;
			 
			 org.hibernate.Query q2 =  em.createQuery(queryString2.toString());
			 
			List<Service> s =(List<Service>)q2.list();
			
			em.getTransaction().commit();
			
			return s;
		}
		
	public List<Staff> retrieveStaffByBusinessId(long busnId){
		    
		Session em = TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		
		 String queryString2 = "select s from Staff s where s.business="+busnId;
		 
		 org.hibernate.Query q2 =  em.createQuery(queryString2.toString());
		 
		List<Staff> s =(List<Staff>)q2.list();
		 
		 for(Staff st:s){
			 
			 String queryStringdayTime = "select s from DayAndTime s where s.staff="+st.getId();
			 
			 org.hibernate.Query dayTimeQuery =  em.createQuery(queryStringdayTime.toString());
			 
			 List<DayAndTime> dayTimes = (List<DayAndTime>)dayTimeQuery.list();
			 st.setDayTimes(dayTimes);
		 }
		 
			em.getTransaction().commit();
			
			return s;
		}
		
		
		public List<Appointment> retrieveExistingAppointments(long busnId, long staffId, Date fromDate, Date toDate){
			Session em = TEAEntityManagerFactory.get();
			em.getTransaction().begin();
			
			 org.hibernate.Query q = (org.hibernate.Query) em.createQuery("select a from Appointment a where a.busnId="+busnId +" and a.staffId=" + staffId +" and apptSts='p' or apptSts='c' and apptDate>=:fromDate and apptDate<=:toDate");
			q.setParameter("fromDate", fromDate);
			q.setParameter("toDate", toDate);
			
			
			List<Appointment> appts = q.list();
//			appts = new ArrayList<Appointment>(appts);
//			for(int i = appts.size()-1; i >= 0; i--){
//				if(appts.get(i).getApptDate().compareTo(toDate) > 0)
//					appts.remove(i);
//			}
			em.getTransaction().commit();
			
			return appts;
		}
		
		public List<Staff> retrieveStaffDetailsByServiceId(long serviceId){
		Session em = TEAEntityManagerFactory.get();
			 Mapper mapper = new DozerBeanMapper();
			 
			 List<Staff> staffs = new ArrayList<Staff>();
			 
			em.getTransaction().begin();
			
			Service service = (Service) em.get(Service.class, serviceId);
			    List<Staff> staff = service.getStaffs();
			 for(Staff sf: staff){
					   sf.getServices();
					   
					     String queryString2 = "select s from DayAndTime s where s.staff="+sf.getId();
					     org.hibernate.Query q2 =  em.createQuery(queryString2.toString());
					     List<DayAndTime> dt = (List<DayAndTime>) q2.list();
					    
					    sf.setDayTimes(dt);
					    staffs.add(sf);
					    
				 }
			   
			    em.getTransaction().commit();
			  
			    System.out.println("kkkkk");
			   return staffs;
			
			
		}
		
		
		public TEAUIStaffDTO retrieveServiceDetailsByStaffId(long staffId){
			Session em = TEAEntityManagerFactory.get();
			 Mapper mapper = new DozerBeanMapper();
			em.getTransaction().begin();
			org.hibernate.Query q1 = em.createQuery("select from Staff s where s.id="+staffId);		 
			  Staff sf = (Staff) ((Query) q1).getSingleResult();
			//List<Long> serviceIds = (List<Long>) CollectionUtils.collect(sf.getSrvcStaffXref(), new BeanToPropertyValueTransformer("serviceId"));
				org.hibernate.Query q2 = em.createQuery("select from Service s where s.id=:id");
			//	q2.setParameter("id", serviceIds);
				List<Service> services = ((Query) q2).getResultList();
				List<Service> services2 = new ArrayList<Service> ();
				services2.addAll(services);
				TEAUIStaffDTO dto = new TEAUIStaffDTO();
				List<TEADayAndTimeDTO> ldt = new ArrayList<TEADayAndTimeDTO>();
				for(DayAndTime dt: sf.getDayTimes())
					ldt.add(mapper.map(dt,  TEADayAndTimeDTO.class));
				dto.setDayTime(ldt);
				dto.setStaffName(sf.getStaffName());
				dto.setStaffId(sf.getId());
				
				List<TEAServiceDTO> sdt = new ArrayList<TEAServiceDTO>();
				for(Service sr: services2)
					sdt.add(mapper.map(sr,  TEAServiceDTO.class));
				
				dto.setServices(sdt);
				dto.setStaffDescription("No description yet.");
				em.getTransaction().commit();
	
		   return dto;
		}
		
		public List<AppointeeDashboard> retrieveAppointmetsByUserId(long userId){
			Session em = TEAEntityManagerFactory.get();
			List<AppointeeDashboard> apptDbs = new ArrayList<AppointeeDashboard>();
			em.getTransaction().begin();
			org.hibernate.Query q = em.createQuery("select a from Appointment a where a.userId=:userId");
			q.setParameter("userId", userId);
			List<Appointment> appts = (List<Appointment>)q.list();
			for(Appointment appt: appts){
				AppointeeDashboard apptDb = new AppointeeDashboard();
				//q = em.createQuery("select s from Staff s where s.id=" + appt.getStaffId());
				Staff staff = (Staff)em.get(Staff.class, appt.getStaffId());
				//Staff staff = (Staff)((Query) q).getSingleResult();
				//q = em.createQuery("select s from Service s where s.id=" + appt.getServiceId());
				Service srvc =(Service)em.get(Service.class,Long.parseLong(appt.getServiceId()));
				apptDb.setApptDate(appt.getApptDate());
				apptDb.setApptNo(appt.getId());
				apptDb.setApptTakenDate(appt.getApptTakenDate());
				apptDb.setApptSts(appt.getApptSts());
				apptDb.setApptTime(appt.getApptTime());
				apptDb.setApptStaff(staff.getStaffName());
				apptDb.setApptService(srvc.getServiceName());
				apptDbs.add(apptDb);
			}
			em.getTransaction().commit();
			
			return apptDbs;
		}
		
		public void updateAppointmentStatus(long apptNo, String sts){
			Session em = TEAEntityManagerFactory.get();
			em.getTransaction().begin();
			Query q = (Query) em.createQuery("select a from Appointment s where a.apptNo=:apptNo");
			q.setParameter("apptNo", apptNo);
			Appointment appt  = (Appointment)q.getSingleResult();
			appt.setApptSts("c");
			em.getTransaction().commit();
	
		}
}
