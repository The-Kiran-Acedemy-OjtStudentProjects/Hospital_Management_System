package com.hospitalmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalmanagement.model.Doctor;

@Repository
public class DoctorDao_impl implements DoctorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
		boolean b = false;
		try {
			Transaction transaction = session.beginTransaction();
			session.save(doctor);
			transaction.commit();
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		} finally {
			session.close();
		}

		return b;
	}

	@Override
	public boolean deleteDoctorById(Integer id) {
		Session session = sessionFactory.openSession();
		boolean b = false;
		try {
			Doctor doctor = new Doctor();
			Transaction transaction = session.beginTransaction();
			doctor.setId(id);
			session.delete(doctor);
			transaction.commit();
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		} finally {

		}
		return b;

	}

	@Override
	public Doctor getDoctorById(Integer id) {
		Session session = sessionFactory.openSession();
		Doctor doctor = null;

		try {
			doctor = session.get(Doctor.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			doctor = null;
		} finally {
			session.close();
		}
		return doctor;
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
		boolean b = false;
		try {
			Transaction transaction = session.beginTransaction();
			session.update(doctor);
			transaction.commit();
			b = true;

		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		} finally {
			session.close();
		}
		if (b) {
			return doctor;
		} else {
			return null;
		}
	}

	@Override
	public Doctor loginDoctor(String username, String password) {
		Doctor doctor = null;
		Session session = sessionFactory.openSession();

		try {
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Doctor.class);
			SimpleExpression usernameExp = Restrictions.eq("username", username);
			SimpleExpression passwordExp = Restrictions.eq("password", password);

			criteria.add(Restrictions.and(usernameExp, passwordExp));
			doctor = (Doctor) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return doctor;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = null;
		Session session = sessionFactory.openSession();
		try {
			doctors = session.createCriteria(Doctor.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return doctors;
	}

	@Override
	public Long getDoctorsTotalCounts() {
		Session session = sessionFactory.openSession();
		Long doctorCount = 0L;
		try {
			Criteria criteria = session.createCriteria(Doctor.class).setProjection(Projections.rowCount());
			List<?> count = criteria.list();
			if (!count.isEmpty()) {
				doctorCount = (Long) count.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return doctorCount;
	}

	@Override
	public Long getDoctorsCountByDate(String registereddate) {
		Session session = sessionFactory.openSession();
		Long doctorCount = 0L;
		try {
			Criteria criteria = session.createCriteria(Doctor.class)
					.add(Restrictions.eq("registerdate", registereddate)).setProjection(Projections.rowCount());
			List<?> count = criteria.list();
			if (!count.isEmpty()) {
				doctorCount = (Long) count.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return doctorCount;
	}

	@Override
	public List<Doctor> getDoctorsByName(String doctorName) {
		List<Doctor> doctors = null;
		Session session = sessionFactory.openSession();
		try {
			doctors = session.createCriteria(Doctor.class).add(Restrictions.eq("firstname", doctorName)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return doctors;
	}

}
