package com.spring.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Auteur {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAuteur;
	private String lastNameAuteur;
	private String firstNameAuteur;
	
	private String username;
	private String password;
	
	private String email;

		@ManyToOne
		@JoinColumn(name="idRole")
		private Role role;
		

	public Auteur(Long idAuteur, String lastNameAuteur, String firstNameAuteur, String username, String password,
			String email) {
		super();
		this.idAuteur = idAuteur;
		this.lastNameAuteur = lastNameAuteur;
		this.firstNameAuteur = firstNameAuteur;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Long idAuteur) {
		this.idAuteur = idAuteur;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastNameAuteur() {
		return lastNameAuteur;
	}

	public void setLastNameAuteur(String lastNameAuteur) {
		this.lastNameAuteur = lastNameAuteur;
	}

	public String getFirstNameAuteur() {
		return firstNameAuteur;
	}

	public void setFirstNameAuteur(String firstNameAuteur) {
		this.firstNameAuteur = firstNameAuteur;
	}
	
	
	

}
