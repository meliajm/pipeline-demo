package com.revature.models;

import java.util.List;
// do we need all 3 constructors for all models?
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement_type")
public class ReimbursementType {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_type_id")
	private int reimbTypeID;
	
	@Column(name="reimb_type")
	private String reimbType;
	//what is this?
//	@OneToMany(mappedBy="reimbType", fetch=FetchType.EAGER)
//	private List<Reimbursement> rList;
//		
	public ReimbursementType() {
		super();
	}

	public ReimbursementType(int reimbTypeID, String reimbType) {
		super();
		this.reimbTypeID = reimbTypeID;
		this.reimbType = reimbType;
	}

	public ReimbursementType(String reimbType) {
		super();
		this.reimbType = reimbType;
	}

	public int getReimbTypeID() {
		return reimbTypeID;
	}
	
	public void setReimbTypeID(int reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}
	
	public String getReimbType() {
		return reimbType;
	}
	
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		result = prime * result + reimbTypeID;
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
		ReimbursementType other = (ReimbursementType) obj;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		if (reimbTypeID != other.reimbTypeID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursementType [reimbTypeID=" + reimbTypeID + ", reimbType=" + reimbType + "]";
	}
	

}
