package com.revature.daos;

import com.revature.models.User;
import com.revature.models.userRole;

public interface IUserRoleDAO {
	
	public userRole findByID(int id);

	public void addUserRole(userRole ur);

}
