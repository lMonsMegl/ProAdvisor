package com.proadvisor.repository;

import com.proadvisor.model.entity.menu.Menu;
import com.proadvisor.model.entity.menu.MenuChapter;
import com.proadvisor.model.entity.menu.MenuDish;
import com.proadvisor.model.entity.menu.MenuSubchapter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class MenuRepository {

    private static final String JPQL_GET_MENU_BY_CATERING_ID =
            "SELECT menu FROM Menu menu JOIN Catering c ON c.menu = menu.id WHERE c.id = :cateringId";
    private static final String JPQL_GET_MENU_CHAPTER_BY_CATERING_ID_AND_CHAPTER_NAME =
            "SELECT mc FROM MenuChapter mc JOIN Menu m ON m.id = mc.menu JOIN Catering c ON c.menu = m.id WHERE c.id = :cateringId AND mc.name = :chapterName";
    private static final String JPQL_GET_MENU_SUBCHAPTER_BY_CATERING_ID_AND_CHAPTER_NAME_AND_SUBCHAPTER_NAME =
            "SELECT msc FROM MenuSubchapter msc JOIN MenuChapter mc ON msc.menuChapter = mc.id JOIN Menu m ON m.id = mc.menu JOIN Catering c ON c.menu = m.id WHERE c.id = :cateringId AND mc.name = :chapterName AND msc.name = :subchapterName";
    private static final String JPQL_GET_MENU_DISH_BY_CATERING_ID_AND_CHAPTER_NAME_AND_SUBCHAPTER_NAME_AND_DISH_NAME =
            "SELECT md FROM MenuDish md JOIN MenuSubchapter msc ON md.subchapter = msc.id JOIN MenuChapter mc ON msb.menuChapter = mc.id JOIN Menu m ON m.id = mc.menu JOIN Catering c ON c.menu = m.id WHERE c.id = :cateringId AND mc.name = :chapterName AND msc.name = :subchapterName AND md.name = :dishName";

    @Autowired
    private EntityManager entityManager;

    public Menu getMenu(long cateringId) {
        return entityManager.unwrap(Session.class)
                .createQuery(JPQL_GET_MENU_BY_CATERING_ID, Menu.class)
                .setParameter("cateringId", cateringId)
                .uniqueResult();
    }

    public MenuChapter getChapter(long cateringId, String chapterName) {
        return entityManager.unwrap(Session.class)
                .createQuery(JPQL_GET_MENU_CHAPTER_BY_CATERING_ID_AND_CHAPTER_NAME, MenuChapter.class)
                .setParameter("cateringId", cateringId)
                .setParameter("chapterName", chapterName)
                .uniqueResult();
    }

    public MenuSubchapter getSubchapterByName(long cateringId, String chapterName, String subchapterName) {
        return entityManager.unwrap(Session.class)
                .createQuery(JPQL_GET_MENU_SUBCHAPTER_BY_CATERING_ID_AND_CHAPTER_NAME_AND_SUBCHAPTER_NAME, MenuSubchapter.class)
                .setParameter("cateringId", cateringId)
                .setParameter("chapterName", chapterName)
                .setParameter("subchapterName", subchapterName)
                .uniqueResult();
    }

    public MenuDish getMenuDishByName(long cateringId, String chapterName, String subchapterName, String dishName) {
        return entityManager.unwrap(Session.class)
                .createQuery(JPQL_GET_MENU_DISH_BY_CATERING_ID_AND_CHAPTER_NAME_AND_SUBCHAPTER_NAME_AND_DISH_NAME, MenuDish.class)
                .setParameter("cateringId", cateringId)
                .setParameter("chapterName", chapterName)
                .setParameter("subchapterName", subchapterName)
                .setParameter("dishName", dishName)
                .uniqueResult();
    }
    
    public MenuDish getMenuDishById(long menuDishId) {
        return entityManager.find(MenuDish.class, menuDishId);
    }
}
