package com.revature.services;

import com.revature.models.LoginDTO;
import com.revature.models.User;

public class LoginService {
	
	private static UserService us = new UserService();
	
	public boolean login(LoginDTO l) {
		User u = us.findByUsername(l.username);
		System.out.println("user: "+u);
		if (l.username.equals(u.getUsername()) && l.password.hashCode()==(u.getPassword())) {
			return true;
		}
		return false;
	}
}
