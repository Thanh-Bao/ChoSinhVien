package com.chosinhvien.service.impl;

import com.chosinhvien.constant.MessageException;
import com.chosinhvien.constant.UserRole;
import com.chosinhvien.entity.ConfirmationToken;
import com.chosinhvien.entity.User;
import com.chosinhvien.service.IConfirmationTokenService;
import com.chosinhvien.service.IRegistrationService;
import com.chosinhvien.service.IUserService;
import com.chosinhvien.util.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService implements IRegistrationService {

    private final IConfirmationTokenService confirmationTokenService;
    private final IUserService userService;
    private final EmailValidator emailValidator;

    @Override
    public String register(User user) {
        boolean isValidEmail = emailValidator.test(user.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException(MessageException.EMAIL_NOT_VALID);
        }
        User oldUser = userService.findByEmail(user.getEmail());
        if(oldUser != null) {
            throw new IllegalStateException(MessageException.EMAIL_EXISTS);
        }

        String token = userService.add(user);
        //TODO: Send this token;
        return "";
    }

    @Override
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.findByToken(token);
        if(confirmationToken == null){
            throw new IllegalStateException("token not found");
        }
        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

//        confirmationTokenService.setConfirmedAt(token);
//        appUserService.enableAppUser(
//                confirmationToken.getAppUser().getEmail());

        return "confirmed";
    }
}
