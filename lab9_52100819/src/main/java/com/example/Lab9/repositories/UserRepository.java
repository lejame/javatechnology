package com.example.Lab9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.tdtu.lab09.models.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
}
