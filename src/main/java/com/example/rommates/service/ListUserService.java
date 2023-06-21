package com.example.rommates.service;

import com.example.rommates.model.ListUser;
import com.example.rommates.repository.ListUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUserService {
    @Autowired
    private ListUserRepository listUserRepository;

    public List<ListUser> getAllListUsers() {
        return listUserRepository.findAll();
    }

    public ListUser getListUser(Long id) {
        return listUserRepository.findById(id).orElse(null);
    }

    public ListUser saveListUser(ListUser listUser) {
        return listUserRepository.save(listUser);
    }

    public void deleteListUser(Long id) {
        listUserRepository.deleteById(id);
    }
}