package com.TB.spring.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ETUDIANTS")
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 60)
	private String prenom;
	@Column(length = 60)
	private String nom;
	@Column(length = 60)
	private String email;
	@Column(length = 60)
	private String tel;
	
	@ManyToOne
    @JoinColumn(name = "filiere_id", referencedColumnName = "id")
	private Filiere filiere;

	
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String prenom, String nom, String email, String tel, Filiere filiere) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.tel = tel;
		this.filiere = filiere;
	}

	public Etudiant(long id, String prenom, String nom, String email, String tel, Filiere filiere) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.tel = tel;
		this.filiere = filiere;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", tel=" + tel
				+ ", filiere=" + filiere + "]";
	}
	
	
	
}
