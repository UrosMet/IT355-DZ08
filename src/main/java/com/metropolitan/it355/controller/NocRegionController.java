package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.NocRegion;
import com.metropolitan.it355.services.NocRegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/nocRegion")
public class NocRegionController {
    
    final NocRegionService nocRegionService;

    @GetMapping
    public ResponseEntity<List<NocRegion>> getAll(){
        return ResponseEntity.ok(nocRegionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NocRegion> getCity(@PathVariable Integer id){
        return ResponseEntity.ok(nocRegionService.getNocRegion(id));
    }

    @PostMapping
    public ResponseEntity<NocRegion> addCity(@RequestBody NocRegion nocRegion){
        return ResponseEntity.ok(nocRegionService.addNocRegion(nocRegion));
    }

    @PutMapping
    public ResponseEntity<NocRegion> editCity(@RequestBody NocRegion nocRegion){
        return ResponseEntity.ok(nocRegionService.editNocRegion(nocRegion));
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Integer id){
        nocRegionService.deleteNocRegion(id);
    }
    
    
}
