package com.proadvisor.controller;

import com.proadvisor.model.entity.common.City;
import com.proadvisor.model.entity.common.Country;
import com.proadvisor.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    
    @Autowired
    private LocationService locationService;
    
    @GetMapping("/cities")
    public List<City> getCities() {
        return locationService.getCities();
    }
    
    @GetMapping("/countries")
    public List<Country> getCountries() {
        return locationService.getCountries();
    }
}
