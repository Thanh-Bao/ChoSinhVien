package com.chosinhvien.service.impl;

import com.chosinhvien.entity.Bill;
import com.chosinhvien.entity.User;
import com.chosinhvien.repository.BillRepo;
import com.chosinhvien.service.IBillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BillService implements IBillService {

    private final BillRepo orderRepo;

    @Override
    public Bill create(Bill bill) {
        return orderRepo.save(bill);
    }

    @Override
    public List<Bill> findByUserAndIsPay(User user, Boolean isPay) {
        return orderRepo.findByUserAndIsPay(user, isPay);
    }
}
