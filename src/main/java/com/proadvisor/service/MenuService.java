package com.proadvisor.service;

import com.proadvisor.model.entity.menu.Dish;
import com.proadvisor.model.entity.menu.Menu;
import com.proadvisor.model.entity.menu.MenuChapter;
import com.proadvisor.model.entity.menu.MenuDish;
import com.proadvisor.model.entity.menu.MenuSubchapter;
import com.proadvisor.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;
    
    @Autowired
    private DishService dishService;


    
    @Transactional
    public void addNewMenuChapter(long cateringId, MenuChapter menuChapter) {
        Menu menu = menuRepository.getMenu(cateringId);
        menuChapter.setMenu(menu);
        menu.getMenuChapters().add(menuChapter);
    }
    
    @Transactional
    public void addNewMenuSubchapter(long cateringId, String chapterName, MenuSubchapter menuSubchapter) {
        MenuChapter menuChapter = menuRepository.getChapter(cateringId, chapterName);
        menuChapter.getMenuSubchapters().add(menuSubchapter);
        menuSubchapter.setMenuChapter(menuChapter);

    }
    
    @Transactional
    public void addNewMenuDish(long cateringId, String chapterName, String subchapterName, MenuDish menuDish, long dishId) {
        MenuSubchapter menuSubchapter = menuRepository.getSubchapterByName(cateringId, chapterName, subchapterName);
        menuSubchapter.getMenuDishes().add(menuDish);
        menuDish.setMenuSubchapter(menuSubchapter);


        
    }
    
    public MenuDish getMenuDish(long cateringId, String chapterName, String subchapterName, String menuDishName) {
        return menuRepository.getMenuDishByName(cateringId, chapterName, subchapterName, menuDishName);
    }

    public Menu getMenuByCateringId(long cateringId) {
        return menuRepository.getMenu(cateringId);
    }
    
    public MenuDish getMenuDishById(long menuDishId) {
        return menuRepository.getMenuDishById(menuDishId);
    }
}
