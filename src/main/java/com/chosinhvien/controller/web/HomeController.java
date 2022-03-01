package com.chosinhvien.controller.web;

import com.chosinhvien.dto.ServicePackDto;
import com.chosinhvien.dto.UserDto;
import com.chosinhvien.entity.Bill;
import com.chosinhvien.entity.BillDetail;
import com.chosinhvien.entity.ServicePack;
import com.chosinhvien.model.Cart;
import com.chosinhvien.model.CartItem;

import com.chosinhvien.service.IBillDetailService;
import com.chosinhvien.service.IBillService;
import com.chosinhvien.service.IServicePackService;
import com.chosinhvien.service.IUserService;
import com.chosinhvien.util.Utils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller("HomeControllerForWeb")
@RequiredArgsConstructor
public class HomeController {

    private final IServicePackService servicePackService;
    private final IUserService userService;
    private final IBillService billService;
    private final IBillDetailService billDetailService;
    private final ModelMapper mapper;

    @GetMapping("/trang-chu")
    public String getHomePage() {
        return "web/home";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/test")
    public String getHomeTest() {
        return "web/test";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/mua-diem")
    public String getMuaDiemPage(HttpServletRequest req, Model model) {
        List<ServicePackDto> servicePacks = servicePackService.findAll()
                .stream().map(servicePack -> mapper.map(servicePack, ServicePackDto.class))
                .collect(Collectors.toList());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Cart cart = Utils.getCartInSession(req);
        cart.setUser(userService.findByEmail(auth.getName()));

        model.addAttribute("servicePacks", servicePacks);
        model.addAttribute("cart", cart);
        return "web/mua-diem";
    }

    @PostMapping("/mua-diem/add")
    public String addToCart(HttpServletRequest req, @RequestParam(value = "servicePackId") Long id,
                            @RequestParam(value = "quantity") int quantity, Model model) {
        Cart cart = Utils.getCartInSession(req);
        if (id != null) {
            ServicePack servicePack = servicePackService.findById(id);
            cart.updateItem(servicePack, quantity);
        }
        return "redirect:/mua-diem";
    }

    @PostMapping("/mua-diem/thanh-toan")
    public String createOrder(HttpServletRequest req, Model model) {
        Cart cart = Utils.getCartInSession(req);
        Bill newBill = new Bill(
                0L,
                LocalDateTime.now(),
                cart.getAmountTotal(),
                false,
                cart.getUser()
        );
        Bill bill = billService.create(newBill);
        List<BillDetail> newOrderDetails = new ArrayList<>();
        cart.getCartItems().forEach(cartItem -> {
            BillDetail newBillDetail = new BillDetail();
            newBillDetail.setId(0L);
            newBillDetail.setAmount(cartItem.getAmount());
            newBillDetail.setQuanity(cartItem.getQuantity());
            newBillDetail.setServicePack(cartItem.getServicePack());
            newBillDetail.setBill(bill);
            newOrderDetails.add(newBillDetail);
        });

        billDetailService.saveAll(newOrderDetails);
        cart.clear();
        return "web/test";
    }


}