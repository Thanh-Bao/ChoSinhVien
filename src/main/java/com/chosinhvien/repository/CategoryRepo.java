package com.chosinhvien.repository;

import com.chosinhvien.entity.Category;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;
import java.util.List;

public interface CategoryRepo extends CrudRepository<Category, Id> {

    List<Category> findAll();

    Category findBySlug(String slug);
}
