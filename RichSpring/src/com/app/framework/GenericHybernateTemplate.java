package com.app.framework;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.util.Assert;

public class GenericHybernateTemplate extends HibernateTemplate{

	public GenericHybernateTemplate(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		super(sessionFactory);
	}

	@Override
	protected void checkWriteOperationAllowed(Session session)
			throws InvalidDataAccessApiUsageException {
		// TODO Auto-generated method stub
		System.err.println("@@@ checkWriteOperationAllowed override @@@");
		if (isCheckWriteOperations() && session.getFlushMode().lessThan(FlushMode.COMMIT)) {
			session.setFlushMode(FlushMode.COMMIT);
		}
	}
	
	@Override
	public <T> T merge(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		
		
		
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		T mergedEntity = null;
		try
		{
			transaction=session.beginTransaction();
			mergedEntity = (T) session.merge(entity);
			transaction.commit();
			
		}
		catch(Exception e)
		{
			 if (transaction != null) {
	             transaction.rollback();
	         }
		}
		finally
		{
			session.close();
			//sessionFactory.close();
		}
		return mergedEntity;
	}
	@Override
	public <T> T merge(final String entityName, final T entity) throws DataAccessException {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		T mergedEntity = null;
		try
		{
			transaction=session.beginTransaction();
			mergedEntity = (T) session.merge(entityName,entity);
			transaction.commit();
			
		}
		catch(Exception e)
		{
			 if (transaction != null) {
	             transaction.rollback();
	         }
		}
		finally
		{
			session.close();
			//sessionFactory.close();
		}
		return mergedEntity;
	}
}
