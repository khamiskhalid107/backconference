package com.example.Visit.controller;

import com.example.Visit.model.Service;
import com.example.Visit.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ServiceAPI {

    @Autowired
    private ServiceRepo serviceRepo;

    @GetMapping("/all/Service")
    public ResponseEntity<?> get(){
        try {

            List<Service> serviceList = serviceRepo.findAll();
            if (serviceList.isEmpty()){
                return new ResponseEntity<>("No Service found", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(serviceList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add/service")
    public ResponseEntity<?> addService(@RequestBody Service service){
        try {
            Service service1 = serviceRepo.save(service);
            return new ResponseEntity<>(service1,HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("Something went wrrong",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/service{S_id}")
        public ResponseEntity<?> deleteLocation(@PathVariable int S_id){
        try {
            serviceRepo.deleteById(S_id);
            return new ResponseEntity<>("Service deleted successfully",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong please try again",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/service/byid{S_id}")
    public ResponseEntity<?> getByID(@PathVariable int S_id){
        try {
            Optional<Service> optionalService = serviceRepo.findById(S_id);
            if (optionalService.isPresent()){
                return new ResponseEntity<>(optionalService,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No Service found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong please try again",HttpStatus.BAD_REQUEST);
        }
    }
}

