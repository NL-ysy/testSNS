package com.avocado.moin.media.repository;

import com.avocado.moin.media.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Integer> {

}