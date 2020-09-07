package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDAO;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;
import com.revature.services.UserRoleService;
import com.revature.services.UserService;

public class LoginController {

	private static LoginService ls = new LoginService();
	private static ObjectMapper om = new ObjectMapper();
	
	RequestDispatcher rd = null;


	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// what is request? here
//		String payloadRequest = getBody(req);
		//System.out.println("pay "+ payloadRequest); //pay {"username":"tiaclair1","password":"p"}
//		System.out.println("req contains ? "+req.getParameterMap().containsKey("user"));

		String username = req.getParameter("username");
		System.out.println("username in lc "+username);
		String password = req.getParameter("password");
		
//		String emp = us.findByUsername(username).getUserRole().getUserRole();
//		System.out.println("emp " +emp);
//		
		LoginDTO l = new LoginDTO();
		l.username = username;
		l.password = password;
		
		
		// && emp.equals("Employee"))
		
		if(req.getMethod().equals("GET")) {
//			System.out.println("in login control login if");
//			LoginDTO l = new LoginDTO();
//			l.username = req.getParameter("username");
//			l.password = req.getParameter("password");
			
			if(ls.login(l)) {
				HttpSession ses = req.getSession();
				ses.setAttribute("user", l);
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				res.getWriter().println("Login Successful");

			} else {
				HttpSession ses = req.getSession(false);
				if(ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
				res.getWriter().println("Login failed");
			}
		}
			else if (req.getMethod().equals("POST")) {

			BufferedReader reader = req.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			
			while (line != null) {
				sb.append(line);
				line=reader.readLine();
			}
			String body = new String(sb);
			System.out.println("body: "+ body);
			l = om.readValue(body, LoginDTO.class);
			System.out.println("ls.login(l): "+ ls.login(l));

			if(ls.login(l)) {
				HttpSession ses = req.getSession();
				System.out.println("you logged in, success!");
				ses.setAttribute("user", l);
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				res.getWriter().println("Login Successful");
//				User u = us.findByUsername(username);
//				res.getWriter().println("user role: " + u.getUserRole().getUserRole());

//				res.getWriter().println("hashcode: "+"p".hashCode());
//				res.getWriter().println("hashcode: "+"p".hashCode());
//				res.getWriter().println("hashcode: "+"q".hashCode());
//				res.setContentType("text/html");
//				System.out.println("username in ls.login "+ username);
//				System.out.println("ses "+ ses);

//				User u = us.findByUsername(username) ;
//				userRole ur = urs.findByID(u.getUserID());
				// need to make this switch so that we can figure out what 
				//type of user (employee or finance manager)
				// then what?
//				if (ur.getUserRole().equals("Employee")) {					
////					req.getRequestDispatcher("employeeSuccess.html").forward(req,res);
//					System.out.println("employee success");
//				} else if (ur.getUserRole().equals("Employee")) {
//					System.out.println("financem success");
////					req.getRequestDispatcher("financeMSuccess.html").forward(req,res);
//				}

			} else {
				HttpSession ses = req.getSession(false);
				if(ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
				res.getWriter().println("Login failed");
			}
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);
		if (ses !=null) {
			LoginDTO l = (LoginDTO) ses.getAttribute("user"); 
			ses.invalidate();		
			res.setStatus(200);
			res.getWriter().println(l.username+" has logged out successfully.");
					
		}  else {
			res.setStatus(400);
			res.getWriter().println("you must be logged in to log out");
		}
	}

	public void financeLogin(HttpServletRequest req, HttpServletResponse res) {
//		System.out.println("finance manager is logging in.");
		
	}
	
//	public static String getBody(HttpServletRequest request) throws IOException {
//
//	    String body = null;
//	    StringBuilder stringBuilder = new StringBuilder();
//	    BufferedReader bufferedReader = null;
//
//	    try {
//	        InputStream inputStream = request.getInputStream();
//	        if (inputStream != null) {
//	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//	            char[] charBuffer = new char[128];
//	            int bytesRead = -1;
//	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
//	                stringBuilder.append(charBuffer, 0, bytesRead);
//	            }
//	        } else {
//	            stringBuilder.append("");
//	        }
//	    } catch (IOException ex) {
//	        throw ex;
//	    } finally {
//	        if (bufferedReader != null) {
//	            try {
//	                bufferedReader.close();
//	            } catch (IOException ex) {
//	                throw ex;
//	            }
//	        }
//	    }
//
//	    body = stringBuilder.toString();
//	    return body;
//	}


}
