package com.chosinhvien.service.impl;

import com.chosinhvien.dto.UserDto;
import com.chosinhvien.repository.UserRepo;
import com.chosinhvien.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements IUserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream()
                .map(entity -> modelMapper.map(entity, UserDto.class)).collect(Collectors.toList());
    }

}
