package com.proadvisor.service;

import com.proadvisor.model.entity.item.Category;
import com.proadvisor.model.entity.item.CategoryBase;
import com.proadvisor.repository.CategoryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryRepository categoryRepository;
    
    @Autowired
    public CategoryServiceImpl(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return categoryRepository.getCategories().stream()
                .filter(category -> !category.hasParent())
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Category getById(final long id) {
        return categoryRepository.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Category> getMainCategories() {
        final List<Category> categories = categoryRepository.getCategories();
        categories.stream().filter(category -> !category.isMain()).forEach(Category::clearChildCategories);
        return categories.stream()
                .filter(CategoryBase::isMain)
                .filter(category -> !category.hasParent())
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Category> getSubCategories(final List<String> pathToCategory) {
        final List<Category> categories = categoryRepository.getCategories();
        
        final Iterator<String> pathIterator = pathToCategory.iterator();
        List<Category> nestedSubCategories = getNestedCategories(pathIterator, categories);
        if (nestedSubCategories == null) {
            return Collections.emptyList();
        }
        
        nestedSubCategories.forEach(Category::removeParent);
        return nestedSubCategories;
    }
    
    @Override
    @Transactional
    public void importCategory(final Category category) {
        categoryRepository.addNewCategory(category);
    }
    
    private List<Category> getNestedCategories(final Iterator<String> pathIterator, final List<Category> childrenCategories) {
        if (pathIterator.hasNext()) {
            final String categoryName = pathIterator.next();
            for (final Category category : childrenCategories) {
                if (StringUtils.isNotEmpty(categoryName) && categoryName.equalsIgnoreCase(category.getName())) {
                    final List<Category> nestedCategories = getNestedCategories(pathIterator, category.getChildren());
                    if (!pathIterator.hasNext()) {
                        return nestedCategories;
                    }
                }
            }
        } else {
            return childrenCategories;
        }
        return null;
    }
}
