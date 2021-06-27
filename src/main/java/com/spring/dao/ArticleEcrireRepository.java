package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.beans.ArticleEcrire;

public interface ArticleEcrireRepository extends JpaRepository<ArticleEcrire, Long> {

	 
	   public List<Object> infoArticleReduitesParAuteur(String nom);
		
		 
	   public List<Object> infoArticleReduitesMotCle(String mot);
		
		
	   public List<Object> infoArticle();
}
