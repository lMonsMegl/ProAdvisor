package com.proadvisor.repository;

import com.proadvisor.model.dto.preview.StorePreview;
import com.proadvisor.model.entity.item.Store;

import java.util.List;

public interface StoreRepository {
    
    List<StorePreview> getAllPreviews(long categoryId);
    
    Store getById(long id);
    
    void add(Store store);
    
    boolean isExists(String name);
}
