package com.proadvisor.repository;

import com.proadvisor.model.dto.preview.StorePreview;
import com.proadvisor.model.entity.item.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StoreRepositoryImpl implements StoreRepository {
    
    private static final String JPQL_GET_ALL_STORE_PREVIEWS = "SELECT NEW com.proadvisor.model.dto.preview.StorePreview" +
            "(store.id, store.name, store.description, store.rating, store.mainImage, store.commentsCount, store.itemViewingCount) FROM Store store " +
            "WHERE category_id = :categoryId";
    
    private static final String JPQL_GET_STORE_BY_NAME =
            "SELECT count(store) FROM Store store WHERE store.name = :name";
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<StorePreview> getAllPreviews(final long categoryId) {
        final Query query = entityManager.createQuery(JPQL_GET_ALL_STORE_PREVIEWS, StorePreview.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }
    
    @Override
    public Store getById(final long id) {
        return entityManager.find(Store.class, id);
    }
    
    @Override
    public void add(final Store store) {
        entityManager.persist(store);
    }
    
    @Override
    public boolean isExists(final String name) {
        return entityManager.createQuery(JPQL_GET_STORE_BY_NAME, Long.class)
                .setParameter("name", name)
                .getSingleResult() != 0;
    }
}
