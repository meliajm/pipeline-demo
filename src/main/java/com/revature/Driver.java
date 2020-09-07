package com.revature;

import java.time.LocalTime;
import java.util.List;

import com.revature.controllers.ReimbController;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.UserDAO;
import com.revature.daos.UserRoleDAO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;


public class Driver {
	
	public static UserDAO uDAO = new UserDAO();
	public static UserRoleDAO urDAO = new UserRoleDAO();
	public static ReimbursementDAO rDAO = new ReimbursementDAO();

	
//	public boolean updateReimbursement(Reimbursement r);
//
//	public List<Reimbursement> findReimbursementByStatus(String status);
//	
//	public List<Reimbursement> findReimbursementsByUser(User u);
	
	public static void main(String[] args) {
//		System.out.println("password".hashCode());
//		System.out.println("password".hashCode());

		
//		String emp = uDAO.findByUsername("tiaclair1").getUserRole().getUserRole();
//		System.out.println("emp " +emp);
//		
//		String fm = uDAO.findByUsername("captain").getUserRole().getUserRole();
//		System.out.println("fm " +fm);
//		insertValues();
//		List<User> users = uDAO.findAll();
//		for (User r: users) {
//			System.out.println(r);
//		}
		
		Reimbursement r = rDAO.findByID(1);
		System.out.println(r.getReimbStatus());

//		userRole ur = urDAO.findByID(1);
//		System.out.println("ur: "+ur);
//		userRole uRole = users.get(1).getUserRole();
//		System.out.println("user role: "+ uRole);
		
//		User bart= uDAO.findByID(10);
//		System.out.println(bart);
////		
//		User bart2= uDAO.findByUsername("barty");
//		System.out.println(bart2);
//		List<Reimbursement> reimbs = rDAO.findReimbursementsByUser(users.get(3));
//		
//		List<Reimbursement> reimbs = rDAO.findAll();
//		System.out.println("find all reimbs");
//		for (Reimbursement r: reimbs) {
//			System.out.println(r);
//		}
		
//		updateReimb();
//		findByStatus();
//		addReimb();
//		addUser();
		
	}
	// removed lists
//	private static void addUser() {
//		userRole ur2 = urDAO.findByID(2);
//		User u = new User("bambo", "pass", "bamboo", "bike", "bambi.com", ur2, null, null);
//		uDAO.addUser(u);
//	}
	
	private static void addReimb() {
		User tia= uDAO.findByUsername("tiaclair1");
		ReimbursementStatus rs = new ReimbursementStatus("Approved");
//		ReimbursementStatus rs2 = new ReimbursementStatus("Denied");

		ReimbursementType rt = new ReimbursementType("Other");

//		Reimbursement r = new Reimbursement(999.22, LocalTime.now(), null, "hair ties", tia, null, rs, rt);
//		Reimbursement r2 = new Reimbursement(555.25, LocalTime.now(), null, "apples", tia, null, rs2, rt);
//		rDAO.addReimbursement(r2);
//		rDAO.addReimbursement(r);
		
		

	}
	
	private static void findByStatus() {
		List<Reimbursement> rs = rDAO.findReimbursementByStatus(1);
//		syso
		for (Reimbursement r: rs) {
			System.out.println(r);
		}
	}
	
	private static void updateReimb() {
		User u = uDAO.findByID(1);
		Reimbursement r = rDAO.findByID(1);
		Reimbursement r2 = rDAO.findByID(6);		
//		r = Reimbursement(r.getReimbID(), r.getReimbAmount(), r.getTimeSubmitted(), LocalTime.now(), r.getReimbDescription(), r.getReimbAuthor(), u, r2.getReimbStatus(), r.getReimbType()); 
		r.setReimbResolver(u);
		r.setReimbStatus(r2.getReimbStatus());
//		r.setTimeResolved(LocalTime.now());
//		r.setReimbDescription("new description here");
		rDAO.updateReimbursement(r);
		System.out.println(r);
	}

	private static void insertValues() {

//		userRole ur2 = urDAO.findByID(2);
//		User u1 = new User("barty", "pass", "bart", "simpson", "bsimpo.com", ur2, null, null);
//		uDAO.addUser(u1);
//		User tia= uDAO.findByUsername("tiaclair1");
		User bart= uDAO.findByID(4);
//		User bart= uDAO.findByUsername("barty");

		System.out.println("bart: "+ bart);
		List<User> users = uDAO.findAll();
		for (User u: users) {
			System.out.println(u);
		}
		ReimbursementStatus rStatus = rDAO.findReimbursementsByUser(users.get(3)).get(0).getReimbStatus();
		System.out.println("bart "+users.get(3));
//		System.out.println("bart "+users.get(3));
		List<Reimbursement> l = rDAO.findReimbursementsByUser(users.get(3));
//		for (Reimbursement li: l) {
//			System.out.println(li);
//		}
			
//		System.out.println(l);
//				.get(0).getReimbStatus();

//		System.out.println("stat: "+rStatus);
		ReimbursementType rType = rDAO.findReimbursementsByUser(users.get(3)).get(0).getReimbType();
		LocalTime ld = LocalTime.now();
		LocalTime tlater = LocalTime.parse( "17:40:00" );

//		DateTimeFormatter dateTimeF = DateTimeFormatter.ofPattern("HH:mm:ss");
//		String time = ZonedDateTime.now().format(dateTimeF);
//		java.sql.Time timeValue = new java.sql.Time(format.parse(fajr_prayertime).getTime());

//		Reimbursement r = new Reimbursement(2020.20, ld, tlater, "good vision", bart, null, rStatus, rType);
//		rDAO.addReimbursement(r);
	}
	
	
}
