package com.chosinhvien.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity(name = "BillDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "bill_id",
            nullable = false
    )
    private Bill Bill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "servicePack_id",
            nullable = false
    )
    private ServicePack servicePack;

    @Column(nullable = false)
    private int quanity;

    @Column(nullable = false)
    private double amount;

}
