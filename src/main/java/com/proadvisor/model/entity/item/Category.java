package com.proadvisor.model.entity.item;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends CategoryBase {
    
    @Override
    public List<Category> getChildren() {
        if (super.getChildren() == null) {
            synchronized (this) {
                super.setChildren(new ArrayList<>());
            }
        }
        return super.getChildren();
    }
    
    public boolean hasChildren() {
        return !CollectionUtils.isEmpty(super.getChildren());
    }
    
    @Override
    public void setChildren(final List<Category> children) {
        getChildren().addAll(children);
        
        children.forEach(childCategory -> childCategory.setParent(this));
    }
    
    public void clearChildCategories() {
        if (hasChildren()) {
            super.getChildren().clear();
        }
    }
    
    public boolean hasParent() {
        return super.getParent() != null;
    }
    
    @Override
    public void setParent(final Category parentCategory) {
        super.setParent(parentCategory);
        
        if (parentCategory != null && !parentCategory.getChildren().contains(this)) {
            parentCategory.getChildren().add(this);
        }
    }
    
    public void removeParent() {
        this.setParent(null);
    }
}
