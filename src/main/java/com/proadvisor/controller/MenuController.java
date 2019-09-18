package com.proadvisor.controller;

import com.proadvisor.model.dto.MenuDishDto;
import com.proadvisor.model.entity.menu.Menu;
import com.proadvisor.model.entity.menu.MenuChapter;
import com.proadvisor.model.entity.menu.MenuDish;
import com.proadvisor.model.entity.menu.MenuSubchapter;
import com.proadvisor.service.CateringService;
import com.proadvisor.service.ImageService;
import com.proadvisor.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/items/caterings/{cateringId}/menu")
public class MenuController {
    
    @Autowired
    private CateringService cateringService;
    
    @Autowired
    private ImageService imageService;
    
    @Autowired
    private MenuService menuService;
    
    @GetMapping
    public Menu getMenu(@PathVariable long cateringId) {
        return menuService.getMenuByCateringId(cateringId);
    }
    
    @PostMapping("chapter")
    public void addNewMenuChapter(@PathVariable long cateringId,
                                  @RequestParam String name) {
        MenuChapter menuChapter = new MenuChapter();
        menuChapter.setName(name);
        menuService.addNewMenuChapter(cateringId, menuChapter);
    }
    
    @PostMapping("chapter/{chapterName}/subchapter")
    public void addNewMenuChapter(@PathVariable long cateringId,
                                  @PathVariable String chapterName,
                                  @RequestParam String name) {
        MenuSubchapter menuSubchapter = new MenuSubchapter();
        menuSubchapter.setName(name);
        menuService.addNewMenuSubchapter(cateringId, chapterName, menuSubchapter);
    }
    
    @PostMapping("chapter/{chapterName}/subchapter/{subchapterName}/dish")
    @Transactional
    public void addNewMenuDish(@PathVariable long cateringId,
                               @PathVariable String chapterName,
                               @PathVariable String subchapterName,
                               @Valid MenuDishDto menuDishDto) throws IOException {
        MenuDish menuDish = new MenuDish();
        BeanUtils.copyProperties(menuDishDto, menuDish);
        menuService.addNewMenuDish(cateringId, chapterName, subchapterName, menuDish, menuDishDto.getDishId());
        menuDish.setMainImage(imageService.save(menuDishDto.getImage()));
        
    }
    
    @GetMapping("chapter/{chapterName}/subchapter/{subchapterName}/dish/{dishName}")
    public MenuDish getMenuDish(@PathVariable long cateringId,
                                @PathVariable String chapterName,
                                @PathVariable String subchapterName,
                                @PathVariable String dishName) {
        return menuService.getMenuDish(cateringId, chapterName, subchapterName, dishName);
    }
    
    @GetMapping("/items/menuDishes/{menuDishId}")
    public MenuDish getMenuDishById(@PathVariable long menuDishId) {
        return menuService.getMenuDishById(menuDishId);
    }
    
}
