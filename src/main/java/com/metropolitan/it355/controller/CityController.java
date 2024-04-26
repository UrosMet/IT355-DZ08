package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.City;
import com.metropolitan.it355.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/city")
public class CityController {

    final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAll(){
        return ResponseEntity.ok(cityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable Integer id){
        return ResponseEntity.ok(cityService.getCity(id));
    }

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city){
        return ResponseEntity.ok(cityService.addCity(city));
    }

    @PutMapping
    public ResponseEntity<City> editCity(@RequestBody City city){
        return ResponseEntity.ok(cityService.editCity(city));
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Integer id){
        cityService.deleteCity(id);
    }


}
