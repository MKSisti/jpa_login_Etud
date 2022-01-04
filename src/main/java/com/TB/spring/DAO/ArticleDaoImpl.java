package com.TB.spring.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;


import com.TB.spring.Entities.Article;

public class ArticleDaoImpl implements IArticleDAO {
//	
//	@PersistenceContext
	private EntityManager em ;
	private EntityTransaction tx;
//	
	
	
	public ArticleDaoImpl() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
		tx.begin();
	}

	@Override
	@Transactional
	public void save(Article a) {
		// TODO Auto-generated method stub
		System.out.println(a.toString());
		try {
			em.persist(a);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		
	}

	@Override
	public List<Article> findAll() {
		try {
			Query query = em.createQuery("select a from Article a");
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e);
		}
		return new ArrayList<Article>();
		
		
	}

	@Override
	@Transactional
	public Article findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Article.class, id);
	}

	@Override
	@Transactional
	public void update(Article a) {
		System.out.println(a.toString());
		Article toBeUpdated = findById(a.getCode());
		toBeUpdated.setCount(a.getCount());
		toBeUpdated.setDescription(a.getDescription());
		toBeUpdated.setName(a.getName());
		toBeUpdated.setPrice(a.getPrice());
		tx.commit();

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		em.remove(findById(id));
		tx.commit();
	}

}
