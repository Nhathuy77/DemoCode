package com.vti.shoppera66backend.service;

import com.vti.shoppera66backend.modal.dto.OrderCreateRequestDto;
import com.vti.shoppera66backend.modal.entity.Order;
import com.vti.shoppera66backend.modal.entity.OrderStatus;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();

    List<Order> findByStatus(OrderStatus status);

    Order create(OrderCreateRequestDto dto);

    Order buyProduct(int orderId);

    Order cancelOrder(int orderId);
}
