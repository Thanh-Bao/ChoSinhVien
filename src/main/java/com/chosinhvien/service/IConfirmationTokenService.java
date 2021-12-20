package com.chosinhvien.service;

import com.chosinhvien.entity.ConfirmationToken;

public interface IConfirmationTokenService {
    ConfirmationToken save(ConfirmationToken token);
    ConfirmationToken findByToken(String token);
    int setConfirmedAt(String token);

}
