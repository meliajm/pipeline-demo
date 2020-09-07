package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface IReimbursementDAO {
	
	public List<Reimbursement> findAll();
	
	public Reimbursement findByID(int id);
		
	public boolean addReimbursement(Reimbursement r);
	
	public boolean updateReimbursement(Reimbursement r);

	public List<Reimbursement> findReimbursementByStatus(int i);
	
	public List<Reimbursement> findReimbursementsByUser(User u);
//	public boolean deleteReimbursement(int id);

}
