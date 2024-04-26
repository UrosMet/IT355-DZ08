package com.metropolitan.it355.services;


import com.metropolitan.it355.entity.City;

import java.util.List;

public interface CityService {

    List<City> getAll();

    City getCity(Integer id);

    City addCity(City city);

    City editCity(City city);

    void deleteCity(Integer id);


    List<City> findAllByCityNameContainsIgnoreCase(String string);

    List<City> findAllByCityNameEndingWithIgnoreCase(String string);

    List<City> findAllByCityNameStartingWith(String string);


}
