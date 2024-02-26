package com.vti.shoppera66backend.repository;

import com.vti.shoppera66backend.modal.entity.Order;
import com.vti.shoppera66backend.modal.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByOrderStatus(OrderStatus orderStatus);

    @Query(value = "SELECT o FROM Order o WHERE o.orderStatus = :orderStatus")
    List<Order> findAllByOrderStatusV2(@Param("orderStatus") OrderStatus orderStatus);

    @Query(value = "SELECT * FROM Order o WHERE o.orderStatus = :orderStatus", nativeQuery = true)
    List<Order> findAllByOrderStatusV3(@Param("orderStatus") OrderStatus orderStatus);
}
