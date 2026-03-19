package com.ilyourd.parque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilyourd.parque.model.Ride;

public interface RideRepository extends JpaRepository<Ride, Long> {

    List<Ride> findByTypeRide(String typeRide);
    List<Ride> findByCapacity(String capacity);
    List<Ride> findByNameContainingIgnoreCase(String name);
}