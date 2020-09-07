package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement_status")
public class ReimbursementStatus {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_status_id")
	private int reimbStatusID;
	
	@Column(name="reimb_status")
	private String reimbStatus;
	
//	@OneToMany(mappedBy="reimbStatus", fetch=FetchType.EAGER)
//	private List<Reimbursement> rList;
//	
	
	public ReimbursementStatus() {
		super();
	}
	
	
	
	public ReimbursementStatus(int reimbStatusID, String reimbStatus) {
		super();
		this.reimbStatusID = reimbStatusID;
		this.reimbStatus = reimbStatus;
	}
	



	public ReimbursementStatus(String reimbStatus) {
		super();
		this.reimbStatus = reimbStatus;
	}



	public int getReimbStatusID() {
		return reimbStatusID;
	}
	public void setReimbStatusID(int reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}
	public String getreimbStatus() {
		return reimbStatus;
	}
	public void setreimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + reimbStatusID;
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
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbStatusID != other.reimbStatusID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [reimbStatusID=" + reimbStatusID + ", reimbStatus=" + reimbStatus + "]";
	}
	
	
	
	
	

	
	
	
	

}
