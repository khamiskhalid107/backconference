//package com.example.Visit.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//public class VisitorService {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
////    @ManyToOne
////    @JoinColumn(name = "V_id")
////    private Visitor visitor;
//
//    @ManyToOne
//    @JoinColumn(name = "S_id")
//    private Service service;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
////    public Visitor getVisitor() {
////        return visitor;
////    }
////
////    public void setVisitor(Visitor visitor) {
////        this.visitor = visitor;
////    }
//
//    public Service getService() {
//        return service;
//    }
//
//    public void setService(Service service) {
//        this.service = service;
//    }
//}
