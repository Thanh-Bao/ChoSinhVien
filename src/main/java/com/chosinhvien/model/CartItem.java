package com.chosinhvien.model;

import com.chosinhvien.entity.ServicePack;
import lombok.Data;

@Data
public class CartItem {

    private ServicePack servicePack;
    private int quantity;

    public CartItem() {
        this.quantity = 0;
    }

    public double getAmount() {
        return this.servicePack.getPrice() * this.quantity;
    }

}
