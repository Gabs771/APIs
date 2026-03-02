package com.ilyourd.parque.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilyourd.parque.model.Ride;
import com.ilyourd.parque.repository.RideRepository;

@RestController
@RequestMapping("/rides")
public class RideControllers {

  private final RideRepository repo;

  public RideControllers(RideRepository repo) {
    this.repo = repo;
  }

  // GET /rides
  @GetMapping
  public List<Ride> getAll() {
    return repo.findAll();
  }


  @PostMapping
  public Ride create(@RequestBody Ride ride) {
    return repo.save(ride);
  }

 
  @PutMapping("/{id}")
  public Ride update(@PathVariable Long id, @RequestBody Ride ride) {
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