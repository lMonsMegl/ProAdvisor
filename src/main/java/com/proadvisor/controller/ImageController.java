package com.proadvisor.controller;

import com.proadvisor.service.ImageService;
import com.proadvisor.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {
    
    @Autowired
    private ImageService imageService;
    
    @Autowired
    private ItemService itemService;
    
    @GetMapping("/images/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageId) {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageService.getById(imageId));
    }
    
    @PostMapping("/items/{itemId}/images")
    public void addImage(@PathVariable long itemId, @RequestParam MultipartFile image) throws IOException {
        String imagePath = imageService.save(image);
        itemService.addImageToItem(itemId, imagePath);
    }
    
    @PostMapping("/items/{itemId}/mainImage")
    public void addMainImage(@PathVariable long itemId, @RequestParam MultipartFile image) throws IOException {
        String imagePath = imageService.save(image);
        itemService.setMainImageToItem(itemId, imagePath);
    }
}
