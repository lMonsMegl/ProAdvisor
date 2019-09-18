package com.proadvisor.service;

import com.proadvisor.model.dto.preview.ProductPreview;
import com.proadvisor.model.entity.item.Product;
import com.proadvisor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<ProductPreview> getAllPreviews(final long categoryId) {
        return productRepository.getAllPreviews(categoryId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Product getById(final long id) {
        return productRepository.getById(id);
    }
    
    @Override
    @Transactional
    public void importProduct(final Product product) {
        productRepository.add(product);
    }
    
    @Override
    @Transactional
    public void add(final Product product) {
        productRepository.add(product);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean isExists(final String name) {
        return productRepository.isExists(name);
    }
}
