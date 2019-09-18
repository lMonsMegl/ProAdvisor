package com.proadvisor.service;

import com.proadvisor.model.entity.item.Category;

import java.util.List;

public interface CategoryService {
    
    List<Category> getAllCategories();
    
    Category getById(long id);
    
    List<Category> getMainCategories();
    
    List<Category> getSubCategories(final List<String> pathToCategory);
    
    void importCategory(Category category);
}
