package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="users")
public class User implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userID;
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="user_hashcode", nullable=false)
	private int password;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)	
	private String lastName;
	
	@Column(name="email", unique=true, nullable=false)	
	private String email;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	//here what should name be
	@JoinColumn(name="user_role_id", nullable=false)
	private userRole userRole;
	
	@OneToMany(mappedBy="reimbAuthor", fetch=FetchType.EAGER)
//	@JsonManagedReference
	@JsonBackReference
	private List<Reimbursement> rAList;
	
//	@OneToMany(mappedBy="reimbResolver", fetch=FetchType.EAGER)
//	@JsonManagedReference
////	@JsonBackReference
//	private List<Reimbursement> rRList;
	
	public User() {
		super();
	}

	public User(int userID, String username, int password, String firstName, String lastName, String email,
			com.revature.models.userRole userRole, List<Reimbursement> rAList) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.rAList = rAList;
//		this.rRList = rRList;
	}

//	public List<Reimbursement> getrRList() {
//		return rRList;
//	}
//
//	public void setrRList(List<Reimbursement> rRList) {
//		this.rRList = rRList;
//	}

	public User(String username, int password, String firstName, String lastName, String email,
			com.revature.models.userRole userRole, List<Reimbursement> rAList) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.rAList = rAList;
//		this.rRList = rRList;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public userRole getUserRole() {
		return userRole;
	}

	public void setUserRole(userRole userRole) {
		this.userRole = userRole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

//	@Override
//	public String toString() {
//		return "User [userID=" + userID + ", username=" + username + ", firstName=" + firstName + ", lastName="
//				+ lastName + ", email=" + email + ", userRole=" + userRole + "]";
//	}
	
	public List<Reimbursement> getrAList() {
		return rAList;
	}

	public void setrAList(List<Reimbursement> rAList) {
		this.rAList = rAList;
	}

//	@Override
//	public String toString() {
//		return "User [userID=" + userID + ", username=" + username + ", firstName=" + firstName + ", lastName="
//				+ lastName + ", email=" + email + "]";
//	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + password;
		result = prime * result + ((rAList == null) ? 0 : rAList.hashCode());
//		result = prime * result + ((rRList == null) ? 0 : rRList.hashCode());
		result = prime * result + userID;
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", userRole=" + userRole + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password != other.password)
			return false;
		if (rAList == null) {
			if (other.rAList != null)
				return false;
		} else if (!rAList.equals(other.rAList))
			return false;
//		if (rRList == null) {
//			if (other.rRList != null)
//				return false;
//		} else if (!rRList.equals(other.rRList))
//			return false;
		if (userID != other.userID)
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	

	
}
