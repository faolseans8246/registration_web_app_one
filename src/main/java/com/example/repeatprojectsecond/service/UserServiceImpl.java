package com.example.repeatprojectsecond.service;

import com.example.repeatprojectsecond.repository.UserRepository;
import com.example.repeatprojectsecond.tables.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    @Override
    public Users getUserById(long id) {
        Optional <Users> userIds = userRepository.findById(id);
        Users users = null;

        if (userIds.isPresent()) {
            users = userIds.get();
        } else {
            throw new RuntimeException("User ID bilan muammo mavjud! -> " + userIds);
        }

        return users;
    }


    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Page<Users> frindPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

        return userRepository.findAll(pageable);
    }
}
