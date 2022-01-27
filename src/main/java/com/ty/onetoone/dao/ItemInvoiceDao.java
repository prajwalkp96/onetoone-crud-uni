package com.ty.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoone.dto.Invoice;
import com.ty.onetoone.dto.Item;

public class ItemInvoiceDao {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	private EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveInvoice(Invoice invoice, Item item) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(item);
		entityManager.persist(invoice);
		entityTransaction.commit();
	}

	public Invoice getInvoiceById(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		Invoice invoice = entityManager.find(Invoice.class, id);
		entityTransaction.commit();
		return invoice;
	}

	public void updateInvoice(Invoice invoice) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(invoice);
		entityTransaction.commit();
	}

	public void deleteInvoice(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		Invoice invoice = entityManager.find(Invoice.class, id);
		if (invoice != null) {
			Item item = invoice.getItem();
			entityManager.remove(invoice);
			if (item != null) {
				entityManager.remove(item);
			}
			entityTransaction.commit();
		}
	}

}
