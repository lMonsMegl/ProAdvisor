package com.proadvisor.service;

import com.proadvisor.model.dto.preview.CateringPreview;
import com.proadvisor.model.entity.common.Comment;
import com.proadvisor.model.entity.item.Catering;
import com.proadvisor.model.entity.item.Item;
import com.proadvisor.repository.CateringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CateringServiceImpl implements CateringService {
    
    @Autowired
    private CateringRepository cateringRepository;
    
    @Autowired
    private CommentService commentService;
    
    @Override
    @Transactional(readOnly = true)
    public List<CateringPreview> getAllPreviews(final long categoryId) {
        return cateringRepository.getAllPreviews(categoryId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Catering getById(final long id) {
        return cateringRepository.getById(id);
    }
    
    @Override
    @Transactional
    public void importCatering(final Catering catering) {
        //TODO
//        importComments(catering);
        cateringRepository.add(catering);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean isExists(final String name) {
        return cateringRepository.isExists(name);
    }
    
    @Override
    @Transactional
    public void add(final Catering catering) {
        cateringRepository.add(catering);
    }
    
    //TODO
    public void importComments(final Item item) {
        if (item.getComments() != null) {
            item.setSummingRating(item.getComments().stream().mapToInt(Comment::getRating).sum());
            item.setCommentsCount(item.getComments().size());
            commentService.calculateRating(item);
        } else {
            item.setCommentsCount(0);
        }
    }
}
