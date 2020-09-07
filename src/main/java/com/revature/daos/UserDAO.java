package com.revature.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDAO implements IUserDAO {
	
	public UserDAO() {
		super();
	}

	@Override
	public List<User> findAll() {
		Session ses = HibernateUtil.getSession();
		List<User> uList = ses.createQuery("From User").list();
		return uList;
	}

	@Override
	public User findByID(int id) {
		Session ses = HibernateUtil.getSession();
		User u = ses.get(User.class, id);
		return u;
	}

	@Override
	public User findByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		List<User> uList  = (List<User>) ses.createQuery("FROM User u WHERE u.username ='"+username+"'", User.class).list();
		return uList.get(0);
	}

	@Override
	public boolean addUser(User u) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		ses.save(u);
//		tx.commit();
		Session ses = HibernateUtil.getSession();
		try {						
			Transaction tx = ses.beginTransaction();
			ses.save(u);
			tx.commit();
			System.out.println("adding user  ///////////////////////////////////////////");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User u) {
		Session ses = HibernateUtil.getSession();
//		ses.merge(u);
		try {	
			Transaction tx = ses.beginTransaction();
			ses.merge(u);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public List<Reimbursement> findUserReimbursements(User u) {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> list  = (List<Reimbursement>) ses.createNativeQuery("SELECT * FROM reimbursement WHERE reimb_author ="+u.getUserID(), Reimbursement.class).list();
		return list;
	}

}
