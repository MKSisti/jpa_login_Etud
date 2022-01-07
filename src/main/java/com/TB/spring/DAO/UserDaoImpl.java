package com.TB.spring.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.TB.spring.Entities.User;

@Repository
public class UserDaoImpl implements IGenericDAO<User, Long> {

	private EntityManager em ;
	private EntityTransaction tx;
	
	
	
	public UserDaoImpl() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
		tx.begin();
	}
	
	public User loginUser(User t) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.userName LIKE :uname AND u.password LIKE :pwd");
		query.setParameter("uname", t.getUserName());
		query.setParameter("pwd", t.getPassword());
		try {
			return (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public void save(User t) {
		try {
			em.persist(t);
			tx.commit();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

	@Override
	public List<User> findAll() {
		List<User> l = new ArrayList<>();
		Query query = em.createQuery("select u from User u");
		try {
			l = query.getResultList();
		} catch (Exception e) {
			System.err.println(e);
		}
		return l;
	}

	@Override
	public User findById(Long id) {
		User u = new User();
		try {
			u = em.find(User.class, id);
		} catch (Exception e) {
			System.err.println(e);
		}
		return u;
	}

	@Override
	public void update(User t) {
		User toBeUpdated = findById(t.getId());
		toBeUpdated.setUserName(t.getUserName());
		toBeUpdated.setPassword(t.getPassword());
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
