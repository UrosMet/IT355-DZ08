package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Medal;

import java.util.List;

public interface MedalService {

    List<Medal> getAll();

    Medal getMedal(Integer id);

    Medal addMedal(Medal Medal);

    Medal editMedal(Medal Medal);

    void deleteMedal(Integer id);
    
    
    List<Medal> findAllByMedalNameContainingIgnoreCase(String string);
}
