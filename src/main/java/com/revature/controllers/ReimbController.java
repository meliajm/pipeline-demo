package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbDTO;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbService;
import com.revature.services.UserService;

public class ReimbController {
	
	private static ReimbService rs = new ReimbService();
	private static ObjectMapper om = new ObjectMapper();

	private static UserService us = new UserService();

	public void getReimbursement(HttpServletResponse res, int id) throws IOException {
		Reimbursement r = rs.findById(id);
		System.out.println("in rc get reimb, r: "+r);
		if (r==null) {
			res.setStatus(204);
		} else {
			System.out.println("in get reimb rc");
			res.setStatus(200);
			String json = om.writeValueAsString(r);
			System.out.println("in rc get reimb, json: "+json);
			res.getWriter().println(json);
		}
	}
	
	public void getAllReimbursements(HttpServletResponse res) throws IOException {
		List<Reimbursement> all = rs.findAll();
		res.getWriter().println(om.writeValueAsString(all));
		res.setStatus(200);
	}
	
	public void updateReimbursement(HttpServletRequest req,  HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		String body = new String(s);		
		System.out.println("body: "+ body);
//		Reimbursement r = om.readValue(body, Reimbursement.class);
		ReimbDTO r = om.readValue(body, ReimbDTO.class);

		System.out.println("r: "+ r);
		if (rs.updateReimbursement(r)) {
			res.setStatus(202);
			res.getWriter().println("Reimb was updated");
		} else {
			res.setStatus(403);
		}
	}

	
	public void addReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		String body = new String(s);		
		System.out.println("body: "+ body);
		ReimbDTO r = om.readValue(body, ReimbDTO.class);
		System.out.println("r: "+ r);
		if (rs.addReimbursement(r)) {
			res.setStatus(201);
			res.getWriter().println("Reimb was created");
		} else {
			res.setStatus(403);
		}
	}

}
