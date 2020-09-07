package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IReimbStatusDAO;
import com.revature.daos.IReimbTypeDAO;
import com.revature.daos.IReimbursementDAO;
import com.revature.daos.IUserDAO;
import com.revature.daos.ReimbStatusDAO;
import com.revature.daos.ReimbTypeDAO;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.UserDAO;
import com.revature.models.ReimbDTO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;



public class ReimbService {
	
	private static final Logger log = LogManager.getLogger(ReimbService.class);
	
	private static IReimbursementDAO rDao = new ReimbursementDAO();
	private static IUserDAO uDao = new UserDAO();
	private static IReimbStatusDAO rsDao = new ReimbStatusDAO();
	private static IReimbTypeDAO rtDao = new ReimbTypeDAO();

	public List<Reimbursement> findAll() {
		log.info("find all");
		return rDao.findAll();
	}
	
	public Reimbursement findById(int id) {
		log.info("find by id");
		return rDao.findByID(id);
	}
	
//	public boolean addReimbursement(Reimbursement r) {
//		log.info("add reimbursement");
//		return rDao.addReimbursement(r);
//	}
	
	public boolean addReimbursement(ReimbDTO rd) {
		Reimbursement r;
		User u = uDao.findByUsername(rd.reimbAuthorString);
		ReimbursementStatus rs = rsDao.findByStatus(rd.reimbStatus); 
		ReimbursementType rt =rtDao.findByType(rd.reimbType);
		r = new Reimbursement(rd.reimbAmount, rd.timeSubmitted, rd.timeResolved, rd.reimbDescription, u, null, rs, rt);
		log.info("add reimbursement");
		return rDao.addReimbursement(r);
	}
	
	public boolean updateReimbursement(ReimbDTO rd) {
		Reimbursement r;
		User uAuth = uDao.findByUsername(rd.reimbAuthorString);
		User uRes = uDao.findByUsername(rd.reimbResolver);

		ReimbursementStatus rs = rsDao.findByStatus(rd.reimbStatus); 
		ReimbursementType rt =rtDao.findByType(rd.reimbType);
		r = new Reimbursement(rd.reimbID, rd.reimbAmount, rd.timeSubmitted, rd.timeResolved, rd.reimbDescription, uAuth, uRes, rs, rt);
		log.info("update reimbursement");
		return rDao.updateReimbursement(r);
	}
	
	public List<Reimbursement> findReimbursementByStatus(int i) {
		log.info("find reimbursement by status");
		return rDao.findReimbursementByStatus(i);
	}

}
