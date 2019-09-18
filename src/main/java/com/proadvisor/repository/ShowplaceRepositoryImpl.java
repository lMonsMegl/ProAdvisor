package com.proadvisor.repository;

import com.proadvisor.model.dto.preview.ShowplacePreview;
import com.proadvisor.model.entity.item.Showplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ShowplaceRepositoryImpl implements ShowplaceRepository {
    
    private static final String JPQL_GET_ALL_SHOWPLACE_PREVIEWS =
            "SELECT NEW com.proadvisor.model.dto.preview.ShowplacePreview" +
                    "(s.id, s.name, s.description, s.rating, s.mainImage, s.commentsCount, s.itemViewingCount) FROM Showplace s " +
                    "WHERE category_id = :categoryId";
    
    private static final String JPQL_GET_SHOWPLACE_BY_NAME =
            "SELECT count(s) FROM Showplace s WHERE s.name = :name";
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<ShowplacePreview> getAllPreviews(final long categoryId) {
        final Query query = entityManager.createQuery(JPQL_GET_ALL_SHOWPLACE_PREVIEWS, ShowplacePreview.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }
    
    @Override
    public Showplace getById(final long id) {
        return entityManager.find(Showplace.class, id);
    }
    
    @Override
    public void add(final Showplace showplace) {
        entityManager.persist(showplace);
    }
    
    @Override
    public boolean isExists(final String name) {
        return entityManager.createQuery(JPQL_GET_SHOWPLACE_BY_NAME, Long.class)
                .setParameter("name", name)
                .getSingleResult() != 0;
    }
}
