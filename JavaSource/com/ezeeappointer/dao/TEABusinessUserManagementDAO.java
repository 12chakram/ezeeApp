/**
 * 
 */
package com.ezeeappointer.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;


import com.ezeeappointer.common.TEAEntityManagerFactory;
import com.ezeeappointer.data.Appointment;
import com.ezeeappointer.data.BsDashboardStafApnt;
import com.ezeeappointer.data.BsLoginDashboard;
import com.ezeeappointer.data.BusinessUser;
import com.ezeeappointer.data.Service;
import com.ezeeappointer.data.ServiceAndStaffXREF;
import com.ezeeappointer.data.Staff;
import com.ezeeappointer.dto.TEAUIBussinessDashboardDTO;


/**
 * @author sairam
 *
 */
public class TEABusinessUserManagementDAO {
	
	/**
	 * @param user
	 * @return
	 */
	public boolean addBusinessUser(BusinessUser user){
		
		Session em =  TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		em.save(user);
		em.getTransaction().commit();
		
		return true; 
		
	}
	
	
	
	
	public boolean updateBusinessUser(BusinessUser user){
		Session em =  TEAEntityManagerFactory.get();
		em.getTransaction().begin();

		//BusinessUser ubu =(BusinessUser) em.find(BusinessUser.class, findBusinessUserByID(user.getId()));
		
		BusinessUser ubu = null;
		
	  if(ubu.getPassword() != null) ubu.setAddress(user.getAddress());
	  if(ubu.getFirstName()!=null) ubu.setFirstName(user.getFirstName());
	  if(ubu.getLastName()!=null) ubu.setLastName(user.getLastName());
	  if(ubu.getAddress()!=null) ubu.setAddress(user.getAddress());
	  if(ubu.getCity()!=null) ubu.setCity(user.getCity());
	  if(ubu.getUserId()!=null) ubu.setUserId(user.getUserId());
	   if(ubu.getPhoneNumber()!=null) ubu.setPhoneNumber(user.getPhoneNumber());
	  if(ubu.getId()!=0) ubu.setId(user.getId());
	  em.persist(ubu);
		 em.getTransaction().commit();
			em.close();	
			return true; 
		
	}
	

	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	public BusinessUser findBusinessUser(String userId, String password){
			
		Session em =  TEAEntityManagerFactory.get();
			StringBuffer queryString = new StringBuffer("select bu from BusinessUser bu where bu.userId='"+userId+"'");
			if(password != null)
				queryString.append(" and bu.password='"+password+"'");
			em.getTransaction().begin();
		org.hibernate.Query q =  em.createQuery(queryString.toString());
			List<BusinessUser> user=q.list();
			em.getTransaction().commit();
			//findBusiness();
			if(user.isEmpty())
				return null;
			else
				return user.get(0);
		}
	
	
	public BusinessUser findBusinessUserByID(Long Id){
		
		Session em =  TEAEntityManagerFactory.get();
		StringBuffer queryString = new StringBuffer("select bu from BusinessUser bu where bu.id="+Id);
		em.getTransaction().begin();
		Query q = (Query) em.createQuery(queryString.toString());
		List<BusinessUser> user= q.getResultList();
		em.getTransaction().commit();
		//findBusiness();
		if(user.isEmpty())
			return null;
		else
			return user.get(0);
	}
	
	
	
	/**
	 * @param email
	 * @return
	 */
	public BusinessUser findBusinessUserByEmail(String email){
		
		Session em =  TEAEntityManagerFactory.get();
			StringBuffer queryString = new StringBuffer("select bu from BusinessUser bu where bu.email='"+email+"'");
			em.getTransaction().begin();
			Query q = (Query) em.createQuery(queryString.toString());
			List<BusinessUser> user= q.getResultList();
			em.getTransaction().commit();
			//findBusiness();
			if(user.isEmpty())
				return null;
			else
				return user.get(0);
	}
	
