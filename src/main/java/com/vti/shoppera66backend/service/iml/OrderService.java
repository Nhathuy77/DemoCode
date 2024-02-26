package com.vti.shoppera66backend.service.iml;

import com.vti.shoppera66backend.config.exception.AppException;
import com.vti.shoppera66backend.config.exception.ErrorResponseEnum;
import com.vti.shoppera66backend.modal.dto.OrderCreateRequestDto;
import com.vti.shoppera66backend.modal.entity.Account;
import com.vti.shoppera66backend.modal.entity.Order;
import com.vti.shoppera66backend.modal.entity.OrderStatus;
import com.vti.shoppera66backend.modal.entity.Product;
import com.vti.shoppera66backend.repository.AccountRepository;
import com.vti.shoppera66backend.repository.OrderRepository;
import com.vti.shoppera66backend.repository.ProductRepository;
import com.vti.shoppera66backend.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByStatus(OrderStatus status) {
        return orderRepository.findAllByOrderStatusV2(status);
    }

    @Override
    public Order create(OrderCreateRequestDto dto) {
        Optional<Account> accountOptional = accountRepository.findById(dto.getAccountId());
        if (accountOptional.isEmpty()){
            throw new AppException(ErrorResponseEnum.NOT_FOUND_PRODUCT);
        }
        Optional<Product> productOptional = productRepository.findById(dto.getProductId());
        if (accountOptional.isPresent() && productOptional.isPresent()){
            Account account = accountOptional.get();
            Product product = productOptional.get();

            Order order = new Order();
            order.setAccount(account);
            order.setProduct(product);
            order.setQuantity(dto.getQuantity());
            order.setOrderStatus(OrderStatus.PENDING);
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Order buyProduct(int orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()){
            Order order = orderOptional.get();
            order.setOrderStatus(OrderStatus.DONE);
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Order cancelOrder(int orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()){
            Order order = orderOptional.get();
            order.setOrderStatus(OrderStatus.CANCEL);
            return orderRepository.save(order);
        }
        return null;
    }
}
