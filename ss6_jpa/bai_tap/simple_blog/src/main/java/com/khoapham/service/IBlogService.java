package com.khoapham.service;

import com.khoapham.model.Blog;


import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void remove(int id);

    List<Blog> search(String keyWord);
}
