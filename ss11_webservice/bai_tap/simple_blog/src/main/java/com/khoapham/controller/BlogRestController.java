package com.khoapham.controller;

import com.khoapham.model.Blog;
import com.khoapham.model.Category;
import com.khoapham.service.IBlogService;
import com.khoapham.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/blogsRest")
@RestController
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("/blogs")
    public ResponseEntity<Page<Blog>> getAllBlog(@RequestParam(defaultValue = "0") Integer page,
                                                 @RequestParam(defaultValue = "3") Integer pageSize,
                                                 @RequestParam Optional<String> sort,
                                                 @RequestParam Optional<String> dir,
                                                 @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        String sortVal = sort.orElse("");
        String dirVal = dir.orElse("");

        Pageable pageable;
        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        } else {
            if (dirVal.equals("asc")) {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            } else {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).descending());
            }
        }

        Page<Blog> productList = iBlogService.search(keywordVal, pageable);

        if (!productList.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> view(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Page<Blog>> getBlogOfCategory(@PathVariable Integer id, Pageable pageable) {
        Page<Blog> productList = iBlogService.findByCategoryId(id, pageable);
        if (!productList.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
