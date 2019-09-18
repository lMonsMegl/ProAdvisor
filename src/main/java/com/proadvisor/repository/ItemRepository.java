package com.proadvisor.repository;

import com.proadvisor.model.entity.item.Item;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private EntityManager entityManager;

    public Item getById(long itemId) {
        return entityManager.unwrap(Session.class)
                .createQuery("SELECT item FROM Item item WHERE id = :itemId", Item.class)
                .setParameter("itemId", itemId)
                .uniqueResult();
    }
}
