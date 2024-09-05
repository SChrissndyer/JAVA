package org.example.day79;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * from product where price> 100.00", nativeQuery = true)
    List<Product> getAllOver100();
}
