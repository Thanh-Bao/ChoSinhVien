package com.chosinhvien.service.impl;

import com.chosinhvien.entity.Role;
import com.chosinhvien.repository.RoleRepo;
import com.chosinhvien.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService implements IRoleService {

    private final RoleRepo roleRepo;

    @Override
    public Role add(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepo.findByName(name);
    }
}
