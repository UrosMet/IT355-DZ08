package com.metropolitan.it355.services;
import com.metropolitan.it355.entity.Sport;

import java.util.List;

public interface SportService {

    List<Sport> getAll();

    Sport getSport(Integer id);

    Sport addSport(Sport sport);

    Sport editSport(Sport sport);

    void deleteSport(Integer id);


    List<Sport> findAllBySportNameEndingWith(String string);

    List<Sport> findAllBySportNameContains(String string);

    List<Sport> findAllBySportNameContainsAndSportNameNotContaining(String contains , String notContains);
}
