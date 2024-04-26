package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.NocRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NocRegionRepository extends JpaRepository <NocRegion , Integer> {

    List<NocRegion> findAllByNocStartsWithAndNocEndingWithIgnoreCase(String start , String end);

    List<NocRegion> findAllByRegionNameStartingWith(String string);

    List<NocRegion> findAllByRegionNameContains(String string);
}
