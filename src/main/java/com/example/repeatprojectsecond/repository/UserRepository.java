package com.example.repeatprojectsecond.repository;

import com.example.repeatprojectsecond.tables.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Long>, CrudRepository<Users, Long> {
}
