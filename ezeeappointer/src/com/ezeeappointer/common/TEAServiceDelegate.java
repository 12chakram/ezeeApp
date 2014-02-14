/**
 * 
 */
package com.ezeeappointer.common;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author sairam
 *
 */

public class TEAServiceDelegate {
	
	private static BeanFactory bf;
	
	/**
	 * @param serviceName
	 * @return
	 */
	public static Object getService(String serviceName){
		
		if(bf==null){
			ClassPathResource res =  new ClassPathResource("ApplicationContext.xml");
			bf = new XmlBeanFactory(res);
		}		
		Object service = bf.getBean(serviceName);		
		return service;
	}
	
	
	
//	//private static BeanFactory bf;
//	
//		private static ApplicationContext ctx = null;
//		
//		public void setApplicationContext(ApplicationContext ctx) throws BeansException {
//			this.ctx = ctx;
//		 }
//		
//		/**
//		 * @param serviceName
//		 * @return
//		 */
//		public static Object getService(String serviceName){
//			
////			if(bf==null){
////				ClassPathResource res =  new ClassPathResource("ApplicationContext.xml");
////				bf = new XmlBeanFactory(res);
////			}		
////			Object service = bf.getBean(serviceName);		
//			return ctx.getBean(serviceName);
//		}
}
