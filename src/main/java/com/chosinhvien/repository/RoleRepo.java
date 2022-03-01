package com.chosinhvien.repository;

import com.chosinhvien.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface  RoleRepo extends CrudRepository<Role, Long> {
    Role findByName(String name);

}
