package com.ezeeappointer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.Appointment;
import com.ezeeappointer.data.Business;
import com.ezeeappointer.data.DayAndTime;
import com.ezeeappointer.data.Service;
import com.ezeeappointer.data.ServiceAndStaffXREF;
import com.ezeeappointer.data.Staff;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;

public class TEAAppointmentDAO {
		
		public void addAppointment(Appointment app){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			em.getTransaction().begin();
			em.persist(app);
			em.getTransaction().commit();
			em.close();		
		}
		
		public List<Service> retrieveServicesByBusinessId(long businessId){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select s from Service s where s.businessId="+businessId);
			List<Service> s = q.getResultList();
			em.getTransaction().commit();
			em.close();	
			return s;
		}
		
		public List<Staff> retrieveStaffDetailsByServiceId(long serviceId){
			EntityManager em = TEAEntityManagerFactory.get().createEntityManager();
			em.getTransaction().begin();
			Query q1 = em.createQuery("select from Staff s JOIN s.srvcStaffXref sxs where sxs.serviceId="+serviceId);			
			List<Staff> staff = q1.getResultList();			
			
			em.getTransaction().commit();
			em.close();
			System.out.println("Size of the result set: "+staff.size());
			return staff;
		}
}
