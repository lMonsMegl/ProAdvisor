package com.proadvisor.model.builder;

import com.proadvisor.model.entity.common.City;
import com.proadvisor.model.entity.item.Category;
import com.proadvisor.model.entity.item.Institution;

public class InstitutionBuilder<T extends Institution, B> extends ItemBuilder<T, B> {
    
    private T institution;
    
    public InstitutionBuilder(T institution) {
        super(institution);
        this.institution = institution;
    }
    
    public B city(City city) {
        institution.setCity(city);
        return (B) this;
    }
    
    public B url(String url) {
        institution.setUrl(url);
        return (B) this;
    }
    
    public B address(String address) {
        institution.setAddress(address);
        return (B) this;
    }
    
    public B category(Category category) {
        institution.setCategory(category);
        return (B) this;
    }
}
