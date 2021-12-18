package com.chosinhvien.repository;

import com.chosinhvien.entity.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ConfirmationTokenRepo extends CrudRepository<ConfirmationToken, Long> {
    ConfirmationToken findByToken(String token);
}
