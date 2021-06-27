package com.spring.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Article {
	private Long idArticle;
	private String titre;
	private String affiliation;
	private String resume;
	private String contenu;
	private String decision;
	private String etat;
	
	  @JsonIgnoreProperties("article")
	@OneToMany(mappedBy="article")
	private Set<Cle> mots=new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="article")
	private Set<ArticleEvaluer> evaluations=new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="article")
	private Set<ArticleEcrire> ecrits=new HashSet<>();

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Set<Cle> getMots() {
		return mots;
	}

	public void setMots(Set<Cle> mots) {
		this.mots = mots;
	}

	public Set<ArticleEvaluer> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<ArticleEvaluer> evaluations) {
		this.evaluations = evaluations;
	}

	public Set<ArticleEcrire> getEcrits() {
		return ecrits;
	}

	public void setEcrits(Set<ArticleEcrire> ecrits) {
		this.ecrits = ecrits;
	}

	public Article(Long idArticle, String titre, String affiliation, String resume, String contenu, String decision,
			String etat, Set<Cle> mots, Set<ArticleEvaluer> evaluations, Set<ArticleEcrire> ecrits) {
		super();
		this.idArticle = idArticle;
		this.titre = titre;
		this.affiliation = affiliation;
		this.resume = resume;
		this.contenu = contenu;
		this.decision = decision;
		this.etat = etat;
		this.mots = mots;
		this.evaluations = evaluations;
		this.ecrits = ecrits;
	}
	
	

}
