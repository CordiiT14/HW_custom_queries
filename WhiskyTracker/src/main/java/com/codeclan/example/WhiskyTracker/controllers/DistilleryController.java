package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

//    @GetMapping(name = "/distilleries")
//    public ResponseEntity<List<Distillery>> getAllDistilleries(){
//        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
//    }
//
//    @GetMapping(name = "/distilleries/{id}")
//    public ResponseEntity getDistilleryById(@PathVariable Long id){
//        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);
//    }
//
//    @PostMapping(name = "/distilleries")
//    public ResponseEntity<Distillery> addNewDistillery(@RequestBody Distillery distillery){
//        distilleryRepository.save(distillery);
//        return new ResponseEntity<>(distillery, HttpStatus.CREATED);
//    }

}
