package com.example.Visit.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long Id;

    @ManyToOne
    @JoinColumn(name = "S_id")
    private Service service;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
