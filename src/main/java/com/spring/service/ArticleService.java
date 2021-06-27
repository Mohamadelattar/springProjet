package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.beans.Article;
import com.spring.beans.ArticleEcrire;
import com.spring.dao.ArticleEcrireRepository;
import com.spring.dao.ArticleRepository;

 
import java.util.Optional;

 

public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ArticleEcrireRepository ecrireArticleRepository;
	
	
     
	public Article ajouterArticle(Article article) {
		article.setEtat("new");
		Article art=articleRepository.save(article);
		
		for(ArticleEcrire e : article.getEcrits()) {
			ArticleEcrire ecrire=new ArticleEcrire();
			ecrire.setArticle(article);
			ecrire.setAuteur(e.getAuteur());
			ecrireArticleRepository.save(ecrire);
		}
		return art;
	}
	
	
	public boolean supprimerArticle(Long id) {
		Optional<Article> article =articleRepository.findById(id);
		if(article.get().getEtat().equals("new")) {
			for(ArticleEcrire e : article.get().getEcrits()){
				ecrireArticleRepository.deleteById(e.getIdEcrire());
			}
			articleRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
		}
	
	public Article modifierArticle(Article article,Long id) {
		Article art=articleRepository.findById(id).get();
		Article arrr=null;
		if(art.getEtat().equals("new")) {
			article.setIdArticle(id);
			 arrr=articleRepository.save(article);
		}
		return arrr;
		
	}
}
