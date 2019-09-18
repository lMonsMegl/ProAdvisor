package com.proadvisor.controller;

import com.proadvisor.model.entity.item.Category;
import com.proadvisor.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    
    @GetMapping(value = "/main")
    public List<Category> getMainCategories() {
        return categoryService.getMainCategories();
    }
    
    @GetMapping(value = "/sub/**")
    public List<Category> getSubCategories(final HttpServletRequest request) {
        final String categoryChain = new AntPathMatcher().extractPathWithinPattern("/categories/sub/**", request.getRequestURI());
        return categoryService.getSubCategories(Arrays.asList(categoryChain.split("/")));
    }
}