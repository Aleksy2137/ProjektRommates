package com.example.rommates.service;

import com.example.rommates.model.User;
import com.example.rommates.model.UserList;
import com.example.rommates.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    @Autowired
    private ListRepository listRepository;

    public List<UserList> findByUserId(Long userId) {
        return listRepository.findByUserId(userId);
    }

    public void addList(int userId) {
        UserList list = new UserList();
        // list.setUserId(userId);
        listRepository.save(list);
    }

    public void addUserToSpecificList(Long listId, User user) {
        UserList userList = listRepository.findById(listId).orElse(null);
        if (userList != null) {
            List<User> users = userList.getUsers();
            users.add(user);
            userList.setUsers(users);
            listRepository.save(userList);
        }
    }
}
