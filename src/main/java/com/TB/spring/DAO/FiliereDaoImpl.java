package com.TB.spring.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.TB.spring.Entities.Filiere;

@Repository
public class FiliereDaoImpl implements IGenericDAO<Filiere, Long> {

	private EntityManager em ;
	private EntityTransaction tx;
	
	
	public FiliereDaoImpl() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
		tx.begin();
	}

	@Override
	public void save(Filiere t) {
		try {
			em.persist(t);
			tx.commit();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public List<Filiere> findAll() {
		List<Filiere> l = new ArrayList<>();
		Query query = em.createQuery("select f from Filiere f");
		try {
			l = query.getResultList();
		} catch (Exception e) {
			System.err.println(e);
		}
		return l;
	}

	@Override
	public Filiere findById(Long id) {
		Filiere u = new Filiere();
		try {
			u = em.find(Filiere.class, id);
		} catch (Exception e) {
			System.err.println(e);
		}
		return u;
	}

	@Override
	public void update(Filiere t) {
		Filiere filToUpdate = findById(t.getId());
		filToUpdate.setDescription(t.getDescription());
		filToUpdate.setName(t.getName());
		tx.commit();
	}

	@Override
	public void deleteById(Long id) {
		try {
			em.remove(findById(id));
			tx.commit();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	

}
