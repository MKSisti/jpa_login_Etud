package com.TB.spring.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.TB.spring.Entities.Etudiant;

@Repository
public class EtudiantDaoImpl implements IGenericDAO<Etudiant, Long> {

	private EntityManager em ;
	private EntityTransaction tx;
	
	public EtudiantDaoImpl() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
		tx.begin();
	}

	@Override
	public void save(Etudiant t) {
		try {
			em.persist(t);
			tx.commit();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

	@Override
	public List<Etudiant> findAll() {
		List<Etudiant> l = new ArrayList<>();
		Query query = em.createQuery("select e from Etudiant e");
		try {
			l = query.getResultList();
		} catch (Exception e) {
			System.err.println(e);
		}
		return l;
	}

	@Override
	public Etudiant findById(Long id) {
		Etudiant u = new Etudiant();
		try {
			u = em.find(Etudiant.class, id);
		} catch (Exception e) {
			System.err.println(e);
		}
		return u;
	}
	
	public List<Etudiant> findByFiliere(String f){
		List<Etudiant> l = new ArrayList<Etudiant>();
		Query query = em.createQuery("SELECT e FROM Etudiant e WHERE e.filiere.name LIKE :fil");
		query.setParameter("fil", f);
		try {
			l = query.getResultList();
		} catch (Exception e) {
			System.err.println(e);
		}
		return l;
	}

	@Override
	public void update(Etudiant t) {
		System.out.println("inside update of DAO boss ...");
		Etudiant toBeUpdated = findById(t.getId());
		toBeUpdated.setEmail(t.getEmail());
		toBeUpdated.setFiliere(t.getFiliere());
		toBeUpdated.setNom(t.getNom());
		toBeUpdated.setPrenom(t.getPrenom());
		toBeUpdated.setTel(t.getTel());
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
