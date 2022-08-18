package com.hospitalmanagement.daoIMPL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalmanagement.dao.AdminDao;
import com.hospitalmanagement.model.Admin;

@Repository
public class AdminDaoIMPL implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Admin loginAdmin(String username, String password) {
		Admin admin = null;
		Session session = sessionFactory.openSession();

		try {
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Admin.class);
			SimpleExpression usernameExp = Restrictions.eq("username", username);
			SimpleExpression passwordExp = Restrictions.eq("password", password);

			criteria.add(Restrictions.and(usernameExp, passwordExp));
			admin = (Admin) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return admin;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		boolean opFlag=false;
		try {
			session.save(admin);
			transaction.commit();
			opFlag=true;
		} catch (Exception e) {
			e.printStackTrace();
			opFlag=false;
		} finally {
			session.close();
		}

		return opFlag;
	}

	@Override
	public void deleteAdminById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Admin getAdminById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

}
