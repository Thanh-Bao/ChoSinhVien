package com.chosinhvien.service.impl;

import com.chosinhvien.entity.BillDetail;
import com.chosinhvien.repository.BillDetailRepo;
import com.chosinhvien.service.IBillDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BillDetailService implements IBillDetailService {

    private final BillDetailRepo orderDetailRepo;

    @Override
    public Iterable<BillDetail> saveAll(List<BillDetail> billDetails) {
        return orderDetailRepo.saveAll(billDetails);
    }
}
