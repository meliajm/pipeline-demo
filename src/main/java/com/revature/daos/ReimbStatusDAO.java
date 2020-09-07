package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.ReimbursementStatus;
import com.revature.utils.HibernateUtil;

public class ReimbStatusDAO implements IReimbStatusDAO {

	@Override
	public ReimbursementStatus findByStatus(String status) {
		Session ses = HibernateUtil.getSession();
		List<ReimbursementStatus> list = (List<ReimbursementStatus>) ses.createQuery("FROM ReimbursementStatus rs WHERE rs.reimbStatus='"+status+"'", ReimbursementStatus.class).list();
		return list.get(0);
	}
}
