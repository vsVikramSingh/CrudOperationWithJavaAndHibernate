package com.cdac.training.session;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
public class CreateNewSession {
	public static Session getSession() {
		Session session = null;
		session = new Configuration().configure().buildSessionFactory().openSession();
		return session;
	}
}
