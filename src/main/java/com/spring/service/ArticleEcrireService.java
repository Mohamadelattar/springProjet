package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.ArticleEcrireRepository;

public class ArticleEcrireService {
	
	@Autowired
	private ArticleEcrireRepository ecrireArticleRepository;
	
	 public List<Object> infoArticleReduitesParAuteur(String nom){
		 return ecrireArticleRepository.infoArticleReduitesParAuteur("%"+nom+"%");
	 }
		
	 public List<Object> infoArticleReduitesMotCle(String mot){
		 return ecrireArticleRepository.infoArticleReduitesMotCle("%"+mot+"%");
	 }
	 
	 public List<Object> infoArticle(){
		 return ecrireArticleRepository.infoArticle();
	 }

}
