package com.chosinhvien.service;

import com.chosinhvien.entity.Category;
import com.chosinhvien.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByCategoryOrderByCreatedAtDesc(Category category, Pageable pageable);

    Page<Product> findAllByCategoryOrderByPriceDesc(Category category, Pageable pageable);

    Page<Product> findAllByCategoryOrderByPriceAsc(Category category, Pageable pageable);

    int getTotalItem();

    int getTotalItemByCategory(Category category);
}
