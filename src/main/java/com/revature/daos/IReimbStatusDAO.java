package com.revature.daos;

import com.revature.models.ReimbursementStatus;

public interface IReimbStatusDAO {
	
	public ReimbursementStatus findByStatus(String status);

}
