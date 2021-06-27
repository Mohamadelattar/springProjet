package com.spring.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cle {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCle;
	private String motCle;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;

	public Cle(Long idCle, String motCle, Article article) {
		super();
		this.idCle = idCle;
		this.motCle = motCle;
		this.article = article;
	}

	public Long getIdCle() {
		return idCle;
	}

	public void setIdCle(Long idCle) {
		this.idCle = idCle;
	}

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
}
