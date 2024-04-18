package com.example.picket.repository;

import com.example.picket.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findById(String id);
    Optional<Customer> findByPass(String password);

    @Query(value="SELECT * FROM CUSTOMER WHERE NAME =:name", nativeQuery = true)
    List<Customer> findByName(@Param("name")String name);
    @Query(value="SELECT * FROM CUSTOMER WHERE TEL =:tel", nativeQuery = true)
    Customer findByTel(@Param("tel")String tel);
}