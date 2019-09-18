package com.proadvisor.repository;

import com.proadvisor.model.entity.item.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Category> getCategories() {
        return entityManager.createQuery("FROM Category").getResultList();
    }
    
    @Override
    public Category getById(final long id) {
        return entityManager.find(Category.class, id);
    }
    
    @Override
    public void addNewCategory(final Category category) {
        entityManager.persist(category);
    }
}