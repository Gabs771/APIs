package com.ilyourd.parque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilyourd.parque.model.Ride;

public interface RideRepository extends JpaRepository<Ride, Long> {
}