package com.chosinhvien.service.impl;

import com.chosinhvien.entity.Category;
import com.chosinhvien.repository.CategoryRepo;
import com.chosinhvien.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findBySlug(String slug) {
        return categoryRepo.findBySlug(slug);
    }
}
