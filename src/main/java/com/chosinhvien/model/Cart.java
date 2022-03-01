package com.chosinhvien.model;

import com.chosinhvien.entity.ServicePack;
import com.chosinhvien.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Cart {

    private User user;
    private List<CartItem> cartItems = new ArrayList<>();

    private CartItem findItemById(Long id) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getServicePack().getId().equals(id)) {
                return cartItem;
            }
        }
        return null;

    }

    public void updateItem(ServicePack servicePack, int quantity) {
        CartItem cartItem = findItemById(servicePack.getId());

        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setQuantity(0);
            cartItem.setServicePack(servicePack);
            this.cartItems.add(cartItem);
        }
        int newQuantity = cartItem.getQuantity() + quantity;
        if (newQuantity <= 0) {
            cartItems.remove(cartItem);
        } else {
            cartItem.setQuantity(newQuantity);
        }
    }

    public double getAmountTotal() {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getAmount();
        }
        return total;
    }

    public void clear() {
        cartItems.clear();
    }

}
