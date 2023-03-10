package com.jbk.product.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jbk.product.config.HibernateUtility;
import com.jbk.product.entity.Product;

public class ProductDao {

	SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

	public boolean saveProduct(Product product) {

		// get session factory

		boolean isAdded = false;
		Session session = sessionFactory.openSession();
		try {
			// get session from session factory

			Transaction transaction = session.beginTransaction();
			
			session.save(product);
			transaction.commit();
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isAdded;

	}
	
	public Product getProductById(int productId) {
		Session session = sessionFactory.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return product;

	}

	public boolean deleteProductById(int productId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		try {
			Product product = session.get(Product.class, productId);
			if (product != null) {
				session.delete(product);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isDeleted;
	}

	public boolean updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {
			Product prd = session.get(Product.class, product.getProductId());
			session.evict(prd);
			if (prd != null) {
				session.update(product);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;

	}

}
