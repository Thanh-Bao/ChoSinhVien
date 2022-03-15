package com.chosinhvien.dto;

import com.chosinhvien.entity.Category;
import com.chosinhvien.entity.Image;
import com.chosinhvien.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private double price;
    private List<Image> images = new ArrayList<>();
    private String description;
    private LocalDateTime createdAt;
    private Category category;
    private User user;

}
