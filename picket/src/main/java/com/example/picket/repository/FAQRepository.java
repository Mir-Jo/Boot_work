package com.example.picket.repository;

import com.example.picket.entity.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FAQRepository extends JpaRepository<FAQ, String> {
}
