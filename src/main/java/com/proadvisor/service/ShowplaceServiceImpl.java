package com.proadvisor.service;

import com.proadvisor.model.dto.preview.ShowplacePreview;
import com.proadvisor.model.entity.item.Showplace;
import com.proadvisor.repository.ShowplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShowplaceServiceImpl implements ShowplaceService {
    
    @Autowired
    private ShowplaceRepository showplaceRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<ShowplacePreview> getAllPreviews(final long categoryId) {
        return showplaceRepository.getAllPreviews(categoryId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Showplace getById(final long id) {
        return showplaceRepository.getById(id);
    }
    
    @Override
    @Transactional
    public void importShowplace(final Showplace showplace) {
        showplaceRepository.add(showplace);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExists(final String name) {
        return showplaceRepository.isExists(name);
    }

    @Override
    @Transactional
    public void add(final Showplace showplace) {
        showplaceRepository.add(showplace);
    }
}
