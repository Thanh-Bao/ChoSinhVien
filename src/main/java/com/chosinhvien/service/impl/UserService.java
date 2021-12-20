package com.chosinhvien.service.impl;

import com.chosinhvien.constant.MessageException;
import com.chosinhvien.constant.UserRole;
import com.chosinhvien.dto.UserDto;
import com.chosinhvien.entity.Role;
import com.chosinhvien.entity.User;
import com.chosinhvien.repository.UserRepo;
import com.chosinhvien.service.IRoleService;
import com.chosinhvien.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements IUserService, UserDetailsService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(
                    String.format(MessageException.USER_NOT_FOUND, email));
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream()
                .map(entity -> modelMapper.map(entity, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public User add(User user) {
        user.setId(0L);
        user.setEnabled(false);
        user.setLocked(false);
        String passwordEncoder = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoder);
        userRepo.save(user);
        addRoleToUser(user.getEmail(), UserRole.USER.name());
        User newUser = userRepo.findByEmail(user.getEmail());
        return newUser;
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        Role role = roleService.findByName(roleName);
        User user = userRepo.findByEmail(email);
        user.getRoles().add(role);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public int enableUser(String email) {
        return userRepo.updateEnable(email);
    }

}
