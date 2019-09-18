package com.proadvisor.service;

import com.proadvisor.model.entity.common.City;
import com.proadvisor.model.entity.common.Country;

import java.util.List;

public interface LocationService {
    
    List<City> getCities();
    
    City getCityById(long id);
    
    List<Country> getCountries();
}
