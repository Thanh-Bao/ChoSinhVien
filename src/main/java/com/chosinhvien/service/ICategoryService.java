package com.chosinhvien.service;

import com.chosinhvien.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findBySlug(String slug);
}
