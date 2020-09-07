package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class UserService {

	private static final Logger log = LogManager.getLogger(UserService.class);

	private static IUserDAO uDao = new UserDAO();
		
	public List<User> findAll() {
		log.info("find all users");
		return uDao.findAll();
	}
	
	public User findById(int id) {
		log.info("find by id");
		return uDao.findByID(id);
	}
	
	public User findByUsername(String username) {
		log.info("find by username");
		System.out.println("username: "+username);
		return uDao.findByUsername(username);
	}
	
	public boolean addUser(User u) {
		log.info("adding user");
		return uDao.addUser(u);
	}
	
	public boolean updateUser(User u) {
		log.info("update user");
		return uDao.updateUser(u);
	}
	
	public List<Reimbursement> findUserReimbursements(User u) {
		log.info("find user reimbursements from user");
		return uDao.findUserReimbursements(u);
	}
//	
//	public User findUserRole(int id) {
//		log.info("find user role from user id");
//		return uDao.findUserRole(id);
//	}

}
