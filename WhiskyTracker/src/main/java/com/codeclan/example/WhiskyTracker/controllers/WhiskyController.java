package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(name = "/whiskys")
    public ResponseEntity<List<Whisky>> findWhiskys(@RequestParam(name="filter", required = false) Integer number, String search){
        if (number == null && search == null) {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        } if (number != null && search == null) {
            return new ResponseEntity<>(whiskyRepository.findAllByYear(number), HttpStatus.OK);
        }
        return new ResponseEntity<List<Whisky>>(whiskyRepository.findByDistilleryNameAndAge(search, number), HttpStatus.OK);
    }

//    @GetMapping(name = "/whiskys/{id}")
//    public ResponseEntity getWhisky(@PathVariable Long id){
//        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
//    }

    @PostMapping(name = "/whiskys")
    public ResponseEntity<Whisky> addNewWhisky(@RequestBody Whisky whisky){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }

}
