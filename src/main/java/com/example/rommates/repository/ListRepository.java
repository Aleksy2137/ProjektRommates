package com.example.rommates.repository;

import com.example.rommates.model.UserList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListRepository extends JpaRepository<UserList, Long> {
    List<UserList> findByUserId(Long userId);
// Dodaj metody zapytań, które są potrzebne w twojej aplikacji
}
