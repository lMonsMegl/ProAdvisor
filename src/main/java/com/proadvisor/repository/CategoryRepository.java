package com.proadvisor.repository;

import com.proadvisor.model.entity.item.Category;

import java.util.List;

public interface CategoryRepository {
    
    List<Category> getCategories();
    
    Category getById(long id);
    
    void addNewCategory(Category category);
}
