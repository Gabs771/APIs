package com.ilyourd.parque.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.ilyourd.parque.model.Ride;
import com.ilyourd.parque.service.RideService;

@RestController
@RequestMapping("/rides")
public class RideControllers {

    private final RideService service;

    public RideControllers(RideService service) {
        this.service = service;
    }

    // SELECT 1: GET /rides
    @GetMapping
    public List<Ride> getAll() {
        return service.getAllRides();
    }

    // SELECT 2: GET /rides/type/{type}
    @GetMapping("/type/{type}")
    public List<Ride> getByType(@PathVariable String type) {
        return service.getRidesByType(type);
    }

    // INSERT: POST /rides
    @PostMapping
    public Ride create(@RequestBody Ride ride) {
        return service.createRide(ride);
    }

    // UPDATE: PUT /rides/{id}  (extra, no estorba)
    @PutMapping("/{id}")
    public Ride update(@PathVariable Long id, @RequestBody Ride ride) {
        return service.updateRide(id, ride);
    }
}