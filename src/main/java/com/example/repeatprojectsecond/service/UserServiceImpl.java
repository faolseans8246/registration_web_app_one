package com.example.repeatprojectsecond.service;

import com.example.repeatprojectsecond.repository.UserRepository;
import com.example.repeatprojectsecond.tables.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getAllItems() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(Users users) {
        this.userRepository.save(users);
    }
}
