package com.chosinhvien.service;

import com.chosinhvien.dto.UserDto;
import com.chosinhvien.entity.User;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();
    String add(User user);
    void addRoleToUser(String email, String roleName);
    User findByEmail(String email);
}