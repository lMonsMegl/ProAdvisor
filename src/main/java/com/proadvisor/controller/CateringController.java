package com.proadvisor.controller;

import com.proadvisor.model.dto.CateringDto;
import com.proadvisor.model.dto.preview.CateringPreview;
import com.proadvisor.model.entity.common.City;
import com.proadvisor.model.entity.item.Category;
import com.proadvisor.model.entity.item.Catering;
import com.proadvisor.service.CategoryService;
import com.proadvisor.service.CateringService;
import com.proadvisor.service.ImageService;
import com.proadvisor.service.LocationService;
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
@RequestMapping("/items/caterings")
public class CateringController {
    
    @Autowired
    private CateringService cateringService;
    
    @Autowired
    private LocationService locationService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ImageService imageService;
    
    @GetMapping
    public List<CateringPreview> getAllCateringPreviews(@RequestParam final long categoryId) {
        return cateringService.getAllPreviews(categoryId);
    }
    
    @GetMapping("{id}")
    public Catering getCateringById(@PathVariable final long id) {
        return cateringService.getById(id);
    }
    
    @PostMapping
    public HttpStatus addNewCatering(@Valid final CateringDto cateringDto, final long cityId, final long categoryId) throws IOException {
        if (cateringService.isExists(cateringDto.getName())) {
            throw new InvalidDataException("Catering with such name already exists");
        }
        final City city = locationService.getCityById(cityId);
        final Category category = categoryService.getById(categoryId);
        final Catering catering = new Catering();
        
        BeanUtils.copyProperties(cateringDto, catering);
        
        catering.setCategory(category);
        catering.setCity(city);
        //TODO
        catering.setMainImage(imageService.save(cateringDto.getImage()));
    
        cateringService.add(catering);
        
        return HttpStatus.OK;
    }
}
