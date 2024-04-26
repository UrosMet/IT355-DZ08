package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.Sport;
import com.metropolitan.it355.repository.SportRepository;
import com.metropolitan.it355.services.SportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SportServiceImpl implements SportService {

    final SportRepository sportRepository;


    @Override
    public List<Sport> getAll() {
        return sportRepository.findAll();
    }

    @Override
    public Sport getSport(Integer id) {
        return sportRepository.findById(id).orElseThrow(()->new NoSuchElementException("Not found"));
    }

    @Override
    public Sport addSport(Sport sport) {
        return sportRepository.save(sport);
    }

    @Override
    public Sport editSport(Sport sport) {
        return sportRepository.save(sport);
    }

    @Override
    public void deleteSport(Integer id) {
        sportRepository.deleteById(id);
    }

    @Override
    public List<Sport> findAllBySportNameEndingWith(String string) {
        return sportRepository.findAllBySportNameEndingWith(string);
    }

    @Override
    public List<Sport> findAllBySportNameContains(String string) {
        return sportRepository.findAllBySportNameContains(string);
    }

    @Override
    public List<Sport> findAllBySportNameContainsAndSportNameNotContaining(String contains, String notContains) {
        return sportRepository.findAllBySportNameContainsAndSportNameNotContaining(contains,notContains);
    }
}
