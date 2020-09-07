package com.revature.models;

public class ReimbDTO {
	
	public int reimbID;
	public double reimbAmount;
	public String timeSubmitted;	
	public String timeResolved;
	public String reimbDescription;
	public String reimbAuthorString;
	public String reimbResolver;
	public String reimbStatus;
	public String reimbType;
	
	public ReimbDTO() {
		super();
	}

	public ReimbDTO(int reimbID, double reimbAmount, String timeSubmitted, String timeResolved, String reimbDescription,
			String reimbAuthorString, String reimbResolver, String reimbStatus, String reimbType) {
		super();
		this.reimbID = reimbID;
		this.reimbAmount = reimbAmount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthorString = reimbAuthorString;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public ReimbDTO(double reimbAmount, String timeSubmitted, String timeResolved, String reimbDescription,
			String reimbAuthorString, String reimbResolver, String reimbStatus, String reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthorString = reimbAuthorString;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimbAuthorString == null) ? 0 : reimbAuthorString.hashCode());
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
		ReimbDTO other = (ReimbDTO) obj;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbAuthorString == null) {
			if (other.reimbAuthorString != null)
				return false;
		} else if (!reimbAuthorString.equals(other.reimbAuthorString))
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
		return "ReimbDTO [reimbID=" + reimbID + ", reimbAmount=" + reimbAmount + ", timeSubmitted=" + timeSubmitted
				+ ", timeResolved=" + timeResolved + ", reimbDescription=" + reimbDescription + ", reimbAuthorString="
				+ reimbAuthorString + ", reimbResolver=" + reimbResolver + ", reimbStatus=" + reimbStatus
				+ ", reimbType=" + reimbType + "]";
	}
	
	
	
	
	
	
	

}