	public long findBusiness(){
		
		Session em =  TEAEntityManagerFactory.get();
		try{
			em.getTransaction().begin();
			Query q = (Query) em.createQuery("select s from Service s  join s.business b where b.id = "+ 10001);//order by table.id desc");
//		StringBuffer queryString = new StringBuffer("select bu from BusinessUser bu where bu.userId='"+userId+"'");
//		if(password != null)
//			queryString.append(" and bu.password='"+password+"'");
//		em.getTransaction().begin();
//		Query q = em.createQuery(queryString.toString());
		//q.setMaxResults(1);
		//Long id = (Long)q.getSingleResult();
			List<Service> b= q.getResultList();
		em.getTransaction().commit();
		 if(b.isEmpty())
			 return 0;
		 else
			b.get(0);
		 return 0;
		}catch(javax.persistence.NoResultException e){
			return 10000;
		}
//		if(user.isEmpty())
//			return null;
//		else
//			return user.get(0);
	}
	
	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	public void updateBusinessSetupFlag(long userId){
			
		Session em =  TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		  BusinessUser businessUser=(BusinessUser) em.get(BusinessUser.class, userId);
		  businessUser.setBusinessSetupFlag("y");
		  em.update(businessUser);
		  em.getTransaction().commit();
			em.close();
			
			
	
			
	}
	
	/*@param bid
	 * return TEAUIBussinessDashboardDTO
	 * this method is used to display appointment counts in dashboard
	 */
	
	
	public TEAUIBussinessDashboardDTO getDashboardApptDetails(long bid)
	{
		TEAUIBussinessDashboardDTO bDashboardValObj=new TEAUIBussinessDashboardDTO();
		Session em =  TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		StringBuffer queryString = new StringBuffer("select apt from Appointment apt where apt.busnId="+bid);
		Query q = (Query) em.createQuery(queryString.toString());
		int i=q.getResultList().size();
		bDashboardValObj.setTotalAptnts(i);
		StringBuffer queryString1 = new StringBuffer("select apt from Appointment apt where apt.busnId="+bid+" and apt.apptSts='p'");
		Query q1 = (Query) em.createQuery(queryString.toString());
		List<Appointment> appointmentObj=q1.getResultList();
		int j=q1.getResultList().size();
		bDashboardValObj.setPendingAptnts(j);
		/*StringBuffer queryString2 = new StringBuffer("select st from Service st where st.businessId="+bid);
		Query q2 = em.createQuery(queryString2.toString());
		List<Service> lisVals=q2.getResultList();
		bDashboardValObj.setServices(lisVals);
		Map<Long,Integer> mapObj=new HashMap<Long, Integer>();
		for (Iterator iterator = lisVals.iterator(); iterator.hasNext();) 
		{
			Service service = (Service) iterator.next();
			StringBuffer queryString3 = new StringBuffer("select a from Appointment a where a.busnId="+bid+" and a.serviceId='"+String.valueOf(service.getId())+"'");
			Query q3 = em.createQuery(queryString3.toString());
			List listObj1=q3.getResultList();
			mapObj.put(service.getId(),listObj1.size());
		}
		bDashboardValObj.setIndividualCounts(mapObj);*/
		
		List<BsLoginDashboard> listToapprve=new ArrayList<BsLoginDashboard>();
		for(Appointment apntObj: appointmentObj)
		{
			BsLoginDashboard bsLoginDashboardObj = new BsLoginDashboard();
			StringBuffer queryString4 = new StringBuffer("select st from Service st where st.id="+apntObj.getServiceId());
			Query q4 = (Query) em.createQuery(queryString4.toString());
			q4.setMaxResults(1);
			Service srvObj = (Service)q4.getSingleResult();
			bsLoginDashboardObj.setServiceName(srvObj.getServiceName());
			StringBuffer queryString5 = new StringBuffer("select st from Staff st where st.id="+apntObj.getStaffId());
			Query q5 = (Query) em.createQuery(queryString5.toString());
			q5.setMaxResults(1);
			Staff stfObj = (Staff)q5.getSingleResult();
			bsLoginDashboardObj.setStaffName(stfObj.getStaffName());
			bsLoginDashboardObj.setApptDate(apntObj.getApptDate());
			bsLoginDashboardObj.setApptTime(apntObj.getApptTime());
			bsLoginDashboardObj.setStaffId(stfObj.getId());
			bsLoginDashboardObj.setServiceId(srvObj.getId());
			bsLoginDashboardObj.setId(apntObj.getId());
			listToapprve.add(bsLoginDashboardObj);
		}
		bDashboardValObj.setListToApprve(listToapprve);
		
		
		//staff apt
		Map<Long,Integer> mapObj=new HashMap<Long, Integer>();
		List<BsDashboardStafApnt> bsDashboardStafApntList=new ArrayList<BsDashboardStafApnt>();
		StringBuffer queryString6 = new StringBuffer("select st from Staff st where st.businessId="+bid);
		Query q6 = (Query) em.createQuery(queryString6.toString());
		List<Staff> staffList=q6.getResultList();
		for (Staff staff : staffList)
		{
			BsDashboardStafApnt stafAppTemptObj=new BsDashboardStafApnt();
			StringBuffer queryString7 = new StringBuffer("select s from ServiceAndStaffXREF s where s.staffId="+staff.getId());
			Query q7 = (Query) em.createQuery(queryString7.toString());
			List<ServiceAndStaffXREF> srveStaffList=q7.getResultList();
			int k=0;
			StringBuffer sb=new StringBuffer();
			for (ServiceAndStaffXREF serviceAndStaffXREF : srveStaffList)
			{
				StringBuffer queryString8 = new StringBuffer("select a from Appointment a where a.busnId="+bid+" and a.serviceId='"+String.valueOf(serviceAndStaffXREF.getServiceId())+"'"+ " and a.staffId="+serviceAndStaffXREF.getStaffId());
				Query q8 = (Query) em.createQuery(queryString8.toString());
				List<Appointment> a=q8.getResultList();
				k=k+a.size();
				Query q9 = (Query) em.createQuery("select s from Service s where s.id=:id");
				q9.setParameter("id", serviceAndStaffXREF.getServiceId());
				q9.setMaxResults(1);
				Service srvObj1 = (Service)q9.getSingleResult();
				sb.append(srvObj1.getServiceName()).append(",");
			}
				mapObj.put(staff.getId(),k);
				if(null!=sb)
				{
					String temptObj=sb.toString();
					int m=temptObj.lastIndexOf(",");
					if(m!=-1)
						{
							stafAppTemptObj.setServiceName(temptObj.substring(0, m-1));
						}
					else
						stafAppTemptObj.setServiceName(null);
				}
				stafAppTemptObj.setStaffId(staff.getId());
				stafAppTemptObj.setStaffName(staff.getStaffName());
				bsDashboardStafApntList.add(stafAppTemptObj);
		}
		bDashboardValObj.setStaffApntList(bsDashboardStafApntList);
		bDashboardValObj.setIndividualCounts(mapObj);
		em.getTransaction().commit();
		em.close();
		return bDashboardValObj; 
	}
	
