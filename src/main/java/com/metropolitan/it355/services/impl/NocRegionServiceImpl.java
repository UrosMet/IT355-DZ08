package com.metropolitan.it355.services.impl;


import com.metropolitan.it355.entity.NocRegion;
import com.metropolitan.it355.repository.NocRegionRepository;
import com.metropolitan.it355.services.NocRegionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class NocRegionServiceImpl implements NocRegionService {

    final NocRegionRepository nocRegionRepository;


    @Override
    public List<NocRegion> getAll() {
        return  nocRegionRepository.findAll();
    }

    @Override
    public NocRegion getNocRegion(Integer id) {
        return nocRegionRepository.findById(id).orElseThrow(()->new NoSuchElementException("Not found"));
    }

    @Override
    public NocRegion addNocRegion(NocRegion nocRegion) {
        return nocRegionRepository.save(nocRegion);
    }

    @Override
    public NocRegion editNocRegion(NocRegion nocRegion) {
        return nocRegionRepository.save(nocRegion);
    }

    @Override
    public void deleteNocRegion(Integer id) {
        nocRegionRepository.deleteById(id);
    }

    @Override
    public List<NocRegion> findAllByNocStartsWithAndNocEndingWithIgnoreCase(String start, String end) {
        return nocRegionRepository.findAllByNocStartsWithAndNocEndingWithIgnoreCase(start,end);
    }

    @Override
    public List<NocRegion> findAllByRegionNameStartingWith(String string) {
        return nocRegionRepository.findAllByRegionNameStartingWith(string);
    }

    @Override
    public List<NocRegion> findAllByRegionNameContains(String string) {
        return nocRegionRepository.findAllByRegionNameContains(string);
    }
}
