package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {


    private static Configuration configuration = null;  
    private static SessionFactory sessionFactory = null;  
    private static ServiceRegistry serviceRegistry = null; 
    
	public static SessionFactory getSessionFactory() {
		configuration = new Configuration().configure();  
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();  
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
        return sessionFactory;
	}
}
