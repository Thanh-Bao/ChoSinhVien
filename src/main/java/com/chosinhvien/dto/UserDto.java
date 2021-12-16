package com.chosinhvien.dto;

import com.chosinhvien.entity.RoleEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private List<RoleEntity> roles = new ArrayList<>();
    private String name;
    private String phone;
    private String address;

}
