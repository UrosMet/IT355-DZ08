package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.City;
import com.metropolitan.it355.repository.CityRepository;
import com.metropolitan.it355.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CityServicesImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getCity(Integer id) {
        return cityRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not Found"));
    }

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City editCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }


    @Override
    public List<City> findAllByCityNameContainsIgnoreCase(String string){
        return cityRepository.findAllByCityNameContainsIgnoreCase(string);
    }

    @Override
    public List<City> findAllByCityNameEndingWithIgnoreCase(String string) {
        return cityRepository.findAllByCityNameEndingWithIgnoreCase(string);
    }

    @Override
    public List<City> findAllByCityNameStartingWith(String string) {
        return cityRepository.findAllByCityNameStartingWith(string);
    }


}
