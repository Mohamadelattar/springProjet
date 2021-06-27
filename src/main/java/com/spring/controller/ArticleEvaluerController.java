package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.ArticleEvaluerService;

@RestController
@CrossOrigin
public class ArticleEvaluerController {
	
	@Autowired 
	private ArticleEvaluerService evaluationJureeService;

}
