package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.beans.Article;
import com.spring.beans.ArticleEvaluer;
import com.spring.beans.Auteur;
import com.spring.dao.ArticleEvaluerRepository;
import com.spring.dao.ArticleRepository;
import com.spring.dao.AuteurRepository;

public class AuteurService {
	
	
	@Autowired
	private AuteurRepository auteurRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired 
	private ArticleEvaluerRepository evaluationJureeRepository;
	
 
	public List<Object> articleByAuteurId(Long id){
	   return auteurRepository.articleByAuteurId(id);
	}
	
 
	public List<Object> rapportJureeByArticleId(Long id){
		List<Object> comments=null;
		Article article=articleRepository.findById(id).get();
		if(!article.getEtat().equals("new") && !article.getDecision().equals("published")) {
	
		comments= auteurRepository.rapportJureeByArticleId(id);
		}
		return comments;
	}
 	public Article conformeArticle(Article article,Long idUser,Long idArticle) {
		Article arrrr=null;
		Auteur auteur=auteurRepository.findById(idUser).get();
		if(auteur.getRole().getNomRole().equals("comite")) {
			Article art=articleRepository.findById(idArticle).get();
			if(art.getEtat().equals("new")) {
				article.setIdArticle(idArticle);
				arrrr=articleRepository.save(article);
			}
			
		}
		return arrrr;
		
	}
	 
	public List<Article> listArticleConforme(){
		return auteurRepository.listArticleConforme();
	}

	
     public List<Auteur> listReferees(){
  	  return auteurRepository.listReferees();
    }
	
    
       public String affecterArticleReferees(Long idArticle,Long idReferee1,Long idReferee2,Long idReferee3) {
		
    	  Article article=articleRepository.findById(idArticle).get();
    	  if(article.getEtat().equals("conforme")) {
    		  Auteur auteur=auteurRepository.findById(idReferee1).get();
     		  if(auteur.getRole().getNomRole().equals("referee")) {
    			  ArticleEvaluer evaluation1=new ArticleEvaluer();
    			  evaluation1.setArticle(article);
    			  evaluation1.setAuteur(auteur);
    			  evaluationJureeRepository.save(evaluation1);
    		  }
    		  Auteur auteur2=auteurRepository.findById(idReferee2).get();
     		  if(auteur2.getRole().getNomRole().equals("referee")) {
    			  ArticleEvaluer evaluation2=new ArticleEvaluer();
    			  evaluation2.setArticle(article);
    			  evaluation2.setAuteur(auteur2);
    			  evaluationJureeRepository.save(evaluation2);
    		  }
    		  
     		  Auteur auteur3=auteurRepository.findById(idReferee3).get();
    		   
    		  if(auteur3.getRole().getNomRole().equals("referee")) {
    			  ArticleEvaluer evaluation3=new ArticleEvaluer();
    			  evaluation3.setArticle(article);
    			  evaluation3.setAuteur(auteur3);
    			  evaluationJureeRepository.save(evaluation3);
    		  }
    		  
    		  article.setEtat("transferred");
    		  articleRepository.save(article);
    		  
    		  return "affectation réussite";
    	  }
    	  else {
    		  return "ERROR | l'article n'a pas le statut conforme" ;
    	  }
    	  
    	  
		
	}
      
      
      public List<Article> listArticleReferee(Long id){
    	  return auteurRepository.listArticleReferee(id);
      }
      
      public String evaluerArticle(Long idReferee,Long idArticle,ArticleEvaluer evaluationJ) {
    	  String message="Impossible d'ajouter l'évaluation";
    	  Article article = articleRepository.findById(idArticle).get();
    	  if(article.getEtat().equals("transferred")) {
    		  ArticleEvaluer evaluation=evaluationJureeRepository.chercherEvaluation(idReferee, idArticle);
    		  if(evaluation.getEtat()==null) {
        	  evaluation.setCommentaire(evaluationJ.getCommentaire());
        	  evaluation.setEtat(evaluationJ.getEtat());
        	  evaluationJureeRepository.save(evaluation);
        	  message="Evaluation ajoutée";
        	  testEvaluationTerminer(idArticle);
    		  }
    		  else {
    			  message="Impossible d'ajouter l'évaluation";
    		  }
    	  }
    	  return message;
      }
      
       
      public void testEvaluationTerminer(Long idArticle) {
    	   boolean t=true;
    	  List<String> etatsEvaluation=evaluationJureeRepository.etatsEvaluationArticle(idArticle);
    	  for(String e : etatsEvaluation) {
    		  if(e==null) {
    			  t=false;
    		  }
    	  }
    	  
    	  if(t) {
    		  Article article=articleRepository.findById(idArticle).get();
    		  article.setEtat("corrected");
    		  articleRepository.save(article);
    	  }
    	  
      }
      
      
       
      public String publierArticle(Long idArticle) {
    	  String message="";
    	  Article article=articleRepository.findById(idArticle).get();
    	  if(article.getEtat().equals("corrected")) {
    		  article.setEtat("accepted");
    		  article.setDecision("published");
    		  articleRepository.save(article);
    		  message="article publiée";
    	  }
    	  else if(article.getEtat().equals("modified")){
    		  article.setEtat("accepted");
    		  article.setDecision("published");
    		  articleRepository.save(article);
    		  message="article publiée";
    		  
    	  }
    	  else {
    		  message="impossible de publier l'article";
    	  }
    	  return message;
    	  
      }
      
    //permet à la comité éditorial de demander des modification sur un articles
      public String demanderModification(Long idArticle) {
    	  String message="";
    	  Article article=articleRepository.findById(idArticle).get();
    	  if(article.getEtat().equals("corrected")) {
    		  article.setEtat("request modification");
    		
    		  articleRepository.save(article);
    		  message="modifications demandées";
    	  }
    	  else {
    		  message="impossible de demander des modfications";
    	  }
    	  return message;
    			  
      }

       
        public List<Article> listArticleAuteurDemandeModifcation(Long id){
      	  return auteurRepository.listArticleAuteurDemandeModifcation(id);
      	  
        }
        
         public String updateArticle(Long idArticle,Article article) {
        	String message="";
        	Article art= articleRepository.findById(idArticle).get();
        	if(art.getEtat().equals("request modification")) {
        		article.setIdArticle(idArticle);
        		article.setEtat("modified");
        		articleRepository.save(article);
        		
        		 message="modifications apportées";
        	}
        	return message;
        	
        }
        
        
      public String refuserArticle(Long idArticle) {
    	  String message="";
    	  Article article=articleRepository.findById(idArticle).get();
    	  if(article.getEtat().equals("corrected")) {
    		  article.setEtat("refused");
    		  article.setDecision("not published");
    		  articleRepository.save(article);
    		  message="article refusé";
    	  }
    	  else if(article.getEtat().equals("new")){
    		  article.setEtat("refused");
    		  article.setDecision("not published");
    		  articleRepository.save(article);
    		  message="article n'est pas conforme avec la politique de la revue";
    	  }
    	  else {
    		  message="impossible de refuser l'article";
    	  }
    	  return message;
    	  
      }


}
