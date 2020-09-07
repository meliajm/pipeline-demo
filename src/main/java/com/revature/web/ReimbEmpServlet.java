//package com.revature.web;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.revature.controllers.ReimbController;
//
//public class ReimbEmpServlet extends HttpServlet {
//	
//	private static ReimbController rc = new ReimbController();
//	
//	public ReimbEmpServlet() {
//		super();
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		res.setContentType("application/json");
////		res.setContentType("text/html");
//		res.setStatus(404);
//
//		final String URI = req.getRequestURI().replace("/project1/", "");
//
//		
//		String[] portions = URI.split("/");
//
//		System.out.println(Arrays.toString(portions));
//		try {
//			switch (portions[0]) {
//			case "reimbursement":
//				if(req.getMethod().equals("POST")) {
//					rc.addReimbursement(req, res);
//				}
//			}
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//			res.getWriter().print("The id you provided is not an integer");
//			res.setStatus(400);
//		}
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		doGet(req, res);
//	}
//
//
//}
