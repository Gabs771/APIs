package com.ilyourd.parque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ilyourd.parque.model.Ride;
import com.ilyourd.parque.repository.RideRepository;

@Service
public class RideService {

    private final RideRepository repo;

    public RideService(RideRepository repo) {
        this.repo = repo;
    }

    // INSERT
    public Ride createRide(Ride ride) {
        return repo.save(ride);
    }

    // SELECT 1
    public List<Ride> getAllRides() {
        return repo.findAll();
    }

    // SELECT 2
    public List<Ride> getRidesByType(String type) {
        return repo.findByTypeRide(type);
    }

    // UPDATE (extra)
    public Ride updateRide(Long id, Ride ride) {
        Ride current = repo.findById(id).orElseThrow();

        current.setName(ride.getName());
        current.setCapacity(ride.getCapacity());
        current.setTypeRide(ride.getTypeRide());
        current.setHeightRqmt(ride.getHeightRqmt());
        current.setStartTime(ride.getStartTime());
        current.setEndTime(ride.getEndTime());

        return repo.save(current);
    }
}