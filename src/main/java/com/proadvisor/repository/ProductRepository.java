package com.proadvisor.repository;

import com.proadvisor.model.dto.preview.ProductPreview;
import com.proadvisor.model.entity.item.Product;

import java.util.List;

public interface ProductRepository {
    
    List<ProductPreview> getAllPreviews(long categoryId);
    
    Product getById(long id);
    
    void add(Product product);
    
    boolean isExists(String name);
}
