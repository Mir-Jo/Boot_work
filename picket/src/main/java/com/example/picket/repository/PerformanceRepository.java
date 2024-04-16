package com.example.picket.repository;

import com.example.picket.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PerformanceRepository extends JpaRepository<Performance, String> {
}
