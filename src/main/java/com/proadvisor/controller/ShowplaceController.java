package com.proadvisor.controller;

import com.proadvisor.model.dto.ShowplaceDto;
import com.proadvisor.model.dto.preview.ShowplacePreview;
import com.proadvisor.model.entity.common.City;
import com.proadvisor.model.entity.item.Category;
import com.proadvisor.model.entity.item.Showplace;
import com.proadvisor.service.CategoryService;
import com.proadvisor.service.ImageService;
import com.proadvisor.service.LocationService;
import com.proadvisor.service.ShowplaceService;
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
@RequestMapping("/items/showplaces")
public class ShowplaceController {
    
    @Autowired
    private ShowplaceService showplaceService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private LocationService locationService;
    
    @Autowired
    private ImageService imageService;
    
    @GetMapping
    public List<ShowplacePreview> getAllShowplacePreviews(@RequestParam final long categoryId) {
        return showplaceService.getAllPreviews(categoryId);
    }
    
    @GetMapping("{id}")
    public Showplace getShowplaceById(@PathVariable final long id) {
        return showplaceService.getById(id);
    }
    
    @PostMapping
    public HttpStatus addNewShowplace(@Valid final ShowplaceDto showplaceDto, final long categoryId, final long cityId) throws IOException {
        if (showplaceService.isExists(showplaceDto.getName())) {
            throw new InvalidDataException("Showplace with such name already exists");
        }
        final City city = locationService.getCityById(cityId);
        final Category category = categoryService.getById(categoryId);
        final Showplace showplace = new Showplace();
        
        BeanUtils.copyProperties(showplaceDto, showplace);
        
        showplace.setCity(city);
        showplace.setCategory(category);
        //TODO
        showplace.setMainImage(imageService.save(showplaceDto.getImage()));
    
        showplaceService.add(showplace);
        
        return HttpStatus.OK;
    }
}
