package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.beans.Article;
import com.spring.beans.ArticleEvaluer;
import com.spring.beans.Auteur;
import com.spring.service.AuteurService;

public class AuteurController {
	
	@Autowired
	private AuteurService auteurService;
	
	
	
 	@RequestMapping(value="/auteur/{id}/articles",method=RequestMethod.GET)
	public List<Object> articleByAuteurId(@PathVariable Long id){
		
		return auteurService.articleByAuteurId(id);
	}
	
	 
	@RequestMapping(value="/auteur/articles/{id}/commentaires",method=RequestMethod.GET)
	public List<Object> rapportJureeByArticleId(@PathVariable Long id){
		return auteurService.rapportJureeByArticleId(id);
	}
	
	 
	
	@RequestMapping(value="/comite/user/{idUser}/articles/{idArticle}",method=RequestMethod.PUT)
	public Article conformeArticle(@RequestBody Article article,@PathVariable Long idUser,@PathVariable Long idArticle) {
		return auteurService.conformeArticle(article,idUser,idArticle);
	}
	
	
	 
	@RequestMapping(value="/comite/conformearticles",method=RequestMethod.GET)
	public List<Article> listArticleConforme(){
		return auteurService.listArticleConforme();
	}
	
	
 	@RequestMapping(value="/comite/referees",method=RequestMethod.GET)
	public List<Auteur> listReferees(){
		return auteurService.listReferees();
	}
	
	
 	@RequestMapping(value="/comite/articles/{idArticle}/referees/{idReferee1}/{idReferee2}/{idReferee3}",method=RequestMethod.POST)
	public String affecterArticleReferees(@PathVariable Long idArticle,@PathVariable Long idReferee1,@PathVariable Long idReferee2
			,@PathVariable Long idReferee3) {
		return auteurService.affecterArticleReferees(idArticle,idReferee1,idReferee2,idReferee3);
	}
	
 	@RequestMapping(value="/referee/{id}/articles",method=RequestMethod.GET)
	public List<Article> listArticleReferee(@PathVariable Long id){
		return auteurService.listArticleReferee(id);
	}
	
 
	@RequestMapping(value="/referee/{idReferee}/articles/{idArticle}",method=RequestMethod.POST)
	public String evaluerArticle(@PathVariable Long idReferee,@PathVariable Long idArticle,
			@RequestBody ArticleEvaluer evaluationJ) {
		return auteurService.evaluerArticle(idReferee,idArticle,evaluationJ);
	}
    
 	@RequestMapping(value="/comite/article/{idArticle}/publier",method=RequestMethod.PUT)
	public String publierArticle(@PathVariable Long idArticle) {
		return auteurService.publierArticle(idArticle);
	}
	
 	@RequestMapping(value="/comite/article/{idArticle}/demandemodification",method=RequestMethod.PUT)
	public String demanderModification(@PathVariable Long idArticle) {
		return auteurService.demanderModification(idArticle);
	}
	
 	@RequestMapping(value="/auteur/{idAuteur}/demandemodification",method=RequestMethod.GET)
	public List<Article> listArticleAuteurDemandeModifcation(@PathVariable Long idAuteur){
		return auteurService.listArticleAuteurDemandeModifcation(idAuteur);
	}
	
 	@RequestMapping(value="/auteur/article/{idArticle}/modifier",method=RequestMethod.PUT)
	public String updateArticle(@PathVariable Long idArticle,@RequestBody Article article) {
		return auteurService.updateArticle(idArticle,article);
	}
	
	
	
	 
	@RequestMapping(value="/comite/article/{idArticle}/refuser",method=RequestMethod.POST)
	public String refuserArticle(@PathVariable Long idArticle) {
		return auteurService.refuserArticle(idArticle);
	}
	

}
