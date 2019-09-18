package com.proadvisor.repository;

import com.proadvisor.model.dto.preview.CateringPreview;
import com.proadvisor.model.entity.item.Catering;

import java.util.List;

public interface CateringRepository {
    
    List<CateringPreview> getAllPreviews(long categoryId);
    
    Catering getById(long id);
    
    void add(Catering catering);
    
    boolean isExists(String name);
}
