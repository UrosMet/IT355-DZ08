package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.City;
import com.metropolitan.it355.entity.Medal;
import com.metropolitan.it355.entity.NocRegion;
import com.metropolitan.it355.entity.Sport;
import com.metropolitan.it355.services.CityService;
import com.metropolitan.it355.services.MedalService;
import com.metropolitan.it355.services.NocRegionService;
import com.metropolitan.it355.services.SportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin")
public class MainController {

    final CityService cityService;
    final NocRegionService nocRegionService;
    final SportService sportService;
    final MedalService medalService;


    @GetMapping("/citiesContains")
    public ResponseEntity<List<City>> getAllCitiesContains(){
        return ResponseEntity.ok(cityService.findAllByCityNameContainsIgnoreCase("R"));
    }

    @GetMapping("/citiesEndingWith")
    public ResponseEntity<List<City>>  getAllCitiesEndingWith(){
        return ResponseEntity.ok(cityService.findAllByCityNameEndingWithIgnoreCase("A"));
    }

    @GetMapping("/citiesStartingWith")
    public ResponseEntity<List<City>> getAllCitiesStartingWith(){
        return ResponseEntity.ok(cityService.findAllByCityNameStartingWith("A"));
    }

    @GetMapping("/nocRegionStartsWithAndEndingWith")
    public ResponseEntity<List<NocRegion>> getNocRegionStartsWithAndEndingWith(){
        return ResponseEntity.ok(nocRegionService.findAllByNocStartsWithAndNocEndingWithIgnoreCase("A" , "G"));
    }

    @GetMapping("/nocRegionNameStartingWith")
    public ResponseEntity<List<NocRegion>> getNocRegionNameStartingWith(){
        return ResponseEntity.ok(nocRegionService.findAllByRegionNameStartingWith("Be"));
    }

    @GetMapping("/nocRegionNameContains")
    public ResponseEntity<List<NocRegion>> getNocRegionNameContains(){
        return ResponseEntity.ok(nocRegionService.findAllByRegionNameContains(" "));
    }

    @GetMapping("/sportEndingWith")
    public ResponseEntity<List<Sport>> getSportsEndingWith(){
        return ResponseEntity.ok(sportService.findAllBySportNameEndingWith("ing"));
    }

    @GetMapping("/sportContains")
    public ResponseEntity<List<Sport>> getSportsContains(){
        return ResponseEntity.ok(sportService.findAllBySportNameContains("ball"));
    }

    @GetMapping("/sportContainsAndNotContains")
    public ResponseEntity<List<Sport>> getSportsContainsAndNotContains(){
        return ResponseEntity.ok(sportService.findAllBySportNameContainsAndSportNameNotContaining(" " , "ball"));
    }

    @GetMapping("/medalContains")
    public ResponseEntity<List<Medal>> medalContains(){
        return ResponseEntity.ok(medalService.findAllByMedalNameContainingIgnoreCase("o"));
    }

}
