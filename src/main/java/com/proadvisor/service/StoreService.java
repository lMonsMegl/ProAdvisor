package com.proadvisor.service;

import com.proadvisor.model.dto.preview.StorePreview;
import com.proadvisor.model.entity.item.Store;

import java.util.List;

public interface StoreService {
    
    List<StorePreview> getAllPreviews(long categoryId);
    
    Store getById(long id);
    
    void importStore(Store store);
    
    boolean isExists(String name);
    
    void add(Store store);
}
