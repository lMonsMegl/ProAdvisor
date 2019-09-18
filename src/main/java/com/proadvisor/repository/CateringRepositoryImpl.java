package com.proadvisor.repository;

import com.proadvisor.model.dto.preview.CateringPreview;
import com.proadvisor.model.entity.item.Catering;
import com.proadvisor.model.entity.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CateringRepositoryImpl implements CateringRepository {
    
    private static final String JPQL_GET_ALL_CATERING_PREVIEWS =
            "SELECT NEW com.proadvisor.model.dto.preview.CateringPreview" +
                    "(c.id, c.name, c.description, c.rating, c.mainImage, c.commentsCount, c.itemViewingCount) FROM Catering c " +
                    "WHERE category_id = :categoryId";
    
    private static final String JPQL_GET_CATERING_COUNT_BY_NAME =
            "SELECT count(c) FROM Catering c WHERE c.name = :name";
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<CateringPreview> getAllPreviews(final long categoryId) {
        final Query query = entityManager.createQuery(JPQL_GET_ALL_CATERING_PREVIEWS, CateringPreview.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }
    
    @Override
    public Catering getById(final long id) {
        return entityManager.find(Catering.class, id);
    }
    
    @Override
    public void add(final Catering catering) {
        entityManager.persist(catering);
    }
    
    @Override
    public boolean isExists(final String name) {
        return entityManager.createQuery(JPQL_GET_CATERING_COUNT_BY_NAME, Long.class)
                .setParameter("name", name)
                .getSingleResult() != 0;
    }
    
    //TODO
    private static final String JPQL_GET_MENU_BY_CATERING_ID =
            "SELECT menu FROM Menu menu JOIN Catering ct ON ct.menu = menu.id WHERE ct.id = :cateringId";
    
    //TODO
    public Menu getMenuByCateringId(long cateringId) {
        return entityManager.createQuery(JPQL_GET_MENU_BY_CATERING_ID, Menu.class)
                .setParameter("cateringId", cateringId)
                .getSingleResult();
        
    }
}
