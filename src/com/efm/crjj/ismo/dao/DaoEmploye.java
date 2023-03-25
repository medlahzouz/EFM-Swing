package com.efm.crjj.ismo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.efm.crjj.ismo.model.Employe;


import Hibernate_util.HibernateUtils;



public class DaoEmploye implements IDao<Employe> {

	@Override
	public List<Employe> getAll() {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		List<Employe> emps = session.createQuery("from Produit").getResultList();

		t.commit();
		session.close();

		return emps;
	}

	@Override
	public Employe getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Employe employe = session.get(Employe.class, id);

		t.commit();
		session.close();

		return employe;
	}

	@Override
	public boolean save(Employe obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			Object o = session.save(obj);

			System.out.println(o);

			t.commit();
			session.close();

			if (o == null)
				return false;
			else
				return true;

		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public boolean delete(Employe obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
