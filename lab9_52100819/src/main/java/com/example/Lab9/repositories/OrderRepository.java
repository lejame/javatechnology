package com.example.Lab9.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Lab9.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
