package com.example.customer.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;








import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.example.customer.dao.CustomerDao;
import com.example.customer.model.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao, Serializable {
	
	
	
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customer.setCreatedDate(new Date());
		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
        session.beginTransaction();
		
		
        session.save(customer);

        session.getTransaction().commit();
        session.close();
     
	}
	
	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		
			return (List<Customer>) getHibernateTemplate().find("from Customer"); 
		
	}

}
