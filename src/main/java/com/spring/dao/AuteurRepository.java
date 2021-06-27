package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.beans.Article;
import com.spring.beans.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {

	public Auteur findAuteurByUsername(String username);
	 
	public List<Object> articleByAuteurId(Long id);
	 
	public List<Object> rapportJureeByArticleId(Long id);
	 
	public List<Article> listArticleConforme();
	
	public List<Auteur> listReferees();
	
	public List<Article> listArticleReferee(Long id);
	
	public List<Article> listArticleAuteurDemandeModifcation(Long id);

}
