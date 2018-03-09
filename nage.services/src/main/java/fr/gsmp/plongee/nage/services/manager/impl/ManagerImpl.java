/**
 * 
 */
package fr.gsmp.plongee.nage.services.manager.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

/**
 * @author simon
 *
 */
public class ManagerImpl {
	protected SessionFactory sessionFactory;
	protected Session session;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		session = sessionFactory.openSession();
		/*session = SessionFactoryUtils.getSession(
				(SessionFactory) sessionFactory, true);*/

	}
}
