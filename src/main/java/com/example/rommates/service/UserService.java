package com.example.rommates.service;

import com.example.rommates.model.User;
import com.example.rommates.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void save(User user) {
        System.out.println("Saving user to database: " + user.getLogin()); // log
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> findByCity(String city) {
        return userRepository.findByCityOrderByCityAsc(city);
        // Implementacja metody findByCity
        // ...
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // Wyszukaj użytkownika w bazie danych za pomocą nazwy użytkownika
        User user = userRepository.findByLogin(name);

        // Jeśli użytkownik nie zostanie znaleziony, zgłoś wyjątek UsernameNotFoundException
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Zwróć obiekt, który implementuje interfejs UserDetails
        // Możesz użyć wbudowanej klasy org.springframework.security.core.userdetails.User
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), new ArrayList<>());
    }
}