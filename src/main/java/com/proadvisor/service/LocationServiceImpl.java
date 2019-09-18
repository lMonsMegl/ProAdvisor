package com.proadvisor.service;

import com.proadvisor.model.entity.common.City;
import com.proadvisor.model.entity.common.Country;
import com.proadvisor.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    
    @Autowired
    private LocationRepository locationRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<City> getCities() {
        return locationRepository.getCities();
    }
    
    @Override
    @Transactional(readOnly = true)
    public City getCityById(final long id) {
        return locationRepository.getCityById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Country> getCountries() {
        return locationRepository.getCountries();
    }
}
