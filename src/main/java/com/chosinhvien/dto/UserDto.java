package com.chosinhvien.dto;

import com.chosinhvien.entity.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private List<Role> roles = new ArrayList<>();
    private String name;
    private String phone;
    private String address;
    private Boolean locked;
    private Boolean enabled;

}
