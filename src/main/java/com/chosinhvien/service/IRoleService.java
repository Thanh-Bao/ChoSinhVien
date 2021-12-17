package com.chosinhvien.service;

import com.chosinhvien.entity.Role;

public interface IRoleService {
    Role add(Role role);
    Role findByName(String name);
}
