package com.example.Visit.controller;

import com.example.Visit.model.Visitor;
import com.example.Visit.repository.VisitorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000/")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:10.4.5.17"})
public class VisitorAPI {

    @Autowired
    private VisitorRepo visitorRepo;

    @GetMapping("/all/Visitor")
    public ResponseEntity<?> get(){
        try {
            List<Visitor> visitorList = visitorRepo.findAll();

            if (visitorList.isEmpty()){
                return new ResponseEntity<>("No Visitor found", HttpStatus.NOT_FOUND);
            }else {
                return  new ResponseEntity<>(visitorList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add/visitor")
    public ResponseEntity<?> addVisitor(@RequestBody Visitor visitor){
        try {
            Visitor visitor1 = visitorRepo.save(visitor);
            return new ResponseEntity<>(visitor1,HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/visitor/delete{id}")
    public ResponseEntity<?> deleteVisitor(@PathVariable Long id){
        try {
            visitorRepo.deleteById(id);
            return new ResponseEntity<>("Visitor deleted Successful",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong please try again",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/byId{id}")
    public ResponseEntity<?> getByID(@PathVariable Long id){
        try {
            Optional<Visitor> optionalVisitor = visitorRepo.findById(id);
            if (optionalVisitor.isPresent()){
                return new ResponseEntity<>(optionalVisitor,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No visitor found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("Something went wrong please try again ",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/visitor{id}")
    public ResponseEntity<?> updateVisitor(@PathVariable Long id , @RequestBody Visitor updateVisitor){
        Optional<Visitor> visitorOptional = visitorRepo.findById(id);
        if (visitorOptional.isPresent()){
            Visitor visitor = visitorOptional.get();
            visitor.setUsername(updateVisitor.getUsername());
            visitor.setEmail(updateVisitor.getEmail());
            visitor.setId(updateVisitor.getId());
            visitor.setRole(updateVisitor.getRole());
            visitor.setPhone(updateVisitor.getPhone());
            visitor.setV_purpose(updateVisitor.getV_purpose());
//            visitor.setCheckInTime(updateVisitor.getCheckInTime());
//            visitor.setCheckOutTime(updateVisitor.getCheckOutTime());
            visitorRepo.save(visitor);
            return new ResponseEntity<>(visitor,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Visitor not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count/visitors")
    public ResponseEntity<Long> countVisitors() {
        try {
            long count = visitorRepo.count();
            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(0L, HttpStatus.BAD_REQUEST);
        }
    }

}
