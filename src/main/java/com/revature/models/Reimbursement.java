package com.revature.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="reimbursement")
//@JsonSerialize
public class Reimbursement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_id")
	private int reimbID;
	
	@Column(name="reimb_amount", nullable=false)
	private double reimbAmount;
	
	@Column(name="reimb_submitted", nullable=false)
	private String timeSubmitted;
	
	@Column(name="reimb_resolved")
	private String timeResolved;

	@Column(name="reimb_description")
	private String reimbDescription;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_author", nullable=false)
//	@JsonBackReference
//	@JsonManagedReference
	private User reimbAuthor;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_resolver")
//	@JsonBackReference
//	@JsonManagedReference
	private User reimbResolver;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_status_id", nullable=false)
	private ReimbursementStatus reimbStatus;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_type_id", nullable=false)
	private ReimbursementType reimbType;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimbID, double reimbAmount, String timeSubmitted, String timeResolved,
			String reimbDescription, User reimbAuthor, User reimbResolver, ReimbursementStatus reimbStatus,
			ReimbursementType reimbType) {
		super();
		this.reimbID = reimbID;
		this.reimbAmount = reimbAmount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public Reimbursement(double reimbAmount, String timeSubmitted, String timeResolved, String reimbDescription,
			User reimbAuthor, User reimbResolver, ReimbursementStatus reimbStatus, ReimbursementType reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public int getReimbID() {
		return reimbID;
	}

	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}


	public String getTimeSubmitted() {
		return timeSubmitted;
	}

	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}

	public String getTimeResolved() {
		return timeResolved;
	}

	public void setTimeResolved(String timeResolved) {
		this.timeResolved = timeResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public User getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(User reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public User getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(User reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public ReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(ReimbursementStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public ReimbursementType getReimbType() {
		return reimbType;
	}

	public void setReimbType(ReimbursementType reimbType) {
		this.reimbType = reimbType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimbAuthor == null) ? 0 : reimbAuthor.hashCode());
		result = prime * result + ((reimbDescription == null) ? 0 : reimbDescription.hashCode());
		result = prime * result + reimbID;
		result = prime * result + ((reimbResolver == null) ? 0 : reimbResolver.hashCode());
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		result = prime * result + ((timeResolved == null) ? 0 : timeResolved.hashCode());
		result = prime * result + ((timeSubmitted == null) ? 0 : timeSubmitted.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbAuthor == null) {
			if (other.reimbAuthor != null)
				return false;
		} else if (!reimbAuthor.equals(other.reimbAuthor))
			return false;
		if (reimbDescription == null) {
			if (other.reimbDescription != null)
				return false;
		} else if (!reimbDescription.equals(other.reimbDescription))
			return false;
		if (reimbID != other.reimbID)
			return false;
		if (reimbResolver == null) {
			if (other.reimbResolver != null)
				return false;
		} else if (!reimbResolver.equals(other.reimbResolver))
			return false;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		if (timeResolved == null) {
			if (other.timeResolved != null)
				return false;
		} else if (!timeResolved.equals(other.timeResolved))
			return false;
		if (timeSubmitted == null) {
			if (other.timeSubmitted != null)
				return false;
		} else if (!timeSubmitted.equals(other.timeSubmitted))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", reimbAmount=" + reimbAmount + ", timeSubmitted=" + timeSubmitted
				+ ", timeResolved=" + timeResolved + ", reimbDescription=" + reimbDescription + ", reimbAuthor="
				+ reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatus=" + reimbStatus + ", reimbType="
				+ reimbType + "]";
	}

	
	
}
