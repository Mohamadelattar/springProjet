package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.beans.Article;
import com.spring.service.ArticleService;

public class ArticleController {

	@Autowired
	private ArticleService articleService;


	@RequestMapping(value="/auteur/articles",method=RequestMethod.POST)
	public Article ajouterArticle(@RequestBody Article article) {
		return articleService.ajouterArticle(article);
	}
	
 	@RequestMapping(value="/auteur/articles/{id}",method=RequestMethod.DELETE)
	public boolean supprimerArticle(@PathVariable Long id) {
		 return articleService.supprimerArticle(id);
		
	}
 	
 	@RequestMapping(value="/auteur/articles/{id}",method=RequestMethod.PUT)
	public Article modifierArticle(@RequestBody Article article,@PathVariable Long id) {
		return articleService.modifierArticle(article,id);
	}
	
	
}
