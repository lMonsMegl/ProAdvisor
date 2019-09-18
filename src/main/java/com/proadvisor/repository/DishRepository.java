package com.proadvisor.repository;

import com.proadvisor.model.dto.preview.DishPreview;
import com.proadvisor.model.entity.menu.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DishRepository {
    
    private static final String JPQL_GET_DISH_COUNT_BY_NAME =
            "SELECT count(ct) FROM Dish ct WHERE ct.name = :name";
    
    private static final String JPQL_GET_ALL_DISH_PREVIEWS =
            "SELECT NEW com.proadvisor.model.dto.DishPreview(c.id, c.name, c.description) FROM Dish c";
    
    @Autowired
    private EntityManager entityManager;

    public void addNewDish(Dish dish) {
        entityManager.persist(dish);
    }
    
    public boolean isDishWithNameExists(String name) {
        return entityManager.createQuery(JPQL_GET_DISH_COUNT_BY_NAME, Long.class)
                       .setParameter("name", name)
                       .getSingleResult() != 0;
    }
    
    public List<DishPreview> getAllPreviews() {
        return entityManager.createQuery(JPQL_GET_ALL_DISH_PREVIEWS, DishPreview.class)
                       .getResultList();
    }
    
    public Dish getById(long id) {
        return entityManager.find(Dish.class, id);
    }
}
