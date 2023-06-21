package com.example.rommates.repository;

import com.example.rommates.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Dodaj metody zapytań, które są potrzebne w twojej aplikacji, na przykład:
    List<User> findByCity(String city);

    // Dodaj metodę do wyszukiwania użytkownika po nazwie użytkownika (login)
    User findByLogin(String login);

    List<User> findByCityOrderByCityAsc(String city);
}


