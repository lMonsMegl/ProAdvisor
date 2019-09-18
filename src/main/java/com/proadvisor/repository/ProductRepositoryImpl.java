package com.proadvisor.repository;

import com.proadvisor.model.dto.preview.ProductPreview;
import com.proadvisor.model.entity.item.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    
    private static final String JPQL_GET_ALL_PRODUCT_PREVIEWS =
            "SELECT NEW com.proadvisor.model.dto.preview.ProductPreview" +
                    "(p.id, p.name, p.description, p.rating, p.mainImage, p.commentsCount, p.itemViewingCount) FROM Product p " +
                    "WHERE category_id = :categoryId";
    
    private static final String JPQL_GET_PRODUCT_BY_NAME =
            "SELECT count(p) FROM Product p WHERE p.name = :name";
    
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<ProductPreview> getAllPreviews(final long categoryId) {
        final Query query = entityManager.createQuery(JPQL_GET_ALL_PRODUCT_PREVIEWS, ProductPreview.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }
    
    @Override
    public Product getById(final long id) {
        return entityManager.find(Product.class, id);
    }
    
    @Override
    public void add(final Product product) {
        entityManager.persist(product);
    }
    
    @Override
    public boolean isExists(final String name) {
        return entityManager.createQuery(JPQL_GET_PRODUCT_BY_NAME, Long.class)
                .setParameter("name", name)
                .getSingleResult() != 0;
    }
}
