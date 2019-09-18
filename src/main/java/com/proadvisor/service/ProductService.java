package com.proadvisor.service;

import com.proadvisor.model.dto.preview.ProductPreview;
import com.proadvisor.model.entity.item.Product;

import java.util.List;

public interface ProductService {
    
    List<ProductPreview> getAllPreviews(long categoryId);
    
    Product getById(long id);
    
    void importProduct(Product product);
    
    void add(Product product);
    
    boolean isExists(String name);
}
