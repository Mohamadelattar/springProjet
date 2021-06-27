package com.spring.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ArticleEcrire {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEcrire;
 
 @JsonIgnoreProperties("ecrits")
    @ManyToOne
    @JoinColumn(name="idArticle")
    private Article article;
 
 @JsonIgnoreProperties("ecrits")
    @ManyToOne
    @JoinColumn(name="idAuteur")
    private Auteur auteur;

public Long getIdEcrire() {
	return idEcrire;
}

public void setIdEcrire(Long idEcrire) {
	this.idEcrire = idEcrire;
}

public Article getArticle() {
	return article;
}

public void setArticle(Article article) {
	this.article = article;
}

public Auteur getAuteur() {
	return auteur;
}

public void setAuteur(Auteur auteur) {
	this.auteur = auteur;
}

public ArticleEcrire(Long idEcrire, Article article, Auteur auteur) {
	super();
	this.idEcrire = idEcrire;
	this.article = article;
	this.auteur = auteur;
}

public ArticleEcrire() {
	// TODO Auto-generated constructor stub
}
 
 
}
