package com.proadvisor.service;

import com.proadvisor.model.dto.preview.StorePreview;
import com.proadvisor.model.entity.item.Store;
import com.proadvisor.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    
    @Autowired
    private StoreRepository shopRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<StorePreview> getAllPreviews(final long categoryId) {
        return shopRepository.getAllPreviews(categoryId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Store getById(final long id) {
        return shopRepository.getById(id);
    }
    
    @Override
    @Transactional
    public void importStore(final Store store) {
        shopRepository.add(store);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean isExists(final String name) {
        return shopRepository.isExists(name);
    }
    
    @Override
    @Transactional
    public void add(final Store store) {
        shopRepository.add(store);
    }
}
