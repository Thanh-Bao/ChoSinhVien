package com.chosinhvien.util;

import com.chosinhvien.model.Cart;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    public static Cart getCartInSession(HttpServletRequest req) {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        return cart;
    }

    public static void removeCartInSession(HttpServletRequest req) {
        req.getSession().removeAttribute("cart");
    }

}
