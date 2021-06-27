package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.service.ArticleEcrireService;

public class ArticleEcrireController {
	
	@Autowired
	private ArticleEcrireService ecrireArticleService;
	
	
 	@RequestMapping(value="/nonauth/articles",method=RequestMethod.GET)
	public List<Object> infoArticleReduitesParAuteur(@RequestParam(name="nom",defaultValue="")String nom){
		return ecrireArticleService.infoArticleReduitesParAuteur(nom);
	}
	
 	@RequestMapping(value="/nonauth/articlesparmot",method=RequestMethod.GET)
	public List<Object> infoArticleReduitesMotCle(@RequestParam(name="mot",defaultValue="")String mot){
		return ecrireArticleService.infoArticleReduitesMotCle(mot);
	}
		
	  
	@RequestMapping(value="/auth/articles",method=RequestMethod.GET)
	public List<Object> infoArticle(){
		return ecrireArticleService.infoArticle();
				}


}
