package com.example.Visit.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VisitorLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "L_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "V_id")
    private Visitor visitor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
