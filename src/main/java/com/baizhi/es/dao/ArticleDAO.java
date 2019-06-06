package com.baizhi.es.dao;

import com.baizhi.entity.Article;

import java.util.List;

public interface ArticleDAO {
    List<Article> userSearch(String term);

    List<Article> searchTileAndContent(String term);
}
