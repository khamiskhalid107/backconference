package com.example.Visit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data
@Entity
public class Staff extends User{
    private String staffNo;
    private String staffLocation;
    private String staffService;


    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getStaffLocation() {
        return staffLocation;
    }

    public void setStaffLocation(String staffLocation) {
        this.staffLocation = staffLocation;
    }

    public String getStaffService() {
        return staffService;
    }

    public void setStaffService(String staffService) {
        this.staffService = staffService;
    }

}
