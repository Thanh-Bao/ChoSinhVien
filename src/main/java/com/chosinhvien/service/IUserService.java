package com.chosinhvien.service;

import com.chosinhvien.dto.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> findAll();

}
