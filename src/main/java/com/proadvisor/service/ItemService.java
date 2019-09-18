package com.proadvisor.service;

import com.proadvisor.model.entity.item.Item;
import com.proadvisor.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;
    
    public Item getById(long itemId) {
        return itemRepository.getById(itemId);
    }
    
    @Transactional
    public void addImageToItem(long itemId, String imageId) {
        Item item = getById(itemId);
        item.getImages().add(imageId);
    }
    
    @Transactional
    public void setMainImageToItem(long itemId, String imageId) {
        Item item = getById(itemId);
        item.setMainImage(imageId);
    }
}
