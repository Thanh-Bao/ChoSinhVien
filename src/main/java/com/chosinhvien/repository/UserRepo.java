package com.chosinhvien.repository;

import com.chosinhvien.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAll();
    User findByEmail(String email);
}
