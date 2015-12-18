package base;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;

import util.HibernateUtil;

public class RateDAL {


	public static double getRate(int GivenCreditScore) {
		double interestRate;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		double rateGet = (Double) null;		
		
		try {
			tx = session.beginTransaction();	
									
			Query query = session.createQuery("from RateDomainModel where MinCreditScore = :MinCreditScore ");
			query.setParameter("MinCreditScore", GivenCreditScore);
			
			List<?> list = query.list();
			rateGet = (Double) list.get(3);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return  rateGet;
	}	
	
	public static RateDomainModel addRate(RateDomainModel rate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(rate);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return  rate;
	}
	

public static void deleteRate(int rateID) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	RateDomainModel rateGet = null;		
	
	try {
		tx = session.beginTransaction();	
								
		RateDomainModel rate = (RateDomainModel) session.get(RateDomainModel.class, rateID);
		session.delete(rate);
	
		
		tx.commit();
	} catch (HibernateException e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}

}	
public static RateDomainModel getFullRate(int rateID) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	RateDomainModel rateGet = null;

	try {
		tx = session.beginTransaction();

		Query query = session.createQuery("from RateDomainModel where RateID = :id ");
		query.setParameter("id", rateID);

		rateGet = (RateDomainModel) query.list().get(0);

		tx.commit();

	} catch (IndexOutOfBoundsException ex) {
		rateGet = null;
	} catch (HibernateException e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
	return rateGet;
}

}