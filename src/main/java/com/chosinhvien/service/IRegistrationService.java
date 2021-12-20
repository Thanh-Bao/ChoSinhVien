package com.chosinhvien.service;

import com.chosinhvien.entity.User;

public interface IRegistrationService {
    User register(User user);
    String confirmToken(String token);
}
