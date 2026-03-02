package com.ilyourd.parque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilyourd.parque.model.Park;

public interface ParkRepository extends JpaRepository<Park, Long> {
}