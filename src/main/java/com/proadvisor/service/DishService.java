package com.proadvisor.service;

import com.proadvisor.model.dto.preview.DishPreview;
import com.proadvisor.model.entity.menu.Dish;
import com.proadvisor.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DishService {
    
    @Autowired
    private DishRepository dishRepository;
    
    @Transactional
    public void addNewDish(Dish dish) {
        dishRepository.addNewDish(dish);
    }
    
    
    public boolean isDishWithNameExists(String name) {
        return dishRepository.isDishWithNameExists(name);
    }
    
    public Dish getById(long dishId) {
        return dishRepository.getById(dishId);
    }
    
    public List<DishPreview> getAllPreviews() {
        return dishRepository.getAllPreviews();
    }
    
}
