package com.example.picket.repository;

import com.example.picket.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, String> {
}
