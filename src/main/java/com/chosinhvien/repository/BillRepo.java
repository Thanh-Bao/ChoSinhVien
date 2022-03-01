package com.chosinhvien.repository;

import com.chosinhvien.entity.Bill;
import com.chosinhvien.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillRepo extends CrudRepository<Bill, Long> {
    List<Bill> findByUserAndIsPay(User user, Boolean isPay);
}
