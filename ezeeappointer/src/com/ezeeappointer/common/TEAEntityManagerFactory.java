package com.ezeeappointer.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class TEAEntityManagerFactory {
	
    private static EntityManagerFactory emfInstance;

    /**
     * @return
     */
    public static EntityManagerFactory get() {
    	try{if(emfInstance == null)
    		emfInstance  = Persistence.createEntityManagerFactory("transactions-optional");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return emfInstance;
    }
}
