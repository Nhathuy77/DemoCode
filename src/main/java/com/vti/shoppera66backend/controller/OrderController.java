package com.vti.shoppera66backend.controller;

import com.vti.shoppera66backend.modal.dto.AccountCreatRequestDto;
import com.vti.shoppera66backend.modal.dto.OrderCreateRequestDto;
import com.vti.shoppera66backend.modal.entity.Account;
import com.vti.shoppera66backend.modal.entity.Order;
import com.vti.shoppera66backend.modal.entity.OrderStatus;
import com.vti.shoppera66backend.service.iml.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin("*")
@Validated
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get-by-status")
    public List<Order> findByStatus(@RequestParam OrderStatus status){
        return orderService.findByStatus(status);
    }

    @PostMapping("/create")
    public Order create(@RequestBody @Valid OrderCreateRequestDto dto){
        return orderService.create(dto);
    }

    @PostMapping("/buy/{id}")
    public Order buy(@PathVariable int id){
        return orderService.buyProduct(id);
    }

    @PostMapping("/cancel/{id}")
    public Order cancel(@PathVariable int id){
        return orderService.cancelOrder(id);
    }

}
