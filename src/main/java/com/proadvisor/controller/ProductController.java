package com.proadvisor.controller;

import com.proadvisor.model.dto.ProductDto;
import com.proadvisor.model.dto.preview.ProductPreview;
import com.proadvisor.model.entity.item.Category;
import com.proadvisor.model.entity.item.Product;
import com.proadvisor.service.CategoryService;
import com.proadvisor.service.ImageService;
import com.proadvisor.service.ProductService;
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
@RequestMapping("/items/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ImageService imageService;
    
    @GetMapping
    public List<ProductPreview> getAllProductPreviews(@RequestParam final long categoryId) {
        return productService.getAllPreviews(categoryId);
    }
    
    @GetMapping(value = "{id}")
    public Product getProductById(@PathVariable final long id) {
        return productService.getById(id);
    }
    
    @PostMapping
    public HttpStatus addNewProduct(@Valid final ProductDto productDto, final long categoryId) throws IOException {
        if (productService.isExists(productDto.getName())) {
            throw new InvalidDataException("Product with such name already exists");
        }
        final Category category = categoryService.getById(categoryId);
        final Product product = new Product();
        
        BeanUtils.copyProperties(productDto, product);
        
        product.setCategory(category);
        //TODO
        product.setMainImage(imageService.save(productDto.getImage()));
    
        productService.add(product);
        
        return HttpStatus.OK;
    }
}
