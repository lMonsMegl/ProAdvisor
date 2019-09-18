package com.proadvisor.repository;

import com.proadvisor.model.entity.common.City;
import com.proadvisor.model.entity.common.Country;

import java.util.List;

public interface LocationRepository {
    
    List<City> getCities();
    
    City getCityById(long id);
    
    List<Country> getCountries();
}
