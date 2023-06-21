package com.example.rommates.repository;

import com.example.rommates.model.ListUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListUserRepository extends JpaRepository<ListUser, Long> {
}

