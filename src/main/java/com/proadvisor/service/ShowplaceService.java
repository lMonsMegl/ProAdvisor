package com.proadvisor.service;

import com.proadvisor.model.dto.preview.ShowplacePreview;
import com.proadvisor.model.entity.item.Showplace;

import java.util.List;

public interface ShowplaceService {
    
    List<ShowplacePreview> getAllPreviews(long categoryId);
    
    Showplace getById(long id);
    
    void importShowplace(Showplace showplace);
    
    boolean isExists(String name);
    
    void add(Showplace showplace);
}
