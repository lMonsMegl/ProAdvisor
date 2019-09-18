package com.proadvisor.controller;

import com.proadvisor.model.dto.DishDto;
import com.proadvisor.model.dto.preview.DishPreview;
import com.proadvisor.model.entity.menu.Dish;
import com.proadvisor.service.DishService;
import com.proadvisor.service.ImageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/items/dishes")
public class DishController {
    
    @Autowired
    private DishService dishService;
    
    @Autowired
    private ImageService imageService;
    
    @PostMapping
    public String addNewDish(@Valid DishDto dishDto) throws IOException {
        if (dishService.isDishWithNameExists(dishDto.getName())) {
            return "Catering with such name already exists";
        }
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDto, dish);
        
        dishService.addNewDish(dish);
        
        dish.setMainImage(imageService.save(dishDto.getImage()));
        
        return "";
    }
    
    @GetMapping
    public List<DishPreview> getAllDishPreviews() {
        return dishService.getAllPreviews();
    }
    
    @GetMapping("{id}")
    public Dish getDishById(@PathVariable long id) {
        return dishService.getById(id);
    }
}
