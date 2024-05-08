package com.example.Visit.controller;

import com.example.Visit.model.Location;
import com.example.Visit.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class LocationAPI {

    @Autowired
    private LocationRepo locationRepo;

    @GetMapping("all/location")
    public ResponseEntity<?> get(){
        try {
            List<Location> locationList = locationRepo.findAll();

            if (locationList.isEmpty()){
                return new ResponseEntity<>("No location found", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(locationList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add/Location")
    public ResponseEntity<?> addLocation(@RequestBody Location location){
        try {
            Location location1 = locationRepo.save(location);
            return new ResponseEntity<>(location1,HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete{L_id}")
    public ResponseEntity<?> deleteLocation(@PathVariable int L_id){
        try {
            locationRepo.deleteById(L_id);
            return new ResponseEntity<>("Location deleted successfully",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong ",HttpStatus.BAD_REQUEST);
        }
    }
}
