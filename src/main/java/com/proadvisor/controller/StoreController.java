package com.proadvisor.controller;

import com.proadvisor.model.dto.StoreDto;
import com.proadvisor.model.dto.preview.StorePreview;
import com.proadvisor.model.entity.common.City;
import com.proadvisor.model.entity.item.Category;
import com.proadvisor.model.entity.item.Store;
import com.proadvisor.service.CategoryService;
import com.proadvisor.service.ImageService;
import com.proadvisor.service.LocationService;
import com.proadvisor.service.StoreService;
import com.sun.media.sound.InvalidDataException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/items/stores")
public class StoreController {
    
    @Autowired
    private StoreService storeService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private LocationService locationService;
    
    @Autowired
    private ImageService imageService;
    
    @GetMapping
    public List<StorePreview> getAllStorePreviews(@RequestParam final long categoryId) {
        return storeService.getAllPreviews(categoryId);
    }
    
    @GetMapping("{id}")
    public Store getStoreById(@PathVariable final long id) {
        return storeService.getById(id);
    }
    
    @PostMapping
    public HttpStatus addNewStore(@Valid final StoreDto storeDto, final long categoryId, final long cityId) throws IOException {
        if (storeService.isExists(storeDto.getName())) {
            throw new InvalidDataException("Store with such name already exists");
        }
        final City city = locationService.getCityById(cityId);
        final Category category = categoryService.getById(categoryId);
        final Store store = new Store();
        
        BeanUtils.copyProperties(storeDto, store);
        
        store.setCity(city);
        store.setCategory(category);
        //TODO
        store.setMainImage(imageService.save(storeDto.getImage()));
    
        storeService.add(store);
        
        return HttpStatus.OK;
    }
}
