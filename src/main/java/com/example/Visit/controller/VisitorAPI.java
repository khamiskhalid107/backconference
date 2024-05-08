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
@RequestMapping("api")
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

    @DeleteMapping("/visitor/delete{V_id}")
    public ResponseEntity<?> deleteVisitor(@PathVariable int V_id){
        try {
            visitorRepo.deleteById(V_id);
            return new ResponseEntity<>("Visitor deleted Successful",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong please try again",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/byId{V_id}")
    public ResponseEntity<?> getByID(@PathVariable int V_id){
        try {
            Optional<Visitor> optionalVisitor = visitorRepo.findById(V_id);
            if (optionalVisitor.isPresent()){
                return new ResponseEntity<>(optionalVisitor,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No visitor found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("Something went wrong please try again ",HttpStatus.BAD_REQUEST);
        }
    }
}
