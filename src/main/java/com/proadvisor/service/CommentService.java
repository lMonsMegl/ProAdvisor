package com.proadvisor.service;

import com.proadvisor.model.entity.common.Comment;
import com.proadvisor.model.entity.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
public class CommentService {
    
    @Autowired
    private ItemService itemService;
    
    @Transactional
    public void addNewComment(long itemId, Comment comment) {
        Item item = itemService.getById(itemId);
        item.getComments().add(comment);
        item.setSummingRating(item.getSummingRating() + comment.getRating());
        item.setCommentsCount(item.getCommentsCount() + 1);
        calculateRating(item);
        comment.setItem(item);
        comment.setCreatedDateTime(ZonedDateTime.now());
    }
    
    public void calculateRating(Item item) {
        item.setRating((double) item.getSummingRating() / item.getCommentsCount());
    }
}
