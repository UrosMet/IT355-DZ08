package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Sport;
import com.metropolitan.it355.services.SportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sport")
public class SportController {

    final SportService sportService;

    @GetMapping
    public ResponseEntity<List<Sport>> getAll(){
        return ResponseEntity.ok(sportService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sport> getCity(@PathVariable Integer id){
        return ResponseEntity.ok(sportService.getSport(id));
    }

    @PostMapping
    public ResponseEntity<Sport> addCity(@RequestBody Sport sport){
        return ResponseEntity.ok(sportService.addSport(sport));
    }

    @PutMapping
    public ResponseEntity<Sport> editCity(@RequestBody Sport sport){
        return ResponseEntity.ok(sportService.editSport(sport));
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Integer id){
        sportService.deleteSport(id);
    }
}
