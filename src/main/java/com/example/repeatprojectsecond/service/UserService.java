package com.example.repeatprojectsecond.service;

import com.example.repeatprojectsecond.tables.Users;

import java.util.List;

public interface UserService {

    List<Users> getAllItems();

    public void saveUser(Users users);

}
