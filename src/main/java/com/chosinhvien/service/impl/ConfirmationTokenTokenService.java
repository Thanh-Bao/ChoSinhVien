package com.chosinhvien.service.impl;

import com.chosinhvien.entity.ConfirmationToken;
import com.chosinhvien.repository.ConfirmationTokenRepo;
import com.chosinhvien.service.IConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenTokenService implements IConfirmationTokenService {

    private final ConfirmationTokenRepo confirmationTokenRepo;

    @Override
    public ConfirmationToken save(ConfirmationToken token) {
        return confirmationTokenRepo.save(token);
    }

    @Override
    public ConfirmationToken findByToken(String token) {
        return confirmationTokenRepo.findByToken(token);
    }
}
