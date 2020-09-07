package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.ReimbursementType;
import com.revature.utils.HibernateUtil;

public class ReimbTypeDAO implements IReimbTypeDAO {

	@Override
	public ReimbursementType findByType(String type) {
		Session ses = HibernateUtil.getSession();
		List<ReimbursementType> list = (List<ReimbursementType>) ses.createQuery("FROM ReimbursementType rt WHERE rt.reimbType='"+type+"'", ReimbursementType.class).list();
		return list.get(0);
	}
	

}
