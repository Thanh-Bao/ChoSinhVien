package com.chosinhvien.service;

import com.chosinhvien.entity.ServicePack;

import java.util.List;
import java.util.Optional;

public interface IServicePackService {

    List<ServicePack> findAll();

    ServicePack findById(Long id);
}
