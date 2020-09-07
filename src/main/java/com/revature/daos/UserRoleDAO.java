package com.revature.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.userRole;
import com.revature.utils.HibernateUtil;

public class UserRoleDAO implements IUserRoleDAO {
	
	public UserRoleDAO() {
		super();
	}

	@Override
	public userRole findByID(int id) {
		Session ses = HibernateUtil.getSession();
		userRole ur = ses.get(userRole.class, id);
		return ur;
	}

	@Override
	public void addUserRole(userRole ur) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(ur);
		tx.commit();		
	}
	
//	@Override
//	public userRole findByID(int id) {
//		try(Connection conn = ConnectionUtility.getConnection()) {
//			String sql = "SELECT * FROM users u JOIN user_roles ur ON u.user_role_id = ur.user_role_id WHERE u.user_id =" + id+";";
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery(sql);
//			if (result.next()) {
//				userRole ur = new userRole();
//				ur.setUserRoleID(result.getInt("user_role_id")); 
//				ur.setUserRole(result.getString("user_role"));
//				return ur;
//			} else {
//				return null;
//			}
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
