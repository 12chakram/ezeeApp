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

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.AppointeeDashboard;
import com.ezeeappointer.data.Appointment;
import com.ezeeappointer.data.DayAndTime;
import com.ezeeappointer.data.Service;
import com.ezeeappointer.data.Staff;
import com.ezeeappointer.dto.TEADayAndTimeDTO;
import com.ezeeappointer.dto.TEAServiceDTO;
import com.ezeeappointer.dto.TEAUIStaffDTO;

public class TEAAppointmentDAO {
		
		public void addAppointment(Appointment app){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			em.getTransaction().begin();
			em.persist(app);
			em.getTransaction().commit();
			em.close();		
		}
		
		public List<Service> retrieveServicesByBusinessId(long busnId){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select s from Service s where s.businessId="+busnId);
			List<Service> s = q.getResultList();
			
			em.getTransaction().commit();
			em.close();	
			return s;
		}
		
	public List<Staff> retrieveStaffByBusinessId(long busnId){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select s from Staff s where s.businessId="+busnId);
			List<Staff> s = q.getResultList();
			System.out.println(s.size());
			for(Staff st:s)
				st.getDayTimes();
			em.getTransaction().commit();
			em.close();	
			return s;
		}
		
		
		public List<Appointment> retrieveExistingAppointments(long busnId, long staffId, Date fromDate, Date toDate){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select a from Appointment a where a.busnId="+busnId +" and a.staffId=" + staffId +" and (apptSts='p' or apptSts='c') and apptDate>=:fromDate");
			q.setParameter("fromDate", fromDate);
			q.setParameter("toDate", toDate);
			List<Appointment> appts = q.getResultList();
			appts = new ArrayList<Appointment>(appts);
			for(int i = appts.size()-1; i >= 0; i--){
				if(appts.get(i).getApptDate().compareTo(toDate) > 0)
					appts.remove(i);
			}
			em.getTransaction().commit();
			em.close();	
			return appts;
		}
		
		public List<TEAUIStaffDTO> retrieveStaffDetailsByServiceId(long serviceId){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			 Mapper mapper = new DozerBeanMapper();
			em.getTransaction().begin();
			Query q1 = em.createQuery("select from Staff s JOIN s.srvcStaffXref sxs where sxs.serviceId="+serviceId);		 
			List<Staff> staff = q1.getResultList();
			
			List<TEAUIStaffDTO> uiStaffDTOs = new ArrayList<TEAUIStaffDTO>();
			for(Staff sf: staff){
				List<Long> serviceIds = (List<Long>) CollectionUtils.collect(sf.getSrvcStaffXref(), 
	                    new BeanToPropertyValueTransformer("serviceId"));
				Query q2 = em.createQuery("select from Service s where s.id=:id");
				q2.setParameter("id", serviceIds);
				List<Service> services = q2.getResultList();
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
				uiStaffDTOs.add(dto);
				
			}		
			
			em.getTransaction().commit();
			em.close();
			System.out.println("Size of the result set: "+staff.size());
			return uiStaffDTOs;
		}
		
		
		public TEAUIStaffDTO retrieveServiceDetailsByStaffId(long staffId){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			 Mapper mapper = new DozerBeanMapper();
			em.getTransaction().begin();
			Query q1 = em.createQuery("select from Staff s where s.id="+staffId);		 
			  Staff sf = (Staff) q1.getSingleResult();
			List<Long> serviceIds = (List<Long>) CollectionUtils.collect(sf.getSrvcStaffXref(), new BeanToPropertyValueTransformer("serviceId"));
				Query q2 = em.createQuery("select from Service s where s.id=:id");
				q2.setParameter("id", serviceIds);
				List<Service> services = q2.getResultList();
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
			em.close();
		   return dto;
		}
		
		public List<AppointeeDashboard> retrieveAppointmetsByUserId(long userId){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			List<AppointeeDashboard> apptDbs = new ArrayList<AppointeeDashboard>();
			em.getTransaction().begin();
			Query q = em.createQuery("select a from Appointment a where a.userId=:userId");
			q.setParameter("userId", userId);
			List<Appointment> appts = q.getResultList();
			for(Appointment appt: appts){
				AppointeeDashboard apptDb = new AppointeeDashboard();
				q = em.createQuery("select s from Staff s where s.id=" + appt.getStaffId());
				Staff staff = (Staff)q.getSingleResult();
				q = em.createQuery("select s from Service s where s.id=" + appt.getServiceId());
				Service srvc = (Service)q.getSingleResult();
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
			em.close();	
			return apptDbs;
		}
		
		public void updateAppointmentStatus(long apptNo, String sts){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select a from Appointment s where a.apptNo=:apptNo");
			q.setParameter("apptNo", apptNo);
			Appointment appt  = (Appointment)q.getSingleResult();
			appt.setApptSts("c");
			em.getTransaction().commit();
			em.close();	
		}
}
