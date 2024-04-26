package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SportRepository extends JpaRepository<Sport , Integer> {

    List<Sport> findAllBySportNameEndingWith(String string);

    List<Sport> findAllBySportNameContains(String string);

    List<Sport> findAllBySportNameContainsAndSportNameNotContaining(String contains , String notContains);
}
