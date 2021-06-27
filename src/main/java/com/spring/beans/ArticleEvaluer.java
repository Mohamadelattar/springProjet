package com.spring.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ArticleEvaluer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEvaluation;
    private String etat;
    private String commentaire;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idArticle")
    private Article article;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idAuteur")
    private Auteur auteur;
    
    public ArticleEvaluer(Long idEvaluation, String etat, String commentaire, Article article, Auteur auteur) {
		super();
		this.idEvaluation = idEvaluation;
		this.etat = etat;
		this.commentaire = commentaire;
		this.article = article;
		this.auteur = auteur;
	}

	public ArticleEvaluer() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdEvaluation() {
		return idEvaluation;
	}
	public void setIdEvaluation(Long idEvaluation) {
		this.idEvaluation = idEvaluation;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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
	
    

}
