package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.beans.ArticleEvaluer;

public interface ArticleEvaluerRepository extends JpaRepository<ArticleEvaluer, Long> {

	 
	public ArticleEvaluer chercherEvaluation(Long idReferee,Long idArticle);
	
	 
	public List<String> etatsEvaluationArticle(Long idArticle);

}
