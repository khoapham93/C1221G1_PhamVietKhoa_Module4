package com.khoapham.service.impl;

import com.khoapham.model.Blog;
import com.khoapham.repository.IBlogRepository;
import com.khoapham.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null){
            blog.setDateCreate(LocalDate.now());
        }
        this.iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return this.iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        this.iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> search(String keyWord) {
        keyWord = "%"+keyWord+"%";
        return this.iBlogRepository.findByName(keyWord);
    }
}
