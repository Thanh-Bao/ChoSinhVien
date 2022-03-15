package com.chosinhvien.service.impl;

import com.chosinhvien.entity.Category;
import com.chosinhvien.entity.Product;
import com.chosinhvien.repository.ProductRepo;
import com.chosinhvien.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepo productRepo;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public Page<Product> findAllByCategoryOrderByCreatedAtDesc(Category category, Pageable pageable) {
        return productRepo.findAllByCategoryOrderByCreatedAtDesc(category, pageable);
    }

    @Override
    public Page<Product> findAllByCategoryOrderByPriceDesc(Category category, Pageable pageable) {
        return productRepo.findAllByCategoryOrderByPriceDesc(category, pageable);
    }

    @Override
    public Page<Product> findAllByCategoryOrderByPriceAsc(Category category, Pageable pageable) {
        return productRepo.findAllByCategoryOrderByPriceAsc(category, pageable);
    }


    @Override
    public int getTotalItem() {
        return (int) productRepo.count();
    }

    @Override
    public int getTotalItemByCategory(Category category) {
        return productRepo.countByCategory(category);
    }


}
