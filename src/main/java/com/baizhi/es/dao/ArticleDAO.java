package com.baizhi.es.dao;

import com.baizhi.es.entity.User;

import java.util.List;

public interface ArticleDAO {

    List<User> userSearch(String term);
}
