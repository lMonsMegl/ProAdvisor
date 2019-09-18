package com.proadvisor.repository;

import com.proadvisor.model.entity.common.City;
import com.proadvisor.model.entity.common.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class LocationRepositoryImpl implements LocationRepository {
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<City> getCities() {
        return entityManager.createQuery("FROM City").getResultList();
    }
    
    @Override
    public City getCityById(final long id) {
        return entityManager.find(City.class, id);
    }
    
    @Override
    public List<Country> getCountries() {
        return entityManager.createQuery("FROM Country").getResultList();
    }
}
