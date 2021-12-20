package com.chosinhvien.service.impl;

import com.chosinhvien.entity.ConfirmationToken;
import com.chosinhvien.repository.ConfirmationTokenRepo;
import com.chosinhvien.service.IConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ConfirmationTokenService implements IConfirmationTokenService {

    private final ConfirmationTokenRepo confirmationTokenRepo;

    @Override
    public ConfirmationToken save(ConfirmationToken token) {
        return confirmationTokenRepo.save(token);
    }

    @Override
    public ConfirmationToken findByToken(String token) {
        return confirmationTokenRepo.findByToken(token);
    }

    @Override
    public int setConfirmedAt(String token) {
        return confirmationTokenRepo.updateConfirmedAt(token, LocalDateTime.now());
    }
}
