package com.app.company.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;





import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.app.company.dao.EmployeeDao;
import com.app.company.entity.Employee;
import com.app.framework.HibernateDaoSupport;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao, Serializable{

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		/*SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try
		{
			transaction=session.beginTransaction();
			session.save(employee);
			transaction.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
			if (transaction != null) {
	             transaction.rollback();
	         }
		}
		finally
		{
			session.close();
			//sessionFactory.close();
		}*/
		Serializable emp = getHibernateTemplate().save(employee);
		return getHibernateTemplate().get(Employee.class,
				emp);
	}
	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 
		
		SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try
		{
			transaction=session.beginTransaction();
			
			session.delete(employee);
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
	}
	@Override
	public void deleteEmployee(long empId) {
		// TODO Auto-generated method stub
		 
		
		SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try
		{
			transaction=session.beginTransaction();
			Object o=session.load(Employee.class,new Long(empId));
		    Employee employee=(Employee)o;
			session.delete(employee);
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
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		/*
		SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try
		{
			transaction=session.beginTransaction();
			session.merge(employee);
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
		*/
		//currentSession().setFlushMode(FlushMode.AUTO);
		//getHibernateTemplate().flush();
		
	
		return (Employee)getHibernateTemplate().merge(employee);
	}

	@Override
	public Employee loadEmployee(long empId) {
		// TODO Auto-generated method stub
	/*
		SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.openSession();
		Employee employee = null;
		try
		{
			Object o=session.get(Employee.class,new Long(empId));
			employee=(Employee)o;
		}
		catch(ObjectNotFoundException onfex)
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
			//sessionFactory.close();
		}
	    return employee;
	    */
		
		return getHibernateTemplate().get(Employee.class,new Long(empId));
	}

	@Override
	public List<Employee> loadAllEmployee() {
		// TODO Auto-generated method stub
		return (List<Employee>) getHibernateTemplate().loadAll(Employee.class);
	}
	@Override
	public void persistEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.err.println("@@@ Persis method called @@@");
		getHibernateTemplate().persist(employee);
		
		
	}
	@Override
	public List<Employee> loadEmployeeByCriteria(Employee employee) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		Criterion c1=Restrictions.idEq(new Long(2));//gt("empId", new Long(2));
		criteria.add(c1);
		return (List<Employee>) getHibernateTemplate().findByCriteria(criteria);
		
		
	}
	
	

	
	
	
}
