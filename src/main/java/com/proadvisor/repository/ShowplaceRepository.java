package com.proadvisor.repository;

import com.proadvisor.model.dto.preview.ShowplacePreview;
import com.proadvisor.model.entity.item.Showplace;

import java.util.List;

public interface ShowplaceRepository {
    
    List<ShowplacePreview> getAllPreviews(long categoryId);
    
    Showplace getById(long id);
    
    void add(Showplace showplace);
    
    boolean isExists(String name);
}
