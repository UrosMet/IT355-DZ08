package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    //Pronaci sve gradove koje sadrze neku rec
    List<City> findAllByCityNameContainsIgnoreCase(String string);

    //Pronaci sve gradove koji se zavrsavaju sa nekim stringom
    List<City> findAllByCityNameEndingWithIgnoreCase(String string);

    List<City> findAllByCityNameStartingWith(String string);

}
