package com.TB.spring.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLES")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	@Column(length = 60)
	private String name;
	@Column(length = 60)
	private String description;
	private float price;
	private int count;
	
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Article(int code, String name, String description, float price, int count) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.count = count;
	}
	

	public Article(String name, String description, float price, int count) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Article [code=" + code + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", count=" + count + "]";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
