package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.NocRegion;

import java.util.List;

public interface NocRegionService {

    List<NocRegion> getAll();

    NocRegion getNocRegion(Integer id);

    NocRegion addNocRegion(NocRegion nocRegion);

    NocRegion editNocRegion(NocRegion nocRegion);

    void deleteNocRegion(Integer id);
    
    
    List<NocRegion> findAllByNocStartsWithAndNocEndingWithIgnoreCase(String start , String end);

    List<NocRegion> findAllByRegionNameStartingWith(String string);

    List<NocRegion> findAllByRegionNameContains(String string);

}
