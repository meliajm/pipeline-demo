package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IUserRoleDAO;
import com.revature.daos.UserRoleDAO;

import com.revature.models.userRole;

public class UserRoleService {
	
	private static final Logger log = LogManager.getLogger(UserRoleService.class);

	private static IUserRoleDAO urDao = new UserRoleDAO();
	
	public userRole findByID(int id) {
		log.info("find user role from user id");
		return urDao.findByID(id);
	}

}
