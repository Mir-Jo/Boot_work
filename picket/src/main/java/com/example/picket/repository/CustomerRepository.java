package com.example.picket.repository;

import com.example.picket.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Override
    ArrayList<Customer> findAll();
}
