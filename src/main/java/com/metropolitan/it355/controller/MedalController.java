package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Medal;
import com.metropolitan.it355.services.MedalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/medal")
public class MedalController {
    
    final MedalService medalService;

    @GetMapping
    public ResponseEntity<List<Medal>> getAll(){
        return ResponseEntity.ok(medalService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medal> getMedal(@PathVariable Integer id){
        return ResponseEntity.ok(medalService.getMedal(id));
    }

    @PostMapping
    public ResponseEntity<Medal> addMedal(@RequestBody Medal medal){
        return ResponseEntity.ok(medalService.addMedal(medal));
    }

    @PutMapping
    public ResponseEntity<Medal> editMedal(@RequestBody Medal medal){
        return ResponseEntity.ok(medalService.editMedal(medal));
    }

    @DeleteMapping("/{id}")
    public void deleteMedal(@PathVariable Integer id){
        medalService.deleteMedal(id);
    }
    
}
