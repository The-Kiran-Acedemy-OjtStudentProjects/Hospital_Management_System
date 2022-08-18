package com.hospitalmanagement.daoIMPL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalmanagement.dao.PharmacistDao;
import com.hospitalmanagement.model.Admin;
import com.hospitalmanagement.model.Pharmacist;

@Repository
public class PharmacistDaoIMPL implements PharmacistDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Pharmacist addPharmacist(Pharmacist Pharmacist) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(Pharmacist);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return Pharmacist;
	}

	@Override
	public void deletePharmacistById(Integer id) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	@Override
	public Pharmacist getPharmacistById(Integer id) {
		Session session = sf.openSession();
		Pharmacist pharmacist = null;
		try {
			pharmacist = session.get(Pharmacist.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pharmacist;
	}

	@Override
	public Pharmacist updatePharmacist(Pharmacist Pharmacist) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(Pharmacist);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return Pharmacist;
	}

	@Override
	public Pharmacist loginPharmacist(String username, String password) {
		Session session = sf.openSession();
		Pharmacist pharmacist = null;
		try {
			Criteria criteria = session.createCriteria(Pharmacist.class);
			SimpleExpression usernameExp = Restrictions.eq("username", username);
			SimpleExpression passwordExp = Restrictions.eq("password", password);

			criteria.add(Restrictions.and(usernameExp, passwordExp));

			pharmacist = (Pharmacist) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return pharmacist;
	}

	@Override
	public Long getPharmacistsTotalCount() {
		Session session = sf.openSession();
		Long totalcount = 0L;
		try {
			Criteria criteria = session.createCriteria(Pharmacist.class);
			criteria.setProjection(Projections.rowCount());
			totalcount = (Long) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return totalcount;
	}

	@Override
	public List<Pharmacist> getPharmacistsByFirstName(String firstName) {
		Session session = sf.openSession();
		List<Pharmacist> pharmacistList = null;
		try {
			pharmacistList = session.createCriteria(Pharmacist.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return pharmacistList;
	}

	@Override
	public Long getPharmacistCountByDate(String date) {
		Session session = sf.openSession();
		Long totalcount = 0L;
		try {
			Criteria criteria = session.createCriteria(Pharmacist.class);
			criteria.add(Restrictions.eq("registerdate", date));
			criteria.setProjection(Projections.rowCount());
			totalcount = (Long) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return totalcount;
	}

}
