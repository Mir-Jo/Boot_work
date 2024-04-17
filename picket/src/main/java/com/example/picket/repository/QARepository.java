package com.example.picket.repository;

import com.example.picket.entity.Customer;
import com.example.picket.entity.QA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface QARepository extends JpaRepository<QA, String> {
    @Override
    ArrayList<QA> findAll();
}