	public boolean updateDashboardPendingApnt(long id,String whichbuttonclicked)
	{
		Session em =  TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		StringBuffer queryString = new StringBuffer("select a from Appointment a where a.id="+id);
		Query q = (Query) em.createQuery(queryString.toString());
		q.setMaxResults(1);
		Appointment apt = (Appointment)q.getSingleResult();
		if(null!=apt)
		{
			apt.setId(id);
			if(whichbuttonclicked.equalsIgnoreCase("confirm"))
			{
				apt.setApptSts("c");

			}
			else
			{
				apt.setApptSts("ca");	
			}
			
				em.merge(apt); 
				em.getTransaction().commit();
				em.close();
				return true;
		}
		else
			return false;
		/*em.getTransaction().begin();
		Query q = em.createQuery("select a from Appointment a where a.apptSts='c'");
		Appointment apt = (Appointment)q.getResultList().get(0);
			apt.setApptSts("p");
			em.merge(apt); 
			
		em.getTransaction().commit();
		em.close();
		return true;*/
	}
	
	public int getPendingAptcount(long id)
	{
		Session em =  TEAEntityManagerFactory.get();
		em.getTransaction().begin();
		StringBuffer queryString1 = new StringBuffer("select apt from Appointment apt where apt.busnId="+id+" and apt.apptSts='p'");
		Query q = (Query) em.createQuery(queryString1.toString());
		int j=q.getResultList().size();
		em.getTransaction().commit();
		em.close();
		return j;
	}
}