package com.ezeeappointer.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class TEAEntityManagerFactory {
	
    private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional");

    /**
     * @return
     */
    public static EntityManagerFactory get() {
        return emfInstance;
    }
}
