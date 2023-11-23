package com.example.Lab9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Lab9.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
