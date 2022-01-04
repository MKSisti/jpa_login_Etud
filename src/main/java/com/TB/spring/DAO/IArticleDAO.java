package com.TB.spring.DAO;

import java.util.List;

import com.TB.spring.Entities.Article;

public interface IArticleDAO {
	public void save(Article a);
	public List<Article> findAll();
	public Article findById(int id);
	public void update(Article a);
	public void deleteById(int id);
}
