package com.ilyourd.parque.model;

import java.math.BigDecimal;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ride")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ride")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private String capacity;

    @Column(name = "type_ride")
    private String typeRide;

    @Column(name = "height_rqmt")
    private BigDecimal heightRqmt;

    @Column(name = "start_tm")
    private LocalTime startTime;

    @Column(name = "end_tm")
    private LocalTime endTime;

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCapacity() { return capacity; }
    public void setCapacity(String capacity) { this.capacity = capacity; }

    public String getTypeRide() { return typeRide; }
    public void setTypeRide(String typeRide) { this.typeRide = typeRide; }

    public BigDecimal getHeightRqmt() { return heightRqmt; }
    public void setHeightRqmt(BigDecimal heightRqmt) { this.heightRqmt = heightRqmt; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
}