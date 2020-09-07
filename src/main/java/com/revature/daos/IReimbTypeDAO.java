package com.revature.daos;

import com.revature.models.ReimbursementType;

public interface IReimbTypeDAO {

	public ReimbursementType findByType(String type);

}
