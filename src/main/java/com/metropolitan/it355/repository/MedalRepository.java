package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Medal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedalRepository extends JpaRepository<Medal , Integer> {
    List<Medal> findAllByMedalNameContainingIgnoreCase(String string);
}
