package com.qhit.lh.gr3.sacura.t1.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateSessionFactory {
    public static SessionFactory getSessionFactory() throws HibernateException {
    	Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
        return sf;
    }
    public static void close(Session session,SessionFactory sf) throws HibernateException {
    	sf.close();
    	session.close();
    }
	
}