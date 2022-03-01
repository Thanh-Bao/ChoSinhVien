package com.chosinhvien.repository;

import com.chosinhvien.entity.ServicePack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ServicePackRepo extends CrudRepository<ServicePack, Long> {

    List<ServicePack> findAll();


}
