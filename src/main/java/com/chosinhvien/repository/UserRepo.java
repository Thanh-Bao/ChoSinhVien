package com.chosinhvien.repository;

import com.chosinhvien.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAll();

    User findByEmail(String email);


    @Transactional
    @Modifying
    @Query("UPDATE User u " +
            "SET u.enabled = TRUE WHERE u.email = ?1")
    int updateEnable(String email);
}
