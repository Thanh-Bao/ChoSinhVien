package com.chosinhvien.repository;

import com.chosinhvien.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findAll();

}
