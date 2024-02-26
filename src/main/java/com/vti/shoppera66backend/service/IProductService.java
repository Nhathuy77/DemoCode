package com.vti.shoppera66backend.service;

import com.vti.shoppera66backend.modal.dto.*;
import com.vti.shoppera66backend.modal.entity.Account;
import com.vti.shoppera66backend.modal.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Page<Product> search(SearchProductRequest request);

    Product create(ProductCreatRequestDto dto);

    Product update(ProductUpdateRequestDto dto);

    Product getById(int id);

    void delete(int id);
}
