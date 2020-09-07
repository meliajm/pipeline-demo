package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class userRole {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_role_id")
	private int UserRoleID;
	
	@Column(name="user_role", nullable=false)
	private String UserRole;
	
	public int getUserRoleID() {
		return UserRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		UserRoleID = userRoleID;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	public userRole() {
		super();
	}
	
	public userRole(int userRoleID, String userRole) {
		super();
		UserRoleID = userRoleID;
		UserRole = userRole;
	}
	public userRole(String userRole) {
		super();
		UserRole = userRole;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UserRole == null) ? 0 : UserRole.hashCode());
		result = prime * result + UserRoleID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		userRole other = (userRole) obj;
		if (UserRole == null) {
			if (other.UserRole != null)
				return false;
		} else if (!UserRole.equals(other.UserRole))
			return false;
		if (UserRoleID != other.UserRoleID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "userRole [UserRoleID=" + UserRoleID + ", UserRole=" + UserRole + "]";
	}
	
	
	
}
