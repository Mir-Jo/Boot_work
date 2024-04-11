package com.example.picket.repository;

import com.example.picket.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(String id);
    @Query(value="SELECT * FROM CUSTOMER WHERE NAME =:name", nativeQuery = true)
    List<Customer> findByName(@Param("name")String name);
    @Query(value="SELECT * FROM CUSTOMER WHERE TEL =:tel", nativeQuery = true)
    Customer findByTel(@Param("tel")String tel);
}
