//package com.example.Visit.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//public class AccessLog {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private int Access_id;
//
//    @ManyToOne
//    @JoinColumn(name = "L_id")
//    private Location location;
//
//    public int getAccess_id() {
//        return Access_id;
//    }
//
//    public void setAccess_id(int access_id) {
//        Access_id = access_id;
//    }
//
//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }
//}
