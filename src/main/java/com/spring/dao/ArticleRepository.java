package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.beans.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
