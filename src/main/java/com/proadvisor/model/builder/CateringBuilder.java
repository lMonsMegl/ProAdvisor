package com.proadvisor.model.builder;

import com.proadvisor.model.entity.common.Comment;
import com.proadvisor.model.entity.item.Catering;
import com.proadvisor.model.entity.item.Item;
import com.proadvisor.model.entity.menu.Menu;
import com.proadvisor.model.entity.menu.MenuChapter;
import com.proadvisor.model.entity.menu.MenuDish;
import com.proadvisor.model.entity.menu.MenuSubchapter;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class CateringBuilder<T extends Catering> extends InstitutionBuilder<T, CateringBuilder<Catering>> {
    
    private T catering;
    
    public CateringBuilder(T catering) {
        super(catering);
        this.catering = catering;
    }
    
    public MenuBuilder menu() {
        return new MenuBuilder();
    }
    
    public T build() {
        return catering;
    }
    
    public class MenuBuilder {
        
        private Menu menu = new Menu();
        
        public MenuBuilder id(long id) {
            menu.setId(id);
            return this;
        }
        
        public ChapterBuilder chapter() {
            return new ChapterBuilder();
        }
        
        public CateringBuilder done() {
            catering.setMenu(menu);
            return CateringBuilder.this;
        }
    
        public class ChapterBuilder {
        
            private MenuChapter chapter = new MenuChapter();
        
            public SubchapterBuilder subchapter() {
                return new SubchapterBuilder();
            }
            
            public ChapterBuilder id(Long id) {
                chapter.setId(id);
                return this;
            }
            
            public ChapterBuilder name(String name) {
                chapter.setName(name);
                return this;
            }
    
            public MenuBuilder done() {
                if(menu.getMenuChapters() == null) {
                  menu.setMenuChapters(new ArrayList<>());
                }
                menu.getMenuChapters().add(chapter);
                chapter.setMenu(menu);
                return MenuBuilder.this;
            }
    
            public class SubchapterBuilder {
                
                private MenuSubchapter menuSubchapter = new MenuSubchapter();
    
                public MenuDishBuilder dish() {
                    return new MenuDishBuilder(new MenuDish());
                }
                public SubchapterBuilder id(Long id) {
                    menuSubchapter.setId(id);
                    return this;
                }
    
                public SubchapterBuilder name(String name) {
                    menuSubchapter.setName(name);
                    return this;
                }
    
                public ChapterBuilder done() {
                    if(chapter.getMenuSubchapters() == null) {
                        chapter.setMenuSubchapters(new ArrayList<>());
                    }
                    chapter.getMenuSubchapters().add(menuSubchapter);
                    menuSubchapter.setMenuChapter(chapter);
                    return ChapterBuilder.this;
                }
    
                public class MenuDishBuilder extends ItemBuilder<MenuDish, MenuDishBuilder> {
                    
                    private MenuDish menuDish;
    
                    public MenuDishBuilder(MenuDish menuDish) {
                        super(menuDish);
                        this.menuDish = menuDish;
                    }
    
                    public MenuDishBuilder ingredients(String ingredients) {
                        menuDish.setIngredients(ingredients);
                        return this;
                    }
                    
                    public MenuDishBuilder weightGrams(int weightGrams) {
                        menuDish.setWeightGrams(weightGrams);
                        return this;
                    }
                    
                    public MenuDishBuilder price(BigDecimal price) {
                        menuDish.setPrice(price);
                        return this;
                    }
                    
                    public SubchapterBuilder done() {
                        if(menuSubchapter.getMenuDishes() == null) {
                            menuSubchapter.setMenuDishes(new ArrayList<>());
                        }
                        menuSubchapter.getMenuDishes().add(menuDish);
                        menuDish.setMenuSubchapter(menuSubchapter);
                        return SubchapterBuilder.this;
                    }
                    
                }
            }
    
        }
    
    }
}
