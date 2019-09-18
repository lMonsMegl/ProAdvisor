package com.proadvisor.service;

import com.proadvisor.model.dto.preview.CateringPreview;
import com.proadvisor.model.entity.item.Catering;

import java.util.List;

public interface CateringService {
    
    List<CateringPreview> getAllPreviews(long categoryId);
    
    Catering getById(long id);
    
    void importCatering(Catering catering);
    
    boolean isExists(String name);
    
    void add(Catering catering);
}
