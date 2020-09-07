package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.userRole;
import com.revature.services.UserRoleService;
import com.revature.services.UserService;

public class UserController {
	
	private static ObjectMapper om = new ObjectMapper();
	private static UserService us = new UserService();
	private static UserRoleService urs = new UserRoleService();
//	private static Reimb
	
	public void getUser(HttpServletResponse res, int id) throws IOException {
		User u = us.findById(id);
		if (u==null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);
		}
	}
	
	public void getUserReimbursements(HttpServletResponse res, User u) throws IOException {
//		List<Reimbursement> rAlist = u.getrAList();
//		res.getWriter().println(om.writeValueAsString(rAlist));
//		res.setStatus(200);
		List<Reimbursement> rAuthList = us.findUserReimbursements(u);
		res.getWriter().println(om.writeValueAsString(rAuthList));
		res.setStatus(200);
	}
	



//	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//		
//		RequestDispatcher rd = null;
//		PrintWriter out = res.getWriter();
//		try {
//			
//			User u = us.findByUsername(req.getParameter("username"));
//			System.out.println("user: "+ u);
//			String username = req.getParameter("username");
//			String password = req.getParameter("password");
//			
//			if (u!=null && u.getUsername().equals(username) && u.getPassword().equals(password)) {
//				userRole ur = urs.findByID(u.getUserID());
//				System.out.println("ur.getUserRole().equals?: " + ur.getUserRole().equals("Employee"));
//				if (ur.getUserRole().equals("Employee")) {				
//					rd = req.getRequestDispatcher("employeeSuccess");
//					rd.forward(req, res);
//				} else if (ur.getUserRole().equals("FinanceM")) {
//					rd = req.getRequestDispatcher("financeMSuccess");
//					rd.forward(req, res);
//					
//				}
//			} else {
//				rd.include(req, res);
//				System.out.println("in else in user controller");
//				// this does not display properly
////				res.setContentType("text/html");
////				rd = req.getRequestDispatcher("index.html");
//				res.sendRedirect("");
//
//			}
//		} catch (NullPointerException e) {
//			// not sure this is working how i want it to
//			e.printStackTrace();
//			res.setContentType("text/html");
//
//			System.out.println("in catch in user controller");
//
//			rd = req.getRequestDispatcher("index.html");
////			res.sendRedirect("");
//			rd.include(req, res);
//			out.print("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
//	
//			System.out.println("in catch in user controller after");
//
////			login(req, res);
//		}
//	}
//	
	
	public void employeeSuccess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Print out reimbursements of users
//		res.setContentType("text/html");
		
		System.out.println("in employee success in user controller");
//		RequestDispatcher rd = null;
		req.getRequestDispatcher("employeeSuccess").forward(req,res);

//		rd = req.getRequestDispatcher("employeeSuccess");
//		rd.forward("employeeSuccess.html");
		
		
//		PrintWriter out = res.getWriter();
//
//		System.out.println("your reimb for this user");
//		System.out.println("req: "+ req);
//		System.out.println("reqs: "+ res.getContentType());

		// i want to use employeeSuccess.html but for now it's print outs
		//rd = req.getRequestDispatcher("employeeSuccess.html");
//		out.print("<h1>Welcome, "+ req.getParameter("username")+ "!</h1>");
		// find reimbs from user
		// this an extra step needing to hit database again, not best practice, where can i pass in user so i
		// do not need to do that
		// this should go to employee success not login i believe
//		User u = us.findByUsername(req.getParameter("username"));
//		List<Reimbursement> listReimb = us.findUserReimbursements(u);
//		out.print("<h3>Here are your reimbursements</h3>");
//		int len = listReimb.size();
//		for (int i=0; i<len; i++) {	
//			
//			out.print("<li>"+listReimb.get(i)+"</li>");
//		}
//		// click here to add new reimbursement request
//		//res.sendRedirect("/reimbursements");
//		
//		out.print("<h3>Submit your reimbursement request here</h3>");
//		out.print("		<form action=\"reimbursement\" method=\"post\">\n" + 
//				"			<table>\n" + 
//				"				<tr>\n" + 
//				"					<td><input type=\"text\" name=\"reimbAmount\" placeholder=\"ENTER amount\"></td>\n" + 
//				"				</tr>\n" + 
//				"				\n" + 
//				"				<tr>\n" + 
//				"				<!--  timestamp for submitted-->\n" + 
//				"					<td><input hidden=\"timestamp\" name=\"timestamp\"></td>\n" + 
//				"				</tr>\n" + 
//				"				\n" + 
//				"				<tr>\n" + 
//				"					<td><input type=\"textarea\" name=\"descr\" placeholder=\"ENTER description\"></td>\n" + 
//				"				</tr>\n" + 
//				"				<tr>\n" + 
//				"					<!-- author for submitted-->\n" + 
//				"					<td><input hidden=\"author\" name=\"this user\"></td>\n" + 
//				"				</tr>\n" + 
//				"				<tr>\n" + 
//				"					<!-- reimbursement status-->\n" + 
//				"					<td><input hidden=\"reimbursement status\" name=\"this user\"></td>\n" + 
//				"				</tr>\n" + 
//				"				<tr>\n" + 
//				"					<!-- make this a drop down menu-->\n" + 
//				"					<td><input type=\"text\" name=\"reimb_type\" placeholder=\"ENTER Lodging, Travel, Food, or Other\"></td>\n" + 
//				"				</tr>\n" + 
//				"				<tr>\n" + 
//				"					<td><input type=\"submit\" value=\"employeeSuccess\" name=\"submit this\"></td>\n" + 
//				"				</tr>\n" + 
//				"			</table>		\n" + 
//				"		</form>");
//
//
//		
//		
//
//		System.out.println("your reimb for this user here? in employeeSuccess in user controller");

		
	}


}
