package com.proadvisor.service;

import com.proadvisor.model.entity.item.Category;
import com.proadvisor.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {
    
    private CategoryService categoryService;
    
    private CategoryRepository categoryRepository;
    
    @BeforeEach
    public void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        
        categoryService = new CategoryServiceImpl(categoryRepository);
    }
    
    @Test
    public void testGetMainCategories() {
        when(categoryRepository.getCategories()).thenReturn(getTestData());
        
        final List<Category> categories = categoryService.getMainCategories();
        
        assertEquals(1, categories.size());
        assertFalse(categories
                .iterator().next().getChildren()
                .iterator().next().getChildren()
                .iterator().next().hasChildren()
        );
        assertEquals(0, categories
                .iterator().next().getChildren()
                .iterator().next().getChildren()
                .iterator().next().getChildren()
                .size()
        );
    }
    
    @Test
    public void testGetSubCategories() {
        when(categoryRepository.getCategories()).thenReturn(getTestData());
        
        final List<Category> subCategories = categoryService.getSubCategories(Arrays.asList("categoryMain1", "categoryMain11"));
        
        assertEquals(2, subCategories.size());
        assertEquals("category111", subCategories.get(0).getName());
        assertNull(subCategories.get(0).getParent());
        assertEquals("category112", subCategories.get(1).getName());
        assertNull(subCategories.get(1).getParent());
        
        final List<Category> badPathSubCategories = categoryService.getSubCategories(Arrays.asList("badCategoryName1"));
        
        assertNull(badPathSubCategories);
    }
    
    private List<Category> getTestData() {
        
        final Category categoryMain1 = new Category() {{
            setName("categoryMain1");
            setMain(true);
            setParent(null);
        }};
        
        final Category category2 = new Category() {{
            setName("category2");
            setMain(false);
            setParent(null);
        }};
        
        final Category categoryMain11 = new Category() {{
            setName("categoryMain11");
            setMain(true);
            setParent(categoryMain1);
        }};
        
        final Category categoryMain12 = new Category() {{
            setName("categoryMain12");
            setMain(true);
            setParent(categoryMain1);
        }};
        
        final Category category111 = new Category() {{
            setName("category111");
            setMain(false);
            setParent(categoryMain11);
        }};
        
        final Category category112 = new Category() {{
            setName("category112");
            setMain(false);
            setParent(categoryMain11);
        }};
        
        final Category category1111 = new Category() {{
            setName("category1111");
            setMain(false);
            setParent(category111);
        }};
        
        return Arrays.asList(categoryMain1, category2, categoryMain11, categoryMain12, category111, category112, category1111);
    }
}
