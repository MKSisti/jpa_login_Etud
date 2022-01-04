package com.TB.spring.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FILIERE")
public class Filiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 60)
	private String description;
	@Column(length = 60)
	private String name;
	
	@OneToMany(mappedBy = "filiere")
	private List<Etudiant> etudiants = new ArrayList<>();

	
	
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Filiere(String description, String name, List<Etudiant> etudiants) {
		super();
		this.description = description;
		this.name = name;
		this.etudiants = etudiants;
	}

	public Filiere(Long id, String description, String name, List<Etudiant> etudiants) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.etudiants = etudiants;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", description=" + description + ", name=" + name ;
	}
	
	
}
