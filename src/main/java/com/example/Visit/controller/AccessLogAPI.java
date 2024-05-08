package com.example.Visit.controller;

import com.example.Visit.model.AccessLog;
import com.example.Visit.repository.AccessLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class AccessLogAPI {

    @Autowired
    private AccessLogRepo accessLogRepo;

    @GetMapping("/all/Access")

    public ResponseEntity<?> get(){
        try {
            List<AccessLog> accessLogList = accessLogRepo.findAll();

            if (accessLogList.isEmpty()){
                return new ResponseEntity<>("No access found", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(accessLogList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAccessLog(@RequestBody AccessLog accessLog){
        try {
            AccessLog accessLog1 = accessLogRepo.save(accessLog);
            return new ResponseEntity<>(accessLog1,HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }
}
