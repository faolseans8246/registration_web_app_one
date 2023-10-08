package com.example.repeatprojectsecond.service;

import com.example.repeatprojectsecond.tables.Users;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    List<Users> getAllItems();

    public void saveUser(Users users);

    public Users getUserById(long id);

    public void deleteUserById(long id);

    public Page<Users> frindPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
